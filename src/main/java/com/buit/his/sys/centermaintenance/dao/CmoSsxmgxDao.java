package com.buit.his.sys.centermaintenance.dao;

import com.buit.his.sys.centermaintenance.dto.SsbmDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/11/10 10:24
 */
@Mapper
public interface CmoSsxmgxDao {

    void replace(@Param("ssxh") Integer ssbm, @Param("fyxh") Integer fyxh);

    List<SsbmDto> querySsbmAndSsmcByFyxh(@Param("list") List<Integer> fyxhList);
}
