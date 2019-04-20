/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.arshiner.common;
import com.arshiner.quartz.job.FlashCelueTask;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.WinBase;
import com.sun.jna.platform.win32.WinBase.SECURITY_ATTRIBUTES;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinNT;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.log4j.Logger;



/**
 *
 * @author William
 */
public class JCallDll {
	private static final Logger logger = Logger.getLogger(FlashCelueTask.class);
	SimpleDateFormat  sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /**
     * 启动
     * @param s_exe
     * @param s_params
     * @return
     */
    public static String WinAPI(String s_exe, String s_params) {
        Kernel32 kernel32 = Kernel32.INSTANCE;
        String s_path = "";
        
        int i_last = s_exe.lastIndexOf(File.separator);
        if (0 < i_last) {
            s_path = s_exe.substring(0, i_last);
        } else {
            return "0";
        }
        SECURITY_ATTRIBUTES procSecAttr = new SECURITY_ATTRIBUTES();
        SECURITY_ATTRIBUTES threadSecAttr = new SECURITY_ATTRIBUTES();
        WinBase.PROCESS_INFORMATION.ByReference byRef = new WinBase.PROCESS_INFORMATION.ByReference();
        WinBase.STARTUPINFO startupInfo = new WinBase.STARTUPINFO();
        startupInfo = new WinBase.STARTUPINFO();
        boolean success = kernel32.CreateProcess(null, s_exe + " " + s_params, procSecAttr,
                threadSecAttr, false, new DWORD(0x00000010), null, s_path,
                startupInfo, byRef);
        if (!success) {
            return "0";
        } else {
            //System.out.println(byRef.dwProcessId);
            return byRef.dwProcessId.toString();
        }
    }
    /**
     * 启动
     * @param s_exe
     * @param s_params
     * @param s_path
     * @return
     */
    public static String WinAPIWithPath(String s_exe, String s_params,String path) {
      Kernel32 kernel32 = Kernel32.INSTANCE;
        SECURITY_ATTRIBUTES procSecAttr = new SECURITY_ATTRIBUTES();
        SECURITY_ATTRIBUTES threadSecAttr = new SECURITY_ATTRIBUTES();
        WinBase.PROCESS_INFORMATION.ByReference byRef = new WinBase.PROCESS_INFORMATION.ByReference();
        WinBase.STARTUPINFO startupInfo = new WinBase.STARTUPINFO();
        startupInfo = new WinBase.STARTUPINFO();
        boolean success = kernel32.CreateProcess(null, s_exe + " " + s_params, procSecAttr,
                threadSecAttr, false, new DWORD(0x00000010), null, path,
                startupInfo, byRef);
        if (!success) {
            return "0";
        } else {
            //System.out.println(byRef.dwProcessId);
            return byRef.dwProcessId.toString();
        }
    }

    /**
     * 杀死进程
     * @param i_pid
     * @return
     */
    public static int killPid(int i_pid) {
        //windows杀进程
        String cmd = "cmd /c taskkill /pid " + String.valueOf(i_pid) + " /T /F";
        Process process = null;
        try {
            process = Runtime.getRuntime().exec(cmd);
        } catch (IOException ex) {
            //Logger.getLogger(ALCluster.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        try {
            return process.waitFor();
        } catch (InterruptedException ex) { 
            //Logger.getLogger(ALCluster.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    //获取进程pid列表
    public static boolean CheckPidStatus(String pid) {
    //public static boolean CheckWinProcess(int i_type, String s_in) {
        Kernel32 kernel32 = Kernel32.INSTANCE;
        //Kernel32 kernel32 = (Kernel32) Native.loadLibrary(Kernel32.class, W32APIOptions.UNICODE_OPTIONS);
        Tlhelp32.PROCESSENTRY32.ByReference processEntry = new Tlhelp32.PROCESSENTRY32.ByReference();
        WinNT.HANDLE snapshot = kernel32.CreateToolhelp32Snapshot(Tlhelp32.TH32CS_SNAPPROCESS, new WinDef.DWORD(0));
        try {
            String s_pid = pid;
            System.out.println("CheckPidStatus : "+pid);
            while (kernel32.Process32Next(snapshot, processEntry)) {
                s_pid = processEntry.th32ProcessID.toString();
                if(!pid.equals("")&&pid!=null){
                	if (pid.equals(s_pid)) {
                		return true;
                    }
                }
            }
        } catch(NullPointerException e){
        	logger.info("pid ========="+pid);
        }finally {
            kernel32.CloseHandle(snapshot);
        }
        return false;
    }

    public static void main(String[] args) { 
       //启动
      String pid =  WinAPIWithPath("D:\\BaiduDisk\\BaiduNetdisk\\baidunetdisk.exe", "","D:\\BaiduDisk\\BaiduNetdisk\\");
      System.out.println(pid);
    	//杀死进程
//    	killPid(11560);
       
    }

    /**
     * dll
     */
//  public interface windllObj extends Library {        //Library  StdCallLibrary //File.separator
//      //windllObj instanceDll = (windllObj) Native.loadLibrary("kernel32", windllObj.class);
//      windllObj instanceDll = (windllObj) Native.loadLibrary("windll", windllObj.class);
//      public int StartJob(String s_exe, String s_params);
//      public int GetLocalResource(String s_nic1, String s_nic2);
//  }
//
//  public static class mywindllObj implements windllObj {
//
//      @Override
//      public int GetLocalResource(String s_nic1, String s_nic2) {
//          return windllObj.instanceDll.GetLocalResource(s_nic1, s_nic2);
//      }
//
//      @Override
//      public int StartJob(String s_exe, String s_params) {
//          return windllObj.instanceDll.StartJob(s_exe, s_params);
//      }
//  }
}
