package com.buit.his.sys.centermaintenance.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.ImDicYpyfFjjfDao;
import com.buit.his.sys.centermaintenance.model.ImDicYpyfFjjf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 住院_药品用法_附加计费<br>
 * @author GONGFANGZHOU
 */
@Service
public class ImDicYpyfFjjfSer extends BaseManagerImp<ImDicYpyfFjjf,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(ImDicYpyfFjjfSer.class);
    
    @Autowired
    private ImDicYpyfFjjfDao imDicYpyfFjjfDao;
    
    @Override
    public ImDicYpyfFjjfDao getEntityMapper(){        
        return imDicYpyfFjjfDao;
    }
    
}
