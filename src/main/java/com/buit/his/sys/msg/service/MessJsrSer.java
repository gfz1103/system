package com.buit.his.sys.msg.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.his.sys.msg.dao.MessJsrDao;
import com.buit.his.sys.msg.dao.MessZjlDao;
import com.buit.his.sys.msg.model.MessJsr;
import com.buit.his.sys.msg.response.MessZjlResp;

import cn.hutool.core.date.DateUtil;
/**
 * 消息推送-接收人<br>
 * @author 神算子
 */
@Service
public class MessJsrSer extends BaseManagerImp<MessJsr,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(MessJsrSer.class);
    
    @Autowired
    private MessJsrDao messJsrDao;
    @Autowired
    private MessZjlDao messZjlDao;
    
    @Override
    public MessJsrDao getEntityMapper(){        
        return messJsrDao;
    }
   
    public List<MessZjlResp> messList(SysUser sysUser){
    	messZjlDao.updateFinish(DateUtil.date().toTimestamp());
    	return messZjlDao.messList(sysUser);
    } 
}
