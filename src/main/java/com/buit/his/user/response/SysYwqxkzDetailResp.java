
package com.buit.his.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * 类名称：SysYwqxkz<br>
 * 类描述：公用_公用权限控制详情<br>
 */
@ApiModel(value="公用_公用权限控制详情")
public class SysYwqxkzDetailResp{

    @ApiModelProperty(value="权限ID")
    private Integer ksdm;

    @ApiModelProperty(value="可写权限不能为空")
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
