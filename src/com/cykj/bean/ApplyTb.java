package com.cykj.bean;


import java.math.BigDecimal;
import java.sql.Date;

public class ApplyTb {
    private Date adate;
    private String apeople;
    private String anum;
    private Date aauditdate;
    private String aauditp;
    private String astate;
    private BigDecimal rn;

    public ApplyTb() {
    }

    public ApplyTb(Date adate, String apeople, String anum, Date aauditdate, String aauditp, String astate, BigDecimal rn) {
        this.adate = adate;
        this.apeople = apeople;
        this.anum = anum;
        this.aauditdate = aauditdate;
        this.aauditp = aauditp;
        this.astate = astate;
        this.rn = rn;
    }

    public Date getAdate() {
        return adate;
    }

    public void setAdate(Date adate) {
        this.adate = adate;
    }

    public String getApeople() {
        return apeople;
    }

    public void setApeople(String apeople) {
        this.apeople = apeople;
    }

    public String getAnum() {
        return anum;
    }

    public void setAnum(String anum) {
        this.anum = anum;
    }

    public Date getAauditdate() {
        return aauditdate;
    }

    public void setAauditdate(Date aauditdate) {
        this.aauditdate = aauditdate;
    }

    public String getAstate() {
        return astate;
    }

    public void setAstate(String astate) {
        this.astate = astate;
    }

    public BigDecimal getRn() {
        return rn;
    }

    public void setRn(BigDecimal rn) {
        this.rn = rn;
    }

    public String getAauditp() {
        return aauditp;
    }

    public void setAauditp(String aauditp) {
        this.aauditp = aauditp;
    }

    @Override
    public String toString() {
        return "ApplyTb{" +
                "adate=" + adate +
                ", apeople='" + apeople + '\'' +
                ", anum='" + anum + '\'' +
                ", aauditdate=" + aauditdate +
                ", aauditp='" + aauditp + '\'' +
                ", astate='" + astate + '\'' +
                ", rn=" + rn +
                '}';
    }
}
