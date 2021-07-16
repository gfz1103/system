package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ImDicYpyf<br>
 * 类描述：住院_药品用法<br>
 *
 * @author liushijie
 */
@ApiModel(value = "住院_药品用法")
public class ImDicYpyfReq {
    @ApiModelProperty(value = "药品用法序号")
    private Integer ypyf;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "项目名称")
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

    /**
     * 设置:药品用法序号
     */
    public void setYpyf(Integer value) {
        this.ypyf = value;
    }

    /**
     * 获取:药品用法序号
     */
    public Integer getYpyf() {
        return ypyf;
    }

    /**
     * 设置:拼音码
     */
    public void setPydm(String value) {
        this.pydm = value;
    }

    /**
     * 获取:拼音码
     */
    public String getPydm() {
        return pydm;
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
