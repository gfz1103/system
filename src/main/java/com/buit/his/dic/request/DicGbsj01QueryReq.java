
package com.buit.his.dic.request;


import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj01<br>
 * 类描述：标准数据主记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据主记录")
public class DicGbsj01QueryReq extends  PageQuery {
    @ApiModelProperty(value = "首字母拼音或汉字或区间编码或五笔码")
    private String condition;

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }
}
