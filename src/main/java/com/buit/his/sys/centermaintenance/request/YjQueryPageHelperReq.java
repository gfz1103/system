package com.buit.his.sys.centermaintenance.request;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @ClassName YjQueryPageHelperReq
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/7/16 20:47
 */
@ApiModel(value="医技全部查询（助手方式）-请求")
public class YjQueryPageHelperReq extends PageQuery {
	private static final long serialVersionUID = -6023650085791396477L;
	@ApiModelProperty(value="拼音代码")
    private Integer pydm;

    public Integer getPydm() {
        return pydm;
    }

    public void setPydm(Integer pydm) {
        this.pydm = pydm;
    }
}
