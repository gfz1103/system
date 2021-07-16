package com.buit.his.user.dao;

import com.buit.commons.EntityDao;
import com.buit.his.user.model.HrPersonnel;
import com.buit.his.user.request.HrPersonnelValCardNumReq;
import com.buit.his.user.request.JkyxzPersonnel;
import com.buit.his.user.response.HrPersonnelKsResp;
import com.buit.his.user.response.MrmsDoctorResp;
import com.buit.system.response.DoctorDicResp;
import com.buit.system.response.HrPersonnelModel;
import com.buit.system.response.HrPersonnelResp;
import com.buit.system.response.OpKspbPerson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * 员工信息<br>
 * @author 神算子
 */
@Mapper
public interface HrPersonnelDao extends EntityDao<HrPersonnel,Integer>{
	/**
     * 根据人员ID解锁
     * @param personId  人员ID
     */
	public void unlock(HrPersonnel hrPersonnel);
	/**
     * 根据人员ID解定
     * @param personId  人员ID
     */
	public void lock(HrPersonnel hrPersonnel);
	/**
     * 查询人员编号是否重复
     * @param personId  人员ID
     */
	public long countRybh(HrPersonnel hrPersonnel);
	/**
     * 查询人员证件编号是否重复
     * @param personId  人员ID
     */
	public Integer validCard(HrPersonnelValCardNumReq req);
	/**
	 * 取所有 没有设置登录用户的 员工
	 * @param ehrServicePersonal	查询信息
	 * @return
	 */
	public List<HrPersonnel> getLoginUser(HrPersonnel hrPersonnel);

	/**
	 * 获取机构代码
	 * @param put
	 * @return
	 */
//    Map<String, Object> getYgdm(String put);


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
    List<HrPersonnel> queryYqysByKs(@Param("nyqhzksList") List<Integer> nyqhzksList, @Param("pydm") String pydm);

	/**
	 * 当日科室排班信息
	 *
	 * @param opKspbPerson
	 * @return
	 */
	public List<OpKspbPerson> getKspbList(OpKspbPerson opKspbPerson);
	   /**
     * 根据拟邀科室查询人员信息
     * @Title: queryRyKsInfo
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param personid
     * @param @param jgid
     * @param @return    设定文件
     * @return HrPersonnelKsResp    返回类型
     * @author 龚方舟
     * @throws
     */
    List<HrPersonnelKsResp> queryRyKsInfo(@Param("personid") Integer personid, @Param("jgid") Integer jgid,
    		 @Param("pycode") String pycode);

    List<HrPersonnelResp> getDocRecordss(JkyxzPersonnel sys);

	/**
	 * @name: queryLoginDoctor
	 * @description: 查询当前在线医生
	 * @param ksid
	 * @return: java.util.List<com.buit.his.drugstock.response.HrPersonnelResp>
	 * @date: 2020/9/15 19:16
	 * @auther: 朱智
	 *
	 */
	List<HrPersonnelResp> queryLoginDoctor(Integer ksid);

	/**
	 * 查询拥有手术权限的医生
	 * */
    List<DoctorDicResp> queryBySsdj(@Param("ssdj") Integer ssdj,@Param("pydm")  String pydm, @Param("jgid") Integer jgid);

	List<DoctorDicResp> queryCheckBySsdj(@Param("ssdj") Integer ssdj, @Param("pydm") String pydm, @Param("jgid") Integer jgid);

    List<HrPersonnelModel> queryById(@Param("list") List<Integer> ids);

	/**
	 * 搜索查询医生信息
	 * @param condition
	 * @return
	 */
	List<HrPersonnel> queryByCondition(@Param("condition") String condition);

	/**
	 * 查询康复治疗师
	 * @param jgid 机构id
	 * @param condition 拼音代码
	 * @return
	 */
    List<HrPersonnelKsResp> queryKfzls(@Param("jgid")Integer jgid,@Param("condition") String condition);

	/**
	 * 获取医生
	 * @param xm
	 * @return
	 */
	List<MrmsDoctorResp> getDoctor(@Param("xm") String xm, @Param("lb")List<Integer> lb);
	

    /**
     * 查询同科室上级医生
     * @Title: querySuperiorDoctor
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param userIdList
     * @param @param officeCode
     * @param @param medicalRoles
     * @param @return    设定文件
     * @return List<HrPersonnelModel>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<HrPersonnelModel> querySuperiorDoctor(@Param("userIdList") List<String> userIdList, 
    		@Param("officeCode") Integer officeCode, @Param("medicalRoles") Integer medicalRoles);
}
