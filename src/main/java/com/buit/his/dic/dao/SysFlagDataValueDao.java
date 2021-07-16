package com.buit.his.dic.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.SysFlagDataValue;
import com.buit.system.response.DictDto;

/**
 * 标识数据内容表<br>
 * @author wangyang
 */
@Mapper
public interface SysFlagDataValueDao extends EntityDao<SysFlagDataValue,Integer>{
	/**
	 * 字典从记录启用/停用
	 * 
	 * @param flagDataValueId
	 * @param stopFlag
	 */
	public void editEnable(@Param("flagDataValueId") Integer flagDataValueId, @Param("stopFlag") String stopFlag);

	/**
	 * 根据字典编码查询数量
	 * 
	 * @param flagDataCode
	 * @param flagDataValue
	 * @return
	 */
	public long findEntityCount(@Param("flagDataCode") String flagDataCode,
			@Param("flagDataValueId") Integer flagDataValueId,@Param("flagDataId") Integer flagDataId);
	/**
	 * 查询flag字典
	 * */
	List<DictDto> queryFlagValueByDataId(@Param("dataId") String dataId);

	/**
	 * 查询flag字典
	 * */
	List<DictDto> queryFlagValueByDataCode(@Param("dataCode") String dataCode);

	/**
	 * 根据dataId、code查询flag字典
	 * */
	DictDto findFlagValueByDataIdAndValueCode(@Param("dataId")String dataId, @Param("code")String code);
}
