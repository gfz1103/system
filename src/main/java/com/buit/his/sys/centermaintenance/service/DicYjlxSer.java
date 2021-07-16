package com.buit.his.sys.centermaintenance.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.dao.DicYjlxDao;
import com.buit.his.sys.centermaintenance.model.DicYjlx;
import com.buit.his.sys.centermaintenance.request.DicYjlxAddReq;
import com.buit.his.sys.centermaintenance.response.DicYjlxResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;

/**
 * 医技类型维护<br>
 *
 * @author 老花生
 */
@Service
public class DicYjlxSer extends BaseManagerImp<DicYjlx, Integer> {

    static final Logger logger = LoggerFactory.getLogger(DicYjlxSer.class);

    @Autowired
    private DicYjlxDao dicYjlxDao;

    @Autowired
    private RedisFactory redisFactory;

    @Override
    public DicYjlxDao getEntityMapper() {
        return dicYjlxDao;
    }

    /**
     * 获取医技分类树结构
     *
     * @return
     */
    public List<DicYjlxResp> loadDicData(Integer pid) {
        return dicYjlxDao.loadDicData(pid);
    }

    /**
     * 新增
     * @param req
     */
    public void add(DicYjlxAddReq req) {
//        int id = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_YJLX);
        DicYjlx dicYjlx = BeanUtil.toBean(req, DicYjlx.class);
//        dicYjlx.setId(id);
        dicYjlx.setZxbz("0");
        dicYjlxDao.insert(dicYjlx);
    }

    /**
     * 中心维护-返回医技类型树集合
     * @return
     */
    public List<DicYjlxResp> getTree() {
        List<DicYjlxResp> data = dicYjlxDao.getTree();
        List<DicYjlxResp> rooList = new ArrayList<>();
        for (DicYjlxResp resp : data) {
            if (0 == resp.getPid()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for(DicYjlxResp resp : rooList){
            resp.setChildrenList(getChildren(resp.getId(), data));
        }
        return rooList;
    }

    /**
     * 递归查找子集
     *
     * @param id 当前数据id
     * @param dataList 数据列表
     * @return
     */
    private List<DicYjlxResp> getChildren(int id, List<DicYjlxResp> dataList){
        //子菜单
        List<DicYjlxResp> childList = new ArrayList<>();
        for(DicYjlxResp resp : dataList){
            // 判断是否为子节点
            if(resp.getPid().equals(id)){
                childList.add(resp);
            }
        }
        // 循环子子节点的子节点
        for(DicYjlxResp resp : childList){
            resp.setChildrenList(getChildren(resp.getId(), dataList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }



}
