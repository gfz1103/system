package com.buit.his.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysMenuSelected;

/**
 * 系统菜单表<br>
 * 
 * @author wangyang
 */
@Mapper
public interface SysMenuSelectedDao extends EntityDao<SysMenuSelected, Integer> {
}
