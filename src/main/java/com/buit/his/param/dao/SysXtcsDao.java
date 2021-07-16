package com.buit.his.param.dao;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.system.response.SysXtcs;

/**
 * 公用_系统参数<br>
 * @author 老花生
 */
@Mapper
public interface SysXtcsDao extends EntityDao<SysXtcs,String> {
    /**
     * 加载发药药房设置
     * @param sysXtcs    加载条件
     * @return 返回集合
     */
    List<SysXtcs> load(SysXtcs sysXtcs);

    /**
     * 更新参数值
     * @param xtcs  参数对象
     */
    void updateCsz(SysXtcs xtcs);

    /**
     * 根据机构id和参数名称查询系统参数
     * @param jgId  机构代码
     * @param csmc  参数名称
     * @return
     */
    SysXtcs findByJgIdAndCsmc(@Param("jgId") Integer jgId,@Param("csmc")  String csmc);

    /**
     * 根据机构id和参数名称查询系统参数
     * @param jgId  机构代码
     * @param csmc  参数名称
     */
    void deleteByJGIdAndCsmc(@Param("jgId")Integer jgId, @Param("csmc")String csmc);
    
	/**
	 * 获取挂号系统参数：当前挂号日期和当前值班类型
	 * 
	 * @param jgId
	 * @param csmc
	 * @return
	 */
	public String getGhSysParams(@Param("jgid") Integer jgid, @Param("csmc") String csmc);

    /**
     * 修改住院相关参数 住院号、病案号做加一操作
     * @param sysXtcs
     */
    void updateZyParam(SysXtcs sysXtcs);
    
	/**
	 * 参数名称模糊查询
	 * 
	 * @param map
	 * @return
	 */
	public List<Map<String, Object>> getXtcsByCsmc(Map<String, Object> map);


}
