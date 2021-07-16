package com.buit.his.user.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SysGroup<br>
 * 类描述：用户组表<br>
 * @author wangyang
 */
@ApiModel(value="用户组表")  
public class SysGroup extends PageQuery {
	 @ApiModelProperty(value="用户组数据ID")
	/** 用户组数据ID */
	private Integer groupId;
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
	// @ApiModelProperty(value="用户组代码")
	/** 用户组代码 */
	private String groupCode;
	// @ApiModelProperty(value="用户组名称")
	/** 用户组名称 */
	private String groupName;
	// @ApiModelProperty(value="{"CN":"停用标识","FD":"FD000011"}")
	/** {"CN":"停用标识","FD":"FD000011"} */
	@ApiModelProperty(value = "{'1':'停用','0':'启用'}")
	private String stopFlag;
	// @ApiModelProperty(value="{"CN":"拼音码"}")
	/** {"CN":"拼音码"} */
	private String pyCode;
	// @ApiModelProperty(value="{"CN":"五笔码"}")
	/** {"CN":"五笔码"} */
	private String wbCode;
	// @ApiModelProperty(value="组类型")
	/** 组类型 */
	private String groupType;
	// @ApiModelProperty(value="首页url")
	/** 首页url */
	private String homepageUrl;
	// @ApiModelProperty(value="序号")
	/** 序号 */
	private Integer groupSeq;
//	@ApiModelProperty(value = "岗位icon")
	private String icon;
//	@ApiModelProperty(value="业务类型ID")
    private Integer btId;

    private Integer systemType;

	public Integer getBtId() {
		return btId;
	}

	public void setBtId(Integer btId) {
		this.btId = btId;
	}

	/** 设置:用户组数据ID */
	public void setGroupId(Integer value) {
		this.groupId = value;
	}

	/** 获取:用户组数据ID */
	public Integer getGroupId() {
		return groupId;
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

	/** 设置:用户组代码 */
	public void setGroupCode(String value) {
		this.groupCode = value;
	}

	/** 获取:用户组代码 */
	public String getGroupCode() {
		return groupCode;
	}

	/** 设置:用户组名称 */
	public void setGroupName(String value) {
		this.groupName = value;
	}

	/** 获取:用户组名称 */
	public String getGroupName() {
		return groupName;
	}

	/** 设置:{"CN":"停用标识","FD":"FD000011"} */
	public void setStopFlag(String value) {
		this.stopFlag = value;
	}

	/** 获取:{"CN":"停用标识","FD":"FD000011"} */
	public String getStopFlag() {
		return stopFlag;
	}

	/** 设置:{"CN":"拼音码"} */
	public void setPyCode(String value) {
		this.pyCode = value;
	}

	/** 获取:{"CN":"拼音码"} */
	public String getPyCode() {
		return pyCode;
	}

	/** 设置:{"CN":"五笔码"} */
	public void setWbCode(String value) {
		this.wbCode = value;
	}

	/** 获取:{"CN":"五笔码"} */
	public String getWbCode() {
		return wbCode;
	}

	/** 设置:组类型 */
	public void setGroupType(String value) {
		this.groupType = value;
	}

	/** 获取:组类型 */
	public String getGroupType() {
		return groupType;
	}

	/** 设置:首页url */
	public void setHomepageUrl(String value) {
		this.homepageUrl = value;
	}

	/** 获取:首页url */
	public String getHomepageUrl() {
		return homepageUrl;
	}

	/** 设置:序号 */
	public void setGroupSeq(Integer value) {
		this.groupSeq = value;
	}

	/** 获取:序号 */
	public Integer getGroupSeq() {
		return groupSeq;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Integer getSystemType() {
		return systemType;
	}

	public void setSystemType(Integer systemType) {
		this.systemType = systemType;
	}
}