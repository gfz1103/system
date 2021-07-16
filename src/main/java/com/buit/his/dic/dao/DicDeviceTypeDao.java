package com.buit.his.dic.dao;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.DicDeviceType;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 * @Table dic_device_type
 */
@Mapper
@Repository
public interface DicDeviceTypeDao extends EntityDao<DicDeviceType, Integer> {

}
