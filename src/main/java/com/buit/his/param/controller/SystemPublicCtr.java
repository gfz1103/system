package com.buit.his.param.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.param.request.MnemonicReq;
import com.buit.his.param.service.SysXtcsCacheSerImp;
import com.buit.his.param.service.SystemPublicSer;
import com.buit.system.request.SystemParamReq;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.Map;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/5/11 18:44
 */
@Api(tags = "系统公共接口")
@Controller
@RequestMapping(value = "/system/public", method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
)
public class SystemPublicCtr extends BaseSpringController {

    @Autowired
    SystemPublicSer systemPublicSer;
    @Autowired
    SysXtcsCacheSerImp sysXtcsCacheSerImp;

    @ApiOperation("获取系统参数")
    @RequestMapping("/get/params")
    @ResponseBody
    public ReturnEntity<Map<String, Object>> getSystemParams(@RequestBody SystemParamReq systemParamReq) throws Exception {
        return ReturnEntityUtil.success(sysXtcsCacheSerImp.getSystemParams(systemParamReq, getUser().getHospitalId()));
    }

    @ApiOperation("获取助记码")
    @RequestMapping("/get/mnemonic")
    @ResponseBody
    public ReturnEntity<Map<String, String>> getMnemonic(@RequestBody @Valid MnemonicReq mnemonicReq) {
        return ReturnEntityUtil.success(systemPublicSer.getMnemonic(mnemonicReq));
    }

}
