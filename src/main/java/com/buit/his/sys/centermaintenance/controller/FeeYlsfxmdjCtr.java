
package com.buit.his.sys.centermaintenance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmdjSer;

import io.swagger.annotations.Api;

/**
 * 公用_医院医疗明细项目<br>
 * @author 老花生
 */
@Api(tags="公用_医院医疗明细项目")
@Controller
@RequestMapping("/feeylsfxmdj")
public class FeeYlsfxmdjCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(FeeYlsfxmdjCtr.class);
    
    @Autowired
    private FeeYlsfxmdjSer feeYlsfxmdjSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<FeeYlsfxmdjResp>> queryPage(FeeYlsfxmdjReq feeylsfxmdj,PageQuery page){
//        PageInfo<FeeYlsfxmdj> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> feeYlsfxmdjSer.findByEntity(feeylsfxmdj)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<FeeYlsfxmdjResp>> getByEntity( FeeYlsfxmdjReq feeylsfxmdj){//@RequestBody 
//        return ReturnEntityUtil.success(feeYlsfxmdjSer.findByEntity(feeylsfxmdj));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<FeeYlsfxmdjResp> getOneByEntity(FeeYlsfxmdjReq feeylsfxmdj){
//        List<FeeYlsfxmdj> list=feeYlsfxmdjSer.findByEntity(feeylsfxmdj);
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
//    public ReturnEntity<FeeYlsfxmdjResp> add(FeeYlsfxmdjReq feeYlsfxmdj) {
//        feeYlsfxmdjSer.insert(feeYlsfxmdj);        
//        return ReturnEntityUtil.success(feeYlsfxmdj);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<FeeYlsfxmdjResp> edit(FeeYlsfxmdjReq feeYlsfxmdj)  {
//        feeYlsfxmdjSer.update(feeYlsfxmdj);        
//        return ReturnEntityUtil.success(feeYlsfxmdj);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<FeeYlsfxmdjResp> delete(FeeYlsfxmdjReq feeYlsfxmdj) {
//        feeYlsfxmdjSer.removeByEntity(feeYlsfxmdj);        
//        return ReturnEntityUtil.success(feeYlsfxmdj);            
//    }
    
}

