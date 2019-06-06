package com.arshiner.rds_big_jk;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.model.Exeception;
import com.arshiner.model.Hdsjcjxxb;
import com.arshiner.model.Hdsjwjxxb;
import com.arshiner.model.Sjltjdjb;
import com.arshiner.service.HdsjcjxxbService;
import com.arshiner.service.HdsjwjxxbService;
import com.arshiner.service.SjltjdjbService;
import com.arshiner.service.SjltjjgService;

/**
 * 核对功能接口
 * 
 * @author MSI-PC
 *
 */
public class Hdsjjk extends TestRestSafeOutAccess {
	private static final Logger logger = Logger.getLogger(Hdsjjk.class);
	private HdsjcjxxbService hdsjcjxxbService;
	private HdsjwjxxbService hdsjwjxxbService;
	private SjltjdjbService sjltjdjbService;
	private SjltjjgService sjltjjgService;

	// 14，数据统计策略查询接口
	public void querysjtjcl() throws Exception {
		String jkid = "81Q05";
		String UTF8Json = "[{}]";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, UTF8Json);
		if (!result.equals("")) {
		} else {
			return;
		}
		logger.info("数据量统计登记表接口" + result);
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1") && !data.equals("") && !data.equals("null")) {
			try {
				// STR 转 jsonArray
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Sjltjdjb record;
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								try {
									record = (Sjltjdjb) JsonToObject.mapToObject(map3, Sjltjdjb.class);
									// 插入
									sjltjdjbService.saveOrupdate(record);
								} catch (Exception e) {
									e.printStackTrace();
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

	// 15 新增数据统计结果写入接口
	public void buildhdsjtjjg(String param) throws Exception {
		String jkid = "81W10";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		logger.info("数据统计结果写入接口：" + result);
		if (!result.equals("")) {
			JSONObject jsonObject = JSON.parseObject(result);
			Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
			String data = "";
			try {
				data = (String) map.get("data");
			} catch (Exception e) {
			}
			if (map.get("code").toString().equals("1")) {
				System.out.println("数据核对统计写入接口获取参数刷新成功");
			} else {
				Exeception record = new Exeception();
				record.setJgxtlb(jkid);
				record.setJobname("code" + map.get("code").toString() + ":" + map.get("message").toString());
				record.setDesciption(data);
				execeptionService.saveOrupdate(record);
				System.out.println("数据核对统计写入接口获取参数失败");
			}
		} else {
			return;
		}
	}

	// 16 核对数据策略查询接口 采集信息
	public void queryHdsjcjxxb() throws Exception {
		String jkid = "81Q06";
		String UTF8Json = "[{}]";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, UTF8Json);
		if (!result.equals("")) {
		} else {
			return;
		}
		logger.info("核对数据采集信息表查询接口  采集信息" + result);
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		if (map.get("code").toString().equals("1") && !data.equals("") && !data.equals("null")) {
			try {
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Hdsjcjxxb record;
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								try {
									record = (Hdsjcjxxb) JsonToObject.mapToObject(map3, Hdsjcjxxb.class);
									// 插入
									if (record.getClwcbj().equals("1")) {
										record.setSbzt("2");
									} else {
										record.setSbzt("0");
									}
									hdsjcjxxbService.saveOrupdate(record);
								} catch (Exception e) {
									e.printStackTrace();
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

	// 17 核对数据采集信息写入接口
	public void bulidhdsjcl(String param) throws Exception {
		String jkid = "81W11";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
			JSONObject jsonObject = JSON.parseObject(result);
			Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
			String data = "";
			try {
				data = (String) map.get("data");
			} catch (Exception e) {
			}
			if (map.get("code").toString().equals("1")) {
				logger.info("核对数据采集信息写入接口" + result);
			} else {
				logger.info("核对数据采集信息写入接口" + result);
			}
		} else {
			System.out.println("核对数据采集信息写入接口获取参数失败： ");
			return;
		}
	}

	// 18 核对数据文件信息写入接口
	public void buildhdsjwjxr(String param) throws Exception {
		String jkid = "81W12";
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, param);
		if (!result.equals("")) {
			logger.info("核对数据文件信息写入接口：" + result);
			JSONObject jsonObject = JSON.parseObject(result);
			Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
			String data = "";
			try {
				data = (String) map.get("data");
			} catch (Exception e) {
			}
			if (map.get("code").toString().equals("1")) {
				System.out.println("核对数据文件信息写入接口获取参数刷新成功");
			} else {
				Exeception record = new Exeception();
				record.setJgxtlb(jkid);
				record.setJobname("code" + map.get("code").toString() + ":" + map.get("message").toString());
				record.setDesciption(data);
				execeptionService.saveOrupdate(record);
				System.out.println(map.get("message"));
				System.out.println("核对数据文件信息写入接口获取参数失败");
			}
		} else {
			System.out.println("核对数据文件信息写入接口获取参数失败： ");
			return;
		}
	}

	// 20 文件状态查询接口
	public void querywjztcx(String params) throws Exception {
		String jkid = "81Q07";
		String UTF8Json = params;
		String result = writeObjectRds(jklb, jkxlh, jkid, babh, mac, UTF8Json);
		if (!result.equals("")) {
		} else {
			return;
		}
		logger.info("文件状态查询接口：" + result);
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		try {
			data = (String) map.get("data");
		} catch (Exception e) {
		}
		// STR 转 jsonArray
		JSONArray myJsonArray = JSONArray.parseArray(data);
		List<Map<String, Object>> mapListJson = (List) myJsonArray;
		Hdsjwjxxb record;
		for (Map<String, Object> map2 : mapListJson) {
			for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
				Entry<String, Object> entry = it.next();
				if (entry.getKey().equals("list")) {
					List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
					for (Map<String, Object> map3 : listmap) {
						try {
							record = (Hdsjwjxxb) JsonToObject.mapToObject(map3, Hdsjwjxxb.class);
							if (!record.getWjzt().equals("2") && !record.getWjzt().equals("4")
									&& !record.getWjzt().equals("3")) {
								record.setSbzt("0");
								record.setGxsj(getTime());
							}
							hdsjwjxxbService.updateByExampleSelective(record);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}
		}
	}

	/**
	 * 核对功能主接口
	 */
	public void HdMain() {

	}

	public HdsjcjxxbService getHdsjcjxxbService() {
		return hdsjcjxxbService;
	}

	public void setHdsjcjxxbService(HdsjcjxxbService hdsjcjxxbService) {
		this.hdsjcjxxbService = hdsjcjxxbService;
	}

	public HdsjwjxxbService getHdsjwjxxbService() {
		return hdsjwjxxbService;
	}

	public void setHdsjwjxxbService(HdsjwjxxbService hdsjwjxxbService) {
		this.hdsjwjxxbService = hdsjwjxxbService;
	}

	public SjltjdjbService getSjltjdjbService() {
		return sjltjdjbService;
	}

	public void setSjltjdjbService(SjltjdjbService sjltjdjbService) {
		this.sjltjdjbService = sjltjdjbService;
	}

	public SjltjjgService getSjltjjgService() {
		return sjltjjgService;
	}

	public void setSjltjjgService(SjltjjgService sjltjjgService) {
		this.sjltjjgService = sjltjjgService;
	}

}
