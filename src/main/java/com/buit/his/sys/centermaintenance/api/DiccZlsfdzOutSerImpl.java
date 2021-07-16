package com.buit.his.sys.centermaintenance.api;

import java.util.List;

import com.buit.system.model.DiccZlsfdz;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.sys.centermaintenance.dao.DiccZlsfdzDao;
import com.buit.system.service.DiccZlsfdzOutSer;

/**
 * 诊疗收费对照<br>
 * @author 老花生
 */
@DubboService(timeout = 10000)
public class DiccZlsfdzOutSerImpl implements DiccZlsfdzOutSer{

	@Autowired
	private DiccZlsfdzDao diccZlsfdzDao;
	 /**
     * @name: getListByZlxmidList
     * @description: 根据诊疗项目ID集合查询
     * @param split
     * @return: void
     * @date: 2020/9/14 13:24
     * @auther: 朱智
     *
     */
	@Override
	public List<Integer> getListByZlxmidList(String[] zlxmids) {
		return diccZlsfdzDao.getListByZlxmidList(zlxmids);
	}



	/**
	 * @name: findByEntity
	 * @description: 根据参数查询集合
	 * @param entity
	 * @return: java.util.List<DiccZlsfdz>
	 * @date: 2020/10/20 16:57
	 * @auther: 老花生
	 *
	 */
	public List<DiccZlsfdz> findByEntity(Object entity){
		return diccZlsfdzDao.findByEntity(entity);
	}
	

}
