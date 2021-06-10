package com.cykj.bean;

import java.math.BigDecimal;

public class PersonTb {
    private String pname;
    private String psection;
    private String prole;
    private String pstate;
    private String paccount;
    private String ppassword;
    private BigDecimal rn;

    public PersonTb() {
    }

    public PersonTb(String pname, String psection, String prole, String pstate, String paccount, String ppassword,BigDecimal rn) {
        this.pname = pname;
        this.psection = psection;
        this.prole = prole;
        this.pstate = pstate;
        this.paccount = paccount;
        this.ppassword = ppassword;
        this.rn = rn;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPsection() {
        return psection;
    }

    public void setPsection(String psection) {
        this.psection = psection;
    }

    public String getProle() {
        return prole;
    }

    public void setProle(String prole) {
        this.prole = prole;
    }

    public String getPstate() {
        return pstate;
    }

    public void setPstate(String pstate) {
        this.pstate = pstate;
    }

    public String getPaccount() {
        return paccount;
    }

    public void setPaccount(String paccount) {
        this.paccount = paccount;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    public BigDecimal getRn() {
        return rn;
    }

    public void setRn(BigDecimal rn) {
        this.rn = rn;
    }

    @Override
    public String toString() {
        return "PersonTb{" +
                "pname='" + pname + '\'' +
                ", psection='" + psection + '\'' +
                ", prole='" + prole + '\'' +
                ", pstate='" + pstate + '\'' +
                ", paccount='" + paccount + '\'' +
                ", ppassword='" + ppassword + '\'' +
                ", rn=" + rn +
                '}';
    }

}
