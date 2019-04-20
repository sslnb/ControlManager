package com.arshiner.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Zlsjddb {
    private String jgxtlb;

    private BigDecimal scn;

    private BigDecimal seq;

    private Timestamp gxsj;

    private String sbzt;

    private String slh;

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public BigDecimal getScn() {
        return scn;
    }

    public void setScn(BigDecimal scn) {
        this.scn = scn;
    }

    public BigDecimal getSeq() {
        return seq;
    }

    public void setSeq(BigDecimal seq) {
        this.seq = seq;
    }

    public Timestamp getGxsj() {
        return gxsj;
    }

    public void setGxsj(Timestamp gxsj) {
        this.gxsj = gxsj;
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }

    public String getSlh() {
        return slh;
    }

    public void setSlh(String slh) {
        this.slh = slh == null ? null : slh.trim();
    }
}