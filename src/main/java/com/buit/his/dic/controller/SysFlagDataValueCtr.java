
package com.buit.his.dic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.dic.model.SysFlagDataValue;
import com.buit.his.dic.service.SysFlagDataSer;
import com.buit.his.dic.service.SysFlagDataValueSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 系统标识字典从记录<br>
 * @author wangyang
 */
@Api(tags = "系统标识字典从记录")
@Controller
@RequestMapping("/sys/sysflagdatavalue")
public class SysFlagDataValueCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SysFlagDataValueCtr.class);

	@Autowired
	private SysFlagDataValueSer sysFlagDataValueSer;
	@Autowired
	private SysFlagDataSer sysFlagDataSer;

	/**
	 * 从记录分页条件查询
	 * 
	 * @param sysflagdata
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典从记录分页条件查询", httpMethod = "POST", notes = "字典从记录分页条件查询")
	public ReturnEntity<PageInfo<SysFlagDataValue>> queryValPage(
			@ApiParam(name = "flagDataId", value = "字典主记录唯一标识", required = true) @RequestParam(value = "flagDataId") Integer flagDataId,
			@ApiParam(name = "condition", value = "查询条件 编码或者名称") @RequestParam(value = "condition", required = false) String condition,
			PageQuery page) {
		SysFlagDataValue sysFlagDataValue = new SysFlagDataValue();
		sysFlagDataValue.setFlagDataId(flagDataId);
		sysFlagDataValue.setCondition(condition);
		sysFlagDataValue.setSortColumns("SERIAL_NUMBER");
		PageInfo<SysFlagDataValue> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> sysFlagDataValueSer.findByEntity(sysFlagDataValue));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 字典从记录新增
	 * 
	 * @param flagDataCode
	 * @param flagDataName
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典从记录新增", httpMethod = "POST", notes = "字典从记录新增")
	public ReturnEntity add(
			@ApiParam(name = "flagDataCode", value = "字典编码", required = true) @RequestParam(value = "flagDataCode") String flagDataCode,
			@ApiParam(name = "flagDataName", value = "字典名称", required = true) @RequestParam(value = "flagDataName") String flagDataName,
			@ApiParam(name = "serialNumber", value = "排序号", required = true) @RequestParam(value = "serialNumber") Integer serialNumber,
			@ApiParam(name = "flagDataId", value = "字典主记录唯一标识", required = true) @RequestParam(value = "flagDataId") Integer flagDataId) {
		sysFlagDataValueSer.add(flagDataCode, flagDataName, serialNumber, flagDataId);
		return ReturnEntityUtil.success();
	}

	/**
	 * 字典从记录修改
	 * 
	 * @param flagDataCode
	 * @param flagDataName
	 * @param serialNumber
	 * @param flagDataValueId
	 * @return
	 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典从记录修改", httpMethod = "POST", notes = "字典从记录修改")
	public ReturnEntity edit(
			@ApiParam(name = "flagDataCode", value = "字典编码", required = true) @RequestParam(value = "flagDataCode") String flagDataCode,
			@ApiParam(name = "flagDataName", value = "字典名称", required = true) @RequestParam(value = "flagDataName") String flagDataName,
			@ApiParam(name = "serialNumber", value = "排序号", required = true) @RequestParam(value = "serialNumber") Integer serialNumber,
			@ApiParam(name = "flagDataValueId", value = "字典从记录唯一标识", required = true) @RequestParam(value = "flagDataValueId") Integer flagDataValueId) {
		sysFlagDataValueSer.edit(flagDataCode, flagDataName, serialNumber, flagDataValueId);
		return ReturnEntityUtil.success();
	}

	/**
	 * 字典从记录修改时查询
	 * 
	 * @param flagDataValueId
	 * @return
	 */
	@RequestMapping("/getOneByEntity")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典从记录修改时查询", httpMethod = "POST", notes = "字典从记录修改时查询")
	public ReturnEntity<SysFlagDataValue> getOneByEntity(
			@ApiParam(name = "flagDataValueId", value = "字典从记录唯一标识", required = true) @RequestParam(value = "flagDataValueId") Integer flagDataValueId) {
		SysFlagDataValue sysFlagDataValue = sysFlagDataValueSer.getEntityMapper().getById(flagDataValueId);
		return ReturnEntityUtil.success(sysFlagDataValue);
	}

	/**
	 * 字典从记录启用/停用
	 * 
	 * @param flagDataValueId
	 * @param stopFlag
	 * @return
	 */
	@RequestMapping("/editEnable")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典从记录启用/停用", httpMethod = "POST", notes = "字典从记录启用/停用")
	public ReturnEntity editEnable(
			@ApiParam(name = "flagDataValueId", value = "字典从记录唯一标识", required = true) @RequestParam(value = "flagDataValueId") Integer flagDataValueId,
			@ApiParam(name = "stopFlag", value = "停用标识  0:启用，1:禁用", required = true) @RequestParam(value = "stopFlag") String stopFlag) {
		sysFlagDataValueSer.getEntityMapper().editEnable(flagDataValueId, stopFlag);
		SysFlagDataValue sysFlagDataValue=sysFlagDataValueSer.getById(flagDataValueId);
		sysFlagDataSer.getEntityMapper().addVersion(sysFlagDataValue.getFlagDataId());
		return ReturnEntityUtil.success();
	}

//    @RequestMapping("/getSysFlagDataValueList")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public PageInfo<SysFlagDataValueResp> queryPage(SysFlagDataValueReq req){
//    	req.setHospitalId(getUser().getHospitalId());
//        PageInfo<SysFlagDataValueResp> pageInfo = PageHelper.startPage(
//        		req.getPageNum(), req.getPageSize()).doSelectPageInfo(
//                    () -> sysFlagDataValueSer.findByEntity(req)
//            );
//        return pageInfo;
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SysFlagDataValueResp>> getByEntity( SysFlagDataValueReq sysflagdatavalue){//@RequestBody 
//        return ReturnEntityUtil.success(sysFlagDataValueSer.findByEntity(sysflagdatavalue));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysFlagDataValueResp> getOneByEntity(SysFlagDataValueReq sysflagdatavalue){
//        List<SysFlagDataValue> list=sysFlagDataValueSer.findByEntity(sysflagdatavalue);
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
//    public ReturnEntity add(@Valid SysFlagDataValueAddReq sysFlagDataValue) {
//        sysFlagDataValueSer.add(sysFlagDataValue);
//        return ReturnEntityUtil.success();
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity edit(@Valid SysFlagDataValueEditReq sysFlagDataValue)  {
//        sysFlagDataValueSer.edit(sysFlagDataValue);
//        return ReturnEntityUtil.success();
//    }
//
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="根据id删除" ,httpMethod="POST")
//    public ReturnEntity delete(Integer flagdatavalueId) {
//        sysFlagDataValueSer.delete(flagdatavalueId);
//        return ReturnEntityUtil.success();
//    }

}
