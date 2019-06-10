/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adbagt;

import static adbagt.SrvAgt.AGTVERSION;
import static adbagt.SrvAgt.gs_applylogfile;
import static adbagt.SrvAgt.gs_config;
import static adbagt.SrvAgt.gs_local;
import static adbagt.SrvAgt.gs_os;
import static adbagt.SrvAgt.gs_path;
import static adbagt.SrvAgt.gs_pid;
import static adbagt.SrvAgt.gs_start;
import static adbagt.SrvAgt.is_debug;

import com.arshiner.common.ConfigFile;
import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinBase.SECURITY_ATTRIBUTES;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinNT;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author William
 */
public class SysResource {

    public static InetAddress getInetAddress() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
            //System.out.println("unknown host!");  
        }
        return null;
    }

    public static String getHostIp(InetAddress netAddress) {
        if (null == netAddress) {
            return null;
        }
        String ip = netAddress.getHostAddress(); //get the ip address  
        return ip;
    }

    public static String getHostName(InetAddress netAddress) {
        //System.out.println("ip is: " + netAddress);
        if (null == netAddress) {
            return null;
        }
        String name = netAddress.getHostName(); //get the host address  
        return name;
    }

    //读配置信息
    //获取capture和apply的输出信息
    public static String getRuntimeOutput(String s_config, int i_type) {
        Properties settings = new Properties();
        FileInputStream in = null;
        String s_ret = "";
        String s_date = "";
        try {
            //读取配置
            in = new FileInputStream(s_config);
            settings.load(in);
            if (1 == i_type) {
                //capture
                //lastredo=c:\\redo1.log&lastscn=1111&lastlog=c:\\adbdata\\20150101.log&dbstamp=20150202121212"
                s_ret = "lastredo=" + settings.getProperty("Last_redo", "").trim() + "&";
                s_ret = s_ret + "lastscn=" + settings.getProperty("Last_log_SCN", "").trim() + "&";
                s_ret = s_ret + "lastlog=" + settings.getProperty("Last_log", "").trim() + "&";
                s_ret = s_ret + "writescn=" + settings.getProperty("Last_write_SCN", "").trim() + "&";
                s_date = settings.getProperty("Last_stamp", "").trim();
                if (14 == s_date.length()) {
                    s_date = s_date.substring(0, 4) + "-" + s_date.substring(4, 6) + "-" + s_date.substring(6, 8)
                            + " " + s_date.substring(8, 10) + ":" + s_date.substring(10, 12) + ":" + s_date.substring(12, 14);
                } else {
                    //UserLib.WriteLog(true, "Warning", s_date);
                }
                s_ret = s_ret + "dbstamp=" + s_date;
            } else if (2 == i_type) {
                //apply
                //lastlog=c:\\aaa.log&lastscn=1111&lastline=1234&dbstamp=20150202121212
                gs_applylogfile = settings.getProperty("last.log", "").trim();
                s_ret = "lastlog=" + gs_applylogfile + "&";
                s_ret = s_ret + "lastscn=" + settings.getProperty("last.SCN", "").trim() + "&";
                s_ret = s_ret + "lastline=" + settings.getProperty("last.line", "").trim() + "&";
                s_ret = s_ret + "lastcount=" + settings.getProperty("last.count", "").trim() + "&";
                s_date = settings.getProperty("last.date", "").trim();
                if (14 == s_date.length()) {
                    s_date = s_date.substring(0, 4) + "-" + s_date.substring(4, 6) + "-" + s_date.substring(6, 8)
                            + " " + s_date.substring(8, 10) + ":" + s_date.substring(10, 12) + ":" + s_date.substring(12, 14);
                }
                s_ret = s_ret + "dbstamp=" + s_date;
            }
            return s_ret;
        } catch (IOException e) {
            //e.printStackTrace();
            return "";
        } finally {
            try {
                if (null != in) {
                    in.close();
                }
            } catch (IOException e) {
                //e.printStackTrace();
                return "";
            }
        }
    }

    //保存文本文件
    public static boolean saveToFile(String s_file, String s_txt) {
        //保存配置
        File foption = new File(s_file);
        try {
            if (!foption.exists())//如果文件不存在,则新建.  
            {
                File parentDir = new File(foption.getParent());
                if (!parentDir.exists())//如果所在目录不存在,则新建.  
                {
                    parentDir.mkdirs();
                }
                foption.createNewFile();
            }
            StringBuilder sb = new StringBuilder();
            sb.append(s_txt);
            System.out.println(sb.toString());
            PrintWriter pw = new PrintWriter(new FileWriter(foption), true);
            pw.println(sb.toString());
            pw.close();
            return true;
        } catch (IOException ex) {
            //ex.printStackTrace();
            return false;
        }
    }

    //读配置信息 用于Deamon界面的显示
    public static String getDaemonInfo() {
        String s_ret = "host=" + getHostName(getInetAddress());
        s_ret = s_ret + "&ostype=" + System.getProperty("os.name");
        s_ret = s_ret + "&osversion=" + System.getProperty("os.version") + "-" + System.getProperty("os.arch");
        s_ret = s_ret + "&port=" + ConfigFile.getIniValue(gs_config, "System", "Port");
        s_ret = s_ret + "&starttime=" + gs_start;
        s_ret = s_ret + "&pid=" + gs_pid;
        s_ret = s_ret + "&home=" + gs_path;
        s_ret = s_ret + "&agentversion=" + AGTVERSION;
        return s_ret;
    }

    //初始化capture.out断点，清空apply断点和SQL日志
    public static String initBreakPoint(String s_scn, String s_pool) {
        StringBuffer sbcapture = new StringBuffer();
        StringBuffer sbapply = new StringBuffer();
        String crlf = System.getProperty("line.separator");
        //初始化capture断点
        
        sbcapture.append("Last_log_SCN=" + s_scn + crlf);
        sbcapture.append("Last_log=" + crlf);
        sbcapture.append("Last_stamp=" + crlf);
        sbcapture.append("Last_redo=" + crlf);
        sbcapture.append("Last_write_SCN=" + crlf);
        String s_txt = sbcapture.toString();
        File ftab = new java.io.File(gs_path + File.separator + "capture.tmp");
        if (ftab.exists()) {
            ftab.delete();
        }
        if (false == saveToFile(gs_path + File.separator + "capture.out", s_txt)) {
            UserLib.WriteLog(true, "Error", "Save capture.out error!");
            return "";
        }
        //apply.out
        sbapply.append("last.log=" + crlf);
        sbapply.append("last.line=" + crlf);
        sbapply.append("last.date=" + crlf);
        sbapply.append("last.SCN=" + crlf);
        sbapply.append("last.count=" + crlf);
        s_txt = sbapply.toString();
        if (false == saveToFile(gs_path + File.separator + "apply.out", s_txt)) {
             UserLib.WriteLog(true, "Error", "Save apply.out error!");
            return "";
        }
        //delete log
        if ("".equals(s_pool)) {
             UserLib.WriteLog(true, "Error", "Logpool path is empty!");
            return "";
            
        }
        if (false == deleteDir(new File(s_pool))) {
             UserLib.WriteLog(true, "Error", "Delete logfile failed!");
            return "";
        }
        return "0";
    }

    //删除目录下所有文件
    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                File ftmp = new File(dir, children[i]);
                if (false == ftmp.delete()) {
                    return false;
                }
            }
        }
        return true;
    }

    //执行客户端获取信息命令
    static public String execGetCfg(String s_file, String s_cmd) {
        String s_ret = "";
        String s_app = "";
        String s_key = "";
        String s_value = "";
        String[] arrSplit = null;
        arrSplit = s_cmd.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值  
            if (arrSplitEqual.length > 1) {
                if ("appname".equals(arrSplitEqual[0].trim())) {
                    s_app = arrSplitEqual[1].trim();
                } else if ("key".equals(arrSplitEqual[0].trim())) {
                    s_key = arrSplitEqual[1].trim();
                }
            }
            if ((!"".equals(s_app)) && (!"".equals(s_key))) {
                //关于加密
                s_value = ConfigFile.getIniValue(s_file, s_app, s_key);
                if (s_key.toLowerCase().contains("password")) {
                    try {
                        s_value = RSALib.decryptstring(s_value);
                    } catch (Exception ex) {
                        Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if ("".equals(s_ret)) {
                    s_ret = s_ret + "value=" + s_value;
                } else {
                    s_ret = s_ret + "&value=" + s_value;
                }
                s_app = "";
                s_key = "";
            }
        }
        return s_ret;
    }

    //执行客户端写入信息命令
    static public String execSetCfg(String s_file, String s_cmd) {
        String s_app = "";
        String s_key = "";
        String s_value = null;
        String[] arrSplit = null;
        arrSplit = s_cmd.split("[&]");
        for (String strSplit : arrSplit) {
            String[] arrSplitEqual = null;
            arrSplitEqual = strSplit.split("[=]");
            //解析出键值  
            if (arrSplitEqual.length > 1) {
                if ("appname".equals(arrSplitEqual[0].trim())) {
                    s_app = arrSplitEqual[1].trim();
                } else if ("key".equals(arrSplitEqual[0].trim())) {
                    s_key = arrSplitEqual[1].trim();
                } else if ("value".equals(arrSplitEqual[0].trim())) {
                    s_value = arrSplitEqual[1].trim();
                }
            }
            if ((!"".equals(s_app)) && (!"".equals(s_key)) && (null != s_value)) {
                //-------------------------------------------------------处理加密
                if (s_key.toLowerCase().contains("password")) {
                    try {
                        s_value = RSALib.encryptstring(s_value);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if (false == ConfigFile.setIniValue(s_file, s_app, s_key, s_value)) {
                    return "";
                }
                s_app = "";
                s_key = "";
                s_value = null;
            }
        }
        return "result=0";
    }

    //启动os进程 返回值s_ret为PID
    //s_exec必须带全路径
    public static String startProcess(String s_path, String s_exec, String s_pidname) {
        String s_ret = "";
        UserLib.WriteLog(is_debug, "Normal", s_path);
        UserLib.WriteLog(is_debug, "Normal", s_exec);
        UserLib.WriteLog(is_debug, "Normal", s_pidname);
        if (gs_os.startsWith("windows")) {
            s_ret = startWinProcess(s_path, s_exec);
        } else if (gs_os.startsWith("linux")) {
            String[] cmd = {"/bin/sh", "-c", s_exec + " >/dev/null &"};
            File dir = new File(s_path);
            try {
                Process proc = Runtime.getRuntime().exec(cmd, null, dir);
                if (null != proc) {
                    s_ret = getPidByName(s_pidname);
                    UserLib.WriteLog(is_debug, "Normal", "Pid is: " + s_ret);
                } else {
                    s_ret = "";
                    UserLib.WriteLog(is_debug, "Warning", "Pid is null.");
                }
                InputStreamReader reader = new InputStreamReader(proc.getInputStream());
                LineNumberReader line = new LineNumberReader(reader);
                String str;
                while ((str = line.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return "";
            }
        } else if (gs_os.startsWith("aix")) {
            String[] cmd = {"/bin/ksh", "-c", s_exec + " >/dev/null &"};
            File dir = new File(s_path);
            try {
                Process proc = Runtime.getRuntime().exec(cmd, null, dir);
                if (null != proc) {
                    s_ret = getPidByName(s_pidname);
                    UserLib.WriteLog(is_debug, "Normal", "Pid is: " + s_ret);
                } else {
                    s_ret = "";
                    UserLib.WriteLog(is_debug, "Warning", "Pid is null.");
                }
                InputStreamReader reader = new InputStreamReader(proc.getInputStream());
                LineNumberReader line = new LineNumberReader(reader);
                String str;
                while ((str = line.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return "";
            }
        }else if (gs_os.startsWith("sunos")) {//加入对solaris系统的支持
            String[] cmd = {"/bin/sh", "-c", s_exec + " >/dev/null &"};
            File dir = new File(s_path);
            try {
                Process proc = Runtime.getRuntime().exec(cmd, null, dir);
                if (null != proc) {
                    s_ret = getPidByName(s_pidname);
                    UserLib.WriteLog(is_debug, "Normal", "Pid is: " + s_ret);
                } else {
                    s_ret = "";
                    UserLib.WriteLog(is_debug, "Warning", "Pid is null.");
                }
                InputStreamReader reader = new InputStreamReader(proc.getInputStream());
                LineNumberReader line = new LineNumberReader(reader);
                String str;
                while ((str = line.readLine()) != null) {
                    System.out.println(str);
                }
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return "";
            }
        } else {
            UserLib.WriteLog(true, "Warning", "No support on this os: " + gs_os);
            return "";
        }
        return s_ret;
    }
  
    //检查进程是否存在tasklist /FI "PID eq 7360"
    public static boolean checkProcess(String s_pid) {
        if (("".equals(s_pid)) || ("0".equals(s_pid))) {
            return false;
        }

        BufferedReader bufferedReader = null;
        try {
            Process proc = null;
            String[] cmd = {"", "", ""};
            if (gs_os.startsWith("windows")) {
                //根据进程pid查询
                return checkWinProcess(1, s_pid);
            } else if (gs_os.startsWith("linux")) {
                cmd[0] = "/bin/sh";
                cmd[1] = "-c";
                cmd[2] = "pwdx " + s_pid;
            } else if (gs_os.startsWith("aix")) {
                cmd[0] = "/bin/ksh";
                cmd[1] = "-c";
                //为了pid完全匹配
                cmd[2] = "ps -ef |awk '{print \" \"$2\" \"}'|grep \" \"" + s_pid + "\" \"";
            } else if (gs_os.startsWith("sunos")) {//支持solaris系统
                cmd[0] = "/sbin/sh";
                cmd[1] = "-c";
                //为了pid完全匹配
                cmd[2] = "ps -ef |awk '{print \" \"$2\" \"}'|grep \" \"" + s_pid + "\" \"";
            } else {
                UserLib.WriteLog(true, "Warning", "No support on this os:" + gs_os);
                return false;
            }
            proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
            bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                UserLib.WriteLog(is_debug, "Normal", "Get pid info: " + line);
                if ((line.contains(s_pid)) && (!line.contains("No such process"))) {
                    return true;
                }
            }
            return false;
        } catch (Exception ex) {
            //ex.printStackTrace();
            return false;
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    //停止os进程
    public static boolean stopProcess(String s_pid) {
        if (("".equals(s_pid)) || ("0".equals(s_pid))) {
            return true;
        }
        Process process = null;
        if (gs_os.startsWith("windows")) {
            String cmd = "cmd /c taskkill /pid " + s_pid + " /T /F";
            try {
                process = Runtime.getRuntime().exec(cmd);
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else if (gs_os.startsWith("linux")) {
            String[] cmd = {"/bin/sh", "-c", "kill -9 " + s_pid};
            try {
                process = Runtime.getRuntime().exec(cmd);
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else if (gs_os.startsWith("aix")) {
            String[] cmd = {"/bin/ksh", "-c", "kill -9 " + s_pid};
            try {
                process = Runtime.getRuntime().exec(cmd);
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }else if (gs_os.startsWith("sunos")) {
            String[] cmd = {"/sbin/sh", "-c", "kill -9 " + s_pid};
            try {
                process = Runtime.getRuntime().exec(cmd);
            } catch (IOException ex) {
                Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            UserLib.WriteLog(true, "Warning", "No support on this os: " + gs_os);
            return false;
        }
        try {
            process.waitFor();
            return true;
        } catch (InterruptedException ex) {
            Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //windows下检查进程
    public static boolean checkWinProcess(int i_type, String s_in) {
        if (("".equals(s_in)) || ("0".equals(s_in))) {
            return false;
        }
        Kernel32 kernel32 = Kernel32.INSTANCE;
        //Kernel32 kernel32 = (Kernel32) Native.loadLibrary(Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        try {
            String s_pid = "";
            while (kernel32.Process32Next(snapshot, processEntry)) {
                //根据进程pid查询
                if (1 == i_type) {
                    s_pid = processEntry.th32ProcessID.toString();
                    //ll_pid = (long)processEntry.th32ProcessID;
                    if (s_in.equals(s_pid)) {
                        //System.out.println(processEntry.th32ProcessID + "\t" + Native.toString(processEntry.szExeFile));
                        return true;
                    }
                } else {  //根据进程名查询
                    if ((s_in.toLowerCase()).equals(Native.toString(processEntry.szExeFile).toLowerCase())) {
                        //System.out.println(processEntry.th32ProcessID + "\t" + Native.toString(processEntry.szExeFile));
                        return true;
                    }
                }
                //System.out.println(processEntry.th32ProcessID + "\t" + Native.toString(processEntry.szExeFile));
            }
        } finally {
            kernel32.CloseHandle(snapshot);
        }
        return false;
    }

    //windows下启动进程 
    public static String startWinProcess(String s_path, String s_cmdline) {
        Kernel32 kernel32 = Kernel32.INSTANCE;
        SECURITY_ATTRIBUTES procSecAttr = new SECURITY_ATTRIBUTES();
        SECURITY_ATTRIBUTES threadSecAttr = new SECURITY_ATTRIBUTES();
        WinBase.PROCESS_INFORMATION.ByReference byRef = new WinBase.PROCESS_INFORMATION.ByReference();
        WinBase.STARTUPINFO startupInfo = new WinBase.STARTUPINFO();
        //正常运行，隐藏界面
        if (false == is_debug) {
            startupInfo.dwFlags = 1;
            startupInfo.wShowWindow = new WinDef.WORD(0);
        }
        boolean success = kernel32.CreateProcess(null, s_cmdline, procSecAttr,
                threadSecAttr, false, new DWORD(0x00000010), null, s_path,
                startupInfo, byRef);
        if (!success) {
            return "0";
        } else {
            //System.out.println(byRef.dwProcessId);
            return byRef.dwProcessId.toString();
        }
    }

    //根据进程名，获取pid
    public static String getPidByName(String s_name) {
        if (("".equals(s_name)) || ("0".equals(s_name))) {
            return "";
        }
        String[] cmd = {"", "", ""};
        if (gs_os.startsWith("linux")) {
            cmd[0] = "/bin/sh";
            cmd[1] = "-c";
            cmd[2] = "ps -ef|grep " + s_name + "|grep -v grep|awk '{print $2}'";
        } else if (gs_os.startsWith("aix")) {
            cmd[0] = "/bin/ksh";
            cmd[1] = "-c";
            cmd[2] = "ps -ef|grep " + s_name + "|grep -v grep|awk '{print $2}'";
        }else if (gs_os.startsWith("sunos")) {//支持solaris系统
            cmd[0] = "/sbin/sh";
            cmd[1] = "-c";
            cmd[2] = "ps -ef|grep " + s_name + "|grep -v grep|awk '{print $2}'";
        }  else {
            return "";
        }
        BufferedReader bufferedReader = null;
        try {
            Process proc = Runtime.getRuntime().exec(cmd);
            proc.waitFor();
            bufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                //System.out.println(line);
                if (!"".equals(line)) {
                    return line.trim();
                }
            }
            return "";
        } catch (Exception ex) {
            //ex.printStackTrace();
            return "";
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception ex) {
                }
            }
        }
    }

    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        // 路径为文件且不为空则进行删除  
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    public static String updateHostID() {
        String s_mac = "";
        String s_ret = "";
        String s_title = "";
        Process process = null;
        BufferedReader br = null;
        try {
            if (gs_os.startsWith("windows")) {
                s_title = "ADB20WIN";
                process = Runtime.getRuntime().exec("wmic nicconfig where IPEnabled=TRUE get MACAddress");
            } else if (gs_os.startsWith("linux")) {
                String[] cmd = {"/bin/sh", "-c", "ifconfig |grep HWaddr|awk '{print $5}'"};
                s_title = "ADB20LUX";
                process = Runtime.getRuntime().exec(cmd);
            } else if (gs_os.startsWith("aix")) {
                String[] cmd = {"/bin/ksh", "-c", "netstat -v |grep Hardware|awk '{print $3}'"};
                s_title = "ADB20AIX";
                process = Runtime.getRuntime().exec(cmd);
            } else if (gs_os.startsWith("sunos")) {//支持solaris系统
                String[] cmd = {"/sbin/sh", "-c", "netstat -p |grep `hostname`|awk '{print $5}'"};
                s_title = "ADB20SUN";
                process = Runtime.getRuntime().exec(cmd);
            }else {
                UserLib.WriteLog(true, "Warning", "No support on this os: " + gs_os);
                return "";
            }
            //没有下面这句，在win2000下执行会导致服务器端主线程挂起，现服务器端已经改为独立线程来发命令
            process.getOutputStream().close();
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            while ((line = br.readLine()) != null) {
                //System.out.println(line.trim());
                line = line.trim();
                if (!"MACAddress".equals(line)) {
                    s_ret = s_ret + line.replaceAll(":", "");
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return "";
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    //e.printStackTrace();
                    return "";
                }
            }
        }
        s_ret = (s_ret.toUpperCase() + "000000000000000000000000").substring(0, 24);
        return s_title + s_ret;
    }

    public static boolean checkLicense(String s_hostid, String s_regcode, String s_code) {
        String snic1 = "";
        String snic2 = "";
        String sregcode = "";
        String sdate = "";

        if (32 != s_hostid.length()) {
            return false;
        } else {
            snic1 = s_hostid.substring(8, 20);
            snic2 = s_hostid.substring(20, 32);
        }
        try {
            sregcode = RSALib.decrypt(s_regcode);
            //UserLib.WriteLog(true, "Normal", sregcode);
        } catch (Exception ex) {
            //Logger.getLogger(SysResource.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        //解密长度不够，则退出8+3+32
        if (43 > sregcode.length()) {
            return false;
        }
        //判断节点数9，10，11位
        ConfigFile.setIniValue(gs_config, "System", "Code", sregcode.substring(8, 11));
        if (!s_code.equals(sregcode.substring(8, 11))) {
            return false;
        }

        //判断解密数据是否合法
        ConfigFile.setIniValue(gs_config, "System", "Date", sregcode.substring(0, 8));
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        String curtime = sd.format(new Date());
        if ((sregcode.contains(snic1)) || (sregcode.contains(snic2))) {
            if ((curtime.compareTo(sregcode.substring(0, 8)) < 0) && (curtime.compareTo("20140101") > 0)) {
                return true;
            }
        }
        return false;
    }

    //获取网卡设备名
    public static String getNetIndex() {
        String s_ret = "";
        String sip = ConfigFile.getIniValue(gs_config, gs_local, "IPLink1");
        Process process = null;
        BufferedReader br = null;
        try {
            if (gs_os.startsWith("windows")) {
                process = Runtime.getRuntime().exec("wmic nicconfig get ipaddress, index /value");
            } else if (gs_os.startsWith("linux")) {
                String[] cmd = {"/bin/sh", "-c", "ifconfig -a |awk '{print $1 \"=\" $2}'"};
                process = Runtime.getRuntime().exec(cmd);
            } else if (gs_os.startsWith("aix")) {
                String[] cmd = {"/bin/ksh", "-c", "ifconfig -a |awk '{print $1 \"=\" $2}'"};
                process = Runtime.getRuntime().exec(cmd);
            } else if (gs_os.startsWith("sunos")) {
                String[] cmd = {"/sbin/sh", "-c", "ifconfig -a |awk '{print $1 \"=\" $2}'"};
                process = Runtime.getRuntime().exec(cmd);
            }else {
                UserLib.WriteLog(true, "Warning", "No support on this os: " + gs_os);
                return "";
            }
            //没有下面这句，在win2000下执行会导致服务器端主线程挂起，现服务器端已经改为独立线程来发命令
            process.getOutputStream().close();
            br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = null;
            String stmp = "";
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.length() < 5) {
                    continue;
                }
                /*
                //解决aix问题-------------------------------------------?????????????????????????????????????????????????????????
                if (line.length() > 60) {
                    line = line.substring(60, line.length());
                }
                */
                if (line.contains(sip)) {
                    if (!"".equals(s_ret)) {
                        UserLib.WriteLog(is_debug, "Normal", "Net device [" + sip + "]: " + line);
                        return s_ret;
                    }
                }
                if ((line.contains("=")) && (!line.endsWith("="))) {
                    if (gs_os.startsWith("windows")) {//windows为index=1 这种形式，所以要取第一个等号之后的内容
                        stmp = line.split("=")[1].trim();
                    } else {
                        stmp = line.split("=")[0].trim();
                    }
                    if (stmp.endsWith(":")) {//去除 AIX和sunos系统中取出的网卡名会带有结尾的冒号
                        stmp = stmp.substring(0, stmp.length() - 1);
                    }
                    if (!"".equals(stmp)) {
                        s_ret = stmp;
                    }
                }
            }
        } catch (Exception e) {
            //e.printStackTrace();
            return "";
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    //e.printStackTrace();
                    return "";
                }
            }
        }
        return "";
    }

    //保存容灾网络配置脚本
    public static String saveNetScript() {
        String sindex = "";
        String sfile = "";
        String sip = ConfigFile.getIniValue(gs_config, "Disaster", "IPAddress");
        String snetmask = ConfigFile.getIniValue(gs_config, "Disaster", "Subnetmask");
        String sgateway = ConfigFile.getIniValue(gs_config, "Disaster", "Gateway");
        if (("".equals(sip)) || ("".equals(snetmask)) || ("".equals(sgateway))) {
            return "";
        }
        StringBuffer sbcapture = new StringBuffer();
        String crlf = System.getProperty("line.separator");
        String s_txt = "";
        if (gs_os.startsWith("windows")) {
            sfile = "appstart.bat";
        } else {
            sfile = "appstart.sh";
        }
        //初始化appstart文件
        File file = new File(gs_path + File.separator + "disaster" + File.separator + sfile);
        // 路径为文件且不为空则进行删除 
        if (!file.exists()) {
            sbcapture.append("# This is a script file." + crlf);
            sbcapture.append("# Please writen your shell/bat in the file." + crlf);
            sbcapture.append(crlf);
            s_txt = sbcapture.toString();
            if (false == saveToFile(gs_path + File.separator + "disaster" + File.separator + sfile, s_txt)) {
                return "";
            }
            sbcapture.delete(0, sbcapture.length());
        }
        //初始化ipstart文件
        sindex = getNetIndex();
        if (gs_os.startsWith("windows")) {
            sfile = "ipstart.bat";
            sbcapture.append("# This is a script file." + crlf);
            sbcapture.append("# Please writen your shell/bat in the file." + crlf);
            sbcapture.append(crlf);
            sbcapture.append("wmic nicconfig where (index=" + sindex + ") call enablestatic \"" + sip + "\", \"" + snetmask + "\"" + crlf);
            sbcapture.append("wmic nicconfig where (index=" + sindex + ") call setgateways \"" + sgateway + "\" , 1" + crlf);
        } else if (gs_os.startsWith("linux")) {
            sfile = "ipstart.sh";
            sbcapture.append("ifconfig " + sindex + " " + sip + " netmask " + snetmask + crlf);
            if (!"".equals(sgateway)) {
                sbcapture.append("route add default gw " + sgateway + crlf);
            }
        } else if (gs_os.startsWith("aix")) {
            sfile = "ipstart.sh";
            sbcapture.append("ifconfig " + sindex + " " + sip + " netmask " + snetmask + crlf);
            if (!"".equals(sgateway)) {
                sbcapture.append("route add default " + sgateway + crlf);
            }
        } else if (gs_os.startsWith("sunos")) {
            sfile = "ipstart.sh";
            sbcapture.append("ifconfig " + sindex + " " + sip + " netmask " + snetmask + crlf);
            if (!"".equals(sgateway)) {
                sbcapture.append("route add default " + sgateway + crlf);
            }
        }else {
            sbcapture.append("#This os: " + gs_os +" is not support." + crlf);
        }
        s_txt = sbcapture.toString();
        if (false == saveToFile(gs_path + File.separator + "disaster" + File.separator + sfile, s_txt)) {
            return "";
        }
        return "0";
    }

}
