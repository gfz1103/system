package com.buit.his.dic.dao;

import com.buit.commons.EntityDao;
import com.buit.his.dic.model.SysDictConfig;
import com.buit.his.dic.response.RegionResp;
import com.buit.his.dic.response.Sondic;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 字典配置<br>
 *
 * @author
 */
@Mapper
public interface SysDictConfigDao extends EntityDao<SysDictConfig, Integer> {
	/**
	 * 行政区化(版本)
	 *
	 * @return
	 */
	List<RegionResp> getLatestRegion(String version);

	/**
	 * 行政区化（全部）
	 *
	 * @return
	 */
	List<RegionResp> getAllRegion();

	/**
	 * 行政区化
	 *
	 * @param part
	 * @return
	 */
	public List<Sondic> runSondic(Map<String, Object> part);

	/**
	 * 更新停用状态
	 * 
	 * @param config
	 */
	void updateFlag(SysDictConfig config);

	/**
	 * 更新版本信息
	 * 
	 * @param sysDictConfig
	 */
	void updateVersion(SysDictConfig sysDictConfig);
}
