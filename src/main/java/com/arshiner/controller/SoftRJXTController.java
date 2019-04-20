package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.model.Totalsysinfo;
import com.arshiner.service.TotalsysinfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Enernity
 * @date 2019-01-30  9:48
 */
@Controller
@RequestMapping(value = "/softRJXTController")
public class SoftRJXTController {



	/*自定义表*/
	@Resource
	private TotalsysinfoService totalSysinfoService;


	/*
	* 查询 <自定义表>
	* */
	@ResponseBody
	@RequestMapping(value = "/selInfo",produces = "text/plain;charset=utf-8")
	public Object selInfo(){
		Map<Object,Object> totalSysMap = new HashMap<>();
		List<Totalsysinfo> totalSysList = totalSysinfoService.allInfo();
		if (totalSysList==null){
			totalSysMap.put("code",0);		//无数据
		}else{
			totalSysMap.put("code",1);
			List<Object> cpuList = new ArrayList<>();
			List<Object> memList = new ArrayList<>();
			List<Object> devList = new ArrayList<>();
			List<Object> jvmList = new ArrayList<>();
			List<Object> sjList = new ArrayList<>();
			for (int i = 0; i<totalSysList.size();i++){
				Totalsysinfo totalSysInfo = totalSysList.get(i);
				cpuList.add(totalSysInfo.getCpu());
				memList.add(totalSysInfo.getMem());
				devList.add(totalSysInfo.getDev());
				jvmList.add(totalSysInfo.getJvm());
				sjList.add(totalSysInfo.getInstime());
			}
			totalSysMap.put("cpuList",cpuList);
			totalSysMap.put("memList",memList);
			totalSysMap.put("devList",devList);
			totalSysMap.put("jvmList",jvmList);
			/*获取当前时间点*/
			SimpleDateFormat dateFormat = new SimpleDateFormat("HH");
            /*获取当前时间用于判断*/
            int sj = new Date().getHours();
			for (int i = 0;i<sjList.size();i++){
				int listNum = new Integer(sjList.get(i).toString());
				/*遍历修改集合中日期,添加昨日今日*/
				if(0<=listNum&&listNum<=sj){
					sjList.set(i,"今日"+sjList.get(i)+"时");
				}else{
					sjList.set(i,"昨日"+sjList.get(i)+"时");
				}
			}
			totalSysMap.put("sjList",sjList);
		}
		return JSONArray.toJSONString(totalSysMap);
	}
}
