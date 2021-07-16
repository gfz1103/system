package com.buit.his.user.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhanggy
 * @title: MrmsDoctorResp
 * @description: TODO
 * @date 2021/4/710:51
 */
@ApiModel("医生列表")
public class MrmsDoctorResp {
    @ApiModelProperty("医生id")
    private Integer personId;
    @ApiModelProperty("医生姓名")
    private String personName;
    @ApiModelProperty("医生编号")
    private String ysbh;
    @ApiModelProperty("科室代码")
    private String ksdm;

    public String getKsdm() {
        return ksdm;
    }

    public void setKsdm(String ksdm) {
        this.ksdm = ksdm;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getYsbh() {
        return ysbh;
    }

    public void setYsbh(String ysbh) {
        this.ysbh = ysbh;
    }
}
