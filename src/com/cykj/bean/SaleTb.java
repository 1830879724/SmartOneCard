package com.cykj.bean;

import java.math.BigDecimal;

public class SaleTb {
    private BigDecimal sid;
    private String scardid;
    private String ssellp;//销售人
    private String sstate;
    private BigDecimal rn;
    private String aname;

    public SaleTb() {
    }

    public SaleTb(BigDecimal sid, String scardid, String ssellp, String sstate, BigDecimal rn, String aname) {
        this.sid = sid;
        this.scardid = scardid;
        this.ssellp = ssellp;
        this.sstate = sstate;
        this.rn = rn;
        this.aname = aname;
    }

    public BigDecimal getSid() {
        return sid;
    }

    public void setSid(BigDecimal sid) {
        this.sid = sid;
    }

    public String getScardid() {
        return scardid;
    }

    public void setScardid(String scardid) {
        this.scardid = scardid;
    }

    public String getSsellp() {
        return ssellp;
    }

    public void setSsellp(String ssellp) {
        this.ssellp = ssellp;
    }

    public String getSstate() {
        return sstate;
    }

    public void setSstate(String sstate) {
        this.sstate = sstate;
    }

    public BigDecimal getRn() {
        return rn;
    }

    public void setRn(BigDecimal rn) {
        this.rn = rn;
    }


    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    @Override
    public String toString() {
        return "SaleTb{" +
                "sid=" + sid +
                ", scardid='" + scardid + '\'' +
                ", ssellp='" + ssellp + '\'' +
                ", sstate='" + sstate + '\'' +
                ", rn=" + rn +
                ", aname='" + aname + '\'' +
                '}';
    }
}
