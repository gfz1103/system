package com.buit.his.sys.centermaintenance.service;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.his.sys.centermaintenance.dao.DicZyzhflDao;
import com.buit.his.sys.centermaintenance.model.DicZyzhfl;
import com.buit.his.sys.centermaintenance.response.DicZyzhflResp;

/**
 * 中医证候分类
 *
 * @author liushijie
 */
@Service
public class DicZyzhflSer extends BaseManagerImp<DicZyzhfl, Integer> {

    static final Logger logger = LoggerFactory.getLogger(DicZyzhflSer.class);

    @Autowired
    private DicZyzhflDao dicZyzhflDao;

    @Override
    public DicZyzhflDao getEntityMapper() {
        return dicZyzhflDao;
    }

    /**
     * 查询中医疾病分类，返回树集合
     * @return
     */
    public List<DicZyzhflResp> queryList() {
        List<DicZyzhflResp> data = dicZyzhflDao.queryList();
        List<DicZyzhflResp> rooList = new ArrayList<>();
        for (DicZyzhflResp resp : data) {
            if (0 == resp.getParentId()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for(DicZyzhflResp resp : rooList){
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
    private List<DicZyzhflResp> getChildren(int id, List<DicZyzhflResp> dataList){
        //子菜单
        List<DicZyzhflResp> childList = new ArrayList<>();
        for(DicZyzhflResp resp : dataList){
            // 判断是否为子节点
            if(resp.getParentId().equals(id)){
                childList.add(resp);
            }
        }
        // 循环子子节点的子节点
        for(DicZyzhflResp resp : childList){
            resp.setChildrenList(getChildren(resp.getId(), dataList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }

    /**
     * 证候分类列表数据
     * @return
     */
    public List<DicZyzhflResp> dropList(){
        return dicZyzhflDao.queryList();
    }


}
