package com.buit.his.user.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;

/**
 * 类名称：SysUserResource<br>
 * 类描述：用户与资源对应关系<br>
 * @author
 */
@ApiModel(value = "用户与资源对应关系")
public class SysUserResource extends PageQuery {
	// @ApiModelProperty(value="用户组数据ID")
	/** 用户组数据ID */
	private Integer userresId;
	// @ApiModelProperty(value="数据版本")
	/** 数据版本 */
	private Integer dataVersion;
	// @ApiModelProperty(value="数据创建时间")
	/** 数据创建时间 */
	private Timestamp gmtCreate;
	// @ApiModelProperty(value="数据修改时间")
	/** 数据修改时间 */
	private Timestamp gmtModify;
	// @ApiModelProperty(value="医疗机构ID")
	/** 医疗机构ID */
	private Integer hospitalId;
	// @ApiModelProperty(value="用户ID")
	/** 用户ID */
	private Integer userId;
	// @ApiModelProperty(value="各资源主键")
	/** 各资源主键 */
	private Integer resourceId;
	// @ApiModelProperty(value="资源权限类别 ")
	/**
	 * 资源权限类别 FD000152 SELECT * FROM SYS_FLAG_DATA_VALUE WHERE FLAGDATA_ID =253 0
	 * :医疗机构 ,1 :号表,2 :服务台,3 :科室 ,4 :药房,5 :药库,6 :第三方系统,7 :自定义报表(查询类)
	 */
	private String resourceType;

	/** 设置:用户组数据ID */
	public void setUserresId(Integer value) {
		this.userresId = value;
	}

	/** 获取:用户组数据ID */
	public Integer getUserresId() {
		return userresId;
	}

	/** 设置:数据版本 */
	public void setDataVersion(Integer value) {
		this.dataVersion = value;
	}

	/** 获取:数据版本 */
	public Integer getDataVersion() {
		return dataVersion;
	}

	/** 设置:数据创建时间 */
	public void setGmtCreate(Timestamp value) {
		this.gmtCreate = value;
	}

	/** 获取:数据创建时间 */
	public Timestamp getGmtCreate() {
		return gmtCreate;
	}

	/** 设置:数据修改时间 */
	public void setGmtModify(Timestamp value) {
		this.gmtModify = value;
	}

	/** 获取:数据修改时间 */
	public Timestamp getGmtModify() {
		return gmtModify;
	}

	/** 设置:医疗机构ID */
	public void setHospitalId(Integer value) {
		this.hospitalId = value;
	}

	/** 获取:医疗机构ID */
	public Integer getHospitalId() {
		return hospitalId;
	}

	/** 设置:用户ID */
	public void setUserId(Integer value) {
		this.userId = value;
	}

	/** 获取:用户ID */
	public Integer getUserId() {
		return userId;
	}

	/** 设置:各资源主键 */
	public void setResourceId(Integer value) {
		this.resourceId = value;
	}

	/** 获取:各资源主键 */
	public Integer getResourceId() {
		return resourceId;
	}

	/** 设置:资源权限类别 FD000152 */
	public void setResourceType(String value) {
		this.resourceType = value;
	}

	/** 获取:资源权限类别 FD000152 */
	public String getResourceType() {
		return resourceType;
	}

}