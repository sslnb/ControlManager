package com.arshiner.model;

import java.math.BigDecimal;
import java.util.Date;

public class Userinfo {
    private BigDecimal userid;

    private String usercode;

    private String userpass;

    private Date createtime;

    private BigDecimal userrole;

    private BigDecimal id;

    public BigDecimal getUserid() {
        return userid;
    }

    public void setUserid(BigDecimal userid) {
        this.userid = userid;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass == null ? null : userpass.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public BigDecimal getUserrole() {
        return userrole;
    }

    public void setUserrole(BigDecimal userrole) {
        this.userrole = userrole;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }
}