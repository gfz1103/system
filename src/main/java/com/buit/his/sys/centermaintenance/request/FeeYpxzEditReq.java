package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeYpxz<br>
 * 类描述：公用_药品禁用编辑<br>
 *
 * @author "MLeo"
 */
@ApiModel(value = "公用_药品禁用编辑")
public class FeeYpxzEditReq {
    @NotNull(message = "病人性质不能为空")
    @ApiModelProperty(value = "病人性质", required = true)
    private Integer brxz;
    @NotNull(message = "药品序号不能为空")
    @ApiModelProperty(value = "药品序号", required = true)
    private Integer ypxh;
    @NotNull(message = "自负比例不能为空")
    @ApiModelProperty(value = "自负比例", required = true)
    private BigDecimal zfbl;

    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public Integer getYpxh() {
        return ypxh;
    }

    public void setYpxh(Integer ypxh) {
        this.ypxh = ypxh;
    }

    public BigDecimal getZfbl() {
        return zfbl;
    }

    public void setZfbl(BigDecimal zfbl) {
        this.zfbl = zfbl;
    }
}
