package com.buit.his.param.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.system.response.CfgJqtdcs;

/**
 * 机器特定参数表<br>
 * @author yueyu
 */
@Mapper
public interface CfgJqtdcsDao extends EntityDao<CfgJqtdcs ,String>{


    /**
     * 根据机构id和参数名称查询系统参数
     * @param jgId  机构代码
     * @param csmc  参数名称
     * @param ip  ip地址
     * @return
     */
    CfgJqtdcs getByJgIdAndIpAndCsmc(@Param("jgId") Integer jgId,@Param("ip") String ip, @Param("csmc")String csmc);

    /**
     * 根据机构id和参数名称查询系统参数
     * @param jgId  机构代码
     * @param csmc  参数名称
     * @param ip  ip地址
     */
    void deleteByJGIdAndIpAndCsmc(@Param("jgId") Integer jgId,@Param("ip") String ip, @Param("csmc")String csmc);
    
	/**
	 * 根据机构id和参数名称查询系统参数
	 * 
	 * @author wy
	 * @param jgId 机构代码
	 * @param csmc 参数名称
	 * @param ip   ip地址
	 * @return
	 */
	public List<Map<String, Object>> getByJgIdAndIpAndCsmcs(@Param("jgId") Integer jgId, @Param("ip") String ip, @Param("csmc") String csmc);
}
