package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicZyzh;
import com.buit.his.sys.centermaintenance.response.DicZyzhResp;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface DicZyzhDao extends EntityDao<DicZyzh,Integer>{

    /**
     * 查询中医证候列表
     * @param id
     * @param pydm
     * @return
     */
    List<DicZyzhResp> queryList(@Param("id") Integer id, @Param("pydm") String pydm);


    /**
     * 通过条件查询症候
     * @param condition
     * @return
     */
    List<DicZyzhResp> queryByConditionList(@Param("condition") String condition);

    /**
     * 证候输入法
     * @return
     */
    List<DicZyzhResp> zyzhInputList();
}
