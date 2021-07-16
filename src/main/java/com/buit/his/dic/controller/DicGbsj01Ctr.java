package com.buit.his.dic.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.dic.model.DicGbsj01;
import com.buit.his.dic.request.DicGbsj01AddReq;
import com.buit.his.dic.request.DicGbsj01EditReq;
import com.buit.his.dic.request.DicGbsj01QueryReq;
import com.buit.his.dic.response.Maindic;
import com.buit.his.dic.response.DicGbsj01Resp;
import com.buit.his.dic.service.DicGbsj01Ser;
import com.buit.his.dic.service.DicGbsj02Ser;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 标准数据主记录<br>
 * @author 老花生
 */
@Api(tags="医院字典")
@Controller
@RequestMapping("/sys/dicgbsj01")
public class DicGbsj01Ctr extends BaseSpringController{

	static final Logger logger = LoggerFactory.getLogger(DicGbsj01Ctr.class);

	@Autowired
	private DicGbsj01Ser dicGbsj01Ser;
	@Autowired
	private DicGbsj02Ser dicGbsj01ValueSer;

	@RequestMapping("/queryByCondition")
	@ResponseBody
	@ApiOperationSupport(author = "老花生")
	@ApiOperation(value="字典--分页查询" ,httpMethod="POST")
	public ReturnEntity<PageInfo<DicGbsj01Resp>> queryPage(DicGbsj01QueryReq req){//@RequestBody
		DicGbsj01 data = BeanUtil.toBean(req, DicGbsj01.class);
		data.setHospitalId(getUser().getHospitalId());
		dicGbsj01Ser.setSortColumns(data);
		PageInfo<DicGbsj01> pageInfo = PageHelper.startPage(
				data.getPageNum(), data.getPageSize()).doSelectPageInfo(
				() -> dicGbsj01Ser.findByEntity(data)
		);
		return ReturnEntityUtil.success(BeanUtil.toPage(pageInfo, DicGbsj01Resp.class));
	}

	/** 新增 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "老花生")
	@ApiOperation(value="字典--新增" ,httpMethod="POST")
	public ReturnEntity add(@Valid DicGbsj01AddReq req) {
		dicGbsj01Ser.add(req, getUser());
		return ReturnEntityUtil.success();
	}

	/** 编辑 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "老花生")
	@ApiOperation(value="字典--编辑" ,httpMethod="POST")
	public ReturnEntity edit(@Valid DicGbsj01EditReq req) {
		dicGbsj01Ser.edit(req, getUser());
		return ReturnEntityUtil.success();
	}

	/** 删除 */
	@RequestMapping("/delete/{id}")
	@ResponseBody
	@ApiOperationSupport(author = "老花生")
	@ApiOperation(value="字典--删除" ,httpMethod="POST")
	public ReturnEntity delete(@PathVariable("id")Integer id) {
		dicGbsj01Ser.removeById(id);
		dicGbsj01ValueSer.removeById(id);
		return ReturnEntityUtil.success();
	}

	/**
	 * 取所有主数据字典的值
	 */
	@RequestMapping("/getAllDic")
	@ResponseBody
	@ApiOperationSupport(author = "神算子")
	@ApiOperation(value = "取所用集团字典", httpMethod = "POST")
	public ReturnEntity<List<Maindic>> getAllDic() {
		return ReturnEntityUtil.success(dicGbsj01Ser.getAllDic());
	}

	@RequestMapping("/getNewData")
	@ResponseBody
	@ApiOperationSupport(author = "神算子")
	@ApiOperation(value = "取最新数据", notes = "1)根据客户版本号判断是否有更新</br>2)如果无更新data节点空</br>3)如果有更新data节点,是最新数据", httpMethod = "POST")
	public ReturnEntity<Maindic> getNewData(
			@ApiParam(name = "dk", value = "字典ID", required = true) @RequestParam(value = "dk") String dk,
			@ApiParam(name = "dversion", value = "版本号", required = true) @RequestParam(value = "dversion") Integer dversion) {
		return ReturnEntityUtil.success(dicGbsj01Ser.getNewData(dk,dversion));
	}

}
