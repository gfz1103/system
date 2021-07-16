package com.buit.his.sys.centermaintenance.api;

import java.util.List;

import com.buit.his.sys.centermaintenance.service.DicYljgSer;
import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.DicYljgDao;
import com.buit.system.response.DicYljgOut;
import com.buit.system.service.DicYljgOutSer;

/**
 * 类名：DicJbbmServiceImpl
 * 描述：疾病编码字典接口实现
 *
 * @author : liushijie
 * 2020/9/15
 **/
@DubboService(timeout = 10000)
public class DicYljgOutSerImpl implements DicYljgOutSer {

    @Autowired
    private DicYljgDao dicYljgDao;

	@Autowired
	private DicYljgSer dicYljgSer;

	@Override
	public List<DicYljgOut> queryByJgid(List<String> jgidList) {
		return dicYljgDao.queryByJgid(jgidList);
	}

	@Override
	public DicYljgOut getById(Integer id) {
		// TODO Auto-generated method stub
		return BeanUtil.toBean(dicYljgDao.getById(id),DicYljgOut.class);
	}

	@Override
	public List<DicYljgOut> getAllYljg() {
		return dicYljgDao.getAllYljg();
	}



}
