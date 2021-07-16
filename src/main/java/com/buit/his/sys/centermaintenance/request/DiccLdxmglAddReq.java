
package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类描述：项目关联-新增
 *
 * @author liushijie
 */
@ApiModel(value = "附加项目-项目关联-新增")
public class DiccLdxmglAddReq {
    @NotNull(message = "项目序号不能为空")
    @ApiModelProperty(value = "项目序号",required = true)
    private Integer xmxh;
    @NotNull(message = "使用类别不能为空")
    @ApiModelProperty(value = "使用类别 | 1.门诊 2。住院",required = true)
    private Integer sylb;
    @NotNull(message = "关联序号不能为空")
    @ApiModelProperty(value = "关联序号",required = true)
    private Integer glxh;
    @NotNull(message = "科室代码不能为空")
    @ApiModelProperty(value = "科室代码",required = true)
    private Integer ksdm;
    @ApiModelProperty(value = "费用数量")
    private BigDecimal fysl;

    /**
     * 设置:项目序号
     */
    public void setXmxh(Integer value) {
        this.xmxh = value;
    }

    /**
     * 获取:项目序号
     */
    public Integer getXmxh() {
        return xmxh;
    }

    /**
     * 设置:使用类别 | 1.门诊 2。住院
     */
    public void setSylb(Integer value) {
        this.sylb = value;
    }

    /**
     * 获取:使用类别 | 1.门诊 2。住院
     */
    public Integer getSylb() {
        return sylb;
    }

    /**
     * 设置:关联序号
     */
    public void setGlxh(Integer value) {
        this.glxh = value;
    }

    /**
     * 获取:关联序号
     */
    public Integer getGlxh() {
        return glxh;
    }

    /**
     * 设置:科室代码
     */
    public void setKsdm(Integer value) {
        this.ksdm = value;
    }

    /**
     * 获取:科室代码
     */
    public Integer getKsdm() {
        return ksdm;
    }

    /**
     * 设置:费用数量
     */
    public void setFysl(BigDecimal value) {
        this.fysl = value;
    }

    /**
     * 获取:费用数量
     */
    public BigDecimal getFysl() {
        return fysl;
    }
}
