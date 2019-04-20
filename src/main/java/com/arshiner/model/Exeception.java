package com.arshiner.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Exeception  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BigDecimal id;

    private String jgxtlb;

    private String jobname;

    private String desciption;

    private Timestamp createtime;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public String getJobname() {
        return jobname;
    }

    public void setJobname(String jobname) {
        this.jobname = jobname == null ? null : jobname.trim();
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption == null ? null : desciption.trim();
    }

    public Timestamp getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Timestamp createtime) {
        this.createtime = createtime;
    }
}