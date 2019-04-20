package com.arshiner.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Ddlsjsjb  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String jgxtlb;

    private BigDecimal scn;

    private Long seq;

    private String orauser;

    private String oraschema;

    private String czlx;

    private String dxlx;

    private String dxm;

    private Timestamp czsj;

    private String nr;

    private Timestamp gxsj;

    private String sbzt;

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

    public Long getSeq() {
        return seq;
    }

    public void setSeq(Long seq) {
        this.seq = seq;
    }

    public String getOrauser() {
        return orauser;
    }

    public void setOrauser(String orauser) {
        this.orauser = orauser == null ? null : orauser.trim();
    }

    public String getOraschema() {
        return oraschema;
    }

    public void setOraschema(String oraschema) {
        this.oraschema = oraschema == null ? null : oraschema.trim();
    }

    public String getCzlx() {
        return czlx;
    }

    public void setCzlx(String czlx) {
        this.czlx = czlx == null ? null : czlx.trim();
    }

    public String getDxlx() {
        return dxlx;
    }

    public void setDxlx(String dxlx) {
        this.dxlx = dxlx == null ? null : dxlx.trim();
    }

    public String getDxm() {
        return dxm;
    }

    public void setDxm(String dxm) {
        this.dxm = dxm == null ? null : dxm.trim();
    }

    public Timestamp getCzsj() {
        return czsj;
    }

    public void setCzsj(Timestamp czsj) {
        this.czsj = czsj;
    }

    public String getNr() {
        return nr;
    }

    public void setNr(String nr) {
        this.nr = nr == null ? null : nr.trim();
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