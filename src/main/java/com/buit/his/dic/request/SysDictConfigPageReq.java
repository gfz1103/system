package com.buit.his.dic.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysDictConfig<br>
 * 类描述：字典配置<br>
 * @author All
 */
@ApiModel(value="字典配置")
public class SysDictConfigPageReq extends PageQuery {

    @ApiModelProperty(value="字典编码")
    private String dictCode;

    public String getDictCode() {
        return dictCode;
    }

    public void setDictCode(String dictCode) {
        this.dictCode = dictCode;
    }
}