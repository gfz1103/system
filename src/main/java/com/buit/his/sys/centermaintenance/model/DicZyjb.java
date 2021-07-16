package com.buit.his.sys.centermaintenance.model;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：DicZyjb<br>
 * 类描述：中医疾病
 *
 * @author liushijie
 * @ApiModel(value="中医疾病")
 */
public class DicZyjb extends PageQuery {
    @ApiModelProperty(value = "疾病标识")
    private Integer jbbs;
    @ApiModelProperty(value = "中医分类")
    private Integer zyfl;
    @ApiModelProperty(value = "疾病代码")
    private String jbdm;
    @ApiModelProperty(value = "疾病名称")
    private String jbmc;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "五笔码")
    private String wbdm;
    @ApiModelProperty(value = "其它码")
    private String qtdm;
    @ApiModelProperty(value = "性别限制")
    private Integer xbxz;
    @ApiModelProperty(value = "允许治愈")
    private Integer yxzy;
    @ApiModelProperty(value = "允许好转")
    private Integer yxhz;
    @ApiModelProperty(value = "允许未愈")
    private Integer yxwy;
    @ApiModelProperty(value = "允许死亡")
    private Integer yxsw;
    @ApiModelProperty(value = "允许其它")
    private Integer yxqt;
    @ApiModelProperty(value = "控制方式")
    private Integer kzfs;
    @ApiModelProperty(value = "注销标志")
    private Integer zxbz;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;

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
     * 设置:中医分类
     */
    public void setZyfl(Integer value) {
        this.zyfl = value;
    }

    /**
     * 获取:中医分类
     */
    public Integer getZyfl() {
        return zyfl;
    }

    /**
     * 设置:疾病代码
     */
    public void setJbdm(String value) {
        this.jbdm = value;
    }

    /**
     * 获取:疾病代码
     */
    public String getJbdm() {
        return jbdm;
    }

    /**
     * 设置:疾病名称
     */
    public void setJbmc(String value) {
        this.jbmc = value;
    }

    /**
     * 获取:疾病名称
     */
    public String getJbmc() {
        return jbmc;
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
     * 设置:五笔码
     */
    public void setWbdm(String value) {
        this.wbdm = value;
    }

    /**
     * 获取:五笔码
     */
    public String getWbdm() {
        return wbdm;
    }

    /**
     * 设置:其它码
     */
    public void setQtdm(String value) {
        this.qtdm = value;
    }

    /**
     * 获取:其它码
     */
    public String getQtdm() {
        return qtdm;
    }

    /**
     * 设置:性别限制
     */
    public void setXbxz(Integer value) {
        this.xbxz = value;
    }

    /**
     * 获取:性别限制
     */
    public Integer getXbxz() {
        return xbxz;
    }

    /**
     * 设置:允许治愈
     */
    public void setYxzy(Integer value) {
        this.yxzy = value;
    }

    /**
     * 获取:允许治愈
     */
    public Integer getYxzy() {
        return yxzy;
    }

    /**
     * 设置:允许好转
     */
    public void setYxhz(Integer value) {
        this.yxhz = value;
    }

    /**
     * 获取:允许好转
     */
    public Integer getYxhz() {
        return yxhz;
    }

    /**
     * 设置:允许未愈
     */
    public void setYxwy(Integer value) {
        this.yxwy = value;
    }

    /**
     * 获取:允许未愈
     */
    public Integer getYxwy() {
        return yxwy;
    }

    /**
     * 设置:允许死亡
     */
    public void setYxsw(Integer value) {
        this.yxsw = value;
    }

    /**
     * 获取:允许死亡
     */
    public Integer getYxsw() {
        return yxsw;
    }

    /**
     * 设置:允许其它
     */
    public void setYxqt(Integer value) {
        this.yxqt = value;
    }

    /**
     * 获取:允许其它
     */
    public Integer getYxqt() {
        return yxqt;
    }

    /**
     * 设置:控制方式
     */
    public void setKzfs(Integer value) {
        this.kzfs = value;
    }

    /**
     * 获取:控制方式
     */
    public Integer getKzfs() {
        return kzfs;
    }

    /**
     * 设置:注销标志
     */
    public void setZxbz(Integer value) {
        this.zxbz = value;
    }

    /**
     * 获取:注销标志
     */
    public Integer getZxbz() {
        return zxbz;
    }

    /**
     * 设置:备注信息
     */
    public void setBzxx(String value) {
        this.bzxx = value;
    }

    /**
     * 获取:备注信息
     */
    public String getBzxx() {
        return bzxx;
    }


}
