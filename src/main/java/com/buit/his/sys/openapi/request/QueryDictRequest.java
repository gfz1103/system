package com.buit.his.sys.openapi.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:45
 * @Description
 **/
@ApiModel("字典查询请求(dict)")
public class QueryDictRequest {

    @ApiModelProperty("字典ID")
    private Integer dictId;

    @ApiModelProperty("机构ID")
    private Integer hospitalId;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }
}
