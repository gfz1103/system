package com.buit.his.sys.centermaintenance.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DiccJbzzglDao;
import com.buit.his.sys.centermaintenance.model.DiccJbzzgl;
import com.buit.his.sys.centermaintenance.request.DiccJbzzglAddReq;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;

/**
 * 疾病治则关联<br>
 *
 * @author liushijie
 */
@Service
public class DiccJbzzglSer extends BaseManagerImp<DiccJbzzgl, Integer> {

    static final Logger logger = LoggerFactory.getLogger(DiccJbzzglSer.class);

    @Autowired
    private DiccJbzzglDao diccJbzzglDao;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public DiccJbzzglDao getEntityMapper() {
        return diccJbzzglDao;
    }


    /**
     * 新增
     * @param req
     */
    public void add(DiccJbzzglAddReq req) {
        DiccJbzzgl condition = new DiccJbzzgl();
        condition.setJbbs(req.getJbbs());
        condition.setZhbs(req.getZhbs());
        List<DiccJbzzgl> dataList = findByEntity(condition);
        if (dataList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_DICCJBZZ_0001",new String[]{req.getZhmc()});
        }
//        int glbs = redisFactory.getTableKey(TableName.DB_NAME, TableName.DICC_JBZZGL);
        DiccJbzzgl jbzz = BeanUtil.toBean(req, DiccJbzzgl.class);
//        jbzz.setGlbs(glbs);
        diccJbzzglDao.insert(jbzz);
    }

}
