package com.buit.his.sys.openapi.request;

import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:35
 * @Description
 **/
public class QuerySfxmmxDetailRequest {

    @ApiModelProperty(value="费用序号")
    private Integer fyxh;

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }
}
