package com.buit.his.sys.centermaintenance.dao;

import com.buit.his.sys.centermaintenance.model.DicSsbm;
import com.buit.his.sys.centermaintenance.request.QueryOperationCodeReq;
import com.buit.his.sys.centermaintenance.response.OperationCodeResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/12/4 11:12
 */
@Mapper
public interface DicSsbmDao {

    void replace(DicSsbm ssbm);

    List<DicSsbm> query(QueryOperationCodeReq req);

    void deleteById(@Param("id") Integer jbxh);

    void enable(@Param("id") Integer id);

    DicSsbm getById(@Param("id") Integer id);
}
