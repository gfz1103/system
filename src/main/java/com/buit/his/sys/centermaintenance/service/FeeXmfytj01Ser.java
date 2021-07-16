package com.buit.his.sys.centermaintenance.service;


import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.OperationTypeEnum;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.FeeXmfytj01Dao;
import com.buit.his.sys.centermaintenance.dao.FeeXmfytj02Dao;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmDao;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmdjDao;
import com.buit.his.sys.centermaintenance.enums.TjdSxpbEnum;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj01;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj02;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.request.FeeXmfytj01Req;
import com.buit.his.sys.centermaintenance.response.FeeXmfytj02Resp;
import com.buit.his.sys.centermaintenance.response.GyFytjResp;
import com.buit.mdi.response.HighQualityConsumablesResp;
import com.buit.mdi.service.MdiVejkfBatchViewService;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.DateUtils;
import com.buit.utill.RedisFactory;
import org.apache.commons.collections.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * <br>
 *
 * @author GONGFANGZHOU
 */
@Service
public class FeeXmfytj01Ser extends BaseManagerImp<FeeXmfytj01, Integer> {

    static final Logger logger = LoggerFactory.getLogger(FeeXmfytj01Ser.class);

    @Autowired
    private FeeXmfytj01Dao feeXmfytj01Dao;

    @Override
    public FeeXmfytj01Dao getEntityMapper() {
        return feeXmfytj01Dao;
    }

    @Autowired
    private RedisFactory redisFactory;

    @Autowired
    private FeeXmfytj02Dao feeXmfytj02Dao;

    @Autowired
    private FeeYlsfxmdjDao feeYlsfxmdjDao;

    @Autowired
    private FeeYlsfxmDao feeYlsfxmDao;

    @DubboReference
    private MdiVejkfBatchViewService mdiVejkfBatchViewService;

    @Autowired
    private GzhcTjkcLogSer gzhcTjkcLogSer;

    /**
     * 新增或修改调价单
     *
     * @param @param feeXmfytj01Req
     * @param @param user    设定文件
     * @return void    返回类型
     * @throws
     * @Title: doSaveAdjustment
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    @Transactional(rollbackFor = Exception.class)
    public void doSaveAdjustment(FeeXmfytj01Req feeXmfytj01Req, SysUser user) {
        String opStatus = feeXmfytj01Req.getOpStatus();//操作类型 create/update
        Integer jgid = user.getHospitalId();
        String userId = String.valueOf(user.getUserId());
        Timestamp now = DateUtils.getNow();

        Integer tjdh = feeXmfytj01Req.getTjdh();
        List<FeeXmfytj02> feexmfytj02List = feeXmfytj01Req.getFytj02List();

        if (OperationTypeEnum.create.getCode().equals(opStatus)) {
            String year = DateUtils.getToday().substring(2, 4);
            // 查询当年最大调价单号
            String maxTjdh = feeXmfytj01Dao.queryMaxTjdh(jgid, year);
            if (StrUtil.isBlank(maxTjdh)) {
                maxTjdh = year + "0000";
            }
            if (Integer.valueOf(maxTjdh.substring(2)) >= 9999) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_GYFYTJ01_0001");
            }
            feeXmfytj01Req.setTjdh(Integer.valueOf(maxTjdh) + 1);
            feeXmfytj01Req.setJgid(jgid);
            feeXmfytj01Req.setRrgh(userId);
            feeXmfytj01Req.setRrrq(DateUtil.date().toTimestamp());
            feeXmfytj01Req.setZxpb(TjdSxpbEnum.DEACTIVATE.getValue());
            feeXmfytj01Req.setSxpb(TjdSxpbEnum.DEACTIVATE.getValue());

            feeXmfytj01Dao.insert(feeXmfytj01Req);
        } else {
            FeeXmfytj01 feeXmfytj01 = new FeeXmfytj01();
            BeanUtil.copyProperties(feeXmfytj01Req, feeXmfytj01);
            feeXmfytj01Dao.updateByEntity(feeXmfytj01);
        }

        FeeXmfytj02 feeXmfytj02Del = new FeeXmfytj02();
        feeXmfytj02Del.setJgid(jgid);
        feeXmfytj02Del.setTjdh(ObjectToTypes.parseInt(tjdh));
        feeXmfytj02Dao.removeByEntity(feeXmfytj02Del);
        for (FeeXmfytj02 feeXmfytj02 : feexmfytj02List) {
            feeXmfytj02.setJgid(jgid);
            feeXmfytj02.setTjdh(ObjectToTypes.parseInt(tjdh));
            feeXmfytj02.setSbxh(redisFactory.getTableKey(TableName.DB_NAME, TableName.FEE_XMFYTJ02));
            feeXmfytj02Dao.insert(feeXmfytj02);
        }
    }

    /**
     * 使调价单立即生效
     *
     * @param @param tjdh
     * @param @param user    设定文件
     * @return void    返回类型
     * @throws
     * @Title: doEffectAdjustment
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    @Transactional(rollbackFor = Exception.class)
    public void doEffectAdjustment(Integer tjdh, SysUser user) {
        Integer jgid = user.getHospitalId();
        String uid = ObjectToTypes.parseString(user.getUserId());
        FeeXmfytj01 feeXmfytj01 = new FeeXmfytj01();
        feeXmfytj01.setTjdh(tjdh);
        feeXmfytj01.setJgid(jgid);
        feeXmfytj01.setSxgh(uid);
        feeXmfytj01.setSxrq(DateUtil.date().toTimestamp());
        long count = feeXmfytj01Dao.updateEffectAdjustment(feeXmfytj01);
        if (count <= 0) {
            return;
        }
        feeYlsfxmdjDao.updatePriceAdjustment(jgid, tjdh);
        List<FeeXmfytj02Resp> feeXmfytj02RespList = feeXmfytj02Dao.queryGyFytjYlsf(tjdh, user.getHospitalId());
        if (CollectionUtil.isNotEmpty(feeXmfytj02RespList)) {
            for (FeeXmfytj02Resp resp : feeXmfytj02RespList) {
                FeeYlsfxm feeYlsfxm = feeYlsfxmDao.getById(resp.getFyxh());
                List<HighQualityConsumablesResp> list = mdiVejkfBatchViewService.findListByXmbm(feeYlsfxm.getXmbm());
                gzhcTjkcLogSer.save(feeXmfytj01, resp, list);
            }
        }
    }

    /**
     * 查询收费项目调价明细
     *
     * @param @param  tjdh
     * @param @param  user
     * @param @return 设定文件
     * @return GyFytjResp    返回类型
     * @throws
     * @Title: doLoadAdjustmentAndDetail
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    public GyFytjResp doLoadAdjustmentAndDetail(Integer tjdh, SysUser user) {
        GyFytjResp gyFytjResp = new GyFytjResp();
        FeeXmfytj01 feeXmfytj01 = new FeeXmfytj01();
        feeXmfytj01.setTjdh(tjdh);
        feeXmfytj01.setJgid(user.getHospitalId());
        List<FeeXmfytj01> feeXmfytj01List = feeXmfytj01Dao.findByEntity(feeXmfytj01);
        if (CollectionUtils.isNotEmpty(feeXmfytj01List)) {
            gyFytjResp.setFeeXmfytj01(feeXmfytj01List.get(0));
        }
        List<FeeXmfytj02Resp> feeXmfytj02RespList = feeXmfytj02Dao.queryGyFytjYlsf(tjdh, user.getHospitalId());
        if (CollectionUtils.isNotEmpty(feeXmfytj02RespList)) {
            gyFytjResp.setFeeXmfytj02RespList(feeXmfytj02RespList);
        }
        return gyFytjResp;
    }

    /**
     * 调价单作废
     *
     * @param tjdh 调价单号
     */
    public void cancelAdjustment(Integer tjdh, SysUser user) {
        FeeXmfytj01 feeXmfytj01 = feeXmfytj01Dao.getByTjdh(tjdh, user.getHospitalId());
        if (!TjdSxpbEnum.DEACTIVATE.equals(feeXmfytj01.getSxpb())) {
            throw BaseException.create("ERROR_SYS_CENTERMAINTENANCE_0001");
        }
        FeeXmfytj01 query = new FeeXmfytj01();
        query.setTjdh(feeXmfytj01.getTjdh());
        query.setSxpb(TjdSxpbEnum.CANCELED.getValue());
        query.setSxgh(String.valueOf(user.getUserId()));
        query.setSxrq(DateUtils.getNow());
        feeXmfytj01Dao.updateByEntity(query);
    }
}
