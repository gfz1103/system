package com.buit.his.sys.centermaintenance.api;


import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.FeeSfdlzfblDao;
import com.buit.system.response.FeeSfdlzfbl;
import com.buit.system.service.FeeSfdlzfblOutSer;


/**
 * 公用自负比例外部接口实现
 * @ClassName: FeeSfdlzfblOutSerImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年10月13日 下午8:16:14
 *
 */
@DubboService(timeout = 10000)
public class FeeSfdlzfblOutSerImpl implements FeeSfdlzfblOutSer{
	
	@Autowired
	private FeeSfdlzfblDao feeSfdlzfblDao;

	/**
	 * 根据brxz、fyxm查询
	 * @Title: getByBrxzAndSfxm
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param brxz
	 * @param @param fyxm
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public FeeSfdlzfbl getByBrxzAndSfxm(Integer brxz, Integer fyxm) {
		return feeSfdlzfblDao.getByBrxzAndSfxm(brxz, fyxm);
	}

	
	/**
	 * 获取自负比例信息
	 * @Title: getZfblInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param feeSfdlzfbl
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public Map<String, Object> getZfblInfo(FeeSfdlzfbl feeSfdlzfbl) {
		return feeSfdlzfblDao.getZfblInfo(feeSfdlzfbl);
	}

	
	/**
	 * 获取自负比例信息 map方式的
	 * @Title: getZfblMap
	 * @Description: TODO(这里用一句话描述这个方法的作用)	 
	 * @param @param map
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public List<Map<String, Object>> getZfblMap(Map<String, Object> map) {
		return feeSfdlzfblDao.getZfblMap(map);
	}

	
	/**
	 * 获取病人性质
	 * @Title: getBrxzInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)	 
	 * @param @return    设定文件
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public List<FeeSfdlzfbl> getBrxzInfo() {
		return feeSfdlzfblDao.getBrxzInfo();
	}

}
