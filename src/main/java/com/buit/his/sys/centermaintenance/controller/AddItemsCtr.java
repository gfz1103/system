
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.sys.centermaintenance.model.DiccLdxmgl;
import com.buit.his.sys.centermaintenance.request.DiccLdxmglAddReq;
import com.buit.his.sys.centermaintenance.request.DiccLdxmglEditReq;
import com.buit.his.sys.centermaintenance.response.DiccLdxmglResp;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmResp;
import com.buit.his.sys.centermaintenance.service.DiccLdxmglSer;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 项目关联
 *
 * @author liushijie
 */
@Api(tags = "附加项目维护")
@Controller
@RequestMapping("/addItems")
public class AddItemsCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(AddItemsCtr.class);

    @Autowired
    private DiccLdxmglSer diccLdxmglSer;

    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;



    /**
     * 中心维护-附加项目-查询医疗收费列表
     * @param pydm
     * @param page
     * @return
     */
    @RequestMapping("/queryChargeList")
    @ResponseBody
    @ApiOperation(value="附加项目-医疗项目列表" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmResp>> queryList(@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(value = "pydm", required = false )  String pydm, PageQuery page){
        PageInfo<FeeYlsfxmResp> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> feeYlsfxmSer.getEntityMapper().
                        queryList(getUser().getHospitalId(), pydm)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 查询项目关联列表
     *
     * @param xmxh
     * @return
     */
    @RequestMapping("/queryGlList")
    @ResponseBody
    @ApiOperation(value = "查询附加项目关联列表", httpMethod = "POST")
    public ReturnEntity<List<DiccLdxmglResp>> queryXmglList(@ApiParam(name = "xmxh", value = "项目序号") @RequestParam int xmxh,
                                                            @ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm) {
        return ReturnEntityUtil.success(diccLdxmglSer.getEntityMapper().queryXmglList(getUser().getHospitalId(), xmxh, pydm));
    }


    /**
     * 附加项目-新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity<String> add(@Valid DiccLdxmglAddReq req) {
        diccLdxmglSer.add(req, getUser().getHospitalId());
        return ReturnEntityUtil.success();
    }


    /**
     * 附加项目-编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity<String> edit(@Valid DiccLdxmglEditReq req) {
        DiccLdxmgl diccLdxmgl = BeanUtil.toBean(req, DiccLdxmgl.class);
        diccLdxmglSer.update(diccLdxmgl);
        return ReturnEntityUtil.success();
    }

    /**
     * 附加项目-删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "删除", httpMethod = "POST")
    public ReturnEntity<String> delete(@ApiParam(name = "jlxh", value = "记录序号", required = true) @RequestParam int jlxh) {
        diccLdxmglSer.getEntityMapper().deleteById(jlxh);
        return ReturnEntityUtil.success();
    }

}

