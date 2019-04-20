package com.arshiner.model;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Cjrjxt {
    private String babh;  //备案编号

    private String sbrq; //上报周期

    private BigDecimal cpusyl; //cpu使用率

    private BigDecimal ncsyl; //内存使用率

    private BigDecimal cpsyl; //磁盘使用率

    private BigDecimal xtfz; //系统负载

    private Timestamp gxsj; //更新时间

    private String sbzt;//时间  小时

    public String getBabh() {
        return babh;
    }

    public void setBabh(String babh) {
        this.babh = babh == null ? null : babh.trim();
    }

    public String getSbrq() {
        return sbrq;
    }

    public void setSbrq(String sbrq) {
        this.sbrq = sbrq == null ? null : sbrq.trim();
    }

    public BigDecimal getCpusyl() {
        return cpusyl;
    }

    public void setCpusyl(BigDecimal cpusyl) {
        this.cpusyl = cpusyl;
    }

    public BigDecimal getNcsyl() {
        return ncsyl;
    }

    public void setNcsyl(BigDecimal ncsyl) {
        this.ncsyl = ncsyl;
    }

    public BigDecimal getCpsyl() {
        return cpsyl;
    }

    public void setCpsyl(BigDecimal cpsyl) {
        this.cpsyl = cpsyl;
    }

    public BigDecimal getXtfz() {
        return xtfz;
    }

    public void setXtfz(BigDecimal xtfz) {
        this.xtfz = xtfz;
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
}