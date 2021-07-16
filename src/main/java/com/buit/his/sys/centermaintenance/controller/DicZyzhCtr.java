//
// package com.buit.his.sys.centermaintenance.controller;
//
//
// import com.buit.commons.BaseSpringController;
// import com.buit.commons.PageQuery;
// import com.buit.his.sys.centermaintenance.model.DicZyzh;
// import com.buit.his.sys.centermaintenance.request.DicZyzhAddReq;
// import com.buit.his.sys.centermaintenance.request.DicZyzhEditReq;
// import com.buit.his.sys.centermaintenance.request.DicZyzhReq;
// import com.buit.his.sys.centermaintenance.response.DicZyzhResp;
// import com.buit.his.sys.centermaintenance.response.TcmSyndromeDicResp;
// import com.buit.his.sys.centermaintenance.service.DicZyzhSer;
// import com.buit.his.sys.centermaintenance.service.TcmSyndromeDicSer;
// import com.buit.utill.BeanUtil;
// import com.buit.utill.ReturnEntity;
// import com.buit.utill.ReturnEntityUtil;
// import com.github.pagehelper.PageHelper;
// import com.github.pagehelper.PageInfo;
// import io.swagger.annotations.Api;
// import io.swagger.annotations.ApiOperation;
// import io.swagger.annotations.ApiParam;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
//
// import javax.validation.Valid;
// import java.util.List;
//
// /**
//  * <br>
//  *
//  * @author 老花生
//  */
// @Api(tags = "中医证候编码维护")
// @Controller
// @RequestMapping("/diczyzh")
// public class DicZyzhCtr extends BaseSpringController {
//
//     static final Logger logger = LoggerFactory.getLogger(DicZyzhCtr.class);
//
//     @Autowired
//     private DicZyzhSer dicZyzhSer;
//
//     @Autowired
//     private TcmSyndromeDicSer tcmSyndromeDicSer;
//
//
//     @RequestMapping("/zhQueryPage")
//     @ResponseBody
//     @ApiOperation(value = "中医证候-分页列表", httpMethod = "POST")
//     public ReturnEntity<PageInfo<DicZyzhResp>> queryPage(@ApiParam(name = "id", value = "中医疾病分类ID", required = true) @RequestParam int id,
//                                                          @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
//         PageInfo<DicZyzhResp> pageInfo = PageHelper.startPage(
//                 page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                 () -> dicZyzhSer.getEntityMapper().queryList(id, pydm)
//         );
//         return ReturnEntityUtil.success(pageInfo);
//     }
//
//     @RequestMapping("/zhTree")
//     @ResponseBody
//     @ApiOperation(value = "中医证候-分类树", httpMethod = "POST")
//     public ReturnEntity<List<TcmSyndromeDicResp>> zhTree() {
//         return ReturnEntityUtil.success(tcmSyndromeDicSer.queryList());
//     }
//
//     /**
//      * 新增
//      */
//     @RequestMapping("/zhAdd")
//     @ResponseBody
//     @ApiOperation(value = "中医证候-新增", httpMethod = "POST")
//     public ReturnEntity <String> zhAdd(DicZyzhAddReq req) {
//         dicZyzhSer.add(req);
//         return ReturnEntityUtil.success();
//     }
//
//     /**
//      * 编辑
//      */
//     @RequestMapping("/zhEdit")
//     @ResponseBody
//     @ApiOperation(value = "中医证候-编辑", httpMethod = "POST")
//     public ReturnEntity <String> zhEdit(@Valid DicZyzhEditReq req) {
//         DicZyzh zyzh = BeanUtil.toBean(req, DicZyzh.class);
//         dicZyzhSer.update(zyzh);
//         return ReturnEntityUtil.success();
//     }
//
//     /**
//      * 删除
//      */
//     @RequestMapping("/zhDelete")
//     @ResponseBody
//     @ApiOperation(value = "中医证候-删除", httpMethod = "POST")
//     public ReturnEntity <String> zhDelete(@ApiParam(name = "zhbs", value = "证候标识", required = true) @RequestParam int zhbs) {
//         dicZyzhSer.removeById(zhbs);
//         return ReturnEntityUtil.success();
//     }
//
// }
//
