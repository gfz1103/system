   
package com.buit.his.sys.centermaintenance.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：DicSfxmlbYlReq<br> 
 * 类描述：公用_收费项目<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用_收费项目_ylReq")
public class DicSfxmlbYlReq {
    @ApiModelProperty(value="收费项目")
    private Integer sfxm;
    
    @ApiModelProperty(value="收费名称")
    private String sfmc;

    @ApiModelProperty(value="排列顺序")
    private String plsx;

    @ApiModelProperty(value="门诊排列序号")
    private String mzpl;
    
    @ApiModelProperty(value="住院排列序号")
    private String zypl;
    
    @ApiModelProperty(value="药品账簿类别,1是0否")
    private String zblb;
    
    @ApiModelProperty(value="保存方式")
    private String opStatus;

	public Integer getSfxm() {
		return sfxm;
	}

	public void setSfxm(Integer sfxm) {
		this.sfxm = sfxm;
	}

	public String getSfmc() {
		return sfmc;
	}

	public void setSfmc(String sfmc) {
		this.sfmc = sfmc;
	}

	public String getPlsx() {
		return plsx;
	}

	public void setPlsx(String plsx) {
		this.plsx = plsx;
	}

	public String getMzpl() {
		return mzpl;
	}

	public void setMzpl(String mzpl) {
		this.mzpl = mzpl;
	}

	public String getZypl() {
		return zypl;
	}

	public void setZypl(String zypl) {
		this.zypl = zypl;
	}

	public String getZblb() {
		return zblb;
	}

	public void setZblb(String zblb) {
		this.zblb = zblb;
	}

	public String getOpStatus() {
		return opStatus;
	}

	public void setOpStatus(String opStatus) {
		this.opStatus = opStatus;
	}

   
}
