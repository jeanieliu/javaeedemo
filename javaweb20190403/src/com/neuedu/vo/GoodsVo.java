package com.neuedu.vo;

import java.math.BigDecimal;

public class GoodsVo {
    private Integer gid;
    private String gnum;
    private String gname;
    private BigDecimal gprice;
    private Integer gstock;
    private Integer gsell;
    private String gdesc;
    private String cname;

    @Override
    public String toString() {
        return "GoodsVo{" +
                "gid=" + gid +
                ", gnum='" + gnum + '\'' +
                ", gname='" + gname + '\'' +
                ", gprice=" + gprice +
                ", gstock=" + gstock +
                ", gsell=" + gsell +
                ", gdesc='" + gdesc + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGnum() {
        return gnum;
    }

    public void setGnum(String gnum) {
        this.gnum = gnum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public BigDecimal getGprice() {
        return gprice;
    }

    public void setGprice(BigDecimal gprice) {
        this.gprice = gprice;
    }

    public Integer getGstock() {
        return gstock;
    }

    public void setGstock(Integer gstock) {
        this.gstock = gstock;
    }

    public Integer getGsell() {
        return gsell;
    }

    public void setGsell(Integer gsell) {
        this.gsell = gsell;
    }

    public String getGdesc() {
        return gdesc;
    }

    public void setGdesc(String gdesc) {
        this.gdesc = gdesc;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
