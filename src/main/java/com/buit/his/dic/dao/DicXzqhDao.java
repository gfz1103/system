package com.buit.his.dic.dao;

import com.buit.commons.EntityDao;

import org.apache.ibatis.annotations.Mapper;
import com.buit.system.model.DicXzqh;

import java.util.List;

/**
 * 行政区划表<br>
 * @author liushijie
 */
@Mapper
public interface DicXzqhDao extends EntityDao<DicXzqh,Integer>{

    /**
     *通过省市县编码查询其名称
     * @param code
     * @return
     */
    String getSsxmc(Integer code);
}
