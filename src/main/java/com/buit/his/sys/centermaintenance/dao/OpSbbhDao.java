package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.OpSbbh;

/**
 * 设备编号表<br>
 * @author GONGFANGZHOU
 */
@Mapper
public interface OpSbbhDao extends EntityDao<OpSbbh,Integer>{

    /**
     * 查询检查类型
     * @return
     */
    List<Map<String, Object>> getJklx();
}
