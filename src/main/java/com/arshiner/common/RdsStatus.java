package com.arshiner.common;

public class RdsStatus {

	private String jkid; //接口标识
	private String jkmc; //接口名称
	private String str ; //返回值
	private String jkstatus; //接口状态
	
	public String getJkid() {
		return jkid;
	}
	public void setJkid(String jkid) {
		if (jkid.equals("81Q01")) {
			this.jkmc = "日志采集全局参数查询接口";
		}
		if (jkid.equals("81Q02")) {
			this.jkmc = "日志采集单表参数查询接口";
		}
		if (jkid.equals("81Q03")) {
			this.jkmc = "存量数据日志解析文件状态反馈接口";
		}
		if (jkid.equals("81Q04")) {
			this.jkmc = "增量数据日志解析文件状态反馈接口";
		}
		if (jkid.equals("81W01")) {
			this.jkmc = "采集软件心跳状态上报接口";
		}
		if (jkid.equals("81W02")) {
			this.jkmc = "采集软件运行状态写入接口";
		}
		if (jkid.equals("81W03")) {
			this.jkmc = "存量数据处理状态写入接口";
		}
		if (jkid.equals("81W04")) {
			this.jkmc = "存量数据块断点写入接口";
		}
		if (jkid.equals("81W05")) {
			this.jkmc = "存量数据文件信息写入接口";
		}
		if (jkid.equals("81W06")) {
			this.jkmc = "增量数据断点写入接口";
		}
		if (jkid.equals("81W07")) {
			this.jkmc = "增量数据文件信息写入接口";
		}
		if (jkid.equals("81W08")) {
			this.jkmc = "DDL数据审计信息写入接口";
		}
		if (jkid.equals("81W09")) {
			this.jkmc = "数据采集情况统计信息写入接口";
		}
		this.jkid = jkid;
	}
	public String getJkmc() {
		
		return jkmc;
	}
	public void setJkmc(String jkmc) {
		this.jkmc = jkmc;
	}
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	public String getJkstatus() {
		return jkstatus;
	}
	public void setJkstatus(String jkstatus) {
		this.jkstatus = jkstatus;
	}
	
	
}
