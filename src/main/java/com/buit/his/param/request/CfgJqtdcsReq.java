package com.buit.his.param.request;

 
import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：CfgJqtdcsReq<br> 
 * 类描述：公用_客户端系统参数<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_客户端系统参数_Req")
public class CfgJqtdcsReq extends PageQuery{
   
	@ApiModelProperty(value="机构编码", hidden = true)
    private Integer jgid;
	
	@ApiModelProperty(value="IP")
    private String ip;

	@ApiModelProperty(value="参数名称")
    private String csm;

	@ApiModelProperty(value="备注")
    private String bz;

	@ApiModelProperty(value="所属类别（用于参数归类）")
    private String sslb;
	
	@ApiModelProperty(value="参数值", hidden = true)
    private String csz;
	
	@ApiModelProperty(value="是否启用", hidden = true)
    private Integer sfqy;

	public Integer getJgid() {
		return jgid;
	}

	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCsm() {
		return csm;
	}

	public void setCsm(String csm) {
		this.csm = csm;
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

	public Integer getSfqy() {
		return sfqy;
	}

	public void setSfqy(Integer sfqy) {
		this.sfqy = sfqy;
	}

	
}
