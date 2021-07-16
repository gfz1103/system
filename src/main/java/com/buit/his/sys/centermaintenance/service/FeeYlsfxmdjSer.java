package com.buit.his.sys.centermaintenance.service;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmdjDao;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxmdj;
/**
 * 公用_医院医疗明细项目<br>
 * @author 老花生
 */
@Service
public class FeeYlsfxmdjSer extends BaseManagerImp<FeeYlsfxmdj,String> {
    
    static final Logger logger = LoggerFactory.getLogger(FeeYlsfxmdjSer.class);
    
    @Autowired
    private FeeYlsfxmdjDao feeYlsfxmdjDao;
    
    @Override
    public FeeYlsfxmdjDao getEntityMapper(){        
        return feeYlsfxmdjDao;
    }
    
    /**
     * 收费项目维护全部调入
     * @Title: allInInstitutionalDetails
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param fygbList
     * @param @param user    设定文件
     * @return void    返回类型
     * @author 龚方舟
     * @throws
     */
	@Transactional(rollbackFor = Exception.class)
    public void allInInstitutionalDetails(List<Integer> fygbList, SysUser user) {
    	for(Integer fygb : fygbList) {
    		feeYlsfxmdjDao.batchInsert(user.getHospitalId(), fygb);
		}
    }
    
}
