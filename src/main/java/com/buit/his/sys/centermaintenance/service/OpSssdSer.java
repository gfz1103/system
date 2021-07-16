package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.OpSssdDao;
import com.buit.his.sys.centermaintenance.model.OpSssd;
/**
 * 所属时段<br>
 * @author GONGFANGZHOU
 */
@Service
public class OpSssdSer extends BaseManagerImp<OpSssd,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OpSssdSer.class);
    
    @Autowired
    private OpSssdDao opSssdDao;
    
    @Override
    public OpSssdDao getEntityMapper(){        
        return opSssdDao;
    }
    
}
