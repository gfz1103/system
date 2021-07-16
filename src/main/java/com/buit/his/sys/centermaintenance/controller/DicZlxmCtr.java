
package com.buit.his.sys.centermaintenance.controller;


import com.buit.apply.request.DicZlxmRecentTimeApiReq;
import com.buit.apply.response.DicZlxmRecentTimeApiResp;
import com.buit.apply.service.OpSbhyService;
import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.request.DicZlxmQueryReq;
import com.buit.his.sys.centermaintenance.request.DicZlxmRecentTimeReq;
import com.buit.his.sys.centermaintenance.response.DicZlxmQueryResp;
import com.buit.his.sys.centermaintenance.response.DicZlxmRecentTimeResp;
import com.buit.his.sys.centermaintenance.service.DicKszdSer;
import com.buit.his.sys.centermaintenance.service.DicZlxmSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.dubbo.config.annotation.DubboReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 诊疗项目<br>
 *
 * @author 老花生
 */
@Api(tags = "门诊-检验")
@Controller
@RequestMapping("/diczlxm")
public class DicZlxmCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicZlxmCtr.class);

    @Autowired
    private DicZlxmSer dicZlxmSer;
    @DubboReference
    private OpSbhyService opSbhyService;


    /**
     * 查询诊疗项目列表(sqdManageService.queryZlxmList)
     */
    @RequestMapping("/queryZlxmList")
    @ResponseBody
    @ApiOperation(value = "查询诊疗项目列表", httpMethod = "POST")
    public ReturnEntity<List<DicZlxmQueryResp>> queryZlxmList(DicZlxmQueryReq diczlxm) {//@RequestBody
        return ReturnEntityUtil.success(dicZlxmSer.queryZlxmList(diczlxm, getUser()));
    }



    /**
     * 查询诊间医技预病html组装(sqdManageService.queryYjyy4Html)  QueryYysjViewResp
     */
    @RequestMapping("/queryYjyy4Html")
    @ResponseBody
    @ApiOperation(value = "查询诊间医技预病html组装", httpMethod = "POST")
    public ReturnEntity<Map<String, Object>> queryYjyy4Html() {
        return ReturnEntityUtil.success(dicZlxmSer.queryYjyy4Html());
    }


    /**
     * 查询设备指定日期最近的号源(sqdManageService.queryRecentTime)
     */
    @RequestMapping("/queryRecentTime")
    @ResponseBody
    @ApiOperation(value = "查询设备指定日期最近的号源", httpMethod = "POST")
    public ReturnEntity<DicZlxmRecentTimeResp> queryRecentTime(DicZlxmRecentTimeReq req) {//@RequestBody
        DicZlxmRecentTimeApiReq ireq = BeanUtil.toBean(req, DicZlxmRecentTimeApiReq.class);
        DicZlxmRecentTimeApiResp iresp = opSbhyService.queryRecentTime(ireq);
        return ReturnEntityUtil.success(BeanUtil.toBean(ireq, DicZlxmRecentTimeResp.class));
    }
}

