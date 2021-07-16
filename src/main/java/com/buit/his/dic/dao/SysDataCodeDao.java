package com.buit.his.dic.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.SysDataCode;
/**
 * 系统数据代码表<br>
 * @author All
 */
@Mapper
public interface SysDataCodeDao extends EntityDao<SysDataCode,Integer>{
	/**
	 * 根据编码类型查询
	 * @param codeType	编码类型
	 * @return
	 */
	SysDataCode findByCodeType(Integer codeId);
}
