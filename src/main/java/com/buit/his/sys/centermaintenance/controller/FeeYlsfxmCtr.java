
package com.buit.his.sys.centermaintenance.controller;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmReq;
import com.buit.his.sys.centermaintenance.request.YjQueryPageHelperReq;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmAllResp;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmBxResp;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmResp;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmZlmxResp;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.response.GyYlxmDicResp;
import com.buit.system.response.YjQueryPageHelperResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.map.MapUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公用_医疗收费<br>
 * @author 老花生
 */
@Api(tags="公用_医疗收费_附加项目")
@Controller
@RequestMapping("/feeylsfxm")
public class FeeYlsfxmCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(FeeYlsfxmCtr.class);
    
    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;
    
    @RequestMapping("/queryInpatientProjectAll")
    @ResponseBody
    @ApiOperation(value="查询住院全部项目" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmAllResp>> queryInpatientProjectAll(@ApiParam(name = "pydm", value = "拼音代码", required = false) 
    @RequestParam(value = "pydm", required = false )  String pydm, PageQuery page){
        PageInfo<FeeYlsfxmAllResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> feeYlsfxmSer.getEntityMapper().
                    queryInpatientProjectAll(getUser().getHospitalId(), pydm)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询医疗收费项目明细
     * @param fyxh
     * @return
     */
    @RequestMapping("/queryYlsfZlmx")
    @ResponseBody
    @ApiOperation(value="查询医疗收费项目明细" ,httpMethod="POST")
    public ReturnEntity<FeeYlsfxmZlmxResp> queryYlsfZlmx(@ApiParam(name = "fyxh", value = "id", required = true) @RequestParam  Integer fyxh){
        FeeYlsfxm feeYlsfxm=feeYlsfxmSer.getById(fyxh);
        FeeYlsfxmZlmxResp feeYlsfxmZlmxResp = new  FeeYlsfxmZlmxResp();
        BeanUtils.copyProperties(feeYlsfxm,feeYlsfxmZlmxResp);
        return ReturnEntityUtil.success(feeYlsfxmZlmxResp);
    }

    @RequestMapping("/queryBxxm")
    @ResponseBody
    @ApiOperation(value="查询备血申请项目" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmBxResp>> queryBxxm(@ApiParam(name = "pydm", value = "拼音代码", required = false) 
    @RequestParam(value = "pydm", required = false )  String pydm, PageQuery page){
        PageInfo<FeeYlsfxmBxResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                        () -> feeYlsfxmSer.getEntityMapper().
                        queryBxxm(10, this.getUser().getHospitalId(), pydm)
                );
        return ReturnEntityUtil.success(pageInfo);
    }
    /** 医技全部查询（助手方式） */
    @RequestMapping("/queryPageHelper")
    @ResponseBody
    @ApiOperation(value="医技全部查询（助手方式）" ,httpMethod="POST")
    public ReturnEntity<PageInfo<YjQueryPageHelperResp>> queryPageHelper(YjQueryPageHelperReq req) {
        HashMap<Object, Object> map = MapUtil.of(new Object[][]{
                {"jgid",  getUser().getHospitalId()},
                {"pydm", req.getPydm()}
        });
        PageInfo<YjQueryPageHelperResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> feeYlsfxmSer.getEntityMapper().queryPageHelper(map)
        );
        return  ReturnEntityUtil.success(pageInfo);
    }
    
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<FeeYlsfxmResp> edit(FeeYlsfxmReq feeYlsfxm)  {
//        feeYlsfxmSer.update(feeYlsfxm);        
//        return ReturnEntityUtil.success(feeYlsfxm);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<FeeYlsfxmResp> delete(FeeYlsfxmReq feeYlsfxm) {
//        feeYlsfxmSer.removeByEntity(feeYlsfxm);        
//        return ReturnEntityUtil.success(feeYlsfxm);            
//    }
    @RequestMapping("/allInfoNoUser")
    @ResponseBody
    @ApiOperation(value="查询全部手术信息刨除用户选择" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmResp>> allInfoNoUser(FeeYlsfxmReq req){
        PageInfo<FeeYlsfxm> pageInfo = feeYlsfxmSer.allInfoNoUser(req);

        PageInfo<FeeYlsfxmResp> ret = BeanUtil.toPage(pageInfo, FeeYlsfxmResp.class);
        return ReturnEntityUtil.success(ret);
    }
    @RequestMapping("/allInfo")
    @ResponseBody
    @ApiOperation(value="查询全部手术信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmResp>> allInfo(FeeYlsfxmReq req){
        req.setZfpb(0);
        PageInfo<FeeYlsfxm> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> feeYlsfxmSer.findByEntity(req)
        );
        PageInfo<FeeYlsfxmResp> ret = BeanUtil.toPage(pageInfo, FeeYlsfxmResp.class);
        for(FeeYlsfxmResp feeYlsfxmResp : ret.getList()) {
        	feeYlsfxmResp.setSsnm(feeYlsfxmResp.getFyxh());
        }
        return ReturnEntityUtil.success(ret);
    }

    @RequestMapping("/queryXmDic")
    @ResponseBody
    @ApiOperation(value="中心维护-附加项目维护-附加项目字典查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<GyYlxmDicResp>> queryXmDic(
            @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm,PageQuery page){
        PageInfo<GyYlxmDicResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
                .doSelectPageInfo(() -> feeYlsfxmSer.getEntityMapper().queryXmDicList(getUser().getHospitalId(),pydm));
        return ReturnEntityUtil.success(pageInfo);
    }
    
    @RequestMapping("/queryCwszFyDic")
    @ResponseBody
    @ApiOperation(value="查询床位设置费用项目字典" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmOutResp>> queryCwszFyDic(@ApiParam(name = "pydm", value = "拼音代码") 
    	@RequestParam(required = false) String pydm,PageQuery page) {
    	PageInfo<FeeYlsfxmOutResp> pageInfo = PageHelper.startPage(
    			page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> feeYlsfxmSer.getEntityMapper().queryCwszFyDic(this.getUser().getHospitalId(), pydm)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    
}

