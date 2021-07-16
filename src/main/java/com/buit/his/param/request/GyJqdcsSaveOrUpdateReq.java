
package com.buit.his.param.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 类名称：GyJqdcsSaveOrUpdateReq<br>
 * 类描述：客户端参数新增或修改<br>
 * @author GONGFANGZHOU
 */
@ApiModel(value="客户端参数新增或修改_saveorupdateReq")
public class GyJqdcsSaveOrUpdateReq {
	@ApiModelProperty(value="机构", hidden = true)
    /** 机构 */
    private Integer jgid;
	@ApiModelProperty(value="IP")
    /** IP */
    private String ip;
	@ApiModelProperty(value="参数名")
    /** 参数名 */
    private String csm;
	@ApiModelProperty(value="参数值")
    /** 参数值 */
    private String csz;
	@ApiModelProperty(value="备注")
    /** 备注 */
    private String bz;
	@ApiModelProperty(value="是否启用")
    /** 是否启用 */
    private String sfqy;
	@ApiModelProperty(value="所属类别")
    /** 所属类别 */
    private String sslb;

    /** 设置:机构  */
    public void setJgid(Integer value) {
        this.jgid = value;
    }
    /** 获取:机构 */
    public Integer getJgid() {
        return jgid;
    }

    /** 设置:IP  */
    public void setIp(String value) {
        this.ip = value;
    }
    /** 获取:IP */
    public String getIp() {
        return ip;
    }

    /** 设置:参数名  */
    public void setCsm(String value) {
        this.csm = value;
    }
    /** 获取:参数名 */
    public String getCsm() {
        return csm;
    }

    /** 设置:参数值  */
    public void setCsz(String value) {
        this.csz = value;
    }
    /** 获取:参数值 */
    public String getCsz() {
        return csz;
    }

    /** 设置:备注  */
    public void setBz(String value) {
        this.bz = value;
    }
    /** 获取:备注 */
    public String getBz() {
        return bz;
    }

    /** 设置:是否启用  */
    public void setSfqy(String value) {
        this.sfqy = value;
    }
    /** 获取:是否启用 */
    public String getSfqy() {
        return sfqy;
    }

    /** 设置:所属类别  */
    public void setSslb(String value) {
        this.sslb = value;
    }
    /** 获取:所属类别 */
    public String getSslb() {
        return sslb;
    }
}