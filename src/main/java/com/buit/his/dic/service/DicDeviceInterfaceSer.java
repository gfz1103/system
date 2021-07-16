package com.buit.his.dic.service;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.EntityDao;
import com.buit.his.dic.dao.DicDeviceInterfaceDao;
import com.buit.his.dic.model.DicDeviceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicDeviceInterfaceSer extends BaseManagerImp<DicDeviceInterface, Integer> {

    @Autowired
    private DicDeviceInterfaceDao dicDeviceInterfaceDao;

    @Override
    public EntityDao<DicDeviceInterface, Integer> getEntityMapper() {
        return dicDeviceInterfaceDao;
    }

    /**
     * 通过设备类型及接口名称查询
     *
     * @param typeId        设备类型主键
     * @param interfaceName 接口主键
     * @return
     */
    public DicDeviceInterface getByTypeAndName(Integer typeId, String interfaceName) {
        DicDeviceInterface query = new DicDeviceInterface();
        query.setTypeId(typeId);
        query.setInterfaceName(interfaceName);
        List<DicDeviceInterface> list = dicDeviceInterfaceDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}
