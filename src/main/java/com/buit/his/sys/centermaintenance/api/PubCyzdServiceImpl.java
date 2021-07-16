package com.buit.his.sys.centermaintenance.api;

import com.buit.commons.BaseException;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.PubCyzdDao;
import com.buit.his.sys.centermaintenance.model.PubCyzd;
import com.buit.system.request.IPubCyzdReq;
import com.buit.system.request.IPubCyzdSaveReq;
import com.buit.system.response.IPubCyzdResp;
import com.buit.system.service.PubCyzdService;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description 类描述
 * @Author 老花生
 * @Date 2020/10/14 18:24
 */
@DubboService
public class PubCyzdServiceImpl implements PubCyzdService {
    @Autowired
    private PubCyzdDao pubCyzdDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public List<IPubCyzdResp> query(IPubCyzdReq pubcyzd) {
        return pubCyzdDao.query(pubcyzd);
    }

    @Override
    public PageInfo<IPubCyzdResp> queryPage(IPubCyzdReq pubcyzd) {
        PageInfo<IPubCyzdResp> pageInfo = PageHelper.startPage(
                pubcyzd.getPageNum(), pubcyzd.getPageSize()).doSelectPageInfo(
                () -> pubCyzdDao.query(pubcyzd)
        );
        return pageInfo;
    }

    @Override
    public void add(IPubCyzdSaveReq req) {
        PubCyzd query = new PubCyzd();
        query.setZdxh(req.getZdxh());
        query.setYgdm(req.getYgdm());
        query.setCflx(req.getCflx());
        query.setJgid(req.getJgid());
        List<PubCyzd> ret = pubCyzdDao.findByEntity(query);
        if(!ret.isEmpty()){
            throw BaseException.create("ERROR_DCTWORK_OP_0001");
        }

        PubCyzd pubcyzd = BeanUtil.toBean(req, PubCyzd.class);
        pubcyzd.setJlbh(redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_CYZD));
        pubcyzd.setPydm(PinyinUtils.getSimplePinYin(req.getZdmc()));
        pubcyzd.setWbdm(WubiUtils.getSimpleWuBi(req.getZdmc()));
        pubCyzdDao.insert(pubcyzd);
    }

    @Override
    public void removeById(Integer id) {
        pubCyzdDao.deleteById(id);
    }
}
