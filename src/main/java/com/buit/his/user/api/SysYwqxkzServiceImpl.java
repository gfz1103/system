package com.buit.his.user.api;

import java.util.List;

import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.his.user.dao.SysYwqxkzDao;
import com.buit.system.model.SysYwqxkz;
import com.buit.system.service.SysYwqxkzService;

@DubboService(timeout = 10000)
public class SysYwqxkzServiceImpl implements SysYwqxkzService{

	@Autowired
	private SysYwqxkzDao sysYwqxkzDao;
	
	@Override
	public List<SysYwqxkz> findByEntity(Object entity) {
		return sysYwqxkzDao.findByEntity(entity);
	}

}
