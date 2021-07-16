
package com.buit.his.user.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.user.model.SysGroupMenu;
import com.buit.his.user.model.SysMenuSelected;
import com.buit.his.user.request.SysGroupMenuReq;
import com.buit.his.user.response.SysGroupMenuResp;
import com.buit.his.user.service.SysGroupMenuSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户组菜单授权表<br>
 * @author 
 */
@Api(tags = "用户组菜单授权表")
@Controller
@RequestMapping("/sys/sysgroupmenu")
public class SysGroupMenuCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SysGroupMenuCtr.class);

	@Autowired
	private SysGroupMenuSer sysGroupMenuSer;

	@RequestMapping("/findList")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "查询系统菜单", httpMethod = "POST", notes = "查询对应医疗机构下的所有系统菜单")
	public ReturnEntity<List<SysMenuSelected>> getByEntity() {
		ReturnEntity<List<SysMenuSelected>> returnEntity = new ReturnEntity<>();
		SysMenuSelected sysAuthorities = new SysMenuSelected();
		sysAuthorities.setMenuId(0);
		sysAuthorities.setHospitalId(getUser().getHospitalId());
		List<SysMenuSelected> sysMenuEntity = sysGroupMenuSer.selectMenuList(sysAuthorities);
		returnEntity.setData(sysMenuEntity);
		return returnEntity;
	}

	@RequestMapping("/getOneByEntity")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据岗位ID获取岗位已选权限", httpMethod = "POST", notes = "根据岗位ID获取对应菜单权限")
	public ReturnEntity<List<SysGroupMenu>> getOneByEntity(
			@ApiParam(name = "groupId", value = "用户组ID", required = true) @RequestParam(value = "groupId") Integer groupId) {// @RequestBody
		SysGroupMenuReq sysgroupmenu = new SysGroupMenuReq();
		sysgroupmenu.setGroupId(groupId);
		sysgroupmenu.setHospitalId(getUser().getHospitalId());
		return ReturnEntityUtil.success(sysGroupMenuSer.findByEntity(sysgroupmenu));
	}

	/** 编辑 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "根据岗位ID修改菜单权限", httpMethod = "POST", notes = "修改岗位对应的权限菜单")
	public ReturnEntity<SysGroupMenuResp> edit(
			@ApiParam(name = "menuIds", value = "菜单ID字符串，以逗号分隔", required = true) @RequestParam(value = "menuIds") String menuIds,
			@ApiParam(name = "groupId", value = "岗位ID", required = true) @RequestParam(value = "groupId") Integer groupId) {
		sysGroupMenuSer.edit(getUser().getHospitalId(), groupId, menuIds);
		return ReturnEntityUtil.success();
	}

//    
//	@RequestMapping("/getOneByEntity")
//	@ResponseBody
//	@ApiOperation(value = "按条件查询-返回唯一值", httpMethod = "POST")
//	public ReturnEntity<List<SysMenu>> getOneByEntity(
//			@ApiParam(name = "groupId", value = "用户组ID", required = true) @RequestParam(value = "groupId") Integer groupId
//			) {
//		ReturnEntity<List<SysMenu>> ReturnEntity <String> = new ReturnEntity<>();
//        SysMenu sysAuthorities = new SysMenu();
//        sysAuthorities.setMenuId(0);
//        sysAuthorities.setHospitalId(getUser().getHospitalId());
//        List<SysMenu> sysMenuEntity= sysGroupMenuSer.selectMenuList(sysAuthorities,groupId);//递归调用
//        returnEntity.setData(sysMenuEntity);
//        return returnEntity;
//	}

//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<SysGroupMenuResp> add(SysGroupMenuReq sysGroupMenu) {
//        sysGroupMenuSer.insert(sysGroupMenu);        
//        return ReturnEntityUtil.success(sysGroupMenu);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SysGroupMenuResp> edit(SysGroupMenuReq sysGroupMenu)  {
//        sysGroupMenuSer.update(sysGroupMenu);        
//        return ReturnEntityUtil.success(sysGroupMenu);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysGroupMenuResp> delete(SysGroupMenuReq sysGroupMenu) {
//        sysGroupMenuSer.removeByEntity(sysGroupMenu);        
//        return ReturnEntityUtil.success(sysGroupMenu);            
//    }

}
