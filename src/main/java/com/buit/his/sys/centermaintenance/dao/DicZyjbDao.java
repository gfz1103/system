package com.buit.his.sys.centermaintenance.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicZyjb;
import com.buit.his.sys.centermaintenance.request.DicZyjbReq;
import com.buit.his.sys.centermaintenance.response.DicZyjbResp;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface DicZyjbDao extends EntityDao<DicZyjb,Integer> {

    /**
     * 查询中医疾病列表
     * @param req   请求参数
     * @return
     */
    List<DicZyjbResp> findZyjb(DicZyjbReq req);
    List<DicZyjbResp> findZyjbbm(DicZyjbReq req);

    /**
     * 查询疾病列表
     * @param zyfl
     * @param pydm
     * @return
     */
    List<DicZyjb> queryList(@Param("zyfl")int zyfl,@Param("pydm")String pydm);
}
