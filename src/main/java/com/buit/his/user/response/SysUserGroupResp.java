//   
//package com.buit.his.user.response;
//
//import java.sql.Timestamp;
//
//import com.buit.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：SysUserGroup<br> 
// * 类描述：系统用户与用户组对照表<br>
// */
//@ApiModel(value="系统用户与用户组对照表")
//public class SysUserGroupResp  extends  PageQuery{
//    @ApiModelProperty(value="对照数据ID")
//    private Integer usergroupId;
//    @ApiModelProperty(value="数据版本")
//    private Integer dataVersion;
//    @ApiModelProperty(value="数据创建时间")
//    private Timestamp gmtCreate;
//    @ApiModelProperty(value="数据修改时间")
//    private Timestamp gmtModify;
//    @ApiModelProperty(value="医疗机构ID")
//    private Integer hospitalId;
//    @ApiModelProperty(value="用户组ID")
//    private Integer groupId;
//    @ApiModelProperty(value="用户ID")
//    private Integer userId;
//    @ApiModelProperty(value="序号")
//    private Integer serialNumber;
//    /**
//     * 设置:对照数据ID
//     */
//    public void setUsergroupId(Integer value) {
//        this.usergroupId = value;
//    }
//    /**
//     * 获取:对照数据ID
//     */
//    public Integer getUsergroupId() {
//        return usergroupId;
//    }
//    /**
//     * 设置:数据版本
//     */
//    public void setDataVersion(Integer value) {
//        this.dataVersion = value;
//    }
//    /**
//     * 获取:数据版本
//     */
//    public Integer getDataVersion() {
//        return dataVersion;
//    }
//    /**
//     * 设置:数据创建时间
//     */
//    public void setGmtCreate(Timestamp value) {
//        this.gmtCreate = value;
//    }
//    /**
//     * 获取:数据创建时间
//     */
//    public Timestamp getGmtCreate() {
//        return gmtCreate;
//    }
//    /**
//     * 设置:数据修改时间
//     */
//    public void setGmtModify(Timestamp value) {
//        this.gmtModify = value;
//    }
//    /**
//     * 获取:数据修改时间
//     */
//    public Timestamp getGmtModify() {
//        return gmtModify;
//    }
//    /**
//     * 设置:医疗机构ID
//     */
//    public void setHospitalId(Integer value) {
//        this.hospitalId = value;
//    }
//    /**
//     * 获取:医疗机构ID
//     */
//    public Integer getHospitalId() {
//        return hospitalId;
//    }
//    /**
//     * 设置:用户组ID
//     */
//    public void setGroupId(Integer value) {
//        this.groupId = value;
//    }
//    /**
//     * 获取:用户组ID
//     */
//    public Integer getGroupId() {
//        return groupId;
//    }
//    /**
//     * 设置:用户ID
//     */
//    public void setUserId(Integer value) {
//        this.userId = value;
//    }
//    /**
//     * 获取:用户ID
//     */
//    public Integer getUserId() {
//        return userId;
//    }
//    /**
//     * 设置:序号
//     */
//    public void setSerialNumber(Integer value) {
//        this.serialNumber = value;
//    }
//    /**
//     * 获取:序号
//     */
//    public Integer getSerialNumber() {
//        return serialNumber;
//    }
//}