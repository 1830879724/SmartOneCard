package com.cykj.bean;

import java.math.BigDecimal;

public class MenuToal {
    private String pname;
    private BigDecimal zid;
    private BigDecimal fid;
    private String url;

    public MenuToal() {
    }

    public MenuToal(String pname, BigDecimal zid, BigDecimal fid, String url) {
        this.pname = pname;
        this.zid = zid;
        this.fid = fid;
        this.url = url;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public BigDecimal getZid() {
        return zid;
    }

    public void setZid(BigDecimal zid) {
        this.zid = zid;
    }

    public BigDecimal getFid() {
        return fid;
    }

    public void setFid(BigDecimal fid) {
        this.fid = fid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "MenuToal{" +
                "pname='" + pname + '\'' +
                ", zid=" + zid +
                ", fid=" + fid +
                ", url='" + url + '\'' +
                '}';
    }
}
