package com.arshiner.controller;

import com.alibaba.fastjson.JSONArray;
import com.arshiner.common.SystemInfo;
import com.arshiner.model.Exeception;
import com.arshiner.model.ScheduleJob;
import com.arshiner.quartz.service.SchedulerJobService;
import com.arshiner.service.ExeceptionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;

/**
 * @author mdk
 * @Date: 10:30 2018/11/23
 * @Description: (获取系统信息)
 */
@Controller
@RequestMapping("/sysController")
public class SysController {

    @Autowired
    ExeceptionService   execeptionService;
    @Autowired
    private SchedulerJobService schedulerJobService;

    
    
    //查询信息
    @ResponseBody
    @RequestMapping("/selSysInfo")
    public Object selSysInfo(){
        HashMap<String,Object> sysMap = new HashMap<String,Object>();
        HashMap<String,Object> heartMap = SystemInfo.getHeartInfo();
        HashMap<String,Object> sysInfoMap = SystemInfo.getSysInfo();
        List<ScheduleJob> jobList = schedulerJobService.getAllScheduleJob();   //任务信息
        int completedCount = 0;     //已完成任务
        int normalCount = 0;        //未完成任务
        int startCount = 0;        //运行中任务
        int pausedCount = 0;        //已停止任务
        if (jobList.size()>0) {
        	for(int i=0;i<jobList.size();i++){
                ScheduleJob scheduleJob = jobList.get(i);//获取每一个Example对象
                if (scheduleJob.getJobStatus().equals("COMPLETE")){
                    completedCount++;
                } else if (scheduleJob.getJobStatus().equals("START")) {
                    startCount++;
                } else if (scheduleJob.getJobStatus().equals("NORMAL")){
                    normalCount++;
                } else if (scheduleJob.getJobStatus().equals("PAUSED")){
                    pausedCount++;
                }
            }
		}
        sysMap.put("totalCount",jobList.size());        //任务总量
        sysMap.put("completedCount",completedCount);    //以完成
        sysMap.put("startCount",startCount);        //运行中
        sysMap.put("normalCount",normalCount);      //未执行
        sysMap.put("pausedCount",pausedCount);        //已停止
        sysMap.put("mem",heartMap.get("mem"));    //内存使用
        sysMap.put("swap",heartMap.get("swap"));    //交换区使用
        sysMap.put("jvm",heartMap.get("jvm"));    //jvm使用
        sysMap.put("cpu",heartMap.get("cpu"));    //cpu使用
        sysMap.put("dev",heartMap.get("dev"));    //磁盘使用
        sysMap.put("memNum",heartMap.get("mem").toString().substring(0,2));    //内存使用
        sysMap.put("cpuNum",heartMap.get("cpu").toString().substring(0,2));    //cpu使用
        sysMap.put("devNum",heartMap.get("dev").toString().substring(0,2));    //磁盘使用
        sysMap.put("jvmNum",heartMap.get("jvm").toString().substring(0,2));    //jvm使用
        sysMap.put("sysArch",sysInfoMap.get("arch"));    //系统名
        return JSONArray.toJSONString(sysMap);
    }


    /*
    * 系统详细信息
    * */
    @ResponseBody
    @RequestMapping("/sysMap")
    public Object sysMap() throws UnknownHostException {
        HashMap<String,Object> sysMap = SystemInfo.getSysMap();
        return JSONArray.toJSONString(sysMap);
    }
    /*
     * 后添加用于插入系统异常信息
     * 有异常时反馈前端弹出界面,
     * 再向异常信息中添加一条记录
     * */
     @ResponseBody
     @RequestMapping("/writeExcelTimonInfo")
     public Object writeExcelTimonInfo(){
         HashMap<String,Object> writMan = new HashMap<>();
         HashMap<String,Object> heartMap = SystemInfo.writExceptionInfo();
         double mem = Double.parseDouble(heartMap.get("mem").toString());
         double dev = Double.parseDouble(heartMap.get("dev").toString());
         double cpu = Double.parseDouble(heartMap.get("cpu").toString());
        /* SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
         System.out.println(df.format(new Date()));// new Date()为获取当前系统时间*/
         if(mem>90){
             String memInfo = "内存使用率超过90%";
             Exeception exception = new Exeception();
             exception.setDesciption(memInfo);
             exception.setJobname("error");
             //当前系统时间,Timestamp类型
             exception.setCreatetime(new Timestamp(System.currentTimeMillis()));
             execeptionService.insertSelective(exception);
             writMan.put("code",1);
             writMan.put("msg",memInfo);
         }
         if (dev>90){
             String devInfo = "磁盘使用率超过90%";
             Exeception exception = new Exeception();
             exception.setDesciption(devInfo);
             exception.setJobname("error");
             //当前系统时间,Timestamp类型
             exception.setCreatetime(new Timestamp(System.currentTimeMillis()));
             execeptionService.insertSelective(exception);
             writMan.put("code",1);
             writMan.put("msg",devInfo);
         }
         if (cpu>90){
             String couInfo = "cpu使用率超过90%";
             Exeception exception = new Exeception();
             exception.setDesciption(couInfo);
             exception.setJobname("error");
             //当前系统时间,Timestamp类型
             exception.setCreatetime(new Timestamp(System.currentTimeMillis()));
             execeptionService.insertSelective(exception);
             writMan.put("code",1);
             writMan.put("msg",couInfo);
         }
         return JSONArray.toJSONString(writMan);
     }

/*    @ResponseBody
    @RequestMapping("/dynamicLoadLine")
    public Object dynamicLoadLine(){
        HashMap<String,Object> dynamicMap = new HashMap<String,Object>();
        HashMap<String,Object> heartMap = SystemInfo.getHeartInfo();
        dynamicMap.put("mem",heartMap.get("mem").toString().substring(0,2));    //内存使用
        dynamicMap.put("cpu",heartMap.get("cpu").toString().substring(0,2));    //cpu使用
        *//*dynamicMap.put("mem",heartMap.get("mem"));    //内存使用
        dynamicMap.put("cpu",heartMap.get("cpu"));    //cpu使用*//*
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
        String times = df.format(new Date());
        dynamicMap.put("times",times);
        return JSONArray.toJSONString(dynamicMap);
    }*/

}
