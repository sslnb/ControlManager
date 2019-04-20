package com.arshiner.model;

import java.io.Serializable;

public class Rzcjqjcs  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String gjz;

    private String csmc;

    private String mrz;

    public String getGjz() {
        return gjz;
    }

    public void setGjz(String gjz) {
        this.gjz = gjz == null ? null : gjz.trim();
    }

    public String getCsmc() {
        return csmc;
    }

    public void setCsmc(String csmc) {
        this.csmc = csmc == null ? null : csmc.trim();
    }

    public String getMrz() {
        return mrz;
    }

    public void setMrz(String mrz) {
        this.mrz = mrz == null ? null : mrz.trim();
    }
}