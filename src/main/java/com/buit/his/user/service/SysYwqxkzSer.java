package com.buit.his.user.service;


import com.buit.his.user.request.SysYwqxkzDetailReq;
import com.buit.system.model.SysYwqxkz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.his.user.dao.SysYwqxkzDao;
import com.buit.his.user.request.SysYwqxkzEditReq;

import cn.hutool.core.collection.CollectionUtil;

/**
 * 公用_公用权限控制<br>
 * @author "MLeo"
 */
@Service
public class SysYwqxkzSer extends BaseManagerImp<SysYwqxkz,String> {

    static final Logger logger = LoggerFactory.getLogger(SysYwqxkzSer.class);

    @Autowired
    private SysYwqxkzDao sysYwqxkzDao;

    @Override
    public SysYwqxkzDao getEntityMapper(){
        return sysYwqxkzDao;
    }


    @Transactional(rollbackFor = Exception.class)
    public void edit(SysYwqxkzEditReq req) {
    	sysYwqxkzDao.deleteById(req);
    	if(CollectionUtil.isNotEmpty(req.getQueryids())) {
	    	for (SysYwqxkzDetailReq sysYwqxkzDetailReq : req.getQueryids()) {
	    		req.setKsdm(sysYwqxkzDetailReq.getKsdm());
	    		req.setWrite(sysYwqxkzDetailReq.getWrite());
	    		sysYwqxkzDao.insert(req);
			}
    	}
    }


}
