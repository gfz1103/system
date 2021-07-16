   
package com.buit.his.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysUser<br> 
 * 类描述：只返回部分用户数据
 * @author All
 */
@ApiModel(value="系统用户表")
public class SysUserAddResp  {
    @ApiModelProperty(value="用户数据ID")
    private Integer userId;
    @ApiModelProperty(value="用户姓名")
    private String userName;
    @ApiModelProperty(value="科室ID")
    private Integer deptId;
	@ApiModelProperty(value="拼音码")
    private String pyCode;
	@ApiModelProperty(value="五笔码")
    private String wbCode;
	
	
    public String getPyCode() {
		return pyCode;
	}
	public void setPyCode(String pyCode) {
		this.pyCode = pyCode;
	}
	public String getWbCode() {
		return wbCode;
	}
	public void setWbCode(String wbCode) {
		this.wbCode = wbCode;
	}
	/**
     * 设置:用户数据ID
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }
    /**
     * 获取:用户数据ID
     */
    public Integer getUserId() {
        return userId;
    }
    /**
     * 设置:用户姓名
     */
    public void setUserName(String value) {
        this.userName = value;
    }
    /**
     * 获取:用户姓名
     */
    public String getUserName() {
        return userName;
    }
    /**
     * 设置:科室ID
     */
    public void setDeptId(Integer value) {
        this.deptId = value;
    }
    /**
     * 获取:科室ID
     */
    public Integer getDeptId() {
        return deptId;
    }
    
}