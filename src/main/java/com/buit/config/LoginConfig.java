package com.buit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
 * 登录配置
 * @author 神算子
 */
@Component 
@ConfigurationProperties("buit.login") 
public class LoginConfig {
	 private Integer errorTime;//errorTime分钟内输入errorNumber次错误密码.锁定用户
	 private Integer errorNumber;//密码输入错误上线
	 private Integer lockTime;//用户锁定时间
	 private Integer tokenInvalidTime;//token失效时间
	public Integer getErrorTime() {
		return errorTime;
	}
	public void setErrorTime(Integer errorTime) {
		this.errorTime = errorTime;
	}
	public Integer getErrorNumber() {
		return errorNumber;
	}
	public void setErrorNumber(Integer errorNumber) {
		this.errorNumber = errorNumber;
	}
	public Integer getLockTime() {
		return lockTime;
	}
	public void setLockTime(Integer lockTime) {
		this.lockTime = lockTime;
	}
	public Integer getTokenInvalidTime() {
		return tokenInvalidTime;
	}
	public void setTokenInvalidTime(Integer tokenInvalidTime) {
		this.tokenInvalidTime = tokenInvalidTime;
	}

}
