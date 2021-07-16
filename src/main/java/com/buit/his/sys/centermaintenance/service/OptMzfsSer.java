package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.OptMzfsDao;
import com.buit.his.sys.centermaintenance.model.OptMzfs;
/**
 * <br>
 * @author GONGFANGZHOU
 */
@Service
public class OptMzfsSer extends BaseManagerImp<OptMzfs,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(OptMzfsSer.class);
    
    @Autowired
    private OptMzfsDao optMzfsDao;
    
    @Override
    public OptMzfsDao getEntityMapper(){        
        return optMzfsDao;
    }
    
}
