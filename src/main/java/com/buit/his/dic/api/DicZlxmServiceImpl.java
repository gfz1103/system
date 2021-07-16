package com.buit.his.dic.api;

import com.buit.his.sys.centermaintenance.dao.DicZlxmDao;
import com.buit.his.sys.centermaintenance.model.DicZlxm;
import com.buit.system.model.DicZlxmModel;
import com.buit.system.service.DicZlxmService;
import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：DicZlxmServiceImpl
 * 描述：诊疗项目接口实现
 *
 * @author : liushijie
 * 2020/10/14
 **/
@DubboService(timeout = 10000)
public class DicZlxmServiceImpl implements DicZlxmService {
    @Autowired
    private DicZlxmDao dicZlxmDao;

    @Override
    public DicZlxmModel getById(Integer fyxh) {
        DicZlxm zlxm = dicZlxmDao.getById(fyxh);
        return BeanUtil.toBean(zlxm, DicZlxmModel.class);
    }

}
