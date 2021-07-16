package com.buit.his.sys.msg.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.msg.model.MessCljl;
/**
 * 消息推送-处理记录<br>
 * @author 神算子
 */
@Mapper
public interface MessCljlDao extends EntityDao<MessCljl,Integer>{
    
}
