package com.buit.his.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysUserResource;
import com.buit.his.user.response.HospitaDicResp;
import com.buit.his.user.response.SysUserAddResp;

/**
 * 用户与资源对应关系<br>
 * @author 
 */
@Mapper
public interface SysUserResourceDao extends EntityDao<SysUserResource, Integer> {
	/**
	 * 获取医疗结构字典
	 * 
	 * @param userid
	 * @return
	 */
	public List<HospitaDicResp> getHospitaDic(Integer userid);

	/**
	 * 取所有未授权用户列表
	 * 
	 * @param sysUserResource
	 * @return
	 */
	public List<SysUserAddResp> getNoAuthUser(SysUserResource sysUserResource);

	/**
	 * 取所有已授权用户列表
	 * 
	 * @param sysUserResource
	 * @return
	 */
	public List<SysUserAddResp> getAuthUser(SysUserResource sysUserResource);

}
