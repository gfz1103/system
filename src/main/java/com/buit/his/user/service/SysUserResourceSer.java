package com.buit.his.user.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.user.dao.SysUserResourceDao;
import com.buit.his.user.model.SysUserResource;
import com.buit.his.user.request.SysUserResourceReq;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;
/**
 * 用户与资源对应关系<br>
 * @author All
 */
@Service
public class SysUserResourceSer extends BaseManagerImp<SysUserResource,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysUserResourceSer.class);
    
    @Autowired
    private SysUserResourceDao sysUserResourceDao;
    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public SysUserResourceDao getEntityMapper(){        
        return sysUserResourceDao;
    }

    @Transactional(rollbackFor=Exception.class)
    public void edit(SysUserResourceReq req, Integer hospitalId,String resourceType) {
    	SysUserResource res=new SysUserResource();
    	res.setGmtCreate(DateUtil.getCurrentTimestamp());
    	res.setHospitalId(hospitalId);
    	res.setResourceId( req.getResourceId());
        //组集合
    	List<Integer> userIds = req.getUserIds();
    	res.setResourceType(resourceType);
    	for(Integer userId : userIds) {
	    	res.setUserId(userId);
			// res.setUserresId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_USER_RESOURCE));
			sysUserResourceDao.insert(res);
    	}
		
    }
}
