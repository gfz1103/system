
package com.buit.his.sys.centermaintenance.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.model.DicYjlx;
import com.buit.his.sys.centermaintenance.response.DicYjlxResp;
import com.buit.his.sys.centermaintenance.service.DicYjlxSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 医技类型维护<br>
 * @author 老花生
 */
@Api(tags="医技类型维护")
@Controller
@RequestMapping("/dicyjlx")
public class DicYjlxCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(DicYjlxCtr.class);
    
    @Autowired
    private DicYjlxSer dicYjlxSer;

    /** 获取医技分类树结构(medicalClassifyService.loadDicData) */
    @RequestMapping("/loadDicData")
    @ResponseBody
    @ApiOperation(value="获取医技分类树结构" ,httpMethod="POST")
    public ReturnEntity<List<DicYjlxResp>> loadDicData(@ApiParam(name = "pid", value = "父ID") @RequestParam Integer pid){//@RequestBody
        return ReturnEntityUtil.success(dicYjlxSer.loadDicData(pid));
    }

    /** 中心维护-获取医技分类树集合 */
    @RequestMapping("/getTree")
    @ResponseBody
    @ApiOperation(value="中心维护-获取医技分类树集合" ,httpMethod="POST")
    public ReturnEntity<List<DicYjlxResp>> getTree(){
        return ReturnEntityUtil.success(dicYjlxSer.getTree());
    }


    @RequestMapping("/getById")
    @ResponseBody
    @ApiOperation(value="根据id查询医技信息" ,httpMethod="POST")
    public ReturnEntity<DicYjlx> getById(@ApiParam(name = "id", value = "主键", required = true) @RequestParam Integer id){
        return ReturnEntityUtil.success(dicYjlxSer.getById(id));
    }
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<DicYjlxResp>> queryPage(DicYjlxReq dicyjlx,PageQuery page){
//        PageInfo<DicYjlx> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> dicYjlxSer.findByEntity(dicyjlx)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<DicYjlxResp> getOneByEntity(DicYjlxReq dicyjlx){
//        List<DicYjlx> list=dicYjlxSer.findByEntity(dicyjlx);
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
//    public ReturnEntity<DicYjlxResp> add(DicYjlxReq dicYjlx) {
//        dicYjlxSer.insert(dicYjlx);        
//        return ReturnEntityUtil.success(dicYjlx);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<DicYjlxResp> edit(DicYjlxReq dicYjlx)  {
//        dicYjlxSer.update(dicYjlx);        
//        return ReturnEntityUtil.success(dicYjlx);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<DicYjlxResp> delete(DicYjlxReq dicYjlx) {
//        dicYjlxSer.removeByEntity(dicYjlx);        
//        return ReturnEntityUtil.success(dicYjlx);            
//    }
    
}

