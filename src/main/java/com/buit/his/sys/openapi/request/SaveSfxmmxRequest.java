package com.buit.his.sys.openapi.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author sunjx
 * @Date 2020-12-14 16:14
 * @Description
 **/
@ApiModel("保存收费项目明细")
public class SaveSfxmmxRequest {

    @ApiModelProperty(value = "病案首页归并")
    private Integer basygb;
    @ApiModelProperty(value = "报表归并")
    private Integer bbgb;
    @ApiModelProperty(value = "笔画代码")
    private String bhdm;
    @ApiModelProperty(value = "标准价格")
    private BigDecimal bzjg;
    @ApiModelProperty(value = "材料标志")
    private Integer clbz;
    @ApiModelProperty(value = "材料对应(字典:sys_dict_config:36)")
    private String cldym;
    @ApiModelProperty(value = "费用单位")
    private String fydw;
    @ApiModelProperty(value = "费用归并")
    private Integer fygb;
    @ApiModelProperty(value = "费用名称(手术名称)")
    private String fymc;
    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;
    @ApiModelProperty(value = "黄码编码")
    private String hmbm;
    @ApiModelProperty(value = "角形代码")
    private String jxdm;
    @ApiModelProperty(value = "明细标志")
    private Integer mxbz;
    @ApiModelProperty(value = "门诊使用")
    private Integer mzsy;
    @ApiModelProperty(value = "拼音代码")
    private String pydm;
    @ApiModelProperty(value = "其他代码")
    private String qtdm;
    @ApiModelProperty("手术编码")
    private Integer ssbm;
    @ApiModelProperty(value = "特殊检查")
    private Integer tjfy;
    @ApiModelProperty(value = "特殊治疗")
    private Integer txzl;
    @ApiModelProperty(value = "五笔代码")
    private String wbdm;
    @ApiModelProperty(value = "项目编码")
    private String xmbm;
    @ApiModelProperty(value = "项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
    private Integer xmlx;
    @ApiModelProperty(value = "医保编码")
    private String ybbm;
    @ApiModelProperty(value = "医保单位")
    private String ybdw;
    @ApiModelProperty(value = "医保名称")
    private String ybmc;
    @ApiModelProperty(value = "医技使用")
    private Integer yjsy;
    @ApiModelProperty(value = "材料规格")
    private String yyclgg;
    @ApiModelProperty(value = "医用品牌")
    private String yypp;
    @ApiModelProperty(value = "注册证号")
    private String zczh;
    @ApiModelProperty(value = "作废判别")
    private Integer zfpb;
    @ApiModelProperty(value = "总限额")
    private BigDecimal zjxe;
    @ApiModelProperty(value = "执行科室")
    private Integer zxks;
    @ApiModelProperty(value = "住院使用")
    private Integer zysy;

    public Integer getBasygb() {
        return basygb;
    }

    public void setBasygb(Integer basygb) {
        this.basygb = basygb;
    }

    public Integer getBbgb() {
        return bbgb;
    }

    public void setBbgb(Integer bbgb) {
        this.bbgb = bbgb;
    }

    public String getBhdm() {
        return bhdm;
    }

    public void setBhdm(String bhdm) {
        this.bhdm = bhdm;
    }

    public BigDecimal getBzjg() {
        return bzjg;
    }

    public void setBzjg(BigDecimal bzjg) {
        this.bzjg = bzjg;
    }

    public Integer getClbz() {
        return clbz;
    }

    public void setClbz(Integer clbz) {
        this.clbz = clbz;
    }

    public String getCldym() {
        return cldym;
    }

    public void setCldym(String cldym) {
        this.cldym = cldym;
    }

    public String getFydw() {
        return fydw;
    }

    public void setFydw(String fydw) {
        this.fydw = fydw;
    }

    public Integer getFygb() {
        return fygb;
    }

    public void setFygb(Integer fygb) {
        this.fygb = fygb;
    }

    public String getFymc() {
        return fymc;
    }

    public void setFymc(String fymc) {
        this.fymc = fymc;
    }

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }

    public String getHmbm() {
        return hmbm;
    }

    public void setHmbm(String hmbm) {
        this.hmbm = hmbm;
    }

    public String getJxdm() {
        return jxdm;
    }

    public void setJxdm(String jxdm) {
        this.jxdm = jxdm;
    }

    public Integer getMxbz() {
        return mxbz;
    }

    public void setMxbz(Integer mxbz) {
        this.mxbz = mxbz;
    }

    public Integer getMzsy() {
        return mzsy;
    }

    public void setMzsy(Integer mzsy) {
        this.mzsy = mzsy;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }

    public String getQtdm() {
        return qtdm;
    }

    public void setQtdm(String qtdm) {
        this.qtdm = qtdm;
    }

    public Integer getSsbm() {
        return ssbm;
    }

    public void setSsbm(Integer ssbm) {
        this.ssbm = ssbm;
    }

    public Integer getTjfy() {
        return tjfy;
    }

    public void setTjfy(Integer tjfy) {
        this.tjfy = tjfy;
    }

    public Integer getTxzl() {
        return txzl;
    }

    public void setTxzl(Integer txzl) {
        this.txzl = txzl;
    }

    public String getWbdm() {
        return wbdm;
    }

    public void setWbdm(String wbdm) {
        this.wbdm = wbdm;
    }

    public String getXmbm() {
        return xmbm;
    }

    public void setXmbm(String xmbm) {
        this.xmbm = xmbm;
    }

    public Integer getXmlx() {
        return xmlx;
    }

    public void setXmlx(Integer xmlx) {
        this.xmlx = xmlx;
    }

    public String getYbbm() {
        return ybbm;
    }

    public void setYbbm(String ybbm) {
        this.ybbm = ybbm;
    }

    public String getYbdw() {
        return ybdw;
    }

    public void setYbdw(String ybdw) {
        this.ybdw = ybdw;
    }

    public String getYbmc() {
        return ybmc;
    }

    public void setYbmc(String ybmc) {
        this.ybmc = ybmc;
    }

    public Integer getYjsy() {
        return yjsy;
    }

    public void setYjsy(Integer yjsy) {
        this.yjsy = yjsy;
    }

    public String getYyclgg() {
        return yyclgg;
    }

    public void setYyclgg(String yyclgg) {
        this.yyclgg = yyclgg;
    }

    public String getYypp() {
        return yypp;
    }

    public void setYypp(String yypp) {
        this.yypp = yypp;
    }

    public String getZczh() {
        return zczh;
    }

    public void setZczh(String zczh) {
        this.zczh = zczh;
    }

    public Integer getZfpb() {
        return zfpb;
    }

    public void setZfpb(Integer zfpb) {
        this.zfpb = zfpb;
    }

    public BigDecimal getZjxe() {
        return zjxe;
    }

    public void setZjxe(BigDecimal zjxe) {
        this.zjxe = zjxe;
    }

    public Integer getZxks() {
        return zxks;
    }

    public void setZxks(Integer zxks) {
        this.zxks = zxks;
    }

    public Integer getZysy() {
        return zysy;
    }

    public void setZysy(Integer zysy) {
        this.zysy = zysy;
    }
}
