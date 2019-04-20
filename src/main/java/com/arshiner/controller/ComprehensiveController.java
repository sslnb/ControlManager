package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.model.*;
import com.arshiner.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author mdk
 * @Date: 15:33 2018/11/30
 * @Description: (用于一些小的东西的查询)
 */
@Controller
@RequestMapping("/comprehensiveController")
public class ComprehensiveController {

    //存量数据文件
    @Autowired
    private ClsjwjbService clsjwjbService;

    //增量数据文件
    @Autowired
    private ZlsjwjbService zlsjwjbService;

    //DDL数据审计表
    @Autowired
    private DdlsjsjbService ddlsjsjbService;

    //存量数据处理状态
    @Autowired
    private ClsjclztService clsjclztService;

    //异常信息
    @Autowired
    private ExeceptionService execeptionService;


    /*
    * 存量文件信息(无查询分页)
    * */
    @ResponseBody
    @RequestMapping("/selAllclsjwj")
    public Object selAllclsjwj(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Clsjwjb> clwjList = clsjwjbService.selAllClsjwjb(before,after);
        HashMap<String,Object> clwjMap = new HashMap<String,Object>();
        clwjMap.put("code",0);
        clwjMap.put("msg", "");
        clwjMap.put("count",clsjwjbService.countClsjwjb());
        Object arry = JSONArray.toJSON(clwjList);
        clwjMap.put("data",arry);
        return JSONArray.toJSONString(clwjMap);
    }


    /*
     * 存量文件信息(有查询分页)   <待修改，添加了表名条件>
     * */
    @ResponseBody
    @RequestMapping("/selclsjwjByParam")
    public Object selclsjwjByParam(@RequestParam("page") String page1, @RequestParam("limit")String limit1,@RequestParam("param1")String param1,@RequestParam("param2")String param2){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Clsjwjb> clwjList = clsjwjbService.selClsjwjbByParam(before,after,param1,param2);
        HashMap<String,Object> clwjMap = new HashMap<String,Object>();
        clwjMap.put("code",0);
        clwjMap.put("msg", "");
        clwjMap.put("count",clsjwjbService.countClsjwjbByParam(param1,param2));
        Object arry = JSONArray.toJSON(clwjList);
        clwjMap.put("data",arry);
        return JSONArray.toJSONString(clwjMap);
    }

    /*
     * 增量文件信息(无查询分页)
     * */
    @ResponseBody
    @RequestMapping("/selAllzlsjwj")
    public Object selAllzlsjwj(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Zlsjwjb> zlwjList = zlsjwjbService.selAllZlsjwjb(before,after);
        HashMap<String,Object> zlwjMap = new HashMap<String,Object>();
        zlwjMap.put("code",0);
        zlwjMap.put("msg", "");
        zlwjMap.put("count",zlsjwjbService.countZlsjwjb());       //调用方法查询全部
        Object arry = JSONArray.toJSON(zlwjList);
        zlwjMap.put("data",arry);
        return JSONArray.toJSONString(zlwjMap);
    }

    /*
     * 增量文件信息(有查询分页)
     * */
    @ResponseBody
    @RequestMapping("/selzlsjwjByParam")
    public Object selzlsjwjByParam(@RequestParam("page") String page1, @RequestParam("limit")String limit1,@RequestParam("param1")String param1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Zlsjwjb> zlwjList = zlsjwjbService.selZlsjwjbByParam(before,after,param1);
        HashMap<String,Object> zlwjMap = new HashMap<String,Object>();
        zlwjMap.put("code",0);
        zlwjMap.put("msg", "");
        zlwjMap.put("count",zlsjwjbService.countZlsjwjbByParam(param1));
        Object arry = JSONArray.toJSON(zlwjList);
        zlwjMap.put("data",arry);
        return JSONArray.toJSONString(zlwjMap);
    }

    /*
     * DDL文件信息(无查询分页)
     * */
    @ResponseBody
    @RequestMapping("/selAllDdlsjsj")
    public Object selAllDdlsjsj(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Ddlsjsjb> ddlList = ddlsjsjbService.selAllDdlsjsj(before,after);
        HashMap<String,Object> ddlMap = new HashMap<String,Object>();
        ddlMap.put("code",0);
        ddlMap.put("msg", "");
        ddlMap.put("count",ddlsjsjbService.countDdlsjsj());
        Object arry = JSONArray.toJSON(ddlList);
        ddlMap.put("data",arry);
        return JSONArray.toJSONString(ddlMap);
    }

    /*
     * DDL文件信息(有查询分页)
     * */
    @ResponseBody
    @RequestMapping("/selDdlsjsjByParam")
    public Object selDdlsjsjByParam(@RequestParam("page") String page1, @RequestParam("limit")String limit1
            ,@RequestParam("param1")String param1,@RequestParam("param2")String param2,@RequestParam("param3")String param3){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Ddlsjsjb> ddlList = ddlsjsjbService.selDdlsjsjByParam(before,after,param1,param2,param3);
        HashMap<String,Object> ddlMap = new HashMap<String,Object>();
        ddlMap.put("code",0);
        ddlMap.put("msg", "");
        ddlMap.put("count",ddlsjsjbService.countDdlsjsjByParam(param1,param2,param3));
        Object arry = JSONArray.toJSON(ddlList);
        ddlMap.put("data",arry);
        return JSONArray.toJSONString(ddlMap);
    }

    /*
     * 存量数据处理状态(无查询分页)
     * */
    @ResponseBody
    @RequestMapping("/selAllClsjclzt")
    public Object selAllClsjclzt(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Clsjclzt> clztList = clsjclztService.selAllClsjclzt(before,after);
        HashMap<String,Object> clztMap = new HashMap<String,Object>();
        clztMap.put("code",0);
        clztMap.put("msg", "");
        clztMap.put("count",clsjclztService.countClsjclzt());
        Object arry = JSONArray.toJSON(clztList);
        clztMap.put("data",arry);
        return JSONArray.toJSONString(clztMap);
    }

    /*
     * 存量数据处理状态(有查询分页)
     * */
    @ResponseBody
    @RequestMapping("/selClsjclztByParam")
    public Object selClsjclztByParam(@RequestParam("page") String page1, @RequestParam("limit")String limit1
            ,@RequestParam("param1")String param1,@RequestParam("param2")String param2){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Clsjclzt> clztList = clsjclztService.selClsjclztByParam(before,after,param1,param2);
        HashMap<String,Object> clztMap = new HashMap<String,Object>();
        clztMap.put("code",0);
        clztMap.put("msg", "");
        clztMap.put("count",clsjclztService.countClsjclztByParam(param1,param2));
        Object arry = JSONArray.toJSON(clztList);
        clztMap.put("data",arry);
        return JSONArray.toJSONString(clztMap);
    }

    /*
    * 任务异常信息(无查询分页)
    * */
    @ResponseBody
    @RequestMapping( value = "/selAllExeception",produces = "text/plain;charset=utf-8")
    public Object selAllExeception(@RequestParam("page") String page1, @RequestParam("limit")String limit1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Exeception> execepList = execeptionService.selAllExeception(before,after);
        HashMap<String,Object> execepMap = new HashMap<String,Object>();
        execepMap.put("code",0);
        execepMap.put("msg", "");
        execepMap.put("count",execeptionService.countExeception());
        Object arry = JSONArray.toJSON(execepList);
        execepMap.put("data",arry);
        return JSONArray.toJSONString(execepMap);
    }

    /*
     * 任务异常信息(有查询分页)
     * */
    @ResponseBody
    @RequestMapping( value = "/haveSelExeception",produces = "text/plain;charset=utf-8")
    public Object haveSelExeception(@RequestParam("page") String page1, @RequestParam("limit")String limit1,@RequestParam("sel_1")String sel_1){
        int page = Integer.valueOf(page1);
        int limit = Integer.valueOf(limit1);
        int before = limit * (page - 1) + 1;
        int after = page * limit;
        List<Exeception> execepList = execeptionService.haveSelExeception(before,after,sel_1);
        HashMap<String,Object> execepMap = new HashMap<String,Object>();
        execepMap.put("code",0);
        execepMap.put("msg", "");
        execepMap.put("count",execeptionService.haveCountExeception(sel_1));
        Object arry = JSONArray.toJSON(execepList);
        execepMap.put("data",arry);
        return JSONArray.toJSONString(execepMap);
    }
}
