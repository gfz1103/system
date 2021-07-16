
package com.buit.his.sys.centermaintenance.controller;


import java.util.List;

import javax.validation.Valid;

import com.buit.his.sys.centermaintenance.request.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.model.DicZlxm;
import com.buit.his.sys.centermaintenance.response.DicYjlxResp;
import com.buit.his.sys.centermaintenance.response.DiccZlsfdzResp;
import com.buit.his.sys.centermaintenance.service.DicKszdSer;
import com.buit.his.sys.centermaintenance.service.DicYjlxSer;
import com.buit.his.sys.centermaintenance.service.DicZlxmSer;
import com.buit.his.sys.centermaintenance.service.DiccZlsfdzSer;
import com.buit.system.model.DicKszd;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 诊疗项目
 *
 * @author liushijie
 */
@Api(tags = "诊疗项目维护")
@Controller
@RequestMapping("/treatmentItems")
public class TreatmentItemsCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(TreatmentItemsCtr.class);

    @Autowired
    private DicZlxmSer dicZlxmSer;

    @Autowired
    private DicKszdSer dicKszdSer;

    @Autowired
    private DiccZlsfdzSer diccZlsfdzSer;

    @Autowired
    private DicYjlxSer dicYjlxSer;

    /**
     * 获取医技分类树集合
     */
    @RequestMapping("/getTree")
    @ResponseBody
    @ApiOperation(value = "获取医技分类树集合", httpMethod = "POST")
    public ReturnEntity<List<DicYjlxResp>> getTree() {
        return ReturnEntityUtil.success(dicYjlxSer.getTree());
    }

    /**
     * 医技类型树-新增
     */
    @RequestMapping("/treeAdd")
    @ResponseBody
    @ApiOperation(value = "医技类型树-新增", httpMethod = "POST")
    public ReturnEntity <String> treeAdd(@Valid DicYjlxAddReq req) {
        dicYjlxSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 医技类型树-编辑
     */
    @RequestMapping("/treeEdit")
    @ResponseBody
    @ApiOperation(value = "医技类型树-编辑", httpMethod = "POST")
    public ReturnEntity <String> treeEdit(@Valid DicYjlxEditReq req) {
        dicYjlxSer.update(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 医技类型树-注销
     */
    @RequestMapping("/treeLogout")
    @ResponseBody
    @ApiOperation(value = "医技类型树-注销", httpMethod = "POST")
    public ReturnEntity <String> treeLogout(@ApiParam(name="id",value="ID",required = true)@RequestParam Integer id) {
        dicYjlxSer.getEntityMapper().logout(id);
        return ReturnEntityUtil.success();
    }


    /**
     * 诊疗项目维护-查询医技类型列表
     *
     * @param yjlx
     * @return
     */
    @RequestMapping("/queryList")
    @ResponseBody
    @ApiOperation(value = "查询医技类型列表", httpMethod = "POST")
    public ReturnEntity<List<DicZlxm>> queryList(@ApiParam(name = "yjlx", value = "医技类型", required = true) @RequestParam Integer yjlx) {
        return ReturnEntityUtil.success(dicZlxmSer.queryList(yjlx));
    }

    /**
     * 诊疗项目维护-新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "诊疗项目维护-新增", httpMethod = "POST")
    public ReturnEntity <String> add(@Valid @RequestBody DicZlxmAddReq req) {
        dicZlxmSer.add(req, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 诊疗项目维护-编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "诊疗项目维护-编辑", httpMethod = "POST")
    public ReturnEntity <String> edit(@Valid @RequestBody DicZlxmEditReq req) {
        dicZlxmSer.edit(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 诊疗项目维护-作废
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "诊疗项目维护-作废", httpMethod = "POST")
    public ReturnEntity <String> delete(@ApiParam(name = "zlxmId", value = "诊疗项目ID", required = true) @RequestParam Integer zlxmId) {
        dicZlxmSer.delete(zlxmId);
        return ReturnEntityUtil.success();
    }

    /**
     * 诊疗项目维护-执行科室列表
     */
    @RequestMapping("/executeDeptList")
    @ResponseBody
    @ApiOperation(value = "诊疗项目维护-执行科室列表", httpMethod = "POST")
    public ReturnEntity<List<DicKszd>> executeDeptList() {
        DicKszd condition = new DicKszd();
        condition.setMedicallab("1");
        return ReturnEntityUtil.success(dicKszdSer.findByEntity(condition));
    }

    /**
     * 诊疗收费对照列表
     */
    @RequestMapping("/sfdzList")
    @ResponseBody
    @ApiOperation(value = "诊疗收费对照列表", httpMethod = "POST")
    public ReturnEntity<List<DiccZlsfdzResp>> sfdzList(@ApiParam(name = "zlxmId", value = "诊疗项目ID", required = true) @RequestParam Integer zlxmId) {
        return ReturnEntityUtil.success(diccZlsfdzSer.getEntityMapper().queryZlsfdzList(zlxmId));
    }

    /**
     * 诊疗收费对照-新增
     */
    @RequestMapping("/sfdzAdd")
    @ResponseBody
    @ApiOperation(value = "诊疗收费对照-新增", httpMethod = "POST")
    public ReturnEntity <String> sfdzAdd(@Valid DiccZlsfdzAddReq req) {
        diccZlsfdzSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 诊疗收费对照-删除
     */
    @RequestMapping("/sfdzDelete")
    @ResponseBody
    @ApiOperation(value = "诊疗收费对照-删除", httpMethod = "POST")
    public ReturnEntity <String> sfdzDelete(@ApiParam(name = "jlxh", value = "主键记录序号", required = true) @RequestParam Integer jlxh) {
        diccZlsfdzSer.delete(jlxh);
        return ReturnEntityUtil.success();
    }


}

