package com.buit.his.sys.openapi.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-18 10:48
 * @Description
 **/
@ApiModel("获取新增项目编码请求")
public class QueryNextSfxmbmRequest {

    @ApiModelProperty("项目类别")
    private String sfxmlb;

    public String getSfxmlb() {
        return sfxmlb;
    }

    public void setSfxmlb(String sfxmlb) {
        this.sfxmlb = sfxmlb;
    }
}
