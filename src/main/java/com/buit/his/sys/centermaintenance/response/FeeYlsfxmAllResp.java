
package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeYlsfxm<br>
 * 类描述：公用_医疗收费<br>
 * @author 老花生
 */
@ApiModel(value="公用_医疗收费")
public class FeeYlsfxmAllResp  extends PageQuery {
	private static final long serialVersionUID = -6575027754012131009L;
	@ApiModelProperty(value="费用序号")
    /** 费用序号 */
    private Integer fyxh;
	@ApiModelProperty(value="费用名称")
    /** 费用名称 */
    private String fymc;
	@ApiModelProperty(value="费用单位")
    /** 费用单位 */
    private String fydw;
	@ApiModelProperty(value="拼音代码")
    /** 拼音代码 */
    private String pydm;
	@ApiModelProperty(value="门诊使用")
    /** 门诊使用 */
    private Integer mzsy;
	@ApiModelProperty(value="住院使用")
    /** 住院使用 */
    private Integer zysy;
	@ApiModelProperty(value="医技使用")
    /** 医技使用 */
    private Integer yjsy;
	@ApiModelProperty(value="特殊检查")
    /** 特殊检查 */
    private Integer tjfy;
	@ApiModelProperty(value="特殊治疗")
    /** 特殊治疗 */
    private Integer txzl;
	@ApiModelProperty(value="五笔代码")
    /** 五笔代码 */
    private String wbdm;
	@ApiModelProperty(value="角形代码")
    /** 角形代码 */
    private String jxdm;
	@ApiModelProperty(value="其他代码")
    /** 其他代码 */
    private String qtdm;
	@ApiModelProperty(value="作废判别")
    /** 作废判别 */
    private Integer zfpb;
	@ApiModelProperty(value="项目编码")
    /** 项目编码 */
    private String xmbm;
	@ApiModelProperty(value="标准价格")
    /** 标准价格 */
    private BigDecimal bzjg;
	@ApiModelProperty(value="项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他")
    /** 项目类别 | 4.检验 5.检查 6.手术 7.治疗 8.护理 9.饮食 10.卫材 99.其他 */
    private Integer xmlx;
	@ApiModelProperty(value="医技接口")
    /** 医技接口 */
    private Integer yjjk;
	@ApiModelProperty(value="住院检查申请单")
    /** 住院检查申请单 */
    private Integer jcsq;
	@ApiModelProperty(value="门诊申请单")
    /** 门诊申请单 */
    private Integer mzsq;
	@ApiModelProperty(value="特殊提示")
    /** 特殊提示 */
    private String tsts;
	@ApiModelProperty(value="LIS类型")
    /** LIS类型 */
    private Integer lislx;
	@ApiModelProperty(value="项目分类 | 维护为GY_XMFLZD（项目分类字典）中的项目分类")
    /** 项目分类 | 维护为GY_XMFLZD（项目分类字典）中的项目分类 */
    private Integer xmfl;
	@ApiModelProperty(value="费用单价")
	private BigDecimal fydj;
	
	public Integer getFyxh() {
		return fyxh;
	}
	public void setFyxh(Integer fyxh) {
		this.fyxh = fyxh;
	}
	public String getFymc() {
		return fymc;
	}
	public void setFymc(String fymc) {
		this.fymc = fymc;
	}
	public String getFydw() {
		return fydw;
	}
	public void setFydw(String fydw) {
		this.fydw = fydw;
	}
	public String getPydm() {
		return pydm;
	}
	public void setPydm(String pydm) {
		this.pydm = pydm;
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
	public Integer getYjsy() {
		return yjsy;
	}
	public void setYjsy(Integer yjsy) {
		this.yjsy = yjsy;
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
	public String getJxdm() {
		return jxdm;
	}
	public void setJxdm(String jxdm) {
		this.jxdm = jxdm;
	}
	public String getQtdm() {
		return qtdm;
	}
	public void setQtdm(String qtdm) {
		this.qtdm = qtdm;
	}
	public Integer getZfpb() {
		return zfpb;
	}
	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}
	public String getXmbm() {
		return xmbm;
	}
	public void setXmbm(String xmbm) {
		this.xmbm = xmbm;
	}
	public BigDecimal getBzjg() {
		return bzjg;
	}
	public void setBzjg(BigDecimal bzjg) {
		this.bzjg = bzjg;
	}
	public Integer getXmlx() {
		return xmlx;
	}
	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}
	public Integer getYjjk() {
		return yjjk;
	}
	public void setYjjk(Integer yjjk) {
		this.yjjk = yjjk;
	}
	public Integer getJcsq() {
		return jcsq;
	}
	public void setJcsq(Integer jcsq) {
		this.jcsq = jcsq;
	}
	public Integer getMzsq() {
		return mzsq;
	}
	public void setMzsq(Integer mzsq) {
		this.mzsq = mzsq;
	}
	public String getTsts() {
		return tsts;
	}
	public void setTsts(String tsts) {
		this.tsts = tsts;
	}
	public Integer getLislx() {
		return lislx;
	}
	public void setLislx(Integer lislx) {
		this.lislx = lislx;
	}
	public Integer getXmfl() {
		return xmfl;
	}
	public void setXmfl(Integer xmfl) {
		this.xmfl = xmfl;
	}
	public BigDecimal getFydj() {
		return fydj;
	}
	public void setFydj(BigDecimal fydj) {
		this.fydj = fydj;
	}
	
}
