package com.buit.his.sys.centermaintenance.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.DicKszdDao;
import com.buit.system.model.DicKszd;
import com.buit.system.response.DicKszdModel;
import com.buit.system.service.DicKszdOutSer;
import com.buit.utill.BeanUtil;

import cn.hutool.core.collection.CollectionUtil;

/**
 * @author : 神算子
 *  2020年10月9日14:10:33
 **/
@DubboService(timeout = 10000)
public class DicKszdOutSerImpl implements DicKszdOutSer {

    @Autowired
    private DicKszdDao dicKszdDao;
    /**
     * 根据ID取科室名称
     * @param ksid  科室ID
     * @return 科室ID 名称
     */
	@Override
	public String getNameById(Integer ksid) {
		DicKszd dicKszd=dicKszdDao.getById(ksid);
		if(dicKszd!=null) {
			return dicKszd.getOfficename();
		}
		return null;
	}

	/**
	 * 获取特定字典文件的Value
	 * @Title: getVauleByKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param jgid
	 * @param @param id
	 * @param @return    设定文件
	 * @return String    返回类型
	 * @author 龚方舟
	 * @throws
	 */
	@Override
	public String getVauleByKey(Integer jgid, Integer id) {
		DicKszd dicKszd = dicKszdDao.getVauleByKey(jgid, id);
		if(dicKszd != null) {
			return dicKszd.getOfficename();
		}
		return null;
	}

	@Override
	public List<DicKszdModel> getOfficeNameByJgidAndStrId(Integer jgid, String id) {
		List<DicKszd> list = dicKszdDao.getOfficeName(jgid, id);
		List<DicKszdModel> resList = new ArrayList<DicKszdModel>();
		if(CollectionUtil.isNotEmpty(list)) {
			resList = BeanUtil.toBeans(list, DicKszdModel.class);
		}
		return resList;
	}

	@Override
	public List<DicKszdModel> findByEntity(Object obj) {
		return  BeanUtil.toBeans(dicKszdDao.findByEntity(obj),DicKszdModel.class)  ;
	}

	@Override
	public List<DicKszdModel> queryZyBrksDic(Integer hospitalId) {
		return BeanUtil.toBeans(dicKszdDao.queryZyBrksDic(hospitalId),DicKszdModel.class)  ;
	}

	@Override
	public Map<String, Object> getYbksdm(Integer ksdm) {
		return dicKszdDao.getYbksdm(ksdm);
	}
	@Override
	public Map<String, Object> getYbksdmzy(Integer brks) {
		return dicKszdDao.getYbksdmzy(brks);
	}

	/**
	 * 根据ID查询
	 *
	 * @param id
	 * @return
	 */
	@Override
	public DicKszd getById(Integer id) {
		return dicKszdDao.getById(id);
	}

	@Override
	public Map<String, Object> getKsInfo(Map<String, Object> map) {
		return dicKszdDao.getKsInfo(map);
	}
}
