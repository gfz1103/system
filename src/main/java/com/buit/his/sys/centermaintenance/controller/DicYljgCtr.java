
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import javax.validation.Valid;

import com.buit.his.sys.centermaintenance.response.PageLogoResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.request.DicYljgAddReq;
import com.buit.his.sys.centermaintenance.request.DicYljgEditReq;
import com.buit.his.sys.centermaintenance.response.DicYljgResp;
import com.buit.his.sys.centermaintenance.service.DicYljgSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 医疗卫生机构索引表<br>
 *
 * @author liushijie
 */
@Api(tags = "医疗机构维护")
@Controller
@RequestMapping("/dicyljg")
public class DicYljgCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicYljgCtr.class);

    @Autowired
    private DicYljgSer dicYljgSer;


    @RequestMapping("/queryList")
    @ResponseBody
    @ApiOperation(value = "查询机构树", httpMethod = "POST")
    public ReturnEntity<List<DicYljgResp>> queryList(@ApiParam(name = "pyCode", value = "拼音码") @RequestParam(required = false) String pyCode) {
        return ReturnEntityUtil.success(dicYljgSer.queryList(pyCode));
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity <String> add(@Valid DicYljgAddReq req) {
        dicYljgSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity <String> edit(@Valid DicYljgEditReq req) {
        dicYljgSer.edit(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 停用机构
     */
    @RequestMapping("/stop")
    @ResponseBody
    @ApiOperation(value = "停用机构", httpMethod = "POST")
    public ReturnEntity <String> stop(@ApiParam(name = "hospitalId", value = "机构ID",required = true)@RequestParam Integer hospitalId) {
        dicYljgSer.stop(hospitalId);
        return ReturnEntityUtil.success();
    }
    /**
     * 查询医疗机构logo
     */
    @RequestMapping("/logo")
    @ResponseBody
    @ApiOperation(value = "查询医疗机构logo", httpMethod = "POST")
    public ReturnEntity <String> logo(@ApiParam(name = "hospitalId", value = "机构ID",required = true)@RequestParam Integer hospitalId) {
        return ReturnEntityUtil.success(dicYljgSer.logo(hospitalId));
    }

    /**
     * 查询医疗机构主页小logo
     */
    @RequestMapping("/pageLogo")
    @ResponseBody
    @ApiOperation(value = "查询医疗机构主页小logo", httpMethod = "POST")
    public ReturnEntity <PageLogoResp> pageLogo(@ApiParam(name = "hospitalId", value = "机构ID",required = true)@RequestParam Integer hospitalId) {
        return ReturnEntityUtil.success(dicYljgSer.pageLogo(hospitalId));
    }

}

