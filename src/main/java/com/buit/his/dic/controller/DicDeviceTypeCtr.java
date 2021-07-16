
package com.buit.his.dic.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.dic.model.DicDeviceType;
import com.buit.his.dic.request.DicDeviceTypeAddReq;
import com.buit.his.dic.service.DicDeviceTypeSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
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
import java.util.List;

/**
 * @Auther jiangwei
 * @CreateDate 2021.3.11
 */
@Api(tags = "办公设备类型字典")
@Controller
@RequestMapping("/sys/deviceType")
public class DicDeviceTypeCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicDeviceTypeCtr.class);

    @Autowired
    private DicDeviceTypeSer dicDeviceTypeSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "办公设备类型分页条件查询", httpMethod = "POST", notes = "办公设备类型分页条件查询")
    public ReturnEntity<PageInfo<DicDeviceType>> queryPage(
            @ApiParam(name = "name", value = "设备名称") @RequestParam(value = "name", required = false) String name,
            PageQuery page) {
        DicDeviceType deviceType = new DicDeviceType();
        deviceType.setTypeName(name);
        PageInfo<DicDeviceType> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
                .doSelectPageInfo(() -> dicDeviceTypeSer.findByEntity(deviceType));
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "办公设备类型列表", httpMethod = "POST", notes = "办公设备类型列表")
    public ReturnEntity<List<DicDeviceType>> findList() {
        DicDeviceType query = new DicDeviceType();
        return ReturnEntityUtil.success(dicDeviceTypeSer.findByEntity(query));
    }

    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "jiangwei")
    @ApiOperation(value = "办公设备类型新增", httpMethod = "POST", notes = "办公设备类型新增")
    public ReturnEntity add(@Valid @RequestBody DicDeviceTypeAddReq req) {
        dicDeviceTypeSer.save(req);
        return ReturnEntityUtil.success();
    }

}
