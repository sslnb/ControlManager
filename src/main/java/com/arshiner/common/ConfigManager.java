package com.arshiner.common;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 配置文件获取
 * @author 士林
 *
 */
//@Component
public class ConfigManager {
	public  Properties properties= new Properties();
	private static boolean status=false;
	public static final String transmitPro=FilePathName.ROOT+"Alivedb.conf";
	public static final String capture=FilePathName.ROOT+"capture.out";
	public static final String babh=FilePathName.ROOT+"BaBh.properties";
	public static final String jdbc=FilePathName.ROOT+"jdbc.properties";
	private static ConfigManager trconfig = new ConfigManager();
	
	 // 静态工厂方法
    public static ConfigManager getInstance() {
        	if (trconfig == null) {
        		trconfig = new ConfigManager();
    		}
    		return trconfig;

    }
	private ConfigManager(){
	}
	public void input(String model){
		try{ 
	        InputStream is = new BufferedInputStream (new FileInputStream(model));
				properties.load(is);
				is.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		status=true;
	}
	
	public ConfigManager(String model){
		try{ 
			InputStream is = new BufferedInputStream (new FileInputStream(model));
			properties.load(is);
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		status=true;
	}
	/**
	 * @param confName
	 * @param model
	 * @param key
	 * @param value
	 * @return返回一个Atomic
	 */
	public boolean configGetAndSet(String key,String value,String model) {
		boolean sign = false;
			 FileOutputStream oFile ;
			try{ 
				 oFile = new FileOutputStream(model,false);
				 properties.setProperty(key, value);
				 properties.store(oFile, "The New properties file");
		         oFile.close();
				sign=true;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return sign;
	}

	
	
	
	
	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		ConfigManager.status = status;
	}

	
}
