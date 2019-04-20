package com.arshiner.model;

import java.io.Serializable;
import java.util.Date;

public class Babh  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String babh;

    private String jkxlh;

    private String ip;

    private String port;

    private String mac;

    private Date time;

    private String sbzq;

    public String getBabh() {
        return babh;
    }

    public void setBabh(String babh) {
        this.babh = babh == null ? null : babh.trim();
    }

    public String getJkxlh() {
        return jkxlh;
    }

    public void setJkxlh(String jkxlh) {
        this.jkxlh = jkxlh == null ? null : jkxlh.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac == null ? null : mac.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSbzq() {
        return sbzq;
    }

    public void setSbzq(String sbzq) {
        this.sbzq = sbzq == null ? null : sbzq.trim();
    }
}