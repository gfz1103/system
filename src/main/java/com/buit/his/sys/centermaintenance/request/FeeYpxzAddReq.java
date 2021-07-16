
package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeYpxzAddReq<br>
 * 类描述：病人性质维护-药品限制<br>
 *
 * @author liushijie
 */
@ApiModel(value = "病人性质维护-药品限制")
public class FeeYpxzAddReq {
    @NotNull(message = "病人性质不能为空")
    @ApiModelProperty(value = "病人性质", required = true)
    private Integer brxz;
    @NotNull(message = "药品序号不能为空")
    @ApiModelProperty(value = "药品序号", required = true)
    private Integer ypxh;
    @NotNull(message = "自负比例不能为空")
    @ApiModelProperty(value = "自负比例", required = true)
    private BigDecimal zfbl;
    @NotNull(message = "药品限额不能为空")
    @ApiModelProperty(value = "药品限额", required = true)
    private BigDecimal ypxe;

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

    public BigDecimal getYpxe() {
        return ypxe;
    }

    public void setYpxe(BigDecimal ypxe) {
        this.ypxe = ypxe;
    }
}
