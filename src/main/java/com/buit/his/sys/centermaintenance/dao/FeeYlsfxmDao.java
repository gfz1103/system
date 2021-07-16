package com.buit.his.sys.centermaintenance.dao;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.buit.his.sys.centermaintenance.response.*;
import com.buit.system.response.SsInputResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.buit.commons.EntityDao;
import com.buit.his.sys.centermaintenance.model.FeeYlsfxm;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlReq;
import com.buit.system.request.FeeYlsfxmProjectSrfApiReq;
import com.buit.system.request.FeeYlsfxmProjectSrfReq;
import com.buit.system.response.FeeYlsfxmOutResp;
import com.buit.system.response.FeeYlsfxmProjectSrfApiResp;
import com.buit.system.response.FeeYlsfxmProjectSrfResp;
import com.buit.system.response.GyYlxmDicResp;
import com.buit.system.response.IFeeYlsfxm;
import com.buit.system.response.YjQueryPageHelperResp;


/**
 * 公用_医疗收费<br>
 *
 * @author 老花生
 */
@Mapper
public interface FeeYlsfxmDao extends EntityDao<FeeYlsfxm, Integer> {

    /**
     * 查询费用归并、费用序号、费用单价
     *
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFygbFyxhFydj(Map<String, Object> parameters);

    /**
     * 查询费用序号、费用名称、作废判别、医保编码
     *
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getFyxhFymcZfpbYbbm(Map<String, Object> parameters);

    /**
     * 查询保险费用
     *
     * @param parameters
     * @return
     */
    List<Map<String, Object>> getBxfy(Map<String, Object> parameters);

    /**
     * 查询保险信息
     *
     * @param param
     * @return
     */
    Map<String, Object> getBxInfo(Map<String, Object> param);

    /**
     * 根据fyxh查询
     *
     * @param ypxhList
     * @return
     */
    List<FeeYlsfxmOutResp> queryByFyxh(@Param("list") List<Integer> ypxhList);
    /**
     * 根据不同病人性质查询
     *
     * @param parameters
     * @return
     */
    public List<Map<String, Object>> getYlsfInfoBybrxzOne(Map<String, Object> parameters);

    /**
     * 根据不同病人性质查询
     *
     * @param parameters
     * @return
     */
    public List<Map<String, Object>> getYlsfInfoBybrxzTwo(Map<String, Object> parameters);


    /**
     * 查询住院全部项目
     *
     * @param @param  jgid
     * @param @return 设定文件
     * @return List<FeeYlsfxmAllResp>    返回类型
     * @throws
     * @Title: queryInpatientProjectAll
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    List<FeeYlsfxmAllResp> queryInpatientProjectAll(@Param("jgid") Integer jgid, @Param("pydm") String pydm);



    /**
     * 医技全部查询（助手方式）
     *
     * @param map
     */
    List<YjQueryPageHelperResp> queryPageHelper(HashMap<Object, Object> map);


    /**
     * 收费项目明细是否作废
     *
     * @param @param zfpb
     * @param @param fyxh    设定文件
     * @return void    返回类型
     * @throws
     * @Title: updateZfpbByFyxh
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    void updateZfpbByFyxh(@Param("zfpb") Integer zfpb, @Param("fyxh") Integer fyxh);

    /**
     * 查询手术项目
     *
     * @param @param  feeYlsfxmYlReq
     * @param @return 设定文件
     * @return List<FeeYlsfxmResp>    返回类型
     * @throws
     * @Title: querySurgicalItems
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    List<FeeYlsfxmResp> querySurgicalItems(FeeYlsfxmYlReq feeYlsfxmYlReq);

    /**
     * 需调入收费项目明细列表
     *
     * @param @param  parameters
     * @param @return 设定文件
     * @return List<FeeYlsfxm>    返回类型
     * @throws
     * @Title: queryInstitutionalDetails
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    List<FeeYlsfxm> queryInstitutionalDetails(Map<String, Object> parameters);

    /**
     * 中心维护-查询费用列表
     * @param jgid 机构代码
     * @param pydm 拼音代码
     * @return
     */
    List<FeeYlsfxmResp> queryList(@Param("jgid") int jgid, @Param("pydm") String pydm);

    /**
     * 中心维护-附加项目字典查询
     * @param jgid 机构代码
     * @param pydm 拼音代码
     * @return
     */
    List<GyYlxmDicResp> queryXmDicList(@Param("jgid") int jgid, @Param("pydm") String pydm);

    /**
     * 中心维护-病人性质维护-费用限制-输入法字典
     * @param pydm
     * @return
     */
    List<GyFyxzDicResp> queryBrxzDic(@Param("pydm") String pydm);
    /**
     * @name: allInfoNoUser
     * @description: 查询全部手术信息刨除用户选择
     * @param pydm
     * @return: void
     * @date: 2020/8/13 20:06
     * @auther: 老花生
     *
     */
    List<IFeeYlsfxm> allInfoNoUser(@Param("pydm") String pydm);

    /**
     * 查询治疗项目的费用列表
     * @param jgid
     * @return
     */
    List<GyYlxmDicResp> queryZlFeeYlsfxm(@Param("jgid") int jgid);

    /**
     * 查询治疗收费项目输入法
     * @param jgid
     * @param pydm
     * @return
     */
    List<GyYlxmDicResp> queryZlxmDicList(@Param("jgid") int jgid, @Param("pydm") String pydm);
    
    /**
     * 查询项目商保价格等
     * @Title: queryXmSbjg
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param fyxh
     * @param @return    设定文件
     * @return Map<String,Object>    返回类型
     * @author 龚方舟
     * @throws
     */
    Map<String, Object> queryXmSbjg(Integer fyxh);
    
    /**
     * 查询备血申请项目
     * @Title: queryBxxm
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param fygb
     * @param @param jgid
     * @param @param pydm
     * @param @return    设定文件
     * @return List<FeeYlsfxmBxResp>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<FeeYlsfxmBxResp> queryBxxm(@Param("fygb") Integer fygb, @Param("jgid") Integer jgid,
    		@Param("pydm") String pydm);
    
    /**
     * 病区医嘱项目输入法(包含中文搜索)
     * @param @param  feeYlsfxmProjectSrfApiReq
     * @param @return 设定文件
     * @return List<feeYlsfxmProjectSrfApiReq>    返回类型
     * @throws
     * @Title: queryProjectOrder
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    List<FeeYlsfxmProjectSrfApiResp> queryProjectOrder(FeeYlsfxmProjectSrfApiReq feeYlsfxmProjectSrfApiReq);

    /**
     * 查询费用记账项目输入法
     * @param @param  FeeYlsfxmProjectSrfReq
     * @param @return 设定文件
     * @return List<FeeYlsfxmProjectSrfResp>    返回类型
     * @throws
     * @Title: queryExpenseAccounting
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @author 龚方舟
     */
    List<FeeYlsfxmProjectSrfResp> queryExpenseAccounting(FeeYlsfxmProjectSrfReq feeYlsfxmProjectSrfReq);

    /**
     * 手麻卫材收费项目输入法
     * @param jgid
     * @param pydm
     * @return
     */
    List<SsInputResp> querySsInputMaterial(@Param("jgid") Integer  jgid, @Param("pydm") String pydm);

    /**
     * 手麻手术项目收费输入法
     * @param jgid
     * @param pydm
     * @return
     */
    List<SsInputResp> querySsInputItem(@Param("jgid") Integer  jgid, @Param("pydm") String pydm);

    /**
     * 项目调价输入法
     * @Title: queryModifyPricecFeeYlsfxm
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param parameters
     * @param @return    设定文件
     * @return List<FeeYlsfxmPriceSrfResp>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<FeeYlsfxmPriceSrfResp> queryModifyPricecFeeYlsfxm(Map<String, Object> parameters);

    /**
     * 联表查询费用明细
     * */
    List<FeeYlsfxmOutResp> queryInnerDjByFyxh(@Param("jgid") Integer jgid, @Param("list") List<Integer> fyxhList);
    

    /**
     * 查询床位费用字典
     * @Title: queryCwszFyDic
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @param @param jgid
     * @param @param pydm
     * @param @return    设定文件
     * @return List<FeeYlsfxmOutResp>    返回类型
     * @author 龚方舟
     * @throws
     */
    List<FeeYlsfxmOutResp> queryCwszFyDic(@Param("jgid") Integer jgid, @Param("pydm") String pydm);
}
