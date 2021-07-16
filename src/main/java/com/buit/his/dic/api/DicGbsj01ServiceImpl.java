package com.buit.his.dic.api;

import com.buit.commons.PageQuery;
import com.buit.his.dic.dao.DicGbsj01Dao;
import com.buit.his.dic.dao.DicGbsj02Dao;
import com.buit.his.dic.model.DicGbsj01;
import com.buit.his.dic.model.DicGbsj02;
import com.buit.his.dic.service.DicGbsj01Ser;
import com.buit.system.request.DicGbsj01Model;
import com.buit.system.response.MaindicModel;
import com.buit.system.response.SondicModel;
import com.buit.system.service.DicGbsj01Service;
import com.buit.utill.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 标准数据主记录 - dubbo 服务实现
 *
 * @author : liushijie
 **/
@DubboService(timeout = 10000)
public class DicGbsj01ServiceImpl implements DicGbsj01Service {

    @Autowired
    DicGbsj01Ser dicGbsj01Ser;

    @Autowired
    private DicGbsj01Dao dicGbsj01Dao;

    @Autowired
    private DicGbsj02Dao dicGbsj02Dao;

    /**
     * 按条件分页查询
     *
     * @param model
     * @param page
     * @return
     */
    @Override
    public PageInfo<DicGbsj01Model> queryPage(DicGbsj01Model model, PageQuery page) {
        PageInfo<DicGbsj01Model> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicGbsj01Dao.findByEntity(model)
        );
        return pageInfo;
    }

    /**
     * 查询主数据集合
     *
     * @param pyCode
     * @param page
     * @return
     */
    @Override
    public PageInfo<DicGbsj01Model> queryPrimaryData(String pyCode, PageQuery page) {
        PageInfo<DicGbsj01Model> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicGbsj01Ser.getEntityMapper().queryPrimaryData(pyCode)
        );
        return pageInfo;
    }

    /**
     * 取所有主数据字典的值
     *
     * @return
     */
    @Override
    public List<MaindicModel> getAllDic() {
        List<MaindicModel> retList = new ArrayList<>();
        List<SondicModel> retSonList = new ArrayList<>();
        DicGbsj01 sysData = new DicGbsj01();
        sysData.setDeleted(0);
        List<DicGbsj01> listMain = dicGbsj01Dao.findByEntity(sysData);
        DicGbsj02 sysDataValue = new DicGbsj02();
        sysDataValue.setDeleted(0);
        List<DicGbsj02> listSon = dicGbsj02Dao.findByEntity(sysDataValue);
        for (DicGbsj01 spd : listMain) {
            MaindicModel maindic = new MaindicModel();
            maindic.setDk(spd.getPrimaryDataCode());
            maindic.setDname(spd.getPrimaryDataName());
            maindic.setDversion(spd.getDataVersion());
            maindic.setPid(spd.getPrimarydataId());
            retList.add(maindic);
        }
        for (DicGbsj02 spdv : listSon) {
            SondicModel sondic = new SondicModel();
            sondic.setDv(spdv.getDataValue());
            sondic.setDn(spdv.getDataValueRemark());
            sondic.setShowOrder(spdv.getSerialNumber());
            sondic.setStop(spdv.getStopFlag());
            sondic.setPy(spdv.getPyCode());
            sondic.setWb(spdv.getWbCode());
            sondic.setPid(spdv.getPrimarydataId());
            retSonList.add(sondic);
        }
        for (MaindicModel main : retList) {
            List<SondicModel> sonList = new ArrayList<>();
            for (SondicModel son : retSonList) {
                if (main.getPid().equals(son.getPid())) {
                    sonList.add(son);
                }
            }
            main.setSon(sonList);
        }
        return retList;
    }

    /**
     * 获取数据库主键
     *
     * @return
     */
    @Override
    public Integer getNextPrimaryDataId() {
        return dicGbsj01Dao.getNextPrimaryDataId();
    }

    /**
     * 新增主数据
     *
     * @param model
     */
    @Override
    public void add(DicGbsj01Model model) {
        dicGbsj01Ser.insert(model);
    }

    /**
     * 修改
     *
     * @param model
     */
    @Override
    public void update(DicGbsj01Model model) {
        dicGbsj01Ser.update(model);
    }

    /**
     * 删除
     *
     * @param primaryDataId
     */
    @Override
    public void delete(Integer primaryDataId) {
        dicGbsj01Ser.removeById(primaryDataId);
    }

    @Override
    public DicGbsj01Model findByCode(String code) {
        return BeanUtil.toBean(dicGbsj01Dao.findByCode(code), DicGbsj01Model.class);
    }
}
