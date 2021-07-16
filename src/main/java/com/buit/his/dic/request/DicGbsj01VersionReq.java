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
// * 类名称：DicGbsj01Version<br> 
// * 类描述：标准数据版本记录<br>
// */
//@ApiModel(value="标准数据版本记录")
//public class DicGbsj01VersionReq  extends  PageQuery{
//    @ApiModelProperty(value="版本数据ID")
//    private Integer dataversionId;
//    @ApiModelProperty(value="数据版本")
//    private Integer dataVersion;
//    @ApiModelProperty(value="数据创建时间")
//    private Timestamp gmtCreate;
//    @ApiModelProperty(value="数据修改时间")
//    private Timestamp gmtModify;
//    @ApiModelProperty(value="医疗机构ID")
//    private Integer hospitalId;
//    @ApiModelProperty(value="标准数据ID")
//    private Integer primarydataId;
//    @ApiModelProperty(value="标准数据版本号")
//    private String primaryDataVersion;
//    @ApiModelProperty(value="版本生效日期")
//    private Timestamp beginDate;
//    @ApiModelProperty(value="版本失效日期")
//    private Timestamp endDate;
//    /**
//     * 设置:版本数据ID
//     */
//    public void setDataversionId(Integer value) {
//        this.dataversionId = value;
//    }
//    /**
//     * 获取:版本数据ID
//     */
//    public Integer getDataversionId() {
//        return dataversionId;
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
//     * 设置:标准数据ID
//     */
//    public void setPrimarydataId(Integer value) {
//        this.primarydataId = value;
//    }
//    /**
//     * 获取:标准数据ID
//     */
//    public Integer getPrimarydataId() {
//        return primarydataId;
//    }
//    /**
//     * 设置:标准数据版本号
//     */
//    public void setPrimaryDataVersion(String value) {
//        this.primaryDataVersion = value;
//    }
//    /**
//     * 获取:标准数据版本号
//     */
//    public String getPrimaryDataVersion() {
//        return primaryDataVersion;
//    }
//    /**
//     * 设置:版本生效日期
//     */
//    public void setBeginDate(Timestamp value) {
//        this.beginDate = value;
//    }
//    /**
//     * 获取:版本生效日期
//     */
//    public Timestamp getBeginDate() {
//        return beginDate;
//    }
//    /**
//     * 设置:版本失效日期
//     */
//    public void setEndDate(Timestamp value) {
//        this.endDate = value;
//    }
//    /**
//     * 获取:版本失效日期
//     */
//    public Timestamp getEndDate() {
//        return endDate;
//    }
//}
