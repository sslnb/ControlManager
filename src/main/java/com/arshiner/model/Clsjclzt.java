package com.arshiner.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Clsjclzt  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jgxtlb;

    private String bm;

    private String cjzt;

    private Timestamp ccqdsj;

    private Timestamp zjqdsj;

    private Timestamp cjwcsj;

    private BigDecimal sjzl;

    private BigDecimal cjsjzl;

    private String zhwjm;

    private String rkzt;

    private Timestamp rkwcsj;

    private BigDecimal rksjzl;

    private BigDecimal rkwjs;

    private String cwxxms;

    private Timestamp gxsj;

    private BigDecimal cjwjs;

    private BigDecimal id;

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

    public String getCjzt() {
        return cjzt;
    }

    public void setCjzt(String cjzt) {
        this.cjzt = cjzt == null ? null : cjzt.trim();
    }

    public Timestamp getCcqdsj() {
        return ccqdsj;
    }

    public void setCcqdsj(Timestamp ccqdsj) {
        this.ccqdsj = ccqdsj;
    }

    public Timestamp getZjqdsj() {
        return zjqdsj;
    }

    public void setZjqdsj(Timestamp zjqdsj) {
        this.zjqdsj = zjqdsj;
    }

    public Timestamp getCjwcsj() {
        return cjwcsj;
    }

    public void setCjwcsj(Timestamp cjwcsj) {
        this.cjwcsj = cjwcsj;
    }

    public BigDecimal getSjzl() {
        return sjzl;
    }

    public void setSjzl(BigDecimal sjzl) {
        this.sjzl = sjzl;
    }

    public BigDecimal getCjsjzl() {
        return cjsjzl;
    }

    public void setCjsjzl(BigDecimal cjsjzl) {
        this.cjsjzl = cjsjzl;
    }

    public String getZhwjm() {
        return zhwjm;
    }

    public void setZhwjm(String zhwjm) {
        this.zhwjm = zhwjm == null ? null : zhwjm.trim();
    }

    public String getRkzt() {
        return rkzt;
    }

    public void setRkzt(String rkzt) {
        this.rkzt = rkzt == null ? null : rkzt.trim();
    }

    public Timestamp getRkwcsj() {
        return rkwcsj;
    }

    public void setRkwcsj(Timestamp rkwcsj) {
        this.rkwcsj = rkwcsj;
    }

    public BigDecimal getRksjzl() {
        return rksjzl;
    }

    public void setRksjzl(BigDecimal rksjzl) {
        this.rksjzl = rksjzl;
    }

    public BigDecimal getRkwjs() {
        return rkwjs;
    }

    public void setRkwjs(BigDecimal rkwjs) {
        this.rkwjs = rkwjs;
    }

    public String getCwxxms() {
        return cwxxms;
    }

    public void setCwxxms(String cwxxms) {
        this.cwxxms = cwxxms == null ? null : cwxxms.trim();
    }

    public Timestamp getGxsj() {
        return gxsj;
    }

    public void setGxsj(Timestamp gxsj) {
        this.gxsj = gxsj;
    }

    public BigDecimal getCjwjs() {
        return cjwjs;
    }

    public void setCjwjs(BigDecimal cjwjs) {
        this.cjwjs = cjwjs;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSbzt() {
        return sbzt;
    }

    public void setSbzt(String sbzt) {
        this.sbzt = sbzt == null ? null : sbzt.trim();
    }
}