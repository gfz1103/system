
package com.buit.his.sys.msg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.constans.TableName;
import com.buit.his.sys.msg.model.MessJsjl;
import com.buit.his.sys.msg.service.MessJsjlSer;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 消息危急值接收记录<br>
 * @author GONGFANGZHOU
 */
@Api(tags="消息危急值接收记录")
@Controller
@RequestMapping("/messjsjl")
public class MessJsjlCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MessJsjlCtr.class);
    
    @Autowired
    private MessJsjlSer messJsjlSer;
    
    @Autowired
    private RedisFactory redisFactory;
    
  
//    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity add(@ApiParam(name = "messId", value = "消息主键") @RequestParam(value = "messId")  Integer messId,
    	    @ApiParam(name = "ksId", value = "科室id", required = false) @RequestParam(value = "ksId", required = false ) Integer ksId,
    	    @ApiParam(name = "ywtype", value = "业务类型(1:住院护士站,2:住院医生站)", required = false) @RequestParam(value = "ywtype", required = false ) Integer ywtype) {
    	MessJsjl messJsjl = new MessJsjl();
    	messJsjl.setMessId(messId);
    	messJsjl.setUserId(getUser().getUserId());
    	messJsjl.setJsTime(DateUtil.date().toTimestamp());   
    	if(!StrUtil.isBlankIfStr(ksId)) {
    		messJsjl.setKsId(ksId);
    	}
    	if(!StrUtil.isBlankIfStr(ywtype)) {
    		messJsjl.setYwType(ywtype);
    	}
    	messJsjl.setMessJsjlId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_JSJL));
    	messJsjlSer.insert(messJsjl);        
        return ReturnEntityUtil.success();            
    }
    
}

