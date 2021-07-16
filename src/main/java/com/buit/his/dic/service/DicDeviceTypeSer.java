package com.buit.his.dic.service;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.EntityDao;
import com.buit.his.dic.dao.DicDeviceTypeDao;
import com.buit.his.dic.model.DicDeviceType;
import com.buit.his.dic.request.DicDeviceTypeAddReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class DicDeviceTypeSer extends BaseManagerImp<DicDeviceType, Integer> {

    @Autowired
    private DicDeviceTypeDao dicDeviceTypeDao;

    @Override
    public EntityDao<DicDeviceType, Integer> getEntityMapper() {
        return dicDeviceTypeDao;
    }

    /**
     * 通过设备型号查找唯一设备
     *
     * @param model 设备型号
     */
    public DicDeviceType getByModel(String model) {
        DicDeviceType query = new DicDeviceType();
        List<DicDeviceType> list = new ArrayList<>();
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

    /**
     * 新增或修改设备类型
     */
    @Transactional(rollbackFor = Exception.class)
    public void save(DicDeviceTypeAddReq req) {
        dicDeviceTypeDao.insert(req);
    }
}
