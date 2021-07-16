   
package com.buit.his.user.response;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysGroupMenu<br> 
 * 类描述：用户组菜单授权表<br>
 * @author
 */
@ApiModel(value="用户组菜单授权表")
public class SysGroupMenuResp  extends  PageQuery{
    @ApiModelProperty(value="菜单授权数据ID")
    private Integer groupmenuId;
    @ApiModelProperty(value="数据版本")
    private Integer dataVersion;
    @ApiModelProperty(value="数据创建时间")
    private Timestamp gmtCreate;
    @ApiModelProperty(value="数据修改时间")
    private Timestamp gmtModify;
    @ApiModelProperty(value="医疗机构ID")
    private Integer hospitalId;
    @ApiModelProperty(value="用户组ID")
    private Integer groupId;
    @ApiModelProperty(value="菜单ID")
    private Integer menuId;
    /**
     * 设置:菜单授权数据ID
     */
    public void setGroupmenuId(Integer value) {
        this.groupmenuId = value;
    }
    /**
     * 获取:菜单授权数据ID
     */
    public Integer getGroupmenuId() {
        return groupmenuId;
    }
    /**
     * 设置:数据版本
     */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /**
     * 获取:数据版本
     */
    public Integer getDataVersion() {
        return dataVersion;
    }
    /**
     * 设置:数据创建时间
     */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /**
     * 获取:数据创建时间
     */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }
    /**
     * 设置:数据修改时间
     */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /**
     * 获取:数据修改时间
     */
    public Timestamp getGmtModify() {
        return gmtModify;
    }
    /**
     * 设置:医疗机构ID
     */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }
    /**
     * 获取:医疗机构ID
     */
    public Integer getHospitalId() {
        return hospitalId;
    }
    /**
     * 设置:用户组ID
     */
    public void setGroupId(Integer value) {
        this.groupId = value;
    }
    /**
     * 获取:用户组ID
     */
    public Integer getGroupId() {
        return groupId;
    }
    /**
     * 设置:菜单ID
     */
    public void setMenuId(Integer value) {
        this.menuId = value;
    }
    /**
     * 获取:菜单ID
     */
    public Integer getMenuId() {
        return menuId;
    }
}