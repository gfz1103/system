package com.buit.his.dic.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.buit.config.SendNoticeConfig;


/**
* @ClassName: UpdateWebDbSer
* @Description: 更新前台字典服务
* @author 神算子
* @date 2020年9月4日14:46:14
 */
@Service
public class UpdateWebDbSer  {
    
    static final Logger logger = LoggerFactory.getLogger(UpdateWebDbSer.class);
    
    @Autowired
	private RestTemplate restTemplate;
    @Autowired
	private SendNoticeConfig sendNoticeConfig;
    
   
    
	/**
	 * 通知前台取最新的字典
	 * 
	 */
    public void updateWebDb() {
    	try {
    		ResponseEntity<String> ret=	restTemplate.postForEntity(sendNoticeConfig.getGetAllDic(),null,String.class);
		} catch (Exception e) {
			logger.error("update webData Error");
		}
    	
    }
}
