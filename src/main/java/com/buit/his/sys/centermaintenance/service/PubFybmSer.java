package com.buit.his.sys.centermaintenance.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.PubFybmDao;
import com.buit.his.sys.centermaintenance.model.PubFybm;
/**
 * 公用_费用别名<br>
 * @author GONGFANGZHOU
 */
@Service
public class PubFybmSer extends BaseManagerImp<PubFybm,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(PubFybmSer.class);
    
    @Autowired
    private PubFybmDao pubFybmDao;
    
    @Override
    public PubFybmDao getEntityMapper(){        
        return pubFybmDao;
    }
    
}
