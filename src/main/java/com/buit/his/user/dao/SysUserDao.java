package com.buit.his.user.dao;

import com.buit.commons.EntityDao;
import com.buit.commons.SysUser;
import com.buit.his.user.response.DicResp;
import com.buit.his.user.response.SysUserAddResp;
import com.buit.his.user.response.SysUserResp;
import com.buit.system.response.SysUserByKjywResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 系统用户表<br>
 *
 * @author
 */
@Mapper
public interface SysUserDao extends EntityDao<SysUser, Integer> {
	/**
	 * 根据用户名查询登录 信息
	 *
	 * @param loginName
	 * @return
	 */
	public List<SysUser> loginQuery(String loginName);

	/**
	 * 登录成功后 修改登录次数
	 *
	 * @param sysUser
	 */
	public void addLoginCount(SysUser sysUser);

	/**
	 * 锁定用户
	 *
	 * @param userId
	 */
	public void lockUser(Integer userId);

	/**
	 * 解锁用户
	 *
	 * @param userId
	 */
	public void unlockUser(Integer userId);

	/**
	 * 锁定用户
	 *
	 * @param personId
	 */
	public void lockUserByPerson(Integer personId);

	/**
	 * 解锁用户
	 *
	 * @param personId
	 */
	public void unlockUserByPerson(Integer personId);

	/**
	 * 根据GroupId查询已授权用户列表
	 *
	 * @param groupId
	 * @param queryName
	 * @param hospitalId
	 * @return
	 */
	public List<SysUserAddResp> haveListByGroupId(@Param("groupId") Integer groupId,
			@Param("queryName") String queryName, @Param("hospitalId") Integer hospitalId);

	/**
	 * 根据GroupId查询未授权用户列表
	 *
	 * @param groupId
	 * @param queryName
	 * @param hospitalId
	 * @return
	 */
	public List<SysUserAddResp> noListByGroupId(@Param("groupId") Integer groupId, @Param("queryName") String queryName,
			@Param("hospitalId") Integer hospitalId);

	/**
	 * 获取所有用户
	 *
	 * @param sysUser
	 * @return
	 */
	public List<SysUserAddResp> getallUser(SysUser sysUser);

	/**
	 * 获取密码
	 *
	 * @param userId
	 * @return
	 */
	public SysUser getPwd(Integer userId);
	/**
	 * 更新用户信息
	 *
	 * @param SysUser 用户对象
	 * @return
	 */
	public void updateInfo(SysUser user);
    /**
     * 报表
     *
     * @param SysUser 用户对象
     * @return
     */
	public List<Map<String,Object>> getReport(Map<String,Object> parmap);

	/**
	 * 获取岗位用户列表字典
	 * @param sysuser
	 * @return
	 */
	List<DicResp> findGroupUserDic(SysUser sysuser);

	/**
	 * @name: queryLoginDoctor
	 * @description: 查询在线医生
	 * @param ksid
	 * @return: java.util.List<com.buit.his.user.response.SysUserResp>
	 * @date: 2020/9/9 13:41
	 * @auther: 朱智
	 *
	 */
    List<SysUserResp> queryLoginDoctor(@Param("ksid") Integer ksid);

	/**
	 * 查询有抗菌药物权限的医生账号列表
	 * @param jgid
	 * @param kjywdj
	 * @return
	 */
	List<SysUserByKjywResp> queryByKjyw(@Param("jgid") Integer jgid, @Param("kjywdj") String kjywdj);
	/**
	 * 修改密码登录超过10次错误标识
	 * @param user
	 */
	void updateLoginErrorFlag(SysUser user);
	List<SysUserResp> errorUser(@Param("hospitalId") Integer hospitalId,@Param("userName") String userName);

}
