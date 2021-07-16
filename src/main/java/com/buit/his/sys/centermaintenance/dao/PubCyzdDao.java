package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.PubCyzd;
import com.buit.his.sys.centermaintenance.request.PubCyzdReq;
import com.buit.his.sys.centermaintenance.response.PubCyzdResp;
import com.buit.system.request.IPubCyzdReq;
import com.buit.system.response.IPubCyzdResp;
import org.apache.ibatis.annotations.Mapper;


/**
 * 公用_个人常用诊断表<br>
 * @author 老花生
 */
@Mapper
public interface PubCyzdDao extends EntityDao<PubCyzd,Integer> {

    /**
     * 查询个人常用诊断
     * @param pubcyzd    请求对象
     * @return
     */
    List<IPubCyzdResp> query(IPubCyzdReq pubcyzd);

    /**
     * 根据用户ID删除保存诊断
     * @param userId
     */
    void removeByUserId(Integer userId);
}
