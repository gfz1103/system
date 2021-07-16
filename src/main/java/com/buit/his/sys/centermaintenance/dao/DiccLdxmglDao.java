package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DiccLdxmgl;
import com.buit.his.sys.centermaintenance.response.DiccLdxmglResp;

/**
 * 项目关联<br>
 *
 * @author GONGFANGZHOU
 */
@Mapper
public interface DiccLdxmglDao extends EntityDao<DiccLdxmgl, Integer> {

    /**
     * 查询项目关联信息
     *
     * @param @param  parameters
     * @param @return 设定文件
     * @return List<DiccLdxmglResp>    返回类型
     * @throws
     * @Title: queryProjectAssociationInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    List<DiccLdxmglResp> queryProjectAssociationInfo(Map<String, Object> parameters);

    /**
     * 中心维护-查询项目关联列表
     *
     * @param jgid 机构ID
     * @param xmxh 项目序号
     * @return
     */
    List<DiccLdxmglResp> queryXmglList(@Param("jgid") int jgid, @Param("xmxh") int xmxh, @Param("pydm")String pydm);
}
