package com.buit.his.dic.service;


import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.commons.PageQuery;
import com.buit.constans.TableName;
import com.buit.his.dic.dao.SysDictConfigDao;
import com.buit.his.dic.model.SysDictConfig;
import com.buit.his.dic.request.SysDictConfigAddReq;
import com.buit.his.dic.request.SysDictConfigEditReq;
import com.buit.his.dic.request.SysDictConfigPageReq;
import com.buit.his.dic.response.Sondic;
import com.buit.his.dic.response.SysDictConfigPageResp;
import com.buit.his.enums.StopFlagEnum;
import com.buit.commons.SysUser;
import com.buit.utill.BeanUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * 字典配置<br>
 * @author MLeo
 */
@Service
public class SysDictConfigSer extends BaseManagerImp<SysDictConfig,Integer> {
    
    static final Logger logger = LoggerFactory.getLogger(SysDictConfigSer.class);
    
    @Autowired
    private SysDictConfigDao sysDictConfigDao;
    @Autowired
    private RedisFactory redisFactory;

    @Override
    public SysDictConfigDao getEntityMapper(){        
        return sysDictConfigDao;
    }

    /**
     * 更新版本信息
     * @param dictId
     */
    public void upDateVersion(String tableName){
    	SysDictConfig sysDictConfig=new SysDictConfig();
    	sysDictConfig.setQuerySql(tableName.toLowerCase());
    	sysDictConfig.setGmtModify(DateUtil.getCurrentTimestamp());
         sysDictConfigDao.updateVersion(sysDictConfig);
    }

    /**
     * 分页查询
     * @param user
     * @param req
     * @return
     */
    public PageInfo<SysDictConfigPageResp> page(SysUser user, SysDictConfigPageReq req) {
        SysDictConfig config = BeanUtil.toBean(req,SysDictConfig.class);
        config.setHospitalId(user.getHospitalId());
        setSortColumns(config);
        PageInfo<SysDictConfig> pageInfo = PageHelper.startPage(
                config.getPageNum(), config.getPageSize()).doSelectPageInfo(
                () -> sysDictConfigDao.findByEntity(config)
        );
        return BeanUtil.toPage(pageInfo,SysDictConfigPageResp.class);
    }

    /**
     * 添加数据
     * @param user
     * @param req
     * @return
     */
    public Integer add(SysUser user, SysDictConfigAddReq req) {
//        Integer id = redisFactory.getTableKey(TableName.DB_NAME,TableName.SYS_DICT_CONFIG);
        SysDictConfig config = BeanUtil.toBean(req,SysDictConfig.class);
//        config.setDictId(id);
        config.setHospitalId(user.getHospitalId());
        sysDictConfigDao.insert(config);
        return config.getDictId();
    }

    /**
     * 编辑数据
     * @param user
     * @param req
     */
    public void edit(SysUser user, SysDictConfigEditReq req) {
        SysDictConfig config = BeanUtil.toBean(req,SysDictConfig.class);
        sysDictConfigDao.update(config);
    }

    /**
     * 停用
     * @param id
     */
    public void stop(Integer id) {
        updateFlag(id,StopFlagEnum.code_1);
    }

    /**
     * 启用
     * @param id
     */
    public void enable(Integer id) {
        updateFlag(id,StopFlagEnum.code_0);
    }

    /**
     * 更新状态
     * @param id
     * @param stopFlagEnum
     */
    private void updateFlag(Integer id, StopFlagEnum stopFlagEnum){
        SysDictConfig config = new SysDictConfig();
        config.setDictId(id);
        config.setStopFlag(stopFlagEnum.getCode());
        sysDictConfigDao.updateFlag(config);
    }

    public PageInfo<Sondic> detailPage(Integer id, SysUser user, PageQuery page) {
        SysDictConfig dict = sysDictConfigDao.getById(id);
        if(null == dict){
            return new PageInfo<>();
        }
        String sql = dict.getQuerySql();
        Map<String, Object> parameter = new HashMap<>();
        parameter.put("hospitalId",user.getHospitalId());
        parameter.put("sql",sql);
        PageInfo<Sondic> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> sysDictConfigDao.runSondic(parameter)
        );
        return pageInfo;
    }
}
