package com.buit.his.user.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.user.dao.SysUserDeptDao;
import com.buit.his.user.model.SysUserDept;
/**
 * 系统用户授权科室<br>
 * @author All
 */
@Service
public class SysUserDeptSer extends BaseManagerImp<SysUserDept,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysUserDeptSer.class);
    
    @Autowired
    private SysUserDeptDao sysUserDeptDao;
    
    @Override
    public SysUserDeptDao getEntityMapper(){        
        return sysUserDeptDao;
    }
    
}
