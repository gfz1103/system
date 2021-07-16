
package com.buit.his.user.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buit.commons.BaseSpringController;
import com.buit.his.user.service.SysUserDeptSer;

import io.swagger.annotations.Api;

/**
 * 系统用户授权科室<br>
 * @author All
 */
@Api(tags="用户与岗位关系")
@Controller
@RequestMapping("/sysuserdept")
public class SysUserDeptCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysUserDeptCtr.class);
    
    @Autowired
    private SysUserDeptSer sysUserDeptSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public PageInfo<SysUserDeptResp> queryPage(SysUserDeptReq sysuserdept,PageQuery page){
//        PageInfo<SysUserDept> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> sysUserDeptSer.findByEntity(sysuserdept)
//            );
//        return pageInfo;
//    }
//    

    
    
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysUserDeptResp> getOneByEntity(SysUserDeptReq sysuserdept){
//        List<SysUserDept> list=sysUserDeptSer.findByEntity(sysuserdept);
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
//    public ReturnEntity<SysUserDeptResp> add(SysUserDeptReq sysUserDept) {
//        sysUserDeptSer.insert(sysUserDept);        
//        return ReturnEntityUtil.success(sysUserDept);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SysUserDeptResp> edit(SysUserDeptReq sysUserDept)  {
//        sysUserDeptSer.update(sysUserDept);        
//        return ReturnEntityUtil.success(sysUserDept);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysUserDeptResp> delete(SysUserDeptReq sysUserDept) {
//        sysUserDeptSer.removeByEntity(sysUserDept);        
//        return ReturnEntityUtil.success(sysUserDept);            
//    }
    
}

