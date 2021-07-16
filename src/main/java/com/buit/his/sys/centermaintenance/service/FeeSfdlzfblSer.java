package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.FeeSfdlzfblDao;
import com.buit.system.response.FeeSfdlzfbl;
/**
 * 公用_自负比例<br>
 * @author ZHOUHAISHENG
 */
@Service
public class FeeSfdlzfblSer extends BaseManagerImp<FeeSfdlzfbl,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(FeeSfdlzfblSer.class);
    
    @Autowired
    private FeeSfdlzfblDao feeSfdlzfblDao;
    
    @Override
    public FeeSfdlzfblDao getEntityMapper(){        
        return feeSfdlzfblDao;
    }
    
}
