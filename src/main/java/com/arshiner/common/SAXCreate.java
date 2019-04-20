package com.arshiner.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.arshiner.model.Asession;
import com.arshiner.model.Clsjclzt;
import com.arshiner.model.Clsjkddb;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Dbconpro;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Zlsjddb;
import com.arshiner.model.Zlsjwjb;
import com.arshiner.service.AsessionService;
import com.arshiner.service.ClsjclztService;
import com.arshiner.service.ClsjkddbService;
import com.arshiner.service.ClsjwjbService;
import com.arshiner.service.DbconProService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.ZlsjddbService;
import com.arshiner.service.ZlsjwjbService;

import srv.Decode;
import srv.LogToOraRecord;
import srv.OraDMLObject;
import srv.OraRecord;
import srv.OraTransObject;

/**
 * 必须要关闭document才能够查看文件长度 sax就不能进行判断file.length com.arshiner.quartz.model
 * 为true是存量，，为false是增量
 * 
 * 内部引入存量数据断点表，和增量数据断点表，存量数据状态表 存量文件表，增量文件表
 * 
 * @author 士林
 *
 */
@Component
public class SAXCreate {

	private ClsjwjbService clsjwjbService;
	private ClsjclztService clsjclztService;
	private ClsjkddbService clsjkddbService;
	private DbrzcjcsService dbrzcjcsService;
	private static final Logger logger = Logger.getLogger(SAXCreate.class);
	private Dbconpro dbConpro;
	private DbconProService dbconProService;
	private Integer rownum = 1;
	private Clsjwjb clsjwj;
	private Clsjkddb clsjkdd;
	private XMLFileName xmlfilename = XMLFileName.getInstance();
	private final SAXTransformerFactory tff = (SAXTransformerFactory) SAXTransformerFactory.newInstance();// 1.创建一个TransformerFactory类的对象
	private String sjk = ""; // 当前数据块文件名
	private TransformerHandler handler;// 创建sax解析的处理类
	private Transformer tr;//
	private AttributesImpl attr;// 属性接口
	private boolean documentStatus = false;// 文档状态
	private File f = null;// 写入的文件
	private FileOutputStream fis;
	private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat d = new SimpleDateFormat("yyyyMMddHHmmss");
	private SimpleDateFormat t = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	private TreeMap<String, Object> tree;
	private int filecount = 0;
	private int wjq = 0;
	private int sjl = 0;
	private String wjsjcq = "";
	private String sjcz = "";
	private ZlsjwjbService zlsjwjbService;
	private ZlsjddbService zlsjddbService;
	private AsessionService asessionService;
	LinkedHashMap<String, Clsjclzt> ztmap = new LinkedHashMap<>();
	LinkedHashMap<String, Dbrzcjcs> dbmap = new LinkedHashMap<>();
	public int wjzdz = 0;
	Clsjclzt clzt = new Clsjclzt();
	Dbrzcjcs dbrzcs = new Dbrzcjcs();

	public TreeMap<String, Object> getTree() {
		return tree;
	}

	public int getFilecount() {
		return filecount;
	}

	public void setFilecount(int filecount) {
		this.filecount = filecount;
	}

	public void setTree(TreeMap<String, Object> tree) {
		this.tree = tree;
	}

	public Clsjwjb getClsjwj() {
		return clsjwj;
	}

	public void setClsjwj(Clsjwjb clsjwj) {
		this.clsjwj = clsjwj;
	}

	public Clsjkddb getClsjkdd() {
		return clsjkdd;
	}

	public void setClsjkdd(Clsjkddb clsjkdd) {
		this.clsjkdd = clsjkdd;
	}

	/**
	 * 
	 * @param url
	 * @param com.arshiner.quartz.model
	 */
	public void createXMLHead(String url, boolean model) {
		try {
			handler = tff.newTransformerHandler();
			tr = handler.getTransformer();

			tr.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

			tr.setOutputProperty(OutputKeys.INDENT, "yes");
			// 5.创建一个Result对象
			f = new File(url);
			if (!f.exists()) {
				f.createNewFile();
			}
			fis = new FileOutputStream(f, false);
			Result result = new StreamResult(fis);
			handler.setResult(result);
			handler.startDocument();
			documentStatus = true;
			attr = new AttributesImpl();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 置空f，tr,fis,handler,documentStatus=fasle,attr, 文件名后退1
	 * 
	 * @throws IOException
	 */
	public void reset() throws IOException {
		tr = null;
		fis.close();
		fis = null;
		logger.info("SAX删除文件" + f.delete());
		f = null;
		handler = null;
		documentStatus = false;
		attr = null;
		dbConpro.setZlnum(new BigDecimal(XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1));
		dbconProService.updAimsData(dbConpro);
		XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1);
	}

	/**
	 * 根据model不同 root子节点不同 真，则是存量 ,否 ,则是增量
	 * 
	 * @param rootchild
	 * @param com.arshiner.quartz.model
	 * @param sessionid
	 * @param serial
	 * @throws SAXException
	 */
	public void createXMLTitle(TreeMap<String, Object> rootchild, boolean model) throws SAXException {
		if (documentStatus == true) {
			attr.clear();
			handler.startElement("", "", "root", attr);
			String key = "";
			String value = "";
			for (Entry<String, Object> entry : rootchild.entrySet()) {
				key = entry.getKey().toString();
				value = "";
				if (key.equals("ora_table")) {
					value = entry.getValue().toString().toUpperCase();
				} else {
					value = entry.getValue().toString();
				}
				attr.clear();
				handler.startElement("", "", key, attr);
				handler.characters(value.toCharArray(), 0, value.length());
				handler.endElement("", "", key);
			}
			handler.startElement("", "", "tab_datalist", attr);
		}
	}

	/**
	 * 增量head
	 * 
	 * @param oraLogObject
	 */
	public void createZLHead() {
		// oraLogObejct 对象 type xtlb
		try {
			attr.clear();
			handler.startElement("", "", "root", attr);
			handler.startElement("", "", "ora_azdm", attr);
			handler.characters(dbConpro.getAzdm().toCharArray(), 0, dbConpro.getAzdm().length());
			handler.endElement("", "", "ora_azdm");
			handler.startElement("", "", "ora_type", attr);
			handler.characters("new".toCharArray(), 0, "new".length());
			handler.endElement("", "", "ora_type");
			handler.startElement("", "", "ora_xtlb", attr);
			handler.characters(dbConpro.getJgxtlb().toCharArray(), 0, dbConpro.getJgxtlb().length());
			handler.endElement("", "", "ora_xtlb");
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 增量文件是否截取
	int dmlnum = 0;
	int trannum = 0;
	boolean zlflag = false;

	/**
	 * 增量,,,这里增量的部分有可能性能不好，，需要修改，dml对象可再次封装一层将索引填进去
	 * 
	 * @throws ParseException
	 */
	public String yestday(String t2) throws ParseException {
		Date time = t.parse(t2);
		Date t1 = new Date(time.getTime() - (84600000L * 30));
		return t.format(t1);
	}

	int indmlnum = 0;

	public boolean createXMLTransactionList(LogToOraRecord log2orarec, int wjzdz, OraRecord oraLogObject) {
		try {
			ArrayList<OraTransObject> translist = oraLogObject.translist;
			ArrayList<OraDMLObject> dmllist = oraLogObject.dmllist;
			String value = "";
			if (translist.isEmpty()) {
				return false;
			}
			if (trannum >= translist.size()) {
				return false;
			}
			OraTransObject oraTransInfo = translist.get(trannum);
			if (oraTransInfo.type.equals("2")) {
				Zlsjddb zlsjddb = new Zlsjddb();
				zlsjddb.setJgxtlb(dbConpro.getJgxtlb());
				zlsjddb.setSlh("1");
				zlsjddb.setScn(new BigDecimal(HexToTen(log2orarec.getCurrentSCN())));
				zlsjddbService.saveOrupdate(zlsjddb);
				trannum = translist.size();
				return false;
			}
			String t1 = "";
			Date time = null;
			try {
				time = d.parse(oraTransInfo.ora_time);
				t1 = t.format(time);
			} catch (Exception e) {
			}
			// 已经转好了从10进制转成16
			if (t1 == null) {
				t1 = "";
			}
			Asession session = asessionService.selsession(dbConpro.getJgxtlb(), oraTransInfo.sid, oraTransInfo.serial,
					t1);
			if (session == null) {
				session = new Asession();
				session.setSid("NOT FOUND");
				session.setSerial("NOT FOUND");
				session.setMachine("NOT FOUND");
				session.setProgram("NOT FOUND");
			}
			oraTransInfo.setOra_client(session.getMachine());
			oraTransInfo.setOra_program(session.getProgram());
			String lx = "";
			String dblx = "";
			String[] split;
			LinkedHashMap<String, List<OraDMLObject>> dmlhc = new LinkedHashMap<>();
			for (Iterator<OraDMLObject> iterator = dmllist.iterator(); iterator.hasNext();) {
				OraDMLObject oraDMLInfo = (OraDMLObject) iterator.next();
				LinkedHashMap<String, List<OraDMLObject>> dmlhcmap = new LinkedHashMap<>();
				dbrzcs = dbmap.get(oraDMLInfo.getTab_name().toUpperCase());
				if (null == dbrzcs) {
					iterator.remove();
					continue;
				}
				lx = session.getProgram().toUpperCase();
				if (lx.equals("NOT FOUND")) {
					iterator.remove();
					if (oraDMLInfo.getTab_action().equals("delete")) {
						oraLogObject.deleteCount--;
					} else if (oraDMLInfo.getTab_action().equals("update")) {
						oraLogObject.updateCount--;
					} else if (oraDMLInfo.getTab_action().equals("insert")) {
						oraLogObject.insertCount--;
					}
					continue;
				}
				if (dbrzcs.getZlkhdgllx() == null) {
				} else if (!dbrzcs.getZlkhdgllx().toUpperCase().contains("#")) {
					dblx = dbrzcs.getZlkhdgllx().toUpperCase();
					if (lx.startsWith(dblx)) {
						if (oraDMLInfo.getTab_action().equals("delete")) {
							oraLogObject.deleteCount--;
						} else if (oraDMLInfo.getTab_action().equals("update")) {
							oraLogObject.updateCount--;
						} else if (oraDMLInfo.getTab_action().equals("insert")) {
							oraLogObject.insertCount--;
						}
						iterator.remove();
						continue;
					}
				} else {
					dblx = dbrzcs.getZlkhdgllx().toUpperCase();
					split = dblx.split("#");
					for (String khd : split) {
						if (lx.startsWith(khd)) {
							if (oraDMLInfo.getTab_action().equals("delete")) {
								oraLogObject.deleteCount--;
							} else if (oraDMLInfo.getTab_action().equals("update")) {
								oraLogObject.updateCount--;
							} else if (oraDMLInfo.getTab_action().equals("insert")) {
								oraLogObject.insertCount--;
							}
							iterator.remove();
							continue;
						}
					}
				}
				clzt = ztmap.get(dbrzcs.getBm());
				if (clzt.getCjzt().equals("1")) {
					if (oraDMLInfo.getTab_action().equals("delete")) {
						deleteCount++;
						oraLogObject.deleteCount--;
					} else if (oraDMLInfo.getTab_action().equals("update")) {
						updateCount++;
						oraLogObject.updateCount--;
					} else if (oraDMLInfo.getTab_action().equals("insert")) {
						insertCount++;
						oraLogObject.insertCount--;
					}
					if (dmlhc.containsKey(dbrzcs.getBm())) {
						dmlhc.get(dbrzcs.getBm()).add(oraDMLInfo);
						iterator.remove();
						logger.info("RedisHic   --------========添加缓存" + dmlhc.get(dbrzcs.getBm()).size());
					} else {
						List<OraDMLObject> list = new ArrayList<>();
						list.add(oraDMLInfo);
						iterator.remove();
						dmlhcmap.put(dbrzcs.getBm(), list);
						dmlhc.putAll(dmlhcmap);
						list = null;
						dmlhcmap = null;
						logger.info("RedisHic   --========添加缓存" + dmlhc.get(dbrzcs.getBm()).size());
					}
					continue;
				}
			}
			if (!dmlhc.isEmpty()) {
				for (Entry<String, List<OraDMLObject>> entry : dmlhc.entrySet()) {
					System.out.println("此事务中缓存的"+entry.getValue().size());
					if (RedisHct.bmhc.containsKey(entry.getKey())) {
						RedisHct.bmhc.get(entry.getKey()).put(oraTransInfo, entry.getValue());
						System.out.println("RedisHct.bmhc-1111111--几个事务-1111111------1"+RedisHct.bmhc.get(entry.getKey()).size());
					} else {
						LinkedHashMap<OraTransObject, List<OraDMLObject>> tranhc = new LinkedHashMap<>();
						tranhc.put(oraTransInfo, entry.getValue());
						RedisHct.bmhc.put(entry.getKey(), tranhc);
						System.out.println("此事务中缓存的"+entry.getValue().size());
						System.out.println("RedisHct.bmhc------11111---1111111------1");
					}
				}
			}
			System.out.println("RedisHct.bmhc-------一共有几张表缓存---22222222222222-------"+RedisHct.bmhc.size());
			if (dmllist.isEmpty()
					||dmlnum>=dmllist.size()
					) {
				Zlsjddb zlsjddb = new Zlsjddb();
				zlsjddb.setJgxtlb(dbConpro.getJgxtlb());
				zlsjddb.setSlh("1");
				zlsjddb.setScn(new BigDecimal(HexToTen(log2orarec.getCurrentSCN())));
				zlsjddbService.saveOrupdate(zlsjddb);
				trannum = translist.size();
				dmlnum = dmllist.size();
				return false;
			}
			if (!documentStatus) {
				// 文件头
				sjk = getZLXMLName();// 自己设置文件名作为属性
				logger.info("增量  ---------新建文件名");
				createXMLHead(sjk, false);
				createZLHead();
			}
			attr.clear();
			attr.addAttribute("", "", "sessionid", "", oraTransInfo.sid);
			attr.addAttribute("", "", "serial", "", oraTransInfo.serial);
			handler.startElement("", "", "ora_transaction", attr);
			attr.clear();
			handler.startElement("", "", "ora_user", attr);
			handler.characters(oraTransInfo.ora_user.toCharArray(), 0, oraTransInfo.ora_user.length());
			handler.endElement("", "", "ora_user");
			handler.startElement("", "", "ora_client", attr);
			handler.characters(session.getMachine().toCharArray(), 0, session.getMachine().toString().length());
			handler.endElement("", "", "ora_client");
			handler.startElement("", "", "ora_time", attr);
			handler.characters(format.format(time).toCharArray(), 0, format.format(time).length());
			handler.endElement("", "", "ora_time");
			handler.startElement("", "", "ora_program", attr);
			handler.characters(session.getProgram().toCharArray(), 0, session.getProgram().length());
			handler.endElement("", "", "ora_program");
			attr.clear();
			// ora_datalist
			handler.startElement("", "", "ora_datalist", attr);
			for (int k = dmlnum; k < dmllist.size(); k++) {
				OraDMLObject oraDMLInfo1 = dmllist.get(k);
				// 索引相同的时候才会做操作
				// tab_record oradmlinfo
				indmlnum++;
				attr.clear();
				attr.addAttribute("", "", "recnum", "", String.valueOf(oraDMLInfo1.getRecnum() + 1));
				handler.startElement("", "", "tab_record", attr);
				// dml内容
				attr.clear();
				handler.startElement("", "", "ora_schema", attr);
				handler.characters(oraDMLInfo1.getOra_schema().toCharArray(), 0, oraDMLInfo1.getOra_schema().length());
				handler.endElement("", "", "ora_schema");
				handler.startElement("", "", "ora_table", attr);
				handler.characters(oraDMLInfo1.getTab_name().toUpperCase().toCharArray(), 0,
						oraDMLInfo1.getTab_name().length());
				handler.endElement("", "", "ora_table");
				handler.startElement("", "", "tab_action", attr);
				handler.characters(oraDMLInfo1.getTab_action().toCharArray(), 0, oraDMLInfo1.getTab_action().length());
				handler.endElement("", "", "tab_action");
				// where_value old_value data_value 都需要判断是否为空
				HashMap<String, String> where_value = oraDMLInfo1.getWhere_value();
				HashMap<String, String> old_value = oraDMLInfo1.getOld_value();
				HashMap<String, String> data_value = oraDMLInfo1.getData_value();
				attr.clear();
				if (!where_value.isEmpty()) {
					handler.startElement("", "", "where_value", attr);
					for (Entry<String, String> entry : where_value.entrySet()) {
						if (entry.getValue() == null) {
							value = "";
						}else{
							value = Decode.decode(entry.getValue()).replace("'", "");
						}
						handler.startElement("", "", entry.getKey(), attr);
						handler.characters(value.toCharArray(), 0, value.length());
						handler.endElement("", "", entry.getKey());
					}
					handler.endElement("", "", "where_value");
				}
				if (!old_value.isEmpty()) {
					handler.startElement("", "", "old_value", attr);
					for (Entry<String, String> entry : old_value.entrySet()) {
						if (null == entry.getValue()  ) {
							value = "";
						}else{
							value = Decode.decode(entry.getValue()).replace("'", "");
						}
						handler.startElement("", "", entry.getKey(), attr);
						handler.characters(value.toCharArray(), 0, value.length());
						handler.endElement("", "", entry.getKey());
					}
					handler.endElement("", "", "old_value");
				}
				if (!data_value.isEmpty()) {
					handler.startElement("", "", "data_value", attr);
					for (Entry<String, String> entry : data_value.entrySet()) {
						if (entry.getValue() == null) {
							value = "";
						}else{
							value = Decode.decode(entry.getValue()).replace("'", "");
						}
						handler.startElement("", "", entry.getKey(), attr);
						handler.characters(value.toCharArray(), 0, value.length());
						handler.endElement("", "", entry.getKey());
					}
					handler.endElement("", "", "data_value");
				}
				handler.endElement("", "", "tab_record");
			}
			handler.endElement("", "", "ora_datalist");
			handler.endElement("", "", "ora_transaction");
			// 关闭
			fis.flush();
			session = null;
			t1 = null;
			time = null;
			if (f.length() >= wjzdz) {
				createZLXMLEnd(oraLogObject);
				if (!RedisHct.bmhc.isEmpty()) {
					for (Iterator<Entry<String, LinkedHashMap<OraTransObject, List<OraDMLObject>>>> it = RedisHct.bmhc
							.entrySet().iterator(); it.hasNext();) {
						Map.Entry<String, LinkedHashMap<OraTransObject, List<OraDMLObject>>> entry = it.next();
						createYCXMLTransactionList(entry.getKey(), oraLogObject, entry.getValue());
						if (documentStatus) {
							createYCZLXMLEnd(bm, oraLogObject);
						}
						it.remove();
					}
				}
				dmlnum = 0;
				trannum = 0;
				indmlnum = 0;
				return true;
			} else {
				trannum = translist.size();
				dmlnum = dmllist.size();
				return false;
			}
		} catch (SAXException e) {
			e.printStackTrace();
			int num = XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1;
			XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), num);
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("增量文件373/n" + e);
			int num = XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1;
			XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), num);
		}
		return false;

	}

	/**
	 * 原始的scn 我需要转成 10进制的num类型
	 * 
	 * @param wjzdz
	 * @param oraLogObject
	 * @throws IOException
	 */
	public void createZLXMLEnd(OraRecord oraLogObject) throws IOException {
		// 关闭
		// 增量文件关闭
		createXMLEnd(false);
		try {
			Zlsjwjb zlsjwjb = new Zlsjwjb();
			Zlsjddb zlsjddb = new Zlsjddb();
			zlsjwjb.setJgxtlb(dbConpro.getJgxtlb());
			zlsjwjb.setWjm(f.getName());
			FileInputStream fis = new FileInputStream(sjk);
			zlsjwjb.setMd5(DigestUtils.md5Hex(fis));
			fis.close();
			fis = null;
			zlsjwjb.setWjdx(new BigDecimal(f.length() / 1024));
			zlsjwjb.setSjlinsert(new BigDecimal(oraLogObject.insertCount));
			zlsjwjb.setSjlupdate(new BigDecimal(oraLogObject.updateCount));
			zlsjwjb.setSjldelete(new BigDecimal(oraLogObject.deleteCount));
			if (!oraLogObject.startSCN.equals("")) {
				zlsjwjb.setScnq(new BigDecimal(HexToTen(oraLogObject.startSCN)));
			}
			if (!oraLogObject.startTrans.equals("")) {
				zlsjwjb.setSeqq(new BigDecimal(HexToTen(oraLogObject.startTrans)));
			}
			if (!oraLogObject.stopSCN.equals("")) {
				zlsjwjb.setScnz(new BigDecimal(HexToTen(oraLogObject.stopSCN)));
				zlsjddb.setScn(new BigDecimal(HexToTen(oraLogObject.stopSCN)));
			} else {
				zlsjwjb.setScnz(new BigDecimal(HexToTen(oraLogObject.startSCN)));
				zlsjddb.setScn(new BigDecimal(HexToTen(oraLogObject.startSCN)));
			}
			if (!oraLogObject.stopTrans.equals("")) {
				zlsjwjb.setSeqz(new BigDecimal(HexToTen(oraLogObject.stopTrans)));
				zlsjddb.setSeq(new BigDecimal(HexToTen(oraLogObject.stopTrans)));
			} else {
				zlsjddb.setSeq(new BigDecimal(HexToTen(oraLogObject.startTrans)));
				zlsjwjb.setSeqz(new BigDecimal(HexToTen(oraLogObject.startTrans)));
			}
			zlsjwjb.setScsj(getTime());
			zlsjwjb.setWjzt("1");
			zlsjwjb.setGxsj(getTime());
			zlsjwjb.setCwzt("0");
			zlsjwjb.setSbzt("0");
			zlsjwjb.setBm("0");
			zlsjwjbService.saveOrupdate(zlsjwjb);
			zlsjddb.setJgxtlb(dbConpro.getJgxtlb());
			zlsjddb.setGxsj(getTime());
			zlsjddb.setSlh("1");
			zlsjddbService.saveOrupdate(zlsjddb);
			zlsjddb = null;
			zlsjwjb = null;
		} catch (NullPointerException e) {
			e.printStackTrace();
			int num = XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1;
			XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), num);
			logger.error(e);
			logger.info("增量生成成功文件写入断点写入失败");
		} catch (Exception e) {
			e.printStackTrace();
			int num = XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1;
			XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), num);
			logger.error(e);
			logger.info("增量生成成功文件写入断点写入失败");
		}

	}

	/**
	 * 增量异常模式
	 * 
	 */
	public String bm = "";
	int insertCount = 0;
	int updateCount = 0;
	int deleteCount = 0;

	public void createYCXMLTransactionList(String bm1, OraRecord oraLogObject,
			LinkedHashMap<OraTransObject, List<OraDMLObject>> linked) {
		try {
			bm = bm1;
			for (Entry<OraTransObject, List<OraDMLObject>> entry : linked.entrySet()) {
				if (!documentStatus) {
					// 文件头
					long b = new Date().getTime();
					sjk = FilePathName.ROOT + dbConpro.getJgxtlb() + FilePathName.FileSepeartor
							+ FilePathName.ZLStanbyPath + FilePathName.FileSepeartor + bm1 + b;// 自己设置文件名作为属性
					createXMLHead(sjk, false);
					createZLHead();
				}
				OraTransObject oraTransInfo = entry.getKey();
				List<OraDMLObject> dmllist = entry.getValue();
				attr.clear();
				attr.addAttribute("", "", "sessionid", "", oraTransInfo.getSid());
				attr.addAttribute("", "", "serial", "", oraTransInfo.getSerial());
				handler.startElement("", "", "ora_transaction", attr);
				attr.clear();
				handler.startElement("", "", "ora_user", attr);
				handler.characters(oraTransInfo.ora_user.toCharArray(), 0, oraTransInfo.ora_user.length());
				handler.endElement("", "", "ora_user");
				handler.startElement("", "", "ora_client", attr);
				handler.characters(oraTransInfo.ora_client.toCharArray(), 0,
						oraTransInfo.ora_client.toString().length());
				handler.endElement("", "", "ora_client");
				handler.startElement("", "", "ora_time", attr);
				handler.characters(oraTransInfo.getOra_time().toCharArray(), 0, oraTransInfo.getOra_time().length());
				handler.endElement("", "", "ora_time");
				handler.startElement("", "", "ora_program", attr);
				handler.characters(oraTransInfo.ora_program.toString().toCharArray(), 0,
						oraTransInfo.ora_program.toString().length());
				handler.endElement("", "", "ora_program");
				attr.clear();
				handler.startElement("", "", "ora_datalist", attr);
				for (Iterator<OraDMLObject> iterator = dmllist.iterator(); iterator.hasNext();) {
					OraDMLObject oraDMLInfo1 = (OraDMLObject) iterator.next();
					// 索引相同的时候才会做操作
					indmlnum++;
					attr.clear();
					attr.addAttribute("", "", "recnum", "", String.valueOf(oraDMLInfo1.getRecnum() + 1));
					handler.startElement("", "", "tab_record", attr);
					// dml内容
					attr.clear();
					handler.startElement("", "", "ora_schema", attr);
					handler.characters(oraDMLInfo1.getOra_schema().toCharArray(), 0,
							oraDMLInfo1.getOra_schema().length());
					handler.endElement("", "", "ora_schema");
					handler.startElement("", "", "ora_table", attr);
					handler.characters(oraDMLInfo1.getTab_name().toUpperCase().toCharArray(), 0,
							oraDMLInfo1.getTab_name().length());
					handler.endElement("", "", "ora_table");
					handler.startElement("", "", "tab_action", attr);
					handler.characters(oraDMLInfo1.getTab_action().toCharArray(), 0,
							oraDMLInfo1.getTab_action().length());
					handler.endElement("", "", "tab_action");
					HashMap<String, String> where_value = oraDMLInfo1.getWhere_value();
					HashMap<String, String> old_value = oraDMLInfo1.getOld_value();
					HashMap<String, String> data_value = oraDMLInfo1.getData_value();
					attr.clear();
					String value = "";
					if (!where_value.isEmpty()) {
						handler.startElement("", "", "where_value", attr);
						for (Entry<String, String> entry1 : where_value.entrySet()) {
							if (null==entry1.getValue()  ) {
								value = "";
							}else{
								value = Decode.decode(entry1.getValue()).replace("'", "");
							}
							handler.startElement("", "", entry1.getKey(), attr);
							handler.characters(value.toCharArray(), 0, value.length());
							handler.endElement("", "", entry1.getKey());
						}
						handler.endElement("", "", "where_value");
					}
					if (!old_value.isEmpty()) {
						handler.startElement("", "", "old_value", attr);
						for (Entry<String, String> entry1 : old_value.entrySet()) {
							if (null == entry1.getValue()) {
								value = "";
							}else{
								value = Decode.decode(entry1.getValue()).replace("'", "");
							}
							handler.startElement("", "", entry1.getKey(), attr);
							handler.characters(value.toCharArray(), 0, value.length());
							handler.endElement("", "", entry1.getKey());
						}
						handler.endElement("", "", "old_value");
					}
					if (!data_value.isEmpty()) {
						handler.startElement("", "", "data_value", attr);
						for (Entry<String, String> entry1 : data_value.entrySet()) {
							if ( null==entry1.getValue() ) {
								value = "";
							}else{
								value = Decode.decode(entry1.getValue()).replace("'", "");
							}
							handler.startElement("", "", entry1.getKey(), attr);
							handler.characters(value.toCharArray(), 0, value.length());
							handler.endElement("", "", entry1.getKey());
						}
						handler.endElement("", "", "data_value");
					}
					handler.endElement("", "", "tab_record");
				}
				handler.endElement("", "", "ora_datalist");
				handler.endElement("", "", "ora_transaction");
				fis.flush();
				if (f.length() >= wjzdz) {
					createYCZLXMLEnd(bm, oraLogObject);
					insertCount = 0;
					updateCount = 0;
					deleteCount = 0;
				}
			}
		} catch (SAXException e) {
			e.printStackTrace();
			logger.error(e);
			int num = XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1;
			XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), num);
			// TODO Auto-generated catch block
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e);
			int num = XMLFileName.zlcountMap.get(dbConpro.getJgxtlb()) - 1;
			XMLFileName.zlcountMap.put(dbConpro.getJgxtlb(), num);
		}
	}

	public void createYCZLXMLEnd(String bm, OraRecord oraLogObject) throws IOException {
		// 关闭
		// 增量文件关闭
		createXMLEnd(false);
		try {
			Zlsjwjb zlsjwjb = new Zlsjwjb();
			Zlsjddb zlsjddb = new Zlsjddb();
			zlsjwjb.setJgxtlb(dbConpro.getJgxtlb());
			zlsjwjb.setWjm(f.getName());
			FileInputStream fis = new FileInputStream(sjk);
			zlsjwjb.setMd5(DigestUtils.md5Hex(fis));
			fis.close();
			zlsjwjb.setWjdx(new BigDecimal(f.length() / 1024));
			zlsjwjb.setSjlinsert(new BigDecimal(insertCount));
			zlsjwjb.setSjlupdate(new BigDecimal(updateCount));
			zlsjwjb.setSjldelete(new BigDecimal(deleteCount));
			if (!oraLogObject.startSCN.equals("")) {
				zlsjwjb.setScnq(new BigDecimal(HexToTen(oraLogObject.startSCN)));
			}
			if (!oraLogObject.startTrans.equals("")) {
				zlsjwjb.setSeqq(new BigDecimal(HexToTen(oraLogObject.startTrans)));
			}
			if (!oraLogObject.stopSCN.equals("")) {
				zlsjwjb.setScnz(new BigDecimal(HexToTen(oraLogObject.stopSCN)));
				zlsjddb.setScn(new BigDecimal(HexToTen(oraLogObject.stopSCN)));
			} else {
				zlsjwjb.setScnz(new BigDecimal(HexToTen(oraLogObject.startSCN)));
				zlsjddb.setScn(new BigDecimal(HexToTen(oraLogObject.startSCN)));
			}
			if (!oraLogObject.stopTrans.equals("")) {
				zlsjwjb.setSeqz(new BigDecimal(HexToTen(oraLogObject.stopTrans)));
				zlsjddb.setSeq(new BigDecimal(HexToTen(oraLogObject.stopTrans)));
			} else {
				zlsjddb.setSeq(new BigDecimal(HexToTen(oraLogObject.startTrans)));
				zlsjwjb.setSeqz(new BigDecimal(HexToTen(oraLogObject.startTrans)));
			}
			zlsjwjb.setScsj(getTime());
			zlsjwjb.setWjzt("1");
			zlsjwjb.setGxsj(getTime());
			zlsjwjb.setCwzt("0");
			zlsjwjb.setSbzt("0");
			zlsjwjb.setBm(bm);
			zlsjwjbService.saveOrupdate(zlsjwjb);
			zlsjddb.setJgxtlb(dbConpro.getJgxtlb());
			zlsjddb.setGxsj(getTime());
			zlsjddb.setSlh("1");
			zlsjddbService.saveOrupdate(zlsjddb);
			zlsjddb = null;
			zlsjwjb = null;
		} catch (NullPointerException e) {
			logger.error(e);
			logger.info("增量生成成功文件写入断点写入失败");
		} catch (Exception e) {
			logger.error(e);
			logger.info("增量生成成功文件写入断点写入失败");
		}

	}

	/**
	 * 有断点续采的功能 存量数据集合 多线程模式
	 * 
	 * @param datalist
	 * @throws Exception
	 */
	public void createXMLDatalist(ResultSet rs, int wjzdz, String wjm, int start, String timeFied, JDBCUtil jdbc)
			throws Exception {
		rs.beforeFirst();
		if (timeFied.equals("")) {
			timeFied = "rowid";
		}
		String key = "";
		String value = "";
		String timeFiedType = jdbc.getTimeFiedType();
		int columnCount = 0;
		int time = 0;
		ResultSetMetaData rsMeta = rs.getMetaData();
		columnCount = rsMeta.getColumnCount();
		String field = timeFied.toLowerCase();
		while (rs.next()) {
			if (!documentStatus) {
				clsjwj.setWjstart(new BigDecimal(rownum));
				if (!wjm.equals("") && wjm != null) {
					sjk = FilePathName.ROOT + dbConpro.getJgxtlb() + FilePathName.FileSepeartor
							+ FilePathName.CLStanbyPath + FilePathName.FileSepeartor + wjm;
				} else {
					sjk = getXMLName();// 自己设置文件名作为属性
				}
				createXMLHead(sjk, true);
				createXMLTitle(tree, true);
				filecount++;
				wjq = 0;
				sjl = 0;
			}
			time = 0;
			attr.addAttribute("", "", "recnum", "", String.valueOf(rownum + 1));
			handler.startElement("", "", "tab_record", attr);
			for (int i = 1; i <= columnCount; i++) {
				key = rsMeta.getColumnLabel(i).toLowerCase();
				value = "";
				if (rs.getObject(i) != null) {
					if (rsMeta.getColumnTypeName(i).equals("DATE")) {
						value = format.format(rs.getTimestamp(i));
					} else {
						value = rs.getString(i);
					}
				}
				if (time == 0) {
					if (key.equals(field)) {
						time++;
						rownum++;
						sjcz = value;
						if (wjq == 0) {
							wjsjcq = value;
						}
						wjq++;
						sjl++;
						continue;
					}
				}
				attr.clear();
				handler.startElement("", "", key, attr);
				handler.characters(value.toCharArray(), 0, value.length());
				handler.endElement("", "", key);
				key = null;
				value = null;
			}
			handler.endElement("", "", "tab_record");
			fis.flush();
			if (f.length() >= wjzdz) {
				createXMLEnd(true);
				if (timeFiedType.equals("VARCHAR2") && !timeFied.equals("rowid")) {
					clsjkdd.setDqsjc(format.format(getTime(d.parse(sjcz))));
					clsjwj.setSjcz(format.format(getTime(d.parse(sjcz))));
					clsjwj.setSjcq(format.format(getTime(d.parse(wjsjcq))));
				} else {
					clsjwj.setSjcq(wjsjcq);
					clsjwj.setSjcz(sjcz);
					clsjkdd.setDqsjc(sjcz);
				}
				clsjwj.setWjm(f.getName());
				clsjwj.setSlj(new BigDecimal(sjl));
				clsjwj.setWjzt("1");
				clsjwj.setWjend(new BigDecimal(rownum));
				clsjwj.setScsj(getTime());
				clsjwj.setCwzt("0");
				clsjwj.setGxsj(getTime());
				clsjwj.setSbzt("0");
				clsjkdd.setSjkstart(new BigDecimal(rownum));
				clsjwj.setWjdx(new BigDecimal(f.length() / 1024));
				clsjwjbService.saveOrupdate(clsjwj);
				clsjkddbService.saveOrupdate(clsjkdd);
				fis = null;
			}
		}
	}

	/**
	 * 16->10
	 * 
	 * @param str
	 * @return
	 */
	public static Long HexToTen(String str) {
		return Long.parseLong(str.replace("0x", "").replace(".", ""), 16);
	}

	/**
	 * 330->00000330
	 * 
	 * @param str
	 * @return
	 */
	public static String padLeft(String s, int length) {
		byte[] bs = new byte[length];
		byte[] ss = s.getBytes();
		Arrays.fill(bs, (byte) (48 & 0xff));
		System.arraycopy(ss, 0, bs, length - ss.length, ss.length);
		return new String(bs);
	}

	/**
	 * 10->16
	 * 
	 * @param n
	 * @return
	 */
	public static String TenToHex(Long n) {
		String a;
		a = Long.toHexString(n);
		StringBuilder sb = new StringBuilder(padLeft(a, 12).toUpperCase());
		a = sb.insert(4, '.').insert(0, "0x").toString();
		return a;
	}

	public void saxClend(String timeFiedType, String timeFied) throws ParseException {
		if (documentStatus) {
			createXMLEnd(true);
			clsjwj.setWjm(f.getName());
			clsjwj.setSlj(new BigDecimal(sjl));
			clsjwj.setWjzt("1");
			if (timeFiedType.equals("VARCHAR2") && !timeFied.equals("rowid")) {
				clsjkdd.setDqsjc(format.format(getTime(d.parse(sjcz))));
				clsjwj.setSjcz(format.format(getTime(d.parse(sjcz))));
				clsjwj.setSjcq(format.format(getTime(d.parse(wjsjcq))));
			} else {
				clsjwj.setSjcq(wjsjcq);
				clsjwj.setSjcz(sjcz);
				clsjkdd.setDqsjc(sjcz);
			}
			clsjwj.setWjend(new BigDecimal(rownum));
			clsjwj.setScsj(getTime());
			clsjwj.setCwzt("0");
			clsjwj.setGxsj(getTime());
			clsjwj.setSbzt("0");
			clsjwj.setWjdx(new BigDecimal(f.length() / 1024));
			clsjwjbService.saveOrupdate(clsjwj);
			clsjkdd.setSbzt("0");
			clsjkddbService.saveOrupdate(clsjkdd);
			fis = null;
		}
	}

	/**
	 * 根据model不同 最后关闭的时候的节点不同 true 存量 false 增量
	 * 
	 * @param com.arshiner.quartz.model
	 * @throws SAXException
	 * @throws IOException
	 */
	public void createXMLEnd(boolean model) {
		// 这个endElement可以先暂时不加，等文件到15MB的时候再加
		try {
			if (model) {
				handler.endElement("", "", "tab_datalist");
				handler.endElement("", "", "root");
				handler.endDocument();
			} else {
				handler.endElement("", "", "root");
				handler.endDocument();
			}
			documentStatus = false;
			fis.close();
		} catch (SAXException e) {
			logger.error(e);
			if (model) {
				logger.info("存量文件关闭失败");
			} else {
				logger.info("增量文件关闭失败");
			}
		} catch (IOException e) {
			logger.error(e);
			if (model) {
				logger.info("存量文件关闭失败");
			} else {
				logger.info("增量文件关闭失败");
			}
		}
	}

	/**
	 * 有断点续采的功能 存量数据集合 多线程模式 备份
	 * 
	 * @param datalist
	 * @throws SQLException
	 * @throws SAXException
	 * @throws IOException
	 * @throws ParseException
	 */
	public Map<String, Object> createXMLDatalist1(ResultSet rs, int taskid, int start, String timeFied, JDBCUtil jdbc)
			throws SQLException, SAXException, IOException, ParseException {
		String sjcq = "";
		String sjcz = "";
		Integer rowcount = start;
		rs.beforeFirst();
		if (timeFied.equals("")) {
			timeFied = "rowid";
		}
		String key = "";
		String value = "";
		int columnCount = 0;
		ResultSetMetaData rsMeta = rs.getMetaData();
		columnCount = rsMeta.getColumnCount();
		String field = timeFied.toLowerCase();
		String filename = "";
		while (rs.next()) {
			if (!documentStatus) {
				filename = "D:\\TEST" + taskid + rowcount + ".xml";
				f = new File(filename);
				createXMLHead(filename, true);
				createXMLTitle(tree, true);
			}
			int time = 0;
			attr.addAttribute("", "", "recnum", "", String.valueOf(rowcount + 1));
			handler.startElement("", "", "tab_record", attr);
			for (int i = 1; i <= columnCount; i++) {
				key = rsMeta.getColumnLabel(i).toLowerCase();
				value = "";
				if (rs.getObject(i) != null) {
					if (rsMeta.getColumnTypeName(i).equals("DATE")) {
						value = format.format(rs.getTimestamp(i));
					} else {
						value = rs.getString(i);
					}
				}
				if (time == 0) {
					if (key.equals(field)) {
						if (rowcount == start) {
							sjcq = value;
						}
						time++;
						rowcount++;
						sjcz = value;
						continue;
					}
				}
				attr.clear();
				handler.startElement("", "", key, attr);
				handler.characters(value.toCharArray(), 0, value.length());
				handler.endElement("", "", key);
			}
			handler.endElement("", "", "tab_record");
			fis.flush();
			if (f.length() >= 20971520) {
				this.createXMLEnd(true);
			}
		}
		Map<String, Object> param = new HashMap<>();
		param.put("dqsjc", sjcz);
		param.put("sjcq", sjcq);
		param.put("sjcz", sjcz);
		param.put("rowcount", rowcount);
		return param;
	}

	/**
	 * 存量文件名获取 有个守护线程，，所以不需要
	 * 
	 * @return
	 */
	public String getXMLName() {
		if (dbConpro.getJgxtlb() != null && !dbConpro.getJgxtlb().equals("")) {

			StringBuffer str = new StringBuffer(FilePathName.ROOT);
			// 文件路径
			str.append(dbConpro.getJgxtlb()).append(FilePathName.FileSepeartor).append(FilePathName.CLStanbyPath)
					// 文件名
					.append(FilePathName.FileSepeartor).append(dbConpro.getAzdm()).append(dbConpro.getJgxtlb())
					.append(xmlfilename.getXmlFileName("cl", dbConpro.getJgxtlb()))
					;
			dbConpro.setClnum(new BigDecimal(XMLFileName.clcountMap.get(dbConpro.getJgxtlb())));
			dbconProService.updateByExampleSelective(dbConpro);
			return str.toString();
		}

		return null;
	}

	/**
	 * 
	 * 增量XML文件名获取
	 * 
	 * @return
	 */
	public String getZLXMLName() {
		if (dbConpro.getJgxtlb() != null && !dbConpro.getJgxtlb().equals("")) {
			StringBuffer str = new StringBuffer(FilePathName.ROOT);
			// 文件路径
			str.append(dbConpro.getJgxtlb()).append(FilePathName.FileSepeartor).append(FilePathName.ZLStanbyPath)
					.append(FilePathName.FileSepeartor).append(dbConpro.getAzdm()).append(dbConpro.getJgxtlb())
					.append(xmlfilename.getXmlFileName("zl", dbConpro.getJgxtlb()))
					;
			// 更新增量个数
			Dbconpro record = new Dbconpro();
			record.setJgxtlb(dbConpro.getJgxtlb());
			record.setZlnum(new BigDecimal(XMLFileName.zlcountMap.get(dbConpro.getJgxtlb())));
			dbconProService.updateByExampleSelective(record);
			return str.toString();
		}
		return "0";
	}

	/**
	 * 
	 * 增量上一个或下一个文件名获取
	 * 
	 * @return
	 */
	public String getNextZLXMLName(Integer num) {
		if (dbConpro.getJgxtlb() != null && !dbConpro.getJgxtlb().equals("")) {
			StringBuffer str = new StringBuffer();
			// 文件路径
			str.append(dbConpro.getAzdm()).append(dbConpro.getJgxtlb())
			.append(xmlfilename.getXmlFileName("zl", num))
			;
			return str.toString();
		}
		return "0";
	}

	/**
	 * 拥有时分秒的Date
	 * 
	 * @return
	 */
	public Timestamp getTime() {
		Date utilDate = new Date();// util.Date
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}

	public boolean isDocumentStatus() {
		return documentStatus;
	}

	public void setDocumentStatus(boolean documentStatus) {
		this.documentStatus = documentStatus;
	}

	public File getF() {
		return f;
	}

	public Integer getRownum() {
		return rownum;
	}

	public void setRownum(Integer rownum) {
		this.rownum = rownum;
	}

	public void setF(File f) {
		this.f = f;
	}

	public Dbconpro getDbConpro() {
		return dbConpro;
	}

	public void setDbConpro(Dbconpro dbConpro) {
		this.dbConpro = dbConpro;
	}

	public String getSjk() {
		return sjk;
	}

	public void setSjk(String sjk) {
		this.sjk = sjk;
	}

	public FileOutputStream getFis() {
		return fis;
	}

	public void setFis(FileOutputStream fis) {
		this.fis = fis;
	}

	public ClsjwjbService getClsjwjbService() {
		return clsjwjbService;
	}

	public void setClsjwjbService(ClsjwjbService clsjwjbService) {
		this.clsjwjbService = clsjwjbService;
	}

	public ClsjkddbService getClsjkddbService() {
		return clsjkddbService;
	}

	public void setClsjkddbService(ClsjkddbService clsjkddbService) {
		this.clsjkddbService = clsjkddbService;
	}

	public DbconProService getDbconProService() {
		return dbconProService;
	}

	public void setDbconProService(DbconProService dbconProService) {
		this.dbconProService = dbconProService;
	}

	public ZlsjwjbService getZlsjwjbService() {
		return zlsjwjbService;
	}

	public void setZlsjwjbService(ZlsjwjbService zlsjwjbService) {
		this.zlsjwjbService = zlsjwjbService;
	}

	public ZlsjddbService getZlsjddbService() {
		return zlsjddbService;
	}

	public void setZlsjddbService(ZlsjddbService zlsjddbService) {
		this.zlsjddbService = zlsjddbService;
	}

	public AsessionService getAsessionService() {
		return asessionService;
	}

	public void setAsessionService(AsessionService asessionService) {
		this.asessionService = asessionService;
	}

	public LinkedHashMap<String, Clsjclzt> getZtmap() {
		return ztmap;
	}

	public void setZtmap(LinkedHashMap<String, Clsjclzt> ztmap) {
		this.ztmap = ztmap;
	}

	public LinkedHashMap<String, Dbrzcjcs> getDbmap() {
		return dbmap;
	}

	public void setDbmap(LinkedHashMap<String, Dbrzcjcs> dbmap) {
		this.dbmap = dbmap;
	}

	public Timestamp getTime(Date utilDate) {
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}

	public DbrzcjcsService getDbrzcjcsService() {
		return dbrzcjcsService;
	}

	public void setDbrzcjcsService(DbrzcjcsService dbrzcjcsService) {
		this.dbrzcjcsService = dbrzcjcsService;
	}

	public int getDmlnum() {
		return dmlnum;
	}

	public void setDmlnum(int dmlnum) {
		this.dmlnum = dmlnum;
	}

	public int getTrannum() {
		return trannum;
	}

	public void setTrannum(int trannum) {
		this.trannum = trannum;
	}

	public boolean isZlflag() {
		return zlflag;
	}

	public void setZlflag(boolean zlflag) {
		this.zlflag = zlflag;
	}

	public int getIndmlnum() {
		return indmlnum;
	}

	public void setIndmlnum(int indmlnum) {
		this.indmlnum = indmlnum;
	}

	public ClsjclztService getClsjclztService() {
		return clsjclztService;
	}

	public void setClsjclztService(ClsjclztService clsjclztService) {
		this.clsjclztService = clsjclztService;
	}

	public String getSjcz() {
		return sjcz;
	}

	public void setSjcz(String sjcz) {
		this.sjcz = sjcz;
	}

}
