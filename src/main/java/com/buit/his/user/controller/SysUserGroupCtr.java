
package com.buit.his.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.buit.commons.SysUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.user.model.SysGroup;
import com.buit.his.user.model.SysUserGroup;
import com.buit.his.user.request.SysUserGroupEditReq;
import com.buit.his.user.request.UserGroupEdit;
import com.buit.his.user.service.SysUserGroupSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 系统用户与用户组对照表<br>
 * @author All
 */
@Api(tags = "用户组关联岗位")
@Controller
@RequestMapping("/sysusergroup")
public class SysUserGroupCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SysUserGroupCtr.class);

	@Autowired
	private SysUserGroupSer sysUserGroupSer;

    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="用户新增权限" ,httpMethod="POST")
    public ReturnEntity<String> add(@Valid UserGroupEdit userGroupEdit) {
        sysUserGroupSer.moreEdit(userGroupEdit, getUser().getHospitalId());    
        return ReturnEntityUtil.success();            
    }

	/** 编辑用户岗位 */
	@RequestMapping("/editUserGroup")
	@ResponseBody
	@ApiOperationSupport(author = "老花生")
	@ApiOperation(value = "编辑用户岗位", httpMethod = "POST")
	public ReturnEntity<String> editUserGroup(@Valid SysUserGroupEditReq req) {
		sysUserGroupSer.edit(req, getUser());
		return ReturnEntityUtil.success();
	}

    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="用户删除权限" ,httpMethod="POST")
    public ReturnEntity<String> delete(@Valid UserGroupEdit userGroupEdit) {
    	SysUserGroup sysUserGroup =new SysUserGroup();
    	sysUserGroup.setGroupId(userGroupEdit.getGroupId());
    	for(Integer userId : userGroupEdit.getUserIdList()) {
	    	sysUserGroup.setUserId(userId);
	        sysUserGroupSer.removeByEntity(sysUserGroup);        
    	}
        return ReturnEntityUtil.success();            
    }

	@RequestMapping("/loginGroup")
	@ResponseBody
	@ApiOperation(value = "根据医院ID取角色", httpMethod = "POST")
	@ApiOperationSupport(author = "神算子")
	public ReturnEntity<List<SysGroup>> loginGroup(
			@ApiParam(name = "hospitalId", value = "医院ID", required = true) @RequestParam(value = "hospitalId") Integer hospitalId) {
		SysUserGroup sysUserGroup = new SysUserGroup();
		sysUserGroup.setHospitalId(hospitalId);
		sysUserGroup.setUserId(getUser().getUserId());
		return ReturnEntityUtil.success(sysUserGroupSer.getEntityMapper().getGroupDic(sysUserGroup));
	}

//	@RequestMapping("/batchEdit")
//	@ResponseBody
//	@ApiOperationSupport(author = "神算子")
//	@ApiOperation(value = "权限与用户的批量关联", httpMethod = "POST")
//	public ReturnEntity<String> batchEdit(UserGroupEdit userGroupEdit) {
//		sysUserGroupSer.batchEdit(userGroupEdit, getUser());
//		return ReturnEntityUtil.success();
//	}

	@RequestMapping("/haveGroup")
	@ResponseBody
	@ApiOperation(value = "用户所拥有的组", httpMethod = "POST")
	public ReturnEntity<List<SysUserGroup>> haveGroup(@ApiParam(name = "userId", value = "用户ID", required = true) @RequestParam(value = "userId") Integer userId) {// @RequestBody
		SysUserGroup sysUserGroup =new SysUserGroup();
		sysUserGroup.setUserId(userId);
		return ReturnEntityUtil.success(sysUserGroupSer.findByEntity(sysUserGroup));
	}
	
  @RequestMapping("/findCont")
  @ResponseBody
  @ApiOperation(value="岗位关联用户数量" ,httpMethod="POST")
  public ReturnEntity<Long> findCont(@ApiParam(name = "groupId", value = "组ID", required = true) @RequestParam(value = "groupId") Integer groupId){
	  SysUserGroup sysUserGroup =new SysUserGroup();
	  sysUserGroup.setGroupId(groupId);
	  return ReturnEntityUtil.success(sysUserGroupSer.getEntityMapper().findByEntityCount(sysUserGroup));    
  }

	@RequestMapping("/checkHavaGroup")
	@ResponseBody
	@ApiOperation(value = "判断用户是否有该角色权限", httpMethod = "POST")
	public ReturnEntity<Boolean> checkHavaGroup(
			@ApiParam(name = "groupId", value = "组ID", required = true) @RequestParam(value = "groupId") Integer groupId) {
		SysUser user = getUser();
		return ReturnEntityUtil.success(sysUserGroupSer.getEntityMapper().checkHavaGroup(user.getUserId(), groupId, user.getHospitalId()) > 0);
	}

}
