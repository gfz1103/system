package com.buit.his.dic.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysDictConfig<br>
 * 类描述：字典配置<br>
 * @author All
 */
@ApiModel(value="字典配置编辑")
public class SysDictConfigEditReq{
    @NotNull(message = "ID不能为空")
    @ApiModelProperty(value="诊断数据ID")
    private Integer dictId;
    @NotBlank(message = "字典编码不能为空")
    @ApiModelProperty(value="字典编码")
    private String dictCode;
    @NotBlank(message = "查询SQL不能为空")
    @ApiModelProperty(value="查询SQL")
    private String querySql;


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
}