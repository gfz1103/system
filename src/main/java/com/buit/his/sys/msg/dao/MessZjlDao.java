package com.buit.his.sys.msg.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.commons.SysUser;
import com.buit.his.sys.msg.model.MessZjl;
import com.buit.his.sys.msg.response.MessZjlResp;
/**
 * 消息推送-主记录<br>
 * @author 神算子
 */
@Mapper
public interface MessZjlDao extends EntityDao<MessZjl,Integer>{
	public List<MessZjlResp> messList(SysUser sysUser);
	public Integer updateFinish(Timestamp now);
	
	void updateFinishByCallId(@Param("callId") Integer callId, @Param("serType") Integer serType);	
}