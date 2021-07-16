package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ImDicYpyf<br>
 * 类描述：住院_药品用法_新增<br>
 *
 * @author liushijie
 */
@ApiModel(value = "住院_药品用法_新增")
public class ImDicYpyfAddReq {
    @NotNull(message = "项目名称不能为空")
    @ApiModelProperty(value = "项目名称",required = true)
    private String xmmc;
    @ApiModelProperty(value = "项目类别")
    private Integer xmlb;
    @ApiModelProperty(value = "附加项目")
    private Integer fyxh;
    @ApiModelProperty(value = "医嘱排序")
    private Integer yzpx;
    @ApiModelProperty(value = "科室打印")
    private Integer kpdy;
    @ApiModelProperty(value = "bzbm")
    private String bzbm;
    @ApiModelProperty(value = "发药方式")
    private Integer fyfs;


    public Integer getFyfs() {
        return fyfs;
    }

    public void setFyfs(Integer fyfs) {
        this.fyfs = fyfs;
    }

    /**
     * 设置:项目名称
     */
    public void setXmmc(String value) {
        this.xmmc = value;
    }

    /**
     * 获取:项目名称
     */
    public String getXmmc() {
        return xmmc;
    }

    /**
     * 设置:项目类别
     */
    public void setXmlb(Integer value) {
        this.xmlb = value;
    }

    /**
     * 获取:项目类别
     */
    public Integer getXmlb() {
        return xmlb;
    }

    /**
     * 设置:附加项目
     */
    public void setFyxh(Integer value) {
        this.fyxh = value;
    }

    /**
     * 获取:附加项目
     */
    public Integer getFyxh() {
        return fyxh;
    }

    /**
     * 设置:医嘱排序
     */
    public void setYzpx(Integer value) {
        this.yzpx = value;
    }

    /**
     * 获取:医嘱排序
     */
    public Integer getYzpx() {
        return yzpx;
    }

    /**
     * 设置:科室打印
     */
    public void setKpdy(Integer value) {
        this.kpdy = value;
    }

    /**
     * 获取:科室打印
     */
    public Integer getKpdy() {
        return kpdy;
    }

    /**
     * 设置:bzbm
     */
    public void setBzbm(String value) {
        this.bzbm = value;
    }

    /**
     * 获取:bzbm
     */
    public String getBzbm() {
        return bzbm;
    }
}
