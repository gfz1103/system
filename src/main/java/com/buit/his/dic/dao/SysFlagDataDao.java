package com.buit.his.dic.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.SysFlagData;

/**
 * 标识数据主记录<br>
 * 
 * @author wangyang
 */
@Mapper
public interface SysFlagDataDao extends EntityDao<SysFlagData, Integer> {
	/**
	 * 根据字典编码查询
	 * 
	 * @param code
	 * @return
	 */
	public SysFlagData findByCode(String code);

	/**
	 * 根据字典编码查询数量
	 * 
	 * @param flagDataCode
	 * @return
	 */
	public long findEntityCount(String flagDataCode);
	public long addVersion(Integer flagDataId);

}
