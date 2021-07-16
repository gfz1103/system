package com.buit.his.sys.centermaintenance.model;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：TcmSyndromeDic<br>
 * 类描述：中医证候分类
 *
 * @author liushijie
 * @ApiModel(value="中医证候分类")
 */
public class DicZyzhfl extends PageQuery {
    @ApiModelProperty(value = "主键ID")
    private Integer id;
    @ApiModelProperty(value = "上级ID")
    private Integer parentId;
    @ApiModelProperty(value = "证候分类")
    private Integer zhfl;
    @ApiModelProperty(value = "分类编码")
    private String flbm;
    @ApiModelProperty(value = "分类代码")
    private String fldm;
    @ApiModelProperty(value = "分类名称")
    private String flmc;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "五笔码")
    private String wbdm;
    @ApiModelProperty(value = "注销标识")
    private Integer zxbz;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;

    /**
     * 设置:证候分类
     */
    public void setZhfl(Integer value) {
        this.zhfl = value;
    }

    /**
     * 获取:证候分类
     */
    public Integer getZhfl() {
        return zhfl;
    }

    /**
     * 设置:分类编码
     */
    public void setFlbm(String value) {
        this.flbm = value;
    }

    /**
     * 获取:分类编码
     */
    public String getFlbm() {
        return flbm;
    }

    /**
     * 设置:分类代码
     */
    public void setFldm(String value) {
        this.fldm = value;
    }

    /**
     * 获取:分类代码
     */
    public String getFldm() {
        return fldm;
    }

    /**
     * 设置:分类名称
     */
    public void setFlmc(String value) {
        this.flmc = value;
    }

    /**
     * 获取:分类名称
     */
    public String getFlmc() {
        return flmc;
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
     * 设置:注销标识
     */
    public void setZxbz(Integer value) {
        this.zxbz = value;
    }

    /**
     * 获取:注销标识
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}