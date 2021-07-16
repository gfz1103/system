package com.buit.his.dic.api;

import com.buit.his.dic.dao.DicXzqhDao;
import com.buit.system.model.DicXzqh;
import com.buit.system.service.DicXzqhService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类名：DicXzqhServiceImpl
 * 描述：行政区划接口实现
 *
 * @author : liushijie
 * 2020/10/18
 **/
@DubboService(timeout = 10000)
public class DicXzqhServiceImpl implements DicXzqhService {
    @Autowired
    private DicXzqhDao dicXzqhDao;


    @Override
    public List<DicXzqh> findByEntity(Object o) {
        return dicXzqhDao.findByEntity(o);
    }

    @Override
    public String getSsxmc(Integer code) {
        return dicXzqhDao.getSsxmc(code);
    }
}
