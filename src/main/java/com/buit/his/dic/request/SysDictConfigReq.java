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
// * 类名称：SysDictConfig<br> 
// * 类描述：字典配置<br>
// */
//@ApiModel(value="字典配置")
//public class SysDictConfigReq  extends  PageQuery{
//    @ApiModelProperty(value="诊断数据ID")
//    private Integer dictId;
//    @ApiModelProperty(value="数据版本")
//    private Integer dataVersion;
//    @ApiModelProperty(value="数据创建时间")
//    private Timestamp gmtCreate;
//    @ApiModelProperty(value="数据修改时间")
//    private Timestamp gmtModify;
//    @ApiModelProperty(value="医疗机构ID")
//    private Integer hospitalId;
//    @ApiModelProperty(value="字典编码")
//    private String dictCode;
//    @ApiModelProperty(value="拼音码")
//    private String pySql;
//    @ApiModelProperty(value="五笔码")
//    private String wbSql;
//    @ApiModelProperty(value="缓存")
//    private String cached;
//    /**
//     * 设置:诊断数据ID
//     */
//    public void setDictId(Integer value) {
//        this.dictId = value;
//    }
//    /**
//     * 获取:诊断数据ID
//     */
//    public Integer getDictId() {
//        return dictId;
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
//     * 设置:字典编码
//     */
//    public void setDictCode(String value) {
//        this.dictCode = value;
//    }
//    /**
//     * 获取:字典编码
//     */
//    public String getDictCode() {
//        return dictCode;
//    }
//    /**
//     * 设置:拼音码
//     */
//    public void setPySql(String value) {
//        this.pySql = value;
//    }
//    /**
//     * 获取:拼音码
//     */
//    public String getPySql() {
//        return pySql;
//    }
//    /**
//     * 设置:五笔码
//     */
//    public void setWbSql(String value) {
//        this.wbSql = value;
//    }
//    /**
//     * 获取:五笔码
//     */
//    public String getWbSql() {
//        return wbSql;
//    }
//    /**
//     * 设置:缓存
//     */
//    public void setCached(String value) {
//        this.cached = value;
//    }
//    /**
//     * 获取:缓存
//     */
//    public String getCached() {
//        return cached;
//    }
//}