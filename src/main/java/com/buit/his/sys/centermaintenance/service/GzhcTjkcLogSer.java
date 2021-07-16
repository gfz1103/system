package com.buit.his.sys.centermaintenance.service;


import cn.hutool.core.collection.CollectionUtil;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.GzhcTjkcLogDao;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj01;
import com.buit.his.sys.centermaintenance.model.GzhcTjkcLog;
import com.buit.his.sys.centermaintenance.response.FeeXmfytj02Resp;
import com.buit.mdi.response.HighQualityConsumablesResp;
import com.buit.utill.RedisFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jiangwei
 * @Description 高值耗材调价库存日志表
 * @Date 2021-07-08
 */
@Service
public class GzhcTjkcLogSer extends BaseManagerImp<GzhcTjkcLog, Integer> {

    static final Logger logger = LoggerFactory.getLogger(GzhcTjkcLogSer.class);

    @Autowired
    private GzhcTjkcLogDao gzhcTjkcLogDao;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public GzhcTjkcLogDao getEntityMapper() {
        return gzhcTjkcLogDao;
    }

    /**
     * 调价时保存项目库存
     *
     * @param tjd   调价单
     * @param tjdmx 调价单明细
     * @param list  库存视图
     */
    void save(FeeXmfytj01 tjd, FeeXmfytj02Resp tjdmx, List<HighQualityConsumablesResp> list) {
        if (CollectionUtil.isNotEmpty(list)) {
            for (HighQualityConsumablesResp resp : list) {
                GzhcTjkcLog entity = new GzhcTjkcLog();
                entity.setJlxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.GZHC_TJKC_LOG));
                entity.setJgid(tjd.getJgid());
                entity.setTjdh(tjd.getTjdh());
                entity.setSbxh(tjdmx.getSbxh());
                entity.setFyxh(tjdmx.getFyxh());
                entity.setKsdm(resp.getHisbmbm());
                entity.setJhjg(new BigDecimal(resp.getPrice()));
                entity.setKcsl(new BigDecimal(resp.getAmount()));
                entity.setSxrq(tjd.getSxrq());
                entity.setGg(resp.getGg());
                entity.setXx(resp.getXh());
                entity.setDw(resp.getUnit());
                entity.setSccj(resp.getSccjmc());
                entity.setYbbm(resp.getMedical_code());

                gzhcTjkcLogDao.insert(entity);
            }

        }


    }

}
