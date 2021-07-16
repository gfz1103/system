package com.buit.his.sys.centermaintenance.service;


import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.PubFyxzDao;
import com.buit.his.sys.centermaintenance.model.PubFyxz;
import com.buit.his.sys.centermaintenance.request.PubFyxzAddReq;
import com.buit.utill.BeanUtil;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公用_费用禁用<br>
 * @author ZHOUHAISHENG
 */
@Service
public class PubFyxzSer extends BaseManagerImp<PubFyxz,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(PubFyxzSer.class);
    
    @Autowired
    private PubFyxzDao pubFyxzDao;
    
    @Override
    public PubFyxzDao getEntityMapper(){        
        return pubFyxzDao;
    }


    /**
     * 新增
     * @param req
     */
    @Transactional
    public void add(PubFyxzAddReq req) {
        PubFyxz pubFyxz = BeanUtil.toBean(req, PubFyxz.class);
        // 判断是否存在
        PubFyxz condition = new PubFyxz();
        condition.setBrxz(req.getBrxz());
        condition.setFyxh(req.getFyxh());
        List<PubFyxz> existList = pubFyxzDao.findByEntity(condition);
        if (existList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_GYFYJY_0001");
        }
        pubFyxz.setCxbl(new BigDecimal(0));
        pubFyxz.setFyxe(new BigDecimal(0));
        pubFyxzDao.insert(pubFyxz);
    }

    /**
     * 编辑
     * @param req
     */
    @Transactional
    public void edit(PubFyxzAddReq req) {
        if(Objects.isNull(req.getOldFyxh())) {
            PubFyxz pubFyxz = BeanUtil.toBean(req, PubFyxz.class);
            pubFyxzDao.update(pubFyxz);
        }else {
            add(req);
            pubFyxzDao.deleteById(req.getBrxz(), req.getOldFyxh());
        }
    }
    
}
