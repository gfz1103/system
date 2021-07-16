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
import com.buit.his.dic.model.SysFlagDataValue;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.RedisFactory;

/**
 * 标识数据内容表<br>
 * @author wangyang
 */
@Service
public class SysFlagDataValueSer extends BaseManagerImp<SysFlagDataValue,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysFlagDataValueSer.class);
    
    @Autowired
    private SysFlagDataValueDao sysFlagDataValueDao;
    @Autowired
    private SysFlagDataDao sysFlagDataDao;
    @Autowired
    private UpdateWebDbSer updateWebDbSer;

    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public SysFlagDataValueDao getEntityMapper(){        
        return sysFlagDataValueDao;
    }

	/**
	 * 字典从记录新增
	 * 
	 * @param flagDataCode
	 * @param flagDataName
	 * @param serialNumber
	 * @param flagDataId
	 */
	public void add(String flagDataCode, String flagDataName, Integer serialNumber, Integer flagDataId) {
		if (flagDataCode == null) {
			throw BaseException.create("ERROR_DIC_0001");
		}
		if (flagDataName == null) {
			throw BaseException.create("ERROR_DIC_0002");
		}
		if (serialNumber == null) {
			throw BaseException.create("ERROR_DIC_0003");
		}
		if (sysFlagDataValueDao.findEntityCount(flagDataCode,null,flagDataId) > 0) {
			throw BaseException.create("ERROR_DIC_0004");
		}
		SysFlagDataValue sysFlagDataValue = new SysFlagDataValue();
//		sysFlagDataValue.setFlagDataValueId(redisFactory.getTableKey(TableName.DB_NAME, TableName.SYS_FLAG_DATA_VALUE));
		sysFlagDataValue.setGmtCreate(new Timestamp(System.currentTimeMillis()));
		sysFlagDataValue.setFlagDataValue(flagDataCode);
		sysFlagDataValue.setFlagDataValueRemark(flagDataName);
		sysFlagDataValue.setSerialNumber(serialNumber);
		sysFlagDataValue.setDataVersion(1);
		sysFlagDataValue.setStopFlag("0");
		sysFlagDataValue.setFlagDataId(flagDataId);

		// 设置拼音、五笔字符
		ChineseCharacterUtil.setPyAndWb(sysFlagDataValue, flagDataName);

		sysFlagDataValueDao.insert(sysFlagDataValue);
		sysFlagDataDao.addVersion(flagDataId);
		updateWebDbSer.updateWebDb();
	}

	/**
	 * 字典从记录修改
	 * 
	 * @param flagDataCode
	 * @param flagDataName
	 * @param serialNumber
	 * @param flagDataValueId
	 */
	public void edit(String flagDataCode, String flagDataName, Integer serialNumber, Integer flagDataValueId) {
		if (flagDataCode == null) {
			throw BaseException.create("ERROR_DIC_0001");
		}
		if (flagDataName == null) {
			throw BaseException.create("ERROR_DIC_0002");
		}
		if (serialNumber == null) {
			throw BaseException.create("ERROR_DIC_0003");
		}
		SysFlagDataValue que =sysFlagDataValueDao.getById(flagDataValueId);
		if (sysFlagDataValueDao.findEntityCount(flagDataCode,flagDataValueId,que.getFlagDataId()) > 0) {
			throw BaseException.create("ERROR_DIC_0004"); 
		}
		SysFlagDataValue sysFlagDataValue = new SysFlagDataValue();
		sysFlagDataValue.setFlagDataValueId(flagDataValueId);
		sysFlagDataValue.setFlagDataValue(flagDataCode);
		sysFlagDataValue.setFlagDataValueRemark(flagDataName);
		sysFlagDataValue.setSerialNumber(serialNumber);
		sysFlagDataValue.setGmtModify(new Timestamp(System.currentTimeMillis()));
		sysFlagDataValueDao.update(sysFlagDataValue);
		
		sysFlagDataValue=sysFlagDataValueDao.getById(flagDataValueId);
		sysFlagDataDao.addVersion(sysFlagDataValue.getFlagDataId());
		updateWebDbSer.updateWebDb();
	}

    public void delete(Integer flagdatavalueId) {
        SysFlagDataValue sysFlagDataValue = sysFlagDataValueDao.getById(flagdatavalueId);
        if(sysFlagDataValue == null) {
            throw new RuntimeException("需要删除的记录不存在！");
        }

        sysFlagDataValueDao.deleteById(flagdatavalueId);
    }
}
