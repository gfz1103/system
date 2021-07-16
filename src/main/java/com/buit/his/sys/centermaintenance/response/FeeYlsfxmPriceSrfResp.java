   
package com.buit.his.sys.centermaintenance.response;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


/**
 * 类名称：FeeYlsfxmPriceSrfResp<br> 
 * 类描述：住院_病区项目医嘱<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="收费项目调价_pricesrfResp")
public class FeeYlsfxmPriceSrfResp extends PageQuery{
	
	@ApiModelProperty(value="费用序号")
	private Integer fyxh;
	
	@ApiModelProperty(value="医嘱名称")
	private String fymc;
	
	@ApiModelProperty(value="费用单位")
	private String fydw;
	
	@ApiModelProperty(value="标准价格")
	private BigDecimal bzjg;
	
	@ApiModelProperty(value="费用单价")
	private BigDecimal fydj;
	
	@ApiModelProperty(value="费用归并")
	private Integer fygb;
	
	@ApiModelProperty(value="费用归并名称")
	private String fygbtext;

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

	public BigDecimal getBzjg() {
		return bzjg;
	}

	public void setBzjg(BigDecimal bzjg) {
		this.bzjg = bzjg;
	}

	public BigDecimal getFydj() {
		return fydj;
	}

	public void setFydj(BigDecimal fydj) {
		this.fydj = fydj;
	}

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public String getFygbtext() {
		return fygbtext;
	}

	public void setFygbtext(String fygbtext) {
		this.fygbtext = fygbtext;
	}
	
}
