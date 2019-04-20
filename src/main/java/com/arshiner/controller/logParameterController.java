package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.model.Rzcjqjcs;
import com.arshiner.service.RzcjqjcsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author mdk
 * @Date: 15:43 2018/11/29
 * @Description: (日志采集全局参数)
 */
@Controller
@RequestMapping("/logParameterController")
public class logParameterController {

    @Autowired
    private RzcjqjcsService rzcjqjcsService;

    /*
    * 查询全部信息
    * */
    @ResponseBody
    @RequestMapping(value = "/selAllRzcjqjcs",produces = "text/plain;charset=utf-8")
    public Object selAllRzcjqjcs(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        HashMap<String,Object> RzcjMap = new HashMap<String,Object>();
        List<Rzcjqjcs> RzcjList = rzcjqjcsService.selAllRzcjqjcs(before,after);
        RzcjMap.put("code",0);
        RzcjMap.put("msg", "");
        RzcjMap.put("count",rzcjqjcsService.countRzcjqjcs());
        Object obj = JSONArray.toJSON(RzcjList);
        RzcjMap.put("data", obj);
        return JSONArray.toJSONString(RzcjMap);
    }

    @ResponseBody
    @RequestMapping("/alterZLMRCJZQ")
    public Object alterZLMRCJZQ(@RequestParam("timeValues") String timeValues){
    	 Rzcjqjcs rzcjqjcs = new Rzcjqjcs();
    	 rzcjqjcs.setGjz("ZLCJZQMRZ");
    	 rzcjqjcs.setCsmc("增量采集周期默认值");
    	 rzcjqjcs.setMrz(timeValues);
    	 rzcjqjcsService.saveorupdate(rzcjqjcs);
    	 HashMap<String,Object> RzcjMap = new HashMap<String,Object>();
    	 RzcjMap.put("code",0);
         RzcjMap.put("msg", "");
         return JSONArray.toJSONString(RzcjMap);
    }
}
