package com.buit.his.user.request;
   
import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysUserGroup<br> 
 * 类描述：系统用户与用户组对照表<br>
 * @author All
 */
@ApiModel(value="系统用户与用户组对照编辑")
public class SysUserGroupEditReq{
	@NotNull(message = "用户ID不能为空")
    @ApiModelProperty(value="用户ID")
    private Integer userId;
	@NotNull(message = "用户组ID集合不能为空")
    @ApiModelProperty(value="用户组ID")
    private List<Integer> groups;
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public List<Integer> getGroups() {
		return groups;
	}
	public void setGroups(List<Integer> groups) {
		this.groups = groups;
	}
}