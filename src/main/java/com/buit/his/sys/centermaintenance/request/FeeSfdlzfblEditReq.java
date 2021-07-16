package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeSfdlzfbl<br>
 * 类描述：自负比例-编辑<br>
 *
 * @author ZHOUHAISHENG
 */
@ApiModel(value = "自负比例-编辑")
public class FeeSfdlzfblEditReq {
    @NotNull(message = "收费项目不能为空")
    @ApiModelProperty(value = "收费项目",required = true)
    private Integer sfxm;
    @NotNull(message = "病人性质不能为空")
    @ApiModelProperty(value = "病人性质",required = true)
    private Integer brxz;
    @NotNull(message = "自负比例不能为空")
    @ApiModelProperty(value = "自负比例,0.1=10%",required = true)
    private BigDecimal zfbl;

    /**
     * 设置:收费项目
     */
    public void setSfxm(Integer value) {
        this.sfxm = value;
    }

    /**
     * 获取:收费项目
     */
    public Integer getSfxm() {
        return sfxm;
    }

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
}
