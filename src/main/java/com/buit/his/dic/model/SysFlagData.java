package com.buit.his.dic.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：SysFlagData<br>
 * 类描述：系统标识字典主记录<br>
 * @author wangyang
 */
@ApiModel(value = "系统标识字典主记录")
public class SysFlagData extends PageQuery {
	@ApiModelProperty(value = "字典主记录唯一标识")
	/** 标识数据ID */
	private Integer flagDataId;
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
	@ApiModelProperty(value = "标识数据代码")
	/** 标识数据代码 */
	private String flagDataCode;
	@ApiModelProperty(value = "标识数据名称")
	/** 标识数据名称 */
	private String flagDataName;
	@ApiModelProperty(value = "值域代码")
	/** 值域代码 */
	private String rangeCode;
	// @ApiModelProperty(value="数据标准依据标识")
	/** 数据标准依据标识 */
	@ApiModelProperty(value = "拼音码")
	/** 拼音码 */
	private String pyCode;
	@ApiModelProperty(value = "五笔码")
	/** 五笔码 */
	private String wbCode;

	public Integer getFlagDataId() {
		return flagDataId;
	}

	public void setFlagDataId(Integer flagDataId) {
		this.flagDataId = flagDataId;
	}

	public String getFlagDataCode() {
		return flagDataCode;
	}

	public void setFlagDataCode(String flagDataCode) {
		this.flagDataCode = flagDataCode;
	}

	public String getFlagDataName() {
		return flagDataName;
	}

	public void setFlagDataName(String flagDataName) {
		this.flagDataName = flagDataName;
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

	/** 设置:值域代码 */
	public void setRangeCode(String value) {
		this.rangeCode = value;
	}

	/** 获取:值域代码 */
	public String getRangeCode() {
		return rangeCode;
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

//    /** 设置:归类树节点的ID  */
//    public void setNodeId(Integer value) {
//        this.nodeId = value;
//    }
//    /** 获取:归类树节点的ID */
//    public Integer getNodeId() {
//        return nodeId;
//    }

}