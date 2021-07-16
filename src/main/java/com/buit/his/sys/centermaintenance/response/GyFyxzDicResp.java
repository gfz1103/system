
package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类描述：病人性质维护费用字典
 *
 * @author liushijie
 */

@ApiModel(value = "病人性质维护费用字典")
public class GyFyxzDicResp {
    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;
    @ApiModelProperty(value = "费用名称")
    private String fymc;
    @ApiModelProperty(value = "费用单位")
    private String fydw;
    @ApiModelProperty(value = "医保编码")
    private BigDecimal bzjg;

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

    public BigDecimal getBzjg() {
        return bzjg;
    }

    public void setBzjg(BigDecimal bzjg) {
        this.bzjg = bzjg;
    }
}