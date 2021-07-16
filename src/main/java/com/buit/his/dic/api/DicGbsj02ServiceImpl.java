package com.buit.his.dic.api;

import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.his.dic.dao.DicGbsj01Dao;
import com.buit.his.dic.dao.DicGbsj02Dao;
import com.buit.his.dic.model.DicGbsj02;
import com.buit.his.dic.service.DicGbsj02Ser;
import com.buit.his.enums.StopFlagEnum;
import com.buit.system.request.DicGbsj02Model;
import com.buit.system.response.DicGbsj02Resp;
import com.buit.system.response.DictDto;
import com.buit.system.service.DicGbsj02Service;
import com.buit.utill.BeanUtil;
import com.buit.utill.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 标准数据值域 - dubbo服务实现
 *
 * @author liushijie
 **/
@DubboService(timeout = 10000)
public class DicGbsj02ServiceImpl implements DicGbsj02Service {
    @Autowired
    private DicGbsj02Ser dicGbsj02Ser;
    @Autowired
    private DicGbsj02Dao dicGbsj02Dao;
    @Autowired
    private DicGbsj01Dao dicGbsj01Dao;

    /**
     * 按条件分页查询
     *
     * @param model
     * @param page
     * @return
     */
    @Override
    public PageInfo<DicGbsj02Model> queryPage(DicGbsj02Model model, PageQuery page) {
        PageInfo<DicGbsj02Model> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicGbsj02Ser.findByEntity(model)
        );
        return pageInfo;
    }

    /**
     * 查询值域数据集
     *
     * @param queryObj
     * @return
     */
    @Override
    public List<DicGbsj02Model> queryDataValueList(DicGbsj02Model queryObj) {
        List<DicGbsj02Model> retList = new ArrayList<>();
        List<DicGbsj02> dataList = dicGbsj02Ser.findByEntity(queryObj);
        for (DicGbsj02 data : dataList) {
            DicGbsj02Model model = BeanUtil.toBean(data, DicGbsj02Model.class);
            retList.add(model);
        }
        return retList;
    }

    /**
     * 获取数据库主键
     *
     * @return
     */
    @Override
    public Integer getNextPrimaryDataValueId() {
        return dicGbsj02Dao.getNextPrimaryDataValueId();
    }

    /**
     * 新增
     *
     * @param model
     */
    @Override
    public void add(DicGbsj02Model model) {
        dicGbsj02Ser.insert(model);
        dicGbsj01Dao.addVersion(model.getPrimarydataId());
    }

    /**
     * 修改
     *
     * @param model
     */
    @Override
    public void edit(DicGbsj02Model model) {
        dicGbsj02Ser.update(model);
        dicGbsj01Dao.addVersion(model.getPrimarydataId());
    }

    /**
     * 停用
     *
     * @param dataValueId
     */
    @Override
    public void stop(Integer dataValueId, SysUser user) {
        dicGbsj02Ser.stop(dataValueId, user);
    }

    /**
     * 启用
     *
     * @param dataValueId
     */
    @Override
    public void open(Integer dataValueId, SysUser user) {
        dicGbsj02Ser.open(dataValueId, user);
    }


    @Override
    public List<DictDto> queryGbzdByMainCode(Integer jgid, String mainCode) {
        return dicGbsj02Dao.queryGbzdByMainCode(jgid, mainCode);
    }

    @Override
    public DictDto findGbzdByMainCodeAndValue(Integer jgid, String mainCode, String value) {
        return dicGbsj02Dao.findGbzdByMainCodeAndValue(jgid, mainCode, value);
    }

    @Override
    public List<Map<String, String>> getValueByPrimaryDataCode(String code) {
        return dicGbsj02Dao.getValueByPrimaryDataCode(code);
    }

    @Override
    public List<DicGbsj02Model> findByEntity(DicGbsj02Model param) {
        return BeanUtil.toBeans(dicGbsj02Dao.findByEntity(BeanUtil.toBean(param, DicGbsj02.class)), DicGbsj02Model.class);
    }

    @Override
    public List<DicGbsj02Model> findAllByEntity(DicGbsj02Model param) {
        return dicGbsj02Dao.findAllByEntity(BeanUtil.toBean(param, DicGbsj02.class));
    }

    @Override
    public PageInfo<DicGbsj02Resp> queryDicBgsj02(DicGbsj02Model param) {
        PageInfo<DicGbsj02Resp> pageInfo = PageHelper.startPage(param.getPageNum(), param.getPageSize())
                .doSelectPageInfo(() -> dicGbsj02Dao.findByEntity(BeanUtil.toBean(param, DicGbsj02.class)));
        return pageInfo;
    }
}
