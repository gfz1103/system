package com.buit.his.sys.centermaintenance.api;

import com.buit.his.sys.centermaintenance.dao.PubBrxzDao;
import com.buit.his.sys.centermaintenance.model.PubBrxz;
import com.buit.system.response.PubBrxzListResp;
import com.buit.system.response.PubBrxzOut;
import com.buit.system.service.PubBrxzOutSer;
import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@DubboService(timeout = 10000)
public class PubBrxzOutSerImpl implements PubBrxzOutSer {

	@Autowired
	private PubBrxzDao pubBrxzDao;

	@Override
	public List<PubBrxzListResp> getListByYpxh(Integer ypxh) {
		return pubBrxzDao.getListByYpxh(ypxh);
	}

	@Override
	public PubBrxzOut getById(Integer brxz) {
		return pubBrxzDao.getByIdRetOut(brxz);
	}

	/**
	 * 根据病人性质查询病人性质名称
	 * 
	 * @param brxz
	 * @return
	 */
	@Override
	public PubBrxzOut getBrmcPubBrxz(Integer brxz) {
		PubBrxz pubBrxz = pubBrxzDao.getBrmcPubBrxz(brxz);
		return BeanUtil.toBean(pubBrxz, PubBrxzOut.class);
	}

	@Override
	public List<Map<String, Object>> getSjxzList(String brxz) {
		return pubBrxzDao.getSjxzList(brxz);
	}

	@Override
	public PubBrxzOut querySjBrxz(Integer brxz) {
		return pubBrxzDao.getByIdRetOut(brxz);
	}

	@Override
	public List<PubBrxzOut> findByEntity(PubBrxzOut param) {
		return BeanUtil.toBeans(pubBrxzDao.findByEntity(param),PubBrxzOut.class) ;
	}

	@Override
	public Integer getSjxzByBrxz(Integer brxz) {
		return pubBrxzDao.getSjxzByBrxz(brxz);
	}

}
