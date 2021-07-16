   
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicSfxmlbXmgbReq<br> 
 * 类描述：公用_收费项目项目归并<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_收费项目_xmgbReq")
public class DicSfxmlbXmgbReq {

    @ApiModelProperty(value="收费项目")
    private Integer sfxm;
    
    @ApiModelProperty(value="病案使用归并")
    private Integer basygb;

    @ApiModelProperty(value="费用类别")
    private Integer fylb;

    @ApiModelProperty(value="门诊归并")
    private Integer mzgb;
    
    @ApiModelProperty(value="住院归并")
    private Integer zygb;

	public Integer getSfxm() {
		return sfxm;
	}

	public void setSfxm(Integer sfxm) {
		this.sfxm = sfxm;
	}

	public Integer getBasygb() {
		return basygb;
	}

	public void setBasygb(Integer basygb) {
		this.basygb = basygb;
	}

	public Integer getFylb() {
		return fylb;
	}

	public void setFylb(Integer fylb) {
		this.fylb = fylb;
	}

	public Integer getMzgb() {
		return mzgb;
	}

	public void setMzgb(Integer mzgb) {
		this.mzgb = mzgb;
	}

	public Integer getZygb() {
		return zygb;
	}

	public void setZygb(Integer zygb) {
		this.zygb = zygb;
	}
   
}
