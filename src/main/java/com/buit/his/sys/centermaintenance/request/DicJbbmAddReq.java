
package com.buit.his.sys.centermaintenance.request;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类描述：公用_疾病编码库_新增<br>
 *
 * @author 老花生
 */
@ApiModel(value = "公用_疾病编码库_新增")
public class DicJbbmAddReq {
    @NotNull(message = "代码类别不能为空")
    @ApiModelProperty(value = "代码类别 | 代码类别(9:ICD9,10:ICD10)", required = true)
    private Integer dmlb;
    @NotNull(message = "疾病名称不能为空")
    @ApiModelProperty(value = "疾病名称", required = true)
    private String jbmc;
    @ApiModelProperty(value = "疾病类别")
    private Integer jblb;
    @ApiModelProperty(value = "拼音码")
    private String pydm;
    @ApiModelProperty(value = "ICD9 | ICD9，ICD码")
    private String icd9;
    @ApiModelProperty(value = "ICD10 ")
    private String icd10;
    @ApiModelProperty(value = "疾病判别")
    private String jbpb;
    @ApiModelProperty(value = "备注信息")
    private String bzxx;
    @ApiModelProperty(value = "疾病报告卡")
    private String jbbgk;
    @ApiModelProperty(value = "五笔码")
    private String wbdm;
    @ApiModelProperty(value = "肠道门诊诊断")
    private Integer cdmzzd;
    @ApiModelProperty(value = "icdCode")
    private String icdCode;
    @ApiModelProperty(value = "作废标志,0:未作废 1:作废")
    private Integer zfbz;


    /**
     * 设置:代码类别 | 代码类别(9:ICD9,10:ICD10)
     */
    public void setDmlb(Integer value) {
        this.dmlb = value;
    }

    /**
     * 获取:代码类别 | 代码类别(9:ICD9,10:ICD10)
     */
    public Integer getDmlb() {
        return dmlb;
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
     * 设置:疾病类别
     */
    public void setJblb(Integer value) {
        this.jblb = value;
    }

    /**
     * 获取:疾病类别
     */
    public Integer getJblb() {
        return jblb;
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
     * 设置:ICD9 | ICD9，ICD码
     */
    public void setIcd9(String value) {
        this.icd9 = value;
    }

    /**
     * 获取:ICD9 | ICD9，ICD码
     */
    public String getIcd9() {
        return icd9;
    }

    /**
     * 设置:ICD10
     */
    public void setIcd10(String value) {
        this.icd10 = value;
    }

    /**
     * 获取:ICD10
     */
    public String getIcd10() {
        return icd10;
    }

    /**
     * 设置:疾病判别
     */
    public void setJbpb(String value) {
        this.jbpb = value;
    }

    /**
     * 获取:疾病判别
     */
    public String getJbpb() {
        return jbpb;
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
     * 设置:疾病报告卡
     */
    public void setJbbgk(String value) {
        this.jbbgk = value;
    }

    /**
     * 获取:疾病报告卡
     */
    public String getJbbgk() {
        return jbbgk;
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
     * 设置:肠道门诊诊断
     */
    public void setCdmzzd(Integer value) {
        this.cdmzzd = value;
    }

    /**
     * 获取:肠道门诊诊断
     */
    public Integer getCdmzzd() {
        return cdmzzd;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    public Integer getZfbz() {
        return zfbz;
    }

    public void setZfbz(Integer zfbz) {
        this.zfbz = zfbz;
    }
}
