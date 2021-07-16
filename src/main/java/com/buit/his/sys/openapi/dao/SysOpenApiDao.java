package com.buit.his.sys.openapi.dao;


import com.buit.commons.EntityDao;
import com.buit.his.sys.openapi.model.SysOpenApi;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 开放api信息<br>
 * @author sunjx
 */
@Mapper
public interface SysOpenApiDao extends EntityDao<SysOpenApi,Integer> {

    SysOpenApi selectBy(@Param("accessKey") String accessKey, @Param("accessSecretMd5") String accessSecretMd5);
}
