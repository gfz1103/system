//   
//package com.buit.his.dic.response;
//
//import java.sql.Timestamp;
//
//import com.buit.his.commons.PageQuery;
//import io.swagger.annotations.ApiModel;
//import io.swagger.annotations.ApiModelProperty;
//
//
///**
// * 类名称：SysFlagData<br> 
// * 类描述：标识数据主记录<br>
// */
//@ApiModel(value="标识数据主记录")
//public class SysFlagDataResp  extends  PageQuery{
//    @ApiModelProperty(value="标识数据ID")
//    private Integer flagdataId;
//    @ApiModelProperty(value="数据版本")
//    private Integer dataVersion;
//    @ApiModelProperty(value="数据创建时间")
//    private Timestamp gmtCreate;
//    @ApiModelProperty(value="数据修改时间")
//    private Timestamp gmtModify;
//    @ApiModelProperty(value="医疗机构ID")
//    private Integer hospitalId;
//    @ApiModelProperty(value="标识数据代码")
//    private String flagdataCode;
//    @ApiModelProperty(value="标识数据名称")
//    private String flagdataName;
//    @ApiModelProperty(value="值域代码")
//    private String rangeCode;
//    @ApiModelProperty(value="数据标准依据标识")
//    private String identificationFlag;
//    @ApiModelProperty(value="拼音码")
//    private String pyCode;
//    @ApiModelProperty(value="五笔码")
//    private String wbCode;
//    @ApiModelProperty(value="归类树节点的ID")
//    private Integer nodeId;
//    /**
//     * 设置:标识数据ID
//     */
//    public void setFlagdataId(Integer value) {
//        this.flagdataId = value;
//    }
//    /**
//     * 获取:标识数据ID
//     */
//    public Integer getFlagdataId() {
//        return flagdataId;
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
//     * 设置:标识数据代码
//     */
//    public void setFlagdataCode(String value) {
//        this.flagdataCode = value;
//    }
//    /**
//     * 获取:标识数据代码
//     */
//    public String getFlagdataCode() {
//        return flagdataCode;
//    }
//    /**
//     * 设置:标识数据名称
//     */
//    public void setFlagdataName(String value) {
//        this.flagdataName = value;
//    }
//    /**
//     * 获取:标识数据名称
//     */
//    public String getFlagdataName() {
//        return flagdataName;
//    }
//    /**
//     * 设置:值域代码
//     */
//    public void setRangeCode(String value) {
//        this.rangeCode = value;
//    }
//    /**
//     * 获取:值域代码
//     */
//    public String getRangeCode() {
//        return rangeCode;
//    }
//    /**
//     * 设置:数据标准依据标识
//     */
//    public void setIdentificationFlag(String value) {
//        this.identificationFlag = value;
//    }
//    /**
//     * 获取:数据标准依据标识
//     */
//    public String getIdentificationFlag() {
//        return identificationFlag;
//    }
//    /**
//     * 设置:拼音码
//     */
//    public void setPyCode(String value) {
//        this.pyCode = value;
//    }
//    /**
//     * 获取:拼音码
//     */
//    public String getPyCode() {
//        return pyCode;
//    }
//    /**
//     * 设置:五笔码
//     */
//    public void setWbCode(String value) {
//        this.wbCode = value;
//    }
//    /**
//     * 获取:五笔码
//     */
//    public String getWbCode() {
//        return wbCode;
//    }
//    /**
//     * 设置:归类树节点的ID
//     */
//    public void setNodeId(Integer value) {
//        this.nodeId = value;
//    }
//    /**
//     * 获取:归类树节点的ID
//     */
//    public Integer getNodeId() {
//        return nodeId;
//    }
//}