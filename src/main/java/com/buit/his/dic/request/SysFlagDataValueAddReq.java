package com.buit.his.dic.request;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysFlagDataValue<br>
 * 类描述：标识数据内容表<br>
 * @author All
 */
@ApiModel(value="标识数据内容表")
public class SysFlagDataValueAddReq {
    @NotNull(message = "医疗机构ID不能为空")
    @ApiModelProperty(value="医疗机构ID")
    private Integer hospitalId;

    @NotNull(message = "标识数据ID不能为空")
    @ApiModelProperty(value="标识数据ID")
    private Integer flagdataId;

    @NotNull(message = "序号不能为空")
    @ApiModelProperty(value="序号")
    private Integer serialNumber;

    @NotNull(message = "值不能为空")
    @ApiModelProperty(value="值")
    private String flagdataValue;

    @NotNull(message = "值含义不能为空")
    @ApiModelProperty(value="值含义")
    private String flagdataValueRemark;

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
}