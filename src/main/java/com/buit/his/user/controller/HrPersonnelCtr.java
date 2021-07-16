
package com.buit.his.user.controller;

import com.buit.commons.BaseException;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.his.dic.model.DicYljs;
import com.buit.his.dic.service.DicYljsSer;
import com.buit.his.user.model.HrPersonnel;
import com.buit.his.user.request.HrPersonnelValCardNumReq;
import com.buit.his.user.request.JkyxzPersonnel;
import com.buit.his.user.response.HrPersonnelKsResp;
import com.buit.his.user.response.MrmsDoctorResp;
import com.buit.his.user.service.HrPersonnelSer;
import com.buit.op.service.CaAuthenticationService;
import com.buit.system.response.HrPersonnelResp;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * 员工信息<br>
 *
 * @author 神算子
 */
@Api(tags = "员工信息")
@Controller
@RequestMapping("/hrpersonnel")
public class HrPersonnelCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(HrPersonnelCtr.class);

    @Autowired
    private HrPersonnelSer hrPersonnelSer;

    @Autowired
    private DicYljsSer dicYljsSer;
    @Value("${resource.url}")
    private String url;

    @DubboReference
    private CaAuthenticationService caAuthenticationService;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "按条件分页查询员工信息", httpMethod = "POST")
    public ReturnEntity<PageInfo<HrPersonnel>> queryPage(@ApiParam(name = "searchPharm", value = "查询条件") @RequestParam(value = "searchPharm", required = false) String searchPharm,
                                                         @ApiParam(name = "logoff", value = "停启用 字典:SYS_FLAG_DATA:FD000011") @RequestParam(value = "logoff", required = false) String logoff, PageQuery page) {
        HrPersonnel hrpersonnel = new HrPersonnel();
        if (logoff == null) {
            logoff = "0";
            hrpersonnel.setLogoff(logoff);
        }
        hrpersonnel.setPersonname(searchPharm);
        hrpersonnel.setOrganizcode(getUser().getHospitalId());
        hrpersonnel.setSortColumns("LASTMODIFYDATE DESC");
        PageInfo<HrPersonnel> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> hrPersonnelSer.findByEntity(hrpersonnel)
        );
        if (pageInfo.getList() != null) {
            for (HrPersonnel sysper : pageInfo.getList()) {
                if (StringUtils.isNotBlank(sysper.getYsqm())) {
                    sysper.setYsqm(url + sysper.getYsqm());
                }
                if (sysper.getLogoffoperater() != null) {
                    HrPersonnel que = hrPersonnelSer.getById(sysper.getLogoffoperater());
                    if (que != null) {
                        sysper.setLogoffoperaterName(que.getPersonname());
                    }
                }
            }
        }
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 检查工号
     */
    @RequestMapping("/check")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "检查工号", httpMethod = "POST", notes = "返回0不重复可用,大于0表示重复")
    public ReturnEntity<Long> check(@ApiParam(name = "rybh", value = "工号") @RequestParam String rybh) {
        HrPersonnel hrpersonnel = new HrPersonnel();
        hrpersonnel.setRybh(rybh);
        return ReturnEntityUtil.success(hrPersonnelSer.getEntityMapper().countRybh(hrpersonnel));
    }

    @RequestMapping("/getNologinInfo")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "取未设置登录账号名单", notes = "用户设置-新增-下拉员工列表 :取未设置登录账号的员工信息", httpMethod = "POST")
    public ReturnEntity<List<HrPersonnel>> getNologinInfo(@ApiParam(name = "quertStr", value = "quertStr", required = false) @RequestParam(required = false, name = "quertStr") String quertStr) {
        HrPersonnel que = new HrPersonnel();
        que.setOrganizcode(getUser().getHospitalId());
        que.setPersonname(quertStr);
        return ReturnEntityUtil.success(hrPersonnelSer.getEntityMapper().getLoginUser(que));
    }

    /**
     * 验证证件类型和证件号码唯一
     *
     * @param req
     * @return
     */
    @RequestMapping("/validCret")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "验证证件类型和证件号码唯一", notes = "1)新增时personid空 </br> 2)修改时personid不可为空 </br> 3)返回0不重复可用,大于0表示重复", httpMethod = "POST")
    public ReturnEntity<Integer> validCret(@Valid HrPersonnelValCardNumReq req) {
        req.setOrganizcode(getUser().getHospitalId());
        return ReturnEntityUtil.success(hrPersonnelSer.getEntityMapper().validCard(req));
    }


    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity<HrPersonnel> add(HrPersonnel hrPersonnel) {
        hrPersonnel.setOrganizcode(getUser().getHospitalId());
        hrPersonnelSer.add(hrPersonnel);
        return ReturnEntityUtil.success(hrPersonnel);
    }

    /**
     * 解锁
     */
    @RequestMapping("/unlock")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "解锁人员信息", httpMethod = "POST")
    public ReturnEntity<String> unlock(@ApiParam(name = "personid", value = "人员ID") @RequestParam Integer personid) {
        hrPersonnelSer.unlock(personid, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/lock")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "锁定人员信息", httpMethod = "POST")
    public ReturnEntity<String> lock(@ApiParam(name = "personid", value = "人员ID") @RequestParam Integer personid) {
        hrPersonnelSer.lock(personid, getUser());
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity<HrPersonnel> edit(HrPersonnel hrPersonnel) {
        hrPersonnelSer.edit(hrPersonnel);
        return ReturnEntityUtil.success(hrPersonnel);
    }

    /**
     * 编辑
     */
    @RequestMapping("/test")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "测试Json", httpMethod = "POST")
    public ReturnEntity<HrPersonnel> test(@RequestBody HrPersonnel hrPersonnel) {
        return ReturnEntityUtil.success(hrPersonnel);
    }

    /**
     * 查询医疗角色
     */
    @RequestMapping("/queryYljs")
    @ResponseBody
    @ApiOperation(value = "查询医疗角色", httpMethod = "POST")
    public ReturnEntity<List<DicYljs>> queryYljs() {
        return ReturnEntityUtil.success(dicYljsSer.queryYljsList());
    }

    /**
     * 查询人员科室信息
     */
    @RequestMapping("/queryRyKsInfo")
    @ResponseBody
    @ApiOperation(value = "查询人员科室信息", httpMethod = "POST")
    public ReturnEntity<HrPersonnelKsResp> queryRyKsInfo() {
        return ReturnEntityUtil.success(hrPersonnelSer.getEntityMapper().queryRyKsInfo(
                this.getUser().getUserId(), this.getUser().getHospitalId(), null).get(0));
    }

    /**
     * 医生分页查询
     *
     * @param req
     * @return
     */
    @RequestMapping("/doctor/queryPages")
    @ResponseBody
    @ApiOperationSupport(author = "Beijunhua")
    @ApiOperation(value = "左侧医生按条件分页查询s", httpMethod = "POST")
    public ReturnEntity<PageInfo<HrPersonnelResp>> queryPages(JkyxzPersonnel req) {
        SysUser user = getUser();
        PageInfo<HrPersonnelResp> pageInfo = hrPersonnelSer.getDocRecordss(req, user);
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/queryYqysByKs")
    @ResponseBody
    @ApiOperation(value = "根据拟邀会诊科室查询拟邀会诊医生", httpMethod = "POST")
    public ReturnEntity<List<HrPersonnel>> queryYqysByKs(@ApiParam(name = "nyqhzksList", value = "拟邀会诊科室", required = true)
                                                         @RequestParam List<Integer> nyqhzksList, @ApiParam(name = "pydm", value = "拼音代码", required = false)
                                                         @RequestParam(value = "pydm", required = false) String pydm) {
        return ReturnEntityUtil.success(hrPersonnelSer.getEntityMapper().queryYqysByKs(nyqhzksList, pydm));
    }

    @RequestMapping("/queryByCondition")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "查询员工信息(新)", httpMethod = "POST")
    public ReturnEntity<PageInfo<HrPersonnel>> queryByCondition(@ApiParam(name = "condition", value = "查询条件") @RequestParam(value = "condition", required = false) String condition,
                                                                PageQuery page) {
        PageInfo<HrPersonnel> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> hrPersonnelSer.getEntityMapper().queryByCondition(condition)
        );
        return ReturnEntityUtil.success(pageInfo);
    }


    /**
     * 通过手机号获取员工CA证书序列号
     */
    @RequestMapping("/cazsxlh")
    @ResponseBody
    @ApiOperationSupport(author = "tian")
    @ApiOperation(value = "通过手机号获取员工CA证书序列号", httpMethod = "POST")
    public ReturnEntity<String> getCazsxlh(@ApiParam(name = "phone", value = "手机号", required = true) @RequestParam(value = "phone") String phone) {
        String ca = null;
        try {
            ca = caAuthenticationService.getCazsxlhByMkeyUser(phone);
            if (Objects.isNull(ca)) {
                throw BaseException.create("ERROR_USER_0023");
            }
        } catch (BaseException e) {
            return ReturnEntityUtil.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return ReturnEntityUtil.error(e.getMessage());
        }
        return ReturnEntityUtil.success(ca);
    }

    @RequestMapping("/queryKfzls")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "查询康复治疗师", httpMethod = "POST")
    public ReturnEntity<PageInfo<HrPersonnelKsResp>> queryKfzls(@ApiParam(name = "condition", value = "查询条件") @RequestParam(value = "condition", required = false) String condition,
                                                                PageQuery page) {
        PageInfo<HrPersonnelKsResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> hrPersonnelSer.queryKfzls(getUser().getHospitalId(), condition));
        return ReturnEntityUtil.success(pageInfo);
    }


    @RequestMapping("/getDoctor")
    @ResponseBody
    @ApiOperation(value = "获取医生", httpMethod = "POST")
    public ReturnEntity<PageInfo<MrmsDoctorResp>> getDoctor(@ApiParam(name = "xm", value = "姓名") @RequestParam(value = "xm", required = false) String xm,
                                                            @ApiParam(name = "lb", value = "医生角色类别") @RequestParam(value = "lb", required = false) List<Integer> lb,
                                                            PageQuery page) {
        PageInfo<MrmsDoctorResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> hrPersonnelSer.getDoctor(xm, lb)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/getPersonMsg")
    @ResponseBody
    @ApiOperation(value = "获取医生详细信息", httpMethod = "POST")
    public ReturnEntity<HrPersonnel> getPersonMsg(@ApiParam(name = "personId", value = "personId") @RequestParam(value = "personId", required = true) String personId
    ) {
        HrPersonnel person = hrPersonnelSer.getPersonMsg(personId);
        return ReturnEntityUtil.success(person);
    }
}

