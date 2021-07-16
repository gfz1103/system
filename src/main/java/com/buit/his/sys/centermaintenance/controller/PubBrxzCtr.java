
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
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
import com.buit.his.sys.centermaintenance.model.PubBrxz;
import com.buit.his.sys.centermaintenance.request.FeeSfdlzfblEditReq;
import com.buit.his.sys.centermaintenance.request.FeeYpxzAddReq;
import com.buit.his.sys.centermaintenance.request.FeeYpxzEditReq;
import com.buit.his.sys.centermaintenance.request.PubBrxzEditReq;
import com.buit.his.sys.centermaintenance.request.PubBrxzNewAddReq;
import com.buit.his.sys.centermaintenance.request.PubFyxzAddReq;
import com.buit.his.sys.centermaintenance.response.FeeYpxzYpxzResp;
import com.buit.his.sys.centermaintenance.response.GyFyxzDicResp;
import com.buit.his.sys.centermaintenance.response.PubBrxzTreeResp;
import com.buit.his.sys.centermaintenance.service.PubBrxzSer;
import com.buit.system.response.DicSfxmlbZfblResp;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公用_病人性质 | 包括自费、公费、记帐等<br>
 *
 * @author MLeo
 */
@Api(tags = "病人性质维护")
@Controller
@RequestMapping("/pubbrxz")
public class PubBrxzCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(PubBrxzCtr.class);

	@Autowired
	private PubBrxzSer pubBrxzSer;
	@Autowired
	private SysDictConfigSerImpl sysDictConfigSer;

	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperation(value = "按条件分页查询", httpMethod = "POST")
	public ReturnEntity<PageInfo<PubBrxz>> queryPage(
			@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
		PubBrxz condition = new PubBrxz();
		condition.setPydm(pydm);
		PageInfo<PubBrxz> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubBrxzSer.findByEntity(condition));
		return ReturnEntityUtil.success(pageInfo);
	}

	@RequestMapping("/queryDetail")
	@ResponseBody
	@ApiOperation(value = "病人性质详情", httpMethod = "POST")
	public ReturnEntity<PubBrxz> queryDetail(
			@ApiParam(name = "brxz", value = "病人性质", required = true) @RequestParam Integer brxz) {
		PubBrxz pubBrxz = pubBrxzSer.getById(brxz);
		return ReturnEntityUtil.success(pubBrxz);
	}

	@RequestMapping("/queryTree")
	@ResponseBody
	@ApiOperation(value = "病人性质树", httpMethod = "POST")
	public ReturnEntity<List<PubBrxzTreeResp>> queryTree() {
		return ReturnEntityUtil.success(pubBrxzSer.getTree());
	}

	@RequestMapping("/add")
	@ResponseBody
	@ApiOperation(value = "病人性质-新增", httpMethod = "POST")
	public ReturnEntity<String> add(@Valid PubBrxzNewAddReq req) {
		pubBrxzSer.add(req);

		return ReturnEntityUtil.success();
	}

	/**
	 * 编辑
	 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "MLeo")
	@ApiOperation(value = "病人性质-编辑", httpMethod = "POST")
	public ReturnEntity<String> edit(@Valid PubBrxzEditReq req) {
		PubBrxz pubBrxz = BeanUtil.toBean(req, PubBrxz.class);
		pubBrxz.setPydm(PinyinUtils.getSimplePinYin(pubBrxz.getXzmc()));
		pubBrxz.setGsxz(req.getSjxz());
		pubBrxzSer.update(pubBrxz);
		sysDictConfigSer.upDateVersion("pub_brxz");
		return ReturnEntityUtil.success();
	}

	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperation(value = "病人性质-删除", httpMethod = "POST")
	public ReturnEntity<String> delete(
			@ApiParam(name = "brxz", value = "性质代码", required = true) @RequestParam int brxz) {
		pubBrxzSer.removeById(brxz);
		sysDictConfigSer.upDateVersion("pub_brxz");
		return ReturnEntityUtil.success();
	}

	/**
	 * 自负比例列表
	 */
	@RequestMapping("/queryBrxzZfbl")
	@ResponseBody
	@ApiOperation(value = "自负比例列表", httpMethod = "POST")
	public ReturnEntity<List<DicSfxmlbZfblResp>> queryBrxzZfbl(
			@ApiParam(name = "brxz", value = "性质代码", required = true) @RequestParam int brxz) {
		return ReturnEntityUtil.success(pubBrxzSer.queryBrxzZfbl(brxz));
	}

	/**
	 * 自负比例-编辑
	 */
	@RequestMapping("/zfblEdit")
	@ResponseBody
	@ApiOperation(value = "自负比例-编辑", httpMethod = "POST")
	public ReturnEntity<String> zfblEdit(@Valid FeeSfdlzfblEditReq req) {
		pubBrxzSer.zfblEdit(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 药品限制列表
	 */
	@RequestMapping("/queryYpxzList")
	@ResponseBody
	@ApiOperation(value = "药品限制列表", httpMethod = "POST")
	public ReturnEntity<PageInfo<FeeYpxzYpxzResp>> queryYpxzList(
			@ApiParam(name = "brxz", value = "性质代码", required = true) @RequestParam int brxz,
			@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
		PageInfo<FeeYpxzYpxzResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubBrxzSer.queryYpxzList(brxz, pydm));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 药品限制-药品输入法
	 */
//    @RequestMapping("/ypDic")
//    @ResponseBody
//    @ApiOperation(value = "药品限制-药品输入法", httpMethod = "POST")
//    public ReturnEntity<PageInfo<YpxzDicResp>> queryYpDic(@ApiParam(name = "pydm", value = "拼音代码", required = true) @RequestParam String pydm, PageQuery page) {
//        PageInfo<YpxzDicResp> pageInfo = PageHelper.startPage(
//                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                () -> pubBrxzSer.queryYpDic(pydm)
//        );
//        return ReturnEntityUtil.success(pageInfo);
//    }

	/**
	 * 药品限制-新增
	 */
	@RequestMapping("/ypxzAdd")
	@ResponseBody
	@ApiOperation(value = "药品限制-新增", httpMethod = "POST")
	public ReturnEntity<String> ypxzAdd(@Valid FeeYpxzAddReq req) {
		pubBrxzSer.ypxzAdd(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 药品限制-编辑
	 */
	@RequestMapping("/ypxzEdit")
	@ResponseBody
	@ApiOperation(value = "药品限制-编辑", httpMethod = "POST")
	public ReturnEntity<String> ypxzEdit(@Valid FeeYpxzEditReq req) {
		pubBrxzSer.ypxzEdit(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 药品限制-删除
	 */
	@RequestMapping("/ypxzDelete")
	@ResponseBody
	@ApiOperation(value = "药品限制-删除", httpMethod = "POST")
	public ReturnEntity<String> ypxzDelete(
			@ApiParam(name = "brxz", value = "病人性质", required = true) @RequestParam Integer brxz,
			@ApiParam(name = "ypxh", value = "药品序号", required = true) @RequestParam Integer ypxh) {
		pubBrxzSer.ypxzDelete(brxz, ypxh);
		return ReturnEntityUtil.success();
	}

	/**
	 * 费用限制列表
	 */
	@RequestMapping("/queryFyxzList")
	@ResponseBody
	@ApiOperation(value = "费用限制列表", httpMethod = "POST")
	public ReturnEntity<PageInfo<FeeYpxzYpxzResp>> queryFyxzList(
			@ApiParam(name = "brxz", value = "性质代码", required = true) @RequestParam int brxz,
			@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
		PageInfo<FeeYpxzYpxzResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubBrxzSer.queryFyxzList(brxz, pydm));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 费用限制-输入法
	 */
	@RequestMapping("/fyDic")
	@ResponseBody
	@ApiOperation(value = "费用限制-输入法", httpMethod = "POST")
	public ReturnEntity<PageInfo<GyFyxzDicResp>> queryBrxzDic(
			@ApiParam(name = "pydm", value = "拼音代码", required = true) @RequestParam String pydm, PageQuery page) {
		PageInfo<GyFyxzDicResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> pubBrxzSer.queryBrxzDic(pydm));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 费用限制-新增
	 */
	@RequestMapping("/fyxzAdd")
	@ResponseBody
	@ApiOperation(value = "费用限制-新增", httpMethod = "POST")
	public ReturnEntity<String> fyxzAdd(@Valid PubFyxzAddReq req) {
		pubBrxzSer.fyxzAdd(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 费用限制-编辑
	 */
	@RequestMapping("/fyxzEdit")
	@ResponseBody
	@ApiOperation(value = "费用限制-编辑", httpMethod = "POST")
	public ReturnEntity<String> fyxzEdit(@Valid PubFyxzAddReq req) {
		pubBrxzSer.fyxzEdit(req);
		return ReturnEntityUtil.success();
	}

	/**
	 * 费用限制-删除
	 */
	@RequestMapping("/fyxzDelete")
	@ResponseBody
	@ApiOperation(value = "费用限制-删除", httpMethod = "POST")
	public ReturnEntity<String> fyxzDelete(
			@ApiParam(name = "brxz", value = "病人性质", required = true) @RequestParam Integer brxz,
			@ApiParam(name = "fyxh", value = "费用序号", required = true) @RequestParam Integer fyxh) {
		pubBrxzSer.fyxzDelete(brxz, fyxh);
		return ReturnEntityUtil.success();
	}

}
