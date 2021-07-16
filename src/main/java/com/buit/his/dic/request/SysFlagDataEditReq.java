
package com.buit.his.dic.request;


import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysFlagData<br>
 * 类描述：标识数据主记录<br>
 * @author All
 */
@ApiModel(value="标识数据主记录")
public class SysFlagDataEditReq {
    @NotNull(message = "标识数据ID不能为空")
    @ApiModelProperty(value="标识数据ID")
    private Integer flagdataId;
    @ApiModelProperty(value="标识数据名称")
    private String flagdataName;
    @ApiModelProperty(value="数据标准依据标识")
    private String identificationFlag;
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
     * 设置:标识数据名称
     */
    public void setFlagdataName(String value) {
        this.flagdataName = value;
    }
    /**
     * 获取:标识数据名称
     */
    public String getFlagdataName() {
        return flagdataName;
    }

    /**
     * 设置:数据标准依据标识
     */
    public void setIdentificationFlag(String value) {
        this.identificationFlag = value;
    }
    /**
     * 获取:数据标准依据标识
     */
    public String getIdentificationFlag() {
        return identificationFlag;
    }

}