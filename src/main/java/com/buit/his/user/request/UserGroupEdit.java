   
package com.buit.his.user.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类描述：权限 与用户的批量关联
 * @author All
 */
@ApiModel(value="权限与用户的批量关联")
public class UserGroupEdit  {
    @ApiModelProperty(value="岗位Id")
    @NotNull(message = "岗位Id不可为空")
    private Integer groupId;
    
    @ApiModelProperty(value="所有授权的用户ID")
    @NotNull(message = "用户ID不可为空")
    private List<Integer> userIdList;

	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public List<Integer> getUserIdList() {
		return userIdList;
	}
	public void setUserIdList(List<Integer> userIdList) {
		this.userIdList = userIdList;
	}
}