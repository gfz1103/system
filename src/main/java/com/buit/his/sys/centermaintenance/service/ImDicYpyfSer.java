package com.buit.his.sys.centermaintenance.service;


import java.util.List;

import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.ImDicYpyfDao;
import com.buit.his.sys.centermaintenance.model.ImDicYpyf;
import com.buit.his.sys.centermaintenance.request.ImDicYpyfAddReq;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;

/**
 * 住院_药品用法<br>
 *
 * @author liushijie
 */
@Service
public class ImDicYpyfSer extends BaseManagerImp<ImDicYpyf, Integer> {

    static final Logger logger = LoggerFactory.getLogger(ImDicYpyfSer.class);

    @Autowired
    private ImDicYpyfDao imDicYpyfDao;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public ImDicYpyfDao getEntityMapper() {
        return imDicYpyfDao;
    }

    /**
     * 新增
     * @param req
     */
    public void add(ImDicYpyfAddReq req) {
        // 判断是否重复
        ImDicYpyf condition = new ImDicYpyf();
        condition.setXmmc(req.getXmmc());
        List<ImDicYpyf> dataList = findByEntity(condition);
        if (dataList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_IMDICYPY_0001");
        }
        ImDicYpyf imDicYpyf = BeanUtil.toBean(req, ImDicYpyf.class);
//        int ypyf = redisFactory.getTableKey(TableName.DB_NAME, TableName.IM_DIC_YPYF);
        String pydm = PinyinUtils.getSimplePinYin(imDicYpyf.getXmmc());
//        imDicYpyf.setYpyf(ypyf);
        imDicYpyf.setPydm(pydm);
        imDicYpyfDao.insert(imDicYpyf);
        sysDictConfigSer.upDateVersion("im_dic_ypyf");
    }

}
