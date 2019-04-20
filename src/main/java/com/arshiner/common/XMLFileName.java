package com.arshiner.common;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;


/**
 * 单例模式; xml的文件名称
 * 
 * @author 士林
 */
public class XMLFileName {

	public static final Integer maxCount = 999999;
	public static final String zlfileType = "2";
	public static final String clfileType = "1";
	public static ConcurrentHashMap<String, Integer> zlcountMap = new ConcurrentHashMap<>();
	public static ConcurrentHashMap<String, Integer> clcountMap = new ConcurrentHashMap<>();
	public static Map<String,List<String>> clNameMap= new HashMap<>();
	public static Map<String,List<String>> zlNameMap= new HashMap<>();
	public static XMLFileName single = new XMLFileName();
	public static int initdaytime = 0;
	public static final int num = 6;
	public static String user = "";
	public static String pwd = "";
	public static String url = "";
	public static ConfigManager config;
	static SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
	// 从这里获取服务端数据库IP
	// 静态工厂方法
	public static XMLFileName getInstance() {
		if (single == null) {
			single = new XMLFileName();
		}
		return single;
	}

	/**
	 * 无参构造 初始化HashMap
	 * 
	 * @return
	 */
	public XMLFileName() {
		config = new ConfigManager(ConfigManager.jdbc);
		user = config.properties.getProperty("user");
		pwd = config.properties.getProperty("pwd");
		url = config.properties.getProperty("url");
		JDBCUtil jdbc = new JDBCUtil(user, pwd, url, "1521", "orcl");
		jdbc.getConnection();
		try {
			String zlsql = "select jgxtlb,zlnum from dbconpro";
			zlcountMap = jdbc.executeQuery(zlsql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	static {
		config = new ConfigManager(ConfigManager.jdbc);
		user = config.properties.getProperty("user");
		pwd = config.properties.getProperty("pwd");
		url = config.properties.getProperty("url");
	}

	public static void reZlfile(String jgxtlb) {
		/**
		 * 使用jdbc进行获取，相同jgxtlb和ip的 select ip,zlindex from dbconpro;
		 */
		JDBCUtil jdbc = new JDBCUtil(user, pwd, url, "1521", "orcl");
		try {
			jdbc.getConnection();
			// 今天的增量文件是否有生成如果没有 设置zl计数为0
			String clsql = "select wjm from "
					+ "(select * From zlsjwjb  where  jgxtlb='"+jgxtlb+"' and to_char(scsj,'dd')=to_char(sysdate,'dd') and wjm like'%"+jgxtlb+"2"+format.format(new Date())+"%' order by wjm desc) where rownum<10"
					+ " order by wjm asc ";
			zlNameMap.put(jgxtlb, jdbc.executeQueryClec(jgxtlb,clsql,"zl"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.closeDB();
	}

	public static void reClfile(String jgxtlb) {
		/**
		 * 使用jdbc进行获取，相同jgxtlb和ip的 select ip,zlindex from dbconpro ;
		 */
		JDBCUtil jdbc = new JDBCUtil(user, pwd, url, "1521", "orcl");
		try {
			jdbc.getConnection();
			String clsql = "select wjm from "
					+ "(select * From clsjwjb  where  jgxtlb='"+jgxtlb+"' and to_char(scsj,'dd')=to_char(sysdate,'dd')  order by wjm desc) where rownum<10 "
					+ " order by wjm asc ";
			clNameMap.put(jgxtlb, jdbc.executeQueryClec(jgxtlb,clsql,"cl"));
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		jdbc.closeDB();

	}

	@SuppressWarnings("deprecation")
	public String getCurrentDate() {
		
		Date date = new Date();
		int hour = date.getHours();
		if (hour == 24 && initdaytime == 0) {
			// 遍历countMap数值归零
			initdaytime++;
			for (Iterator<HashMap.Entry<String, Integer>> it = clcountMap.entrySet().iterator(); it.hasNext();) {
				Entry<String, Integer> entry = it.next();
				clcountMap.put(entry.getKey(), 0);
			}
		}

		String str = format.format(date);
		return str;
	}

	/**
	 * 定值文件名
	 * 
	 * @param model
	 *            zl 增量的文件 cl 存量的文件
	 * @return
	 */
	public String getXmlFileName(String model, Integer xmlCount) {
		StringBuffer filename = new StringBuffer();
		if (model.equals("zl")) {
			//
			Integer zlxmlCount = xmlCount;
			filename.append(XMLFileName.zlfileType);
			filename.append(getCurrentDate());
			if (zlxmlCount <= maxCount && zlxmlCount != null) {
				filename.append(XMLFileName.autoGenericCode(zlxmlCount));
			} else {
				zlxmlCount = 0;
				filename.append(XMLFileName.autoGenericCode(zlxmlCount));
			}
		}
		if (model.equals("cl")) {
			Integer clxmlCount = xmlCount;
			filename.append(XMLFileName.clfileType);
			filename.append(getCurrentDate());
			if (clxmlCount <= maxCount && clxmlCount != null) {
				filename.append(XMLFileName.autoGenericCode(clxmlCount));
			} else {
				clxmlCount = 0;
				filename.append(XMLFileName.autoGenericCode(clxmlCount));
			}
		}
		return filename.toString();
	}

	public synchronized String getClycName(String jgxtlb){
		String name = clNameMap.get(jgxtlb).get(0);
		clNameMap.get(jgxtlb).remove(0);
		return  name;
	}
	/**
	 * 
	 * @param model
	 *            zl 增量的文件 cl 存量的文件
	 * @return
	 */
	public synchronized String getXmlFileName(String model, String jgxtlb) {
		StringBuffer filename = new StringBuffer();
		Integer zlxmlCount = 0;
		Integer clxmlCount = 0;
		if (model.equals("zl")) {
			if (zlcountMap.get(jgxtlb) == null || zlcountMap.get(jgxtlb).equals("")) {
				zlxmlCount = 0;
			} else {
				zlxmlCount = zlcountMap.get(jgxtlb);
			}
			filename.append(XMLFileName.zlfileType);
			filename.append(getCurrentDate());
			if (zlxmlCount <= maxCount && zlxmlCount != 0) {
				zlxmlCount++;
				zlcountMap.put(jgxtlb, zlxmlCount);
				filename.append(XMLFileName.autoGenericCode(zlxmlCount));
			} else {
				zlxmlCount = 0;
				zlxmlCount++;
				zlcountMap.put(jgxtlb, zlxmlCount);
				filename.append(XMLFileName.autoGenericCode(zlxmlCount));
			}
		}
		if (model.equals("cl")) {
			if (clcountMap.get(jgxtlb) == null || clcountMap.get(jgxtlb).equals("")) {
				clxmlCount = 0;
			} else {
				clxmlCount = clcountMap.get(jgxtlb);
			}
			filename.append(XMLFileName.clfileType);
			filename.append(getCurrentDate());
			if (null!=clNameMap.get(jgxtlb)&&!clNameMap.get(jgxtlb).isEmpty()) {
				return getClycName(jgxtlb);
			}else{
				if (clxmlCount <= maxCount && clxmlCount != 0) {
					clxmlCount++;
					filename.append(XMLFileName.autoGenericCode(clxmlCount));
					clcountMap.put(jgxtlb, clxmlCount);
				} else {
					clxmlCount = 0;
					clxmlCount++;
					filename.append(XMLFileName.autoGenericCode(clxmlCount));
					clcountMap.put(jgxtlb, clxmlCount);
				}
			}
		}
		return filename.toString();
	}

	public static ConcurrentHashMap<String, Integer> getZlcountMap() {
		return zlcountMap;
	}

	public static void setZlcountMap(ConcurrentHashMap<String, Integer> zlcountMap) {
		XMLFileName.zlcountMap = zlcountMap;
	}

	public static ConcurrentHashMap<String, Integer> getClcountMap() {
		return clcountMap;
	}

	public static void setClcountMap(ConcurrentHashMap<String, Integer> clcountMap) {
		XMLFileName.clcountMap = clcountMap;
	}

	/**
	 * 获取6位字符
	 * 
	 * @param code
	 * @return
	 */
	public static String autoGenericCode(Integer code) {
		String result = "";
		result = String.format("%0" + num + "d", code);

		return result;
	}

	public static int getInitdaytime() {
		return initdaytime;
	}

	public static void setInitdaytime(int initdaytime) {
		XMLFileName.initdaytime = initdaytime;
	}
}
