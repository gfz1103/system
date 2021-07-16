package com.buit.his.sys.centermaintenance.service;


import java.util.ArrayList;
import java.util.List;

import com.buit.his.sys.centermaintenance.response.PageLogoResp;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.constans.TableName;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.dao.DicYljgDao;
import com.buit.his.sys.centermaintenance.model.DicYljg;
import com.buit.his.sys.centermaintenance.request.DicYljgAddReq;
import com.buit.his.sys.centermaintenance.request.DicYljgEditReq;
import com.buit.his.sys.centermaintenance.response.DicYljgResp;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.DateUtil;
import com.buit.utill.RedisFactory;

/**
 * 医疗卫生机构索引表<br>
 *
 * @author liushijie
 */
@Service
public class DicYljgSer extends BaseManagerImp<DicYljg, Integer> {

    static final Logger logger = LoggerFactory.getLogger(DicYljgSer.class);

    @Autowired
    private DicYljgDao dicYljgDao;

    @Autowired
    private RedisFactory redisFactory;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @Override
    public DicYljgDao getEntityMapper() {
        return dicYljgDao;
    }
    @Value("${resource.url}")
    private String url;
    /**
     * 新增
     *
     * @param req
     */
    public void add(DicYljgAddReq req) {
        DicYljg conditon = null;
        // 校验医疗机构代码(医保)
        if (StringUtils.isNotBlank(req.getHospitalCode())) {
            conditon = new DicYljg();
            conditon.setHospitalCode(req.getHospitalCode());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0001");
            }
        }
        // 医疗机构组织机构代码
        if (StringUtils.isNotBlank(req.getOrganizationCode())) {
            conditon = new DicYljg();
            conditon.setOrganizationCode(req.getOrganizationCode());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0002");
            }
        }
        // 校验医疗机构名称
        if (StringUtils.isNotBlank(req.getHospitalName())) {
            conditon = new DicYljg();
            conditon.setHospitalName(req.getHospitalName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0003");
            }
        }
        // 校验第二医疗机构名称
        if (StringUtils.isNotBlank(req.getSecondHospitalName())) {
            conditon = new DicYljg();
            conditon.setSecondHospitalName(req.getSecondHospitalName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0004");
            }
        }
        // 校验医院医保全称
        if (StringUtils.isNotBlank(req.getAffiliatedName())) {
            conditon = new DicYljg();
            conditon.setAffiliatedName(req.getAffiliatedName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0005");
            }
        }
        // 校验医院简称
        if (StringUtils.isNotBlank(req.getSecondName())) {
            conditon = new DicYljg();
            conditon.setSecondName(req.getSecondName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0006");
            }
        }
        int hospitalId = redisFactory.getTableKey(TableName.DB_NAME, TableName.DIC_YLJG);
        DicYljg dicYljg = BeanUtil.toBean(req, DicYljg.class);
        dicYljg.setHospitalId(hospitalId);
        dicYljg.setGmtCreate(DateUtil.getCurrentTimestamp());
        dicYljg.setGmtModify(DateUtil.getCurrentTimestamp());

        String logo = dicYljg.getLogo();
        String pageLogo1 = dicYljg.getPageLogo1();
        String pageLogo2 = dicYljg.getPageLogo2();
        String pageLogo3 = dicYljg.getPageLogo3();
        String pageLogo4 = dicYljg.getPageLogo4();
        String pageLogo5 = dicYljg.getPageLogo5();

        if (logo != null&&logo.contains("/image")) {
            String[] images = logo.split("image");
            logo="/image"+images[1];
            dicYljg.setLogo(logo);
        }
        if (pageLogo1 != null&&pageLogo1.contains("/image")) {
            String[] images = pageLogo1.split("image");
            pageLogo1="/image"+images[1];
            dicYljg.setPageLogo1(pageLogo1);
        }
        if (pageLogo2 != null&&pageLogo2.contains("/image")) {
            String[] images = pageLogo2.split("image");
            pageLogo2="/image"+images[1];
            dicYljg.setPageLogo2(pageLogo2);
        }
        if (pageLogo3 != null&&pageLogo3.contains("/image")) {
            String[] images = pageLogo3.split("image");
            pageLogo3="/image"+images[1];
            dicYljg.setPageLogo3(pageLogo3);
        }
        if (pageLogo4 != null&&pageLogo4.contains("/image")) {
            String[] images = pageLogo4.split("image");
            pageLogo4="/image"+images[1];
            dicYljg.setPageLogo4(pageLogo4);
        }
        if (pageLogo5 != null&&pageLogo5.contains("/image")) {
            String[] images = pageLogo5.split("image");
            pageLogo5="/image"+images[1];
            dicYljg.setPageLogo5(pageLogo5);
        }

        dicYljgDao.insert(dicYljg);
        sysDictConfigSer.upDateVersion("dic_yljg");
    }

    /**
     * 修改
     *
     * @param req
     */
    public void edit(DicYljgEditReq req) {
        DicYljg conditon = null;
        // 校验医疗机构代码(医保)
        if (StringUtils.isNotBlank(req.getHospitalCode())) {
            conditon = new DicYljg();
            conditon.setHospitalCode(req.getHospitalCode());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                DicYljg dicYljg = dataList.get(0);
                if (!dicYljg.getHospitalId().equals(req.getHospitalId())) {
                    throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0001");
                }
            }
        }
        // 医疗机构组织机构代码
        if (StringUtils.isNotBlank(req.getOrganizationCode())) {
            conditon = new DicYljg();
            conditon.setOrganizationCode(req.getOrganizationCode());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                DicYljg dicYljg = dataList.get(0);
                if (!dicYljg.getHospitalId().equals(req.getHospitalId())) {
                    throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0002");
                }
            }
        }
        // 校验医疗机构名称
        if (StringUtils.isNotBlank(req.getHospitalName())) {
            conditon = new DicYljg();
            conditon.setHospitalName(req.getHospitalName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                DicYljg dicYljg = dataList.get(0);
                if (!dicYljg.getHospitalId().equals(req.getHospitalId())) {
                    throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0003");
                }
            }
        }
        // 校验第二医疗机构名称
        if (StringUtils.isNotBlank(req.getSecondHospitalName())) {
            conditon = new DicYljg();
            conditon.setSecondHospitalName(req.getSecondHospitalName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                DicYljg dicYljg = dataList.get(0);
                if (!dicYljg.getHospitalId().equals(req.getHospitalId())) {
                    throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0004");
                }
            }
        }
        // 校验医院医保全称
        if (StringUtils.isNotBlank(req.getAffiliatedName())) {
            conditon = new DicYljg();
            conditon.setAffiliatedName(req.getAffiliatedName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                DicYljg dicYljg = dataList.get(0);
                if (!dicYljg.getHospitalId().equals(req.getHospitalId())) {
                    throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0005");
                }
            }
        }
        // 校验医院简称
        if (StringUtils.isNotBlank(req.getSecondName())) {
            conditon = new DicYljg();
            conditon.setSecondName(req.getSecondName());
            List<DicYljg> dataList = dicYljgDao.findByEntity(conditon);
            if (dataList.size() > 0) {
                DicYljg dicYljg = dataList.get(0);
                if (!dicYljg.getHospitalId().equals(req.getHospitalId())) {
                    throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0006");
                }
            }
        }
        DicYljg dicYljg = BeanUtil.toBean(req, DicYljg.class);
        dicYljg.setGmtModify(DateUtil.getCurrentTimestamp());
        String logo = dicYljg.getLogo();
        String pageLogo1 = dicYljg.getPageLogo1();
        String pageLogo2 = dicYljg.getPageLogo2();
        String pageLogo3 = dicYljg.getPageLogo3();
        String pageLogo4 = dicYljg.getPageLogo4();
        String pageLogo5 = dicYljg.getPageLogo5();

        if (logo != null&&logo.contains("/image")) {
            String[] images = logo.split("image");
            logo="/image"+images[1];
            dicYljg.setLogo(logo);
        }
        if (pageLogo1 != null&&pageLogo1.contains("/image")) {
            String[] images = pageLogo1.split("image");
            pageLogo1="/image"+images[1];
            dicYljg.setPageLogo1(pageLogo1);
        }
        if (pageLogo2 != null&&pageLogo2.contains("/image")) {
            String[] images = pageLogo2.split("image");
            pageLogo2="/image"+images[1];
            dicYljg.setPageLogo2(pageLogo2);
        }
        if (pageLogo3 != null&&pageLogo3.contains("/image")) {
            String[] images = pageLogo3.split("image");
            pageLogo3="/image"+images[1];
            dicYljg.setPageLogo3(pageLogo3);
        }
        if (pageLogo4 != null&&pageLogo4.contains("/image")) {
            String[] images = pageLogo4.split("image");
            pageLogo4="/image"+images[1];
            dicYljg.setPageLogo4(pageLogo4);
        }
        if (pageLogo5 != null&&pageLogo5.contains("/image")) {
            String[] images = pageLogo5.split("image");
            pageLogo5="/image"+images[1];
            dicYljg.setPageLogo5(pageLogo5);
        }

        dicYljgDao.update(dicYljg);
        sysDictConfigSer.upDateVersion("dic_yljg");
    }


    /**
     * 查询机构集合, 返回树集合
     *
     * @return
     */
    public List<DicYljgResp> queryList(String pyCode) {
        List<DicYljgResp> data = dicYljgDao.queryList(pyCode);
        List<DicYljgResp> rooList = new ArrayList<>();
        for (DicYljgResp resp : data) {
            resp.setLogo(url+resp.getLogo());
            resp.setPageLogo1(url+resp.getPageLogo1());
            resp.setPageLogo2(url+resp.getPageLogo2());
            resp.setPageLogo3(url+resp.getPageLogo3());
            resp.setPageLogo4(url+resp.getPageLogo4());
            resp.setPageLogo5(url+resp.getPageLogo5());
            if (0 == resp.getParentHospitalId()) {
                rooList.add(resp);
            }
        }
        // 递归添加子集
        for (DicYljgResp resp : rooList) {
            resp.setChildrenList(getChildren(resp.getHospitalId(), data));
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
    private List<DicYljgResp> getChildren(int id, List<DicYljgResp> dataList) {
        //子菜单
        List<DicYljgResp> childList = new ArrayList<>();
        for (DicYljgResp resp : dataList) {
            // 判断是否为子节点
            if (resp.getParentHospitalId().equals(id)) {
                childList.add(resp);
            }
        }
        // 循环子子节点的子节点
        for (DicYljgResp resp : childList) {
            resp.setChildrenList(getChildren(resp.getHospitalId(), dataList));
        }
        // 递归退出条件
        if (childList.size() == 0) {
            List<DicYljgResp> retChildList = new ArrayList<>();
            return retChildList;
        }
        return childList;
    }

    /**
     * 机构停用
     *
     * @param hospitalId
     */
    public void stop(Integer hospitalId) {
        // 如果机构有下级且未停用，不允许停用
        DicYljg condition = new DicYljg();
        condition.setParentHospitalId(hospitalId);
        condition.setStopFlag("0");
        List<DicYljg> dataList = findByEntity(condition);
        if (dataList.size() > 0) {
            throw BaseException.create("ERROR_CENTERMAINTENANCE_DIC_YLJG_0007");
        }
        DicYljg updateYljg = new DicYljg();
        updateYljg.setHospitalId(hospitalId);
        updateYljg.setEndDate(DateUtil.getCurrentTimestamp());
        dicYljgDao.stopYljg(updateYljg);
        sysDictConfigSer.upDateVersion("dic_yljg");
    }

    public String logo(Integer hospitalId) {
        DicYljg byId = dicYljgDao.getById(hospitalId);
        return byId == null ? "" : url+byId.getLogo();
    }

    public PageLogoResp pageLogo(Integer hospitalId) {
        DicYljg byId = dicYljgDao.getById(hospitalId);
        PageLogoResp pageLogoResp =new PageLogoResp();
        if (byId != null) {
            String pageLogo1 = byId.getPageLogo1();
            if (pageLogo1 != null&&pageLogo1.contains("/image")) {
                pageLogoResp.setPageLogo1(url + pageLogo1);
            }
            String pageLogo2= byId.getPageLogo2();
            if (pageLogo2 != null&&pageLogo2.contains("/image")) {
                pageLogoResp.setPageLogo2(url + pageLogo2);
            }
            String pageLogo3 = byId.getPageLogo3();
            if (pageLogo3 != null&&pageLogo3.contains("/image")) {
                pageLogoResp.setPageLogo3(url + pageLogo3);
            }
            String pageLogo4 = byId.getPageLogo4();
            if (pageLogo4 != null&&pageLogo4.contains("/image")) {
                pageLogoResp.setPageLogo4(url + pageLogo4);
            }
            String pageLogo5 = byId.getPageLogo5();
            if (pageLogo5 != null&&pageLogo5.contains("/image")) {
                pageLogoResp.setPageLogo5(url + pageLogo5);
            }
        }
        return pageLogoResp;
    }
}
