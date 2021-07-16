
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
@ApiModel(value="标准疾病诊断添加")
public class DicGbsj02AddReq {
	@NotNull(message = "字典ID不能为空")
	@ApiModelProperty(value="字典ID")
	private Integer primarydataId;
//	@ApiModelProperty(value="上级数据值ID")
//	private Integer parentDatavalueId;
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

	public Integer getPrimarydataId() {
		return primarydataId;
	}

	public void setPrimarydataId(Integer primarydataId) {
		this.primarydataId = primarydataId;
	}

//	public Integer getParentDatavalueId() {
//		return parentDatavalueId;
//	}
//
//	public void setParentDatavalueId(Integer parentDatavalueId) {
//		this.parentDatavalueId = parentDatavalueId;
//	}
}
