package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.model.Dbrzcjcs;
import com.arshiner.service.DbrzcjcsService;
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
 * @Description: (单表日志采集参数)
 */
@Controller
@RequestMapping("/singleTableController")
public class SingleTableController {


    @Autowired
    private DbrzcjcsService dbrzcjcsService;

    /*
     * 查询全部信息
     * */
    @ResponseBody
    @RequestMapping(value = "/selAllSingleTable",produces = "text/plain;charset=utf-8")
    public Object selAllSingleTable(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        HashMap<String,Object> singTabMap = new HashMap<String,Object>();
        List<Dbrzcjcs> singTabList = dbrzcjcsService.selAllSingleTable(before,after);
        singTabMap.put("code",0);
        singTabMap.put("msg", "");
        singTabMap.put("count",dbrzcjcsService.countSingleTable());
        Object obj = JSONArray.toJSON(singTabList);
        singTabMap.put("data", obj);
        return JSONArray.toJSONString(singTabMap);
    }

    /*
     * 含带条件查询信息
     * */
    @ResponseBody
    @RequestMapping("/selSingTabByParam")
    public Object selSingTabByParam(@RequestParam("page") String page1, @RequestParam("limit")String limit1,@RequestParam("param1")String param1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        HashMap<String,Object> singTabMap = new HashMap<String,Object>();
        List<Dbrzcjcs> singTabList = dbrzcjcsService.selSingTabByParam(before,after,param1);
        singTabMap.put("code",0);
        singTabMap.put("msg", "");
        singTabMap.put("count",dbrzcjcsService.countSingleTableByParam(param1));
        Object obj = JSONArray.toJSON(singTabList);
        singTabMap.put("data", obj);
        return JSONArray.toJSONString(singTabMap);
    }
}
