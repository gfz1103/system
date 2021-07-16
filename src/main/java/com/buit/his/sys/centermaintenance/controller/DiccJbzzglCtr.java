//
// package com.buit.his.sys.centermaintenance.controller;
//
// import com.buit.commons.BaseSpringController;
// import com.buit.his.sys.centermaintenance.model.DiccJbzzgl;
// import com.buit.his.sys.centermaintenance.request.DiccJbzzglAddReq;
// import com.buit.his.sys.centermaintenance.request.DiccJbzzglEditReq;
// import com.buit.his.sys.centermaintenance.request.DiccJbzzglReq;
// import com.buit.his.sys.centermaintenance.response.DiccJbzzglResp;
// import com.buit.his.sys.centermaintenance.service.DiccJbzzglSer;
// import com.buit.utill.BeanUtil;
// import com.buit.utill.ReturnEntity;
// import com.buit.utill.ReturnEntityUtil;
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
// import java.util.List;
//
// /**
//  * 疾病治则关联<br>
//  *
//  * @author liushijie
//  */
// @Api(tags = "疾病治则关联")
// @Controller
// @RequestMapping("/diccjbzzgl")
// public class DiccJbzzglCtr extends BaseSpringController {
//
//     static final Logger logger = LoggerFactory.getLogger(DiccJbzzglCtr.class);
//
//     @Autowired
//     private DiccJbzzglSer diccJbzzglSer;
//
//     @RequestMapping("/queryZZList")
//     @ResponseBody
//     @ApiOperation(value = "疾病治则关联-列表", httpMethod = "POST")
//     public ReturnEntity<List<DiccJbzzglResp>> queryZZList(@ApiParam(name = "jbbs", value = "疾病标识", required = true) @RequestParam int jbbs) {
//         return ReturnEntityUtil.success(diccJbzzglSer.getEntityMapper().queryList(jbbs));
//     }
//
//    @RequestMapping("/zzadd")
//    @ResponseBody
//    @ApiOperation(value="疾病治则关联-新增" ,httpMethod="POST")
//    public ReturnEntity <String> add(DiccJbzzglAddReq req) {
//        diccJbzzglSer.add(req);
//        return ReturnEntityUtil.success();
//    }
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="疾病治则关联-编辑" ,httpMethod="POST")
//    public ReturnEntity <String> edit(DiccJbzzglEditReq req)  {
//        DiccJbzzgl jbzz = BeanUtil.toBean(req, DiccJbzzgl.class);
//        diccJbzzglSer.update(jbzz);
//        return ReturnEntityUtil.success();
//    }
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="疾病治则关联-删除" ,httpMethod="POST")
//    public ReturnEntity <String> delete(@ApiParam(name = "glbs", value = "关联标识", required = true) @RequestParam int glbs) {
//        diccJbzzglSer.removeById(glbs);
//        return ReturnEntityUtil.success();
//    }
//
// }
//
