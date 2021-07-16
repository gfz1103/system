package com.buit.his.sys.centermaintenance.api;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.PubFyxzDao;
import com.buit.his.sys.centermaintenance.model.PubFyxz;
import com.buit.system.request.PubFyxzApiReq;
import com.buit.system.service.PubFyxzService;
import com.buit.utill.BeanUtil;

/**
 * 公用费用限制外部接口实现
 * @ClassName: PubFyxzServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月14日 上午9:53:19
 *
 */
@DubboService(timeout = 10000)
public class PubFyxzServiceImpl implements PubFyxzService{

	@Autowired
	private PubFyxzDao pubFyxzDao;
	
	/**
	 * 获取费用禁用信息
	 * @Title: getFyjyInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param pubFyxzApiReq
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public Map<String, Object> getFyjyInfo(PubFyxzApiReq pubFyxzApiReq) {
		PubFyxz pubFyxz = BeanUtil.toBean(pubFyxzApiReq, PubFyxz.class);
		return pubFyxzDao.getFyjyInfo(pubFyxz);
	}

}
