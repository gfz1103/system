package com.buit.his.sys.centermaintenance.service;


import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.DicJbbmDao;
import com.buit.his.sys.centermaintenance.model.DicJbbm;
import com.buit.his.sys.centermaintenance.request.DicJbbmAddReq;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 公用_疾病编码库<br>
 * @author 老花生
 */
@Service
public class DicJbbmSer extends BaseManagerImp<DicJbbm,Integer> {

    static final Logger logger = LoggerFactory.getLogger(DicJbbmSer.class);

    @Autowired
    private DicJbbmDao dicJbbmDao;

    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public DicJbbmDao getEntityMapper(){
        return dicJbbmDao;
    }

    /**
     * 新增
     * @param req
     */
    public void add(DicJbbmAddReq req) {
        DicJbbm condition = null;
        // 判断名称是否重复
        if (StringUtils.isNotBlank(req.getJbmc())) {
            condition = new DicJbbm();
            condition.setJbmc(req.getJbmc());
            List<DicJbbm> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICJBBM_0001");
            }
        }
        // 判断 icdCode 是否重复
        if (StringUtils.isNotBlank(req.getIcdCode())) {
            condition = new DicJbbm();
            condition.setIcdCode(req.getIcdCode());
            List<DicJbbm> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICJBBM_0004");
            }
        }
        /*
        // 判断ICD10是否重复
        if (StringUtils.isNotBlank(req.getIcd10())) {
            condition = new DicJbbm();
            condition.setIcd10(req.getIcd10());
            List<DicJbbm> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICJBBM_0002");
            }
        }
        // 判断ICD9是否重复
        if (StringUtils.isNotBlank(req.getIcd9())) {
            condition = new DicJbbm();
            condition.setIcd9(req.getIcd9());
            List<DicJbbm> dataList = findByEntity(condition);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DICJBBM_0003");
            }
        }
        */
//        int jbxh = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_JBBM);
        DicJbbm jbbm = BeanUtil.toBean(req, DicJbbm.class);
//        jbbm.setJbxh(jbxh);
        dicJbbmDao.insert(jbbm);
        sysDictConfigSer.upDateVersion("dic_jbbm");
    }


}
