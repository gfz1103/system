package com.buit.his.sys.openapi.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author sunjx
 * @Date 2020-12-15 15:47
 * @Description
 **/
@ApiModel("查询字典响应")
public class QueryDictResponse {

    @ApiModelProperty(value = "code,数据存储使用")
    private String dv;
    @ApiModelProperty(value = "名称")
    private String dn;
    @ApiModelProperty(value = "是否停用 sys_flag_data:11,0:启用 1:停用 ")
    private String stop;
    @ApiModelProperty(value = "排序")
    private Integer showOrder;
    @ApiModelProperty(value = "拼音码")
    private String py;
    @ApiModelProperty(value = "五笔码")
    private String wb;

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getDn() {
        return dn;
    }

    public void setDn(String dn) {
        this.dn = dn;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public String getPy() {
        return py;
    }

    public void setPy(String py) {
        this.py = py;
    }

    public String getWb() {
        return wb;
    }

    public void setWb(String wb) {
        this.wb = wb;
    }
}
