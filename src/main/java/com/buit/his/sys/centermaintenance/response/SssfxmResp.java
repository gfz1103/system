package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/12/4 14:15
 */
public class SssfxmResp {

    private Integer fyxh;
    private String fymc;
    private String fydw;
    private BigDecimal fydj;

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public BigDecimal getFydj() {
        return fydj;
    }

    public void setFydj(BigDecimal fydj) {
        this.fydj = fydj;
    }
}
