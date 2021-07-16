package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeYlsfxmBxResp<br> 
 * 类描述：机构收费项目维护明细_备血<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_明细项目_bxResp")
public class FeeYlsfxmBxResp {
    @ApiModelProperty(value="费用序号")
	private Integer sxpzdm;
	
	@ApiModelProperty(value="费用名称")
	private String sxpzmc;
	
	@ApiModelProperty(value="费用单位")
	private String dw;
	
	@ApiModelProperty(value="标准价格")
	private BigDecimal bzjg;
	
	@ApiModelProperty(value="项目类型")
	private Integer xmlx;
	
	@ApiModelProperty(value="费用单价")
	private BigDecimal dj;
	
	@ApiModelProperty(value="商保价格")
	private BigDecimal sbjg;
	
	@ApiModelProperty(value="费用归并")
	private Integer fygb;
	
	@ApiModelProperty(value="费用单价")
	private Integer fyks;

	public Integer getSxpzdm() {
		return sxpzdm;
	}

	public void setSxpzdm(Integer sxpzdm) {
		this.sxpzdm = sxpzdm;
	}

	public String getSxpzmc() {
		return sxpzmc;
	}

	public void setSxpzmc(String sxpzmc) {
		this.sxpzmc = sxpzmc;
	}

	public String getDw() {
		return dw;
	}

	public void setDw(String dw) {
		this.dw = dw;
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

	public BigDecimal getDj() {
		return dj;
	}

	public void setDj(BigDecimal dj) {
		this.dj = dj;
	}

	public BigDecimal getSbjg() {
		return sbjg;
	}

	public void setSbjg(BigDecimal sbjg) {
		this.sbjg = sbjg;
	}

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public Integer getFyks() {
		return fyks;
	}

	public void setFyks(Integer fyks) {
		this.fyks = fyks;
	}
    
}
