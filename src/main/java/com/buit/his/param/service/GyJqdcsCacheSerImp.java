package com.buit.his.param.service;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.his.param.dao.CfgJqtdcsDao;
import com.buit.system.response.CfgJqtdcs;
import com.buit.system.service.GyJqdcsCacheSer;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/14 13:18
 */
@DubboService(timeout = 10000)
public class GyJqdcsCacheSerImp  implements GyJqdcsCacheSer{

    @Autowired
    CfgJqtdcsDao cfgJqtdcsDao;

    public CfgJqtdcs getByJgIdAndIpAndCsmc(Integer jgId,String ip,String csmc){
        return cfgJqtdcsDao.getByJgIdAndIpAndCsmc(jgId,ip,csmc);
    }

    public void update(CfgJqtdcs sysXtcs){
        cfgJqtdcsDao.update(sysXtcs);
    }

    public void delete(Integer jgId,String ip,String csmc){
        cfgJqtdcsDao.deleteByJGIdAndIpAndCsmc(jgId,ip,csmc);
    }
    
    public void insert(CfgJqtdcs cfgJqtdcs) {
    	cfgJqtdcsDao.insert(cfgJqtdcs);
    }
    
    public List<CfgJqtdcs> findByEntity(Object entity) {
    	return cfgJqtdcsDao.findByEntity(entity);
    }
}
