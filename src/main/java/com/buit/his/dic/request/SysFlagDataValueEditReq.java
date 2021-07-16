
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
public class SysFlagDataValueEditReq {
    @NotNull(message = "标识数据值ID不能为空")
    @ApiModelProperty(value="标识数据值ID")
    private Integer flagdatavalueId;

    @ApiModelProperty(value="序号")
    private Integer serialNumber;

    @NotNull(message = "值不能为空")
    @ApiModelProperty(value="值")
    private String flagdataValue;

    @NotNull(message = "值含义不能为空")
    @ApiModelProperty(value="值含义")
    private String flagdataValueRemark;
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