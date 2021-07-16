package com.buit.his.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysGroup;

/**
 * 用户组表<br>
 * 
 * @author wangyang
 */
@Mapper
public interface SysGroupDao extends EntityDao<SysGroup, Integer> {
	/**
	 * 岗位停用
	 * 
	 * @param groupId
	 * @param stopFlag
	 */
	public void editEnable(@Param("groupId") Integer groupId, @Param("stopFlag") String stopFlag);

	/**
	 * 查询组代码是否存在
	 * 
	 * @param sysGroup
	 * @return
	 */
	public Integer isExistGroupCode(SysGroup sysGroup);

	/**
	 * 获取最大排序号
	 * 
	 * @return
	 */
	public Long getMaxSort();
}
