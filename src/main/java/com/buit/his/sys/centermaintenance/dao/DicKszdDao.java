package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.response.DicKszdResp;
import com.buit.system.model.DicKszd;

/**
 * <br>
 * @author 老花生
 */
@Mapper
public interface DicKszdDao extends EntityDao<DicKszd,Integer>{

	/**
	 * 获取科室代码和科室名称
	 *
	 * @author wy
	 * @param map
	 * @return
	 */
	public Map<String, Object> getKsInfo(Map<String, Object> map);


	/**
	 * 获取特定字典文件的Value
	 * @Title: getVauleByKey
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param jgid
	 * @param @param id
	 * @param @return    设定文件
	 * @return DicKszd    返回类型
	 * @author 龚方舟
	 * @throws
	 */
	DicKszd getVauleByKey(@Param("jgid") Integer jgid, @Param("id") Integer id);

	DicKszdResp getByKsdm(@Param("jgid") Integer jgid, @Param("brks") String brks);

	/**
	 * 查询科室集合
	 * @param pycode 拼音码
	 * @return
	 */
	List<DicKszdResp> queryList(@Param("pycode")String pycode, @Param("parentid") Integer parentid);

	/**
	 * 停用科室
	 * @param id
	 */
	void stopDept(@Param("id") int id);


	 /**
	  * 获取科室名称
	  * @Title: getOfficeName
	  * @Description: TODO(这里用一句话描述这个方法的作用)
	  * @param @param jgid
	  * @param @param id
	  * @param @return    设定文件
	  * @return List<DicKszd>    返回类型
	  * @author 龚方舟
	  * @throws
	  */
	 List<DicKszd>  getOfficeName(@Param("jgid") Integer jgid, @Param("id") String id);

	/**
	 * 查询住院病人科室字典
	 * @param hospitalId
	 * @return
	 */
    List<DicKszd> queryZyBrksDic(Integer hospitalId);

	/**
	 * 获取医保科室
	 * @param ksdm
	 * @return
	 */
	public Map<String,Object> getYbksdm(Integer ksdm);

	public Map<String,Object> getYbksdmzy(Integer brks);


}
