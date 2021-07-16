
package com.buit.his.dic.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysFlagDataValue<br>
 * 类描述：标识数据内容表<br>
 * @author All
 */
@ApiModel(value="标识数据内容表")
public class SysFlagDataValueResp  extends  PageQuery{
    @ApiModelProperty(value="标识数据值ID")
    private Integer flagdatavalueId;
    @ApiModelProperty(value="数据版本")
    private Integer dataVersion;
    @ApiModelProperty(value="数据创建时间")
    private Timestamp gmtCreate;
    @ApiModelProperty(value="数据修改时间")
    private Timestamp gmtModify;
    @ApiModelProperty(value="医疗机构ID")
    private Integer hospitalId;
    @ApiModelProperty(value="标识数据ID")
    private Integer flagdataId;
    @ApiModelProperty(value="序号")
    private Integer serialNumber;
    @ApiModelProperty(value="值")
    private String flagdataValue;
    @ApiModelProperty(value="值含义")
    private String flagdataValueRemark;
    @ApiModelProperty(value="上级主数据ID")
    private Integer parentFlagdatavalueId;
    @ApiModelProperty(value="拼音码")
    private String pyCode;
    @ApiModelProperty(value="五笔码")
    private String wbCode;
    /**
     * 设置:标识数据值ID
     */
    public void setFlagdatavalueId(Integer value) {
        this.flagdatavalueId = value;
    }
    /**
     * 获取:标识数据值ID
     */
    public Integer getFlagdatavalueId() {
        return flagdatavalueId;
    }
    /**
     * 设置:数据版本
     */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /**
     * 获取:数据版本
     */
    public Integer getDataVersion() {
        return dataVersion;
    }
    /**
     * 设置:数据创建时间
     */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /**
     * 获取:数据创建时间
     */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }
    /**
     * 设置:数据修改时间
     */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /**
     * 获取:数据修改时间
     */
    public Timestamp getGmtModify() {
        return gmtModify;
    }
    /**
     * 设置:医疗机构ID
     */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }
    /**
     * 获取:医疗机构ID
     */
    public Integer getHospitalId() {
        return hospitalId;
    }
    /**
     * 设置:标识数据ID
     */
    public void setFlagdataId(Integer value) {
        this.flagdataId = value;
    }
    /**
     * 获取:标识数据ID
     */
    public Integer getFlagdataId() {
        return flagdataId;
    }
    /**
     * 设置:序号
     */
    public void setSerialNumber(Integer value) {
        this.serialNumber = value;
    }
    /**
     * 获取:序号
     */
    public Integer getSerialNumber() {
        return serialNumber;
    }
    /**
     * 设置:值
     */
    public void setFlagdataValue(String value) {
        this.flagdataValue = value;
    }
    /**
     * 获取:值
     */
    public String getFlagdataValue() {
        return flagdataValue;
    }
    /**
     * 设置:值含义
     */
    public void setFlagdataValueRemark(String value) {
        this.flagdataValueRemark = value;
    }
    /**
     * 获取:值含义
     */
    public String getFlagdataValueRemark() {
        return flagdataValueRemark;
    }
    /**
     * 设置:上级主数据ID
     */
    public void setParentFlagdatavalueId(Integer value) {
        this.parentFlagdatavalueId = value;
    }
    /**
     * 获取:上级主数据ID
     */
    public Integer getParentFlagdatavalueId() {
        return parentFlagdatavalueId;
    }
    /**
     * 设置:拼音码
     */
    public void setPyCode(String value) {
        this.pyCode = value;
    }
    /**
     * 获取:拼音码
     */
    public String getPyCode() {
        return pyCode;
    }
    /**
     * 设置:五笔码
     */
    public void setWbCode(String value) {
        this.wbCode = value;
    }
    /**
     * 获取:五笔码
     */
    public String getWbCode() {
        return wbCode;
    }
}