package com.buit.his.dic.service;


import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.dao.SysFlagDataDao;
import com.buit.his.dic.dao.SysFlagDataValueDao;
import com.buit.his.dic.model.SysFlagData;
import com.buit.his.dic.request.SysFlagDataEditReq;
import com.buit.utill.BeanUtil;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.RedisFactory;

/**
 * 标识数据主记录<br>
 * @author wangyang
 */
@Service
public class SysFlagDataSer extends BaseManagerImp<SysFlagData,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysFlagDataSer.class);
    
    @Autowired
    private SysFlagDataDao sysFlagDataDao;

    @Autowired
    private SysFlagDataValueDao sysFlagDataValueDao;

    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public SysFlagDataDao getEntityMapper(){        
        return sysFlagDataDao;
    }

	/**
	 * 字典主表新增
	 * 
	 * @param flagDataCode
	 * @param flagDataName
	 */
	public void add(String flagDataCode, String flagDataName) {
		if (flagDataCode == null) {
			throw BaseException.create("ERROR_DIC_0001");
		}
		if (flagDataName == null) {
			throw BaseException.create("ERROR_DIC_0002");
		}
		if (sysFlagDataDao.findEntityCount(flagDataCode) > 0) {
			throw BaseException.create("ERROR_DIC_0004");
		}
		SysFlagData sysFlagData = new SysFlagData();
//		sysFlagData.setFlagDataId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_FLAG_DATA));
		sysFlagData.setGmtCreate(new Timestamp(System.currentTimeMillis()));
		sysFlagData.setFlagDataCode(flagDataCode);
		sysFlagData.setFlagDataName(flagDataName);
		sysFlagData.setDataVersion(1);

		// 设置拼音、五笔字符
		ChineseCharacterUtil.setPyAndWb(sysFlagData, sysFlagData.getFlagDataName());
		sysFlagDataDao.insert(sysFlagData);
	}

    public void edit(SysFlagDataEditReq req) {
        SysFlagData sysFlagData = BeanUtil.toBean(req, SysFlagData.class);
        sysFlagData.setGmtModify(new Timestamp(System.currentTimeMillis()));
        sysFlagDataDao.update(sysFlagData);
    }

    public void delete(Integer flagdataId) {
        SysFlagData sysFlagData = sysFlagDataDao.getById(flagdataId);
        if(sysFlagData == null) {
            throw new RuntimeException("需要删除的记录不存在！");
        }
        if(sysFlagDataValueDao.findByEntityCount(flagdataId) > 0 ) {
            throw new RuntimeException("存在标识详情记录，不能删除！");
        }
        sysFlagDataDao.deleteById(flagdataId);
    }
}
