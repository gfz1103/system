package com.buit.his.dic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.his.sys.centermaintenance.dao.DicYljgDao;
import com.buit.his.sys.centermaintenance.model.DicYljg;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/25 19:41
 */
@Service
public class YljgCacheSer {

    @Autowired
    DicYljgDao dicYljgDao;

    public DicYljg getYljgByJgid(Integer jgid) {
        return dicYljgDao.getById(jgid);
    }

}
