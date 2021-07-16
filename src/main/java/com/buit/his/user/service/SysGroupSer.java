package com.buit.his.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.user.dao.SysGroupDao;
import com.buit.his.user.dao.SysUserGroupDao;
import com.buit.his.user.model.SysGroup;
import com.buit.his.user.model.SysUserGroup;
import com.buit.his.user.request.SysGroupReq;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;

/**
 * 用户组表<br>
 * @author wangyang
 */
@Service
public class SysGroupSer extends BaseManagerImp<SysGroup, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SysGroupSer.class);

	@Autowired
	private SysGroupDao sysGroupDao;
	@Autowired
	private SysUserGroupDao sysUserGroupDao;

	@Autowired
	private RedisFactory redisFactory;

	@Override
	public SysGroupDao getEntityMapper() {
		return sysGroupDao;
	}

	/**
	 * 插入数据
	 */
	public void save(SysGroupReq req) {
		// 岗位代码不为空
		if (req.getGroupCode() == null) {
			throw BaseException.create("ERROR_GROUP_0002");
		}
		// 岗位名称不为空
		if (req.getGroupName() == null) {
			throw BaseException.create("ERROR_GROUP_0003");
		}

		// 复制对象
		SysGroup sysGroup = new SysGroup();
		BeanUtils.copyProperties(req, sysGroup);

		// 机构代码是否已存在
		if (sysGroupDao.isExistGroupCode(sysGroup).intValue() > 0) {
			throw BaseException.create("ERROR_GROUP_0004");
		}
		// 设置拼音、五笔字符
		ChineseCharacterUtil.setPyAndWb(sysGroup, sysGroup.getGroupName());

		// 设置其他参数
		// sysGroup.setGroupId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_GROUP));
		sysGroup.setDataVersion(1);
		sysGroup.setGmtCreate(DateUtil.getCurrentTimestamp());
		sysGroup.setGmtModify(DateUtil.getCurrentTimestamp());
		sysGroup.setStopFlag("0");
		sysGroup.setGroupType("0");

		sysGroupDao.insert(sysGroup);
	}

	/**
	 * 编辑数据
	 */
	public void edit(SysGroupReq req) {
		SysGroup sysGroup = sysGroupDao.getById(req.getGroupId());
		if (sysGroup == null) {
			throw BaseException.create("ERROR_GROUP_0005");
		}

		// 复制对象
		SysGroup sysGroupData = new SysGroup();
		BeanUtils.copyProperties(req, sysGroupData);

		// 机构代码是否已存在
		Integer count = sysGroupDao.isExistGroupCode(sysGroupData);
		if (count.intValue() > 0) {
			throw BaseException.create("ERROR_GROUP_0004");
		}

		// 复制对象
		BeanUtils.copyProperties(req, sysGroup);
		// 设置拼音、五笔字符
		ChineseCharacterUtil.setPyAndWb(sysGroup, sysGroup.getGroupName());
		sysGroup.setGmtModify(DateUtil.getCurrentTimestamp());
		sysGroupDao.update(sysGroup);
	}
	/**
	 * 删除组
	 */
	@Transactional(rollbackFor = Exception.class)
	public void del(Integer groupId) {
		sysGroupDao.deleteById(groupId);
		SysUserGroup sysUserGroup =new SysUserGroup();
		sysUserGroup.setGroupId(groupId);
		sysUserGroupDao.removeByEntity(sysUserGroup);
	}
	
	/**
	 * 验证岗位编码重复
	 * 
	 * @param groupCode
	 * @param hospitalId
	 * @return
	 */
	public boolean validGroupCode(String groupCode, Integer hospitalId) {
		boolean flag = Boolean.TRUE;
		SysGroup sysGroup = new SysGroup();
		sysGroup.setGroupCode(groupCode);
		sysGroup.setHospitalId(hospitalId);
		Integer count = sysGroupDao.isExistGroupCode(sysGroup);
		if (count != null && count.intValue() > 0) {
			flag = Boolean.FALSE;
		}
		return flag;
	}
	
	
}
