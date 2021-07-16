
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DiccJbzzgl<br>
 * 类描述：疾病治则关联<br>
 *
 * @author liushijie
 */
@ApiModel(value = "疾病治则关联")
public class DiccJbzzglReq {
    @ApiModelProperty(value = "关联标识")
    private Integer glbs;
    @ApiModelProperty(value = "疾病标识")
    private Integer jbbs;
    @ApiModelProperty(value = "证侯标识")
    private Integer zhbs;
    @ApiModelProperty(value = "治则标识")
    private Integer zzbs;
    @ApiModelProperty(value = "备注信息")
    private String bbxx;

    /**
     * 设置:关联标识
     */
    public void setGlbs(Integer value) {
        this.glbs = value;
    }

    /**
     * 获取:关联标识
     */
    public Integer getGlbs() {
        return glbs;
    }

    /**
     * 设置:疾病标识
     */
    public void setJbbs(Integer value) {
        this.jbbs = value;
    }

    /**
     * 获取:疾病标识
     */
    public Integer getJbbs() {
        return jbbs;
    }

    /**
     * 设置:证侯标识
     */
    public void setZhbs(Integer value) {
        this.zhbs = value;
    }

    /**
     * 获取:证侯标识
     */
    public Integer getZhbs() {
        return zhbs;
    }

    /**
     * 设置:治则标识
     */
    public void setZzbs(Integer value) {
        this.zzbs = value;
    }

    /**
     * 获取:治则标识
     */
    public Integer getZzbs() {
        return zzbs;
    }

    /**
     * 设置:备注信息
     */
    public void setBbxx(String value) {
        this.bbxx = value;
    }

    /**
     * 获取:备注信息
     */
    public String getBbxx() {
        return bbxx;
    }
}
