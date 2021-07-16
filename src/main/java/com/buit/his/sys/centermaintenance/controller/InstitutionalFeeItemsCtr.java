package com.buit.his.sys.centermaintenance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmdjSaveReq;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmdjMechanismResp;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmdjSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 机构收费项目维护
 * @ClassName: InstitutionalFeeItemsCtr
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年7月16日 下午5:19:07
 *
 */
@Api(tags="机构收费项目维护")
@Controller
@RequestMapping("/institutionalFeeItems")
public class InstitutionalFeeItemsCtr extends BaseSpringController{

	@Autowired
	private FeeYlsfxmdjSer feeYlsfxmdjSer;
	
	@Autowired
	private FeeYlsfxmSer feeYlsfxmSer;
	
	@RequestMapping("/queryInstitutionalFeeCollection")
    @ResponseBody
    @ApiOperation(value="机构收费项目明细查询-分页" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmdjMechanismResp>> queryInstitutionalFeeCollection(@ApiParam(name = "fygb", value = "费用归并", required = false)
    @RequestParam(value = "fygb", required = false ) Integer fygb, @ApiParam(name = "pydm", value = "拼音代码", required = false)
    @RequestParam(value = "pydm", required = false ) String pydm,PageQuery page){
    	Map<String, Object> parameters = new HashMap<String, Object>(16);
    	parameters.put("fygb", fygb);
    	parameters.put("jgid", getUser().getHospitalId());
    	if(StrUtil.isNotBlank(pydm)) {
    		parameters.put("pydm", pydm);
    	}
        PageInfo<FeeYlsfxmdjMechanismResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> feeYlsfxmdjSer.getEntityMapper().queryInstitutionalFeeCollection(parameters)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
	
	
	@RequestMapping("/updateInstitutionalFeeCollection")
    @ResponseBody
    @ApiOperation(value="机构收费项目明细修改" ,httpMethod="POST")
    public ReturnEntity <String> updateInstitutionalFeeCollection(FeeYlsfxmdjSaveReq feeYlsfxmdjSaveReq){
		feeYlsfxmdjSer.update(feeYlsfxmdjSaveReq);
        return ReturnEntityUtil.success();    
    }
	
	@RequestMapping("/logoutProject")
    @ResponseBody
    @ApiOperation(value="机构收费项目明细作废或取消作废" ,httpMethod="POST")
    public ReturnEntity <String> logoutProject(@ApiParam(name = "zfpb", value = "是否作废", required = true) 
	@RequestParam Integer zfpb, @ApiParam(name = "fyxh", value = "费用序号", required = true) 
	@RequestParam Integer fyxh){
		feeYlsfxmdjSer.getEntityMapper().logoutProject(zfpb, fyxh, this.getUser().getHospitalId());
        return ReturnEntityUtil.success();
    }
	
	@RequestMapping("/queryInstitutionalDetails")
    @ResponseBody
    @ApiOperation(value="需调入收费项目明细列表" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxm>> queryInstitutionalDetails(@ApiParam(name = "fygb", value = "费用归并", required = true) 
    @RequestParam Integer fygb, @ApiParam(name = "pydm", value = "拼音代码", required = false) 
    @RequestParam(value = "pydm", required = false ) String pydm, PageQuery page){
    	Map<String, Object> parameters = new HashMap<String, Object>(16);
    	parameters.put("fygb", fygb);
    	parameters.put("jgid", getUser().getHospitalId());
    	if(StrUtil.isNotBlank(pydm)) {
    		parameters.put("pydm", pydm);
    	}
        PageInfo<FeeYlsfxm> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> feeYlsfxmSer.getEntityMapper().queryInstitutionalDetails(parameters)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
	
	@RequestMapping("/saveInInstitutionalDetails")
    @ResponseBody
    @ApiOperation(value="收费项目维护选择调入" ,httpMethod="POST")
    public ReturnEntity <String> saveInInstitutionalDetails(@ApiParam(name = "fyxhList", value = "费用序号集合", required = true) 
    @RequestParam List<Integer> fyxhList){
		feeYlsfxmdjSer.getEntityMapper().selectInsert(this.getUser().getHospitalId(), fyxhList);
        return ReturnEntityUtil.success();
    }
	
	
	@RequestMapping("/allInInstitutionalDetails")
    @ResponseBody
    @ApiOperation(value="收费项目维护全部调入" ,httpMethod="POST")
    public ReturnEntity <String> allInInstitutionalDetails(@ApiParam(name = "fygbList", value = "费用归并集合", required = true) 
    @RequestParam List<Integer> fygbList){
		feeYlsfxmdjSer.allInInstitutionalDetails(fygbList, this.getUser());
        return ReturnEntityUtil.success();
    }
	
	
}
