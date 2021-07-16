
package com.buit.his.sys.adminms.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.adminms.model.SysRourt;
import com.buit.his.sys.adminms.service.SysRourtSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 前台发布端口<br>
 * @author DESKTOP-OK78BUA
 */
@Api(tags="前台发布端口")
@Controller
@RequestMapping("/sysrourt")
public class SysRourtCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysRourtCtr.class);
    
    @Autowired
    private SysRourtSer sysRourtSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<SysRourtResp>> queryPage(SysRourtReq sysrourt,PageQuery page){
//        PageInfo<SysRourt> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> sysRourtSer.findByEntity(sysrourt)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="取当前系统端口" ,httpMethod="POST")
    public ReturnEntity<List<SysRourt>> getByEntity(){//@RequestBody 
        return ReturnEntityUtil.success(sysRourtSer.findByEntity(null));    
    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysRourtResp> getOneByEntity(SysRourtReq sysrourt){
//        List<SysRourt> list=sysRourtSer.findByEntity(sysrourt);
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
//    public ReturnEntity<SysRourtResp> add(SysRourtReq sysRourt) {
//        sysRourtSer.insert(sysRourt);        
//        return ReturnEntityUtil.success(sysRourt);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SysRourtResp> edit(SysRourtReq sysRourt)  {
//        sysRourtSer.update(sysRourt);        
//        return ReturnEntityUtil.success(sysRourt);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysRourtResp> delete(SysRourtReq sysRourt) {
//        sysRourtSer.removeByEntity(sysRourt);        
//        return ReturnEntityUtil.success(sysRourt);            
//    }
    
}

