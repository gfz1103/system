package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.FeeXmfytj02Dao;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj02;
/**
 * <br>
 * @author GONGFANGZHOU
 */
@Service
public class FeeXmfytj02Ser extends BaseManagerImp<FeeXmfytj02,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(FeeXmfytj02Ser.class);
    
    @Autowired
    private FeeXmfytj02Dao feeXmfytj02Dao;
    
    @Override
    public FeeXmfytj02Dao getEntityMapper(){        
        return feeXmfytj02Dao;
    }
    
}
