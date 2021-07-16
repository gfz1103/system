package com.buit.his.sys.centermaintenance.service;


import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.DicSypcDao;
import com.buit.his.sys.centermaintenance.model.DicSypc;
import com.buit.his.sys.centermaintenance.request.DicSypcAddReq;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;

/**
 * 公用_使用频次<br>
 * @author GONGFANGZHOU
 */
@Service
public class DicSypcSer extends BaseManagerImp<DicSypc,String> {
    
    static final Logger logger = LoggerFactory.getLogger(DicSypcSer.class);
    
    @Autowired
    private DicSypcDao dicSypcDao;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;
    
    @Override
    public DicSypcDao getEntityMapper(){        
        return dicSypcDao;
    }

    /**
     * 新增
     * @param req
     */
    public void add(DicSypcAddReq req) {
        // 判断名称是否重复
        DicSypc condition = new DicSypc();
        condition.setPcmc(req.getPcmc());
        List<DicSypc> dataList = findByEntity(condition);
        if (dataList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_DICSYPC_0001");
        }
        DicSypc dicSypc = BeanUtil.toBean(req, DicSypc.class);
        dicSypc.setPcbm(dicSypc.getPcmc());
        dicSypcDao.insert(dicSypc);
        sysDictConfigSer.upDateVersion("dic_sypc");
    }

    
}
