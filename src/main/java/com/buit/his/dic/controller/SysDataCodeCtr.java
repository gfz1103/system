
package com.buit.his.dic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.dic.service.SysDataCodeSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 系统数据代码表<br>
 * @author
 */
@Api(tags="系统数据代码表")
@Controller
@RequestMapping("/sysdatacode")
public class SysDataCodeCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysDataCodeCtr.class);
    
    @Autowired
    private SysDataCodeSer sysDataCodeSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public PageInfo<SysDataCodeResp> queryPage(SysDataCodeReq sysdatacode,PageQuery page){
//        PageInfo<SysDataCode> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> sysDataCodeSer.findByEntity(sysdatacode)
//            );
//        return pageInfo;
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SysDataCodeResp>> getByEntity( SysDataCodeReq sysdatacode){//@RequestBody 
//        return ReturnEntityUtil.success(sysDataCodeSer.findByEntity(sysdatacode));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysDataCodeResp> getOneByEntity(SysDataCodeReq sysdatacode){
//        List<SysDataCode> list=sysDataCodeSer.findByEntity(sysdatacode);
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
//    public ReturnEntity<SysDataCodeResp> add(SysDataCodeReq sysDataCode) {
//        sysDataCodeSer.insert(sysDataCode);        
//        return ReturnEntityUtil.success(sysDataCode);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<SysDataCodeResp> edit(SysDataCodeReq sysDataCode)  {
//        sysDataCodeSer.update(sysDataCode);        
//        return ReturnEntityUtil.success(sysDataCode);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysDataCodeResp> delete(SysDataCodeReq sysDataCode) {
//        sysDataCodeSer.removeByEntity(sysDataCode);        
//        return ReturnEntityUtil.success(sysDataCode);            
//    }
    
    
  /** 测试得到编码 */
  @RequestMapping("/test")
  @ResponseBody
  @ApiOperation(value="测试编码生成" ,httpMethod="POST")
  public ReturnEntity<String> delete(@ApiParam(name = "codeId", value = "规则ID", required = true) @RequestParam(value = "codeId") Integer codeId) {
      return ReturnEntityUtil.success(sysDataCodeSer.getSysDataCode(codeId));
  }

    
}

