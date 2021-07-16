
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubFklb<br>
 * 类描述：付款类别<br>
 *
 * @author liushijie
 */
@ApiModel(value = "付款类别")
public class PubFklbEditReq {
    @NotNull(message = "付款类别不能为空")
    @ApiModelProperty(value = "付款类别", required = true)
    private Integer fklb;
    @NotNull(message = "类别名称不能为空")
    @ApiModelProperty(value = "类别名称", required = true)
    private String lbmc;
    @NotNull(message = "门诊使用不能为空")
    @ApiModelProperty(value = "门诊使用 0:未使用,1:使用", required = true)
    private Integer mzsy;
    @NotNull(message = "住院使用不能为空")
    @ApiModelProperty(value = "住院使用 0:未使用,1:使用", required = true)
    private Integer zysy;

    /**
     * 设置:付款类别
     */
    public void setFklb(Integer value) {
        this.fklb = value;
    }

    /**
     * 获取:付款类别
     */
    public Integer getFklb() {
        return fklb;
    }

    /**
     * 设置:类别名称
     */
    public void setLbmc(String value) {
        this.lbmc = value;
    }

    /**
     * 获取:类别名称
     */
    public String getLbmc() {
        return lbmc;
    }

    /**
     * 设置:门诊使用
     */
    public void setMzsy(Integer value) {
        this.mzsy = value;
    }

    /**
     * 获取:门诊使用
     */
    public Integer getMzsy() {
        return mzsy;
    }

    /**
     * 设置:住院使用
     */
    public void setZysy(Integer value) {
        this.zysy = value;
    }

    /**
     * 获取:住院使用
     */
    public Integer getZysy() {
        return zysy;
    }
}
