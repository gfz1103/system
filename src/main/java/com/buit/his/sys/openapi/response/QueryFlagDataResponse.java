package com.buit.his.sys.openapi.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:47
 * @Description
 **/
@ApiModel("查询字典响应(flag_data)")
public class QueryFlagDataResponse {

    @ApiModelProperty(value = "code")
    private String code;
    @ApiModelProperty(value = "名称")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
