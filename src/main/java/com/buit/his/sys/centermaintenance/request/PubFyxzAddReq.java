package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubFyxz<br>
 * 类描述：公用_费用禁用_新增<br>
 *
 * @author liushijie
 */
@ApiModel(value = "公用_费用禁用_新增")
public class PubFyxzAddReq {
    @NotNull(message = "病人性质不能为空")
    @ApiModelProperty(value = "病人性质",required = true)
    private Integer brxz;
    @NotNull(message = "费用序号不能为空")
    @ApiModelProperty(value = "费用序号",required = true)
    private Integer fyxh;
    @NotNull(message = "自负比例不能为空")
    @ApiModelProperty(value = "自负比例",required = true)
    private BigDecimal zfbl;
    @ApiModelProperty(value = "特殊标志，是否走纯自费")
    private String tsbz;
    @NotNull(message = "费用限额不能为空")
    @ApiModelProperty(value="费用限额 | =0：没有限额 >0：有限额",required = true)
    private BigDecimal fyxe;
    @ApiModelProperty(value = "编辑时，旧的fyxh")
    private Integer oldFyxh;
    /**
     * 设置:病人性质
     */
    public void setBrxz(Integer value) {
        this.brxz = value;
    }

    /**
     * 获取:病人性质
     */
    public Integer getBrxz() {
        return brxz;
    }

    /**
     * 设置:费用序号
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }

    /**
     * 获取:费用序号
     */
    public Integer getFyxh() {
        return fyxh;
    }

    /**
     * 设置:自负比例
     */
    public void setZfbl(BigDecimal value) {
        this.zfbl = value;
    }

    /**
     * 获取:自负比例
     */
    public BigDecimal getZfbl() {
        return zfbl;
    }

    /**
     * 设置:特殊标志，是否走纯自费
     */
    public void setTsbz(String value) {
        this.tsbz = value;
    }

    /**
     * 获取:特殊标志，是否走纯自费
     */
    public String getTsbz() {
        return tsbz;
    }

    public BigDecimal getFyxe() {
        return fyxe;
    }

    public void setFyxe(BigDecimal fyxe) {
        this.fyxe = fyxe;
    }

    public Integer getOldFyxh() {
        return oldFyxh;
    }

    public void setOldFyxh(Integer oldFyxh) {
        this.oldFyxh = oldFyxh;
    }
}
