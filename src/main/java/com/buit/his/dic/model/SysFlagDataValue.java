package com.buit.his.dic.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SysFlagDataValue<br>
 * 类描述： 系统标识字典从记录<br>
 * @author wangyang
 */
@ApiModel(value = "系统标识字典从记录")
public class SysFlagDataValue extends PageQuery {
	@ApiModelProperty(value = "字典从记录唯一标识")
	/** 标识数据值ID */
	private Integer flagDataValueId;
	@ApiModelProperty(value = "数据版本")
	/** 数据版本 */
	private Integer dataVersion;
	@ApiModelProperty(value = "数据创建时间")
	/** 数据创建时间 */
	private Timestamp gmtCreate;
	@ApiModelProperty(value = "数据修改时间")
	/** 数据修改时间 */
	private Timestamp gmtModify;
	@ApiModelProperty(value = "医疗机构ID")
	/** 医疗机构ID */
	private Integer hospitalId;
	@ApiModelProperty(value = "字典主记录唯一标识")
	/** 标识数据ID */
	private Integer flagDataId;
	@ApiModelProperty(value = "序号")
	/** 序号 */
	private Integer serialNumber;
	 @ApiModelProperty(value="字典编码")
	/** 值 */
	private String flagDataValue;
	 @ApiModelProperty(value="字典名称")
	/** 值含义 */
	private String flagDataValueRemark;
	// @ApiModelProperty(value="上级主数据ID")
	/** 上级主数据ID */
	private Integer parentFlagdatavalueId;
	@ApiModelProperty(value = "拼音码")
	/** 拼音码 */
	private String pyCode;
	@ApiModelProperty(value = "五笔码")
	/** 五笔码 */
	private String wbCode;
	@JsonIgnore
	@ApiModelProperty(value = "分页查询条件")
	/** 分页查询条件 */
	private String condition;
	@ApiModelProperty(value = "停用标识 0：启用； 1：停用； SysFlagDataValue：11")
	/** 停用标识 0：启用 1：停用 */
	private String stopFlag;

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

	/** 设置:序号 */
	public void setSerialNumber(Integer value) {
		this.serialNumber = value;
	}

	/** 获取:序号 */
	public Integer getSerialNumber() {
		return serialNumber;
	}

	/** 设置:上级主数据ID */
	public void setParentFlagdatavalueId(Integer value) {
		this.parentFlagdatavalueId = value;
	}

	/** 获取:上级主数据ID */
	public Integer getParentFlagdatavalueId() {
		return parentFlagdatavalueId;
	}

	/** 设置:拼音码 */
	public void setPyCode(String value) {
		this.pyCode = value;
	}

	/** 获取:拼音码 */
	public String getPyCode() {
		return pyCode;
	}

	/** 设置:五笔码 */
	public void setWbCode(String value) {
		this.wbCode = value;
	}

	/** 获取:五笔码 */
	public String getWbCode() {
		return wbCode;
	}

	public Integer getFlagDataValueId() {
		return flagDataValueId;
	}

	public void setFlagDataValueId(Integer flagDataValueId) {
		this.flagDataValueId = flagDataValueId;
	}

	public Integer getFlagDataId() {
		return flagDataId;
	}

	public void setFlagDataId(Integer flagDataId) {
		this.flagDataId = flagDataId;
	}

	public String getFlagDataValue() {
		return flagDataValue;
	}

	public void setFlagDataValue(String flagDataValue) {
		this.flagDataValue = flagDataValue;
	}

	public String getFlagDataValueRemark() {
		return flagDataValueRemark;
	}

	public void setFlagDataValueRemark(String flagDataValueRemark) {
		this.flagDataValueRemark = flagDataValueRemark;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

	public String getStopFlag() {
		return stopFlag;
	}

	public void setStopFlag(String stopFlag) {
		this.stopFlag = stopFlag;
	}

}