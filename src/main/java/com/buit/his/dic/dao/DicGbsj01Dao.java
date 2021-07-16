package com.buit.his.dic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.DicGbsj01;
import com.buit.system.request.DicGbsj01Model;

/**
 * 标准数据主记录<br>
 *
 * @author All
 */
@Mapper
public interface DicGbsj01Dao extends EntityDao<DicGbsj01,Integer>{

	/**
	 * 查询全部数据
	 * @param code 通过编码查询
	 * @return
	 */
	DicGbsj01 findByCode(String code);

	/**
	 * 查询主数据集合
	 * @param pyCode
	 * @return
	 */
	List<DicGbsj01Model> queryPrimaryData(String pyCode);

	Integer addVersion(Integer primarydataId);

	int getNextPrimaryDataId();
	
}
