package com.buit.his.sys.openapi.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:45
 * @Description
 **/
@ApiModel("字典查询请求(flag_data)")
public class QueryFlagDataRequest {

    @ApiModelProperty("字典Code")
    private String dataCode;

    @ApiModelProperty("机构ID")
    private Integer hospitalId;

    public String getDataCode() {
        return dataCode;
    }

    public void setDataCode(String dataCode) {
        this.dataCode = dataCode;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }
}
