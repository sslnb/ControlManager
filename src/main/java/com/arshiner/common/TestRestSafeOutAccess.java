package com.arshiner.common;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arshiner.common.RestSafeRequestRds;
import com.arshiner.model.Clsjwjb;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Exeception;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.Zlsjwjb;
import com.arshiner.quartz.service.ScheduleJobInService;
import com.arshiner.service.ClsjwjbService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.ExeceptionService;
import com.arshiner.service.RzcjqjcsService;
import com.arshiner.service.ZlsjwjbService;
import com.tmri.bigdata.util.abc.AbcUtil;

public class TestRestSafeOutAccess {
	protected static final Logger logger = Logger.getLogger(TestRestSafeOutAccess.class);
	public static String agxtip = "";
	public static String agxtport = "";
	public static String jklb = "";
	public static String jkxlh = "";
	public static String babh = "";
	public static String mac = "";
	public static int statusCode = 0;
	protected static TestRestSafeOutAccess trconfig = new TestRestSafeOutAccess();
	static ConfigManager config = new ConfigManager(ConfigManager.babh);
	protected static String user;
	protected static String pwd;
	protected static String url;
	protected static JDBCUtil jdbc;
	/**
	 * 单表日志采集参数
	 */
	protected DbrzcjcsService dbrzcjcsService;
	protected ScheduleJobInService  scheduleJobInService;
	/**
	 * 日志采集全局参数
	 */
	protected RzcjqjcsService rzcjqjcsService;
	protected ClsjwjbService clsjwjbService;
	protected ZlsjwjbService zlsjwjbService;
	protected ExeceptionService execeptionService;
	public static TestRestSafeOutAccess getInstance() {
		if (trconfig == null) {
			trconfig = new TestRestSafeOutAccess();
		}
		return trconfig;
	}
	/**
	 * 刷新备案编号
	 */
	static {
		config= new ConfigManager(ConfigManager.babh);
		String ip = config.properties.getProperty("agxtip");
		String port = config.properties.getProperty("agxtport");
		String jkxlh = config.properties.getProperty("jkxlh");
		String babh = config.properties.getProperty("babh");
		String mac = config.properties.getProperty("mac");
		config = new ConfigManager(ConfigManager.jdbc);
		user = config.properties.getProperty("user");
		pwd = config.properties.getProperty("pwd");
		url = config.properties.getProperty("url");
		jdbc =  new JDBCUtil(user, pwd, url, "1521", "orcl");
		config= new ConfigManager(ConfigManager.babh);
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
	public TestRestSafeOutAccess (){
		config= new ConfigManager(ConfigManager.babh);
		String ip = config.properties.getProperty("agxtip");
		String port = config.properties.getProperty("agxtport");
		String jkxlh = config.properties.getProperty("jkxlh");
		String babh = config.properties.getProperty("babh");
		String mac = config.properties.getProperty("mac");
		config = new ConfigManager(ConfigManager.jdbc);
		user = config.properties.getProperty("user");
		pwd = config.properties.getProperty("pwd");
		url = config.properties.getProperty("url");
		jdbc =  new JDBCUtil(user, pwd, url, "1521", "orcl");
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
	public static String writeObjectRds(String jklb, String jkxlh, String jkid, String babh, String mac,
			String UTF8Json) throws Exception {
		String retStr = "";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = null;
		if (jkid.indexOf("81Q") > -1) {
			post = new HttpPost("http://" + agxtip + ":" + agxtport + "/bigweb/restSafeAccess.ews?method=queryRdsOut");
		} else {
			post = new HttpPost("http://" + agxtip + ":" + agxtport + "/bigweb/restSafeAccess.ews?method=writeRdsOut");
		}
		// 请求明细
		RestSafeRequestRds restSafeRequest = new RestSafeRequestRds();
		restSafeRequest.setBabh(babh);
		restSafeRequest.setWkmac(mac);
		// 补充其他参数信息
		restSafeRequest.setJkxlh(jkxlh);
		restSafeRequest.setJkid(jkid);
		String fwsj = AbcUtil.dateNow2str();
		restSafeRequest.setFwsj(fwsj);
		restSafeRequest.setVersion("v1.1");
		// 结果集
		restSafeRequest.setParams(UTF8Json);
		String params = "";
		try {
			// 加密串Base64加密
			params = AbcUtil.encryptMessage(restSafeRequest.getParams(), restSafeRequest.getJkxlh());

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		restSafeRequest.setParams(params);
		// 构造业务流水号
		String ywlsh = calYwlsh(restSafeRequest);
		restSafeRequest.setYwlsh(ywlsh);

		StringEntity entity = new StringEntity(JSON.toJSONString(restSafeRequest), Charset.forName("UTF-8"));
		entity.setContentType("application/json");
		post.setEntity(entity);
		try {
			// 设置超时时间长短
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000)
					.setConnectionRequestTimeout(2000).setSocketTimeout(1000).build();
			post.setConfig(requestConfig);
			HttpResponse response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			logger.info(statusCode);
			if (statusCode == 200) {
				retStr = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			}
			TestRestSafeOutAccess.statusCode = statusCode;
		} catch (IOException e) {
		}
		return retStr;
	}

	public static String getObjectRdsStatus(String jkid, String UTF8Json) throws Exception {
		String retStr = "";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = null;
		if (jkid.indexOf("81Q") > -1) {
			post = new HttpPost("http://" + agxtip + ":" + agxtport + "/bigweb/restSafeAccess.ews?method=queryRdsOut");
		} else {
			post = new HttpPost("http://" + agxtip + ":" + agxtport + "/bigweb/restSafeAccess.ews?method=writeRdsOut");
		}
		// 请求明细
		RestSafeRequestRds restSafeRequest = new RestSafeRequestRds();
		restSafeRequest.setBabh(babh);
		restSafeRequest.setWkmac(mac);
		// 补充其他参数信息
		restSafeRequest.setJkxlh(jkxlh);
		restSafeRequest.setJkid(jkid);
		String fwsj = AbcUtil.dateNow2str();
		restSafeRequest.setFwsj(fwsj);
		restSafeRequest.setVersion("v1.1");
		// 结果集
		restSafeRequest.setParams(UTF8Json);
		String params = "";
		try {
			// 加密串Base64加密
			params = AbcUtil.encryptMessage(restSafeRequest.getParams(), restSafeRequest.getJkxlh());

		} catch (Exception ex) {
		}
		restSafeRequest.setParams(params);
		// 构造业务流水号
		String ywlsh = calYwlsh(restSafeRequest);
		restSafeRequest.setYwlsh(ywlsh);
		StringEntity entity = new StringEntity(JSON.toJSONString(restSafeRequest), Charset.forName("UTF-8"));
		entity.setContentType("application/json");
		post.setEntity(entity);
		try {
			// 设置超时时间长短
			RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(1000)
					.setConnectionRequestTimeout(1000).setSocketTimeout(1000).build();
			post.setConfig(requestConfig);
			HttpResponse response = client.execute(post);
			int statusCode = response.getStatusLine().getStatusCode();
			logger.info(statusCode);
			if (statusCode == 200) {
				retStr = IOUtils.toString(response.getEntity().getContent(), "UTF-8");
			}

			TestRestSafeOutAccess.statusCode = statusCode;
		} catch (IOException e) {
			logger.error("接口不通！！！！！！");
		}
		retStr = statusCode + "";
		return retStr;
	}

	/**
	 * 接口信息获取
	 * 
	 * @return
	 */
	public static Map<String, String> rdsStatus() {
		Map<String, String> statusMap = new HashMap<>();
		String UTF8Json = "[{}]";
		for (int i = 1; i <= 4; i++) {
			String jkid = "81Q0" + i;
			try {
				String result = getObjectRdsStatus(jkid, UTF8Json);
				statusMap.put(jkid, result);
			} catch (Exception e) {
			}
		}
		for (int i = 1; i <= 9; i++) {
			String jkid = "81W0" + i;
			try {
				String result = getObjectRdsStatus(jkid, UTF8Json);
				statusMap.put(jkid, result);
			} catch (Exception e) {
			}
		}
		return statusMap;
	}

	// 1.日志采集全局参数查询接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<String, Object> queryGlobalParams() throws Exception {
		String jkid = "81Q01";
		String UTF8Json = "[{}]";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, UTF8Json);
		if (result.equals("")) {
			return null;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("0")) {
			return null;
		}
		if (!map.get("code").toString().equals("0") && !data.equals("") && !data.equals("null")) {
			try {
				// STR 转 jsonArray
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Rzcjqjcs record = new Rzcjqjcs();
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								try {
									record = (Rzcjqjcs) JsonToObject.mapToObject(map3, Rzcjqjcs.class);
									// 插入
									rzcjqjcsService.saveorupdate(record);

								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		} else {
		}
		return map;
	}

	// 2.日志采集单表参数查询接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void querySingleParams() throws Exception {
		String jkid = "81Q02";
		String UTF8Json = "[{}]";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, UTF8Json);
		if (!result.equals("")) {
		} else {
			return;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (!map.get("code").toString().equals("0") && !data.equals("") && !data.equals("null")) {
			try {
				// STR 转 jsonArray
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Dbrzcjcs record;
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								try {
									record = (Dbrzcjcs) JsonToObject.mapToObject(map3, Dbrzcjcs.class);
									// 插入
									dbrzcjcsService.saveorupdate(record);
								} catch (Exception e) {
								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
	}



	/**
	 * 
	 * @param param
	 *            数据格式
	 * @throws Exception
	 */
	// 3.存量数据日志解析文件状态反馈接口
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String queryOldDataFileStatus(String param,String oldpath,String filepath) throws Exception {
		String jkid = "81Q03";
		String flag ="-1";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("存量数据日志解析文件状态反馈接口获取参数失败： ");
			return flag;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		Clsjwjb record = new Clsjwjb();
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		logger.info("存量数据日志解析文件状态反馈接口参数刷新成功");
		JSONArray myJsonArray = JSONArray.parseArray(data);
		List<Map<String, Object>> mapListJson = (List) myJsonArray;
		if (mapListJson==null) {
			return flag;
		}
		for (Map<String, Object> map2 : mapListJson) {
			for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
				Entry<String, Object> entry = it.next();
				if (entry.getKey().equals("list")) {
					List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
					if (listmap.isEmpty()) {
						return flag;
					}
					for (Map<String, Object> map3 : listmap) {
						record.setWjm(map3.get("wjm").toString());

						record.setWjzt(map3.get("wjzt").toString());
						if (record.getWjzt().equals("3")) {
							record.setScbjsj(getTime());
							clsjwjbService.updateByExample(record);
						}
						if (record.getWjzt().equals("4")) {
							record.setRksj(getTime());
							clsjwjbService.updateByWjzt(record);
							File file = null;
							List<Clsjwjb> cllist = clsjwjbService.selectOrderbyWJM(record);
							for (Iterator iterator = cllist.iterator(); iterator.hasNext();) {
								Clsjwjb clsjwjb = (Clsjwjb) iterator.next();
								file = new File(FilePathName.ROOT+FilePathName.CLStanbyPath+FilePathName.FileSepeartor+clsjwjb.getWjm());
								if (file.exists()) {
									file.renameTo(new File(FilePathName.ROOT+FilePathName.CLDIDPath+FilePathName.FileSepeartor+clsjwjb.getWjm()));
								}
							}
							
						}
						if (!record.getWjzt().equals("2")&&!record.getWjzt().equals("4")
								&&!record.getWjzt().equals("3")) {
							record.setSbzt("0");
							clsjwjbService.updateByExample(record);
							flag ="0";
						}
					}
				}
			}
		}
		return flag;
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

	/**
	 * // 4.增量数据日志解析文件状态反馈接口 param 格式未知
	 * 
	 * @param param
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public void queryNewDataFileStatus(String param,String oldpath,String filepath) throws Exception {
		String jkid = "81Q04";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("增量数据日志解析文件状态反馈接口获取参数失败： ");
			return;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
			
		} catch (Exception e) {
		}
			if (data==null) {
				return ;
			}
			try {
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Zlsjwjb record = new Zlsjwjb();;
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								try {
									record.setWjm(map3.get("wjm").toString());
									record.setWjzt(map3.get("wjzt").toString());
									if (record.getWjzt().equals("3")) {
										record.setScbjsj(getTime());
										zlsjwjbService.updateByExampleSelective(record);
									}
									if (record.getWjzt().equals("4")) {
										record.setRksj(getTime());
										zlsjwjbService.updateByWjzt(record);
										File file = null;
										List<Zlsjwjb> zllist = zlsjwjbService.selectOrderByWjm(record);
										for (Iterator<Zlsjwjb> iterator = zllist.iterator(); iterator.hasNext();) {
											Zlsjwjb zlsjwjb = (Zlsjwjb) iterator.next();
											file = new File(FilePathName.ROOT+FilePathName.ZLStanbyPath+FilePathName.FileSepeartor+zlsjwjb.getWjm());
											if (file.exists()) {
												file.renameTo(new File(FilePathName.ROOT+FilePathName.ZLDIDPath+FilePathName.FileSepeartor+zlsjwjb.getWjm()));
											}
										}
									}
									if (!record.getWjzt().equals("3")&&!record.getWjzt().equals("2")&&!record.getWjzt().equals("4")) {
										record.setSbzt("0");
										zlsjwjbService.updateByExampleSelective(record);
									}
								} catch (Exception e) {
								}
							}
						}
					}
				}
			} catch (Exception e) {
				logger.info(e);
			}
	}

	/**
	 * // 5.采集软件心跳状态上报接口
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> writeHeartBeat(String param) throws Exception {
		String jkid = "81W01";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		JSONObject json = JsonToObject.StringconsvertToJSONObject(result);
		Map<String, Object> object = JsonToObject.JSONconsvertToMap(json);
		return object;
	}

	/**
	 * // 6.采集软件运行状态写入接口
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void buildTaskStatusJson(String param) throws Exception {
		String jkid = "81W02";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
			JSONObject jsonObject = JSON.parseObject(result);
			Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
			if (map.get("code").toString().equals("1")) {
				logger.info("采集软件运行状态写入接口获取参数刷新成功");
			} else {
				logger.info(map.get("message"));
				logger.info("采集软件运行状态写入接口获取参数失败");
			}
		} else {
			logger.info("采集软件运行状态写入接口获取参数失败： ");
			return;
		}
	}

	/**
	 * // 7.存量数据处理状态写入接口
	 * 
	 * @param param
	 * @throws Exception
	 */
	public String buildOldDataStatusinfoJson(String param) throws Exception {
		String jkid = "81W03";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("存量数据处理状态写入接口获取参数失败： ");
			return "";
		}
		logger.info(result);
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		logger.info(map.get("code"));
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1")) {
			logger.info("存量数据处理状态写入接口参数刷新成功");
		} else {
			Exeception record = new Exeception();
			record.setJgxtlb(jkid);
			record.setJobname("code"+map.get("code").toString()+":"+map.get("message").toString());
			record.setDesciption(data);
			execeptionService.saveOrupdate(record);
			logger.info(result);
			logger.info("存量数据处理状态写入接口81w03获取参数失败");
		}
		return map.get("code").toString();
	}

	/**
	 * // 8.存量数据块断点写入接口
	 * 
	 * @param param
	 * @throws Exception
	 */
	public String buildOldDataBrkinfoJson(String param) throws Exception {
		String jkid = "81W04";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("存量数据块断点写入接口获取参数失败： ");
			return "";
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1")) {
			logger.info("存量数据块断点写入接口参数刷新成功");
		} else {
			logger.info(result);
			Exeception record = new Exeception();
			record.setJgxtlb(jkid);
			record.setJobname("code"+map.get("code").toString()+":"+map.get("message").toString());
			record.setDesciption(data);
			execeptionService.saveOrupdate(record);
			logger.info("存量数据块断点写入接口获取参数失败");
		}
		return map.get("code").toString();
	}

	/**
	 * // 9.存量数据文件信息写入接口
	 * 
	 * @param param
	 * @throws Exception
	 */
	public String  buildOldFilenameJson(String param) throws Exception {
		String jkid = "81W05";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("存量数据文件信息写入接口获取参数失败： ");
			return "";
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1") && null!=data) {
			logger.info("存量数据文件信息写入接口参数刷新成功");
		} else {
			Exeception record = new Exeception();
			record.setJgxtlb(jkid);
			record.setJobname("code"+map.get("code").toString()+":"+map.get("message").toString());
			record.setDesciption(data);
			execeptionService.saveOrupdate(record);
			logger.info(result);
			logger.info("存量数据文件信息写入接口获取参数失败");
		}
		return map.get("code").toString();
	}

	/**
	 * // 10.增量数据断点写入接口
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void buildNewDataBrkinfoJson(String param) throws Exception {
		String jkid = "81W06";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("增量数据断点写入接口获取参数失败： ");
			return;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		logger.info(map.get("code"));
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1")) {
			logger.info("增量数据断点写入接口参数刷新成功");
		} else {
			Exeception record = new Exeception();
			record.setJgxtlb(jkid);
			record.setJobname("code"+map.get("code").toString()+":"+map.get("message").toString());
			record.setDesciption(data);
			execeptionService.saveOrupdate(record);
			logger.info(result);
			logger.info("增量数据断点写入接口81W06获取参数失败");
		}
	}

	/**
	 * // 11.增量数据文件信息写入接口
	 * 
	 * @param param
	 * @throws Exception
	 */
	public void buildNewFilenameJson(String param) throws Exception {
		String jkid = "81W07";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
		} else {
			logger.info("增量数据文件信息写入接口获取参数失败： ");
			return;
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1") && !data.equals("null")) {
			logger.info("增量数据文件信息写入接口参数刷新成功");
		} else {
			Exeception record = new Exeception();
			record.setJgxtlb(jkid);
			record.setJobname("code"+map.get("code").toString()+":"+map.get("message").toString());
			record.setDesciption(data);
			execeptionService.saveOrupdate(record);
			logger.info(result);
			logger.info("增量数据文件信息写入接口获取参数失败");
		}
	}

	/**
	 * // 12.DDL数据审计信息写入接口
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public void buildDDLDataJson(String param) throws Exception {
		String jkid = "81W08";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
	}
	/**
	 * // 13.数据采集情况统计信息写入接口
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> buildGatherStatisticsJson(String param) throws Exception {
		String jkid = "81W09";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		JSONObject json = JsonToObject.StringconsvertToJSONObject(result);
		Map<String, Object> object = JsonToObject.JSONconsvertToMap(json);
		return object;
	}

	
	/**
	 * 写入方法转成json
	 * 
	 * @param list
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	public static String paraseParams(List list) {
		return JsonToObject.ListconsvertToJSON(list);
	}


	private static String calYwlsh(RestSafeRequestRds restSafeRequest) {
		StringBuilder sb = new StringBuilder();
		sb.append(restSafeRequest.getJkxlh());
		sb.append(restSafeRequest.getJkid());
		sb.append(restSafeRequest.getFwsj());
		if (restSafeRequest.getVersion() != null) {
			sb.append(restSafeRequest.getVersion());
		}
		sb.append(restSafeRequest.getParams());
		String ret = AbcUtil.MD5(sb.toString());
		return ret;
	}

	public DbrzcjcsService getDbrzcjcsService() {
		return dbrzcjcsService;
	}

	public ZlsjwjbService getZlsjwjbService() {
		return zlsjwjbService;
	}

	public void setZlsjwjbService(ZlsjwjbService zlsjwjbService) {
		this.zlsjwjbService = zlsjwjbService;
	}

	public void setDbrzcjcsService(DbrzcjcsService dbrzcjcsService) {
		this.dbrzcjcsService = dbrzcjcsService;
	}

	public RzcjqjcsService getRzcjqjcsService() {
		return rzcjqjcsService;
	}

	public void setRzcjqjcsService(RzcjqjcsService rzcjqjcsService) {
		this.rzcjqjcsService = rzcjqjcsService;
	}

	public ClsjwjbService getClsjwjbService() {
		return clsjwjbService;
	}

	public void setClsjwjbService(ClsjwjbService clsjwjbService) {
		this.clsjwjbService = clsjwjbService;
	}
	public ExeceptionService getExeceptionService() {
		return execeptionService;
	}
	public void setExeceptionService(ExeceptionService execeptionService) {
		this.execeptionService = execeptionService;
	}

}
