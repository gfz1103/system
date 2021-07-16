package com.buit.his.sys.centermaintenance.api;

import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.FeeYpxzDao;
import com.buit.his.sys.centermaintenance.model.FeeYpxz;
import com.buit.system.request.FeeYpxzApiReq;
import com.buit.system.service.FeeYpxzService;
import com.buit.utill.BeanUtil;

/**
 * 公用药品禁用外部接口实现
 * @ClassName: FeeYpxzServiceImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月14日 上午10:15:37
 *
 */
@DubboService(timeout = 10000)
public class FeeYpxzServiceImpl implements FeeYpxzService{

	@Autowired
	private FeeYpxzDao feeYpxzDao;
	
	/**
	 * 获取药品禁用信息
	 * @Title: getYpjyInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)	 
	 * @param @param feeYpxzApiReq
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public Map<String, Object> getYpjyInfo(FeeYpxzApiReq feeYpxzApiReq) {
		FeeYpxz feeYpxz = BeanUtil.toBean(feeYpxzApiReq, FeeYpxz.class);
		return feeYpxzDao.getYpjyInfo(feeYpxz);
	}

}
