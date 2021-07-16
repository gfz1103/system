package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicZyjbfl;
import com.buit.his.sys.centermaintenance.response.DicZyjbflResp;

/**
 * 中医疾病分类
 * @author liushijie
 */
@Mapper
public interface DicZyjbflDao extends EntityDao<DicZyjbfl,Integer>{

    /**
     * 查询中医疾病列表
     * @return
     */
    List<DicZyjbflResp> queryList();

    /**
     * 中医分类下拉列表
     * @return
     */
    List<DicZyjbfl> dropList();
    
}
