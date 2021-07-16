package com.buit.his.dic.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.dic.dao.DicXzqhDao;
import com.buit.system.model.DicXzqh;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 行政区划表<br>
 * @author liushijie
 */
@Service
public class DicXzqhSer extends BaseManagerImp<DicXzqh,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicXzqhSer.class);
    
    @Autowired
    private DicXzqhDao dicXzqhDao;
    
    @Override
    public DicXzqhDao getEntityMapper(){        
        return dicXzqhDao;
    }
    
}
