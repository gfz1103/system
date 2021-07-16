package com.buit.his.sys.adminms.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：QueCxfb<br> 
 * 类描述：查询发布
 * @author 神算子 
 * @ApiModel(value="查询发布")
 */
public class QueCxfb  extends  PageQuery{
	//@ApiModelProperty(value="发布表主键")
    /** 发布表主键 */
    private Integer publishId;
	//@ApiModelProperty(value="英文名")
    /** 英文名 */
    private String enName;
	//@ApiModelProperty(value="design_query表版本号")
    /** design_query表版本号 */
    private Integer dataVersion;
	//@ApiModelProperty(value="创建时间")
    /** 创建时间 */
    private Timestamp gmtCreate;
	//@ApiModelProperty(value="修改时间")
    /** 修改时间 */
    private Timestamp gmtModify;
	//@ApiModelProperty(value="design_query表主键")
    /** design_query表主键 */
    private Integer queryId;
	//@ApiModelProperty(value="query对象json")
    /** query对象json */
    private String queryJson;
	//@ApiModelProperty(value="查询SQL")
    /** 查询SQL */
    private String selectSql;
	//@ApiModelProperty(value="命名空间")
    /** 命名空间 */
    private String nameSpace;
	//@ApiModelProperty(value="0:启用,1:停用")
    /** 0:启用,1:停用 */
    private Integer queryStop;

    /** 设置:发布表主键  */
    public void setPublishId(Integer value) {
        this.publishId = value;
    }
    /** 获取:发布表主键 */
    public Integer getPublishId() {
        return publishId;
    }

    /** 设置:英文名  */
    public void setEnName(String value) {
        this.enName = value;
    }
    /** 获取:英文名 */
    public String getEnName() {
        return enName;
    }

    /** 设置:design_query表版本号  */
    public void setDataVersion(Integer value) {
        this.dataVersion = value;
    }
    /** 获取:design_query表版本号 */
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

    /** 设置:修改时间  */
    public void setGmtModify(Timestamp value) {
        this.gmtModify = value;
    }
    /** 获取:修改时间 */
    public Timestamp getGmtModify() {
        return gmtModify;
    }

    /** 设置:design_query表主键  */
    public void setQueryId(Integer value) {
        this.queryId = value;
    }
    /** 获取:design_query表主键 */
    public Integer getQueryId() {
        return queryId;
    }

    /** 设置:query对象json  */
    public void setQueryJson(String value) {
        this.queryJson = value;
    }
    /** 获取:query对象json */
    public String getQueryJson() {
        return queryJson;
    }

    /** 设置:查询SQL  */
    public void setSelectSql(String value) {
        this.selectSql = value;
    }
    /** 获取:查询SQL */
    public String getSelectSql() {
        return selectSql;
    }

    /** 设置:命名空间  */
    public void setNameSpace(String value) {
        this.nameSpace = value;
    }
    /** 获取:命名空间 */
    public String getNameSpace() {
        return nameSpace;
    }

    /** 设置:0:启用,1:停用  */
    public void setQueryStop(Integer value) {
        this.queryStop = value;
    }
    /** 获取:0:启用,1:停用 */
    public Integer getQueryStop() {
        return queryStop;
    }


}
