
package com.buit.his.param.request;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：SysXtcsSaveOrUpdateReq<br>
 * 类描述：公用系统参数新增或修改<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="公用系统参数新增或修改_saveorupdateReq")
public class SysXtcsSaveOrUpdateReq {
	@ApiModelProperty(value="机构编码", hidden = true)
    /** 机构编码 */
    private Integer jgid;
	@ApiModelProperty(value="参数名称")
    /** 参数名称 */
    private String csmc;
	@ApiModelProperty(value="参数值")
    /** 参数值 */
    private String csz;
	@ApiModelProperty(value="默认值")
    /** 默认值 */
    private String mrz;
	@ApiModelProperty(value="备注")
    /** 备注 */
    private String bz;
	@ApiModelProperty(value="xxsm")
    /** xxsm */
    private String xxsm;
	@ApiModelProperty(value="所属类别（用于参数归类）")
    /** 所属类别（用于参数归类） */
    private String sslb;
	@ApiModelProperty(value="系统识别")
    /** xtsb */
    private BigDecimal xtsb;

    /** 设置:机构编码  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构编码 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:参数名称  */
    public void setCsmc(String value) {
        this.csmc = value;
    }
    /** 获取:参数名称 */
    public String getCsmc() {
        return csmc;
    }

    /** 设置:参数值  */
    public void setCsz(String value) {
        this.csz = value;
    }
    /** 获取:参数值 */
    public String getCsz() {
        return csz;
    }

    /** 设置:默认值  */
    public void setMrz(String value) {
        this.mrz = value;
    }
    /** 获取:默认值 */
    public String getMrz() {
        return mrz;
    }

    /** 设置:备注  */
    public void setBz(String value) {
        this.bz = value;
    }
    /** 获取:备注 */
    public String getBz() {
        return bz;
    }

    /** 设置:xxsm  */
    public void setXxsm(String value) {
        this.xxsm = value;
    }
    /** 获取:xxsm */
    public String getXxsm() {
        return xxsm;
    }

    /** 设置:所属类别（用于参数归类）  */
    public void setSslb(String value) {
        this.sslb = value;
    }
    /** 获取:所属类别（用于参数归类） */
    public String getSslb() {
        return sslb;
    }

    /** 设置:xtsb  */
    public void setXtsb(BigDecimal value) {
        this.xtsb = value;
    }
    /** 获取:xtsb */
    public BigDecimal getXtsb() {
        return xtsb;
    }
}
