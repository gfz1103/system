package com.buit.his.sys.centermaintenance.service;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.PubBrxzDao;
import com.buit.his.sys.centermaintenance.model.PubBrxz;
import com.buit.his.sys.centermaintenance.request.FeeSfdlzfblEditReq;
import com.buit.his.sys.centermaintenance.request.FeeYpxzAddReq;
import com.buit.his.sys.centermaintenance.request.FeeYpxzEditReq;
import com.buit.his.sys.centermaintenance.request.PubBrxzNewAddReq;
import com.buit.his.sys.centermaintenance.request.PubBrxzSaveReq;
import com.buit.his.sys.centermaintenance.request.PubFyxzAddReq;
import com.buit.his.sys.centermaintenance.response.FeeYpxzYpxzResp;
import com.buit.his.sys.centermaintenance.response.GyFyxzDicResp;
import com.buit.his.sys.centermaintenance.response.PubBrxzTreeResp;
import com.buit.his.sys.centermaintenance.response.PubFyxzFyxzResp;
import com.buit.system.model.DicSfxmlb;
import com.buit.system.response.DicSfxmlbZfblResp;
import com.buit.system.response.FeeSfdlzfbl;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;

/**
 * 公用_病人性质 | 包括自费、公费、记帐等<br>
 *
 * @author "MLeo"
 */
@Service
public class PubBrxzSer extends BaseManagerImp<PubBrxz, Integer> {

    static final Logger logger = LoggerFactory.getLogger(PubBrxzSer.class);

    @Autowired
    private PubBrxzDao pubBrxzDao;
    @Autowired
    private FeeYpxzSer feeYpxzSer;
    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private DicSfxmlbSer dicSfxmlbSer;
    @Autowired
    private FeeYpxzSer getFeeYpxzSer;
    @Autowired
    private PubFyxzSer pubFyxzSer;
    @Autowired
    private FeeSfdlzfblSer feeSfdlzfblSer;
    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;


    @Override
    public PubBrxzDao getEntityMapper() {
        return pubBrxzDao;
    }

//    public List<PubBrxzListResp> getListByYpxh(Integer ypxh) {
//        List<PubBrxzListResp> resps = pubBrxzDao.getListByYpxh(ypxh);
//        return resps;
//    }

    public void save(PubBrxzSaveReq req) {
        List<PubBrxzSaveReq.PubBrxzAddReq> adds = req.getAdds();
        if (CollectionUtils.isEmpty(adds)) {
            return;
        }
        feeYpxzSer.batchAdd(adds);
        sysDictConfigSer.upDateVersion("pub_brxz");
    }

    /**
     * 病人性质查询实际病人性质
     *
     * @param brxz
     * @return
     */
    public PubBrxz querySjBrxz(Integer brxz) {
        return pubBrxzDao.querySjBrxzByBrxz(brxz);
    }

    /**
     * 新增
     *
     * @param req
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public void add(PubBrxzNewAddReq req) {
//        Integer id = redisFactory.getTableKey(TableName.DB_NAME, TableName.PUB_BRXZ);
        PubBrxz pubBrxz = BeanUtil.toBean(req, PubBrxz.class);
//        pubBrxz.setBrxz(id);
        pubBrxz.setTffbjy(0);
        pubBrxz.setPydm(PinyinUtils.getSimplePinYin(pubBrxz.getXzmc()));
        pubBrxz.setSsbl(new BigDecimal(0));
        pubBrxz.setGsxz(req.getSjxz());
        pubBrxzDao.insert(pubBrxz);

        // 初始化自付比例数据
        List<DicSfxmlb> sfxmList = dicSfxmlbSer.findByEntity(null);
        for (DicSfxmlb x : sfxmList) {
            FeeSfdlzfbl zf = new FeeSfdlzfbl();
            zf.setSfxm(x.getSfxm());
            zf.setBrxz(pubBrxz.getBrxz());
            zf.setZfbl(new BigDecimal(0));
            feeSfdlzfblSer.insert(zf);
        }
        sysDictConfigSer.upDateVersion("pub_brxz");
    }

    /**
     * 查询病人性质树
     * @return
     */
    public List<PubBrxzTreeResp> getTree() {
        List<PubBrxzTreeResp> data = pubBrxzDao.queryTree();
        List<PubBrxzTreeResp> rooList = new ArrayList<>();
        for (PubBrxzTreeResp resp : data) {
            if (-1 == resp.getSjxz()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for(PubBrxzTreeResp resp : rooList){
            resp.setChildrenList(getChildren(resp.getBrxz(), data));
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
    private List<PubBrxzTreeResp> getChildren(int id, List<PubBrxzTreeResp> dataList){
        //子菜单
        List<PubBrxzTreeResp> childList = new ArrayList<>();
        for(PubBrxzTreeResp resp : dataList){
            // 判断是否为子节点
            if(resp.getSjxz().equals(id)){
                childList.add(resp);
            }
        }
        // 循环子子节点的子节点
        for(PubBrxzTreeResp resp : childList){
            resp.setChildrenList(getChildren(resp.getBrxz(), dataList));
        }
        // 递归退出条件
        if (childList.size() == 0){
            return null;
        }
        return childList;
    }

    /**
     * 自负比例-列表
     * @param brxz
     * @return
     */
    public List<DicSfxmlbZfblResp> queryBrxzZfbl(Integer brxz) {
        return dicSfxmlbSer.getEntityMapper().queryBrxzZfbl(brxz);
    }

    /**
     * 自付比例-编辑
     * @param req
     */
    public void zfblEdit(FeeSfdlzfblEditReq req) {
        FeeSfdlzfbl feeSfdlzfbl = BeanUtil.toBean(req, FeeSfdlzfbl.class);
        FeeSfdlzfbl exitFeeSfdlzfbl = feeSfdlzfblSer.getEntityMapper().getByBrxzAndSfxm(req.getBrxz(), req.getSfxm());
        if(Objects.isNull(exitFeeSfdlzfbl)){
            feeSfdlzfblSer.insert(feeSfdlzfbl);
        }else {
            feeSfdlzfblSer.update(feeSfdlzfbl);
        }
    }


    /**
     * 药品限制-列表
     * @param brxz
     * @return
     */
    public List<FeeYpxzYpxzResp> queryYpxzList(Integer brxz, String pydm) {
        return getFeeYpxzSer.getEntityMapper().queryYpxzList(brxz, pydm);
    }

    /**
     * 药品限制-药品输入法
     * @param pydm
     * @return
     */
//    public List<YpxzDicResp> queryYpDic(String pydm) {
//        return drugsTypkSer.getEntityMapper().queryBrxzYpDic(pydm);
//    }

    /**
     * 药品限制-新增
     * @param req
     */
    public void ypxzAdd(FeeYpxzAddReq req) {
        feeYpxzSer.add(req);
    }

    /**
     * 药品限制-编辑
     * @param req
     */
    public void ypxzEdit(FeeYpxzEditReq req) {
        feeYpxzSer.edit(req);
    }

    /**
     * 药品限制-删除
     * @param brxz
     * @param ypxh
     */
    public void ypxzDelete(int brxz, int ypxh) {
        feeYpxzSer.getEntityMapper().deleteById(brxz,ypxh);
    }

    /**
     * 费用限制列表
     * @param brxz
     * @return
     */
    public List<PubFyxzFyxzResp> queryFyxzList(Integer brxz,String pydm) {
        return pubFyxzSer.getEntityMapper().queryFyxzList(brxz, pydm);
    }


    /**
     * 费用限制-输入法
     * @param pydm
     * @return
     */
    public List<GyFyxzDicResp> queryBrxzDic(String pydm) {
        return feeYlsfxmSer.getEntityMapper().queryBrxzDic(pydm);
    }


    /**
     * 费用限制-新增
     * @param req
     */
    public void fyxzAdd(PubFyxzAddReq req) {
        pubFyxzSer.add(req);
    }

    /**
     * 费用限制-编辑
     * @param req
     */
    public void fyxzEdit(PubFyxzAddReq req) {
        pubFyxzSer.edit(req);
    }

    /**
     * 费用限制-删除
     * @param brxz
     * @param fyxh
     */
    public void fyxzDelete(Integer brxz, Integer fyxh) {
        pubFyxzSer.getEntityMapper().deleteById(brxz, fyxh);
    }





}
