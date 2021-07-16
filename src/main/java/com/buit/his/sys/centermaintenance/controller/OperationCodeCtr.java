package com.buit.his.sys.centermaintenance.controller;

import com.buit.his.sys.centermaintenance.request.QueryOperationCodeReq;
import com.buit.his.sys.centermaintenance.request.SaveOperationCodeReq;
import com.buit.his.sys.centermaintenance.request.SssfxmReq;
import com.buit.his.sys.centermaintenance.response.OperationCodeResp;
import com.buit.his.sys.centermaintenance.response.SssfxmResp;
import com.buit.his.sys.centermaintenance.service.OperationCodeSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * @Description
 * @Author yueyu
 * @Date 2020/11/9 15:28
 */
@Api(tags="手术编码维护")
@Controller
@RequestMapping(value = "/operation/code",method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class OperationCodeCtr {

    @Autowired
    OperationCodeSer operationCodeSer;

    @ApiOperation("保存")
    @RequestMapping("/save")
    @ResponseBody
    public ReturnEntity save(@Valid SaveOperationCodeReq req){
        operationCodeSer.save(req);
        return ReturnEntityUtil.success();
    }

    @ApiOperation("删除")
    @RequestMapping("/delete")
    @ResponseBody
    public ReturnEntity delete(@RequestParam("id")Integer id){
        operationCodeSer.delete(id);
        return ReturnEntityUtil.success();
    }


    @ApiOperation("列表")
    @RequestMapping("/list")
    @ResponseBody
    public ReturnEntity<PageInfo<OperationCodeResp>> list(QueryOperationCodeReq req){

        return ReturnEntityUtil.success(operationCodeSer.list(req));
    }

    @ApiOperation("停用/启用")
    @RequestMapping("/enable")
    @ResponseBody
    public ReturnEntity enable(@RequestParam("id")Integer id){
        operationCodeSer.enable(id);
        return ReturnEntityUtil.success();
    }

    @ApiOperation("查询手术编码信息")
    @RequestMapping("/get")
    @ResponseBody
    public ReturnEntity<OperationCodeResp> get(@RequestParam("id")Integer id){
        return ReturnEntityUtil.success(operationCodeSer.get(id));
    }
}
