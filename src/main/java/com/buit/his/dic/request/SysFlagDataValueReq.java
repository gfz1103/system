
package com.buit.his.dic.request;


import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysFlagDataValue<br>
 * 类描述：标识数据内容表<br>
 * @author All
 */
@ApiModel(value="标识数据内容表")
public class SysFlagDataValueReq  extends  PageQuery{
    @ApiModelProperty(value="标识数据ID")
    private Integer flagdataId;
	@ApiModelProperty(value="医疗机构ID")
    private Integer hospitalId;
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
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
}