
package com.buit.his.user.controller;

import java.sql.Timestamp;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.constans.TableName;
import com.buit.his.user.model.SysMenu;
import com.buit.his.user.model.SysUserMenu;
import com.buit.his.user.service.SysUserMenuSer;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户快捷菜单<br>
 * @author
 */
@Api(tags="用户快捷菜单")
@Controller
@RequestMapping("/sysusermenu")
public class SysUserMenuCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysUserMenuCtr.class);
    
    @Autowired
    private SysUserMenuSer sysUserMenuSer;
    @Autowired
	private RedisFactory redisFactory;

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="取所有快捷键" ,notes = "取当前登录用户的所有快捷键",httpMethod="POST")
    public ReturnEntity<List<SysMenu>> getByEntity( ){
        return ReturnEntityUtil.success(sysUserMenuSer.getEntityMapper().getAllMenu(getUser().getUserId(),getUser().getGroupId()));    
    }

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增快捷键" ,httpMethod="POST")
    public ReturnEntity<SysUserMenu> add(@ApiParam(name = "menuId", value = "菜单ID" ,required = true) @RequestParam(value = "menuId")  Integer menuId) {
    	SysUserMenu sysUserMenu =new SysUserMenu();
    	sysUserMenu.setUserId(getUser().getUserId());
    	sysUserMenu.setMenuId(menuId);
    	sysUserMenu.setGroupId(getUser().getGroupId());
    	sysUserMenu.setGmtCreate(new Timestamp(System.currentTimeMillis()));
    	// sysUserMenu.setUsermenuId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_USER_MENU));
    	sysUserMenuSer.removeByEntity(sysUserMenu);   
    	sysUserMenuSer.insert(sysUserMenu);        
        return ReturnEntityUtil.success(sysUserMenu);            
    }

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除快捷键" ,httpMethod="POST")
    public ReturnEntity<String> delete(@ApiParam(name = "menuId", value = "菜单ID" ,required = true) @RequestParam(value = "menuId")  Integer menuId) {
    	SysUserMenu sysUserMenu =new SysUserMenu();
    	sysUserMenu.setUserId(getUser().getUserId());
    	sysUserMenu.setMenuId(menuId);
    	sysUserMenu.setGroupId(getUser().getGroupId());
    	sysUserMenuSer.removeByEntity(sysUserMenu);         
        return ReturnEntityUtil.success();            
    }
    
}

