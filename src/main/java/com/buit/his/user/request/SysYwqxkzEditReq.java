   
package com.buit.his.user.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysYwqxkz<br> 
 * 类描述：公用_公用权限控制编辑<br>
 * @author "文光临"
 */
@ApiModel(value="公用_公用权限控制编辑")
public class SysYwqxkzEditReq{
	@NotNull(message = "员工代码不能为空")
    @ApiModelProperty(value="员工代码,personid",required = true)
    private Integer ygdm;
	@NotNull(message = "业务类别")
    @ApiModelProperty(value="业务类别ID,btId",required = true)
    private Integer ywlb;
    @ApiModelProperty(value="权限ID集合 queryid")
    private List<SysYwqxkzDetailReq> queryids;
    @ApiModelProperty(value="机构代码",hidden = true)
    private Integer jgid;
    @ApiModelProperty(value="默认标志 ",hidden = true)
    private Integer mrbz;
    @ApiModelProperty(value="插入数据时使用 不对外 ",hidden = true)
    private Integer ksdm;
	@ApiModelProperty(value="插入数据时使用 不对外 ",hidden = true)
	private Integer write;
    
	public Integer getKsdm() {
		return ksdm;
	}
	public void setKsdm(Integer ksdm) {
		this.ksdm = ksdm;
	}
	public Integer getYgdm() {
		return ygdm;
	}
	public void setYgdm(Integer ygdm) {
		this.ygdm = ygdm;
	}
	
	public Integer getYwlb() {
		return ywlb;
	}
	public void setYwlb(Integer ywlb) {
		this.ywlb = ywlb;
	}

	public List<SysYwqxkzDetailReq> getQueryids() {
		return queryids;
	}

	public void setQueryids(List<SysYwqxkzDetailReq> queryids) {
		this.queryids = queryids;
	}

	public Integer getJgid() {
		return jgid;
	}
	public void setJgid(Integer jgid) {
		this.jgid = jgid;
	}
	public Integer getMrbz() {
		return mrbz;
	}
	public void setMrbz(Integer mrbz) {
		this.mrbz = mrbz;
	}

	public Integer getWrite() {
		return write;
	}

	public void setWrite(Integer write) {
		this.write = write;
	}
}
