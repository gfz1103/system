package com.buit.his.sys.centermaintenance.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.DicZlxm;

/**
 * 诊疗项目<br>
 * @author 老花生
 */
@Mapper
public interface DicZlxmDao extends EntityDao<DicZlxm,Integer>{

    /**
     * 查询费用总和
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFyzh(Map<String, Object> parameters);

    /**
     * 查询费用项目、诊疗项目ID、费用数量
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFyxhZlxmidFysl(Map<String, Object> parameters);
}
