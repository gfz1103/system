package com.buit.his.user.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;

/**
 * 类名称：SysUserDept<br> 
 * 类描述：系统用户授权科室<br>
 * @author
 */
@ApiModel(value="系统用户授权科室")
public class SysUserDept  extends  PageQuery{
	//@ApiModelProperty(value="用户授权科室数据ID")
    /** 用户授权科室数据ID */
    private Integer userdeptId;
	//@ApiModelProperty(value="数据版本")
    /** 数据版本 */
    private Integer dataVersion;
	//@ApiModelProperty(value="数据创建时间")
    /** 数据创建时间 */
    private Timestamp gmtCreate;
	//@ApiModelProperty(value="数据修改时间")
    /** 数据修改时间 */
    private Timestamp gmtModify;
	//@ApiModelProperty(value="医疗机构ID")
    /** 医疗机构ID */
    private Integer hospitalId;
	//@ApiModelProperty(value="用户代码")
    /** 用户代码 */
    private Integer userId;
	//@ApiModelProperty(value="科室代码")
    /** 科室代码 */
    private Integer deptId;
	//@ApiModelProperty(value="是否为默认科室FD000054")
    /** 是否为默认科室FD000054 */
    private String defaultFlag;

    /** 设置:用户授权科室数据ID  */
    public void setUserdeptId(Integer value) {
        this.userdeptId = value;
    }
    /** 获取:用户授权科室数据ID */
    public Integer getUserdeptId() {
        return userdeptId;
    }

    /** 设置:数据版本  */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /** 获取:数据版本 */
    public Integer getDataVersion() {
        return dataVersion;
    }

    /** 设置:数据创建时间  */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /** 获取:数据创建时间 */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /** 设置:数据修改时间  */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /** 获取:数据修改时间 */
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

    /** 设置:用户代码  */
    public void setUserId(Integer value) {
        this.userId = value;
    }
    /** 获取:用户代码 */
    public Integer getUserId() {
        return userId;
    }

    /** 设置:科室代码  */
    public void setDeptId(Integer value) {
        this.deptId = value;
    }
    /** 获取:科室代码 */
    public Integer getDeptId() {
        return deptId;
    }

    /** 设置:是否为默认科室FD000054  */
    public void setDefaultFlag(String value) {
        this.defaultFlag = value;
    }
    /** 获取:是否为默认科室FD000054 */
    public String getDefaultFlag() {
        return defaultFlag;
    }


}