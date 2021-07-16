package com.buit.his.dic.api;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.dic.dao.SysDictConfigDao;
import com.buit.his.dic.model.SysDictConfig;
import com.buit.system.service.SysDictConfigSer;

import cn.hutool.core.date.DateUtil;

/**
 * 标准数据值域 - 系统字典
 * 
 * @author 汪洋
 **/
@DubboService(timeout = 10000)
public class SysDictConfigSerImpl implements SysDictConfigSer {

	@Autowired
	private SysDictConfigDao sysDictConfigDao;

	/**
	 * 更新版本信息
	 * 
	 * @param dictId
	 */
	public void upDateVersion(String tableName) {
		SysDictConfig sysDictConfig = new SysDictConfig();
		sysDictConfig.setQuerySql(tableName.toLowerCase());
		sysDictConfig.setGmtModify(DateUtil.date().toTimestamp());
		sysDictConfigDao.updateVersion(sysDictConfig);
	}

}
