package com.buit.his.dic.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;

/**
 * 类名称：DicGbsj01<br> 
 * 类描述：标准数据主记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据主记录")
public class DicGbsj01  extends  PageQuery{
	//@ApiModelProperty(value="标准数据ID")
    /** 标准数据ID */
    private Integer primarydataId;
	//@ApiModelProperty(value="数据版本")
    /** 数据版本 */
    private Integer dataVersion;
	//@ApiModelProperty(value="数据创建时间")
    /** 数据创建时间 */
    private Timestamp gmtCreate;
	//@ApiModelProperty(value="数据修改时间")
    /** 数据修改时间 */
    private Timestamp gmtModify;
	//@ApiModelProperty(value="医疗机构ID")
    /** 医疗机构ID */
    private Integer hospitalId;
	//@ApiModelProperty(value="标准数据代码")
    /** 标准数据代码 */
    private String primaryDataCode;
	//@ApiModelProperty(value="标准数据名称")
    /** 标准数据名称 */
    private String primaryDataName;
	//@ApiModelProperty(value="值域代码")
    /** 值域代码 */
    private String rangeCode;
	//@ApiModelProperty(value="{'CN':'主数据标准依据标识','FD':'FD000001'}")
    /** {'CN':'主数据标准依据标识','FD':'FD000001'} */
    private String identificationFlag;
	//@ApiModelProperty(value="拼音码")
    /** 拼音码 */
    private String pyCode;
	//@ApiModelProperty(value="五笔码")
    /** 五笔码 */
    private String wbCode;
	//@ApiModelProperty(value="{'CN':'数据显示方式','FD':'FD000002'}")
    /** {'CN':'数据显示方式','FD':'FD000002'} */
    private String dataViewType;
	//@ApiModelProperty(value="是否可扩展，0，不可扩展，1，可扩展")
    /** 是否可扩展，0，不可扩展，1，可扩展 */
    private String canExtend;
    /** 操作人ID */
    private Integer operatorId;
    /** 数据字典查询条件 */
    private String condition;
    /** 是否删除 0:否 1:删除 */
    private Integer deleted;

    /** 设置:标准数据ID  */
    public void setPrimarydataId(Integer value) {
        this.primarydataId = value;
    }
    /** 获取:标准数据ID */
    public Integer getPrimarydataId() {
        return primarydataId;
    }

    /** 设置:数据版本  */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /** 获取:数据版本 */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /** 设置:数据创建时间  */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /** 获取:数据创建时间 */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /** 设置:数据修改时间  */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /** 获取:数据修改时间 */
    public Timestamp getGmtModify() {
        return gmtModify;
    }

    /** 设置:医疗机构ID  */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }
    /** 获取:医疗机构ID */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /** 设置:标准数据代码  */
    public void setPrimaryDataCode(String value) {
        this.primaryDataCode = value;
    }
    /** 获取:标准数据代码 */
    public String getPrimaryDataCode() {
        return primaryDataCode;
    }

    /** 设置:标准数据名称  */
    public void setPrimaryDataName(String value) {
        this.primaryDataName = value;
    }
    /** 获取:标准数据名称 */
    public String getPrimaryDataName() {
        return primaryDataName;
    }

    /** 设置:值域代码  */
    public void setRangeCode(String value) {
        this.rangeCode = value;
    }
    /** 获取:值域代码 */
    public String getRangeCode() {
        return rangeCode;
    }

    /** 设置:{'CN':'主数据标准依据标识','FD':'FD000001'}  */
    public void setIdentificationFlag(String value) {
        this.identificationFlag = value;
    }
    /** 获取:{'CN':'主数据标准依据标识','FD':'FD000001'} */
    public String getIdentificationFlag() {
        return identificationFlag;
    }

    /** 设置:拼音码  */
    public void setPyCode(String value) {
        this.pyCode = value;
    }
    /** 获取:拼音码 */
    public String getPyCode() {
        return pyCode;
    }

    /** 设置:五笔码  */
    public void setWbCode(String value) {
        this.wbCode = value;
    }
    /** 获取:五笔码 */
    public String getWbCode() {
        return wbCode;
    }

    /** 设置:{'CN':'数据显示方式','FD':'FD000002'}  */
    public void setDataViewType(String value) {
        this.dataViewType = value;
    }
    /** 获取:{'CN':'数据显示方式','FD':'FD000002'} */
    public String getDataViewType() {
        return dataViewType;
    }

    /** 设置:是否可扩展，0，不可扩展，1，可扩展  */
    public void setCanExtend(String value) {
        this.canExtend = value;
    }
    /** 获取:是否可扩展，0，不可扩展，1，可扩展 */
    public String getCanExtend() {
        return canExtend;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }
}
