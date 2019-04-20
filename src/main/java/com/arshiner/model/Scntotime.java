package com.arshiner.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Scntotime  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jgxtlb;

    private String scn;

    private Timestamp time;

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public String getScn() {
        return scn;
    }

    public void setScn(String scn) {
        this.scn = scn == null ? null : scn.trim();
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }
}