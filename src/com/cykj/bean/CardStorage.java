package com.cykj.bean;

import java.math.BigDecimal;
import java.sql.Date;

public class CardStorage {
    private BigDecimal cid;
    private String cradid;
    private Date cdate;
    private String cstate;
    private BigDecimal rn;

    public CardStorage() {
    }

    public CardStorage(BigDecimal cid, String cradid, Date cdate, String cstate, BigDecimal rn) {
        this.cid = cid;
        this.cradid = cradid;
        this.cdate = cdate;
        this.cstate = cstate;
        this.rn = rn;
    }

    public BigDecimal getCid() {
        return cid;
    }

    public void setCid(BigDecimal cid) {
        this.cid = cid;
    }

    public String getCradid() {
        return cradid;
    }

    public void setCradid(String cradid) {
        this.cradid = cradid;
    }

    public Date getCdate() {
        return cdate;
    }

    public void setCdate(Date cdate) {
        this.cdate = cdate;
    }

    public String getCstate() {
        return cstate;
    }

    public void setCstate(String cstate) {
        this.cstate = cstate;
    }

    public BigDecimal getRn() {
        return rn;
    }

    public void setRn(BigDecimal rn) {
        this.rn = rn;
    }

    @Override
    public String toString() {
        return "CardStorage{" +
                "cid=" + cid +
                ", cradid='" + cradid + '\'' +
                ", cdate=" + cdate +
                ", cstate='" + cstate + '\'' +
                ", rn=" + rn +
                '}';
    }
}
