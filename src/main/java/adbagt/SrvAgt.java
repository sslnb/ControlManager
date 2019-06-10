/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adbagt;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.arshiner.common.ConfigFile;

/**
 *
 * @author William
 */
public class SrvAgt {

    static String gs_pid = "";                  //本进程
    static String gs_port = "";                 //端口
    static String gs_local = "";                //本地
    static String gs_os = "";                   //操作系统
    static String gs_start = "";                //启动时间
    static int iflag_capture = 0;               //抓取开关
    static int iflag_transmit = 0;              //传输开关
    static int iflag_apply = 0;                 //写入开关 
    static boolean is_debug = false;            //调试标识
    static String gs_captureinfo = "";          //抓取信息
    static String gs_capturemode = "";
    static String gs_transmitinfo = "";         //传输信息
    static String gs_applyhead = "";
    static String gs_applyinfo = "";            //写入信息
    static String gs_cpid = "";                 //截获进程
    static String gs_tpid = "";                 //传输进程
    static String gs_apid = "";                 //写入进程
    static String gs_sid = "";                  //oracle
    static String gs_realtime = "";             //延时
    static String gs_chkcapture = "5";          //检查capture线程
    static String gs_chktransmit = "5";         //检查transmit线程
    static String gs_chkapply = "5";            //检查apply线程
    static String gs_applylogfile = "";         //正在apply的日志文件名
    static String gs_logpool = "";              //日志池
    static String gs_tport = "";                //传输端口
    static String gs_aport = "";                //apply端口
    static String gs_hostid = "";
    static String gs_regcode = "";
    static String gs_act = "";                                              //本地角色，active or standby
    static String gs_path = System.getProperty("user.dir");                 //当前路径
    static String gs_config = gs_path + File.separator + "Alivedb.conf";    //配置文件路径
    static final String AGTVERSION = "2.15.12.2";
    //设置双机运行模式1和普通模式0
    //双机模式则服务启动后自动按身份执行，普通模式需要人工启动抓取，传输和写入
    static String gs_mode = "0";
    //重启线程标记
    static String gs_restart = "0";                   //0正常运行，1停止，2启动
    static int gi_restatus = 0;                       //线程退出标记，退出两个即表示完全退出

    public static void main(String[] args) throws Exception {
        UserLib.WriteLog(true, "Normal", "------------------------------------------------");
        UserLib.WriteLog(true, "Normal", "AliveDB Managerment Daemon");
        UserLib.WriteLog(true, "Normal", "LanderSoft all rights reserved.");
        UserLib.WriteLog(true, "Normal", "Version " + AGTVERSION);
        UserLib.WriteLog(true, "Normal", "------------------------------------------------");
        //调试标识
        if (args.length > 0) {
            if ((args[0].toUpperCase()).contains("DEBUG")) {
                is_debug = true;
                UserLib.WriteLog(true, "DEBUG", "Running as debug model ...");
            }
        }
        UserLib.WriteLog(true, "Normal", "Managerment Agent is starting...");
        String name = ManagementFactory.getRuntimeMXBean().getName();
        gs_pid = name.split("@")[0];
        UserLib.WriteLog(true, "Normal", "Pid is:" + gs_pid);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        gs_start = sd.format(new Date());
    }



    //注册线程 
    static class startRegisterThread implements Runnable {

        //执行循环
        public void run() {
            while (true) {
                try {
                    //int min = 3000;//该版本减少检查的等待时间
                    int min = 30;//调试使用
                    Random random = new Random(System.currentTimeMillis());
                    int i_loop = random.nextInt(min) + min;
                    //UserLib.WriteLog(true, "Normal", "---产生测试日志------产生测试日志------产生测试日志------产生测试日志------产生测试日志------产生测试日志---");
                    Thread.sleep(i_loop * 1000);
                    //检查capture.out的最后修改时间，如果capture进程在，文件修改在一小时之前，那么重启capture
                    if ("active".equals(gs_act)) {//角色为active才检查capture.out
                        String check_cpid = ConfigFile.getIniValue(gs_path + File.separator + "pids.conf", "Capture", "PID").trim();
                        //String check_cpid = ConfigFile.getIniValue(gs_path + File.separator + "pidd.conf", "Capture", "PID").trim();
                        UserLib.WriteLog(true, "Normal", "Check capture pid is " + check_cpid);
                        if (!"".equalsIgnoreCase(check_cpid)) {
                            if (SysResource.checkProcess(gs_cpid)) {//进程不为空，并且capture正在运行时才检查
                                //if(true){//测试使用
                                UserLib.WriteLog(true, "Normal", "Check capture.out...");
                                File f = new File(gs_path + File.separator + "capture.out");
                                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                                Calendar cal = Calendar.getInstance();
                                cal.setTimeInMillis(f.lastModified());
                                String s = sdf.format(cal.getTime());
                                String c = sdf.format(new Date());
                                Date sd = new Date();
                                Date cd = new Date();
                                try {
                                    sd = sdf.parse(s);
                                    cd = sdf.parse(c);
                                } catch (ParseException ex) {
                                    Logger.getLogger(SrvAgt.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                UserLib.WriteLog(true, "Normal","Capture.out time is " + s);
                                UserLib.WriteLog(true, "Normal","Current time is " + c);
                                long between = (cd.getTime() - sd.getTime()) / 1000;
                                UserLib.WriteLog(true, "Normal","Capture.out delay is " + between);
                                if (3600 < between) {//capture.out修改时间为一小时之前，那么停掉capture，由agent重新启动
                                    UserLib.WriteLog(true, "Normal", "Check capture.out failed.");
                                    if (SysResource.stopProcess(gs_cpid)) {
                                        //ConfigFile.setIniValue(gs_path + File.separator + "pids.conf", "Capture", "PID", "");
                                        UserLib.WriteLog(true, "Normal", "Capture thread restarting...");
                                        //gs_cpid = "";
                                        //iflag_capture = 0;//这里不用设置为0，便于进程再启动capture
                                    }else{
                                        UserLib.WriteLog(true, "Error", "Stop capture thread failed.");
                                    }
                                }
                            } else {
                                UserLib.WriteLog(true, "Normal", "Capture thread is stopped.");
                            }
                        }
                    }
                    
                    //将已经确定日期的系统日志进行压缩，并且删除原日志
                    //注册无效则停止应用
                    
                    if (false == execRegister(gs_hostid, gs_regcode, "")) {
                        if (!"".equals(gs_cpid)) {
                            if (SysResource.stopProcess(gs_cpid)) {
                                ConfigFile.setIniValue(gs_path + File.separator + "pids.conf", "Capture", "PID", "");
                                UserLib.WriteLog(true, "Normal", "Capture thread has stopped.");
                                gs_cpid = "";
                                gs_mode = "0";
                                iflag_capture = 0;
                            }
                        }
                        if (!"".equals(gs_tpid)) {
                            if (SysResource.stopProcess(gs_tpid)) {
                                ConfigFile.setIniValue(gs_path + File.separator + "pids.conf", "Transmit", "PID", "");
                                UserLib.WriteLog(true, "Normal", "Transmit thread has stopped.");
                                gs_tpid = "";
                                gs_mode = "0";
                                iflag_transmit = 0;
                            }
                        }
                        if (!"".equals(gs_apid)) {
                            if (SysResource.stopProcess(gs_apid)) {
                                ConfigFile.setIniValue(gs_path + File.separator + "pids.conf", "Apply", "PID", "");
                                UserLib.WriteLog(true, "Normal", "Apply thread has stopped.");
                                gs_apid = "";
                                gs_mode = "0";
                                iflag_apply = 0;
                            }
                        }
                    }
                    
                } catch (InterruptedException ex) {
                    Logger.getLogger(SrvAgt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    //执行注册
    static public boolean execRegister(String s_path, String s_exe, String s_pidname) {
        UserLib.WriteLog(true, "Normal", "Check license ...");
        //每次更新读取注册码，可确保输入正确的注册码即可马上生效
        gs_regcode = ConfigFile.getIniValue(gs_config, "System", "Regcode");
        //第三个参数是功能代码110,111,220,221
        if (true == SysResource.checkLicense(gs_hostid, gs_regcode, "110")) {
            UserLib.WriteLog(true, "Normal", "The license is valid [peer to peer].");
        } else if (true == SysResource.checkLicense(gs_hostid, gs_regcode, "111")) {
            UserLib.WriteLog(true, "Normal", "The license is valid [peer to peer to peer].");
        } else if (true == SysResource.checkLicense(gs_hostid, gs_regcode, "221")) {
            UserLib.WriteLog(true, "Normal", "The license is valid [rac to peer].");
        } else {
            gs_regcode = null;
        }
        if (null == gs_regcode) {
            UserLib.WriteLog(true, "Normal", "The license is invalid.");
            return false;
        }
        return true;
    }

    //启动抓取线程类 
    static class startCaptureThread implements Runnable {

        //执行循环
        public void run() {
            String s_path = gs_path + File.separator + "capture" + File.separator;
            String s_exe = "capture";
            UserLib.WriteLog(true, "Normal", "The system is : " + gs_os);
            if (gs_os.startsWith("windows")) {
                s_exe = s_exe + ".exe";
            }
            //调试模式，打开日志输出
            if (true == is_debug) {
                ConfigFile.setIniValue(gs_config, "System", "Logging", "true");
            } else {
                ConfigFile.setIniValue(gs_config, "System", "Logging", "false");
            }
            while (true) {
                //双机模式则服务启动时，进程也要启动
                if  ("1".equals(gs_mode)) {
                    iflag_capture = 1;
                }
                if ("1".equals(gs_restart)) {
                    UserLib.WriteLog(is_debug, "Normal", "Capture thread is exited.");
                    gi_restatus++;
                    break;
                }
                execCapture(s_path, s_path + s_exe, s_exe);
                try {
                    Thread.sleep(Integer.valueOf(gs_chkcapture) * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SrvAgt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //执行capture
    static public int execCapture(String s_path, String s_exe, String s_pidname) {
        if (1 == iflag_capture) {
            UserLib.WriteLog(is_debug, "Normal", "Checking capture thread...");
            if (!SysResource.checkProcess(gs_cpid)) {
                UserLib.WriteLog(true, "Normal", "Start capture thread...");
                gs_cpid = SysResource.startProcess(s_path, s_exe, s_pidname);
                gs_sid = ConfigFile.getIniValue(gs_config, gs_local, "Oracle_instance");
                if("0".equals(ConfigFile.getIniValue(gs_config, "Option", "Capture_mode"))){
                    gs_capturemode = "Realtime";
                }else if("1".equals(ConfigFile.getIniValue(gs_config, "Option", "Capture_mode"))){
                    gs_capturemode = "Delay";
                }else {
                    UserLib.WriteLog(true, "Error", "Get a illegal capture mode: " + ConfigFile.getIniValue(gs_config, "Option", "Capture_mode"));
                    gs_capturemode = "Unknown";
                }
                ConfigFile.setIniValue(gs_path + File.separator + "pids.conf", "Capture", "PID", gs_cpid);
                gs_captureinfo = "status=Running"  + "&capturemode=" + gs_capturemode + "&sid=" + gs_sid + "&" + SysResource.getRuntimeOutput(gs_path + File.separator + "capture.out", 1);
            } else {
                UserLib.WriteLog(true, "Normal", "Capture thread " + gs_cpid + " is running...");
                gs_captureinfo = "status=Running"  + "&capturemode=" + gs_capturemode + "&sid=" + gs_sid + "&" + SysResource.getRuntimeOutput(gs_path + File.separator + "capture.out", 1);
            }
        } else {
            //若进程在，则继续监控管理
            if (!"".equals(gs_cpid)) {
                iflag_capture = 1;
            } else {
                gs_captureinfo = "status=Stopped" + "&capturemode=" + gs_capturemode;
            }
        }
        return 0;
    }



    //启动线程类 
    static class startApplyThread implements Runnable {

        //执行循环
        public void run() {
            String s_path = gs_path + File.separator + "apply" + File.separator;
            String s_exe = "apply.jar";
            while (true) {
                //双机模式则服务启动时，进程也要启动
                if  ("1".equals(gs_mode)) {
                    iflag_apply = 1;
                }
                if ("1".equals(gs_restart)) {
                    UserLib.WriteLog(is_debug, "Normal", "Apply thread is exited.");
                    gi_restatus++;
                    break;
                }
                if (!"".equals(gs_logpool)) {
                } else {
                    UserLib.WriteLog(true, "Warning", "Apply thread initialization error.");
                }
                try {
                    Thread.sleep(Integer.valueOf(gs_chkapply) * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SrvAgt.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }




    


}
