
package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 治疗管理收费项目明细
 * zhouhaihseng
 */

@ApiModel(value="治疗管理收费项目明细")
public class FeeYlsfxmZlmxResp {

    @ApiModelProperty(value="费用名称(手术名称)")
    private String fymc;

    @ApiModelProperty(value="费用序号", hidden = true)
    private Integer fyxh;
    @ApiModelProperty(value="费用单位", hidden = true)
    private String fydw;

    @ApiModelProperty(value="费用单价")
    private BigDecimal fydj;

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
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
