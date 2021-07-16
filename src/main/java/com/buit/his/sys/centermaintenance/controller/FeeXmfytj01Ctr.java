
package com.buit.his.sys.centermaintenance.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj01;
import com.buit.his.sys.centermaintenance.model.FeeXmfytj02;
import com.buit.his.sys.centermaintenance.request.FeeXmfytj01QueryReq;
import com.buit.his.sys.centermaintenance.request.FeeXmfytj01Req;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmPriceSrfResp;
import com.buit.his.sys.centermaintenance.response.GyFytjResp;
import com.buit.his.sys.centermaintenance.service.FeeXmfytj01Ser;
import com.buit.his.sys.centermaintenance.service.FeeXmfytj02Ser;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.CommomUtil;
import com.buit.utill.DateUtils;
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

import java.util.HashMap;
import java.util.Map;

/**
 * <br>
 * @author GONGFANGZHOU
 */
@Api(tags="机构收费项目调价")
@Controller
@RequestMapping("/feexmfytj01")
public class FeeXmfytj01Ctr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(FeeXmfytj01Ctr.class);
    
    @Autowired
    private FeeXmfytj01Ser feeXmfytj01Ser;
    
    @Autowired
    private FeeXmfytj02Ser feeXmfytj02Ser;

    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="查询已执行或未执行调价单-分页" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeXmfytj01>> queryPage(FeeXmfytj01QueryReq feeXmfytj01QueryReq,PageQuery page) {
        feeXmfytj01QueryReq.setJgid(getUser().getHospitalId());
        String zxrq = feeXmfytj01QueryReq.getZxrq();
        if (StrUtil.isNotBlank(zxrq)) {
            feeXmfytj01QueryReq.setKszxrq(DateUtils.getDailyStartTime(DateUtils.fristDayOfMonth(zxrq)));
            feeXmfytj01QueryReq.setJszxrq(DateUtils.getDailyEndTime(DateUtils.lastDayOfMonth(zxrq)));
        }
        PageInfo<FeeXmfytj01> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> feeXmfytj01Ser.getEntityMapper().queryFytjIsExecute(feeXmfytj01QueryReq)
        );
        return ReturnEntityUtil.success(pageInfo);
    }
    
    @RequestMapping("/saveAdjustment")
    @ResponseBody
    @ApiOperation(value="新增或修改调价单" ,httpMethod="POST")
    public ReturnEntity <String> saveAdjustment(@RequestBody FeeXmfytj01Req feeXmfytj01Req){
        feeXmfytj01Ser.doSaveAdjustment(feeXmfytj01Req, this.getUser());
        return ReturnEntityUtil.success();
    }
    
    @RequestMapping("/updateExcuteStatus")
    @ResponseBody
    @ApiOperation(value="执行调价单" ,httpMethod="POST")
    public ReturnEntity <String> updateExcuteStatus(@ApiParam(name = "tjdh", value = "调价单号", required = true) 
	@RequestParam Integer tjdh){
    	FeeXmfytj01 feeXmfytj01 = new FeeXmfytj01();
    	feeXmfytj01.setTjdh(tjdh);
    	feeXmfytj01.setJgid(getUser().getHospitalId());
    	feeXmfytj01.setZxgh(ObjectToTypes.parseString(getUser().getUserId()));
    	feeXmfytj01.setZxrq(DateUtil.date().toTimestamp());
    	feeXmfytj01Ser.getEntityMapper().updateExcuteStatus(feeXmfytj01);
        return ReturnEntityUtil.success();
    }
    
    @RequestMapping("/effectAdjustment")
    @ResponseBody
    @ApiOperation(value="调价单立即生效" ,httpMethod="POST")
    public ReturnEntity <String> effectAdjustment(@ApiParam(name = "tjdh", value = "调价单号", required = true) 
	@RequestParam Integer tjdh){
    	feeXmfytj01Ser.doEffectAdjustment(tjdh, this.getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/removeAdjustment")
    @ResponseBody
    @ApiOperation(value="删除调价单" ,httpMethod="POST")
    public ReturnEntity <String> removeAdjustment(@ApiParam(name = "tjdh", value = "调价单号", required = true) 
	@RequestParam Integer tjdh){
    	FeeXmfytj01 feeXmfytj01 = new FeeXmfytj01();
        feeXmfytj01.setTjdh(tjdh);
        feeXmfytj01.setJgid(this.getUser().getHospitalId());
        feeXmfytj01Ser.removeByEntity(feeXmfytj01);

        FeeXmfytj02 feeXmfytj02 = new FeeXmfytj02();
        feeXmfytj02.setTjdh(tjdh);
        feeXmfytj02.setJgid(this.getUser().getHospitalId());
        feeXmfytj02Ser.removeByEntity(feeXmfytj02);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/cancelAdjustment")
    @ResponseBody
    @ApiOperation(value = "调价单作废", httpMethod = "POST")
    public ReturnEntity<String> cancelAdjustment(@ApiParam(name = "tjdh", value = "调价单号", required = true)
                                                 @RequestParam Integer tjdh) {
        feeXmfytj01Ser.cancelAdjustment(tjdh, getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/loadAdjustmentAndDetail")
    @ResponseBody
    @ApiOperation(value = "查询收费项目调价明细", httpMethod = "POST")
    public ReturnEntity<GyFytjResp> loadAdjustmentAndDetail(@ApiParam(name = "tjdh", value = "调价单号", required = true)
                                                            @RequestParam Integer tjdh) {
        return ReturnEntityUtil.success(feeXmfytj01Ser.doLoadAdjustmentAndDetail(tjdh, this.getUser()));
    }

    @RequestMapping("/queryModifyPricecFeeYlsfxm")
    @ResponseBody
    @ApiOperationSupport(author = "龚方舟")
    @ApiOperation(value = "收费项目调价输入法查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<FeeYlsfxmPriceSrfResp>> queryModifyPricecFeeYlsfxm(@ApiParam(name = "pydm", value = "拼音代码")
                                                                                    @RequestParam String pydm, PageQuery page) {
        Map<String, Object> parameters = new HashMap<String, Object>(16);
        parameters.put("cxlb", "a.pydm");
        if(CommomUtil.isContainChinese(pydm)) {
            parameters.put("cxlb", "a.fymc");
        }
        parameters.put("jgid", this.getUser().getHospitalId());
        parameters.put("pydm", pydm);
        PageInfo<FeeYlsfxmPriceSrfResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
                .doSelectPageInfo(() -> feeYlsfxmSer.getEntityMapper().queryModifyPricecFeeYlsfxm(parameters));
        return ReturnEntityUtil.success(pageInfo);
    }


       
}

