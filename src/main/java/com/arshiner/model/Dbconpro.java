package com.arshiner.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class Dbconpro {
    private String ip;

    private String port;

    private String sid;

    private String servicename;

    private String schema;

    private String username;

    private String password;

    private String jgxtlb;

    private String azdm;

    private BigDecimal agentype;

    private String syljas;

    private BigDecimal id;

    private BigDecimal zlnum;

    private BigDecimal clnum;

    private Timestamp startepoch;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port == null ? null : port.trim();
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename == null ? null : servicename.trim();
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema == null ? null : schema.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getJgxtlb() {
        return jgxtlb;
    }

    public void setJgxtlb(String jgxtlb) {
        this.jgxtlb = jgxtlb == null ? null : jgxtlb.trim();
    }

    public String getAzdm() {
        return azdm;
    }

    public void setAzdm(String azdm) {
        this.azdm = azdm == null ? null : azdm.trim();
    }

    public BigDecimal getAgentype() {
        return agentype;
    }

    public void setAgentype(BigDecimal agentype) {
        this.agentype = agentype;
    }

    public String getSyljas() {
        return syljas;
    }

    public void setSyljas(String syljas) {
        this.syljas = syljas == null ? null : syljas.trim();
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getZlnum() {
        return zlnum;
    }

    public void setZlnum(BigDecimal zlnum) {
        this.zlnum = zlnum;
    }

    public BigDecimal getClnum() {
        return clnum;
    }

    public void setClnum(BigDecimal clnum) {
        this.clnum = clnum;
    }

    public Timestamp getStartepoch() {
        return startepoch;
    }

    public void setStartepoch(Timestamp startepoch) {
        this.startepoch = startepoch;
    }
}