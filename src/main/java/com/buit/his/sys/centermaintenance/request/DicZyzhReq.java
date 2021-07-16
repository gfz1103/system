
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicZyzh<br>
 *
 * @author liushijie
 */
@ApiModel(value = "中医证候编码维护")
public class DicZyzhReq {
    @ApiModelProperty(value = "证侯标识")
    private Integer zhbs;
    @ApiModelProperty(value = "证侯分类")
    private Integer zhfl;
    @ApiModelProperty(value = "证侯代码")
    private String zhdm;
    @ApiModelProperty(value = "证侯名称")
    private String zhmc;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "五笔码")
    private String wbdm;
    @ApiModelProperty(value = "其它码")
    private String qtdm;
    @ApiModelProperty(value = "注销标志 0:未注销 1:已注销")
    private Integer zxbz;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;

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
     * 设置:证侯分类
     */
    public void setZhfl(Integer value) {
        this.zhfl = value;
    }

    /**
     * 获取:证侯分类
     */
    public Integer getZhfl() {
        return zhfl;
    }

    /**
     * 设置:证侯代码
     */
    public void setZhdm(String value) {
        this.zhdm = value;
    }

    /**
     * 获取:证侯代码
     */
    public String getZhdm() {
        return zhdm;
    }

    /**
     * 设置:证侯名称
     */
    public void setZhmc(String value) {
        this.zhmc = value;
    }

    /**
     * 获取:证侯名称
     */
    public String getZhmc() {
        return zhmc;
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
     * 设置:注销标志 0:未注销 1:已注销
     */
    public void setZxbz(Integer value) {
        this.zxbz = value;
    }

    /**
     * 获取:注销标志 0:未注销 1:已注销
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
