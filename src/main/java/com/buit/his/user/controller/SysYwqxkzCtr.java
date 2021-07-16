
package com.buit.his.user.controller;

import java.util.List;

import javax.validation.Valid;

import com.buit.his.user.request.SysYwqxkzDetailReq;
import com.buit.his.user.response.SysYwqxkzDetailResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.user.request.SysYwqxkzEditReq;
import com.buit.his.user.service.SysYwqxkzSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公用_公用权限控制<br>
 * @author MLeo
 */
@Api(tags="公用权限控制")
@Controller
@RequestMapping("/sysywqxkz")
public class SysYwqxkzCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysYwqxkzCtr.class);
    
    @Autowired
    private SysYwqxkzSer sysYwqxkzSer;

    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "文光临")
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<String> edit(@Valid @RequestBody SysYwqxkzEditReq req)  {
    	req.setJgid(getUser().getHospitalId());
    	req.setMrbz(0);
        sysYwqxkzSer.edit(req);
        return ReturnEntityUtil.success();
    }
    /** 查询人员已有权限 */
    @RequestMapping("/findqx")
    @ResponseBody
    @ApiOperationSupport(author = "文光临")
    @ApiOperation(value="查询人员已有权限" ,httpMethod="POST")
    public ReturnEntity<List<SysYwqxkzDetailResp>> findqx(@ApiParam(name = "btId", value = "业务类型ID") @RequestParam(value = "btId")  Integer btId,
                                                          @ApiParam(name = "personid", value = "人员ID") @RequestParam(value = "personid") Integer personid)  {
    	return ReturnEntityUtil.success(sysYwqxkzSer.getEntityMapper().findqx(personid, btId));
    }


    /** 查询人员已有权限 */
    @RequestMapping("/getWriteAuthority")
    @ResponseBody
    @ApiOperationSupport(author = "tian")
    @ApiOperation(value="查询人员病区可写权限" ,httpMethod="POST")
    public ReturnEntity<Boolean> getWriteAuthority(
            @ApiParam(name = "ygdm", value = "员工代码") @RequestParam(value = "ygdm")  Integer ygdm,
            @ApiParam(name = "ksdm", value = "科室代码") @RequestParam(value = "ksdm") Integer ksdm,
            @ApiParam(name = "bqdm", value = "病区代码") @RequestParam(value = "bqdm") Integer bqdm)  {
        return ReturnEntityUtil.success(
                sysYwqxkzSer.getEntityMapper().getWriteAuthority(ygdm, ksdm, bqdm, getUser().getHospitalId()) == 2);
    }
}

