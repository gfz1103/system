package com.buit.his.sys.centermaintenance.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：PubBrxz
 * 类描述：病人性质维护-编辑
 *
 * @author liushijie
 */
@ApiModel(value = "病人性质维护-编辑")
public class PubBrxzEditReq {
    @NotNull(message = "性质代码不能为空")
    @ApiModelProperty(value = "性质代码")
    private Integer brxz;
    @ApiModelProperty(value = "性质名称")
    private String xzmc;
    @ApiModelProperty(value = "上级性质 | 指明该类证号是否存在上级性质,及其上级代码")
    private Integer sjxz;
    @ApiModelProperty(value = "证号判别 | 0.不需要 1.需要")
    private String zhpb;
    @ApiModelProperty(value = "保险判别 | 0.非保险 1.大病保险 2.医疗保险 9.其他保险")
    private Integer dbpb;
    @ApiModelProperty(value = "门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value = "住院使用")
    private Integer zysy;
    @ApiModelProperty(value = "实收比例")
    private BigDecimal ssbl;
    @ApiModelProperty(value = "床费限价 | 某些病人床位限制在某金额才为公费，自动累加床位费时将超过的金额写入自负床位费")
    private BigDecimal cfxj;
    @ApiModelProperty(value = "处方限额")
    private BigDecimal cfxe;
    @ApiModelProperty(value = "排列顺序")
    private String plsx;
    @ApiModelProperty(value = "性质控制大类")
    private String xzdl;
    @ApiModelProperty(value = "退费分步交易")
    private Integer tffbjy;
    @ApiModelProperty(value = "妇幼儿童标志")
    private Integer fyetbz;
    @ApiModelProperty(value = "vipcwfy")
    private String vipcwfy;


    public Integer getBrxz() {
        return brxz;
    }

    public void setBrxz(Integer brxz) {
        this.brxz = brxz;
    }

    public String getXzmc() {
        return xzmc;
    }

    public void setXzmc(String xzmc) {
        this.xzmc = xzmc;
    }

    public Integer getSjxz() {
        return sjxz;
    }

    public void setSjxz(Integer sjxz) {
        this.sjxz = sjxz;
    }

    public String getZhpb() {
        return zhpb;
    }

    public void setZhpb(String zhpb) {
        this.zhpb = zhpb;
    }

    public Integer getDbpb() {
        return dbpb;
    }

    public void setDbpb(Integer dbpb) {
        this.dbpb = dbpb;
    }

    public Integer getMzsy() {
        return mzsy;
    }

    public void setMzsy(Integer mzsy) {
        this.mzsy = mzsy;
    }

    public Integer getZysy() {
        return zysy;
    }

    public void setZysy(Integer zysy) {
        this.zysy = zysy;
    }

    public BigDecimal getCfxj() {
        return cfxj;
    }

    public void setCfxj(BigDecimal cfxj) {
        this.cfxj = cfxj;
    }

    public BigDecimal getCfxe() {
        return cfxe;
    }

    public void setCfxe(BigDecimal cfxe) {
        this.cfxe = cfxe;
    }

    public String getPlsx() {
        return plsx;
    }

    public void setPlsx(String plsx) {
        this.plsx = plsx;
    }

    public String getXzdl() {
        return xzdl;
    }

    public void setXzdl(String xzdl) {
        this.xzdl = xzdl;
    }

    public String getVipcwfy() {
        return vipcwfy;
    }

    public void setVipcwfy(String vipcwfy) {
        this.vipcwfy = vipcwfy;
    }

    public BigDecimal getSsbl() {
        return ssbl;
    }

    public void setSsbl(BigDecimal ssbl) {
        this.ssbl = ssbl;
    }

    public Integer getTffbjy() {
        return tffbjy;
    }

    public void setTffbjy(Integer tffbjy) {
        this.tffbjy = tffbjy;
    }

    public Integer getFyetbz() {
        return fyetbz;
    }

    public void setFyetbz(Integer fyetbz) {
        this.fyetbz = fyetbz;
    }
}
