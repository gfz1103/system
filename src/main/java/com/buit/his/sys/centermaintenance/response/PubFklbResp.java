
package com.buit.his.sys.centermaintenance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubFklb<br>
 * 类描述：付款类别<br>
 *
 * @author liushijie
 */
@ApiModel(value = "付款类别")
public class PubFklbResp {
    @ApiModelProperty(value = "付款类别")
    private Long fklb;
    @ApiModelProperty(value = "类别名称")
    private String lbmc;
    @ApiModelProperty(value = "门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value = "住院使用")
    private Integer zysy;

    /**
     * 设置:付款类别
     */
    public void setFklb(Long value) {
        this.fklb = value;
    }

    /**
     * 获取:付款类别
     */
    public Long getFklb() {
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
