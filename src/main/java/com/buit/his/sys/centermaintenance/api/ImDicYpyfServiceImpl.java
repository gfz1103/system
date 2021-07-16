package com.buit.his.sys.centermaintenance.api;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.ImDicYpyfDao;
import com.buit.system.model.ImDicYpyfModel;
import com.buit.system.service.ImDicYpyfService;
import com.buit.utill.BeanUtil;

/**
 * 药品用法外部接口实现
 * @ClassName: ImDicYpyfServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月14日 下午3:36:06
 *
 */
@DubboService(timeout = 10000)
public class ImDicYpyfServiceImpl implements ImDicYpyfService{

	@Autowired
	private ImDicYpyfDao imDicYpyfDao;
	
	@Override
	public ImDicYpyfModel getById(Integer id) {
		return BeanUtil.toBean(imDicYpyfDao.getById(id), ImDicYpyfModel.class);
	}

	@Override
	public List<ImDicYpyfModel> queryUncheckedList(Integer yfsb, Integer jgid, String value) {
		return BeanUtil.toBeans(imDicYpyfDao.queryUncheckedList(yfsb, jgid, value), ImDicYpyfModel.class);
	}

}
