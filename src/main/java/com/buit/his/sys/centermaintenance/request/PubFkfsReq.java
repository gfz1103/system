
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubFkfs<br>
 * 类描述：公用_付款方式 |  用于门诊及住院付款方式设定<br>
 *
 * @author WY
 */
@ApiModel(value = "公用_付款方式 ")
public class PubFkfsReq {
    @ApiModelProperty(value = "付款方式")
    private Integer fkfs;
    @ApiModelProperty(value = "付款名称")
    private String fkmc;
    @ApiModelProperty(value = "使用类型 1.门诊使用2.住院使用")
    private Integer sylx;
    @ApiModelProperty(value = "付款类别")
    private Integer fklb;
    @ApiModelProperty(value = "号码长度")
    private Integer hmcd;
    @ApiModelProperty(value = "付款精度")
    private Integer fkjd;
    @ApiModelProperty(value = "货币误差标志")
    private Integer hbwc;
    @ApiModelProperty(value = "默认标志")
    private Integer mrbz;
    @ApiModelProperty(value = "作废标志")
    private Integer zfbz;
    @ApiModelProperty(value = "快捷方式")
    private String kjfs;
    @ApiModelProperty(value = "舍入方式 | 系统配置舍入方式(2701).  1.四舍五入 2.五舍六入 3.舍去零头 4.补整收取")
    private Integer srfs;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;
    @ApiModelProperty(value = "诊间结算使用 默认为0，0为不使用|1为使用")
    private String zjjssy;

    /**
     * 设置:付款方式
     */
    public void setFkfs(Integer value) {
        this.fkfs = value;
    }

    /**
     * 获取:付款方式
     */
    public Integer getFkfs() {
        return fkfs;
    }

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
     * 设置:默认标志
     */
    public void setMrbz(Integer value) {
        this.mrbz = value;
    }

    /**
     * 获取:默认标志
     */
    public Integer getMrbz() {
        return mrbz;
    }

    /**
     * 设置:作废标志
     */
    public void setZfbz(Integer value) {
        this.zfbz = value;
    }

    /**
     * 获取:作废标志
     */
    public Integer getZfbz() {
        return zfbz;
    }

    /**
     * 设置:快捷方式
     */
    public void setKjfs(String value) {
        this.kjfs = value;
    }

    /**
     * 获取:快捷方式
     */
    public String getKjfs() {
        return kjfs;
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
}
