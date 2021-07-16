package com.buit.his.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.SysUserDept;
/**
 * 系统用户授权科室<br>
 * @author All
 */
@Mapper
public interface SysUserDeptDao extends EntityDao<SysUserDept,Integer>{
    
}
