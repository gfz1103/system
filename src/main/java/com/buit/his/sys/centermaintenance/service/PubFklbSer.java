package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.PubFklbDao;
import com.buit.his.sys.centermaintenance.model.PubFklb;
import com.buit.his.sys.centermaintenance.request.PubFklbAddReq;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;

/**
 * 付款类别<br>
 *
 * @author liushijie
 */
@Service
public class PubFklbSer extends BaseManagerImp<PubFklb, Integer> {

    static final Logger logger = LoggerFactory.getLogger(PubFklbSer.class);

    @Autowired
    private PubFklbDao pubFklbDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public PubFklbDao getEntityMapper() {
        return pubFklbDao;
    }

    /**
     * 新增
     * @param req
     */
    public void add(PubFklbAddReq req) {
        int fklb = redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_FKLB);
        PubFklb pubFklb = BeanUtil.toBean(req, PubFklb.class);
        pubFklb.setFklb(fklb);
        pubFklbDao.insert(pubFklb);
    }
}
