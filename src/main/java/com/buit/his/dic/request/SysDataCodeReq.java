//   
//package com.buit.his.dic.request;
//
//import java.sql.Timestamp;
//
//import com.buit.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：SysDataCode<br> 
// * 类描述：系统数据代码表<br>
// */
//@ApiModel(value="系统数据代码表")
//public class SysDataCodeReq  extends  PageQuery{
//    @ApiModelProperty(value="数据代码ID")
//    private Integer datacodeId;
//    @ApiModelProperty(value="数据版本")
//    private Integer dataVersion;
//    @ApiModelProperty(value="数据创建时间")
//    private Timestamp gmtCreate;
//    @ApiModelProperty(value="数据修改时间")
//    private Timestamp gmtModify;
//    @ApiModelProperty(value="医疗机构ID")
//    private Integer hospitalId;
//    @ApiModelProperty(value="代码类型")
//    private String datacodeType;
//    @ApiModelProperty(value="当前代码")
//    private Integer datacodeNo;
//    @ApiModelProperty(value="当前长度")
//    private Integer datacodeLen;
//    @ApiModelProperty(value="当前前缀")
//    private String datacodeHead;
//    @ApiModelProperty(value="年份")
//    private String datacodeYear;
//    @ApiModelProperty(value="年份格式")
//    private String datacodeYearFormat;
//    @ApiModelProperty(value="自定义过程")
//    private String datacodeProduce;
//    /**
//     * 设置:数据代码ID
//     */
//    public void setDatacodeId(Integer value) {
//        this.datacodeId = value;
//    }
//    /**
//     * 获取:数据代码ID
//     */
//    public Integer getDatacodeId() {
//        return datacodeId;
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
//     * 设置:代码类型
//     */
//    public void setDatacodeType(String value) {
//        this.datacodeType = value;
//    }
//    /**
//     * 获取:代码类型
//     */
//    public String getDatacodeType() {
//        return datacodeType;
//    }
//    /**
//     * 设置:当前代码
//     */
//    public void setDatacodeNo(Integer value) {
//        this.datacodeNo = value;
//    }
//    /**
//     * 获取:当前代码
//     */
//    public Integer getDatacodeNo() {
//        return datacodeNo;
//    }
//    /**
//     * 设置:当前长度
//     */
//    public void setDatacodeLen(Integer value) {
//        this.datacodeLen = value;
//    }
//    /**
//     * 获取:当前长度
//     */
//    public Integer getDatacodeLen() {
//        return datacodeLen;
//    }
//    /**
//     * 设置:当前前缀
//     */
//    public void setDatacodeHead(String value) {
//        this.datacodeHead = value;
//    }
//    /**
//     * 获取:当前前缀
//     */
//    public String getDatacodeHead() {
//        return datacodeHead;
//    }
//    /**
//     * 设置:年份
//     */
//    public void setDatacodeYear(String value) {
//        this.datacodeYear = value;
//    }
//    /**
//     * 获取:年份
//     */
//    public String getDatacodeYear() {
//        return datacodeYear;
//    }
//    /**
//     * 设置:年份格式
//     */
//    public void setDatacodeYearFormat(String value) {
//        this.datacodeYearFormat = value;
//    }
//    /**
//     * 获取:年份格式
//     */
//    public String getDatacodeYearFormat() {
//        return datacodeYearFormat;
//    }
//    /**
//     * 设置:自定义过程
//     */
//    public void setDatacodeProduce(String value) {
//        this.datacodeProduce = value;
//    }
//    /**
//     * 获取:自定义过程
//     */
//    public String getDatacodeProduce() {
//        return datacodeProduce;
//    }
//}