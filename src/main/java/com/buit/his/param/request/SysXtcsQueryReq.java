package com.buit.his.param.request;

 
import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysXtcsQueryReq<br> 
 * 类描述：公用_系统参数<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_系统参数_queryReq")
public class SysXtcsQueryReq extends PageQuery{
   
	@ApiModelProperty(value="机构编码", hidden = true)
    private Integer jgid;

	@ApiModelProperty(value="参数名称")
    private String csmc;

	@ApiModelProperty(value="备注")
    private String bz;

	@ApiModelProperty(value="所属类别（用于参数归类）")
    private String sslb;
	
	@ApiModelProperty(value="参数值", hidden = true)
    private String csz;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getCsmc() {
		return csmc;
	}

	public void setCsmc(String csmc) {
		this.csmc = csmc;
	}

	public String getBz() {
		return bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public String getSslb() {
		return sslb;
	}

	public void setSslb(String sslb) {
		this.sslb = sslb;
	}

	public String getCsz() {
		return csz;
	}

	public void setCsz(String csz) {
		this.csz = csz;
	}
	
	
}
