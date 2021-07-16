package com.buit.his.sys.centermaintenance.api;

import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.DicSfxmlbDao;
import com.buit.system.model.DicSfxmlb;
import com.buit.system.response.DicSfxmlbZfblResp;
import com.buit.system.service.DicSfxmlbService;

/**
 * 公用付款方式服务实现类
 * 
 * @author 汪洋
 */
@DubboService(timeout = 10000)
public class DicSfxmlbServiceImpl implements DicSfxmlbService {
	@Autowired
	private DicSfxmlbDao dicSfxmlbDao;

	/**
	 * 医疗项目修改前校验 @Title: findCountNotEqualSfxm @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param dicSfxmlb @param @return 设定文件 @return
	 * long 返回类型 @author 龚方舟 @throws
	 */
	public long findCountNotEqualSfxm(DicSfxmlb dicSfxmlb) {
		return dicSfxmlbDao.findCountNotEqualSfxm(dicSfxmlb);
	}

	/**
	 * 查询公用收费项目信息 @Title: queryDicSfxmlbInfo @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param sfxm @param @return 设定文件 @return
	 * Map<String,Object> 返回类型 @author 龚方舟 @throws
	 */
	public Map<String, Object> queryDicSfxmlbInfo(Integer sfxm) {
		return dicSfxmlbDao.queryDicSfxmlbInfo(sfxm);
	}

	/**
	 * 中心维护-病人性质-自负比例列表
	 * 
	 * @param brxz 病人性质代码
	 * @return
	 */
	public List<DicSfxmlbZfblResp> queryBrxzZfbl(Integer brxz) {
		return dicSfxmlbDao.queryBrxzZfbl(brxz);
	}

	/**
	 * 费用归并
	 * 
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> doQueryGbje(Map<String, Object> parameters) {
		return dicSfxmlbDao.doQueryGbje(parameters);
	}

	/**
	 * 费用归并
	 * 
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> doQueryGbjeByCondition(Map<String, Object> parameters) {
		return dicSfxmlbDao.doQueryGbjeByCondition(parameters);
	}

	/**
	 * 归并金额
	 * 
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> doQueryGbjeA(Map<String, Object> parameters) {
		return dicSfxmlbDao.doQueryGbjeA(parameters);
	}

	/**
	 * 医技归并金额
	 * 
	 * @param parameters
	 * @return
	 */
	public List<Map<String, Object>> doQueryYjGbJe(Map<String, Object> parameters) {
		return dicSfxmlbDao.doQueryYjGbJe(parameters);
	}

	/**
	 * 获取医保门诊项目代码
	 * 
	 * @param parameters
	 * @return
	 */
	public Map<String, Object> getYbmzxm(Map<String, Object> parameters) {
		return dicSfxmlbDao.getYbmzxm(parameters);
	}

	/**
	 * 查询收费项目
	 *
	 * @param parameters
	 * @return
	 */
	public Map<String, Object> doQuerySfxm(Map<String, Object> parameters) {
		return dicSfxmlbDao.doQuerySfxm(parameters);
	}

	@Override
	public List<DicSfxmlb> findByEntity(DicSfxmlb dicSfxmlbParam) {
		return dicSfxmlbDao.findByEntity(dicSfxmlbParam);
	}

	@Override
	public long findByEntityCount(Object obj) {
		return dicSfxmlbDao.findByEntityCount(obj);
	}
}
