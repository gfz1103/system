package com.buit.his.sys.msg.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.sys.msg.dao.MessCljlDao;
import com.buit.his.sys.msg.dao.MessZjlDao;
import com.buit.his.sys.msg.model.MessCljl;
import com.buit.his.sys.msg.model.MessZjl;
import com.buit.utill.RedisFactory;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
/**
 * 消息推送-处理记录<br>
 * @author 神算子
 */
@Service
public class MessCljlSer extends BaseManagerImp<MessCljl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(MessCljlSer.class);
    
    @Autowired
    private MessCljlDao messCljlDao;
    @Autowired
    private MessZjlDao messZjlDao;
    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public MessCljlDao getEntityMapper(){        
        return messCljlDao;
    }
    
    /**
     * 会诊消息处理完成
     */
    public void hzFinish(Integer sqxh,SysUser sysuser){
    	MessZjl messZjl =new MessZjl();
    	messZjl.setCallId(sqxh);
    	List<MessZjl> messZjlList= messZjlDao.findByEntity(messZjl);
		if(CollectionUtil.isNotEmpty(messZjlList)) {
			messZjl=messZjlList.get(0);
			MessCljl messCljl=new MessCljl();
	    	messCljl.setMessId(messZjl.getMessId());
	    	messCljl.setUserId(sysuser.getUserId());
	    	messCljl.setCtime(DateUtil.date().toTimestamp());
//	    	messCljl.setKsId(messZjl.getk);
	    	messCljl.setMessCljlId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_CLJL));
	    	messCljlDao.insert(messCljl);        
		}
    }
    
}
