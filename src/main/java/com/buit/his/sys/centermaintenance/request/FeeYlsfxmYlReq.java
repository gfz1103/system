
package com.buit.his.sys.centermaintenance.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：FeeYlsfxmYlReq<br>
 * 类描述：公用_医疗收费_明细<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_医疗收费_ylReq")
public class FeeYlsfxmYlReq {

	@ApiModelProperty(value="费用归并")
	private Integer fygb;
	
	@ApiModelProperty(value="医保编码")
	private String ybbm;
	
	@ApiModelProperty(value="费用名称")
	private String fymc;
	
	@ApiModelProperty(value="作废判别")
	private Integer zfpb;
	
	@ApiModelProperty(value="拼音代码")
	private String pydm;

	public Integer getFygb() {
		return fygb;
	}

	public void setFygb(Integer fygb) {
		this.fygb = fygb;
	}

	public String getYbbm() {
		return ybbm;
	}

	public void setYbbm(String ybbm) {
		this.ybbm = ybbm;
	}

	public String getFymc() {
		return fymc;
	}

	public void setFymc(String fymc) {
		this.fymc = fymc;
	}

	public Integer getZfpb() {
		return zfpb;
	}

	public void setZfpb(Integer zfpb) {
		this.zfpb = zfpb;
	}

	public String getPydm() {
		return pydm;
	}

	public void setPydm(String pydm) {
		this.pydm = pydm;
	}


}
