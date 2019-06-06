package com.arshiner.model;

import java.math.BigDecimal;
import java.util.Date;

public class Sjltjjg {
    private String hdph;

    private String bm;

    private String jgxtlb;

    private String tjrq;

    private BigDecimal tjsl;

    private Date gxsj;

    private String csbj;

    private String bjcsbj;

    private Date tbTime;

    private String zsazdm;

    private String sbzt;

    public String getHdph() {
        return hdph;
    }

    public void setHdph(String hdph) {
        this.hdph = hdph == null ? null : hdph.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public String getTjrq() {
        return tjrq;
    }

    public void setTjrq(String tjrq) {
        this.tjrq = tjrq == null ? null : tjrq.trim();
    }

    public BigDecimal getTjsl() {
        return tjsl;
    }

    public void setTjsl(BigDecimal tjsl) {
        this.tjsl = tjsl;
    }

    public Date getGxsj() {
        return gxsj;
    }

    public void setGxsj(Date gxsj) {
        this.gxsj = gxsj;
    }

    public String getCsbj() {
        return csbj;
    }

    public void setCsbj(String csbj) {
        this.csbj = csbj == null ? null : csbj.trim();
    }

    public String getBjcsbj() {
        return bjcsbj;
    }

    public void setBjcsbj(String bjcsbj) {
        this.bjcsbj = bjcsbj == null ? null : bjcsbj.trim();
    }

    public Date getTbTime() {
        return tbTime;
    }

    public void setTbTime(Date tbTime) {
        this.tbTime = tbTime;
    }

    public String getZsazdm() {
        return zsazdm;
    }

    public void setZsazdm(String zsazdm) {
        this.zsazdm = zsazdm == null ? null : zsazdm.trim();
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }
}