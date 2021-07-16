package com.buit.his.user.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.user.dao.SysUserMenuDao;
import com.buit.his.user.model.SysUserMenu;
/**
 * 用户快捷菜单<br>
 * @author All
 */
@Service
public class SysUserMenuSer extends BaseManagerImp<SysUserMenu,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysUserMenuSer.class);
    
    @Autowired
    private SysUserMenuDao sysUserMenuDao;
    
    @Override
    public SysUserMenuDao getEntityMapper(){        
        return sysUserMenuDao;
    }
    
}
