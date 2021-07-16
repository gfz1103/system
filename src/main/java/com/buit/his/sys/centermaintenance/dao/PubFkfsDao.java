package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.PubFkfs;

/**
 * 公用_付款方式 | 用于门诊及住院付款方式设定<br>
 * 
 * @author WY
 */
@Mapper
public interface PubFkfsDao extends EntityDao<PubFkfs, Integer> {

	/**
	 * 根据条件查询付款方式信息
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getPubFkfsInfo(Map<String, Object> map);

	/**
	 * 获取增值税的付款方式信息
	 * 
	 * @param zzsFkfs
	 * @return
	 */
	List<Map<String, Object>> getZzsFkfs(String zzsFkfs);

	/**
	 * 查询住院默认付款方式
	 * 
	 * @return
	 */
	PubFkfs findZyfkfs();

	/**
	 * 作废/取消作废
	 * 
	 * @param zfbz 作废标识
	 * @param fkfs 付款方式
	 */
	void updateZfbz(@Param("zfbz") Integer zfbz, @Param("fkfs") Integer fkfs);

	/**
	 * 设置默认标志
	 * 
	 * @param fkfs
	 * @param mrbz
	 * @param sylx
	 */
	void setMrbz(@Param("fkfs") Integer fkfs, @Param("mrbz") Integer mrbz, @Param("sylx") Integer sylx);

	/**
	 * 还原默认标志
	 *
	 * @param sylx
	 */
	void reductionMrbz(@Param("sylx") Integer sylx);

	/**
	 * 设置货币误差
	 * 
	 * @param fkfs
	 * @param hbwc
	 * @param sylx
	 */
	void setHbwc(@Param("fkfs") Integer fkfs, @Param("hbwc") Integer hbwc, @Param("sylx") Integer sylx);

	/**
	 * 还原货币误差
	 *
	 * @param sylx
	 */
	void reductionHbwc(@Param("sylx") Integer sylx);

	/**
	 * 查询付款方式和金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryFkfs(Map<String, Object> parameters);
	
	/**
	 * 查询自增
	 * @Title: queryFkfsNextPk
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 龚方舟
	 * @throws
	 */
    Integer queryFkfsNextPk();
}
