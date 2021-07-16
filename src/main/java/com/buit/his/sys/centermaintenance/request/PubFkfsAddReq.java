
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;


/**
 * 类名称：PubFkfs<br>
 * 类描述：公用_付款方式 |  用于门诊及住院付款方式设定<br>
 *
 * @author liushijie
 */
@ApiModel(value = "公用_付款方式 ")
public class PubFkfsAddReq {
    @NotNull(message = "付款名称不能为空")
    @ApiModelProperty(value = "付款名称", required = true)
    private String fkmc;
    @NotNull(message = "使用类型不能为空")
    @ApiModelProperty(value = "使用类型 | 1.门诊使用   2.住院使用", required = true)
    private Integer sylx;
    @NotNull(message = "付款类别不能为空")
    @ApiModelProperty(value = "付款类别", required = true)
    private Integer fklb;
    @ApiModelProperty(value = "号码长度")
    private Integer hmcd;
    @NotNull(message = "付款精度不能为空")
    @ApiModelProperty(value = "付款精度", required = true)
    private Integer fkjd;
    @NotNull(message = "货币误差标志不能为空")
    @ApiModelProperty(value = "货币误差标志", required = true)
    private Integer hbwc;
    @NotNull(message = "舍入方式不能为空")
    @ApiModelProperty(value = "舍入方式 | 系统配置舍入方式(2701).  1.四舍五入 2.五舍六入 3.舍去零头 4.补整收取", required = true)
    private Integer srfs;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;
    @ApiModelProperty(value = "诊间结算使用 默认为0，0为不使用|1为使用")
    private String zjjssy;
    @ApiModelProperty(value = "门诊归并 | 日终相关报表的归并标志")
    private int mzgb;
    @ApiModelProperty(value = "住院归并 | 日终相关报表的归并标志")
    private int zygb;

    /**
     * 设置:付款名称
     */
    public void setFkmc(String value) {
        this.fkmc = value;
    }

    /**
     * 获取:付款名称
     */
    public String getFkmc() {
        return fkmc;
    }

    /**
     * 设置:使用类型 | 1.门诊使用   2.住院使用
     */
    public void setSylx(Integer value) {
        this.sylx = value;
    }

    /**
     * 获取:使用类型 | 1.门诊使用   2.住院使用
     */
    public Integer getSylx() {
        return sylx;
    }

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
     * 设置:号码长度
     */
    public void setHmcd(Integer value) {
        this.hmcd = value;
    }

    /**
     * 获取:号码长度
     */
    public Integer getHmcd() {
        return hmcd;
    }

    /**
     * 设置:付款精度
     */
    public void setFkjd(Integer value) {
        this.fkjd = value;
    }

    /**
     * 获取:付款精度
     */
    public Integer getFkjd() {
        return fkjd;
    }

    /**
     * 设置:货币误差标志
     */
    public void setHbwc(Integer value) {
        this.hbwc = value;
    }

    /**
     * 获取:货币误差标志
     */
    public Integer getHbwc() {
        return hbwc;
    }

    /**
     * 设置:舍入方式 | 系统配置舍入方式(2701).  1.四舍五入 2.五舍六入 3.舍去零头 4.补整收取
     */
    public void setSrfs(Integer value) {
        this.srfs = value;
    }

    /**
     * 获取:舍入方式 | 系统配置舍入方式(2701).  1.四舍五入 2.五舍六入 3.舍去零头 4.补整收取
     */
    public Integer getSrfs() {
        return srfs;
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

    /**
     * 设置:诊间结算使用 默认为0，0为不使用|1为使用
     */
    public void setZjjssy(String value) {
        this.zjjssy = value;
    }

    /**
     * 获取:诊间结算使用 默认为0，0为不使用|1为使用
     */
    public String getZjjssy() {
        return zjjssy;
    }

    public int getMzgb() {
        return mzgb;
    }

    public void setMzgb(int mzgb) {
        this.mzgb = mzgb;
    }

    public int getZygb() {
        return zygb;
    }

    public void setZygb(int zygb) {
        this.zygb = zygb;
    }
}
