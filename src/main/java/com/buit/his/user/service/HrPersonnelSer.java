package com.buit.his.user.service;


import cn.hutool.core.date.DateUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseManagerImp;
import com.buit.commons.SysUser;
import com.buit.constans.TableName;
import com.buit.his.user.dao.HrPersonnelDao;
import com.buit.his.user.dao.SysUserDao;
import com.buit.his.user.model.HrPersonnel;
import com.buit.his.user.request.JkyxzPersonnel;
import com.buit.his.user.response.HrPersonnelKsResp;
import com.buit.his.user.response.MrmsDoctorResp;
import com.buit.op.request.MkeyUserReq;
import com.buit.op.service.CaAuthenticationService;
import com.buit.system.response.HrPersonnelResp;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.RedisFactory;
import com.buit.utill.WubiUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 员工信息<br>
 *
 * @author 神算子
 */
@Service
public class HrPersonnelSer extends BaseManagerImp<HrPersonnel, Integer> {

    static final Logger logger = LoggerFactory.getLogger(HrPersonnelSer.class);

    @Autowired
    private HrPersonnelDao hrPersonnelDao;
    @Autowired
    private SysUserDao sysUserDao;
    @Autowired
    private RedisFactory redisFactory;
    @DubboReference
    private CaAuthenticationService caAuthenticationService;

    @Override
    public HrPersonnelDao getEntityMapper() {
        return hrPersonnelDao;
    }

    /**
     * 插入数据
     */
    public void add(HrPersonnel hrPersonnel) {
        hrPersonnel.setWbcode(WubiUtils.getSimpleWuBi(hrPersonnel.getPersonname()));
        hrPersonnel.setPycode(PinyinUtils.getSimplePinYin(hrPersonnel.getPersonname()));
//    	hrPersonnel.setPersonid(redisFactory.getTableKey(TableName.DB_NAME, TableName.HR_PERSONNEL));
        hrPersonnel.setGmtCreate(DateUtil.date().toTimestamp());
        hrPersonnel.setLastmodifydate(DateUtil.date().toTimestamp());
        getEntityMapper().insert(hrPersonnel);
        //保存CA证书信息
        saveOrUpdateCaInfo(hrPersonnel);
    }

    /**
     * 编辑数据
     */
    @Transactional(rollbackFor = Exception.class)
    public void edit(HrPersonnel hrPersonnel) {
        //判断工号是否重复
        if (hrPersonnelDao.countRybh(hrPersonnel) > 0) {
            throw BaseException.create("ERROR_USER_0020");
        }
        hrPersonnel.setWbcode(WubiUtils.getSimpleWuBi(hrPersonnel.getPersonname()));
        hrPersonnel.setPycode(PinyinUtils.getSimplePinYin(hrPersonnel.getPersonname()));
        hrPersonnel.setLastmodifydate(DateUtil.date().toTimestamp());
        String ysqm = hrPersonnel.getYsqm();
        if (ysqm != null&&ysqm.contains("/image")) {
            String[] images = ysqm.split("image");
            ysqm="/image"+images[1];
            hrPersonnel.setYsqm(ysqm);
        }
        hrPersonnelDao.update(hrPersonnel);
        //同步信息
        SysUser user = new SysUser();
        user.setPersonId(hrPersonnel.getPersonid());
        user.setUserName(hrPersonnel.getPersonname());
        user.setDeptId(hrPersonnel.getOfficecode());
        user.setGmtModify(DateUtil.date().toTimestamp());
        sysUserDao.updateInfo(user);
        //更新CA证书信息
        saveOrUpdateCaInfo(hrPersonnel);
    }

    /**
     * 根据人员ID解锁
     *
     * @param personId 人员ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void unlock(Integer personId, SysUser sysUser) {
        HrPersonnel hrPersonnel = new HrPersonnel();
        hrPersonnel.setPersonid(personId);
        hrPersonnel.setRecoveroperater(sysUser.getUserId());
        hrPersonnel.setRecovertime(DateUtil.date().toTimestamp());
        getEntityMapper().unlock(hrPersonnel);
        //操作用户表锁定
        sysUserDao.unlockUser(personId);
    }

    /**
     * 根据人员ID锁定
     *
     * @param personId 人员ID
     */
    @Transactional(rollbackFor = Exception.class)
    public void lock(Integer personId, SysUser sysUser) {
        HrPersonnel hrPersonnel = new HrPersonnel();
        hrPersonnel.setPersonid(personId);
        hrPersonnel.setLogoffoperater(sysUser.getUserId());
        hrPersonnel.setLogofftime(DateUtil.date().toTimestamp());
        getEntityMapper().lock(hrPersonnel);
        //操作用户表解锁
        sysUserDao.lockUser(personId);
    }

    /**
     * 查询医生信息
     *
     * @param @param  zyh
     * @param @return 设定文件
     * @return List<HrPersonnelResp>    返回类型
     * @throws
     * @Title: querytyRecords
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 卑军华
     */

    public PageInfo<HrPersonnelResp> getDocRecordss(JkyxzPersonnel req, SysUser user) {
        Integer jgid = user.getHospitalId();
        req.setOrganizcode(jgid);
        JkyxzPersonnel JkyxzPersonnel = BeanUtil.toBean(req, JkyxzPersonnel.class);
        PageInfo<JkyxzPersonnel> pageInfo = PageHelper.startPage(
                req.getPageNum(), req.getPageSize()).doSelectPageInfo(
                () -> hrPersonnelDao.getDocRecordss(JkyxzPersonnel)
        );
        return BeanUtil.toPage(pageInfo, HrPersonnelResp.class);
    }

    private void saveOrUpdateCaInfo(HrPersonnel hrPersonnel) {
        //保存CA证书信息
        if (hrPersonnel.getInternet() && Objects.nonNull(hrPersonnel.getCazsxlh())) {
            MkeyUserReq mkeyUserReq = new MkeyUserReq();
            mkeyUserReq.setMkeyUserId(hrPersonnel.getMobile());
            mkeyUserReq.setCaZsxlh(hrPersonnel.getCazsxlh());
            mkeyUserReq.setSysUserId(hrPersonnel.getPersonid());
            caAuthenticationService.saveMkeyUser(mkeyUserReq);
        }
    }

    /**
     * 查询康复治疗师
     *
     * @param jgid 机构id
     * @param pydm 拼音代码
     * @return
     */
    public List<HrPersonnelKsResp> queryKfzls(Integer jgid, String pydm) {
        return hrPersonnelDao.queryKfzls(jgid, pydm);
    }

    /**
     * 获取医生列表
     *
     * @param xm
     * @return
     */
    public List<MrmsDoctorResp> getDoctor(String xm, List<Integer> lb) {
        return hrPersonnelDao.getDoctor(xm, lb);
    }

    public HrPersonnel getPersonMsg(String personId) {
        if (personId == null || personId.equals("")) {
            return null;
        }
        return hrPersonnelDao.getById(Integer.valueOf(personId));
    }
}
