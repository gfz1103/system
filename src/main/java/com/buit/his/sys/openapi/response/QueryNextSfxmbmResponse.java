package com.buit.his.sys.openapi.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-18 10:53
 * @Description
 **/
@ApiModel("获取新收费项目编码响应")
public class QueryNextSfxmbmResponse {

    @ApiModelProperty("新项目编码")
    private String nextSfxmbm;

    public String getNextSfxmbm() {
        return nextSfxmbm;
    }

    public void setNextSfxmbm(String nextSfxmbm) {
        this.nextSfxmbm = nextSfxmbm;
    }
}
