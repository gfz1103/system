package com.buit.his.sys.centermaintenance.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicZyzhfl;
import com.buit.his.sys.centermaintenance.response.DicZyzhflResp;

/**
 * 中医证候分类
 *
 * @author liushijie
 */
@Mapper
public interface DicZyzhflDao extends EntityDao<DicZyzhfl, Integer> {

    /**
     * 查询中医证候分类列表
     * @return
     */
    List<DicZyzhflResp> queryList();
}
