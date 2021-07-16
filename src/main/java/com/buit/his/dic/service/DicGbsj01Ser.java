package com.buit.his.dic.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.dao.DicGbsj01Dao;
import com.buit.his.dic.dao.DicGbsj02Dao;
import com.buit.his.dic.model.DicGbsj01;
import com.buit.his.dic.model.DicGbsj02;
import com.buit.his.dic.request.DicGbsj01AddReq;
import com.buit.his.dic.request.DicGbsj01EditReq;
import com.buit.his.dic.response.Maindic;
import com.buit.his.dic.response.Sondic;
import com.buit.commons.SysUser;
import com.buit.utill.BeanUtil;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;

/**
 * 标准数据主记录<br>
 * @author 老花生
 */
@Service
public class DicGbsj01Ser extends BaseManagerImp<DicGbsj01,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicGbsj01Ser.class);
    
    @Autowired
    private DicGbsj01Dao dicGbsj01Dao;
    @Autowired
    private DicGbsj02Dao dicGbsj02Dao;

    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public DicGbsj01Dao getEntityMapper(){        
        return dicGbsj01Dao;
    }

    /**
     * 新增
     * @param req   请求参数
     * @param user  用户信息
     */
    public void add(DicGbsj01AddReq req, SysUser user) {
        DicGbsj01 data = BeanUtil.toBean(req, DicGbsj01.class);
        data.setOperatorId(user.getUserId());
        data.setHospitalId(user.getHospitalId());
        data.setGmtCreate(DateUtil.getCurrentTimestamp());
        ChineseCharacterUtil.setPyAndWb(data, data.getPrimaryDataName());

        dicGbsj01Dao.insert(data);
    }

    /**
     * 编辑
     * @param req   请求参数
     */
    public void edit(DicGbsj01EditReq req, SysUser user) {
        DicGbsj01 data = dicGbsj01Dao.getById(req.getPrimarydataId());
        BeanUtils.copyProperties(req, data);
        data.setOperatorId(user.getUserId());
        data.setDataVersion(data.getDataVersion() + 1);
        data.setGmtModify(DateUtil.getCurrentTimestamp());
        ChineseCharacterUtil.setPyAndWb(data, data.getPrimaryDataName());

        dicGbsj01Dao.update(data);
    }

	/**
	 * 编辑
	 * @return
	 */
	public List<Maindic> getAllDic() {
    	List<Maindic> retList = new ArrayList<>();
		retList = new ArrayList<>();
		List<DicGbsj01> listMain = dicGbsj01Dao.findByEntity(null);
		DicGbsj02 dicGbsj01Value = new DicGbsj02();
		for (DicGbsj01 dicGbsj01 : listMain) {
			Maindic maindic = new Maindic();
			maindic.setDk(dicGbsj01.getPrimaryDataCode());
			maindic.setDname(dicGbsj01.getPrimaryDataName());
			maindic.setDversion(dicGbsj01.getDataVersion());
			retList.add(maindic);
			dicGbsj01Value.setPrimarydataId(dicGbsj01.getPrimarydataId());
			List<DicGbsj02> listSon = dicGbsj02Dao.findByEntity(dicGbsj01Value);
			List<Sondic> resonList = new ArrayList<>();
			maindic.setSon(resonList);
			for (DicGbsj02 sondb : listSon) {
				Sondic sondic = new Sondic();
				sondic.setDv(sondb.getDataValue());
				sondic.setDn(sondb.getDataValueRemark());
				sondic.setShowOrder(sondb.getSerialNumber());
				sondic.setStop(sondb.getStopFlag());
				sondic.setPy(sondb.getPyCode());
				sondic.setWb(sondb.getWbCode());
				resonList.add(sondic);
			}
		}
		return retList;
    }

	/**
	 * 编辑
	 * @param dk
	 * @param dversion
	 * @return
	 */
    public Maindic getNewData(String dk,Integer dversion) {
    	DicGbsj01 dicGbsj01 = dicGbsj01Dao.findByCode(dk);
		if (dicGbsj01 == null) {
			return null;
		}
		Maindic maindic = new Maindic();
		List<Sondic> resonList = new ArrayList<>();
		maindic.setSon(resonList);
		// 如果版本相同返回数据
		// 这里可以使用缓存 暂时不写
		if (dversion.equals(dicGbsj01.getDataVersion())) {
			return maindic;
		}
		maindic.setDk(dicGbsj01.getPrimaryDataCode());
		maindic.setDname(dicGbsj01.getPrimaryDataName());
		maindic.setDversion(dicGbsj01.getDataVersion());
		DicGbsj02 dicGbsj01Value = new DicGbsj02();
		dicGbsj01Value.setPrimarydataId(dicGbsj01.getPrimarydataId());
		List<DicGbsj02> listSon = dicGbsj02Dao.findByEntity(dicGbsj01Value);
		maindic.setSon(resonList);
		for (DicGbsj02 sondb : listSon) {
			Sondic sondic = new Sondic();
			sondic.setDv(sondb.getDataValue());
			sondic.setDn(sondb.getDataValueRemark());
			sondic.setShowOrder(sondb.getSerialNumber());
			sondic.setStop(sondb.getStopFlag());
			sondic.setPy(sondb.getPyCode());
			sondic.setWb(sondb.getWbCode());
			resonList.add(sondic);
		}
		return maindic;
    }
}
