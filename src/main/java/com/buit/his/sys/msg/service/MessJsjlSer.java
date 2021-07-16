package com.buit.his.sys.msg.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.msg.dao.MessJsjlDao;
import com.buit.his.sys.msg.model.MessJsjl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 消息危急值接收记录<br>
 * @author GONGFANGZHOU
 */
@Service
public class MessJsjlSer extends BaseManagerImp<MessJsjl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(MessJsjlSer.class);
    
    @Autowired
    private MessJsjlDao messJsjlDao;
    
    @Override
    public MessJsjlDao getEntityMapper(){        
        return messJsjlDao;
    }
    
}
