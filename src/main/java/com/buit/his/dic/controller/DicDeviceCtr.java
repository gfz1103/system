
package com.buit.his.dic.controller;

import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseException;
import com.buit.commons.BaseSpringController;
import com.buit.his.dic.model.DicDevice;
import com.buit.his.dic.model.DicDeviceInterface;
import com.buit.his.dic.request.DicDeviceAddReq;
import com.buit.his.dic.request.DicDeviceEditReq;
import com.buit.his.dic.request.DicDeviceQueryReq;
import com.buit.his.dic.response.DicDeviceResp;
import com.buit.his.dic.service.DicDeviceInterfaceSer;
import com.buit.his.dic.service.DicDeviceSer;
import com.buit.his.dic.service.DicXzqhSer;
import com.buit.his.enums.DeviceStatusEnum;
import com.buit.system.model.DicXzqh;
import com.buit.utill.PinyinUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.buit.utill.WubiUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 */
@Api(tags = "办公设备维护")
@Controller
@RequestMapping("/sys/device")
public class DicDeviceCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicDeviceCtr.class);

    @Autowired
    private DicDeviceSer dicDeviceSer;
    @Autowired
    private DicDeviceInterfaceSer dicDeviceInterfaceSer;
    @Autowired
    private DicXzqhSer dicXzqhSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "办公设备分页条件查询", httpMethod = "POST", notes = "办公设备分页条件查询")
    public ReturnEntity<PageInfo<DicDeviceResp>> queryPage(DicDeviceQueryReq req) {
        req.setJgid(getUser().getHospitalId());
        PageInfo<DicDeviceResp> pageInfo = PageHelper.startPage(req.getPageNum(), req.getPageSize())
                .doSelectPageInfo(() -> dicDeviceSer.queryPage(req));
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "新增办公设备", httpMethod = "POST", notes = "新增办公设备")
    public ReturnEntity add(@Valid @RequestBody DicDeviceAddReq req) {
        req.setJgid(getUser().getHospitalId());
        req.setStatus(DeviceStatusEnum.ENABLE.getValue());
        dicDeviceSer.insert(req);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "编辑办公设备信息", httpMethod = "POST", notes = "编辑办公设备信息")
    public ReturnEntity edit(@Valid @RequestBody DicDeviceEditReq req) {
        dicDeviceSer.edit(req);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/enable")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "启用办公设备", httpMethod = "POST", notes = "启用办公设备")
    public ReturnEntity enable(@ApiParam(name = "deviceId", value = "设备序列号", type = "int") @RequestParam Integer deviceId) {
        dicDeviceSer.enable(deviceId);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/disable")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "停用办公设备", httpMethod = "POST", notes = "停用办公设备")
    public ReturnEntity disable(@ApiParam(name = "deviceId", value = "设备序列号", type = "int") @RequestParam Integer deviceId) {
        dicDeviceSer.disable(deviceId);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/getDeviceInvokingUrl")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "获取设备调用接口地址", httpMethod = "POST", notes = "获取设备调用接口地址")
    public ReturnEntity<String> getDeviceInvokingUrl(
            @ApiParam(name = "typeId", value = "设备型号主键", type = "int") @NotNull @RequestParam Integer typeId,
            @ApiParam(name = "interfaceName", value = "接口名称", type = "String") @NotNull @RequestParam String interfaceName
    ) {
        StringBuffer sb = new StringBuffer();
        DicDevice device = dicDeviceSer.getByIpAndType(getIpAddress(), typeId);
        DicDeviceInterface dicDeviceInterface = dicDeviceInterfaceSer.getByTypeAndName(typeId, interfaceName);
        if (device == null || dicDeviceInterface == null) {
            throw BaseException.create("ERROR_DEVICE_0001");
        }

        if (StrUtil.isNotBlank(device.getHttpPort())) {
            sb.append("http://localhost:").append(device.getHttpPort()).append(dicDeviceInterface.getUrl());
        } else {
            sb.append("https://localhost:").append(device.getHttpsPort()).append(dicDeviceInterface.getUrl());
        }
        return ReturnEntityUtil.success(sb.toString());
    }

    @RequestMapping("/syncXzqh")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "行政区划拼音码/五笔码补全", httpMethod = "POST", notes = "行政区划拼音码/五笔码补全")
    public ReturnEntity syncXzqh() {
        DicXzqh query = new DicXzqh();
        List<DicXzqh> list = dicXzqhSer.findByEntity(query);
        for (DicXzqh entry : list) {
            if (StrUtil.isBlank(entry.getPyCode())) {
                entry.setPyCode(PinyinUtils.getSimplePinYin(entry.getName()));
                entry.setWbCode(WubiUtils.getSimpleWuBi(entry.getName()));
                dicXzqhSer.update(entry);
            }
        }
        return ReturnEntityUtil.success();
    }
}
