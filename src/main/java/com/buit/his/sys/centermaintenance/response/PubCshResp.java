
package com.buit.his.sys.centermaintenance.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：Gycsh<br>
 * 类描述：初始化字典<br>
 *
 * @author beijunhua
 */
@ApiModel(value = "初始化字典")
public class PubCshResp {
    @ApiModelProperty(value = "groupid")
    private Integer groupid;
    @ApiModelProperty(value = "officeid")
    private Integer officeid;
    @ApiModelProperty(value = "机构id")
    private Integer jgid;
    @ApiModelProperty(value = "初始化")
    private Integer init;

    /*@ApiModelProperty(value = "子集集合")
    private List<PubCshResp> childrenList;*/

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

    public Integer getJgid() {
        return jgid;
    }

    public void setJgid(Integer jgid) {
        this.jgid = jgid;
    }

    public Integer getInit() {
        return init;
    }

    public void setInit(Integer init) {
        this.init = init;
    }
}
