package com.buit.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/**
* @ClassName: FileUploadConfig
* @Description: 消息推送配置类
* @author 神算子
* @date 2020年9月4日14:46:14
 */
@Component
@ConfigurationProperties("his.ws")
public class SendNoticeConfig {
	/** 系统消息提醒 */
	public  String getAllMess;
	/** 字典变更消息 */
	public  String getAllDic ;
	public String getGetAllMess() {
		return getAllMess;
	}
	public void setGetAllMess(String getAllMess) {
		this.getAllMess = getAllMess;
	}
	public String getGetAllDic() {
		return getAllDic;
	}
	public void setGetAllDic(String getAllDic) {
		this.getAllDic = getAllDic;
	}
}
