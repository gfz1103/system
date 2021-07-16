package com.buit.his.sys.openapi.rest;

import com.buit.config.annotation.OpenApi;
import com.buit.his.sys.openapi.request.OpenApiRequest;
import com.buit.his.sys.openapi.request.*;
import com.buit.his.sys.openapi.response.*;
import com.buit.his.sys.openapi.service.OpenYlsfxmService;
import com.buit.system.model.DicSfxmlb;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author sunjx
 * @Date 2020-12-14 10:06
 * @Description 物资/耗材相关接口
 **/
@Api(tags = "收费物资明细", description = "")
@RequestMapping("/openapi/sfwzmx")
@OpenApi(role = "sfwzmx")
@RestController
public class FeeYlsfxmRest {

    @Autowired
    private OpenYlsfxmService openYlsfxmService;

    @ApiOperation("项目大类查询")
    @PostMapping("/v1/sfxmlb_list")
    public ReturnEntity<List<DicSfxmlb>> sfxmlbList(@RequestBody OpenApiRequest<QuerysfxmlbListRequest> request){
        return ReturnEntityUtil.success(openYlsfxmService.sfxmlbList(request.getData().getFyfl(), request.getData().getPydm()));
    }

    @ApiOperation("获取新增项目编码")
    @PostMapping("/v1/next_sfxmbm")
    public ReturnEntity<QueryNextSfxmbmResponse> nextSfxmbm(@RequestBody OpenApiRequest<QueryNextSfxmbmRequest> request){
        return ReturnEntityUtil.success(openYlsfxmService.nextSfxmbm(request.getData().getSfxmlb()));
    }

    @ApiOperation(value = "保存项目明细", notes =
        "使用情况, 门诊使用:mzsy,1/0; 住院使用:zysy,1/0; 医技使用:yjsy,1/0 <br>" +
        "明细标志:mxbz,1/0 <br>" +
        "材料标志:clbz,1/0 <br>" +
        "执行科室:zxks,字典查询(dict_config)41 <br>" +
        "报表归并:bbgb,字典查询(dict_config)42 <br>" +
        "材料对应:cldy,字典查询(dict_config)43 <br>" +
        "项目类型:xmlx,字典查询(flag_data)XM000001 <br>" +
        "病案首页归并:basygb,")
    @PostMapping("/v1/save")
    public ReturnEntity<SaveSfxmmxResponse> save(@RequestBody OpenApiRequest<SaveSfxmmxRequest> request){
        return ReturnEntityUtil.success(openYlsfxmService.save(request.getData()));
    }

    @ApiOperation("项目明细详情")
    @PostMapping("/v1/detail")
    public ReturnEntity<QuerySfxmmxDetailResponse> detail(@RequestBody OpenApiRequest<QuerySfxmmxDetailRequest> request){
        return ReturnEntityUtil.success(openYlsfxmService.detail(request.getData().getFyxh()));
    }

    @ApiOperation(value = "字典查询(dict_config)")
    @PostMapping("/v1/dict")
    public ReturnEntity<List<QueryDictResponse>> dict(@RequestBody OpenApiRequest<QueryDictRequest> request){
        return ReturnEntityUtil.success(openYlsfxmService.dict(request.getData().getDictId(), request.getData().getHospitalId()));
    }

    @ApiOperation(value = "字典查询(flag_data)")
    @PostMapping("/v1/flag_data")
    public ReturnEntity<List<QueryFlagDataResponse>> flagData(@RequestBody OpenApiRequest<QueryFlagDataRequest> request){
        return ReturnEntityUtil.success(openYlsfxmService.flagData(request.getData().getDataCode(), request.getData().getHospitalId()));
    }
}
