package com.buit.his.sys.adminms.service;


import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.adminms.dao.SysRourtDao;
import com.buit.his.sys.adminms.model.SysRourt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 前台发布端口<br>
 * @author DESKTOP-OK78BUA
 */
@Service
public class SysRourtSer extends BaseManagerImp<SysRourt,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysRourtSer.class);
    
    @Autowired
    private SysRourtDao sysRourtDao;
    
    @Override
    public SysRourtDao getEntityMapper(){        
        return sysRourtDao;
    }
    
}
