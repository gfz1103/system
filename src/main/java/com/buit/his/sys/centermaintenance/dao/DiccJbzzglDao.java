package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DiccJbzzgl;
import com.buit.his.sys.centermaintenance.response.DiccJbzzglResp;

/**
 * 疾病治则关联<br>
 * @author liushijie
 */
@Mapper
public interface DiccJbzzglDao extends EntityDao<DiccJbzzgl,Integer>{


    /**
     * 疾病治则关联列表
     * @param jbbs
     * @return
     */
    List<DiccJbzzglResp> queryList(@Param("jbbs")int jbbs);
    
}
