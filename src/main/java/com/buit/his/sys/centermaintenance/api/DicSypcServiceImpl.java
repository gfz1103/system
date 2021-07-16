package com.buit.his.sys.centermaintenance.api;

import java.util.ArrayList;
import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.model.DicSypc;
import com.buit.his.sys.centermaintenance.service.DicSypcSer;
import com.buit.system.request.DicSypcApiReq;
import com.buit.system.response.DicSypcModel;
import com.buit.system.service.DicSypcService;
import com.buit.utill.BeanUtil;


/**
 * 使用频次外部接口实现
 * @ClassName: DicSypcServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月13日 下午6:24:45
 *
 */
@DubboService(timeout = 10000)
public class DicSypcServiceImpl implements DicSypcService{

	@Autowired
	private DicSypcSer dicSypcSer;
	
	@Override
	public DicSypcModel getById(String id) {
		DicSypc dicSypc = dicSypcSer.getById(id);
		return BeanUtil.toBean(dicSypc, DicSypcModel.class);
	}

	@Override
	public List<DicSypcModel> findByEntity(DicSypcApiReq req) {
		List<DicSypc> list = dicSypcSer.findByEntity(req);
		List<DicSypcModel> resList = new ArrayList<DicSypcModel>();
		for(DicSypc dicSypc : list) {
			DicSypcModel model = BeanUtil.toBean(dicSypc, DicSypcModel.class);
			resList.add(model);
		}
		return resList;
	}

}
