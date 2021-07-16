package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicYjlx;
import com.buit.his.sys.centermaintenance.response.DicYjlxResp;
import com.buit.his.sys.centermaintenance.response.DicYjlxZlxmResp;

/**
 * 医技类型维护<br>
 * @author 老花生
 */
@Mapper
public interface DicYjlxDao extends EntityDao<DicYjlx,Integer>{

    /**
     * 获取医技分类树结构
     * @param pid
     * @return
     */
    List<DicYjlxResp> loadDicData(@Param("pid") Integer pid);

    /**
     * 查询医技类型树集合
     * @return
     */
    List<DicYjlxResp> getTree();

    /**
     * 注销
     * @param id
     */
    void logout(@Param("id") Integer id);
    
    /**
     * 查询医技树
     * @Title: queryDicYjlxById
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param id    设定文件
     * @return DicYjlxZlxmResp    返回类型
     * @author 龚方舟
     * @throws
     */
    DicYjlxZlxmResp queryDicYjlxById(Integer id);
    
}
