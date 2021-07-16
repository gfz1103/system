package com.buit.his.dic.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysDictConfig<br>
 * 类描述：字典配置<br>
 * @author All
 */
@ApiModel(value="字典配置")
public class SysDictConfigPageResp {
    @ApiModelProperty(value="诊断数据ID")
    private Integer dictId;
    @ApiModelProperty(value="字典编码")
    private String dictCode;
    @ApiModelProperty(value="查询SQL")
    private String querySql;
    @ApiModelProperty(value="停用标识 0 启用 1 停用")
    private String stopFlag;


    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }

    public String getQuerySql() {
        return querySql;
    }

    public void setQuerySql(String querySql) {
        this.querySql = querySql;
    }

    public String getStopFlag() {
        return stopFlag;
    }

    public void setStopFlag(String stopFlag) {
        this.stopFlag = stopFlag;
    }
}