
package com.buit.his.sys.centermaintenance.response;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：Gyghj<br>
 * 类描述：功能集字典<br>
 *
 * @author beijunhua
 */
@ApiModel(value = "功能集字典")
public class PubCshywjResp {
    @ApiModelProperty(value = "groupid")
    private Integer groupid;
    @ApiModelProperty(value = "officeid")
    private Integer officeid;
    @ApiModelProperty(value = "officename")
    private String officename;
    @ApiModelProperty(value = "init")
    private Integer init;
    @ApiModelProperty(value = "使用标志")
    private Integer sybz;
    @ApiModelProperty(value = "前提条件")
    private Integer qttj;

    @ApiModelProperty(value = "子集集合")
    private List<PubCshResp> childrenList;

    public Integer getGroupid() {
        return groupid;
    }

    public void setGroupid(Integer groupid) {
        this.groupid = groupid;
    }

    public Integer getOfficeid() {
        return officeid;
    }

    public void setOfficeid(Integer officeid) {
        this.officeid = officeid;
    }

    public String getOfficename() {
        return officename;
    }

    public void setOfficename(String officename) {
        this.officename = officename;
    }

    public Integer getInit() {
        return init;
    }

    public void setInit(Integer init) {
        this.init = init;
    }

    public Integer getSybz() {
        return sybz;
    }

    public void setSybz(Integer sybz) {
        this.sybz = sybz;
    }

    public Integer getQttj() {
        return qttj;
    }

    public void setQttj(Integer qttj) {
        this.qttj = qttj;
    }

    public List<PubCshResp> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<PubCshResp> childrenList) {
        this.childrenList = childrenList;
    }
}
