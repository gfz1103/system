package com.buit.his.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysGroupMenu;
/**
 * 用户组菜单授权表<br>
 * @author 
 */
@Mapper
public interface SysGroupMenuDao extends EntityDao<SysGroupMenu,Integer>{
    
}
