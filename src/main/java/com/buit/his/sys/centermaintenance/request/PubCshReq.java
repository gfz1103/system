
package com.buit.his.sys.centermaintenance.request;

import java.util.List;

import com.buit.his.sys.centermaintenance.response.PubCshResp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：Gyghj<br>
 * 类描述：功能集字典<br>
 *
 * @author beijunhua
 */
@ApiModel(value = "初始化")
public class PubCshReq {
    @ApiModelProperty(value = "用户名")
    private String userid;
    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "子集集合")
    private List<PubCshResp> childrenList;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<PubCshResp> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<PubCshResp> childrenList) {
        this.childrenList = childrenList;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
