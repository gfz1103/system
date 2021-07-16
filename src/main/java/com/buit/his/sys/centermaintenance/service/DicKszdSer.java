package com.buit.his.sys.centermaintenance.service;


import java.util.ArrayList;
import java.util.List;

import com.buit.his.shyb.source.model.ShybData02Resp;
import com.buit.his.shyb.source.service.impl.ShybSh02Service;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.DicKszdDao;
import com.buit.his.sys.centermaintenance.request.DicKszdAddReq;
import com.buit.his.sys.centermaintenance.response.DicKszdResp;
import com.buit.system.model.DicKszd;
import com.buit.utill.BeanUtil;
import com.buit.utill.RedisFactory;

/**
 * <br>
 *
 * @author 老花生
 */
@Service
public class DicKszdSer extends BaseManagerImp<DicKszd, Integer> {

    static final Logger logger = LoggerFactory.getLogger(DicKszdSer.class);

    @Autowired
    private DicKszdDao dicKszdDao;

    @DubboReference
    private ShybSh02Service shybSh02Service;

    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @Override
    public DicKszdDao getEntityMapper() {
        return dicKszdDao;
    }

    /**
     * 新增
     *
     * @param req
     */
    public void add(DicKszdAddReq req) {
        int id = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_KSZD);
        DicKszd office = BeanUtil.toBean(req, DicKszd.class);
        office.setId(id);
        dicKszdDao.insert(office);
        sysDictConfigSer.upDateVersion("dic_kszd");
    }

    /**
     * 查询科室集合, 返回树集合
     *
     * @return
     */
    public List<DicKszdResp> queryList(String pycode, Integer parentid) {
        List<DicKszdResp> data = dicKszdDao.queryList(pycode, parentid);
        List<DicKszdResp> rooList = new ArrayList<>();
        for (DicKszdResp resp : data) {
            if ("0".equals(resp.getParentid())) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for (DicKszdResp resp : rooList) {
            resp.setChildrenList(getChildren(resp.getId(), data));
        }
        return rooList;
    }

    /**
     * 递归查找子集
     *
     * @param id       当前数据id
     * @param dataList 数据列表
     * @return
     */
    private List<DicKszdResp> getChildren(Integer id, List<DicKszdResp> dataList) {
        //子菜单
        List<DicKszdResp> childList = new ArrayList<>();
        for (DicKszdResp resp : dataList) {
            // 判断是否为子节点
            if (resp.getParentid().equals(id + "")) {
                childList.add(resp);
            }
        }
        // 循环子子节点的子节点
        for (DicKszdResp resp : childList) {
            resp.setChildrenList(getChildren(resp.getId(), dataList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            List<DicKszdResp> retChildList = new ArrayList<>();
            return retChildList;
        }
        return childList;
    }

    /**
     * 查询医保科室, 返回树结构
     *
     * @return
     */
    public List<ShybData02Resp> queryYbList() {
        List<ShybData02Resp> data = shybSh02Service.queryList();
        List<ShybData02Resp> rooList = new ArrayList<>();
        for (ShybData02Resp resp : data) {
            if (0 == resp.getParentDatavalueId()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for (ShybData02Resp resp : rooList) {
            resp.setChildrenList(getYbChildren(resp.getYbdatavalueId(), data));
        }
        return rooList;
    }
    /**
     * 查询线上医保科室, 返回树结构
     *
     * @return
     */
    public List<ShybData02Resp> queryXSYbList() {
        List<ShybData02Resp> data = shybSh02Service.queryXsList();
        List<ShybData02Resp> rooList = new ArrayList<>();
        for (ShybData02Resp resp : data) {
            if (0 == resp.getParentDatavalueId()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for (ShybData02Resp resp : rooList) {
            resp.setChildrenList(getYbChildren(resp.getYbdatavalueId(), data));
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
   private List<ShybData02Resp> getYbChildren(Integer id, List<ShybData02Resp> dataList){
       //子菜单
       List<ShybData02Resp> childList = new ArrayList<>();
       for(ShybData02Resp resp : dataList){
           // 判断是否为子节点
           if(resp.getParentDatavalueId().equals(id)){
               childList.add(resp);
           }
       }
       // 循环子子节点的子节点
       for(ShybData02Resp resp : childList){
           resp.setChildrenList(getYbChildren(resp.getYbdatavalueId(), dataList));
       }
       // 递归退出条件
       if (childList.size() == 0){
           List<ShybData02Resp> retChildList = new ArrayList<>();
           return retChildList;
       }
       return childList;
   }


    public DicKszdResp detail(Integer jgid, String brks) {
        return dicKszdDao.getByKsdm(jgid, brks);
    }
}
