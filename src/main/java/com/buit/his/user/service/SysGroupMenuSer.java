package com.buit.his.user.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.user.dao.SysGroupMenuDao;
import com.buit.his.user.dao.SysMenuSelectedDao;
import com.buit.his.user.dao.SysUserMenuDao;
import com.buit.his.user.model.SysGroupMenu;
import com.buit.his.user.model.SysMenuSelected;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;

/**
 * 用户组菜单授权表<br>
 * @author
 */
@Service
public class SysGroupMenuSer extends BaseManagerImp<SysGroupMenu, Integer> {

	static final Logger logger = LoggerFactory.getLogger(SysGroupMenuSer.class);

	@Autowired
	private SysGroupMenuDao sysGroupMenuDao;
	@Autowired
	private SysUserMenuDao sysUserMenuDao;

	@Autowired
	private SysMenuSelectedDao sysMenuSelectedDao;

	@Autowired
	private RedisFactory redisFactory;

	@Override
	public SysGroupMenuDao getEntityMapper() {
		return sysGroupMenuDao;
	}

	/**
	 * 获取系统菜单列表（递归调用）
	 * 
	 * @param info
	 * @return
	 */
	public List<SysMenuSelected> selectMenuList(SysMenuSelected info) {
		SysMenuSelected condition = new SysMenuSelected();
		condition.setParentMenuId(info.getMenuId());
		condition.setHospitalId(info.getHospitalId());
		condition.setSortColumns("MENU_SORT asc");
		List<SysMenuSelected> resultList = sysMenuSelectedDao.findByEntity(condition);
		if (resultList != null) {
			for (SysMenuSelected item : resultList) {
				List<SysMenuSelected> childMenuList = selectMenuList(item);
				if (childMenuList != null) {
					item.setChildMenuList(childMenuList);
				}
			}
		}
		return resultList;
	}

	/**
	 * 根据岗位ID修改菜单权限
	 */
	@Transactional(rollbackFor = Exception.class)
	public void edit(Integer hospitalId, Integer groupId, String menuIds) {
		if (menuIds == null) {
			throw BaseException.create("ERROR_GROUP_0006");
		}
		if (groupId == null) {
			throw BaseException.create("ERROR_GROUP_0007");
		}

		if (!"".equals(menuIds) && menuIds != null) {
			// 删除岗位对应所有菜单
			SysGroupMenu sgm = new SysGroupMenu();
			sgm.setHospitalId(hospitalId);
			sgm.setGroupId(groupId);
			getEntityMapper().removeByEntity(sgm);
			// 循环插入岗位
			String[] menuIdIndex = menuIds.split(",");
			for (String menuId : menuIdIndex) {
				SysGroupMenu sysGroupMenu = new SysGroupMenu();
				sysGroupMenu.setHospitalId(hospitalId);
				sysGroupMenu.setGroupId(groupId);
				sysGroupMenu.setMenuId(Integer.valueOf(menuId));
				// sysGroupMenu.setGroupmenuId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_GROUP_MENU));
				sysGroupMenu.setGmtCreate(DateUtil.getCurrentTimestamp());
				sysGroupMenu.setGmtModify(DateUtil.getCurrentTimestamp());
				getEntityMapper().insert(sysGroupMenu);
			}
		}
		sysUserMenuDao.deleteByGroupId(groupId);
	}

}
