
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类描述：科室字典<br>
 *
 * @author liushijie
 */
@ApiModel(value = "科室字典-新增")
public class DicKszdAddReq {
    @NotNull(message = "科室代码不能为空")
    @ApiModelProperty(value = "科室代码", required = true)
    private String officecode;
    @NotNull(message = "科室名称不能为空")
    @ApiModelProperty(value = "科室名称", required = true)
    private String officename;
    @ApiModelProperty(value = "地址")
    private String address;
    @NotNull(message = "所属机构不能为空")
    @ApiModelProperty(value = "所属机构", required = true)
    private String organizcode;
    @NotNull(message = "上级科室不能为空")
    @ApiModelProperty(value = "上级科室", required = true)
    private String parentid;
    @ApiModelProperty(value = "科室类型")
    private String organiztype;
    @ApiModelProperty(value = "联系电话")
    private String telphone;
    @ApiModelProperty(value = "电子邮箱")
    private String email;
    @ApiModelProperty(value = "排列顺序")
    private String plsx;
    @ApiModelProperty(value = "拼音码")
    private String pyCode;
    @ApiModelProperty(value = "核算科室")
    private String accountoffice;
    @NotNull(message = "门诊科室不能为空")
    @ApiModelProperty(value = "门诊科室 1:是 0:否", required = true)
    private String outpatientclinic;
    @NotNull(message = "医技科室不能为空")
    @ApiModelProperty(value = "医技科室 1:是 0:否", required = true)
    private String medicallab;
    @NotNull(message = "住院科室不能为空")
    @ApiModelProperty(value = "住院科室 1:是 0:否", required = true)
    private String hospitaldept;
    @NotNull(message = "住院病区不能为空")
    @ApiModelProperty(value = "住院病区 1:是 0:否", required = true)
    private String hospitalarea;
    @NotNull(message = "急诊科室不能为空")
    @ApiModelProperty(value = "是否急诊科室，1：是 0：否", required = true)
    private String emergency;
    @NotNull(message = "手术科室不能为空")
    @ApiModelProperty(value = "是否手术科室，1：是 0：否", required = true)
    private String surgical;
    @NotNull(message = "输液科室不能为空")
    @ApiModelProperty(value = "是否输液科室，1：是 0：否", required = true)
    private String fluid;
    @NotNull(message = "是否中医科室不能为空")
    @ApiModelProperty(value = "是否中医科室，1：是 0：否", required = true)
    private String tcm;
    @NotNull(message = "是否互联网科室不能为空")
    @ApiModelProperty(value = "是否互联网科室，1：是 0：否", required = true)
    private String internet;
    @ApiModelProperty(value = "额定床位")
    private Integer ratedbed;
    @ApiModelProperty(value = "状态 0:未注销 1:已注销")
    private String logoff;
    @ApiModelProperty(value = "线下医保科室")
    private String ybks;
    @ApiModelProperty(value = "线上医保科室")
    private String xsybks;
    @ApiModelProperty(value = "ksdz")
    private Integer ksdz;
    @ApiModelProperty(value = "医保机构代码")
    private String yljgid;
    @ApiModelProperty(value = "sfscpt")
    private Integer sfscpt;
    @ApiModelProperty(value = "核算分类")
    private String hsfl;
    @ApiModelProperty(value = "报表归并 ")
    private Integer bbgb;
    @ApiModelProperty(value = "科室大类：1,大内科 2,大外科,3,妇科 0或空,未分类")
    private String ksfl;
    @ApiModelProperty(value = "1:输液科室")
    private String syks;
    @ApiModelProperty(value = "是否留观病区 1:是 0:否")
    private String lgbq;
    @ApiModelProperty(value = "是否留观科室 1:是 0:否")
    private String lgks;
    @ApiModelProperty(value = "0:非治疗科室;1:治疗科室")
    private String zlks;
    @ApiModelProperty("0:非注射科室;1:注射科室")
    private String zsks;

    /**
     * 设置:科室代码
     */
    public void setOfficecode(String value) {
        this.officecode = value;
    }

    /**
     * 获取:科室代码
     */
    public String getOfficecode() {
        return officecode;
    }

    /**
     * 设置:科室名称
     */
    public void setOfficename(String value) {
        this.officename = value;
    }

    /**
     * 获取:科室名称
     */
    public String getOfficename() {
        return officename;
    }

    /**
     * 设置:地址
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * 获取:地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置:所属机构
     */
    public void setOrganizcode(String value) {
        this.organizcode = value;
    }

    /**
     * 获取:所属机构
     */
    public String getOrganizcode() {
        return organizcode;
    }

    /**
     * 设置:上级科室
     */
    public void setParentid(String value) {
        this.parentid = value;
    }

    /**
     * 获取:上级科室
     */
    public String getParentid() {
        return parentid;
    }

    /**
     * 设置:科室类型
     */
    public void setOrganiztype(String value) {
        this.organiztype = value;
    }

    /**
     * 获取:科室类型
     */
    public String getOrganiztype() {
        return organiztype;
    }

    /**
     * 设置:联系电话
     */
    public void setTelphone(String value) {
        this.telphone = value;
    }

    /**
     * 获取:联系电话
     */
    public String getTelphone() {
        return telphone;
    }

    /**
     * 设置:电子邮箱
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * 获取:电子邮箱
     */
    public String getEmail() {
        return email;
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

    public String getPyCode() {
        return pyCode;
    }

    public void setPyCode(String pyCode) {
        this.pyCode = pyCode;
    }

    /**
     * 设置:核算科室
     */
    public void setAccountoffice(String value) {
        this.accountoffice = value;
    }

    /**
     * 获取:核算科室
     */
    public String getAccountoffice() {
        return accountoffice;
    }

    /**
     * 设置:门诊科室
     */
    public void setOutpatientclinic(String value) {
        this.outpatientclinic = value;
    }

    /**
     * 获取:门诊科室
     */
    public String getOutpatientclinic() {
        return outpatientclinic;
    }

    /**
     * 设置:医技科室
     */
    public void setMedicallab(String value) {
        this.medicallab = value;
    }

    /**
     * 获取:医技科室
     */
    public String getMedicallab() {
        return medicallab;
    }

    /**
     * 设置:住院科室
     */
    public void setHospitaldept(String value) {
        this.hospitaldept = value;
    }

    /**
     * 获取:住院科室
     */
    public String getHospitaldept() {
        return hospitaldept;
    }

    /**
     * 设置:住院病区
     */
    public void setHospitalarea(String value) {
        this.hospitalarea = value;
    }

    /**
     * 获取:住院病区
     */
    public String getHospitalarea() {
        return hospitalarea;
    }

    /**
     * 设置:额定床位
     */
    public void setRatedbed(Integer value) {
        this.ratedbed = value;
    }

    /**
     * 获取:额定床位
     */
    public Integer getRatedbed() {
        return ratedbed;
    }

    /**
     * 设置:logoff
     */
    public void setLogoff(String value) {
        this.logoff = value;
    }

    /**
     * 获取:logoff
     */
    public String getLogoff() {
        return logoff;
    }

    /**
     * 设置:医保科室
     */
    public void setYbks(String value) {
        this.ybks = value;
    }

    /**
     * 获取:医保科室
     */
    public String getYbks() {
        return ybks;
    }

    /**
     * 设置:ksdz
     */
    public void setKsdz(Integer value) {
        this.ksdz = value;
    }

    /**
     * 获取:ksdz
     */
    public Integer getKsdz() {
        return ksdz;
    }

    /**
     * 设置:医保机构代码
     */
    public void setYljgid(String value) {
        this.yljgid = value;
    }

    /**
     * 获取:医保机构代码
     */
    public String getYljgid() {
        return yljgid;
    }

    /**
     * 设置:sfscpt
     */
    public void setSfscpt(Integer value) {
        this.sfscpt = value;
    }

    /**
     * 获取:sfscpt
     */
    public Integer getSfscpt() {
        return sfscpt;
    }

    /**
     * 设置:核算分类
     */
    public void setHsfl(String value) {
        this.hsfl = value;
    }

    /**
     * 获取:核算分类
     */
    public String getHsfl() {
        return hsfl;
    }

    /**
     * 设置:报表归并
     */
    public void setBbgb(Integer value) {
        this.bbgb = value;
    }

    /**
     * 获取:报表归并
     */
    public Integer getBbgb() {
        return bbgb;
    }

    /**
     * 设置:科室大类：1,大内科 2,大外科,3,妇科 0或空,未分类
     */
    public void setKsfl(String value) {
        this.ksfl = value;
    }

    /**
     * 获取:科室大类：1,大内科 2,大外科,3,妇科 0或空,未分类
     */
    public String getKsfl() {
        return ksfl;
    }

    /**
     * 设置:1:输液科室
     */
    public void setSyks(String value) {
        this.syks = value;
    }

    /**
     * 获取:1:输液科室
     */
    public String getSyks() {
        return syks;
    }

    public String getEmergency() {
        return emergency;
    }

    public void setEmergency(String emergency) {
        this.emergency = emergency;
    }

    public String getSurgical() {
        return surgical;
    }

    public void setSurgical(String surgical) {
        this.surgical = surgical;
    }

    public String getFluid() {
        return fluid;
    }

    public void setFluid(String fluid) {
        this.fluid = fluid;
    }

    public String getXsybks() {
        return xsybks;
    }

    public void setXsybks(String xsybks) {
        this.xsybks = xsybks;
    }

    public String getTcm() {
        return tcm;
    }

    public void setTcm(String tcm) {
        this.tcm = tcm;
    }

    public String getInternet() {
        return internet;
    }

    public void setInternet(String internet) {
        this.internet = internet;
    }

    public String getLgbq() {
        return lgbq;
    }

    public void setLgbq(String lgbq) {
        this.lgbq = lgbq;
    }

    public String getLgks() {
        return lgks;
    }

    public void setLgks(String lgks) {
        this.lgks = lgks;
    }

    public String getZlks() {
        return zlks;
    }

    public void setZlks(String zlks) {
        this.zlks = zlks;
    }

    public String getZsks() {
        return zsks;
    }

    public void setZsks(String zsks) {
        this.zsks = zsks;
    }
}
