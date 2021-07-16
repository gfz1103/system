
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.request.PubCshReq;
import com.buit.his.sys.centermaintenance.response.PubCshywjResp;
import com.buit.his.sys.centermaintenance.service.PubCshywjSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 项目关联
 *
 * @author  beijunhua
 */
@Api(tags = "系统初始化")
@Controller
@RequestMapping("/systeminit")
public class SystemInitialCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(SystemInitialCtr.class);

    @Autowired
    private PubCshywjSer gyGnjSer;




    /**
     * 系统初始化
     * @param
     * @return
     */
    @RequestMapping("/queryList")
    @ResponseBody
    @ApiOperation(value="系统初始化列表" ,httpMethod="POST")
    public ReturnEntity<List<PubCshywjResp>> queryList(){
        List<PubCshywjResp> pageInfo =gyGnjSer.queryList(getUser());
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/doInit")
    @ResponseBody
    @ApiOperation(value="系统初始化-初始化" ,httpMethod="POST")
    public ReturnEntity <String> doInit(@RequestBody PubCshReq req) throws Exception {
        gyGnjSer.doInit(req,getUser());
        return ReturnEntityUtil.success();
    }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}

