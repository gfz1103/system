package com.buit.his.sys.centermaintenance.model;


import java.util.List;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：DicJbbm<br> 
 * 类描述：公用_疾病编码库
 * @author 老花生 
 * @ApiModel(value="公用_疾病编码库")
 */
public class DicJbbm  extends PageQuery {
	@ApiModelProperty(value="疾病序号")
    private Integer jbxh;
	@ApiModelProperty(value="代码类别 | 代码类别(9:ICD9,10:ICD10)")
    private Integer dmlb;
	@ApiModelProperty(value="疾病名称")
    private String jbmc;
	@ApiModelProperty(value="疾病类别")
    private Integer jblb;
	@ApiModelProperty(value="拼音码")
    private String pydm;
	@ApiModelProperty(value="ICD9 | ICD9，ICD码")
    private String icd9;
	@ApiModelProperty(value="ICD10 ")
    private String icd10;
	@ApiModelProperty(value="其它统计码 | 其它统计码，目前是病案统计码")
    private String qtxm;
	@ApiModelProperty(value="附加编码")
    private String fjbm;
	@ApiModelProperty(value="性别限制 | 性别限制(0.不限 1.限男 2.限女)")
    private Integer xbxz;
	@ApiModelProperty(value="允许治愈 | 允许治愈(0.禁止 1.允许)")
    private Integer yxzy;
	@ApiModelProperty(value="允许好转 | 允许好转(0.禁止 1.允许)")
    private Integer yxhz;
	@ApiModelProperty(value="允许未愈 | 允许未愈(0.禁止 1.允许)")
    private Integer yxwy;
	@ApiModelProperty(value="允许死亡 | 允许死亡(0.禁止 1.允许)")
    private Integer yxsw;
	@ApiModelProperty(value="允许其它 | 允许其它(0.禁止 1.允许)")
    private Integer yxqt;
	@ApiModelProperty(value="控制方式 | 控制方式(0.提醒 1.强制控制)，针对以上疾病规则")
    private Integer kzfs;
	@ApiModelProperty(value="疾病判别")
    private String jbpb;
	@ApiModelProperty(value="备注信息")
    private String bzxx;
	@ApiModelProperty(value="疾病报告卡")
    private String jbbgk;
	@ApiModelProperty(value="五笔码")
    private String wbdm;
	@ApiModelProperty(value="角形码")
    private String jxdm;
	@ApiModelProperty(value="其他码")
    private String qtdm;
	@ApiModelProperty(value="笔画码")
    private String bhdm;
	@ApiModelProperty(value="ybbmYh")
    private String ybbmYh;
	@ApiModelProperty(value="ybbm")
    private String ybbm;
	@ApiModelProperty(value="mzsy")
    private String mzsy;
	@ApiModelProperty(value="jbdl")
    private Integer jbdl;
	@ApiModelProperty(value="jblx")
    private Integer jblx;
	@ApiModelProperty(value="zfbz")
    private Integer zfbz;
	@ApiModelProperty(value="lbdm")
    private String lbdm;
	@ApiModelProperty(value="icdbf")
    private String icdbf;
	@ApiModelProperty(value="肠道门诊诊断")
    private Integer cdmzzd;
    @ApiModelProperty(value="排除 zdxh 集合")
    private List<Integer> notIn;
    @ApiModelProperty(value="icd_code")
    private String icdCode;
    @ApiModelProperty(value="手术等级")
    private Integer ssdj;

    public Integer getSsdj() {
        return ssdj;
    }

    public void setSsdj(Integer ssdj) {
        this.ssdj = ssdj;
    }

    public String getIcdCode() {
        return icdCode;
    }

    public void setIcdCode(String icdCode) {
        this.icdCode = icdCode;
    }

    /** 设置:疾病序号  */
    public void setJbxh(Integer value) {
        this.jbxh = value;
    }
    /** 获取:疾病序号 */
    public Integer getJbxh() {
        return jbxh;
    }

    /** 设置:代码类别 | 代码类别(9:ICD9,10:ICD10)  */
    public void setDmlb(Integer value) {
        this.dmlb = value;
    }
    /** 获取:代码类别 | 代码类别(9:ICD9,10:ICD10) */
    public Integer getDmlb() {
        return dmlb;
    }

    /** 设置:疾病名称  */
    public void setJbmc(String value) {
        this.jbmc = value;
    }
    /** 获取:疾病名称 */
    public String getJbmc() {
        return jbmc;
    }

    /** 设置:疾病类别  */
    public void setJblb(Integer value) {
        this.jblb = value;
    }
    /** 获取:疾病类别 */
    public Integer getJblb() {
        return jblb;
    }

    /** 设置:拼音码  */
    public void setPydm(String value) {
        this.pydm = value;
    }
    /** 获取:拼音码 */
    public String getPydm() {
        return pydm;
    }

    /** 设置:ICD9 | ICD9，ICD码  */
    public void setIcd9(String value) {
        this.icd9 = value;
    }
    /** 获取:ICD9 | ICD9，ICD码 */
    public String getIcd9() {
        return icd9;
    }

    /** 设置:ICD10   */
    public void setIcd10(String value) {
        this.icd10 = value;
    }
    /** 获取:ICD10  */
    public String getIcd10() {
        return icd10;
    }

    /** 设置:其它统计码 | 其它统计码，目前是病案统计码  */
    public void setQtxm(String value) {
        this.qtxm = value;
    }
    /** 获取:其它统计码 | 其它统计码，目前是病案统计码 */
    public String getQtxm() {
        return qtxm;
    }

    /** 设置:附加编码  */
    public void setFjbm(String value) {
        this.fjbm = value;
    }
    /** 获取:附加编码 */
    public String getFjbm() {
        return fjbm;
    }

    /** 设置:性别限制 | 性别限制(0.不限 1.限男 2.限女)  */
    public void setXbxz(Integer value) {
        this.xbxz = value;
    }
    /** 获取:性别限制 | 性别限制(0.不限 1.限男 2.限女) */
    public Integer getXbxz() {
        return xbxz;
    }

    /** 设置:允许治愈 | 允许治愈(0.禁止 1.允许)  */
    public void setYxzy(Integer value) {
        this.yxzy = value;
    }
    /** 获取:允许治愈 | 允许治愈(0.禁止 1.允许) */
    public Integer getYxzy() {
        return yxzy;
    }

    /** 设置:允许好转 | 允许好转(0.禁止 1.允许)  */
    public void setYxhz(Integer value) {
        this.yxhz = value;
    }
    /** 获取:允许好转 | 允许好转(0.禁止 1.允许) */
    public Integer getYxhz() {
        return yxhz;
    }

    /** 设置:允许未愈 | 允许未愈(0.禁止 1.允许)  */
    public void setYxwy(Integer value) {
        this.yxwy = value;
    }
    /** 获取:允许未愈 | 允许未愈(0.禁止 1.允许) */
    public Integer getYxwy() {
        return yxwy;
    }

    /** 设置:允许死亡 | 允许死亡(0.禁止 1.允许)  */
    public void setYxsw(Integer value) {
        this.yxsw = value;
    }
    /** 获取:允许死亡 | 允许死亡(0.禁止 1.允许) */
    public Integer getYxsw() {
        return yxsw;
    }

    /** 设置:允许其它 | 允许其它(0.禁止 1.允许)  */
    public void setYxqt(Integer value) {
        this.yxqt = value;
    }
    /** 获取:允许其它 | 允许其它(0.禁止 1.允许) */
    public Integer getYxqt() {
        return yxqt;
    }

    /** 设置:控制方式 | 控制方式(0.提醒 1.强制控制)，针对以上疾病规则  */
    public void setKzfs(Integer value) {
        this.kzfs = value;
    }
    /** 获取:控制方式 | 控制方式(0.提醒 1.强制控制)，针对以上疾病规则 */
    public Integer getKzfs() {
        return kzfs;
    }

    /** 设置:疾病判别  */
    public void setJbpb(String value) {
        this.jbpb = value;
    }
    /** 获取:疾病判别 */
    public String getJbpb() {
        return jbpb;
    }

    /** 设置:备注信息  */
    public void setBzxx(String value) {
        this.bzxx = value;
    }
    /** 获取:备注信息 */
    public String getBzxx() {
        return bzxx;
    }

    /** 设置:疾病报告卡  */
    public void setJbbgk(String value) {
        this.jbbgk = value;
    }
    /** 获取:疾病报告卡 */
    public String getJbbgk() {
        return jbbgk;
    }

    /** 设置:五笔码  */
    public void setWbdm(String value) {
        this.wbdm = value;
    }
    /** 获取:五笔码 */
    public String getWbdm() {
        return wbdm;
    }

    /** 设置:角形码  */
    public void setJxdm(String value) {
        this.jxdm = value;
    }
    /** 获取:角形码 */
    public String getJxdm() {
        return jxdm;
    }

    /** 设置:其他码  */
    public void setQtdm(String value) {
        this.qtdm = value;
    }
    /** 获取:其他码 */
    public String getQtdm() {
        return qtdm;
    }

    /** 设置:笔画码  */
    public void setBhdm(String value) {
        this.bhdm = value;
    }
    /** 获取:笔画码 */
    public String getBhdm() {
        return bhdm;
    }

    /** 设置:ybbmYh  */
    public void setYbbmYh(String value) {
        this.ybbmYh = value;
    }
    /** 获取:ybbmYh */
    public String getYbbmYh() {
        return ybbmYh;
    }

    /** 设置:ybbm  */
    public void setYbbm(String value) {
        this.ybbm = value;
    }
    /** 获取:ybbm */
    public String getYbbm() {
        return ybbm;
    }

    /** 设置:mzsy  */
    public void setMzsy(String value) {
        this.mzsy = value;
    }
    /** 获取:mzsy */
    public String getMzsy() {
        return mzsy;
    }

    /** 设置:jbdl  */
    public void setJbdl(Integer value) {
        this.jbdl = value;
    }
    /** 获取:jbdl */
    public Integer getJbdl() {
        return jbdl;
    }

    /** 设置:jblx  */
    public void setJblx(Integer value) {
        this.jblx = value;
    }
    /** 获取:jblx */
    public Integer getJblx() {
        return jblx;
    }

    /** 设置:zfbz  */
    public void setZfbz(Integer value) {
        this.zfbz = value;
    }
    /** 获取:zfbz */
    public Integer getZfbz() {
        return zfbz;
    }

    /** 设置:lbdm  */
    public void setLbdm(String value) {
        this.lbdm = value;
    }
    /** 获取:lbdm */
    public String getLbdm() {
        return lbdm;
    }

    /** 设置:icdbf  */
    public void setIcdbf(String value) {
        this.icdbf = value;
    }
    /** 获取:icdbf */
    public String getIcdbf() {
        return icdbf;
    }

    /** 设置:肠道门诊诊断  */
    public void setCdmzzd(Integer value) {
        this.cdmzzd = value;
    }
    /** 获取:肠道门诊诊断 */
    public Integer getCdmzzd() {
        return cdmzzd;
    }

    public List<Integer> getNotIn() {
        return notIn;
    }

    public void setNotIn(List<Integer> notIn) {
        this.notIn = notIn;
    }
}
