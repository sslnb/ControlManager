package com.arshiner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.arshiner.common.ConfigManager;
import com.arshiner.common.FilePathName;
import com.arshiner.common.JDBCUtil;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.rds_big_jk.Hdsjjk;
import com.tmri.bigdata.util.abc.AbcUtil;

import srv.Decode;

public class Test {
	private static SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
	private static SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	static ConfigManager config = new ConfigManager(ConfigManager.babh);

	/**
	 * 刷新备案编号
	 */
	public static void get() {
		String ip = config.properties.getProperty("agxtip");
		String port = config.properties.getProperty("agxtport");
		String jkxlh = config.properties.getProperty("jkxlh");
		String babh = config.properties.getProperty("babh");
		String mac = config.properties.getProperty("mac");
		if (!ip.equals("") && ip != null) {
			TestRestSafeOutAccess.agxtip = ip;
		}
		if (!port.equals("") && port != null) {
			TestRestSafeOutAccess.agxtport = port;
		}
		if (!jkxlh.equals("") && jkxlh != null) {
			TestRestSafeOutAccess.jkxlh = jkxlh;
		}
		if (!babh.equals("") && babh != null) {
			TestRestSafeOutAccess.babh = babh;
		}
		if (!mac.equals("") && mac != null) {
			TestRestSafeOutAccess.mac = mac;
		}
	}

	// public static void main(String[] args) throws Exception {
	// get();
	// TestRestSafeOutAccess roas= new TestRestSafeOutAccess();
	// roas.queryGlobalParams();
	// }
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
	public static String TenToHex(BigDecimal n) {
		String a;
		a = Long.toHexString(n.longValue());
		System.out.println(n.longValue());
		StringBuilder sb = new StringBuilder(padLeft(a, 12));
		a = sb.insert(4, '.').insert(0, "0x").toString();
		return a;
	}

	/**
	 * 文件置空
	 * 
	 * @param file
	 * @return
	 */
	public static boolean fileEquealNull(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(0);
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	static SimpleDateFormat startEpoch = new SimpleDateFormat("MM/dd/YYYY::hh:mm:ss");

	public static void main(String[] args) throws Exception {
		
		
//		get();
//		Hdsjjk jk = new Hdsjjk();
//		jk.queryGlobalParams();
//		jk.querysjtjcl();
		File  userdir = new   File("C:\\Users\\Administrator\\Desktop\\MDK_0424\\ceshi");
		File[] files = userdir.listFiles();
		for (int j = 0; j < files.length; j++) {
			File file = files[j];
			 AbcUtil.unZipDesFromBase64File(file.getAbsolutePath(),
					 file.getAbsolutePath());
		}
//		long used = userdir.getUsableSpace()*100/userdir.getTotalSpace();
//		System.out.println(used<70);0be880f3
//		JDBCUtil jdbc = new JDBCUtil("admin_test", "admin_test", "10.2.42.114", "1521", "orcl");
//		
//		jdbc.getConnection(true);
//		jdbc.closeDB();
//		
//		File  file = new File(FilePathName.ROOT);
//		System.out.println(Math.ceil((file.getTotalSpace()-file.getFreeSpace())*100/file.getTotalSpace()));
//		JDBCUtil jdbc = new JDBCUtil("admin_test", "admin_test", "10.2.42.114", "1521", "orcl");
//		jdbc.getConnection();
//		for (int i = 0; i < 1000; i++) {
//			String update = "insert into  frm_log (a,f) values ('"+i+"' , '"+i+"') ";
//			jdbc.executeUpdate(update);
//			Thread.sleep(100);	
//		}
//		jdbc.closeDB();
//		System.out.println(TenToHex((long) 175124886));;
////		SAXReader reader = new SAXReader();34   63125
////		Document doc = reader.read("D:\\test\\A0x0000.06DFEC5F.log");
////		Element rootelement = doc.getRootElement();0022f695
////		if (rootelement.elementIterator("SCN").hasNext()) {
////		} else {0022f879
////		}
//		// SAXCreate sax =new SAXCreate();
//		// sax.createXMLHead("D:\\0000011000220190327000007", false);
//		// sax.createXMLEnd(false);
//		// sax.createXMLHead("D:\\0000011000220190327000007", false);
//		// sax.createXMLEnd(false);
//		// String scn = "60851739";
//		 System.out.println(TenToHex(new BigDecimal("15900837936490")));
//		// System.out.println(startEpoch.format(new Date()));
		 AbcUtil.unZipDesFromBase64File("D:\\test\\0000011000320190605000001",
		 "D:\\test\\0000011000320190605000001");
//		 AbcUtil.unZipDesFromBase64File("D:\\test\\6500016000220190521000018",
//				 "D:\\test\\6500016000220190521000018");
//		 AbcUtil.unZipDesFromBase64File("D:\\test\\6500016000220190521000019",
//				 "D:\\test\\6500016000220190521000019");
//		System.out.println(new String(strn)+""+new String(strn).length());
//		Map<String, Object> gdStatus = new HashMap<>();
//		Map<String, Object> gdStatus1 = new HashMap<>();
//		gdStatus.put("thread1", "2019/05/10 13:10:20");
//		gdStatus.put("thread2", "2019/05/10 13:10:20");
//		String num = JsonToObject.MapconsvertToJson(gdStatus).toJSONString();
//		System.out.println(num);
//		gdStatus1=JsonToObject.JSONconsvertToMap(JsonToObject.StringconsvertToJSONObject(num));
//		String sql = "select * from clsjwjb";
//		List list = jdbc.executeQuery(sql, null);
//		System.out.println(JsonToObject.ListconsvertToJSON(list));
//		for (int i = 0; i < 100; i++) {
//			for (int j = 0; j < 5; j++) {
//				if (j==4) {
//					break;
//				}else{
//					System.out.println(j);
//				}
//			}
//		}
//		 get();
//		 TestRestSafeOutAccess rds = TestRestSafeOutAccess.getInstance();
//		 TestRestSafeOutAccess.rdsStatus();
	}

	/**
	 * 测试 剩余增量三个接口
	 * 
	 * @param utilDate
	 * @return
	 */
//	 public static void main(String[] args) throws Exception {
//
	// List<Zlsjwjb> zlwjlist = new ArrayList<>();
	// Zlsjwjb zlwj = new Zlsjwjb();
	// zlwj.setGxsj(getTime(new Date()));
	// zlwj.setJgxtlb("1000");
	// zlwj.setMd5("feeda3e042fd58880c95ba8ed857c2e4");
	// zlwj.setWjdx(new BigDecimal("20973272"));
	// zlwj.setWjm("0000011000220190308000001");
	// zlwj.setScnq(new BigDecimal("123456"));
	// zlwj.setScnz(new BigDecimal("234567"));
	// zlwj.setSeqq(new BigDecimal(125));
	// zlwj.setSeqz(new BigDecimal(256));
	// zlwj.setSywjm("begin");
	// zlwj.setXywjm("0000011000220190226000002");
	// zlwj.setWjzt("2");
	// zlwj.setScfwqsj(getTime(new Date()));
	// zlwj.setCwzt("0");
	// zlwj.setScsj(getTime(new Date()));
	// zlwj.setSjlinsert(new BigDecimal(200));
	// zlwj.setSjldelete(new BigDecimal(200));
	// zlwj.setSjlupdate(new BigDecimal(200));
	// zlwjlist.add(zlwj);
	// rds.buildNewFilenameJson(JsonToObject.ListconsvertToJSON(zlwjlist));
	// System.out.println("增量文件表");
	// rds.queryNewDataFileStatus(JsonToObject.ListconsvertToJSON(zlwjlist));
	// System.out.println("增量断点表");
	// //zldd
	// Zlsjddb zldd = new Zlsjddb();
	// zldd.setJgxtlb("1000");
	// zldd.setGxsj(getTime(new Date()));
	// zldd.setScn(new BigDecimal("123456"));
	// zldd.setSeq(new BigDecimal(125));
	// List<Zlsjddb> ddlist = new ArrayList<>();
	// ddlist.add(zldd);
	// //ddl
	// Ddlsjsjb ddl = new Ddlsjsjb();
	// ddl.setJgxtlb("1000");
	// ddl.setScn(new BigDecimal(156));
	// ddl.setSeq(new Long(15203215));
	// ddl.setOraschema("CESHI");
	// ddl.setOrauser("CESHI");
	// ddl.setCzlx("01");
	// ddl.setCzsj(getTime(new Date()));
	// ddl.setDxlx("01");
	// ddl.setDxm("TEST_TABLE");
	// ddl.setNr("CREATE TABLE TEST_TABLE (test1 VARCHAR(2))");
	// List<Ddlsjsjb> ddsjlist = new ArrayList<>();
	// rds.buildDDLDataJson(JsonToObject.ListconsvertToJSON(ddsjlist));
//	 }
	public static Timestamp getTime(Date utilDate) {
		Timestamp sqlDate = new Timestamp(utilDate.getTime());// util.Date转sql.Date
		return sqlDate;
	}
}
