
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;
import java.util.stream.Collectors;

import com.buit.his.sys.centermaintenance.response.SsFeeYlsfxmResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.model.PubFybm;
import com.buit.his.sys.centermaintenance.request.DicSfxmlbReq;
import com.buit.his.sys.centermaintenance.request.DicSfxmlbXmgbReq;
import com.buit.his.sys.centermaintenance.request.DicSfxmlbYlReq;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlReq;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlSaveReq;
import com.buit.his.sys.centermaintenance.response.PubBrxzResp;
import com.buit.his.sys.centermaintenance.service.DicSfxmlbSer;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.his.sys.centermaintenance.service.PubFybmSer;
import com.buit.system.model.DicSfxmlb;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公用_收费项目<br>
 * 
 * @author GONGFANGZHOU
 */
@Api(tags = "收费项目维护")
@Controller
@RequestMapping("/dicsfxmlb")
public class DicSfxmlbCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(DicSfxmlbCtr.class);

	@Autowired
	private DicSfxmlbSer dicSfxmlbSer;

	@Autowired
	private FeeYlsfxmSer feeYlsfxmSer;

	@Autowired
	private PubFybmSer pubFybmSer;

	@RequestMapping("/queryMedicalProject")
	@ResponseBody
	@ApiOperation(value = "项目分页查询", httpMethod = "POST")
	public ReturnEntity<PageInfo<DicSfxmlb>> queryPage(
			@ApiParam(name = "fyfl", value = "费用分类(1:医疗2:药品3:其他)", required = true) @RequestParam Integer fyfl,
			@ApiParam(name = "pydm", value = "拼音代码", required = false) @RequestParam(value = "pydm", required = false) String pydm,
			PageQuery page) {
		DicSfxmlb dicSfxmlb = new DicSfxmlb();
		dicSfxmlb.setFyfl(fyfl);
		if (StrUtil.isNotBlank(pydm)) {
			dicSfxmlb.setPydm(pydm);
		}
		PageInfo<DicSfxmlb> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> dicSfxmlbSer.findByEntity(dicSfxmlb));
		return ReturnEntityUtil.success(pageInfo);
	}

	@RequestMapping("/chargingProjectsVerification")
	@ResponseBody
	@ApiOperation(value = "项目新增修改前校验", httpMethod = "POST")
	public ReturnEntity<String> chargingProjectsVerification(DicSfxmlbYlReq dicSfxmlbYlReq) {
		dicSfxmlbSer.chargingProjectsVerification(dicSfxmlbYlReq);
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/saveChargingProjects")
	@ResponseBody
	@ApiOperation(value = "项目新增或修改保存", httpMethod = "POST")
	public ReturnEntity<String> saveChargingProjects(DicSfxmlbReq dicSfxmlbReq) {
		dicSfxmlbSer.doSaveChargingProjects(dicSfxmlbReq);
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/consolidationProjects")
	@ResponseBody
	@ApiOperation(value = "项目归并", httpMethod = "POST")
	public ReturnEntity<String> consolidationProjects(DicSfxmlbXmgbReq dicSfxmlbXmgbReq) {
		DicSfxmlb dicSfxmlb = dicSfxmlbSer.getById(dicSfxmlbXmgbReq.getSfxm());
		BeanUtil.copyProperties(dicSfxmlbXmgbReq, dicSfxmlb,
				CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
		dicSfxmlbSer.update(dicSfxmlb);
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/queryFeeYlsfxmDetail")
	@ResponseBody
	@ApiOperation(value = "收费项目明细列表-分页", httpMethod = "POST")
	public ReturnEntity<PageInfo<FeeYlsfxm>> queryFeeYlsfxmDetail(FeeYlsfxmYlReq feeYlsfxmYlReq, PageQuery page) {

		return ReturnEntityUtil.success(feeYlsfxmSer.queryFeeYlsfxmDetail(feeYlsfxmYlReq,page));
	}

	@RequestMapping("/saveCostDetail")
	@ResponseBody
	@ApiOperation(value = "项目明细新增修改保存", httpMethod = "POST")
	public ReturnEntity<String> saveCostDetail(@RequestBody FeeYlsfxmYlSaveReq feeYlsfxmYlSaveReq) {
		dicSfxmlbSer.doSaveCostDetail(feeYlsfxmYlSaveReq);
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/logoutMedicalItems")
	@ResponseBody
	@ApiOperation(value = "项目明细作废或取消作废", httpMethod = "POST")
	public ReturnEntity<String> logoutMedicalItems(
			@ApiParam(name = "zfpb", value = "是否作废", required = true) @RequestParam Integer zfpb,
			@ApiParam(name = "fyxh", value = "费用序号", required = true) @RequestParam Integer fyxh) {
		dicSfxmlbSer.logoutMedicalItems(fyxh, zfpb, this.getUser());
		return ReturnEntityUtil.success();
	}

	@RequestMapping("/queryPubFybm")
	@ResponseBody
	@ApiOperation(value = "费用别名列表-分页", httpMethod = "POST")
	public ReturnEntity<PageInfo<PubFybm>> queryFeeYlsfxmDetail(
			@ApiParam(name = "fyxh", value = "费用序号", required = true) @RequestParam Integer fyxh, PageQuery page) {
		PubFybm pubFybm = new PubFybm();
		pubFybm.setFyxh(fyxh);
		PageInfo<PubFybm> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubFybmSer.findByEntity(pubFybm));
		return ReturnEntityUtil.success(pageInfo);
	}

	@RequestMapping("/queryCostLimit")
	@ResponseBody
	@ApiOperation(value = "项目费用限制列表", httpMethod = "POST")
	public ReturnEntity<List<PubBrxzResp>> queryCostLimit(
			@ApiParam(name = "fyxh", value = "费用序号", required = true) @RequestParam Integer fyxh) {
		return ReturnEntityUtil.success(dicSfxmlbSer.queryCostLimit(fyxh));
	}

}
