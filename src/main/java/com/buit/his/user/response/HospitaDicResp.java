package com.buit.his.user.response;
   

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicYljg<br> 
 * 类描述：医疗卫生机构<br>
 * @author 老花生
 */
@ApiModel(value="医疗卫生机构")
public class HospitaDicResp {
    @ApiModelProperty(value="ID")
    private Integer hospitalId;
    @ApiModelProperty(value="医疗机构名称")
    private String hospitalName;
    
	public Integer getHospitalId() {
		return hospitalId;
	}
	public void setHospitalId(Integer hospitalId) {
		this.hospitalId = hospitalId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
}
