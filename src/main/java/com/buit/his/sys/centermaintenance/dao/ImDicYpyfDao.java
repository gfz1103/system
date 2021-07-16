package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.ImDicYpyf;
import com.buit.his.sys.centermaintenance.response.ImDicYpyfAppendResp;

/**
 * 住院_药品用法<br>
 * @author yueyu
 */
@Mapper
public interface ImDicYpyfDao extends EntityDao<ImDicYpyf,Integer>{

    /**
     * 查询未选择的药品用法
     *
     * */
    List<ImDicYpyf> queryUncheckedList(@Param("yfsb") Integer yfsb, @Param("jgid") Integer jgid, @Param("value") String value);


    /**
     * 根据用法查询药品附加项目
     * @Title: loadYpAppendAdvice
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param ypyf
     * @param @return    设定文件
     * @return ImDicYpyfAppendResp    返回类型
     * @author 龚方舟
     * @throws
     */
    List<ImDicYpyfAppendResp> loadYpAppendAdvice(Integer ypyf);
}
