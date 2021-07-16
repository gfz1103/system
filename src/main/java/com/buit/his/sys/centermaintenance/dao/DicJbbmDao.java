package com.buit.his.sys.centermaintenance.dao;


import java.util.List;
import java.util.Map;

import com.buit.his.sys.centermaintenance.request.QueryOperationCodeReq;
import com.buit.his.sys.centermaintenance.response.OperationCodeResp;
import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicJbbm;
import org.apache.ibatis.annotations.Param;

/**
 * 公用_疾病编码库<br>
 * @author 老花生
 */
@Mapper
public interface DicJbbmDao extends EntityDao<DicJbbm,Integer> {
    
	/**
	 * 查询疾病编码
	 * @Title: getJbbmInfo
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param jbxh
	 * @param @return    设定文件
	 * @return List<Map<String,Object>>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
	List<Map<String, Object>> getJbbmInfo(String jbxh);

	/**
	 * 查询疾病编码nomc
	 * @Title: getZd
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @param jbxh
	 * @param @return    设定文件
	 * @return List<Map<String,Object>>    返回类型
	 * @author 卑军华
	 * @throws
	 */
	List<Map<String, Object>> getZd(String zdxh);
	List<Map<String, Object>> getBrzd(String zyh);

    void replace(DicJbbm dicJbbm);

	List<OperationCodeResp> query(QueryOperationCodeReq req);

    void enable(@Param("jbxh") Integer jbxh);

    void updateZfbz(@Param("jbxh") Integer jbxh,@Param("zfbz") Integer zfbz);
}
