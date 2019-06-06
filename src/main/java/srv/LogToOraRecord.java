/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package srv;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.*;

import com.arshiner.common.JDBCUtil;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Ddlsjsjb;
import com.arshiner.service.DdlsjsjbService;

/**
 * 查询主键 select table_name,column_name from all_cons_columns where
 * owner='ADMIN_TEST' and table_name='FRM_LOG' 为了让整个封装过程更清晰定义此类
 * 过程1：站点的capture日志数据通过SiteSCNObj的getSiteFileList进行排序
 * 过程2：通过LogToOraRecord的getNextOraRecord获取下一个事务（含遍历器等）
 * 过程3：将获取的事务（SCN元素）装载到LogRecord对象 过程4：将LogRecord对象装载到OraRecord对象
 * 过程5：给其他程序调用生成xml 输出OraRecord对象，以便通过sax写xml文件 调用方法：
 * 首先创建LogToOraRecord对象，通过构造函数对站点数、当前断点及日志池路径进行设置 循环调用getNextOraRecord即可
 *
 * @author William 2018-11-20
 */
public class LogToOraRecord {

	int isitecnt = 0; // rac站点
	public static String curscn = ""; // 当前的scn断点
	static OraRecord orarec = new OraRecord();
	static LogRecord logdata = new LogRecord();
	private String curfile = ""; // 当前日志文件
	ArrayList<SiteSCNObj> sitescnobj = new ArrayList<>();
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public DmlCache updateDmlCache = new DmlCache(); // 临时存放上一次的update dml
	public DdlsjsjbService ddlsjsjbService;
	public Dbconpro db;
	JDBCUtil jdbc;
	List<Dbrzcjcs> dbrzcjcslist = new ArrayList<>();
	// bm tbname 主建列 colname
	List<String> pklist;
	ArrayList<String> actlist;
	// Jdbc stmt = new Jdbc();

	// 在构造函数中创建与站点数相同的scn迭代器
	public void LogToOraRecord(int sitecnt, String scn, String logpool) {
		// 每个站点的最新scn对象SiteSCNObj
		for (int i = 0; i < sitecnt; i++) {
			sitescnobj.add(i, new SiteSCNObj(i, scn, logpool));
		}
		isitecnt = sitecnt;
		curscn = scn; // 设置断点
	}

	// 设置scn断点
	public boolean setCurrentSCN(String scn) {
		if ("".equals(scn)) {
			return false;
		}
		curscn = scn; // 设置断点
		return true;
	}

	// 获取当前curscn
	public String getCurrentSCN() {
		return curscn;
	}

	// 获取当前日志文件
	public boolean setCurrentLogfile(String sfile) {
		if ("".equals(sfile)) {
			return false;
		}
		this.curfile = sfile; // 设置断点
		return true;
	}

	// 获取当前文件
	public String getCurrentLogfile() {
		return this.curfile;
	}

	// 返回orarec对象
	public OraRecord getOraRecord() {
		return orarec;
	}

	// 从多个站点中获取最小的scn对象，输出到logdata中，以事务为单位
	public boolean getNextOraRecord() {
		String scnmin = "0xffff.ffffffff";
		String scnloop = "";
		int imin = 0;
		for (int i = 0; i < isitecnt; i++) {
			// 获取站点当前scn
			scnloop = sitescnobj.get(i).getSiteSCN();
			while (curscn.compareTo(scnloop) >= 0) {
				// 小于断点则取下一个事务对象
				sitescnobj.get(i).getSiteNextElement();
				// 若scnloop为空，则没有下一个了，无需关注遍历器为null
				scnloop = sitescnobj.get(i).getSiteSCN();
				// 如果站点数大于1个，且有站点获取不到scn，则直接返回false，无需继续排序了
				if ("".equals(scnloop)) {
					if (1 < isitecnt) {
						System.out.println("Site[" + i + "] rac waiting for new record...");
					} else {
						System.out.println("Site[" + i + "] waiting for new record...");
					}
					return true;
				}
			}
			// 获取各个站点中scn最小的一个
			if (scnmin.compareTo(scnloop) > 0) {
				scnmin = scnloop;
				imin = i;
			}
		}
		// 循环未退出，则表明在每个站点中，都找到了大于curscn的事务，scnmin即为最小的事务号，imin为站点号
		Element curlst;
		Element curdml;
		// 重置事务
		logdata.resetOraTrans();
		logdata.resetOraDML();
		logdata.scn = sitescnobj.get(imin).getSiteElement().elementText("ID");
		logdata.type = sitescnobj.get(imin).getSiteElement().elementText("type"); // 操作类型ddl
		logdata.tx = sitescnobj.get(imin).getSiteElement().elementText("tx");
		logdata.session = sitescnobj.get(imin).getSiteElement().elementText("Session"); // 日志中获取Session
		logdata.time = sitescnobj.get(imin).getSiteElement().elementText("time");
		if (!"".equals(logdata.type)) {
			if (sitescnobj.get(imin).getSiteElement().elementIterator("list").hasNext()) {
				if (null == logdata.tx) {
					logdata.tx = logdata.scn; // tx为空的
				}
				curlst = (Element) sitescnobj.get(imin).getSiteElement().elementIterator("list").next();
				// 获取dml or ddl
				for (Iterator i = curlst.elementIterator("record"); i.hasNext();) { // 多记录
					curdml = (Element) i.next();
					logdata.getNextLogRecord(curdml, logdata);
					setOraRecord(logdata, orarec);
				}
				//
				if (!"".equals(updateDmlCache.schema)) {
					// 用户不同，或者操作不同，或者不是同一个记录的操作，都生成插入操作
					// if ((!logdata.schema.equals(updateDmlCache.schema)) ||
					// (!"2".equals(logdata.act))
					// || (!logdata.rowid.equals(updateDmlCache.rowid))) {
					orarec.insertCount++;
					orarec.addDMLObj(updateDmlCache.schema, updateDmlCache.tab, logdata.getDMLType(updateDmlCache.act),
							updateDmlCache.session, updateDmlCache.wherevalue, updateDmlCache.newvalue,
							updateDmlCache.oldvalue);
					orarec.translist.add(orarec.translist.get(orarec.translist.size() - 1));
					// }
					// 如果还是针对这个表的同一记录做操作，则此insert无需记录
					updateDmlCache.resetDmlCache();
				}
			}
			// 设置新的scn断点
			setCurrentSCN(sitescnobj.get(imin).getSiteElement().elementText("ID"));
			setCurrentLogfile(sitescnobj.get(imin).getSiteFile());
		} else {
			System.out.println("unknow type");
		}
		return true;
	}

	/**
	 * 根据LogSeparator中保存的一个完整DDL或者DML输出到对象OraRecord
	 * 读取list中的每个记录，组装到OraRecord的ddllist 当事务不存在的时候，在OraRecord中新增事务信息translist
	 * 当事务存在的时候，不新增事务信息translist
	 */
	public boolean setOraRecord(LogRecord dtrecord, OraRecord oraobj) {
		// OraRecord对象每次会传入一个dml，并且包含事务信息，方便随意对大事务进行切割封装
		// 在写xml对象时，可根据translist中的最后一个事务id，来判断新传入的dml是否属于同一个事务
		// 若属于同一事务，则新增dml即可，否则新增事务对象再新增dml
		// String sessionid, String serial, String ora_user, String ora_client,
		// String ora_time, String ora_program
		if (!"".equals(updateDmlCache.schema)) {
			// 用户不同，或者操作不同，或者不是同一个记录的操作，都生成插入操作
			if ((!dtrecord.schema.equals(updateDmlCache.schema)) || (!"2".equals(dtrecord.act))
					|| (!dtrecord.rowid.equals(updateDmlCache.rowid))) {
				oraobj.insertCount++;
				oraobj.addDMLObj(updateDmlCache.schema, updateDmlCache.tab, dtrecord.getDMLType(updateDmlCache.act),
						updateDmlCache.session, updateDmlCache.wherevalue, updateDmlCache.newvalue,
						updateDmlCache.oldvalue);
				oraobj.translist.add(oraobj.translist.get(oraobj.translist.size() - 1));
			}
			// 如果还是针对这个表的同一记录做操作，则此insert无需记录
			updateDmlCache.resetDmlCache();
		}
		if (checkIsNeed(dtrecord.tab, dtrecord.getDMLType(dtrecord.act))
				|| dtrecord.getDMLType(dtrecord.act).equals("ddl")) {
			if (0 == oraobj.translist.size()) {
				if (dtrecord.session == null || dtrecord.session.equals("")) {
					oraobj.addTransObj(dtrecord.tx, dtrecord.type, "", "", dtrecord.schema, "", dtrecord.time, "");
				} else {
					if (dtrecord.session == null || dtrecord.session.equals("")) {
						oraobj.addTransObj(dtrecord.tx, dtrecord.type, "", "", dtrecord.schema, "", dtrecord.time, "");
					} else {
						oraobj.addTransObj(dtrecord.tx, dtrecord.type,
								String.valueOf(Integer.valueOf(dtrecord.session.substring(0, 4), 16)),
								String.valueOf(Integer.valueOf(dtrecord.session.substring(4, 8), 16)), dtrecord.schema,
								"", dtrecord.time, "");
					}
					// 起始scn和tid
				}
				oraobj.startSCN = dtrecord.scn;
				oraobj.startTrans = dtrecord.tx;
			} else if (!dtrecord.tx.equals(oraobj.translist.get(oraobj.translist.size() - 1).tx)) {
				if (dtrecord.session == null || dtrecord.session.equals("")) {
					oraobj.addTransObj(dtrecord.tx, dtrecord.type, "", "", dtrecord.schema, "", dtrecord.time, "");
				} else {
					oraobj.addTransObj(dtrecord.tx, dtrecord.type,
							String.valueOf(Integer.valueOf(dtrecord.session.substring(0, 4), 16)),
							String.valueOf(Integer.valueOf(dtrecord.session.substring(4, 8), 16)), dtrecord.schema, "",
							dtrecord.time, "");
				}
				// 结束scn和tid
				oraobj.stopSCN = dtrecord.scn;
				oraobj.stopTrans = dtrecord.tx;
			}
			HashMap<String, String> old_value = new HashMap<>();
			HashMap<String, String> where_value = new HashMap<>();
			HashMap<String, String> new_value = new HashMap<>();
			// updateDmlCache不为空才需要进来判断
			if (dtrecord.getDMLType(dtrecord.act).equals("insert")) {
				if (checkIsPriKey(dtrecord.tab, dtrecord.data)) {
					dtrecord.setHashValue(dtrecord.data, new_value);
					where_value = setHashValue(dtrecord.tab, dtrecord.data);
				} else {
					dtrecord.setHashValue(dtrecord.data, where_value);
					dtrecord.setHashValue(dtrecord.data, new_value);
				}
				oraobj.insertCount++;
			} else if (dtrecord.getDMLType(dtrecord.act).equals("update")) {
				// 如果update操作更新了主键列，则将该操作分解为先删除再插入
				if (checkIsPriKey(dtrecord.tab, dtrecord.data)) {
					// 先执行删除
					dtrecord.act = "1"; // delete
					dtrecord.setHashValue(dtrecord.where, where_value);
					if (checkIsPriKey(dtrecord.tab, dtrecord.where)) {
						where_value = setHashValue(dtrecord.tab, dtrecord.where);
					}
					oraobj.deleteCount++;
					oraobj.addDMLObj(dtrecord.schema, dtrecord.tab, dtrecord.getDMLType(dtrecord.act), dtrecord.session,
							where_value, new_value, old_value);
					// 再执行insert
					dtrecord.act = "0"; // insert
					// 此处用update的where值来代替插入的值，存在的问题是主键列的值是老的，需要用data的值更
					dtrecord.setHashValue(dtrecord.where, new_value);
					if (checkIsPriKey(dtrecord.tab, dtrecord.where)) {
						where_value = setHashValue(dtrecord.tab, dtrecord.where);
					}
					// 将主键新值替换旧
					replaceOldValue(dtrecord.data, new_value);
					// 为了满足需求2，n个update时，n-1个delete， 一个insert
					updateDmlCache = updateDmlCache.setDmlCache(dtrecord.schema, dtrecord.tab, dtrecord.act,
							dtrecord.session, dtrecord.rowid, where_value, new_value, old_value);

					// oraobj.insertCount++;
					// oraobj.addDMLObj(dtrecord.schema, dtrecord.tab,
					// dtrecord.getDMLType(dtrecord.act), dtrecord.session,
					// where_value, new_value, old_value);
					// 一起调用下面的替代where方法
					return true;
				} else {
					dtrecord.setUpdateValue(dtrecord.data, dtrecord.where, old_value, new_value, where_value);
					if (checkIsPriKey(dtrecord.tab, dtrecord.where)) {
						where_value = setHashValue(dtrecord.tab, dtrecord.where);
					}
					oraobj.updateCount++;
				}
			} else if (dtrecord.getDMLType(dtrecord.act).equals("delete")) {
				if (checkIsPriKey(dtrecord.tab, dtrecord.where)) {
					dtrecord.setHashValue(dtrecord.where, where_value);
					where_value = setHashValue(dtrecord.tab, dtrecord.where);
				} else {
					dtrecord.setHashValue(dtrecord.where, where_value);
				}
				oraobj.deleteCount++;
			} else if (dtrecord.getDMLType(dtrecord.act).equals("ddl")) {
				// 主键列更新
				setPklist();
				dtrecord.setDDLValue(dtrecord.data, new_value);
				jdbc.getConnection();
				Ddlsjsjb ddl = new Ddlsjsjb();
				ddl.setJgxtlb(db.getJgxtlb());
				ddl.setScn(new BigDecimal(Long.parseLong(dtrecord.scn.substring(2).replace(".", ""), 16)));
				ddl.setSeq(Long.parseLong(dtrecord.tx.substring(2).replace(".", ""), 16));
				ddl.setOrauser(dtrecord.schema);
				ddl.setOraschema(dtrecord.schema);
				ddl.setDxm(dtrecord.tab);
				try {
					String data = Decode.decode(dtrecord.data);
					ddl.setCzlx(dtrecord.getDDLCZLX(data));
					ddl.setDxlx(dtrecord.getDDLDXLX(data));
					if (data.getBytes().length > 1024) {
						byte[] strb = data.getBytes();
						byte[] strn = new byte[1024];
						for (int i = 0; i < strn.length; i++) {
							strn[i] = strb[i];
						}
						ddl.setNr(new String(strn));
					} else {
						ddl.setNr(data);
					}
					String sql = "select to_char(scn_to_timestamp(" + ddl.getScn()
							+ "),'yyyy-mm-dd hh24:mi:ss') scn from dual";
					Map<String, Object> scn = null;
					scn = jdbc.executeQuery(sql, null).get(0);
					ddl.setCzsj(new Timestamp(format.parse(scn.get("scn").toString()).getTime()));
					List<Ddlsjsjb> ddllist = new ArrayList<>();
					ddllist.add(ddl);
					TestRestSafeOutAccess roas = new TestRestSafeOutAccess();
					roas.buildDDLDataJson(JsonToObject.ListconsvertToJSON(ddllist));
					ddlsjsjbService.insertSelective(ddl);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					jdbc.closeDB();
				}
			}
			if (!dtrecord.type.equals("2")) {
				oraobj.addDMLObj(dtrecord.schema, dtrecord.tab, dtrecord.getDMLType(dtrecord.act), dtrecord.session,
						where_value, new_value, old_value);
			}
		} else {
			System.out.println("过滤------- " + dtrecord.tab + "  操作：" + dtrecord.getDMLType(dtrecord.act));
		}
		return true;
	}

	public Dbconpro getDb() {
		return db;
	}

	public void setDb(Dbconpro db) {
		this.db = db;
		setPklist();
	}

	public void setPklist() {
		jdbc = new JDBCUtil(db.getUsername(), db.getPassword(), db.getIp(), db.getPort(), db.getServicename());
		jdbc.getConnection();
		// 获取表名
		String bm = "";
		actlist = new ArrayList<>();
		for (int i = 0; i < dbrzcjcslist.size(); i++) {
			// 表名
			if (i == 0) {
				bm = "'" + dbrzcjcslist.get(i).getBm() + "'";
			} else {
				bm = "'" + dbrzcjcslist.get(i).getBm() + "'" + "," + bm;
			}
			if (dbrzcjcslist.get(i).getZlinsert().equals("1")) {
				actlist.add(new String(dbrzcjcslist.get(i).getBm() + ".insert").toLowerCase());
			}
			if (dbrzcjcslist.get(i).getZldelete().equals("1")) {
				actlist.add(new String(dbrzcjcslist.get(i).getBm() + ".delete").toLowerCase());
			}
			if (dbrzcjcslist.get(i).getZlupdate().equals("1")) {
				actlist.add(new String(dbrzcjcslist.get(i).getBm() + ".update").toLowerCase());
			}
		}
		String sql = "select distinct Cu.TABLE_NAME,Cu.COLUMN_NAME from all_cons_columns cu,all_constraints au "
				+ "where cu.CONSTRAINT_NAME=au.CONSTRAINT_NAME and au.CONSTRAINT_type='P' " + " AND cu.OWNER='"
				+ db.getSchema().toUpperCase() + "'" + " and au.TABLE_NAME in(" + bm.toUpperCase() + ")";
		try {
			pklist = jdbc.executeQuery1(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbc.closeDB();
	}

	// insert where_value 如果没有主键 就是全部字段 如果有主键就是主键字段
	public HashMap<String, String> setHashValue(String stab, String old) {
		// 校验传入数据
		String sin = old;
		if (!sin.contains("=")) {
			return new HashMap<>();
		}
		HashMap<String, String> newmap = new HashMap<>();
		String scol = "";
		String svalue = "";
		String[] strarray1;
		String[] strarray = sin.split(",");
		for (int i = 0; i < strarray.length; i++) {
			strarray1 = strarray[i].split("=");
			scol = strarray1[0].replace("\"", "");
			if (2 == strarray1.length) {
				svalue = strarray1[1];
				// indexOf查询pklist集合中 是否有此项
				if (-1 < pklist.indexOf((stab + "." + scol).toLowerCase())) {
					newmap.put(scol, svalue); // 去掉列的引号
				}
			}
		}
		return newmap;
	}

	public List<Dbrzcjcs> getDbrzcjcslist() {
		return dbrzcjcslist;
	}

	public void setDbrzcjcslist(List<Dbrzcjcs> dbrzcjcslist) {
		this.dbrzcjcslist = dbrzcjcslist;
	}

	public List<String> getPklist() {
		return pklist;
	}

	public void setPklist(List<String> pklist) {
		this.pklist = pklist;
	}

	// 根据 表名字和 列的数据（col1=data1；col2=...）,到pklist中查找，若找到了，则需要拆分update操作，否则做正常流程
	public boolean checkIsPriKey(String stab, String sdata) {
		String scol = "";
		String[] strarray1;
		String[] strarray = sdata.split(",");
		for (int i = 0; i < strarray.length; i++) {
			strarray1 = strarray[i].split("=");
			if (2 == strarray1.length) {
				scol = strarray1[0].replace("\"", "");
				if (-1 < pklist.indexOf((stab + "." + scol).toLowerCase())) {
					// 找到主键了，记录主键
					return true;

				}
			}
		}
		return false;
	}

	// 根据传进来的新老where用data根据num做出=后面的替换
	public String replacewhere(String data, String where) {
		ArrayList<String[]> strlist = new ArrayList<>();
		String[] strarraywhere = where.split(","); // where构建一维
		String[] strarraydata = data.split(",");// 都是num1=xx,num2=xx
		String newWhere = "";
		for (int i = 0; i < strarraywhere.length; i++) {
			String[] strarray1where = strarraywhere[i].split("=");
			for (int j = 0; j < strarraydata.length; j++) {
				String[] strarray1data = strarraydata[j].split("=");
				if (strarray1where[0].equals(strarray1data[0])) {
					String s = strarray1data[1];
					strarray1where[1] = s;
				}
			}
			strlist.add(strarray1where);
		}
		for (int i = 0; i < strlist.size(); i++) {
			String[] str = strlist.get(i);
			if (i == 0) {
				newWhere = str[0] + "=" + str[1];
			} else {
				newWhere = newWhere + "," + str[0] + "=" + str[1];
			}
		}
		strlist = null;
		return newWhere;
	}

	// 根据表名字和操作类型（insert，update，delete）,到actlist中查找，若找到了，则需拼装
	public boolean checkIsNeed(String stab, String sact) {
		if (-1 < actlist.indexOf((stab + "." + sact).toLowerCase())) {
			return true;
		}
		return false;
	}

	// 拆分snew字符串，更新hash表中对应的列值（根据key来更新value）
	public void replaceOldValue(String snew, HashMap<String, String> oldvalue) {
		String scol = "";
		String[] strarray1;
		String[] strarray = snew.split(",");
		for (int i = 0; i < strarray.length; i++) {
			strarray1 = strarray[i].split("=");
			if (2 == strarray1.length) {
				scol = strarray1[0].replace("\"", "");
				oldvalue.replace(scol, strarray1[1]);
			}
		}
	}

	public DdlsjsjbService getDdlsjsjbService() {
		return ddlsjsjbService;
	}

	public void setDdlsjsjbService(DdlsjsjbService ddlsjsjbService) {
		this.ddlsjsjbService = ddlsjsjbService;
	}

}
