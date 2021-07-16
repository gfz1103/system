   
package com.buit.his.sys.centermaintenance.response;


import java.util.List;

import com.buit.his.sys.centermaintenance.model.FeeXmfytj01;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：GyFytjResp<br> 
 * 类描述：<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_费用调价")
public class GyFytjResp  {
    
	@ApiModelProperty(value="调价表单数据")
	FeeXmfytj01 feeXmfytj01;
	
	@ApiModelProperty(value="调价项目集合")
	List<FeeXmfytj02Resp> feeXmfytj02RespList;

	public FeeXmfytj01 getFeeXmfytj01() {
		return feeXmfytj01;
	}

	public void setFeeXmfytj01(FeeXmfytj01 feeXmfytj01) {
		this.feeXmfytj01 = feeXmfytj01;
	}

	public List<FeeXmfytj02Resp> getFeeXmfytj02RespList() {
		return feeXmfytj02RespList;
	}

	public void setFeeXmfytj02RespList(List<FeeXmfytj02Resp> feeXmfytj02RespList) {
		this.feeXmfytj02RespList = feeXmfytj02RespList;
	}
	
	
}
