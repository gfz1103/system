package com.buit.his.dic.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj02<br>
 * 类描述：标准数据值域记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据值分页信息")
public class DicGbsj02PageResp {
    @ApiModelProperty(value="数据值ID")
    private Integer datavalueId;
    @ApiModelProperty(value="编码")
    private String dataValue;
    @ApiModelProperty(value="名称")
    private String dataValueRemark;
    @ApiModelProperty(value = "序号")
    private Integer serialNumber;
    @ApiModelProperty(value="停用标识 1 停用 0启用")
    private String stopFlag;


    public Integer getDatavalueId() {
        return datavalueId;
    }

    public void setDatavalueId(Integer datavalueId) {
        this.datavalueId = datavalueId;
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue;
    }

    public String getDataValueRemark() {
        return dataValueRemark;
    }

    public void setDataValueRemark(String dataValueRemark) {
        this.dataValueRemark = dataValueRemark;
    }

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}
