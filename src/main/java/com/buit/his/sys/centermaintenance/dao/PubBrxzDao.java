package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.PubBrxz;
import com.buit.his.sys.centermaintenance.response.PubBrxzResp;
import com.buit.his.sys.centermaintenance.response.PubBrxzTreeResp;
import com.buit.system.response.PubBrxzListResp;
import com.buit.system.response.PubBrxzOut;

/**
 * 公用_病人性质 | 包括自费、公费、记帐等<br>
 * @author "MLeo"
 */
@Mapper
public interface PubBrxzDao extends EntityDao<PubBrxz,Integer>{
    /**
     * 查询药品费用列表
     * @param ypxh
     * @return
     */
    List<PubBrxzListResp> getListByYpxh(Integer ypxh);

	/**
	 * 根据病人性质查询上级性质
	 * 
	 * @author wy
	 * @param brxz
	 * @return
	 */
	public Integer getSjxzByBrxz(Integer brxz);
	
	/**
	 * 建档时获得病人性质列表
	 * 
	 * @author wy
	 * @return
	 */
	public List<PubBrxz> getPubBrxzList();

	/**
	 * 获取病人性质sjxz
	 * @param brxz
	 * @return
	 */
	List<Map<String, Object>> getSjxzList(String brxz);

	/**
	 *
	 * @param brxz
	 * @return
	 */
    PubBrxz querySjBrxzByBrxz(Integer brxz);
    PubBrxzOut getByIdRetOut(Integer brxz);
    
    /**
     * 查询项目明细费用限制
     * @Title: queryCostLimit
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param fyxh
     * @param @return    设定文件
     * @return List<PubBrxzResp>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<PubBrxzResp> queryCostLimit(Integer fyxh);
    
	/**
	 * 根据病人性质查询病人性质名称
	 * 
	 * @param brxz
	 * @return
	 */
	public PubBrxz getBrmcPubBrxz(Integer brxz);

	/**
	 * 病人性质列表
	 * @return
	 */
	public List<PubBrxzTreeResp> queryTree();

}
