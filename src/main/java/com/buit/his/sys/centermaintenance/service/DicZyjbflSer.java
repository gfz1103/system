package com.buit.his.sys.centermaintenance.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.DicZyjbflDao;
import com.buit.his.sys.centermaintenance.model.DicZyjbfl;
import com.buit.his.sys.centermaintenance.response.DicZyjbflResp;

/**
 * 中医疾病分类
 *
 * @author liushijie
 */
@Service
public class DicZyjbflSer extends BaseManagerImp<DicZyjbfl, Integer> {

    static final Logger logger = LoggerFactory.getLogger(DicZyjbflSer.class);

    @Autowired
    private DicZyjbflDao dicZyjbflDao;

    @Override
    public DicZyjbflDao getEntityMapper() {
        return dicZyjbflDao;
    }


    /**
     * 查询中医疾病分类，返回树集合
     * @return
     */
    public List<DicZyjbflResp> queryList() {
        List<DicZyjbflResp> data = dicZyjbflDao.queryList();
        List<DicZyjbflResp> rooList = new ArrayList<>();
        for (DicZyjbflResp resp : data) {
            if (0 == resp.getSjid()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for(DicZyjbflResp resp : rooList){
            resp.setChildrenList(getChildren(resp.getZyfl(), data));
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
    private List<DicZyjbflResp> getChildren(int id, List<DicZyjbflResp> dataList){
        //子菜单
        List<DicZyjbflResp> childList = new ArrayList<>();
        for(DicZyjbflResp resp : dataList){
            // 判断是否为子节点
            if(resp.getSjid().equals(id)){
                childList.add(resp);
            }
        }
        // 循环子子节点的子节点
        for(DicZyjbflResp resp : childList){
            resp.setChildrenList(getChildren(resp.getZyfl(), dataList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }

}
