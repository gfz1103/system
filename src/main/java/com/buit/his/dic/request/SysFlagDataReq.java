
package com.buit.his.dic.request;


import javax.validation.constraints.NotNull;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysFlagData<br>
 * 类描述：标识数据主记录<br>
 * @author All
 */
@ApiModel(value="标识数据主记录")
public class SysFlagDataReq  extends  PageQuery{
    @NotNull(message = "标识数据代码不能为空")
    @ApiModelProperty(value="标识数据代码")
    private String flagdataCode;

    /**
     * 设置:标识数据代码
     */
    public void setFlagdataCode(String value) {
        this.flagdataCode = value;
    }
    /**
     * 获取:标识数据代码
     */
    public String getFlagdataCode() {
        return flagdataCode;
    }
}