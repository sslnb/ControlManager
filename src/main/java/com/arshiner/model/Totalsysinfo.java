package com.arshiner.model;

public class Totalsysinfo {
    private Integer cpu;

    private Integer mem;

    private Integer dev;

    private Integer jvm;

    private String instime;

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Integer getMem() {
        return mem;
    }

    public void setMem(Integer mem) {
        this.mem = mem;
    }

    public Integer getDev() {
        return dev;
    }

    public void setDev(Integer dev) {
        this.dev = dev;
    }

    public Integer getJvm() {
        return jvm;
    }

    public void setJvm(Integer jvm) {
        this.jvm = jvm;
    }

    public String getInstime() {
        return instime;
    }

    public void setInstime(String instime) {
        this.instime = instime == null ? null : instime.trim();
    }
}