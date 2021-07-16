package com.buit.his.dic.dao;

import java.util.List;
import java.util.Map;

import com.buit.system.request.DicGbsj02Model;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.DicGbsj02;
import com.buit.system.response.DictDto;

/**
 * 标准数据值域记录<br>
 * @author 老花生
 */
@Mapper
public interface DicGbsj02Dao extends EntityDao<DicGbsj02,Integer>{
    /**
     * 更新启用状态
     * @param dataValue 更新信息
     */
    void updateStatus(DicGbsj02 dataValue);

    /**
     * @name: getValueByPrimaryDataCode
     * @description: 根据数据字典代码查询code、value
     * @param code
     * @return: java.util.List<java.util.Map<java.lang.String,java.lang.String>>
     * @date: 2020/8/26 20:12
     * @auther: 老花生
     *
     */
    List<Map<String, String>> getValueByPrimaryDataCode(@Param("code") String code);

    /**
     * 查询国标字典
     * */
    List<DictDto> queryGbzdByMainCode(@Param("jgid") Integer jgid, @Param("code") String mainCode);

    DictDto findGbzdByMainCodeAndValue(@Param("jgid") Integer jgid,@Param("code") String mainCode,@Param("value") String value);

    int getNextPrimaryDataValueId();

    List<DicGbsj02Model> findAllByEntity(Object entity);
}
