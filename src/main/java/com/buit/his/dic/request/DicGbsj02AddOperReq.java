
package com.buit.his.dic.request;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj02<br>
 * 类描述：标准数据值域记录<br>
 * @author 老花生
 */
@ApiModel(value="标准数据值域记录新增手术")
public class DicGbsj02AddOperReq{
	@ApiModelProperty(value="序号")
    private Integer serialNumber;
	@NotBlank(message = "ICD-9-CM3不能为空")
	@ApiModelProperty(value="ICD-9-CM3")
    private String dataValue;
	@NotBlank(message = "手术操作名称不能为空")
	@ApiModelProperty(value="手术操作名称")
    private String dataValueRemark;
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getDataValue() {
		return dataValue;
	}
	public void setDataValue(String dataValue) {
		this.dataValue = dataValue;
	}
	public String getDataValueRemark() {
		return dataValueRemark;
	}
	public void setDataValueRemark(String dataValueRemark) {
		this.dataValueRemark = dataValueRemark;
	}
}
