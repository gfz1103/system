package com.buit.his.sys.openapi.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;

/**
 * @Author sunjx
 * @Date 2020-12-14 16:14
 * @Description
 **/
@ApiModel("保存收费项目明细响应")
public class SaveSfxmmxResponse {

    @ApiModelProperty(value = "费用序号")
    private Integer fyxh;

    public Integer getFyxh() {
        return fyxh;
    }

    public void setFyxh(Integer fyxh) {
        this.fyxh = fyxh;
    }
}
