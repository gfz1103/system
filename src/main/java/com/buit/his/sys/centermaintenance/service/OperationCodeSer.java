package com.buit.his.sys.centermaintenance.service;

import cn.hutool.json.JSONUtil;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DicJbbmDao;
import com.buit.his.sys.centermaintenance.dao.DicSsbmDao;
import com.buit.his.sys.centermaintenance.dao.FeeYlsfxmDao;
import com.buit.his.sys.centermaintenance.model.DicJbbm;
import com.buit.his.sys.centermaintenance.model.DicSsbm;
import com.buit.his.sys.centermaintenance.request.QueryOperationCodeReq;
import com.buit.his.sys.centermaintenance.request.SaveOperationCodeReq;
import com.buit.his.sys.centermaintenance.request.SssfxmReq;
import com.buit.his.sys.centermaintenance.response.OperationCodeResp;
import com.buit.his.sys.centermaintenance.response.SssfxmResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description
 * @Author yueyu
 * @Date 2020/11/9 16:09
 */
@Service
public class OperationCodeSer {

    static final Logger log = LoggerFactory.getLogger(OperationCodeSer.class);

    @Autowired
    RedisFactory redisFactory;
    @Autowired
    DicSsbmDao dicSsbmDao;
    @Autowired
    FeeYlsfxmDao feeYlsfxmDao;

    public void save(SaveOperationCodeReq req) {
        log.info("保存手术编码数据[{}]", JSONUtil.toJsonStr(req));
        DicSsbm dicSsbm = BeanUtil.toBean(req,DicSsbm.class);
        dicSsbmDao.replace(dicSsbm);
    }

    public PageInfo<OperationCodeResp> list(QueryOperationCodeReq req) {
        log.info("查询手术编码列表[{}]",JSONUtil.toJsonStr(req));
        PageInfo<OperationCodeResp> resp = PageHelper.startPage(req.getPageNum(),req.getPageSize())
                .doSelectPageInfo(()->dicSsbmDao.query(req));
        return resp;
    }

    public void delete(Integer id) {
        log.info("删除手术编码数据[{}]",id);
        dicSsbmDao.deleteById(id);
    }

    public void enable(Integer id) {
        log.info("启用/停用手术编码字典[{}]",id);
        dicSsbmDao.enable(id);
    }

    public OperationCodeResp get(Integer jbxh) {
        log.info("查询手术编码信息[{}]",jbxh);
        DicSsbm ssbm = dicSsbmDao.getById(jbxh);
        OperationCodeResp resp = BeanUtil.toBean(ssbm,OperationCodeResp.class);
        return resp;
    }
}
