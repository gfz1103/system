package com.buit.his.sys.centermaintenance.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.FeeYpxzDao;
import com.buit.his.sys.centermaintenance.model.FeeYpxz;
import com.buit.his.sys.centermaintenance.request.FeeYpxzAddReq;
import com.buit.his.sys.centermaintenance.request.FeeYpxzEditReq;
import com.buit.his.sys.centermaintenance.request.PubBrxzSaveReq;
import com.buit.system.utill.MedicineUtils;
import com.buit.utill.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 公用_药品禁用<br>
 * @author "MLeo"
 */
@Service
public class FeeYpxzSer extends BaseManagerImp<FeeYpxz,Integer> {

    static final Logger logger = LoggerFactory.getLogger(FeeYpxzSer.class);

    @Autowired
    private FeeYpxzDao feeYpxzDao;

    @Override
    public FeeYpxzDao getEntityMapper(){
        return feeYpxzDao;
    }

    @Transactional(rollbackFor = Exception.class)
    public void batchAdd(List<PubBrxzSaveReq.PubBrxzAddReq> adds) {
        List<FeeYpxz> ypjies = BeanUtil.toBeans(adds,FeeYpxz.class);
        Integer ypxh = ypjies.get(0).getYpxh();
        feeYpxzDao.deleteByYpxh(ypxh);
        //   List<Map<String, Object>> meds = BUHISUtil.ListObjToMap(ypjies);
        List<FeeYpxz> med = new ArrayList<>();
        for(int i=0;i<ypjies.size();i++){
            Double zfbl = MedicineUtils.parseDouble(ypjies.get(i).getZfbl());
            if(zfbl!=null && zfbl!=0){
                med.add(ypjies.get(i));
            }
        }
        if(med.size()>0){
            feeYpxzDao.batchInsert(med);
        }

    }

    /**
     * 新增
     * @param req
     */
    public void add(FeeYpxzAddReq req) {
        FeeYpxz feeYpxz = BeanUtil.toBean(req, FeeYpxz.class);
        FeeYpxz condition = new FeeYpxz();
        condition.setBrxz(req.getBrxz());
        condition.setYpxh(req.getYpxh());
        List<FeeYpxz> existList = feeYpxzDao.findByEntity(condition);
        if (existList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_GYYPJY_0001");
        }
        feeYpxzDao.insert(feeYpxz);
    }

    /**
     * 编辑
     * @param req
     */
    public void edit(FeeYpxzEditReq req) {
        FeeYpxz feeYpxz = BeanUtil.toBean(req, FeeYpxz.class);
        feeYpxzDao.update(feeYpxz);
    }


}
