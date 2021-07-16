package com.buit.his.user.model;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.annotations.ApiModelProperty;

/**
 * 类名称：DicYwlb<br> 
 * 类描述：业务类别表
 * @author WENGL 
 * @ApiModel(value="业务类别表")
 */
public class DicYwlb  {
	@ApiModelProperty(value="主键")
    private Integer btId;
	@ApiModelProperty(value="业务编码")
    private String btCode;
	@ApiModelProperty(value="业务名称")
    private String btName;
	@ApiModelProperty(value="业务表名")
    private String btTableName;
	@ApiModelProperty(value="筛选条件")
    private int btWhere;
	@ApiModelProperty(value="动态SQL",hidden = true)
	@JsonIgnore
    private String btSql;
	@ApiModelProperty(value="医疗机构ID",hidden = true)
	@JsonIgnore
    private Integer hospitaId;
	@ApiModelProperty(value="创建时间",hidden = true)
	@JsonIgnore
    private Timestamp gmtCreate;
	@ApiModelProperty(value="修改时间",hidden = true)
	@JsonIgnore
    private Timestamp gmtModify;

    /** 设置:主键  */
    public void setBtId(Integer value) {
        this.btId = value;
    }
    /** 获取:主键 */
    public Integer getBtId() {
        return btId;
    }

    /** 设置:业务编码  */
    public void setBtCode(String value) {
        this.btCode = value;
    }
    /** 获取:业务编码 */
    public String getBtCode() {
        return btCode;
    }

    /** 设置:业务名称  */
    public void setBtName(String value) {
        this.btName = value;
    }
    /** 获取:业务名称 */
    public String getBtName() {
        return btName;
    }

    /** 设置:业务表名  */
    public void setBtTableName(String value) {
        this.btTableName = value;
    }
    /** 获取:业务表名 */
    public String getBtTableName() {
        return btTableName;
    }

    /** 设置:筛选条件1  */
    public void setBtWhere(int value) {
        this.btWhere = value;
    }
    /** 获取:筛选条件1 */
    public int getBtWhere() {
        return btWhere;
    }

    /** 设置:动态SQL  */
    public void setBtSql(String value) {
        this.btSql = value;
    }
    /** 获取:动态SQL */
    public String getBtSql() {
        return btSql;
    }
    /** 设置:医疗机构ID  */
    public void setHospitaId(Integer value) {
        this.hospitaId = value;
    }
    /** 获取:医疗机构ID */
    public Integer getHospitaId() {
        return hospitaId;
    }
    /** 设置:创建时间  */
    public void setGmtCreate(Timestamp value) {
        this.gmtCreate = value;
    }
    /** 获取:创建时间 */
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    /** 设置:修改时间  */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /** 获取:修改时间 */
    public Timestamp getGmtModify() {
        return gmtModify;
    }

}
