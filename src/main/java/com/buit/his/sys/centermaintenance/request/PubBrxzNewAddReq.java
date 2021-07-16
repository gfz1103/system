package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：PubBrxz<br>
 * 类描述：病人性质维护-新增
 *
 * @author liushijie
 */
@ApiModel(value = "病人性质维护-新增")
public class PubBrxzNewAddReq {
    @ApiModelProperty(value = "性质名称", required = true)
    private String xzmc;
    @ApiModelProperty(value = "上级性质", required = true)
    private Integer sjxz;
    @ApiModelProperty(value = "证号判别 | 0.不需要 1.需要", required = true)
    private String zhpb;
    @ApiModelProperty(value = "险种|保险判别", required = true)
    private Integer dbpb;
    @ApiModelProperty(value = "门诊使用", required = true)
    private Integer mzsy;
    @ApiModelProperty(value = "住院使用", required = true)
    private Integer zysy;
    @ApiModelProperty(value = "床费限价", required = true)
    private BigDecimal cfxj;
    @ApiModelProperty(value = "处方限额", required = true)
    private BigDecimal cfxe;
    @ApiModelProperty(value = "排列顺序", required = true)
    private String plsx;
    @ApiModelProperty(value = "性质控制大类", required = true)
    private String xzdl;
    @ApiModelProperty(value = "VIP床位费", required = true)
    private String vipcwfy;
    @ApiModelProperty(value = "退费分步交易", required = true)
    private Integer tffbjy;

    /**
     * 设置:性质名称
     */
    public void setXzmc(String value) {
        this.xzmc = value;
    }

    /**
     * 获取:性质名称
     */
    public String getXzmc() {
        return xzmc;
    }

    /**
     * 设置:上级性质 | 指明该类证号是否存在上级性质,及其上级代码
     */
    public void setSjxz(Integer value) {
        this.sjxz = value;
    }

    /**
     * 获取:上级性质 | 指明该类证号是否存在上级性质,及其上级代码
     */
    public Integer getSjxz() {
        return sjxz;
    }

    /**
     * 设置:证号判别 | 0.不需要 1.需要
     */
    public void setZhpb(String value) {
        this.zhpb = value;
    }

    /**
     * 获取:证号判别 | 0.不需要 1.需要
     */
    public String getZhpb() {
        return zhpb;
    }

    /**
     * 设置:保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险
     */
    public void setDbpb(Integer value) {
        this.dbpb = value;
    }

    /**
     * 获取:保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险
     */
    public Integer getDbpb() {
        return dbpb;
    }

    /**
     * 设置:门诊使用
     */
    public void setMzsy(Integer value) {
        this.mzsy = value;
    }

    /**
     * 获取:门诊使用
     */
    public Integer getMzsy() {
        return mzsy;
    }

    /**
     * 设置:住院使用
     */
    public void setZysy(Integer value) {
        this.zysy = value;
    }

    /**
     * 获取:住院使用
     */
    public Integer getZysy() {
        return zysy;
    }

    /**
     * 设置:床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费
     */
    public void setCfxj(BigDecimal value) {
        this.cfxj = value;
    }

    /**
     * 获取:床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费
     */
    public BigDecimal getCfxj() {
        return cfxj;
    }

    /**
     * 设置:处方限额
     */
    public void setCfxe(BigDecimal value) {
        this.cfxe = value;
    }

    /**
     * 获取:处方限额
     */
    public BigDecimal getCfxe() {
        return cfxe;
    }

    /**
     * 设置:排列顺序
     */
    public void setPlsx(String value) {
        this.plsx = value;
    }

    /**
     * 获取:排列顺序
     */
    public String getPlsx() {
        return plsx;
    }

    /**
     * 设置:性质控制大类
     */
    public void setXzdl(String value) {
        this.xzdl = value;
    }

    /**
     * 获取:性质控制大类
     */
    public String getXzdl() {
        return xzdl;
    }

    /**
     * 设置:vipcwfy
     */
    public void setVipcwfy(String value) {
        this.vipcwfy = value;
    }

    /**
     * 获取:vipcwfy
     */
    public String getVipcwfy() {
        return vipcwfy;
    }

    public Integer getTffbjy() {
        return tffbjy;
    }

    public void setTffbjy(Integer tffbjy) {
        this.tffbjy = tffbjy;
    }
}
