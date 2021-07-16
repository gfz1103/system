package com.buit.his.sys.centermaintenance.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.PubFkfsDao;
import com.buit.his.sys.centermaintenance.model.PubFkfs;
import com.buit.his.sys.centermaintenance.request.PubFkfsAddReq;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 公用_付款方式 |  用于门诊及住院付款方式设定<br>
 *
 * @author WY
 */
@Service
public class PubFkfsSer extends BaseManagerImp<PubFkfs, Integer> {

    static final Logger logger = LoggerFactory.getLogger(PubFkfsSer.class);

    @Autowired
    private PubFkfsDao pubFkfsDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @Override
    public PubFkfsDao getEntityMapper() {
        return pubFkfsDao;
    }

    /**
     * 新增
     *
     * @param req
     */
    public void add(PubFkfsAddReq req) {
        PubFkfs pubFkfs = BeanUtil.toBean(req, PubFkfs.class);
        PubFkfs condition = new PubFkfs();
        condition.setFkmc(req.getFkmc());
        condition.setSylx(req.getSylx());
        List<PubFkfs> existList = pubFkfsDao.findByEntity(condition);
        if (existList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_GYFKFS_0001");
        }
//        int fkfs = redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_FKFS);
        
        Integer fkfs = pubFkfsDao.queryFkfsNextPk();
        if (null == req.getHmcd()) {
            pubFkfs.setHmcd(0);
        }
        pubFkfs.setZfbz(0);
        pubFkfs.setFkfs(fkfs);
        pubFkfs.setMrbz(0);
        //住院归并，门诊归并默认是自身
        if (pubFkfs.getMzgb() == -1) {
            pubFkfs.setMzgb(fkfs);
        }
        if (pubFkfs.getZygb() == -1) {
            pubFkfs.setZygb(fkfs);
        }
        pubFkfsDao.insert(pubFkfs);
        sysDictConfigSer.upDateVersion("pub_fkfs");
    }

    /**
     * 设置默认标志
     *
     * @param fkfs
     */
    @Transactional(rollbackFor = Exception.class)
    public void setMrbz(Integer fkfs, Integer sylx) {
        PubFkfs condition = new PubFkfs();
        condition.setFkfs(fkfs);
        condition.setSylx(sylx);
        condition.setHbwc(1);
        List<PubFkfs> dataList = findByEntity(condition);
        if (dataList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_GYFKFS_0002");
        }
        // 还原默认标志
        pubFkfsDao.reductionMrbz(sylx);
        pubFkfsDao.setMrbz(fkfs, 1, sylx);
        sysDictConfigSer.upDateVersion("pub_fkfs");
    }

    /**
     * 设置货币误差
     *
     * @param fkfs
     */
    @Transactional(rollbackFor = Exception.class)
    public void setHbwc(Integer fkfs, Integer sylx) {
        PubFkfs condition = new PubFkfs();
        condition.setFkfs(fkfs);
        condition.setSylx(sylx);
        condition.setMrbz(1);
        List<PubFkfs> dataList = findByEntity(condition);
        if (dataList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_GYFKFS_0002");
        }
        // 还原货币误差
        pubFkfsDao.reductionHbwc(sylx);
        pubFkfsDao.setHbwc(fkfs, 1, sylx);
    }

}
