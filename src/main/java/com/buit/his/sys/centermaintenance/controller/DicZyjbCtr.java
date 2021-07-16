
 package com.buit.his.sys.centermaintenance.controller;

 import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.request.DicZyjbReq;
import com.buit.his.sys.centermaintenance.response.DicZyjbResp;
import com.buit.his.sys.centermaintenance.service.DicZyjbSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

 /**
  * 中医疾病
  *
  * @author 老花生
  */
 @Api(tags = "中医疾病编码维护")
 @Controller
 @RequestMapping("/diczyjb")
 public class DicZyjbCtr extends BaseSpringController {

     static final Logger logger = LoggerFactory.getLogger(DicZyjbCtr.class);

     @Autowired
     private DicZyjbSer dicZyjbSer;

//     @Autowired
//     private TcmDiseaseDicSer tcmDiseaseDicSer;
//
//
//     @RequestMapping("/tcmTree")
//     @ResponseBody
//     @ApiOperation(value = "中医疾病-树集合", httpMethod = "POST")
//     public ReturnEntity<List<TcmDiseaseDicResp>> tree() {
//         return ReturnEntityUtil.success(tcmDiseaseDicSer.queryList());
//     }
//
//     @RequestMapping("/tcmQueryPage")
//     @ResponseBody
//     @ApiOperation(value = "中医疾病-分页查询", httpMethod = "POST")
//     public ReturnEntity<PageInfo<DicZyjbResp>> queryPage(@ApiParam(name = "id", value = "中医疾病分类ID", required = true) @RequestParam int id,
//                                                          @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
//         PageInfo<DicZyjbResp> pageInfo = PageHelper.startPage(
//                 page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                 () -> dicZyjbSer.getEntityMapper().queryList(id, pydm)
//         );
//         return ReturnEntityUtil.success(pageInfo);
//     }
//
//
//     @RequestMapping("/tcmDropList")
//     @ResponseBody
//     @ApiOperation(value = "中医疾病-中医分类下拉列表", httpMethod = "POST")
//     public ReturnEntity<List<TcmDiseaseDic>> dropList() {
//         return ReturnEntityUtil.success(tcmDiseaseDicSer.getEntityMapper().dropList());
//     }
//
//
//     /**
//      * 新增
//      */
//     @RequestMapping("/tcmAdd")
//     @ResponseBody
//     @ApiOperation(value = "中医疾病-新增", httpMethod = "POST")
//     public ReturnEntity <String> tcmAdd(@Valid DicZyjbAddReq req) {
//         dicZyjbSer.add(req);
//         return ReturnEntityUtil.success();
//     }
//
//     /**
//      * 编辑
//      */
//     @RequestMapping("/tcmEdit")
//     @ResponseBody
//     @ApiOperation(value = "中医疾病-编辑", httpMethod = "POST")
//     public ReturnEntity <String> tcmEdit(@Valid DicZyjbEditReq dicZyjb) {
//         dicZyjbSer.update(dicZyjb);
//         return ReturnEntityUtil.success(dicZyjb);
//     }
//
//     /**
//      * 删除
//      */
//     @RequestMapping("/tcmDelete")
//     @ResponseBody
//     @ApiOperation(value = "中医疾病-删除", httpMethod = "POST")
//     public ReturnEntity <String> tcmDelete(@ApiParam(name = "jbbs", value = "疾病标识", required = true) @RequestParam int jbbs) {
//         dicZyjbSer.removeById(jbbs);
//         return ReturnEntityUtil.success();
//     }
     @RequestMapping("/zyPage")
     @ResponseBody
     @ApiOperation(value="中医疾病分页查询" ,httpMethod="POST")
     public ReturnEntity<PageInfo<DicZyjbResp>> zyPage(DicZyjbReq req){
         PageInfo<DicZyjbResp> pageInfo = PageHelper.startPage(
                 req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                     () -> dicZyjbSer.findZyjb(req)
             );
         return ReturnEntityUtil.success(pageInfo);
     }

 }

