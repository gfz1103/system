package com.buit.his.user.service;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.user.dao.SysMenuDao;
import com.buit.his.user.model.SysMenu;
import com.buit.his.user.response.SysMenuSystemResp;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.RedisFactory;

import cn.hutool.core.collection.CollectionUtil;
/**
 * 系统菜单表<br>
 * @author
 */
@Service
public class SysMenuSer extends BaseManagerImp<SysMenu,Integer> {

    static final Logger logger = LoggerFactory.getLogger(SysMenuSer.class);

    @Autowired
    private SysMenuDao sysMenuDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public SysMenuDao getEntityMapper(){
        return sysMenuDao;
    }

    public void save(SysMenu sysMenu) {
    	if(sysMenu.getParentMenuId()==null) {
    		sysMenu.setParentMenuId(0);
    	}
//		checkRouteName(sysMenu);
    	sysMenu.setGmtModify(new Timestamp(System.currentTimeMillis()));
    	sysMenu.setGmtCreate(new Timestamp(System.currentTimeMillis()));
    	// sysMenu.setMenuId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_MENU));
    	
//    	StringBuffer sb = new StringBuffer("-");
    	//循环取所有父节点
//    	while (!parentMenuId.equals(0)) {
//    		SysMenu f=sysMenuDao.getById(parentMenuId);
//    		sb.append(f.getRouteName()).append("-");
//    		parentMenuId=f.getParentMenuId();
//		}
    	
    	if(sysMenu.getModelTypeFlag().equals("3")||sysMenu.getModelTypeFlag().equals("4")) {//3按钮,4页面
    		Integer parentMenuId=sysMenu.getParentMenuId();
    		SysMenu f=sysMenuDao.getById(parentMenuId);
    		sysMenu.setFatherRouteName(f.getMenuUrl());	
    	}
    	ChineseCharacterUtil.setPyAndWb(sysMenu,sysMenu.getMenuName());
    	sysMenuDao.insert(sysMenu);
    	if(sysMenu.getModelTypeFlag().equals("1")&&StringUtils.isNotEmpty(sysMenu.getMenuUrl())) {//1:菜单 
    		//查找下面的按钮和页面
    		SysMenu parentMenu= new SysMenu();
    		parentMenu.setParentMenuId(sysMenu.getMenuId());
    		parentMenu.setModelTypeFlag("4");
    		parentMenu.setMenuUrl(sysMenu.getMenuUrl());
    		int page=sysMenuDao.updateSonParentId(parentMenu);
    		if(page==0) {
    			parentMenu.setModelTypeFlag("3");
        		sysMenuDao.updateSonParentId(parentMenu);
    		}
    	}
    }


//    private void checkRouteName(SysMenu sysMenu  ){
////    	1:菜单,2报表,3按钮,4页面
//    	String type="1";
//    	SysMenu que=new SysMenu();
//		que.setExtMenuId(sysMenu.getMenuId());
//		que.setRouteName(sysMenu.getRouteName());
//		if(sysMenu.getModelTypeFlag().equals(type)) {
//			que.setModelTypeFlag(sysMenu.getModelTypeFlag());
//		}else {
//			que.setParentMenuId(sysMenu.getParentMenuId());
//		}
//		if(sysMenuDao.findByEntityCount(que)>0) {
//			//根据路由名 判断重复
//			throw BaseException.create("ERROR_USER_0010");
//		}
//	}

    /**
     * 循环查询 子节点数量
     */
    public void isHaveSon(List<SysMenu> menuList) {
    	if (menuList ==null){
			return ;
		}
    	SysMenu queMenu=new SysMenu ();
    	for (SysMenu sysMenu : menuList) {
    		queMenu.setParentMenuId(sysMenu.getMenuId());
    		sysMenu.setCountSon(sysMenuDao.findByEntityCount(queMenu));
		}
    }

	/**
	 * 获取系统菜单列表（递归调用）
	 * @param parentMenuId
	 * @param groupId
	 * @return
	 */
	public List<SysMenu> selectMenuList(Integer parentMenuId,Integer groupId) {
		List<SysMenu> resultList = sysMenuDao.getMenuListByGroupId(parentMenuId,groupId);
		if (resultList != null) {
			for (SysMenu item : resultList) {
				List<SysMenu> childMenuList = selectMenuList(item.getMenuId(),groupId);
				if (childMenuList != null) {
					item.setChildMenuList(childMenuList);
				}
			}
		}
		return resultList;
	}

	public void edit(SysMenu sysMenu) {
//		checkRouteName(sysMenu);
//		Integer parentMenuId=sysMenu.getParentMenuId();
//    	StringBuffer sb = new StringBuffer("-");
    	//循环取所有父节点
//    	while (!parentMenuId.equals(0)) {
//    		SysMenu f=sysMenuDao.getById(parentMenuId);
//    		sb.append(f.getRouteName()).append("-");
//    		parentMenuId=f.getParentMenuId();
//		}
//    	sysMenu.setFatherRouteName(sb.substring(1)+sysMenu.getRouteName());
		SysMenu menuold= sysMenuDao.getById(sysMenu.getMenuId());
    	if(sysMenu.getModelTypeFlag().equals("3")||sysMenu.getModelTypeFlag().equals("4")) {//3按钮,4页面
    		Integer parentMenuId=sysMenu.getParentMenuId();
    		SysMenu f=sysMenuDao.getById(parentMenuId);
    		sysMenu.setFatherRouteName(f.getMenuUrl());	
    	}
		sysMenu.setGmtModify(new Timestamp(System.currentTimeMillis()));
		sysMenuDao.update(sysMenu);
		if(sysMenu.getModelTypeFlag().equals("1")&&StringUtils.isNotEmpty(sysMenu.getMenuUrl())) {//1:菜单 
			if(!sysMenu.getMenuUrl().equals(menuold.getMenuUrl())) {
				//查找下面的按钮和页面
	    		SysMenu parentMenu= new SysMenu();
	    		parentMenu.setParentMenuId(sysMenu.getMenuId());
	    		parentMenu.setModelTypeFlag("4");
	    		parentMenu.setMenuUrl(sysMenu.getMenuUrl());
	    		int page=sysMenuDao.updateSonParentId(parentMenu);
	    		if(page==0) {
	    			parentMenu.setModelTypeFlag("3");
	        		sysMenuDao.updateSonParentId(parentMenu);
	    		}
			}
    	}
	}
	public List<SysMenuSystemResp> getAllSystem() {
		SysMenu queMenu=new SysMenu ();
		 List<String> allSystemList = sysMenuDao.getAllSystem();
		 List<SysMenuSystemResp>  req =new ArrayList<SysMenuSystemResp>();
		 if(CollectionUtil.isNotEmpty(allSystemList)) {
			 
			 for (String systemName : allSystemList) {
				 SysMenuSystemResp sysMenuSystemResp=new SysMenuSystemResp();
				 sysMenuSystemResp.setSystemName(systemName);
				 queMenu.setSystemName(systemName);
				 sysMenuSystemResp.setMenuList(sysMenuDao.findByEntity(queMenu));
				 req.add(sysMenuSystemResp);
			}
			return req;
		 }
		 return null;
	}
}
