package com.arshiner.model;

import java.math.BigDecimal;
import java.util.Date;

public class Agent {
    private String kip;

    private String jgxtlb;

    private String staius;

    private BigDecimal cpu;

    private BigDecimal nc;

    private BigDecimal cp;

    private Date time;

    public String getKip() {
        return kip;
    }

    public void setKip(String kip) {
        this.kip = kip == null ? null : kip.trim();
    }

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public String getStaius() {
        return staius;
    }

    public void setStaius(String staius) {
        this.staius = staius == null ? null : staius.trim();
    }

    public BigDecimal getCpu() {
        return cpu;
    }

    public void setCpu(BigDecimal cpu) {
        this.cpu = cpu;
    }

    public BigDecimal getNc() {
        return nc;
    }

    public void setNc(BigDecimal nc) {
        this.nc = nc;
    }

    public BigDecimal getCp() {
        return cp;
    }

    public void setCp(BigDecimal cp) {
        this.cp = cp;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}