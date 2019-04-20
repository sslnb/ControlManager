package com.arshiner.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.arshiner.common.ConfigManager;
import com.arshiner.common.JsonToObject;
import com.arshiner.common.TestRestSafeOutAccess;
import com.arshiner.model.Babh;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.model.Exeception;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.model.ScheduleJob;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.BaBhService;
import com.arshiner.service.DbrzcjcsService;
import com.arshiner.service.ExeceptionService;
import com.arshiner.service.RzcjqjcsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author mdk
 * @Date: 15:28 2018/12/21
 * @Description: (类描述)
 */
@Controller
@RequestMapping(value = "/baBhController")
public class BaBhController {
	@Autowired
	ExeceptionService execeptionService;
	@Autowired
	private RzcjqjcsService rzcjqjcsService;
	@Autowired
	private DbrzcjcsService dbrzcjcsService;
	ConfigManager config = new ConfigManager(ConfigManager.babh);
	@Autowired
	SchedulerJobService schedulerJobService;

	/*
	 * 添加备案信息
	 */
	@ResponseBody
	@RequestMapping(value = "/insBaBh", produces = "text/plain;charset=utf-8")
	public Object insBaBh(@RequestParam("filingNumber") String babh, @RequestParam("interfaceSerialNum") String jkxlh,
			@RequestParam("activeStandbyIp") String ip, @RequestParam("port") String port,
			@RequestParam("macAddress") String mac) {
		HashMap<String, Object> baMap = new HashMap<String, Object>();
		int pd = 1;
		try {
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
			config.configGetAndSet("agxtip", ip, ConfigManager.babh);
			config.configGetAndSet("agxtport", port, ConfigManager.babh);
			config.configGetAndSet("jkxlh", jkxlh, ConfigManager.babh);
			config.configGetAndSet("babh", babh, ConfigManager.babh);
			config.configGetAndSet("mac", mac, ConfigManager.babh);
		} catch (Exception e1) {
			pd = 0;
		}
		if (pd != 0) {
			baMap.put("code", "1");
		} else {
			baMap.put("code", "0");
		}
		return JSONArray.toJSONString(baMap);
	}

	// 1.日志采集全局参数查询接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value = "/queryQJparams", produces = "text/plain;charset=utf-8")
	public Object queryQJparams() throws Exception {
		TestRestSafeOutAccess.agxtip = config.properties.getProperty("agxtip");
		TestRestSafeOutAccess.agxtport = config.properties.getProperty("agxtport");
		TestRestSafeOutAccess.jkxlh = config.properties.getProperty("jkxlh");
		TestRestSafeOutAccess.babh = config.properties.getProperty("babh");
		TestRestSafeOutAccess.mac = config.properties.getProperty("mac");
		HashMap<String, Object> baMap = new HashMap<String, Object>();
		String jkid = "81Q01";
		String UTF8Json = "[{}]";
		String result = TestRestSafeOutAccess.writeObjectRds(TestRestSafeOutAccess.jklb,
				config.properties.getProperty("jkxlh"), jkid, config.properties.getProperty("babh"),
				config.properties.getProperty("mac"), UTF8Json);
		if (!result.equals("")) {
		} else {
			System.out.println("获取参数失败： ");
		}
		JSONObject jsonObject = JSON.parseObject(result);
		Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
		String data = "";
		int pd = 0;
		try {
			data = (String) map.get("data");
			//抛异常
			if (map.get("code").toString().equals("1") && !data.equals("") && !data.equals("null")) {
				// STR 转 jsonArray
				JSONArray myJsonArray = JSONArray.parseArray(data);
				List<Map<String, Object>> mapListJson = (List) myJsonArray;
				Rzcjqjcs record;
				for (Map<String, Object> map2 : mapListJson) {
					for (Iterator<Entry<String, Object>> it = map2.entrySet().iterator(); it.hasNext();) {
						Entry<String, Object> entry = it.next();
						if (entry.getKey().equals("list")) {
							List<Map<String, Object>> listmap = (List<Map<String, Object>>) entry.getValue();
							for (Map<String, Object> map3 : listmap) {
								record = (Rzcjqjcs) JsonToObject.mapToObject(map3, Rzcjqjcs.class);
								// 插入
								rzcjqjcsService.saveorupdate(record);

							}
						}
					}
				}
				System.out.println("全局参数刷新成功");
			} else {
				System.out.println(map.get("message"));
				System.out.println("获取全局参数失败");
			}
			pd = 0;
		} catch (Exception e) {
            pd = 1;
		}
		if (pd != 0) {
			baMap.put("code", "1");
		} else {
			baMap.put("code", "0");
		}
		return JSONArray.toJSONString(baMap);
	}

	// 2.日志采集单表参数查询接口
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ResponseBody
	@RequestMapping(value = "/querySingleParams", produces = "text/plain;charset=utf-8")
	public Object querySingleParams() throws Exception {
		HashMap<String, Object> baMap = new HashMap<String, Object>();
		String jkid = "81Q02";
		String UTF8Json = "[{}]";
		String result = TestRestSafeOutAccess.writeObjectRds(TestRestSafeOutAccess.jklb,
				config.properties.getProperty("jkxlh"), jkid, config.properties.getProperty("babh"),
				config.properties.getProperty("mac"), UTF8Json);
        int pd = 1;
        JSONObject jsonObject = JSON.parseObject(result);
        Map<String, Object> map = JsonToObject.JSONconsvertToMap(jsonObject);
        String data = "";
		if (!result.equals("")) {
		    pd=0;
            try {
            	//动态添加底层配置
                data = (String) map.get("data");
                if (map.get("code").toString().equals("1") && !data.equals("") && !data.equals("null")) {
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
                                        
                                        dbrzcjcsService.saveorupdate(record);
                                        System.out.println(record.getCjsj().toString());
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    }
                    System.out.println("单表参数刷新成功");
                } else if (map.get("code").toString().equals("0")) {
                    System.out.println(map.get("message"));
                    System.out.println("单表获取参数失败");
                } else if (map.get("code").toString().equals("2")) {
                    System.out.println(map.get("message"));
                    System.out.println("单表获取参数失败");
                }
            } catch (Exception e) {
                pd = 1;
            }
		} else {
			System.out.println("获取参数失败： ");
		}



		if (pd != 0) {
			baMap.put("code", "1");
		} else {
			baMap.put("code", "0");
		}
		return JSONArray.toJSONString(baMap);
	}

	/*
	 * 授权信息
	 */
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping("/selAllBaBh")
	public Object selAllBaBh() {
		HashMap<String, Object> baMap = new HashMap<String, Object>();
		baMap.put("msg", "");
		baMap.put("count", 1);
		Babh babh = new Babh();
		if (!config.properties.getProperty("babh").equals("") && config.properties.getProperty("babh") != null) {
			baMap.put("code", 0);
		} else {
			baMap.put("code", -1);
		}
		if (!config.properties.getProperty("agxtip").equals("") && config.properties.getProperty("agxtip") != null) {
			baMap.put("code", 0);
		} else {
			baMap.put("code", -1);
		}
		if (!config.properties.getProperty("jkxlh").equals("") && config.properties.getProperty("jkxlh") != null) {
			baMap.put("code", 0);
		} else {
			baMap.put("code", -1);
		}
		if (!config.properties.getProperty("mac").equals("") && config.properties.getProperty("mac") != null) {
			baMap.put("code", 0);
		} else {
			baMap.put("code", -1);
		}
		if (!config.properties.getProperty("agxtport").equals("")
				&& config.properties.getProperty("agxtport") != null) {
			baMap.put("code", 0);
		} else {
			baMap.put("code", -1);
		}
		babh.setBabh(config.properties.getProperty("babh"));
		babh.setIp(config.properties.getProperty("agxtip"));
		babh.setJkxlh(config.properties.getProperty("jkxlh"));
		babh.setMac(config.properties.getProperty("mac"));
		babh.setPort(config.properties.getProperty("agxtport"));
		baMap.put("ba", JsonToObject.MapconsvertToJson((Map<String, Object>) JsonToObject.objectToMap(babh)));
		return JSONArray.toJSONString(baMap);
	}

}
