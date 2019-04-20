package com.arshiner.common;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.ini4j.Ini;
import org.ini4j.Wini;

/**
 * @author William
 */
public final class ConfigFile {
	public  static final String Alivedbconf=FilePathName.ROOT+"Alivedb.conf";
	public  static final String Captureout=FilePathName.ROOT+"capture.out";

	public static void main(String[] args) {
		String encoding = "UTF-8";
	    File file = new File(FilePathName.ROOT+"capture.out");
	    try{
	    if (file.isFile() && file.exists()) { //判断文件是否存在
	        InputStreamReader read = new InputStreamReader(
	                new FileInputStream(file), encoding);//考虑到编码格式
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	        while ((lineTxt = bufferedReader.readLine()) != null) {
	               System.out.println(lineTxt);         
	         }       
	        read.close();
	    } else {
	        System.out.println("找不到指定的文件");
	    }
	} catch (Exception e) {
	    System.out.println("读取文件内容出错");
	    e.printStackTrace();
	}
	}
    //读取某个键值
    public static String getIniValue(String s_file, String s_section, String s_key) {
        Ini ini = new Ini();
        try {
            ini.load(new File(s_file));
        } catch (IOException ex) {
            //Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }
        String s_ret = ini.get(s_section, s_key);
        if (null == s_ret) {
            s_ret = "";
        } 
        return s_ret.trim();
    }
    
    public static boolean setIniValue(String s_file, String s_section, String s_key, String s_value) {
        Wini ini;
        try {
            ini = new Wini(new File(s_file));
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        ini.put(s_section, s_key, s_value);
        try {
            ini.store();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //可删除section，也可删除某个键值
    public static boolean delIniValue(String s_file, String s_section, String s_key) {
        Wini ini;
        try {
            ini = new Wini(new File(s_file));
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        if ("".equals(s_key)) {
            ini.remove(s_section);
        } else {
            ini.remove(s_section, s_key);
        }
        try {
            ini.store();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    //删除用户信息，删除节点信息
    public static String delIniSection(String s_file, String s_section) {
        Wini ini;
        try {
            ini = new Wini(new File(s_file));
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return "result=1";
        }
        for (int i = 1; i <= 10; i++) {
            ini.remove(s_section + String.valueOf(i));
        }
        try {
            ini.store();
            return "result=0";
        } catch (IOException ex) {
            Logger.getLogger(ConfigFile.class.getName()).log(Level.SEVERE, null, ex);
            return "result=1";
        }
    }
    
}
