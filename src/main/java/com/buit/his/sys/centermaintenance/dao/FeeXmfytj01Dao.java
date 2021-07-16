package com.buit.his.sys.centermaintenance.dao;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj01;
import com.buit.his.sys.centermaintenance.request.FeeXmfytj01QueryReq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <br>
 *
 * @author GONGFANGZHOU
 */
@Mapper
public interface FeeXmfytj01Dao extends EntityDao<FeeXmfytj01, Integer> {
	/**
	 * 调价单号查询
	 *
	 * @param tjdh 调价单号
	 * @param jgid 机构id
	 * @return
	 */
	FeeXmfytj01 getByTjdh(@Param("tjdh") Integer tjdh, @Param("jgid") Integer jgid);

	/**
	 * 查询未执行或已执行调价单列表
	 *
	 * @param @param  feeXmfytj01QueryReq
	 * @param @return 设定文件
	 * @return List<FeeXmfytj01>    返回类型
	 * @throws
	 * @Title: queryFytjIsExecute
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author 龚方舟
	 */
    List<FeeXmfytj01> queryFytjIsExecute(FeeXmfytj01QueryReq feeXmfytj01QueryReq);

	/**
	 * 查询当年最大调价单号
	 *
	 * @param jgid 机构id
	 * @param year 2位年份
	 */
	String queryMaxTjdh(@Param("jgid") Integer jgid, @Param("year") String year);
    
    /**
     * 更新执行状态
     * @Title: updateExcuteStatus
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param feeXmfytj01    设定文件
     * @return void    返回类型
     * @author 龚方舟
     * @throws
     */
    void updateExcuteStatus(FeeXmfytj01 feeXmfytj01);

	/**
	 * 更新生效调价单
	 *
	 * @param @param  feeXmfytj01
	 * @param @return 设定文件
	 * @return long    返回类型
	 * @throws
	 * @Title: updateEffectAdjustment
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @author 龚方舟
	 */
	long updateEffectAdjustment(FeeXmfytj01 feeXmfytj01);

	/**
	 * 按属性修改非空值
	 */
	void updateByEntity(FeeXmfytj01 entry);

}
