package com.buit.his.sys.centermaintenance.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.GzhcTjkcLog;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author jiangwei
 * @Description 高值耗材调价库存日志表
 * @Date 2021-07-08
 */
@Mapper
@Repository
public interface GzhcTjkcLogDao extends EntityDao<GzhcTjkcLog, Integer> {
    /**
     * 按属性修改非空值
     */
    void updateByEntity(GzhcTjkcLog entry);
}
