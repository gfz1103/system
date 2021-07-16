
package com.buit.his.user.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.user.model.SysUserResource;
import com.buit.his.user.request.SysUserResourceReq;
import com.buit.his.user.response.SysUserAddResp;
import com.buit.his.user.service.SysUserResourceSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户与资源对应关系<br>
 * @author All
 */
@Api(tags="用户与资源对应关系")
@Controller
@RequestMapping("/sysuserresource")
public class SysUserResourceCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysUserResourceCtr.class);
    
    @Autowired
    private SysUserResourceSer sysUserResourceSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public PageInfo<SysUserResourceResp> queryPage(SysUserResourceReq sysuserresource,PageQuery page){
//        PageInfo<SysUserResource> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> sysUserResourceSer.findByEntity(sysuserresource)
//            );
//        return pageInfo;
//    }
//    
    
    
    @RequestMapping("/storageHaveList")
    @ResponseBody
    @ApiOperation(value="药库所有已授权用户" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUserAddResp>> storageHaveList(PageQuery page,@ApiParam(name = "resourceId", value = "药库Id", required = true)  @RequestParam(value = "resourceId") Integer resourceId ){//@RequestBody 
        return ReturnEntityUtil.success(this.getUserHaveList( page,resourceId,"5"));    
    }
    @RequestMapping("/serHaveList")
    @ResponseBody
    @ApiOperation(value="服务台所有已授权用户" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUserAddResp>> serHaveList(PageQuery page,@ApiParam(name = "resourceId", value = "服务台Id", required = true)  @RequestParam(value = "resourceId") Integer resourceId ){//@RequestBody 
        return ReturnEntityUtil.success(this.getUserHaveList( page,resourceId,"2"));    
    }
    private PageInfo<SysUserAddResp> getUserHaveList( PageQuery page,Integer resourceId,String aa ){
    	SysUserResource res =new SysUserResource();
    	res.setHospitalId(getUser().getHospitalId());
    	res.setResourceId(resourceId);
//    	  资源权限类别 FD000152  SELECT * FROM SYS_FLAG_DATA_VALUE WHERE FLAGDATA_ID =253
//          0 :医疗机构  ,1 :号表,2 :服务台,3 :科室 ,4 :药房,5 :药库,6 :第三方系统,7 :自定义报表(查询类) 
    	res.setResourceType(aa);
    	PageInfo<SysUserAddResp> pageInfo = PageHelper.startPage(
	            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
	                    () -> sysUserResourceSer.getEntityMapper().getAuthUser(res)
	            );
    	return pageInfo;
    }
    
    @RequestMapping("/storageList")
    @ResponseBody
    @ApiOperation(value="药库所有未授权用户" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUserAddResp>> storageList(PageQuery page,@ApiParam(name = "resourceId", value = "药库Id", required = true)  @RequestParam(value = "resourceId") Integer resourceId ){//@RequestBody 
        return ReturnEntityUtil.success(this.getUserList(page,resourceId,"5"));    
    }
    @RequestMapping("/serList")
    @ResponseBody
    @ApiOperation(value="服务台所有未授权用户" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysUserAddResp>> serList(PageQuery page,@ApiParam(name = "resourceId", value = "服务台Id", required = true)  @RequestParam(value = "resourceId") Integer resourceId ){//@RequestBody 
        return ReturnEntityUtil.success(this.getUserList(page,resourceId,"2"));    
    }
    private PageInfo<SysUserAddResp> getUserList(PageQuery page, Integer resourceId,String aa ){
    	SysUserResource res =new SysUserResource();
    	res.setHospitalId(getUser().getHospitalId());
    	res.setResourceId(resourceId);
//    	  资源权限类别 FD000152  SELECT * FROM SYS_FLAG_DATA_VALUE WHERE FLAGDATA_ID =253
//          0 :医疗机构  ,1 :号表,2 :服务台,3 :科室 ,4 :药房,5 :药库,6 :第三方系统,7 :自定义报表(查询类) 
    	res.setResourceType(aa);
    	PageInfo<SysUserAddResp> pageInfo = PageHelper.startPage(
	            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
	                    () -> sysUserResourceSer.getEntityMapper().getNoAuthUser(res)
	            );
    	return pageInfo;
    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysUserResourceResp> getOneByEntity(SysUserResourceReq sysuserresource){
//        List<SysUserResource> list=sysUserResourceSer.findByEntity(sysuserresource);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<SysUserResourceResp> add(SysUserResourceReq sysUserResource) {
//        sysUserResourceSer.insert(sysUserResource);        
//        return ReturnEntityUtil.success(sysUserResource);            
//    }
    /** 药库权限编辑 */
    @RequestMapping("/storageEdit")
    @ResponseBody
    @ApiOperation(value="药库权限新增" ,httpMethod="POST")
    public ReturnEntity<String> storageEdit(@Valid SysUserResourceReq req)  {
        sysUserResourceSer.edit(req, getUser().getHospitalId(), "5");;        
        return ReturnEntityUtil.success();            
    }
    /** 服务台权限编辑 */
    @RequestMapping("/serEdit")
    @ResponseBody
    @ApiOperation(value="服务台权限新增" ,httpMethod="POST")
    public ReturnEntity<String> serEdit(@Valid SysUserResourceReq req)  {
        sysUserResourceSer.edit(req, getUser().getHospitalId(), "2");;        
        return ReturnEntityUtil.success();            
    }
    
    @RequestMapping("/serDelete")
    @ResponseBody
    @ApiOperation(value="服务台权限删除" ,httpMethod="POST")
    public ReturnEntity<String> serDelete(@Valid SysUserResourceReq req) {
    	SysUserResource res=new SysUserResource();
    	res.setResourceId(req.getResourceId());
    	res.setResourceType("2");
    	for(Integer userId : req.getUserIds()) {
	    	res.setUserId(userId);
	        sysUserResourceSer.removeByEntity(res);  
        }
        return ReturnEntityUtil.success();            
    }
    @RequestMapping("/storageDelete")
    @ResponseBody
    @ApiOperation(value="药库权限删除" ,httpMethod="POST")
    public ReturnEntity<String> storageDelete(@Valid SysUserResourceReq req) {
    	SysUserResource res=new SysUserResource();
    	res.setResourceId(req.getResourceId());
    	res.setResourceType("5");
    	for(Integer userId : req.getUserIds()) {
	    	res.setUserId(userId);
	        sysUserResourceSer.removeByEntity(res);  
        }
        return ReturnEntityUtil.success();            
    }
    
}

