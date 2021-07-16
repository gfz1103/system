package com.buit.his.user.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.user.dao.SysUserGroupDao;
import com.buit.his.user.model.SysUserGroup;
import com.buit.his.user.request.SysUserGroupEditReq;
import com.buit.his.user.request.UserGroupEdit;
import com.buit.utill.RedisFactory;

/**
 * 系统用户与用户组对照表<br>
 * @author All
 */
@Service
public class SysUserGroupSer extends BaseManagerImp<SysUserGroup,Integer> {

    static final Logger logger = LoggerFactory.getLogger(SysUserGroupSer.class);

    @Autowired
    private SysUserGroupDao sysUserGroupDao;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public SysUserGroupDao getEntityMapper(){
        return sysUserGroupDao;
    }

    @Transactional(rollbackFor=Exception.class)
    public void moreEdit(UserGroupEdit userGroupEdit,Integer hospitalId) {
    	SysUserGroup userGroup = new SysUserGroup();
		userGroup.setGroupId(userGroupEdit.getGroupId());
		userGroup.setHospitalId(hospitalId);
		int i=1;
    	for(Integer userId : userGroupEdit.getUserIdList()) {
	    	// userGroup.setUsergroupId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_USER_GROUP));
			userGroup.setUserId(userId);
			userGroup.setSerialNumber(i++);
			sysUserGroupDao.insert(userGroup);
    	}
    }
    /**
     * 编辑用户岗位权限
     * @param req
     */
    @Transactional(rollbackFor=Exception.class)
    public void edit(SysUserGroupEditReq req, SysUser user) {
    	//初始化变量
		//组集合
    	List<Integer> groups = req.getGroups();
    	Integer userId = req.getUserId();
    	Integer hospitalId = user.getHospitalId();
		//机构ID
    	int i = 1;
    	SysUserGroup userGroup = null;

    	//判断用户是否为新增，如果原来有就删除在新增
    	delByUserId(userId);

    	for(Integer groupId : groups) {
    		userGroup = new SysUserGroup();
    		// userGroup.setUsergroupId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_USER_GROUP));
    		userGroup.setUserId(userId);
    		userGroup.setGroupId(groupId);
    		userGroup.setHospitalId(hospitalId);
    		userGroup.setSerialNumber(i++);

    		sysUserGroupDao.insert(userGroup);
    	}
    }

    /**
     * 根据用户id删除岗位
     * @param req
     */
    public void delByUserId(Integer userId){
    	SysUserGroup userGroup = new SysUserGroup();
    	userGroup.setUserId(userId);
    	List<SysUserGroup> ret = sysUserGroupDao.findByEntity(userGroup);
    	if(!ret.isEmpty()) {
    		sysUserGroupDao.delByUserId(userId);
    	}
    }

}
