package com.buit.his.sys.centermaintenance.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.buit.system.request.QueryFeeYlsfxmdjReq;
import com.buit.system.response.QueryJsJcResp;
import com.buit.system.response.SrfFeeYlsfxmdjResp;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmdjDao;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxmdj;
import com.buit.system.model.FeeYlsfxmdjModel;
import com.buit.system.service.FeeYlsfxmdjService;
import com.buit.utill.BeanUtil;

/**
 * 公用医院医疗明细项目外部接口实现
 * 
 * @ClassName: FeeYlsfxmdjServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月14日 下午1:22:50
 *
 */
@DubboService(timeout = 10000)
public class FeeYlsfxmdjServiceImpl implements FeeYlsfxmdjService {

	@Autowired
	private FeeYlsfxmdjDao feeYlsfxmdjDao;

	@Override
	public List<FeeYlsfxmdjModel> findByEntity(Object obj) {
		List<FeeYlsfxmdj> list = feeYlsfxmdjDao.findByEntity(obj);
		List<FeeYlsfxmdjModel> resList = new ArrayList<FeeYlsfxmdjModel>();
		resList = BeanUtil.toBeans(list, FeeYlsfxmdjModel.class);
		return resList;
	}

	/**
	 * 查询医疗明细信息
	 * 
	 * @param feeYlsfxmdjModel
	 * @return
	 */
	public List<FeeYlsfxmdjModel> getYlmxInfo(FeeYlsfxmdjModel feeYlsfxmdjModel) {
		List<FeeYlsfxmdjModel> list = feeYlsfxmdjDao.getYlmxInfo(feeYlsfxmdjModel);
		return list;
	}

	/**
	 * 查询费用单价
	 * 
	 * @author wy
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getFydj(Map<String, Object> map) {
		return feeYlsfxmdjDao.getFydj(map);
	}

	/**
	 * 查询
	 * 
	 * @param map
	 * @return
	 */
	public Map<String, Object> getJgbz(Map<String, Object> map) {
		return feeYlsfxmdjDao.getJgbz(map);
	}
	
	/**
	 * 检验 输入法查询 -挂号收费专用
	 * 
	 * @param par
	 * @return
	 */
	public List<QueryJsJcResp> doQueryJsjc(Map<String, Object> par){
		return feeYlsfxmdjDao.doQueryJsjc(par);
	}

	@Override
	public PageInfo<SrfFeeYlsfxmdjResp> querySrfJy(QueryFeeYlsfxmdjReq req) {
		PageInfo<SrfFeeYlsfxmdjResp> pageInfo = PageHelper.startPage(
				req.getPageNum(), req.getPageSize()).doSelectPageInfo(
				() -> feeYlsfxmdjDao.querySrfJy(req)
		);

		return pageInfo;
	}
}
