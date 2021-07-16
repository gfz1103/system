package com.buit.his.dic.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author All
 */
@ApiModel(value="通用标识数据字典")
public class CommFlagData {
    @ApiModelProperty(value="字典值")
    private String flagdataValue;
    @ApiModelProperty(value="字典备注")
    private String flagdataValueRemark;

    public String getFlagdataValue() {
        return flagdataValue;
    }

    public void setFlagdataValue(String flagdataValue) {
        this.flagdataValue = flagdataValue;
    }

    public String getFlagdataValueRemark() {
        return flagdataValueRemark;
    }

    public void setFlagdataValueRemark(String flagdataValueRemark) {
        this.flagdataValueRemark = flagdataValueRemark;
    }
}
