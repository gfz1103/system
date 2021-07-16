package com.buit.his.dic.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.dao.DicGbsj01Dao;
import com.buit.his.dic.dao.DicGbsj02Dao;
import com.buit.his.dic.model.DicGbsj02;
import com.buit.his.dic.request.DicGbsj01PageReq;
import com.buit.his.dic.request.DicGbsj02AddReq;
import com.buit.his.dic.request.DicGbsj02EditReq;
import com.buit.his.dic.response.DicGbsj02DetailResp;
import com.buit.his.dic.response.DicGbsj02PageResp;
import com.buit.his.enums.StopFlagEnum;
import com.buit.commons.SysUser;
import com.buit.utill.BeanUtil;
import com.buit.utill.ChineseCharacterUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 标准数据值域记录<br>
 * @author 老花生
 */
@Service
public class DicGbsj02Ser extends BaseManagerImp<DicGbsj02,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(DicGbsj02Ser.class);
    
    @Autowired
    private DicGbsj02Dao dicGbsj02Dao;
    @Autowired
    private DicGbsj01Dao dicGbsj01Dao;
    @Autowired
    private UpdateWebDbSer updateWebDbSer;

    @Autowired
    private RedisFactory redisFactory;
    
    @Override
    public DicGbsj02Dao getEntityMapper(){        
        return dicGbsj02Dao;
    }

    /**
     * 分页查询
     * @param req   请求参数
     * @return
     */
    public PageInfo<DicGbsj02PageResp> page(DicGbsj01PageReq req) {
        setSortColumns(req);
        DicGbsj02 data = BeanUtil.toBean(req, DicGbsj02.class);
        PageInfo<DicGbsj02PageResp> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> dicGbsj02Dao.findByEntity(data)
        );
        return pageInfo;
    }

    /**
     * 停用
     * @param id    主键ID
     */
    public void stop(Integer id, SysUser user) {
        DicGbsj02 dataValue = new DicGbsj02();
        dataValue.setOperatorId(user.getUserId());
        dataValue.setDatavalueId(id);
        dataValue.setGmtModify(DateUtil.getCurrentTimestamp());
        dataValue.setStopFlag(StopFlagEnum.code_1.getCode());
        dicGbsj02Dao.updateStatus(dataValue);
        DicGbsj02 data = dicGbsj02Dao.getById(id);
        dicGbsj01Dao.addVersion(data.getPrimarydataId());
        updateWebDbSer.updateWebDb();
    }

    /**
     * 启用
     * @param id    主键ID
     */
    public void open(Integer id, SysUser user) {
        DicGbsj02 dataValue = new DicGbsj02();
        dataValue.setOperatorId(user.getUserId());
        dataValue.setDatavalueId(id);
        dataValue.setGmtModify(DateUtil.getCurrentTimestamp());
        dataValue.setStopFlag(StopFlagEnum.code_0.getCode());
        dicGbsj02Dao.updateStatus(dataValue);
    }

    /**
     * 编辑
     * @param req   请求参数
     */
    public void edit(DicGbsj02EditReq req, SysUser user) {
        DicGbsj02 data = dicGbsj02Dao.getById(req.getDatavalueId());
        BeanUtils.copyProperties(req, data);
        data.setOperatorId(user.getUserId());
        data.setDataVersion(data.getDataVersion() + 1);
        data.setGmtModify(DateUtil.getCurrentTimestamp());
        ChineseCharacterUtil.setPyAndWb(data, data.getDataValueRemark());

        dicGbsj02Dao.update(data);
        dicGbsj01Dao.addVersion(data.getPrimarydataId());
        updateWebDbSer.updateWebDb();
    }

    /**
     * 新增
     * @param req   请求参数
     * @param user  用户信息
     */
    public void add(DicGbsj02AddReq req, SysUser user) {
        DicGbsj02 data = BeanUtil.toBean(req, DicGbsj02.class);
        data.setOperatorId(user.getUserId());
        data.setCreateId(user.getUserId());
        data.setHospitalId(user.getHospitalId());
        data.setGmtCreate(DateUtil.getCurrentTimestamp());
        data.setDataversionId(data.getPrimarydataId());
        data.setStopFlag(StopFlagEnum.code_0.getCode());
        ChineseCharacterUtil.setPyAndWb(data, data.getDataValueRemark());

        dicGbsj02Dao.insert(data);
        dicGbsj01Dao.addVersion(data.getPrimarydataId());
        updateWebDbSer.updateWebDb();
    }

    /**
     * 明细
     * @param id    主键ID
     * @return
     */
    public DicGbsj02DetailResp detail(Integer id) {
        DicGbsj02 value = dicGbsj02Dao.getById(id);
        DicGbsj02DetailResp response = BeanUtil.toBean(value,DicGbsj02DetailResp.class);
        return response;
    }
}
