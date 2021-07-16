package com.buit.his.sys.centermaintenance.service;


import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.DicZyjbDao;
import com.buit.his.sys.centermaintenance.model.DicZyjb;
import com.buit.his.sys.centermaintenance.request.DicZyjbAddReq;
import com.buit.his.sys.centermaintenance.request.DicZyjbReq;
import com.buit.his.sys.centermaintenance.response.DicZyjbResp;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;

/**
 * <br>
 * @author 老花生
 */
@Service
public class DicZyjbSer extends BaseManagerImp<DicZyjb,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicZyjbSer.class);
    
    @Autowired
    private DicZyjbDao dicZyjbDao;

    @Autowired
    private RedisFactory redisFactory;

    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;
    
    @Override
    public DicZyjbDao getEntityMapper(){        
        return dicZyjbDao;
    }


    /**
     * 查询中医疾病列表
     * @return
     */
    public List<DicZyjbResp> findZyjb(DicZyjbReq req) {
        return dicZyjbDao.findZyjb(req);
    }
    public List<DicZyjbResp> findZyjbbm(DicZyjbReq req) {
        return dicZyjbDao.findZyjbbm(req);
    }

    /**
     * 新增
     * @param req
     */
    public void add(DicZyjbAddReq req) {
        DicZyjb condition = null;
        // 校验名称是否重复
        if (StringUtils.isNotBlank(req.getJbmc())) {
            condition = new DicZyjb();
            condition.setJbmc(req.getJbmc());
            List<DicZyjb> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICZYJB_0001");
            }
        }
        // 校验疾病代码是否重复
        if (StringUtils.isNotBlank(req.getJbdm())) {
            condition = new DicZyjb();
            condition.setJbdm(req.getJbdm());
            List<DicZyjb> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICZYJB_0002");
            }
        }
        DicZyjb zyjb = BeanUtil.toBean(req, DicZyjb.class);
//        int jbbs = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_ZYJB);
//        zyjb.setJbbs(jbbs);
        zyjb.setZxbz(0);
        zyjb.setKzfs(0);
        zyjb.setPydm(PinyinUtils.getSimplePinYin(zyjb.getJbmc()));
        zyjb.setPydm(WubiUtils.getSimpleWuBi(zyjb.getJbmc()));
        dicZyjbDao.insert(zyjb);
        sysDictConfigSer.upDateVersion("dic_zyjb");
    }
}
