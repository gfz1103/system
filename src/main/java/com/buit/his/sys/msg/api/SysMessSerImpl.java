package com.buit.his.sys.msg.api;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.commons.SysUser;
import com.buit.his.sys.msg.dao.MessZjlDao;
import com.buit.his.sys.msg.model.MessJsr;
import com.buit.his.sys.msg.model.MessZjl;
import com.buit.his.sys.msg.service.MessJsrSer;
import com.buit.his.sys.msg.service.MessZjlSer;
import com.buit.system.request.MessJsrOut;
import com.buit.system.request.MessZjlOut;
import com.buit.system.service.SysMessSer;

import cn.hutool.core.collection.CollectionUtil;


/**
 * 系统消息发送<br>
 * @author 神算子
 */
@DubboService(timeout = 10000)
public class SysMessSerImpl implements SysMessSer{
	
	@Autowired
	private MessZjlSer messZjlSer;
	@Autowired
	private MessJsrSer messJsrSer;
	
	@Autowired
	private MessZjlDao messZjlDao;
	
	/*
     * 消息推送
     */
	@Override
	public void pubMess(MessZjlOut messZjlOut,List<MessJsrOut> yqList,SysUser sysUser) {
		MessZjl query = new MessZjl();
		query.setCallId(messZjlOut.getCallId());
		query.setSerType(messZjlOut.getSerType());
		query.setIsFinish(1);
		List<MessZjl> list = messZjlSer.findByEntity(query);
		if(CollectionUtils.isEmpty(list)) {
			MessZjl messZjl=new MessZjl();
			BeanUtils.copyProperties(messZjlOut, messZjl);
			messZjlSer.pubMesshz(messZjl, yqList, sysUser);
		}
	}
	@Override
	public void delMess(Integer callId, Integer serType) {
		if(callId==null||serType==null) {
			return ;
		}
		MessZjl que=new MessZjl();
		MessJsr del=new MessJsr();
		que.setCallId(callId);
		que.setSerType(serType);
		List<MessZjl> list = messZjlSer.findByEntity(que);
		if(CollectionUtil.isNotEmpty(list)) {
			for (MessZjl messZjl : list) {
				messZjlSer.removeById(messZjl.getMessId());
				del.setMessId(messZjl.getMessId());
				messJsrSer.removeByEntity(del);
			}
		}
		
	}
	
	@Override
	public void updateFinishByCallId(Integer callId, Integer serType) {
		messZjlDao.updateFinishByCallId(callId, serType);
	}
}
