
package com.buit.his.dic.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicGbsj02<br>
 * 类描述：标准数据值域记录<br>
 * @author 老花生
 */
@ApiModel(value="标准疾病诊断编辑")
public class DicGbsj02EditReq {
	@NotNull(message = "数据值ID不能为空")
	@ApiModelProperty(value="数据值ID")
    private Integer datavalueId;
	@NotNull(message = "序号不能为空")
	@ApiModelProperty(value="序号")
    private Integer serialNumber;
	@NotBlank(message = "编码不能为空")
	@ApiModelProperty(value="编码")
	private String dataValue;
	@NotBlank(message = "名称不能为空")
	@ApiModelProperty(value="名称")
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
	public Integer getDatavalueId() {
		return datavalueId;
	}
	public void setDatavalueId(Integer datavalueId) {
		this.datavalueId = datavalueId;
	}
	
}
