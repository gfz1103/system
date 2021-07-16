
package com.buit.his.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.user.model.SysMenu;
import com.buit.his.user.response.SysMenuSystemResp;
import com.buit.his.user.service.SysMenuSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 系统菜单表<br>
 * @author 
 */
@Api(tags="菜单设置")
@Controller
@RequestMapping("/sysmenu")
public class SysMenuCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysMenuCtr.class);
    
    @Autowired
    private SysMenuSer sysMenuSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="列表分页查询" ,httpMethod="POST", notes="第一级目录:parentMenuId=0")
    public ReturnEntity<PageInfo<SysMenu>> queryPage(PageQuery page){
    	SysMenu sysmenu=new SysMenu ();
    	sysmenu.setParentMenuId(0);
    	sysmenu.setSortColumns("MENU_SORT asc");
        PageInfo<SysMenu> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> sysMenuSer.findByEntity(sysmenu)
            );
        sysMenuSer.isHaveSon(pageInfo.getList());
        return ReturnEntityUtil.success(pageInfo);
    }
    
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
    public ReturnEntity<List<SysMenu>> getByEntity(SysMenu sysmenu){
        sysmenu.setSortColumns("MENU_SORT asc");
    	List<SysMenu> menuList=sysMenuSer.findByEntity(sysmenu);
    	sysMenuSer.isHaveSon(menuList);
        return ReturnEntityUtil.success(menuList);    
    }
    @RequestMapping("/getOneByEntity")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="按menuId查询菜单" ,httpMethod="POST")
    public ReturnEntity<SysMenu> getOneByEntity(@ApiParam(name = "menuId", value = "菜单ID", required = true) @RequestParam(value = "menuId") Integer menuId){
    	SysMenu sysMenu =new SysMenu();
    	sysMenu.setMenuId(menuId);
        List<SysMenu> list=sysMenuSer.findByEntity(sysMenu);
        if(list.size()>0){
           return ReturnEntityUtil.success(list.get(0));    
        }
        return ReturnEntityUtil.success();
    }
    
    /** 新增 */
    @PostMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<SysMenu> add(SysMenu sysMenu) {
    	sysMenu.setHospitalId(getUser().getHospitalId());
        sysMenuSer.save(sysMenu);        
        return ReturnEntityUtil.success(sysMenu);            
    }
    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<SysMenu> edit(SysMenu sysMenu)  {
        sysMenuSer.edit(sysMenu);
        return ReturnEntityUtil.success();
    }
    
    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="根据menuId删除" ,httpMethod="POST")
    public ReturnEntity<SysMenu> delete(@ApiParam(name = "menuId", value = "菜单ID", required = true) @RequestParam(value = "menuId") Integer menuId) {
    	SysMenu que=new SysMenu();
    	que.setParentMenuId(menuId);
    	//为了实现菜单 可以自由调整等级
    	//菜单 下面的按钮和页面 会根据 url自动挂载 
//    	if(sysMenuSer.getEntityMapper().findByEntityCount(que)>0) {
//    		return ReturnEntityUtil.error("ERROR_USER_0011");
//    	}
        sysMenuSer.removeById(menuId);        
        return ReturnEntityUtil.success();            
    }
    
    
    /** 菜单停用 */
    @RequestMapping("/upDisplayFlag")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="菜单停用" ,httpMethod="POST")
    public ReturnEntity<String> upDisplayFlag(@ApiParam(name = "menuId", value = "菜单ID", required = true) @RequestParam(value = "menuId") Integer menuId ,
    		@ApiParam(name = "displayFlag", value = "显示标识 字典 SYS_FLAG_DATA: =11", required = true) @RequestParam(value = "displayFlag") String displayFlag
    		)  {
    	SysMenu sysMenu=new SysMenu();
    	sysMenu.setMenuId(menuId);
    	sysMenu.setDisplayFlag(displayFlag);
        sysMenuSer.getEntityMapper().updateDisplayFlag(sysMenu);        
        return ReturnEntityUtil.success();            
    }
    
	@RequestMapping("/getMenuListByGId")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "获取当前用户菜单权限", httpMethod = "POST")
	public ReturnEntity<List<SysMenu>> getMenuListByGroupId() {
		List<SysMenu> list = sysMenuSer.selectMenuList(0,getUser().getGroupId());
//		logger.info("用户组ID====================="+getUser().getGroupId());
		return ReturnEntityUtil.success(list);
	}
	/**
	 * 取排序最大值
	 */
    @PostMapping("/getMaxSort")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="取排序最大值" ,httpMethod="POST")
    public ReturnEntity<Long> getMaxSort() {
    	Long maxSort= sysMenuSer.getEntityMapper().getMaxSort();    
    	if(maxSort==null) {
    		maxSort=0L;
    	}
    	maxSort=maxSort+1;
        return ReturnEntityUtil.success(maxSort);            
    }
    @PostMapping("/getAllMenu")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="所有可见按钮列表" ,notes = "取当前用户所有可见的按钮列表",httpMethod="POST")
    public ReturnEntity<List<String>> getAllMenu() {
    	List<String> ret=sysMenuSer.getEntityMapper().getAllMenu(getUser().getGroupId());
        return ReturnEntityUtil.success(ret);            
    }  
    @PostMapping("/getAllSystem")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="按系统名取菜单" ,httpMethod="POST")
    public ReturnEntity<List<SysMenuSystemResp>> getAllSystem() {
    	return ReturnEntityUtil.success(sysMenuSer.getAllSystem());            
    }


    @PostMapping("/getUrlByRoute")
    @ResponseBody
    @ApiOperation(value="根据路由获取URL" ,httpMethod="POST")
    public ReturnEntity<String> getRoute(@ApiParam(name = "routeName", value = "动态路由", required = true) @RequestParam(value = "routeName") String routeName) {
        return ReturnEntityUtil.success(sysMenuSer.getEntityMapper().queryUrlByRoute(routeName));
    }

}

