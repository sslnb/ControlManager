package com.arshiner.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Clsjkddb {
    private String jgxtlb;

    private String bm;

    private BigDecimal sjkbh;

    private String sjcq;

    private String sjcz;

    private String dqsjc;

    private String wcbj;

    private Timestamp gxsj;

    private BigDecimal id;

    private BigDecimal sjkstart;

    private BigDecimal sjkend;

    private String sbzt;

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public String getBm() {
        return bm;
    }

    public void setBm(String bm) {
        this.bm = bm == null ? null : bm.trim();
    }

    public BigDecimal getSjkbh() {
        return sjkbh;
    }

    public void setSjkbh(BigDecimal sjkbh) {
        this.sjkbh = sjkbh;
    }

    public String getSjcq() {
        return sjcq;
    }

    public void setSjcq(String sjcq) {
        this.sjcq = sjcq == null ? null : sjcq.trim();
    }

    public String getSjcz() {
        return sjcz;
    }

    public void setSjcz(String sjcz) {
        this.sjcz = sjcz == null ? null : sjcz.trim();
    }

    public String getDqsjc() {
        return dqsjc;
    }

    public void setDqsjc(String dqsjc) {
        this.dqsjc = dqsjc == null ? null : dqsjc.trim();
    }

    public String getWcbj() {
        return wcbj;
    }

    public void setWcbj(String wcbj) {
        this.wcbj = wcbj == null ? null : wcbj.trim();
    }

    public Timestamp getGxsj() {
        return gxsj;
    }

    public void setGxsj(Timestamp gxsj) {
        this.gxsj = gxsj;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getSjkstart() {
        return sjkstart;
    }

    public void setSjkstart(BigDecimal sjkstart) {
        this.sjkstart = sjkstart;
    }

    public BigDecimal getSjkend() {
        return sjkend;
    }

    public void setSjkend(BigDecimal sjkend) {
        this.sjkend = sjkend;
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }
}