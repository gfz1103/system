package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicYljg;
import com.buit.his.sys.centermaintenance.response.DicYljgResp;
import com.buit.system.response.DicYljgOut;

/**
 * 医疗卫生机构索引表<br>
 *
 * @author yueyu
 */
@Mapper
public interface DicYljgDao extends EntityDao<DicYljg, Integer> {

    /**
     * 根据jgid查询机构信息
     *
     * @param jgidList
     */
    List<DicYljgOut> queryByJgid(@Param("list") List<String> jgidList);

    /**
     * 查询机构集合
     *
     * @param pyCode
     * @return
     */
    List<DicYljgResp> queryList(@Param("pyCode") String pyCode);

    /**
     * 停用机构
     * @param dicYljg
     */
    void stopYljg(DicYljg dicYljg);

    /**
     *查询系统中所有子机构（有效的）
     * @return
     */
    List<DicYljgOut> getAllYljg();
}
