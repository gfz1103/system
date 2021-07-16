package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeSfdlzfbl<br>
 * 类描述：公用_自负比例<br>
 *
 * @author ZHOUHAISHENG
 */
@ApiModel(value = "公用_自负比例")
public class FeeSfdlzfblReq {
    @ApiModelProperty(value = "收费项目")
    private Integer sfxm;
    @ApiModelProperty(value = "病人性质")
    private Integer brxz;
    @ApiModelProperty(value = "自负比例")
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
