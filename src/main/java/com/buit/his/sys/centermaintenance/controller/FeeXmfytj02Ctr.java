
package com.buit.his.sys.centermaintenance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.service.FeeXmfytj02Ser;

import io.swagger.annotations.Api;

/**
 * <br>
 * @author GONGFANGZHOU
 */
@Api(tags="")
@Controller
@RequestMapping("/feexmfytj02")
public class FeeXmfytj02Ctr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(FeeXmfytj02Ctr.class);
    
    @Autowired
    private FeeXmfytj02Ser feeXmfytj02Ser;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<FeeXmfytj02Resp>> queryPage(FeeXmfytj02Req feexmfytj02,PageQuery page){
//        PageInfo<FeeXmfytj02> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> feeXmfytj02Ser.findByEntity(feexmfytj02)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<FeeXmfytj02Resp>> getByEntity( FeeXmfytj02Req feexmfytj02){//@RequestBody 
//        return ReturnEntityUtil.success(feeXmfytj02Ser.findByEntity(feexmfytj02));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<FeeXmfytj02Resp> getOneByEntity(FeeXmfytj02Req feexmfytj02){
//        List<FeeXmfytj02> list=feeXmfytj02Ser.findByEntity(feexmfytj02);
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
//    public ReturnEntity<FeeXmfytj02Resp> add(FeeXmfytj02Req feeXmfytj02) {
//        feeXmfytj02Ser.insert(feeXmfytj02);        
//        return ReturnEntityUtil.success(feeXmfytj02);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<FeeXmfytj02Resp> edit(FeeXmfytj02Req feeXmfytj02)  {
//        feeXmfytj02Ser.update(feeXmfytj02);        
//        return ReturnEntityUtil.success(feeXmfytj02);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<FeeXmfytj02Resp> delete(FeeXmfytj02Req feeXmfytj02) {
//        feeXmfytj02Ser.removeByEntity(feeXmfytj02);        
//        return ReturnEntityUtil.success(feeXmfytj02);            
//    }
    
}

