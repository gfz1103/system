   
package com.buit.his.user.response;

import java.util.List;

import com.buit.commons.SysUser;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * 登陆请求返回对象
 * @author All
 */
@ApiModel(value="登陆请求返回对象")
public class LoginResp  {
    @ApiModelProperty(value="token")
    private String token;
    @ApiModelProperty(value="医院列表")
    private List<HospitaDicResp>  hospitas;
    @ApiModelProperty(value="用户信息")
    private SysUser sysuser;
    
	public SysUser getSysuser() {
		return sysuser;
	}
	public void setSysuser(SysUser sysuser) {
		this.sysuser = sysuser;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public List<HospitaDicResp> getHospitas() {
		return hospitas;
	}
	public void setHospitas(List<HospitaDicResp> hospitas) {
		this.hospitas = hospitas;
	}
}