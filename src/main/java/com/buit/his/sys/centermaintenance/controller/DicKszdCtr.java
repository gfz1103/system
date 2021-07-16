
package com.buit.his.sys.centermaintenance.controller;


import java.util.List;

import javax.validation.Valid;

import com.buit.commons.SysUser;
import com.buit.his.shyb.source.model.ShybData02Resp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.request.DicKszdAddReq;
import com.buit.his.sys.centermaintenance.request.DicKszdEditReq;
import com.buit.his.sys.centermaintenance.response.DicKszdResp;
import com.buit.his.sys.centermaintenance.service.DicKszdSer;
import com.buit.system.model.DicKszd;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * <br>
 *
 * @author 老花生
 */
@Api(tags = "科室维护")
@Controller
@RequestMapping("/dickszd")
public class DicKszdCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicKszdCtr.class);

    @Autowired
    private DicKszdSer dicKszdSer;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    //    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<DicKszdResp>> queryPage(DicKszdReq dickszd,PageQuery page){
//        PageInfo<DicKszd> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> dicKszdSer.findByEntity(dickszd)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
    @RequestMapping("/queryList")
    @ResponseBody
    @ApiOperation(value = "查询科室, 返回树集合", httpMethod = "POST")
    public ReturnEntity<List<DicKszdResp>> queryList(@ApiParam(name = "pyCode", value = "拼音码") @RequestParam(required = false) String pyCode,
                                                     @ApiParam(name = "parentid", value = "上级科室ID") @RequestParam(required = false) Integer parentid) {
        return ReturnEntityUtil.success(dicKszdSer.queryList(pyCode, parentid));
    }

    /**
     * 详情
     */
    @RequestMapping("/{brks}")
    @ResponseBody
    @ApiOperation(value = "详情", httpMethod = "POST")
    public ReturnEntity<DicKszdResp> detail(
            @ApiParam(name = "brks", value = "科室ID", required = true) @PathVariable String brks) {
        SysUser user = getUser();
        return ReturnEntityUtil.success(dicKszdSer.detail(user.getHospitalId(), brks));
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity<String> add(@Valid DicKszdAddReq req) {
        dicKszdSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity<String> edit(@Valid DicKszdEditReq req) {
        DicKszd office = BeanUtil.toBean(req, DicKszd.class);
        dicKszdSer.update(office);
        sysDictConfigSer.upDateVersion("dic_kszd");
        return ReturnEntityUtil.success();
    }

    /**
     * 停用
     */
    @RequestMapping("/stop")
    @ResponseBody
    @ApiOperation(value = "停用", httpMethod = "POST")
    public ReturnEntity<String> stop(@RequestParam(value = "id")int id) {
        dicKszdSer.getEntityMapper().stopDept(id);
        sysDictConfigSer.upDateVersion("dic_kszd");
        return ReturnEntityUtil.success();
    }


   @RequestMapping("/queryYbks")
   @ResponseBody
   @ApiOperation(value = "查询线下医保科室科室", httpMethod = "POST")
   public ReturnEntity<List<ShybData02Resp>> queryYbks() {
       return ReturnEntityUtil.success(dicKszdSer.queryYbList());
   }


    @RequestMapping("/queryXsYbks")
    @ResponseBody
    @ApiOperation(value = "查询线上医保科室科室", httpMethod = "POST")
    public ReturnEntity<List<ShybData02Resp>> queryXsYbks() {
        return ReturnEntityUtil.success(dicKszdSer.queryXSYbList());
    }
}

