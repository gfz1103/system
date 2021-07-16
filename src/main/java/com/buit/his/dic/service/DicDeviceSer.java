package com.buit.his.dic.service;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.EntityDao;
import com.buit.his.dic.dao.DicDeviceDao;
import com.buit.his.dic.model.DicDevice;
import com.buit.his.dic.request.DicDeviceEditReq;
import com.buit.his.dic.request.DicDeviceQueryReq;
import com.buit.his.enums.DeviceStatusEnum;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DicDeviceSer extends BaseManagerImp<DicDevice, Integer> {

    @Autowired
    private DicDeviceDao dicDeviceDao;

    @Override
    public EntityDao<DicDevice, Integer> getEntityMapper() {
        return dicDeviceDao;
    }

    /**
     * 启用设备
     */
    public void enable(Integer deviceId) {
        DicDevice query = new DicDevice();
        query.setDeviceId(deviceId);
        query.setStatus(DeviceStatusEnum.ENABLE.getValue());
        dicDeviceDao.updateByEntity(query);
    }

    /**
     * 停用设备
     */
    public void disable(Integer deviceId) {
        DicDevice query = new DicDevice();
        query.setDeviceId(deviceId);
        query.setStatus(DeviceStatusEnum.DISABLE.getValue());
        dicDeviceDao.updateByEntity(query);
    }

    /**
     * 分页查询
     */
    public List<DicDevice> queryPage(DicDeviceQueryReq req) {
        return dicDeviceDao.queryPage(req);
    }

    /**
     * 编辑
     */
    public void edit(DicDeviceEditReq req) {
        DicDevice query = new DicDevice();
        BeanUtils.copyProperties(req, query);
        dicDeviceDao.updateByEntity(query);
    }

    /**
     * 通过ip地址和设备类型查询
     *
     * @param ip     ip地址
     * @param typeId 设备类型主键
     * @return
     */
    public DicDevice getByIpAndType(String ip, Integer typeId) {
        DicDevice query = new DicDevice();
        query.setIp(ip);
        query.setTypeId(typeId);
        query.setStatus(DeviceStatusEnum.ENABLE.getValue());
        List<DicDevice> list = dicDeviceDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }
}
