package com.buit.his.sys.centermaintenance.api;

import cn.hutool.core.collection.CollectionUtil;
import com.buit.his.sys.centermaintenance.dao.PubFkfsDao;
import com.buit.his.sys.centermaintenance.model.PubFkfs;
import com.buit.system.request.PubFkfsModel;
import com.buit.system.service.PubFkfsService;
import com.buit.utill.BeanUtil;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * 公用付款方式服务实现类
 */
@DubboService(timeout = 10000)
public class PubFkfsSerImpl implements PubFkfsService {
    @Autowired
    private PubFkfsDao pubFkfsDao;

    @Override
    public List<Map<String, Object>> getPubFkfsInfo(Map<String, Object> map) {
        return pubFkfsDao.getPubFkfsInfo(map);
    }

    @Override
    public List<Map<String, Object>> getZzsFkfs(String zzsFkfs) {
        return pubFkfsDao.getZzsFkfs(zzsFkfs);
    }

    @Override
    public PubFkfsModel findZyfkfs() {
        PubFkfsModel pubFkfs = new PubFkfsModel();
        BeanUtils.copyProperties(pubFkfsDao.findZyfkfs(), pubFkfs);
        return pubFkfs;
    }

    @Override
    public void updateZfbz(Integer zfbz, Integer fkfs) {
        pubFkfsDao.updateZfbz(zfbz, fkfs);
    }

    @Override
    public void setMrbz(Integer fkfs, Integer mrbz, Integer sylx) {
        pubFkfsDao.setMrbz(fkfs, mrbz, sylx);
    }

    @Override
    public void reductionMrbz(Integer sylx) {
        pubFkfsDao.reductionMrbz(sylx);
    }

    @Override
    public void setHbwc(Integer fkfs, Integer hbwc, Integer sylx) {
        pubFkfsDao.setHbwc(fkfs, hbwc, sylx);
    }

    @Override
    public void reductionHbwc(Integer sylx) {
        pubFkfsDao.reductionHbwc(sylx);
    }

    @Override
    public List<Map<String, Object>> doQueryFkfs(Map<String, Object> parameters) {
        return pubFkfsDao.doQueryFkfs(parameters);
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    public PubFkfsModel getById(Integer id) {
        PubFkfs pubFkfs = pubFkfsDao.getById(id);
        return BeanUtil.toBean(pubFkfs, PubFkfsModel.class);
    }

    @Override
    public List<PubFkfsModel> findByEntity(PubFkfsModel param) {
        return BeanUtil.toBeans(pubFkfsDao.findByEntity(BeanUtil.toBean(param, PubFkfs.class)), PubFkfsModel.class);
    }

    @Override
    public PubFkfsModel getHbwc(Integer ywlx) {
        PubFkfs query = new PubFkfs();
        query.setSylx(ywlx);
        query.setHbwc(1);
        query.setZfbz(0);
        List<PubFkfs> list = pubFkfsDao.findByEntity(query);
        if (CollectionUtil.isNotEmpty(list)) {
            return BeanUtil.toBean(list.get(0), PubFkfsModel.class);
        }
        return null;
    }
}
