package com.buit.his.user.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;

/**
 * 类名称：SysUserMenu<br> 
 * 类描述：用户快捷菜单<br>
 * @author
 */
@ApiModel(value="用户快捷菜单")
public class SysUserMenu  extends  PageQuery{
	//@ApiModelProperty(value="数据ID")
    /** 数据ID */
    private Integer usermenuId;
	//@ApiModelProperty(value="版本号")
    /** 版本号 */
    private Integer dataVersion;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp gmtCreate;
	//@ApiModelProperty(value="最后更新时间")
    /** 最后更新时间 */
    private Timestamp gmtModify;
	//@ApiModelProperty(value="医疗机构ID")
    /** 医疗机构ID */
    private Integer hospitalId;
	//@ApiModelProperty(value="用户ID")
    /** 用户ID */
    private Integer userId;
    private Integer groupId;
	//@ApiModelProperty(value="菜单ID")
    /** 菜单ID */
    private Integer menuId;
	//@ApiModelProperty(value="序号")
    /** 序号 */
    private Integer serialNumber;
    
    public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	/** 设置:数据ID  */
    public void setUsermenuId(Integer value) {
        this.usermenuId = value;
    }
    /** 获取:数据ID */
    public Integer getUsermenuId() {
        return usermenuId;
    }

    /** 设置:版本号  */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /** 获取:版本号 */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /** 设置:创建时间  */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /** 获取:创建时间 */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /** 设置:最后更新时间  */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /** 获取:最后更新时间 */
    public Timestamp getGmtModify() {
        return gmtModify;
    }

    /** 设置:医疗机构ID  */
    public void setHospitalId(Integer value) {
        this.hospitalId = value;
    }
    /** 获取:医疗机构ID */
    public Integer getHospitalId() {
        return hospitalId;
    }

    /** 设置:用户ID  */
    public void setUserId(Integer value) {
        this.userId = value;
    }
    /** 获取:用户ID */
    public Integer getUserId() {
        return userId;
    }

    /** 设置:菜单ID  */
    public void setMenuId(Integer value) {
        this.menuId = value;
    }
    /** 获取:菜单ID */
    public Integer getMenuId() {
        return menuId;
    }

    /** 设置:序号  */
    public void setSerialNumber(Integer value) {
        this.serialNumber = value;
    }
    /** 获取:序号 */
    public Integer getSerialNumber() {
        return serialNumber;
    }


}