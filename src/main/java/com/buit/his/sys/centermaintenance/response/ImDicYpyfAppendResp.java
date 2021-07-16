package com.buit.his.sys.centermaintenance.response;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：ImDicYpyfAppendResp<br> 
 * 类描述：药品用法附加项目<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value = "住院_药品用法附加项目_AppendResp")
public class ImDicYpyfAppendResp {
    @ApiModelProperty(value = "使用类别")
    private Integer sylb;
    @ApiModelProperty(value = "项目序号")
    private Integer ypxh;
    @ApiModelProperty(value = "费用数量")
    private BigDecimal fysl;
    @ApiModelProperty(value = "项目名称")
    private String yzmc;
    @ApiModelProperty(value = "费用单价")
    private BigDecimal ypdj;
    @ApiModelProperty(value = "费用单位")
    private String fydw;
    @ApiModelProperty(value = "费用科室")
    private Integer fyks;
    @ApiModelProperty(value = "费用归并")
    private Integer fygb;
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


   
}
