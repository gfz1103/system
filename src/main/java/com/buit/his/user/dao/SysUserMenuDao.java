package com.buit.his.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysMenu;
import com.buit.his.user.model.SysUserMenu;

/**
 * 用户快捷菜单<br>
 * 
 * @author
 */
@Mapper
public interface SysUserMenuDao extends EntityDao<SysUserMenu, Integer> {
	/**
	 * 获取所有菜单
	 * @param groupId 组ID
	 * @param userid
	 * @return
	 */
	public List<SysMenu> getAllMenu( @Param("userId") Integer userid, @Param("groupId") Integer groupId );
	/**
	 * 删除组下 不再有权限的菜单
	 * @param groupId 组ID
	 * @return
	 */
	public void deleteByGroupId(@Param("groupId") Integer groupId );

}
