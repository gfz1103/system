package com.buit.his.user.dao;

import java.util.List;

import com.buit.his.user.response.SysYwqxkzDetailResp;
import com.buit.system.model.SysYwqxkz;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.user.request.SysYwqxkzEditReq;
/**
 * 公用_公用权限控制<br>
 * @author "MLeo"
 */
@Mapper
public interface SysYwqxkzDao extends EntityDao<SysYwqxkz,String>{
    /**
     * 初始化用户药房
     * @param qxkz
     */
//    void initUserDrugstore(SysYwqxkz qxkz);
    /**
     * 修改用户药房
     * @param qxkz
     */
//    void editUserDrugstore(SysYwqxkz qxkz);
    /** 取已获取权限列表 */
    List<SysYwqxkzDetailResp> findqx(@Param("ygdm") Integer ygdm, @Param("ywlb") Integer ywlb);
    /**清空权限 */
    void deleteById(SysYwqxkzEditReq sysYwqxkz);
    Integer getmorenAuthority(SysYwqxkz sysYwqxkz);

    Integer getWriteAuthority(Integer ygdm, Integer ksdm, Integer bqdm, Integer jgid);
}
