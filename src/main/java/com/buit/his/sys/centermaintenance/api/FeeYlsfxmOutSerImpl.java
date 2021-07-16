package com.buit.his.sys.centermaintenance.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.system.request.GyYlxmDicReq;
import com.buit.system.request.IFeeYlsfxmReq;
import com.buit.system.response.*;

import com.buit.system.model.FeeYlsfxmModel;
import com.buit.system.service.FeeYlsfxmOutSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.BeanUtil;
import com.buit.utill.ParamUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.commons.PageQuery;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmDao;

import com.buit.system.model.FeeYlsfxmModel;
import com.buit.system.request.FeeYlsfxmProjectSrfApiReq;
import com.buit.system.request.FeeYlsfxmProjectSrfReq;
import com.buit.system.service.FeeYlsfxmOutSer;

@DubboService(timeout = 10000)
public class FeeYlsfxmOutSerImpl implements FeeYlsfxmOutSer {

	@Autowired
	private FeeYlsfxmDao feeYlsfxmDao;

	@Override
	public List<FeeYlsfxmOutResp> queryByFyxh(List<Integer> ypxhList) {
		return feeYlsfxmDao.queryByFyxh(ypxhList);
	}
	@Override
	public Map<String, Object> getBxInfo(Map<String, Object> param) {
		return feeYlsfxmDao.getBxInfo(param);
	}

	@Override
	public PageInfo<YjQueryPageHelperResp> queryPageHelper(HashMap<Object, Object> map) {
		PageInfo<YjQueryPageHelperResp> pageInfo = PageHelper
				.startPage(ObjectToTypes.parseInt(map.get("pageNum")), ObjectToTypes.parseInt(map.get("pageSize")))
				.doSelectPageInfo(() -> feeYlsfxmDao.queryPageHelper(map));
		return pageInfo;
	};

	@Override
	public FeeYlsfxmOutResp getById(Integer al_fyxh) {
		return BeanUtil.toBean(feeYlsfxmDao.getById(al_fyxh), FeeYlsfxmOutResp.class);
	}

	@Override
	public List<GyYlxmDicResp> queryZlFeeYlsfxm(Integer hospitalId) {
		return feeYlsfxmDao.queryZlFeeYlsfxm(hospitalId);
	}

	@Override
	public List<Map<String, Object>> getFyxhFymcZfpbYbbm(Map<String, Object> parameters) {
		return feeYlsfxmDao.getFyxhFymcZfpbYbbm(parameters);
	}

	@Override
	public List<Map<String, Object>> getBxfy(Map<String, Object> parameters) {
		return feeYlsfxmDao.getBxfy(parameters);
	}

	@Override
	public List<FeeYlsfxmModel> findByEntity(Object obj) {
		return BeanUtil.toBeans(feeYlsfxmDao.findByEntity(obj), FeeYlsfxmModel.class);
	}

	@Override
	public PageInfo<FeeYlsfxmModel> findPageByEntity(IFeeYlsfxmReq req) {
		PageInfo<FeeYlsfxm> pageInfo = PageHelper.startPage(
				req.getPageNum(), req.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.findByEntity(req)
		);
		return BeanUtil.toPage(pageInfo, FeeYlsfxmModel.class);
	}

	@Override
	public List<FeeYlsfxmModel> findByEntity(IFeeYlsfxmReq req) {
		return BeanUtil.toBeans(feeYlsfxmDao.findByEntity(req), FeeYlsfxmModel.class);
	}

	@Override
	public Map<String, Object> queryXmSbjg(Integer fyxh) {
		return feeYlsfxmDao.queryXmSbjg(fyxh);
	}

	@Override
	public long findByEntityCount(Object obj) {
		return feeYlsfxmDao.findByEntityCount(obj);
	}

	@Override
	public List<GyYlxmDicResp> queryZlxmDicList(int jgid, String pydm) {
		return feeYlsfxmDao.queryZlxmDicList(jgid, pydm);
	}

	@Override
	public List<GyYlxmDicResp> queryZlFeeYlsfxm(int jgid) {
		return feeYlsfxmDao.queryZlFeeYlsfxm(jgid);
	}

	@Override
	public List<FeeYlsfxmProjectSrfApiResp> queryProjectOrder(FeeYlsfxmProjectSrfApiReq feeYlsfxmProjectSrfApiReq) {
		return feeYlsfxmDao.queryProjectOrder(feeYlsfxmProjectSrfApiReq);
	}

	/**
	 *
	 *
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> getYlsfInfoBybrxzOne(Map<String, Object> parameters) {
		return feeYlsfxmDao.getYlsfInfoBybrxzOne(parameters);
	}

	/**
	 *
	 *
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> getYlsfInfoBybrxzTwo(Map<String, Object> parameters) {
		return feeYlsfxmDao.getYlsfInfoBybrxzTwo(parameters);
	}


	@Override
	public PageInfo<IFeeYlsfxm> allInfoNoUser(IFeeYlsfxmReq req) {
		Map<String, Object> map = ParamUtil.instance().put("pydm", req.getPydm());

		PageInfo<IFeeYlsfxm> pageInfo = PageHelper.startPage(
				req.getPageNum(), req.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.allInfoNoUser(req.getPydm())
		);
		return pageInfo;
	}




	@Override
	public PageInfo<GyYlxmDicResp> queryZlxmDicList(GyYlxmDicReq gyYlxmDicReq) {

		PageInfo<GyYlxmDicResp> pageInfo = PageHelper.startPage(
				gyYlxmDicReq.getPageNum(), gyYlxmDicReq.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.queryZlxmDicList(gyYlxmDicReq.getJgid(),gyYlxmDicReq.getPydm())
		);
		return pageInfo;

	}
	
	
	@Override
	public PageInfo<FeeYlsfxmProjectSrfApiResp> queryProjectOrderByPageInfo(
			FeeYlsfxmProjectSrfApiReq req) {
		PageInfo<FeeYlsfxmProjectSrfApiResp> pageInfo = PageHelper.startPage(
				req.getPageNum(), req.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.queryProjectOrder(req)
		);
		return pageInfo;
	}
	
	@Override
	public PageInfo<FeeYlsfxmProjectSrfResp> queryExpenseAccountingByPageInfo(
			FeeYlsfxmProjectSrfReq req) {
		PageInfo<FeeYlsfxmProjectSrfResp> pageInfo = PageHelper.startPage(
				req.getPageNum(), req.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.queryExpenseAccounting(req)
		);
		return pageInfo;
	}

	/**
	 * 手麻卫材收费项目输入法
	 * @param jgid
	 * @param pydm
	 * @return
	 */
	@Override
	public List<SsInputResp> querySsInputMaterial(Integer jgid, String pydm) {
		return feeYlsfxmDao.querySsInputMaterial(jgid,pydm);
	}

	@Override
	public PageInfo<SsInputResp> querySsInputMaterialPage(Integer jgid, String pydm,PageQuery page) {
		PageInfo<SsInputResp> pageInfo = PageHelper.startPage(
				page.getPageNum(), page.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.querySsInputMaterial(jgid,pydm)
		);

		return pageInfo;
	}

	/**
	 * 手麻收费项目输入法字典
	 * @param jgid
	 * @param pydm
	 * @return
	 */
	@Override
	public List<SsInputResp> querySsInputItem(Integer jgid, String pydm) {
		 return feeYlsfxmDao.querySsInputItem(jgid,pydm);
	}

	@Override
	public PageInfo<SsInputResp> querySsInputItemPage(Integer jgid, String pydm,PageQuery page) {
		PageInfo<SsInputResp> pageInfo = PageHelper.startPage(
				page.getPageNum(), page.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmDao.querySsInputItem(jgid,pydm)
		);

		return pageInfo;
	}

	@Override
	public List<FeeYlsfxmOutResp> queryInnerDjByFyxh(Integer jgid,List<Integer> fyxhList) {

		return feeYlsfxmDao.queryInnerDjByFyxh(jgid,fyxhList);
	}


}
