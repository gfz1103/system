package com.buit.his.sys.adminms.model;

import java.sql.Timestamp;

import com.buit.commons.PageQuery;

/**
 * 类名称：QueCxfbcz<br> 
 * 类描述：单表增删改查操作发布
 * @author 神算子 
 * @ApiModel(value="单表增删改查操作发布")
 */
public class QueCxfbcz  extends  PageQuery{
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
	//@ApiModelProperty(value="table_def表主键")
    /** table_def表主键 */
    private Integer tableId;
	//@ApiModelProperty(value="query对象json")
    /** query对象json */
    private String tableJson;
	//@ApiModelProperty(value="查询SQL")
    /** 查询SQL */
    private String selectSql;
	//@ApiModelProperty(value="更新SQL")
    /** 更新SQL */
    private String updateSql;
	//@ApiModelProperty(value="插入SQL")
    /** 插入SQL */
    private String insertsql;
	//@ApiModelProperty(value="删除SQL")
    /** 删除SQL */
    private String deletesql;
	//@ApiModelProperty(value="命名空间")
    /** 命名空间 */
    private String nameSpace;
	//@ApiModelProperty(value="0:启用,1:停用")
    /** 0:启用,1:停用 */
    private Integer tableStop;

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

    /** 设置:table_def表主键  */
    public void setTableId(Integer value) {
        this.tableId = value;
    }
    /** 获取:table_def表主键 */
    public Integer getTableId() {
        return tableId;
    }

    /** 设置:query对象json  */
    public void setTableJson(String value) {
        this.tableJson = value;
    }
    /** 获取:query对象json */
    public String getTableJson() {
        return tableJson;
    }

    /** 设置:查询SQL  */
    public void setSelectSql(String value) {
        this.selectSql = value;
    }
    /** 获取:查询SQL */
    public String getSelectSql() {
        return selectSql;
    }

    /** 设置:更新SQL  */
    public void setUpdateSql(String value) {
        this.updateSql = value;
    }
    /** 获取:更新SQL */
    public String getUpdateSql() {
        return updateSql;
    }

    /** 设置:插入SQL  */
    public void setInsertsql(String value) {
        this.insertsql = value;
    }
    /** 获取:插入SQL */
    public String getInsertsql() {
        return insertsql;
    }

    /** 设置:删除SQL  */
    public void setDeletesql(String value) {
        this.deletesql = value;
    }
    /** 获取:删除SQL */
    public String getDeletesql() {
        return deletesql;
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
    public void setTableStop(Integer value) {
        this.tableStop = value;
    }
    /** 获取:0:启用,1:停用 */
    public Integer getTableStop() {
        return tableStop;
    }


}
