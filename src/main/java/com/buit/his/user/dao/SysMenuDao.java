package com.buit.his.user.dao;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysMenu;
import io.lettuce.core.dynamic.annotation.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 系统菜单表<br>
 * 
 * @author
 */
@Mapper
public interface SysMenuDao extends EntityDao<SysMenu, Integer> {
	/**
	 * 菜单停用
	 * 
	 * @param sysMenu
	 */
	public void updateDisplayFlag(SysMenu sysMenu);

	/**
	 * 根据当前用户获取菜单权限
	 * 
	 * @param parentMenuId
	 * @param groupId
	 * @return
	 */
	public List<SysMenu> getMenuListByGroupId(@Param(value = "parentMenuId") Integer parentMenuId,
			@Param(value = "groupId") Integer groupId);

	/**
	 * 获取最大序号
	 * 
	 * @return
	 */
	public Long getMaxSort();

	/**
	 * 获取所有菜单
	 *
	 * @param groupId 角色id
	 * @return
	 */
	List<String> getAllMenu(@Param("groupId") Integer groupId);

	/**
	 * 更新菜单下面
	 *
	 * @param groupId
	 * @return
	 */
	int updateSonParentId(SysMenu sysMenu);
	
	public List<String> getAllSystem();

	String queryUrlByRoute(@Param("routeName") String routeName);
}
