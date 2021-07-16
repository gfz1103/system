package com.buit.his.dic.model;

import com.buit.commons.PageQuery;
import io.swagger.annotations.ApiModel;

import java.sql.Timestamp;

/**
 * 类名称：SysDictConfig<br> 
 * 类描述：字典配置<br>
 * @author All
 */
@ApiModel(value="字典配置")
public class SysDictConfig  extends  PageQuery{
	//@ApiModelProperty(value="诊断数据ID")
    /** 诊断数据ID */
    private Integer dictId;
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
	//@ApiModelProperty(value="字典编码")
    /** 字典编码 */
    private String dictCode;
	//@ApiModelProperty(value="查询SQL")
    /** 查询SQL */
    private String querySql;
	//@ApiModelProperty(value="五笔码")
    /** 五笔码 */
    private String wbSql;
	//@ApiModelProperty(value="缓存")
    /** 缓存 */
    private String cached;
	//@ApiModelProperty(value="停用标识 0 启用 1 停用")
    /** 停用标识 0 启用 1 停用 */
    private String stopFlag;

    /** 设置:诊断数据ID  */
    public void setDictId(Integer value) {
        this.dictId = value;
    }
    /** 获取:诊断数据ID */
    public Integer getDictId() {
        return dictId;
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

    /** 设置:字典编码  */
    public void setDictCode(String value) {
        this.dictCode = value;
    }
    /** 获取:字典编码 */
    public String getDictCode() {
        return dictCode;
    }
    public String getQuerySql() {
		return querySql;
	}
	public void setQuerySql(String querySql) {
		this.querySql = querySql;
	}
	/** 设置:五笔码  */
    public void setWbSql(String value) {
        this.wbSql = value;
    }
    /** 获取:五笔码 */
    public String getWbSql() {
        return wbSql;
    }

    /** 设置:缓存  */
    public void setCached(String value) {
        this.cached = value;
    }
    /** 获取:缓存 */
    public String getCached() {
        return cached;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}