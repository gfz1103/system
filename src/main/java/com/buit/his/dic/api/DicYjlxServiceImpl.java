package com.buit.his.dic.api;

import com.buit.his.sys.centermaintenance.dao.DicYjlxDao;
import com.buit.his.sys.centermaintenance.model.DicYjlx;
import com.buit.his.sys.centermaintenance.response.DicYjlxZlxmResp;
import com.buit.his.sys.centermaintenance.service.DicYjlxSer;
import com.buit.system.model.DicYjlxModel;
import com.buit.system.response.DicYjlxZlxmApiResp;
import com.buit.system.service.DicYjlxService;
import com.buit.utill.BeanUtil;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：DicYjlxServiceImpl
 * 描述：医技类型接口实现
 *
 * @author : liushijie
 * 2020/10/14
 **/
@DubboService(timeout = 10000)
public class DicYjlxServiceImpl implements DicYjlxService {
    @Autowired
    private DicYjlxDao dicYjlxDao;

    @Override
    public DicYjlxModel getById(Integer yjlx) {
        DicYjlx dicYjlx = dicYjlxDao.getById(yjlx);
        return BeanUtil.toBean(dicYjlx, DicYjlxModel.class);
    }

	@Override
	public DicYjlxZlxmApiResp queryDicYjlxById(Integer id) {
		DicYjlxZlxmResp resp = dicYjlxDao.queryDicYjlxById(id);
		return BeanUtil.toBean(resp, DicYjlxZlxmApiResp.class);
	}

	@Override
	public DicYjlxModel queryFirstYjlx(DicYjlxModel dicYjlxModel) {
		DicYjlx model = dicYjlxDao.getById(dicYjlxModel.getId());
		Integer pid = model.getPid();
		if(pid != 0) {
			model = dicYjlxDao.getById(pid);
			DicYjlxModel newModel = BeanUtil.toBean(model, DicYjlxModel.class);
			return queryFirstYjlx(newModel);
		}else {
			return BeanUtil.toBean(model, DicYjlxModel.class);
		}
	}
}
