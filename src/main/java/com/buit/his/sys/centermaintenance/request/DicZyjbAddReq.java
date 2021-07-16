
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicZyjb<br>
 *
 * @author 老花生
 */
@ApiModel(value = "中医疾病编码")
public class DicZyjbAddReq {
    @NotNull(message = "中医分类不能为空")
    @ApiModelProperty(value = "中医分类", required = true)
    private Integer zyfl;
    @NotNull(message = "疾病代码不能为空")
    @ApiModelProperty(value = "疾病代码", required = true)
    private String jbdm;
    @NotNull(message = "疾病名称不能为空")
    @ApiModelProperty(value = "疾病名称", required = true)
    private String jbmc;

    /**
     * 设置:zyfl
     */
    public void setZyfl(Integer value) {
        this.zyfl = value;
    }

    /**
     * 获取:zyfl
     */
    public Integer getZyfl() {
        return zyfl;
    }

    /**
     * 设置:jbdm
     */
    public void setJbdm(String value) {
        this.jbdm = value;
    }

    /**
     * 获取:jbdm
     */
    public String getJbdm() {
        return jbdm;
    }

    /**
     * 设置:jbmc
     */
    public void setJbmc(String value) {
        this.jbmc = value;
    }

    /**
     * 获取:jbmc
     */
    public String getJbmc() {
        return jbmc;
    }

}
