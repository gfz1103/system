   
package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DiccLdxmgl<br> 
 * 类描述：项目关联<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="项目关联_Resp")
public class DiccLdxmglResp {
    @ApiModelProperty(value="项目序号")
    private Integer xmxh;
	
	@ApiModelProperty(value="使用类别 | 1.门诊 2。住院")
    private Integer sylb;
	
	@ApiModelProperty(value="关联序号")
    private Integer ypxh;
	
	@ApiModelProperty(value="医嘱名称")
    private String yzmc;
	
	@ApiModelProperty(value="费用数量")
    private BigDecimal fysl;
	
	@ApiModelProperty(value="药品单价")
    private BigDecimal ypdj;
	
	@ApiModelProperty(value="项目类型")
    private Integer xmlx;
	
	@ApiModelProperty(value="费用单位")
    private String fydw;
	
	@ApiModelProperty(value="费用科室")
    private Integer fyks;
	
	@ApiModelProperty(value="费用归并")
    private Integer fygb;

	@ApiModelProperty(value="记录序号")
	private Integer jlxh;

	@ApiModelProperty(value="关联序号")
	private Integer glxh;

	@ApiModelProperty(value="费用名称")
	private String fymc;

	@ApiModelProperty(value="机构ID")
	private Integer jgid;

	@ApiModelProperty(value="科室代码")
	private Integer ksdm;






	public Integer getXmxh() {
		return xmxh;
	}

	public void setXmxh(Integer xmxh) {
		this.xmxh = xmxh;
	}

	public Integer getSylb() {
		return sylb;
	}

	public void setSylb(Integer sylb) {
		this.sylb = sylb;
	}

	public Integer getYpxh() {
		return ypxh;
	}

	public void setYpxh(Integer ypxh) {
		this.ypxh = ypxh;
	}

	public String getYzmc() {
		return yzmc;
	}

	public void setYzmc(String yzmc) {
		this.yzmc = yzmc;
	}

	public BigDecimal getFysl() {
		return fysl;
	}

	public void setFysl(BigDecimal fysl) {
		this.fysl = fysl;
	}

	public BigDecimal getYpdj() {
		return ypdj;
	}

	public void setYpdj(BigDecimal ypdj) {
		this.ypdj = ypdj;
	}

	public Integer getXmlx() {
		return xmlx;
	}

	public void setXmlx(Integer xmlx) {
		this.xmlx = xmlx;
	}

	public String getFydw() {
		return fydw;
	}

	public void setFydw(String fydw) {
		this.fydw = fydw;
	}

	public Integer getFyks() {
		return fyks;
	}

	public void setFyks(Integer fyks) {
		this.fyks = fyks;
	}

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public Integer getJlxh() {
		return jlxh;
	}

	public void setJlxh(Integer jlxh) {
		this.jlxh = jlxh;
	}

	public Integer getGlxh() {
		return glxh;
	}

	public void setGlxh(Integer glxh) {
		this.glxh = glxh;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public Integer getKsdm() {
		return ksdm;
	}

	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}
}
