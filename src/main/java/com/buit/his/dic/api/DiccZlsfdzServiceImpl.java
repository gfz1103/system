package com.buit.his.dic.api;

import com.buit.his.sys.centermaintenance.dao.DiccZlsfdzDao;
import com.buit.system.response.LoadSqdDetailInfoResp;
import com.buit.system.model.DiccZlsfdzModel;
import com.buit.system.service.DiccZlsfdzService;
import com.buit.utill.BeanUtil;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 类名：DiccZlsfdzServiceImpl 描述：诊疗收费对照接口实现
 *
 * @author : liushijie 2020/10/14
 **/
@DubboService(timeout = 10000)
public class DiccZlsfdzServiceImpl implements DiccZlsfdzService {

	@Autowired
	private DiccZlsfdzDao diccZlsfdzDao;

	@Override
	public List<Integer> getListByZlxmidList(String[] zlxmids) {
		return diccZlsfdzDao.getListByZlxmidList(zlxmids);
	}

	/**
	 * 查询医技预病人申请单详细信息
	 * 
	 * @param jcxh
	 * @return
	 */
	public List<LoadSqdDetailInfoResp> loadSqdDetailInfo(Integer jcxh) {
		return diccZlsfdzDao.loadSqdDetailInfo(jcxh);
	}

	@Override
	public List<DiccZlsfdzModel> findByEntity(Object obj) {
		return BeanUtil.toBeans(diccZlsfdzDao.findByEntity(obj), DiccZlsfdzModel.class);
	}
}
