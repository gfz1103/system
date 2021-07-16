package com.buit.his.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysGroup;
import com.buit.his.user.model.SysUserGroup;

/**
 * 系统用户与用户组对照表<br>
 * 
 * @author
 */
@Mapper
public interface SysUserGroupDao extends EntityDao<SysUserGroup, Integer> {
	/**
	 * 获取岗位字典
	 * 
	 * @param sysUserGroup
	 * @return
	 */
	public List<SysGroup> getGroupDic(SysUserGroup sysUserGroup);

	/**
	 * 根据用户ID删除
	 * 
	 * @param userId
	 */
	public void delByUserId(Integer userId);

    Integer checkHavaGroup(Integer userId, Integer groupId, Integer jgid);
}
