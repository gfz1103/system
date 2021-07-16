
package com.buit.his.dic.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.dic.model.SysFlagData;
import com.buit.his.dic.model.SysFlagDataValue;
import com.buit.his.dic.response.Maindic;
import com.buit.his.dic.response.Sondic;
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
 * 系统标识字典<br>
 * 
 * @author wangyang
 */
@Api(tags = "系统标识字典")
@Controller
@RequestMapping("/sys/sysflagdata")
public class SysFlagDataCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SysFlagDataCtr.class);

	@Autowired
	private SysFlagDataSer sysFlagDataSer;
	@Autowired
	private SysFlagDataValueSer sysFlagDataValueSer;

	/**
	 * 字典主记录分页条件查询
	 * 
	 * @param flagDataName
	 * @param page
	 * @return
	 */
	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典主记录分页条件查询", httpMethod = "POST", notes = "字典主记录分页条件查询")
	public ReturnEntity<PageInfo<SysFlagData>> queryPage(
			@ApiParam(name = "flagDataName", value = "字典名称") @RequestParam(value = "flagDataName", required = false) String flagDataName,
			PageQuery page) {
		SysFlagData sysFlagData = new SysFlagData();
		sysFlagData.setFlagDataName(flagDataName);
		sysFlagDataSer.setSortColumns(sysFlagData);
		PageInfo<SysFlagData> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> sysFlagDataSer.findByEntity(sysFlagData));
		return ReturnEntityUtil.success(pageInfo);
	}

	/**
	 * 字典主记录新增
	 * 
	 * @param flagDataCode
	 * @param flagDataName
	 * @return
	 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "字典主记录新增", httpMethod = "POST", notes = "字典主记录新增")
	public ReturnEntity add(
			@ApiParam(name = "flagDataCode", value = "字典编码", required = true) @RequestParam(value = "flagDataCode") String flagDataCode,
			@ApiParam(name = "flagDataName", value = "字典名称", required = true) @RequestParam(value = "flagDataName") String flagDataName) {
		sysFlagDataSer.add(flagDataCode, flagDataName);
		return ReturnEntityUtil.success();
	}

	/**
	 * 标识数据字典
	 * 
	 * @return
	 */
	@RequestMapping("/getAllDic")
	@ResponseBody
	@ApiOperationSupport(author = "神算子")
	@ApiOperation(value = "标识数据字典", notes = "1)前台加载标示数据字典项</br>2)每个主项目的数据版本号</br>3)前后台每次使用会确认版本号", httpMethod = "POST")
	public ReturnEntity<List<Maindic>> getAllDic() {
		List<SysFlagData> listMain = sysFlagDataSer.findByEntity(null);
		if (listMain.size() == 0) {
			return ReturnEntityUtil.success();
		}
		SysFlagDataValue sysFlagDataValue = new SysFlagDataValue();

		List<Maindic> retList = new ArrayList<>();
		for (SysFlagData sysFlagData : listMain) {
			Maindic maindic = new Maindic();
			maindic.setDk(sysFlagData.getFlagDataCode());
			maindic.setDname(sysFlagData.getFlagDataName());
			maindic.setDversion(sysFlagData.getDataVersion());
			retList.add(maindic);
			sysFlagDataValue.setFlagDataId(sysFlagData.getFlagDataId());
			List<SysFlagDataValue> listSon = sysFlagDataValueSer.findByEntity(sysFlagDataValue);
			List<Sondic> resonList = new ArrayList<>();
			maindic.setSon(resonList);
			for (SysFlagDataValue sondb : listSon) {
				Sondic sondic = new Sondic();
				sondic.setDv(sondb.getFlagDataValue());
				sondic.setDn(sondb.getFlagDataValueRemark());
				sondic.setShowOrder(sondb.getSerialNumber());
				sondic.setStop(sondb.getStopFlag());
				sondic.setPy(sondb.getPyCode());
				sondic.setWb(sondb.getWbCode());
				resonList.add(sondic);
			}
		}
//		FileWriter writer = new FileWriter("test.properties");
		return ReturnEntityUtil.success(retList);
	}

	/**
	 * 取最新数据
	 * 
	 * @param dk
	 * @param dversion
	 * @return
	 */
	@RequestMapping("/getNewData")
	@ResponseBody
	@ApiOperationSupport(author = "神算子")
	@ApiOperation(value = "取最新数据", notes = "1)根据客户版本号判断是否有更新</br>2)如果无更新data节点空</br>3)如果有更新data节点,是最新数据", httpMethod = "POST")
	public ReturnEntity<Maindic> getNewData(
			@ApiParam(name = "dk", value = "字典ID", required = true) @RequestParam(value = "dk") String dk,
			@ApiParam(name = "dversion", value = "版本号", required = true) @RequestParam(value = "dversion") Integer dversion) {
		SysFlagData sysFlagData = sysFlagDataSer.getEntityMapper().findByCode(dk);
		if (sysFlagData == null) {
			return ReturnEntityUtil.success();
		}
		Maindic maindic = new Maindic();
		List<Sondic> resonList = new ArrayList<>();
		maindic.setSon(resonList);
		// 如果版本相同返回数据
		// 这里可以使用缓存 暂时不写
		if (dversion.equals(sysFlagData.getDataVersion())) {
			return ReturnEntityUtil.success(maindic);
		}
		maindic.setDk(sysFlagData.getFlagDataCode());
		maindic.setDname(sysFlagData.getFlagDataName());
		maindic.setDversion(sysFlagData.getDataVersion());
		SysFlagDataValue sysFlagDataValue = new SysFlagDataValue();
		sysFlagDataValue.setFlagDataId(sysFlagData.getFlagDataId());
		List<SysFlagDataValue> listSon = sysFlagDataValueSer.findByEntity(sysFlagDataValue);
		for (SysFlagDataValue sondb : listSon) {
			Sondic sondic = new Sondic();
			sondic.setDv(sondb.getFlagDataValue());
			sondic.setDn(sondb.getFlagDataValueRemark());
			sondic.setShowOrder(sondb.getSerialNumber());
			sondic.setStop(sondb.getStopFlag());
			sondic.setPy(sondb.getPyCode());
			sondic.setWb(sondb.getWbCode());
			resonList.add(sondic);
		}
		return ReturnEntityUtil.success(maindic);
	}

}
