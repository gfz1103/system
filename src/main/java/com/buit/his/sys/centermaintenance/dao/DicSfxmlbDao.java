package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.system.model.DicSfxmlb;
import com.buit.system.response.DicSfxmlbZfblResp;

/**
 * 公用_收费项目<br>
 * 
 * @author GONGFANGZHOU
 */
@Mapper
public interface DicSfxmlbDao extends EntityDao<DicSfxmlb, Integer> {

	/**
	 * 医疗项目修改前校验 @Title: findCountNotEqualSfxm @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param dicSfxmlb @param @return 设定文件 @return
	 * long 返回类型 @author 龚方舟 @throws
	 */
	long findCountNotEqualSfxm(DicSfxmlb dicSfxmlb);

	/**
	 * 获取新收费项目编码
	 */
	String nextSfxmbm(String sfxmlb);

	/**
	 * 更新当前使用最新的收费项目编码
	 */
	int updateNowSfxmbm(@Param("sfxmlb") Integer sfxmlb, @Param("lsh") Integer lsh);

	/**
	 * 查询公用收费项目信息 @Title: queryDicSfxmlbInfo @Description:
	 * TODO(这里用一句话描述这个方法的作用) @param @param sfxm @param @return 设定文件 @return
	 * Map<String,Object> 返回类型 @author 龚方舟 @throws
	 */
	Map<String, Object> queryDicSfxmlbInfo(Integer sfxm);

	/**
	 * 中心维护-病人性质-自负比例列表
	 * 
	 * @param brxz 病人性质代码
	 * @return
	 */
	List<DicSfxmlbZfblResp> queryBrxzZfbl(@Param("brxz") Integer brxz);

	/**
	 * 费用归并
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGbje(Map<String, Object> parameters);

	/**
	 * 费用归并
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGbjeByCondition(Map<String, Object> parameters);

	/**
	 * 归并金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryGbjeA(Map<String, Object> parameters);

	/**
	 * 医技归并金额
	 * 
	 * @param parameters
	 * @return
	 */
	List<Map<String, Object>> doQueryYjGbJe(Map<String, Object> parameters);

	/**
	 * 获取医保门诊项目代码
	 * 
	 * @param parameters
	 * @return
	 */
	Map<String, Object> getYbmzxm(Map<String, Object> parameters);

	/**
	 * 查询收费项目
	 *
	 * @param parameters
	 * @return
	 */
	Map<String, Object> doQuerySfxm(Map<String, Object> parameters);
	
	/**
	 * 查询主键
	 * @Title: queryPkNextNum
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return Integer    返回类型
	 * @author 龚方舟
	 * @throws
	 */
    Integer queryPkNextNum();

}
