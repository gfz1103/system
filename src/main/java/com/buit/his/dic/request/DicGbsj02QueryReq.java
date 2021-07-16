   
package com.buit.his.dic.request;

import javax.validation.constraints.NotBlank;

import com.buit.commons.PageQuery;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj02<br> 
 * 类描述：标准数据值域记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据值域记录")
public class DicGbsj02QueryReq  extends  PageQuery{
	@NotBlank(message = "标准数据代码不能为空")
    @ApiModelProperty(value="标准数据代码")
    private String primaryDataCode;
    @ApiModelProperty(value="查询码")
    private String queryCode;
    
	public String getPrimaryDataCode() {
		return primaryDataCode;
	}
	public void setPrimaryDataCode(String primaryDataCode) {
		this.primaryDataCode = primaryDataCode;
	}
	public String getQueryCode() {
		return queryCode;
	}
	public void setQueryCode(String queryCode) {
		this.queryCode = queryCode;
	}
}
