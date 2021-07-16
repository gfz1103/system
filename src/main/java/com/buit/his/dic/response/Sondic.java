package com.buit.his.dic.response;

import io.swagger.annotations.ApiModelProperty;

/**
 * @author All
 */
public class Sondic {
    @ApiModelProperty(value = "code,数据存储使用")
    String dv;
    @ApiModelProperty(value = "名称")
    String dn;
    @ApiModelProperty(value = "是否停用 sys_flag_data:11,0:启用 1:停用 ")
    String stop;
    @ApiModelProperty(value = "排序")
    Integer showOrder;
    @ApiModelProperty(value = "拼音码")
    String py;
    @ApiModelProperty(value = "五笔码")
    String wb;

    public Integer getShowOrder() {
        return showOrder;
    }

    public void setShowOrder(Integer showOrder) {
        this.showOrder = showOrder;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

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
