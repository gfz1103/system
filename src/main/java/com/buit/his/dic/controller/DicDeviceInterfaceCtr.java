
package com.buit.his.dic.controller;

import com.buit.commons.BaseSpringController;
import com.buit.his.dic.model.DicDeviceInterface;
import com.buit.his.dic.request.DicDeviceInterfaceAddReq;
import com.buit.his.dic.service.DicDeviceInterfaceSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.15
 */
@Api(tags = "办公设备接口维护")
@Controller
@RequestMapping("/sys/deviceInterface")
public class DicDeviceInterfaceCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicDeviceInterfaceCtr.class);

    @Autowired
    private DicDeviceInterfaceSer dicDeviceInterfaceSer;

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "办公设备接口查询", httpMethod = "POST", notes = "办公设备类型分页条件查询")
    public ReturnEntity<List<DicDeviceInterface>> findList(
            @ApiParam(name = "typeId", value = "办公设备类型") @RequestParam(value = "typeId", required = true) Integer typeId) {
        DicDeviceInterface query = new DicDeviceInterface();
        query.setTypeId(typeId);
        List<DicDeviceInterface> list = dicDeviceInterfaceSer.findByEntity(query);
        return ReturnEntityUtil.success(list);
    }

    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "新增接口", httpMethod = "POST", notes = "办公设备类型新增")
    public ReturnEntity add(@Valid @RequestBody DicDeviceInterfaceAddReq req) {
        dicDeviceInterfaceSer.insert(req);
        return ReturnEntityUtil.success();
    }

}
