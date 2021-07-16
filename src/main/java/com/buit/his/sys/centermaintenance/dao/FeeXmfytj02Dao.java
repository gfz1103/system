package com.buit.his.sys.centermaintenance.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj02;
import com.buit.his.sys.centermaintenance.response.FeeXmfytj02Resp;
/**
 * <br>
 * @author GONGFANGZHOU
 */
@Mapper
public interface FeeXmfytj02Dao extends EntityDao<FeeXmfytj02,Integer>{
    
	/**
	 * 查询调价项目
	 * @Title: queryGyFytjYlsf
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param @return    设定文件
	 * @return List<FeeXmfytj02Resp>    返回类型
	 * @author 龚方舟
	 * @throws
	 */
    List<FeeXmfytj02Resp> queryGyFytjYlsf(@Param("tjdh") Integer tjdh, @Param("jgid") Integer jgid);
}
