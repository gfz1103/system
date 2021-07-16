   
package com.buit.his.user.request;

import java.util.List;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysUserResource<br> 
 * 类描述：用户与资源对应关系<br>
 * @author All
 */
@ApiModel(value="用户与资源对应关系")
public class SysUserResourceReq  {
    @ApiModelProperty(value="各资源主键")
    @NotNull(message = "用户ID不能为空")
    private Integer resourceId;   
	@NotNull(message = "用户ID列表不能为空")
    @ApiModelProperty(value="授权的所有用户ID列表")
    private List<Integer> userIds;
	public Integer getResourceId() {
		return resourceId;
	}
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}
	public List<Integer> getUserIds() {
		return userIds;
	}
	public void setUserIds(List<Integer> userIds) {
		this.userIds = userIds;
	}
}