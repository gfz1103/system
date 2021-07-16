   
package com.buit.his.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicYwlb<br> 
 * 类描述：业务类别表<br>
 * @author WENGL
 */
@ApiModel(value="权限对象")
public class BusinessAuth  {

    @ApiModelProperty(value="权限ID")
    private Integer queryid;
    @ApiModelProperty(value="权限名称")
    private String showname;
    @ApiModelProperty(value="是否是留观病区 1：是 0 :否")
    private String lgbq;
    @ApiModelProperty(value="是否是留观科室 1：是 0 :否")
    private String lgks;
    
	public Integer getQueryid() {
		return queryid;
	}
	public void setQueryid(Integer queryid) {
		this.queryid = queryid;
	}
	public String getShowname() {
		return showname;
	}
	public void setShowname(String showname) {
		this.showname = showname;
	}
	public String getLgbq() {
		return lgbq;
	}
	public void setLgbq(String lgbq) {
		this.lgbq = lgbq;
	}
	public String getLgks() {
		return lgks;
	}
	public void setLgks(String lgks) {
		this.lgks = lgks;
	}
	
}
