
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import javax.validation.Valid;

import com.buit.his.sys.centermaintenance.request.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.model.DicJbbm;
import com.buit.his.sys.centermaintenance.model.DicZyjbfl;
import com.buit.his.sys.centermaintenance.model.DicZyzh;
import com.buit.his.sys.centermaintenance.model.DiccJbzzgl;
import com.buit.his.sys.centermaintenance.response.DicJbbmResp;
import com.buit.his.sys.centermaintenance.response.DicZyjbResp;
import com.buit.his.sys.centermaintenance.response.DicZyjbflResp;
import com.buit.his.sys.centermaintenance.response.DicZyzhResp;
import com.buit.his.sys.centermaintenance.response.DicZyzhflResp;
import com.buit.his.sys.centermaintenance.response.DiccJbzzglResp;
import com.buit.his.sys.centermaintenance.service.DicJbbmSer;
import com.buit.his.sys.centermaintenance.service.DicZyjbSer;
import com.buit.his.sys.centermaintenance.service.DicZyjbflSer;
import com.buit.his.sys.centermaintenance.service.DicZyzhSer;
import com.buit.his.sys.centermaintenance.service.DicZyzhflSer;
import com.buit.his.sys.centermaintenance.service.DiccJbzzglSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公用_疾病编码库<br>
 *
 * @author 老花生
 */
@Api(tags = "疾病编码维护")
@Controller
@RequestMapping("/dicjbbm")
public class DicJbbmCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicJbbmCtr.class);

    @Autowired
    private DicJbbmSer dicJbbmSer;

    @Autowired
    private DiccJbzzglSer diccJbzzglSer;

    @Autowired
    private DicZyjbSer dicZyjbSer;

    @Autowired
    private DicZyjbflSer dicZyjbflSer;

    @Autowired
    private DicZyzhSer dicZyzhSer;

    @Autowired
    private DicZyzhflSer dicZyzhflSer;

    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @RequestMapping("/westQueryPage")
    @ResponseBody
    @ApiOperation(value = "西医疾病编码-分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<DicJbbmResp>> queryPage(@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm,
                                                        @ApiParam(name = "icdCode", value = "icdCode") @RequestParam(required = false) String icdCode, PageQuery page) {
        DicJbbm condition = new DicJbbm();
        condition.setPydm(pydm);
        condition.setIcdCode(icdCode);
        condition.setDmlb(10);
        condition.setZfbz(0);
        PageInfo<DicJbbm> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicJbbmSer.findByEntity(condition)
        );
        PageInfo<DicJbbmResp> ret = BeanUtil.toPage(pageInfo, DicJbbmResp.class);
        return ReturnEntityUtil.success(ret);
    }

    /**
     * 修改疾病编码作废标志
     */
    @RequestMapping("/updateZfbz")
    @ResponseBody
    @ApiOperation(value = "西医疾病编码-修改西医疾病编码作废标志", httpMethod = "POST")
    public ReturnEntity <String> updateZfbz(@ApiParam(name = "zfbz", value = "作废标志,0:未作废,1:") @RequestParam Integer zfbz,
                                            @ApiParam(name = "jbxh", value = "疾病序号") @RequestParam Integer jbxh) {
        dicJbbmSer.getEntityMapper().updateZfbz(jbxh,zfbz);
        return ReturnEntityUtil.success();
    }

    /**
     * 新增
     */
    @RequestMapping("/westAdd")
    @ResponseBody
    @ApiOperation(value = "西医疾病编码-新增", httpMethod = "POST")
    public ReturnEntity <String> westAdd(@Valid DicJbbmAddReq req) {
        dicJbbmSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/westEdit")
    @ResponseBody
    @ApiOperation(value = "西医疾病编码-编辑", httpMethod = "POST")
    public ReturnEntity <String> edit(@Valid DicJbbmEditReq req) {
        DicJbbm jbbm = BeanUtil.toBean(req, DicJbbm.class);
        dicJbbmSer.update(jbbm);
        sysDictConfigSer.upDateVersion("dic_jbbm");
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/westDelete")
    @ResponseBody
    @ApiOperation(value = "西医疾病编码-删除", httpMethod = "POST")
    public ReturnEntity <String> delete(@ApiParam(name = "jbxh", value = "疾病序号", required = true) @RequestParam int jbxh) {
        dicJbbmSer.removeById(jbxh);
        sysDictConfigSer.upDateVersion("dic_jbbm");
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/queryZZList")
    @ResponseBody
    @ApiOperation(value = "疾病治则关联-列表", httpMethod = "POST")
    public ReturnEntity<List<DiccJbzzglResp>> queryZZList(@ApiParam(name = "jbbs", value = "疾病标识", required = true) @RequestParam int jbbs) {
        return ReturnEntityUtil.success(diccJbzzglSer.getEntityMapper().queryList(jbbs));
    }

    @RequestMapping("/zzadd")
    @ResponseBody
    @ApiOperation(value="疾病治则关联-新增" ,httpMethod="POST")
    public ReturnEntity <String> zzadd(@Valid DiccJbzzglAddReq req) {
        diccJbzzglSer.add(req);
        return ReturnEntityUtil.success();
    }
    @RequestMapping("/zzedit")
    @ResponseBody
    @ApiOperation(value="疾病治则关联-编辑" ,httpMethod="POST")
    public ReturnEntity <String> zzedit(@Valid DiccJbzzglEditReq req)  {
        DiccJbzzgl jbzz = BeanUtil.toBean(req, DiccJbzzgl.class);
        diccJbzzglSer.update(jbzz);
        return ReturnEntityUtil.success();
    }
    @RequestMapping("/zzdelete")
    @ResponseBody
    @ApiOperation(value="疾病治则关联-删除" ,httpMethod="POST")
    public ReturnEntity <String> zzdelete(@ApiParam(name = "glbs", value = "关联标识", required = true) @RequestParam int glbs) {
        diccJbzzglSer.removeById(glbs);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/tcmTree")
    @ResponseBody
    @ApiOperation(value = "中医疾病-树集合", httpMethod = "POST")
    public ReturnEntity<List<DicZyjbflResp>> tree() {
        return ReturnEntityUtil.success(dicZyjbflSer.queryList());
    }

    @RequestMapping("/tcmQueryPage")
    @ResponseBody
    @ApiOperation(value = "中医疾病-分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<DicZyjbResp>> queryPage(@ApiParam(name = "zyfl", value = "中医疾病分类ID", required = true) @RequestParam int zyfl,
                                                         @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
        PageInfo<DicZyjbResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicZyjbSer.getEntityMapper().queryList(zyfl, pydm)
        );
        return ReturnEntityUtil.success(pageInfo);
    }


    @RequestMapping("/tcmDropList")
    @ResponseBody
    @ApiOperation(value = "中医疾病-中医分类下拉列表", httpMethod = "POST")
    public ReturnEntity<List<DicZyjbfl>> dropList() {
        return ReturnEntityUtil.success(dicZyjbflSer.getEntityMapper().dropList());
    }

    /**
     * 新增
     */
    @RequestMapping("/tcmAdd")
    @ResponseBody
    @ApiOperation(value = "中医疾病-新增", httpMethod = "POST")
    public ReturnEntity <String> tcmAdd(@Valid DicZyjbAddReq req) {
        dicZyjbSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/tcmEdit")
    @ResponseBody
    @ApiOperation(value = "中医疾病-编辑", httpMethod = "POST")
    public ReturnEntity<DicZyjbEditReq> tcmEdit(@Valid DicZyjbEditReq dicZyjb) {
        dicZyjbSer.update(dicZyjb);
        sysDictConfigSer.upDateVersion("dic_zyjb");
        return ReturnEntityUtil.success(dicZyjb);
    }

    /**
     * 删除
     */
    @RequestMapping("/tcmDelete")
    @ResponseBody
    @ApiOperation(value = "中医疾病-删除", httpMethod = "POST")
    public ReturnEntity <String> tcmDelete(@ApiParam(name = "jbbs", value = "疾病标识", required = true) @RequestParam int jbbs) {
        dicZyjbSer.removeById(jbbs);
        sysDictConfigSer.upDateVersion("dic_zyjb");
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/zhQueryPage")
    @ResponseBody
    @ApiOperation(value = "中医证候-分页列表", httpMethod = "POST")
    public ReturnEntity<PageInfo<DicZyzhResp>> zhQueryPage(@ApiParam(name = "id", value = "中医疾病分类ID", required = true) @RequestParam int id,
                                                         @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
        PageInfo<DicZyzhResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicZyzhSer.getEntityMapper().queryList(id, pydm)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/zhQueryAll")
    @ResponseBody
    @ApiOperation(value = "中医证候-通过条件查询所有", httpMethod = "POST")
    public ReturnEntity<PageInfo<DicZyzhResp>> zhQueryAll(@ApiParam(name = "condition", value = "搜索条件（拼音码或者名称）") @RequestParam(required = false) String condition, PageQuery page) {
        PageInfo<DicZyzhResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicZyzhSer.getEntityMapper().queryByConditionList(condition)
        );
        return ReturnEntityUtil.success(pageInfo);
    }




    @RequestMapping("/zhInput")
    @ResponseBody
    @ApiOperation(value = "中医证候-输入法", httpMethod = "POST")
    public ReturnEntity<PageInfo<DicZyzhResp>> zyzhInputList(PageQuery page) {
        PageInfo<DicZyzhResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicZyzhSer.getEntityMapper().zyzhInputList()
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/zhTree")
    @ResponseBody
    @ApiOperation(value = "中医证候-分类树", httpMethod = "POST")
    public ReturnEntity<List<DicZyzhflResp>> zhTree() {
        return ReturnEntityUtil.success(dicZyzhflSer.queryList());
    }

    @RequestMapping("/zhDropList")
    @ResponseBody
    @ApiOperation(value = "中医证候-分类下拉列表", httpMethod = "POST")
    public ReturnEntity<List<DicZyzhflResp>> zhDropList() {
        return ReturnEntityUtil.success(dicZyzhflSer.dropList());
    }

    /**
     * 新增
     */
    @RequestMapping("/zhAdd")
    @ResponseBody
    @ApiOperation(value = "中医证候-新增", httpMethod = "POST")
    public ReturnEntity <String> zhAdd(@Valid DicZyzhAddReq req) {
        dicZyzhSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/zhEdit")
    @ResponseBody
    @ApiOperation(value = "中医证候-编辑", httpMethod = "POST")
    public ReturnEntity <String> zhEdit(@Valid DicZyzhEditReq req) {
        DicZyzh zyzh = BeanUtil.toBean(req, DicZyzh.class);
        dicZyzhSer.update(zyzh);
        sysDictConfigSer.upDateVersion("dic_jbbm");
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/zhDelete")
    @ResponseBody
    @ApiOperation(value = "中医证候-删除", httpMethod = "POST")
    public ReturnEntity <String> zhDelete(@ApiParam(name = "zhbs", value = "证候标识", required = true) @RequestParam int zhbs) {
        dicZyzhSer.removeById(zhbs);
        sysDictConfigSer.upDateVersion("dic_jbbm");
        return ReturnEntityUtil.success();
    }
    @RequestMapping("/xyPage")
    @ResponseBody
    @ApiOperation(value="西医疾病分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicJbbmResp>> xyPage(DicJbbmReq dicjbbm, PageQuery page){
        PageInfo<DicJbbm> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicJbbmSer.findByEntity(dicjbbm)
        );
        PageInfo<DicJbbmResp> ret = BeanUtil.toPage(pageInfo, DicJbbmResp.class);
        return ReturnEntityUtil.success(ret);
    }

    @RequestMapping("/zyPage")
    @ResponseBody
    @ApiOperation(value="中医疾病分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicZyjbResp>> zyPage(DicZyjbReq req){
        PageInfo<DicZyjbResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> dicZyjbSer.findZyjbbm(req)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

}

