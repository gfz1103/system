package com.buit.his.sys.msg.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.msg.model.MessJsr;
/**
 * 消息推送-接收人<br>
 * @author 神算子
 */
@Mapper
public interface MessJsrDao extends EntityDao<MessJsr,Integer>{
    
}
