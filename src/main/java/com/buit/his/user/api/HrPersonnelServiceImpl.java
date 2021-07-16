package com.buit.his.user.api;

import java.util.ArrayList;
import java.util.List;

import com.buit.his.user.dao.HrPersonnelDao;
import com.buit.system.response.*;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.his.user.dao.SysUserDao;
import com.buit.his.user.model.HrPersonnel;
import com.buit.his.user.response.HrPersonnelKsResp;
import com.buit.his.user.service.HrPersonnelSer;
import com.buit.system.service.HrPersonnelService;
import com.buit.utill.BeanUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.crypto.digest.DigestAlgorithm;
import cn.hutool.crypto.digest.Digester;

/**
 * @author liushijie
 **/
@DubboService(timeout = 10000)
public class HrPersonnelServiceImpl implements HrPersonnelService {

    @Autowired
    private HrPersonnelSer hrPersonnelSer;
    @Autowired
	private SysUserDao sysUserDao;
	@Autowired
	private HrPersonnelDao hrPersonnelDao;
    /**
     * 查询员工信息
     * @param personId
     * @return
     */
    @Override
    public HrPersonnelModel getPersonnelById(Integer personId) {
        HrPersonnel per = hrPersonnelSer.getById(personId);
        HrPersonnelModel retObj = BeanUtil.toBean(per, HrPersonnelModel.class);
        return retObj;
    }
    /**
     * 比对用户的密码是否相符
     * @param personId
     * @return true:相符,false:不相符
     */
    @Override
    public boolean checkPassWd(Integer personId,String passwd){
    	SysUser sysUser =sysUserDao.getPwd(personId);
    	if(sysUser==null) {
    		return false;
    	}
    	Digester md5 = new Digester(DigestAlgorithm.MD5);
		md5.setSalt(sysUser.getLoginName().getBytes());
		String md5passwd = md5.digestHex(passwd);
		// 密码验证不通过
		if (!md5passwd.equals(sysUser.getUserPwd())) {
			return false;
		}
		return true;
    }
    /**
     * 比对用户的密码是否相符
     * @param opKspbPerson
     * @return true:相符,false:不相符
     */
	@Override
    public List<OpKspbPerson> getKspbList(OpKspbPerson opKspbPerson) {
		return hrPersonnelSer.getEntityMapper().getKspbList(opKspbPerson);
	}
    /**
     * 根据登录名取用户ID
     * @param longName 登录名
     * @return null 未找到用户
     */
	@Override
	public Integer getPersonId(String longName) {
		List<SysUser> queList = sysUserDao.loginQuery(longName);
		if (queList.size() > 0) {
			SysUser sysUser = queList.get(0);
			return sysUser.getUserId();
		}
		return null;
	}

	/**
     * 根据拟邀科室查询人员信息
     * @Title: queryYqysByKs
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param nyqhzksList
     * @param @return    设定文件
     * @return List<HrPersonnel>    返回类型
     * @author 龚方舟
     * @throws
     */
	@Override
	public List<HrPersonnelModel> queryYqysByKs(List<Integer> nyqhzksList, String pydm) {
		List<HrPersonnel> list = hrPersonnelSer.getEntityMapper().queryYqysByKs(nyqhzksList, pydm);
		List<HrPersonnelModel> resList = new ArrayList<HrPersonnelModel>();
		for(HrPersonnel hrPersonnel : list) {
			HrPersonnelModel model = BeanUtil.toBean(hrPersonnel, HrPersonnelModel.class);
			resList.add(model);
		}
		return resList;
	}

	@Override
	public List<HrPersonnelModel> queryById(List<Integer> ids) {
		return hrPersonnelDao.queryById(ids);
	}

	@Override
	public List<HrPersonnelModel> findByEntity(Object o) {
		return BeanUtil.toBeans(hrPersonnelSer.findByEntity(o),HrPersonnelModel.class) ;
	}

	@Override
	public List<HrPersonnelResp> queryLoginDoctor(Integer ksid) {
		return hrPersonnelSer.getEntityMapper().queryLoginDoctor(ksid);
	}

	@Override
	public PageInfo<HrPersonnelKsApiResp> queryRyKsInfoByPageInfo(Integer personid, Integer jgid,
			String pycode, PageQuery req) {
		PageInfo<HrPersonnelKsResp> pageInfo = PageHelper.startPage(
				req.getPageNum(), req.getPageSize()).doSelectPageInfo(
				() -> hrPersonnelSer.getEntityMapper().queryRyKsInfo(personid, jgid, pycode)
		);
		return BeanUtil.toPage(pageInfo, HrPersonnelKsApiResp.class);
	}

	@Override
	public List<DoctorDicResp> queryBySsdj(Integer ssdj, String pydm, Integer jgid) {

		return hrPersonnelDao.queryBySsdj(ssdj,pydm,jgid);
	}

	@Override
	public List<DoctorDicResp> queryCheckBySsdj(Integer ssdj, String pydm, Integer jgid) {
		return hrPersonnelDao.queryCheckBySsdj(ssdj,pydm,jgid);
	}

	@Override
	public List<SysUserByKjywResp> queryByKjyw(Integer jgid, String kjywdj) {
		return sysUserDao.queryByKjyw(jgid, kjywdj);
	}
	
	
	@Override
	public List<HrPersonnelModel> querySuperiorDoctor(List<String> userIdList, Integer officeCode,
			Integer medicalRoles) {
		return hrPersonnelDao.querySuperiorDoctor(userIdList, officeCode, medicalRoles);
	}

}

