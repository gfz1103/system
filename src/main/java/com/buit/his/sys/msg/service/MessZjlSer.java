package com.buit.his.sys.msg.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.sys.msg.dao.MessJsrDao;
import com.buit.his.sys.msg.dao.MessZjlDao;
import com.buit.his.sys.msg.model.MessJsr;
import com.buit.his.sys.msg.model.MessZjl;
import com.buit.system.request.MessJsrOut;
import com.buit.utill.RedisFactory;
/**
 * 消息推送-主记录<br>
 * @author 神算子
 */
@Service
public class MessZjlSer extends BaseManagerImp<MessZjl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(MessZjlSer.class);
    
    @Autowired
    private MessZjlDao messZjlDao;
    @Autowired
    private MessJsrDao messJsrDao;
    @Autowired
	private RedisFactory redisFactory;
    
    @Override
    public MessZjlDao getEntityMapper(){        
        return messZjlDao;
    }
    /*
     * 会诊断消息提醒
     */
//    public void pubMesshz(CisZyHzsqIReq cisZyHzsq,List<CisZyHzyqdxIReq> yqList,SysUser sysUser){
//    	MessZjl messZjl =new MessZjl();
//    	messZjl.setMessTitle(cisZyHzsq.getHzmd());
//    	messZjl.setMessContent(cisZyHzsq.getHzmd2());
//    	messZjl.setCtime(DateUtil.date().toTimestamp());
//    	messZjl.setCuserId(sysUser.getUserId());
//    	messZjl.setCuserName(sysUser.getUserName());
//    	messZjl.setCallInterval(1);
//    	messZjl.setMessType(1);
//    	messZjl.setCallId(cisZyHzsq.getSqxh());
//    	messZjl.setIsFinish(1);
//    	messZjl.setSerType(2);
//    	messZjl.setMessTimeOut(cisZyHzsq.getHzsj());
//    	messZjl.setMessId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_ZJL));
//    	MessJsr messJsr=new MessJsr();
//    	messJsr.setMessId(messZjl.getMessId());
//    	for (CisZyHzyqdxIReq cisZyHzyqdx : yqList) {
//    		messJsr.setMessJsId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_JSR));
//    		if("-1".equals(cisZyHzyqdx.getYqdx())) {
//    			messJsr.setUserId(Integer.valueOf(cisZyHzyqdx.getYqdx()));
//    			messJsr.setKsId(null);
//    		}else {
//    			messJsr.setUserId(null);
//    			messJsr.setKsId(Integer.valueOf(cisZyHzyqdx.getNyqhzks()));
//    		}
//    		messJsrDao.insert(messJsr);	
//		}
//    	//通知前端 重取消息
//    }
//    
    
    
    /*
     * 会诊断消息提醒
     */
    public void pubMesshz(MessZjl messZjl,List<MessJsrOut> yqList,SysUser sysUser){
//    	MessZjl messZjl =new MessZjl();
//    	messZjl.setMessTitle(cisZyHzsq.getHzmd());
//    	messZjl.setMessContent(cisZyHzsq.getHzmd2());
//    	messZjl.setCtime(DateUtil.date().toTimestamp());
//    	messZjl.setCuserId(sysUser.getUserId());
//    	messZjl.setCuserName(sysUser.getUserName());
//    	messZjl.setCallInterval(1);
//    	messZjl.setMessType(1);
//    	messZjl.setCallId(cisZyHzsq.getSqxh());
//    	messZjl.setIsFinish(1);
//    	messZjl.setSerType(2);
//    	messZjl.setMessTimeOut(cisZyHzsq.getHzsj());
    	messZjl.setMessId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_ZJL));
    	MessJsr messJsr=new MessJsr();
    	messJsr.setMessId(messZjl.getMessId());
    	for (MessJsrOut messJsrOut : yqList) {
    		BeanUtils.copyProperties(messJsrOut, messJsr);
    		messJsr.setMessJsId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_JSR));
    		messJsrDao.insert(messJsr);	
		}
    	messZjlDao.insert(messZjl);
    	//通知前端 重取消息
    }
    public List<MessZjl> getallMess(SysUser sysUser){
    	return null;
    }
    
}
