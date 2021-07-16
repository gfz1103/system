package com.buit.his.sys.openapi.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:19
 * @Description
 **/
@ApiModel
public class QuerysfxmlbListRequest {

    @ApiModelProperty("费用分类(1:医疗2:药品3:其他)")
    private Integer fyfl;

    @ApiModelProperty("拼音代码")
    private String pydm;

    public Integer getFyfl() {
        return fyfl;
    }

    public void setFyfl(Integer fyfl) {
        this.fyfl = fyfl;
    }

    public String getPydm() {
        return pydm;
    }

    public void setPydm(String pydm) {
        this.pydm = pydm;
    }
}
