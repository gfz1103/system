package com.buit.his.sys.centermaintenance.service;


import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.DicZyzhDao;
import com.buit.his.sys.centermaintenance.model.DicZyzh;
import com.buit.his.sys.centermaintenance.request.DicZyzhAddReq;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;

/**
 * <br>
 * @author 老花生
 */
@Service
public class DicZyzhSer extends BaseManagerImp<DicZyzh,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicZyzhSer.class);
    
    @Autowired
    private DicZyzhDao dicZyzhDao;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;
    
    @Override
    public DicZyzhDao getEntityMapper(){        
        return dicZyzhDao;
    }

    /**
     * 新增
     * @param req
     */
    public void add(DicZyzhAddReq req) {
        // 判断名称是否重复
        DicZyzh condition = null;
        if (StringUtils.isNotBlank(req.getZhmc())) {
            condition = new DicZyzh();
            condition.setZhmc(req.getZhmc());
            List<DicZyzh> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICZYZH_0001");
            }
        }
        if (StringUtils.isNotBlank(req.getZhdm())) {
            condition = new DicZyzh();
            condition.setZhdm(req.getZhdm());
            List<DicZyzh> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICZYZH_0002");
            }
        }
//        int zhbs = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_ZYZH);
        DicZyzh zyzh = BeanUtil.toBean(req, DicZyzh.class);
//        zyzh.setZhbs(zhbs);
        zyzh.setZxbz(0);
        dicZyzhDao.insert(zyzh);
        sysDictConfigSer.upDateVersion("dic_jbbm");
    }
}
