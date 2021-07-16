package com.buit.his.dic.dao;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.DicDevice;
import com.buit.his.dic.request.DicDeviceQueryReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 * @Table dic_device
 */
@Mapper
@Repository
public interface DicDeviceDao extends EntityDao<DicDevice, Integer> {

    /**
     * 更新不为空的字段
     */
    void updateByEntity(DicDevice dicDevice);

    /**
     * 多条件分页查询
     */
    List<DicDevice> queryPage(DicDeviceQueryReq req);
}
