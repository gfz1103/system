
package com.buit.his.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.his.user.response.DicResp;
import com.buit.his.user.response.SysUserAddResp;
import com.buit.his.user.service.SysUserSer;
import com.buit.utill.PinyinUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.buit.utill.WubiUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 系统用户表<br>
 * @author All
 */
@Api(tags="用户设置")
@Controller
@RequestMapping("/sysuser")
public class SysUserCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysUserCtr.class);
    
    @Autowired
    private SysUserSer sysUserSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="查询本院所有员工-分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUser>> queryPage(@ApiParam(name = "userName", value = "查询条件-姓名") @RequestParam(value = "userName",required = false)  String userName,PageQuery page){
		PageInfo<SysUser> pageInfo = sysUserSer.page(getUser(),userName,page);
        return ReturnEntityUtil.success(pageInfo);
    }
	  /** 修改密码 */
	  @RequestMapping("/updataPassWord")
	  @ResponseBody
	  @ApiOperationSupport(author = "神算子")
	  @ApiOperation(value="修改密码" ,httpMethod="POST",notes  ="用户修改自己密码")
	  public ReturnEntity<String> updataPassWord(@ApiParam(name = "oldpw", value = "老密码") @RequestParam(value = "oldpw")  String oldpw,
			  @ApiParam(name = "newpw", value = "新密码") @RequestParam(value = "newpw")  String newpw)  {
	      return  sysUserSer.updatePasswd(getUser().getUserId(), oldpw,newpw);            
	  }
	  /** 密码重置 */
	  @RequestMapping("/resetPassWord")
	  @ResponseBody
	  @ApiOperationSupport(author = "神算子")
	  @ApiOperation(value="密码重置" ,httpMethod="POST",notes  ="管理员 重置某人密码")
	  public ReturnEntity<String> resetPassWord(@ApiParam(name = "userId", value = "用户Id") @RequestParam(value = "userId")  Integer userId,
			  @ApiParam(name = "loginName", value = "登录名") @RequestParam(value = "loginName")  String loginName)  {
		  sysUserSer.updatePasswd(userId, loginName);        
	      return ReturnEntityUtil.success();            
	  }
	  
	  /** 锁定用户 */
	  @RequestMapping("/lockUser")
	  @ResponseBody
	  @ApiOperationSupport(author = "神算子")
	  @ApiOperation(value="锁定用户" ,httpMethod="POST",notes  ="管理员 锁定用户,用户无法登录")
	  public ReturnEntity<String> lockUser(@ApiParam(name = "userId", value = "用户Id") @RequestParam(value = "userId")  Integer userId)  {
		  sysUserSer.getEntityMapper().lockUser(userId);      
	      return ReturnEntityUtil.success();            
	  }

	  /** 解锁用户 */
	  @RequestMapping("/unlockUser")
	  @ResponseBody
	  @ApiOperationSupport(author = "神算子")
	  @ApiOperation(value="解锁用户" ,httpMethod="POST",notes  ="管理员 解锁用户")
	  public ReturnEntity<String> unlockUser(@ApiParam(name = "userId", value = "用户Id") @RequestParam(value = "userId")  Integer userId)  {
		  sysUserSer.getEntityMapper().unlockUser(userId);
	      return ReturnEntityUtil.success();
	  }

    
    @RequestMapping("/haveListByGroupId")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="已授权列表", notes = "根据GroupId查询已授权用户" ,httpMethod="POST")
    public ReturnEntity<List<SysUserAddResp>> haveListByGroupId(@ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId,
    		@ApiParam(name = "queryName", value = "查询条件") @RequestParam(value = "queryName",required = false)  String queryName){ 
        return ReturnEntityUtil.success(sysUserSer.getEntityMapper().haveListByGroupId(groupId,queryName,getUser().getHospitalId()));    
    }
    
    @RequestMapping("/noListByGroupId")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="未授权列表", notes = "根据GroupId查询未授权用户" ,httpMethod="POST")
    public ReturnEntity<List<SysUserAddResp>> getListByGroupId(@ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId,
    		@ApiParam(name = "queryName", value = "查询条件") @RequestParam(value = "queryName",required = false)  String queryName){ 
    	return ReturnEntityUtil.success(sysUserSer.getEntityMapper().noListByGroupId(groupId,queryName,getUser().getHospitalId()));    
    }
    
    
    
    @RequestMapping("/haveListByGroupIdPage")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="已授权列表-分页", notes = "根据GroupId查询已授权用户" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUserAddResp>> haveListByGroupIdPage(PageQuery page,@ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId,
    		@ApiParam(name = "queryName", value = "查询条件") @RequestParam(value = "queryName",required = false)  String queryName){ 
    	PageInfo<SysUserAddResp> pageInfo = PageHelper.startPage(
    	            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
    	                    () -> sysUserSer.getEntityMapper().haveListByGroupId(groupId,queryName,getUser().getHospitalId())
    	            );
    	
        return ReturnEntityUtil.success(pageInfo);    
    }
    
    @RequestMapping("/noListByGroupIdPage")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="未授权列表-分页", notes = "根据GroupId查询未授权用户" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUserAddResp>> getListByGroupIdPage(PageQuery page,@ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId,
    		@ApiParam(name = "queryName", value = "查询条件") @RequestParam(value = "queryName",required = false)  String queryName){ 
    	PageInfo<SysUserAddResp> pageInfo = PageHelper.startPage(
	            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
	                    () -> sysUserSer.getEntityMapper().noListByGroupId(groupId,queryName,getUser().getHospitalId())
	            );
    	return ReturnEntityUtil.success(pageInfo);    
    }
    
    
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysUserResp> getOneByEntity(SysUserReq sysuser){
//        List<SysUser> list=sysUserSer.findByEntity(sysuser);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<SysUser> add(SysUser sysUser) {
    	sysUser.setHospitalId(getUser().getHospitalId());
        return sysUserSer.add(sysUser);            
    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SysUserResp> edit(SysUserReq sysUser)  {
//        sysUserSer.update(sysUser);        
//        return ReturnEntityUtil.success(sysUser);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysUserResp> delete(SysUserReq sysUser) {
//        sysUserSer.removeByEntity(sysUser);        
//        return ReturnEntityUtil.success(sysUser);            
//    }
    
  /** 登录
   * 选择医院和角色后的 登录
   * */
  @RequestMapping("/submitUser")
  @ResponseBody
  @ApiOperation(value="提交登录信息" ,httpMethod="POST",notes = "登录界面,选择医院和角色后 提交信息,并进入主页 ")
  @ApiOperationSupport(author = "神算子")
  public ReturnEntity<SysUser> submitUser(@ApiParam(name = "hospitalId", value = "医院ID", required = true) @RequestParam(value = "hospitalId")  Integer hospitalId,
		  @ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId, HttpServletRequest request) {
	  SysUser sysUser =getUser();
	  sysUser.setHospitalId(hospitalId);
	  sysUser.setGroupId(groupId);
	  sysUserSer.updataSession(sysUser);
      return ReturnEntityUtil.success(sysUser);            
  }
  /** 
   * 切换业务权限时使用
   * */
  @RequestMapping("/changeBid")
  @ResponseBody
  @ApiOperation(value="切换业务权限时使用" ,httpMethod="POST")
  @ApiOperationSupport(author = "神算子")
  public ReturnEntity<SysUser> changeBid(@ApiParam(name = "ksdm", value = "业务权限代码", required = true) @RequestParam(value = "ksdm")  Integer ksdm,
		  @ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId, HttpServletRequest request) {
	  SysUser sysUser =getUser();
	  sysUserSer.changeBid(sysUser,groupId,ksdm);
      return ReturnEntityUtil.success(sysUser);            
  }
  
  /** 
   * 公用拼音五笔码转换方法
   * */
  @RequestMapping("/pywbTool")
  @ResponseBody
  @ApiOperation(value="拼音五笔工具" ,httpMethod="POST",notes = "公用拼音五笔码转换方法 ")
  @ApiOperationSupport(author = "神算子")
  public ReturnEntity<Map<String,String>> pywbTool(@ApiParam(name = "word", value = "文字", required = true) @RequestParam(value = "word")  String word) {
	  Map<String,String> ret=new HashMap<>(3);
	  ret.put("pinyin", PinyinUtils.getSimplePinYin(word));
	  ret.put("wubi",WubiUtils.getSimpleWuBi(word));
	  return ReturnEntityUtil.success(ret);            
  }
  
	@RequestMapping("/findList")
	@ResponseBody
	@ApiOperation(value="返回所有用户" ,httpMethod="POST")
	public ReturnEntity<List<SysUserAddResp>> getByEntity( SysUser sysuser){
		//用户授权设置 当前医院所有用户
		sysuser.setHospitalId(getUser().getHospitalId());
	    return ReturnEntityUtil.success(sysUserSer.getEntityMapper().getallUser(sysuser));    
	}

	/**
	 * 获取岗位用户列表字典
	 * @param
	 * @return
	 */
	@RequestMapping("/findGroupUserDic")
	@ResponseBody
	@ApiOperation(value="获取岗位用户列表字典" ,httpMethod="POST")
	public ReturnEntity<List<DicResp>> findGroupUserDic(@ApiParam(name = "groupId", value = "组Id", required = true) @RequestParam(value = "groupId")  Integer groupId){
		//用户授权设置 当前医院所有用户
		SysUser sysuser=new SysUser();
		sysuser.setHospitalId(getUser().getHospitalId());
		sysuser.setGroupId(groupId);
		return ReturnEntityUtil.success(sysUserSer.findGroupUserDic(sysuser));
	}
}

