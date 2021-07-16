
package com.buit.his.sys.msg.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.SysUser;
import com.buit.his.sys.msg.response.MessZjlResp;
import com.buit.his.sys.msg.service.MessJsrSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 消息推送-接收人<br>
 * @author 神算子
 */
@Api(tags="消息推送-接收人")
@Controller
@RequestMapping("/messjsr")
public class MessJsrCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MessJsrCtr.class);
    
    @Autowired
    private MessJsrSer messJsrSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<MessJsrResp>> queryPage(MessJsrReq messjsr,PageQuery page){
//        PageInfo<MessJsr> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> messJsrSer.findByEntity(messjsr)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
    
    @RequestMapping("/messList")
    @ResponseBody
    @ApiOperation(value="当前登录用户消息列表" ,httpMethod="POST")
    public ReturnEntity<List<MessZjlResp>> messList(@ApiParam(name = "ksId", value = "科室ID") @RequestParam(value = "ksId",required = false)  Integer ksId){ 
    	SysUser sysUser =getUser();
    	sysUser.setDeptId(ksId);
        return ReturnEntityUtil.success(messJsrSer.messList(sysUser));    
    }
    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MessJsrResp> getOneByEntity(MessJsrReq messjsr){
//        List<MessJsr> list=messJsrSer.findByEntity(messjsr);
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
//    public ReturnEntity<MessJsrResp> add(MessJsrReq messJsr) {
//        messJsrSer.insert(messJsr);        
//        return ReturnEntityUtil.success(messJsr);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<MessJsrResp> edit(MessJsrReq messJsr)  {
//        messJsrSer.update(messJsr);        
//        return ReturnEntityUtil.success(messJsr);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MessJsrResp> delete(MessJsrReq messJsr) {
//        messJsrSer.removeByEntity(messJsr);        
//        return ReturnEntityUtil.success(messJsr);            
//    }
    
}

