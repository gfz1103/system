package com.buit.his.user.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel(value="可写权限控制")
public class SysYwqxkzDetailReq {
    @NotNull(message = "权限ID不能为空")
    @ApiModelProperty(value="权限ID",required = true)
    private Integer ksdm;

    @NotNull(message = "可写权限不能为空")
    @ApiModelProperty(value="可写权限不能为空",required = true)
    private Integer write;

    public Integer getKsdm() {
        return ksdm;
    }

    public void setKsdm(Integer ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getWrite() {
        return write;
    }

    public void setWrite(Integer write) {
        this.write = write;
    }
}
