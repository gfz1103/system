
package com.buit.his.dic.controller;

import java.util.List;

import javax.validation.Valid;

import com.buit.his.dic.api.DicGbsj02ServiceImpl;
import com.buit.system.request.DicGbsj02Model;
import com.buit.system.response.DicGbsj02Resp;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.his.dic.model.DicGbsj02;
import com.buit.his.dic.request.DicGbsj01PageReq;
import com.buit.his.dic.request.DicGbsj02AddReq;
import com.buit.his.dic.request.DicGbsj02EditReq;
import com.buit.his.dic.response.DicGbsj02DetailResp;
import com.buit.his.dic.response.DicGbsj02PageResp;
import com.buit.his.dic.service.DicGbsj02Ser;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 标准数据值域记录<br>
 * @author 老花生
 */
@Api(tags="医院字典项")
@Controller
@RequestMapping("/sys/dicgbsj02")
public class DicGbsj02Ctr extends BaseSpringController{

    static final Logger logger = LoggerFactory.getLogger(DicGbsj02Ctr.class);

    @Autowired
    private DicGbsj02Ser dicGbsj01ValueSer;

    @Autowired
    private DicGbsj02ServiceImpl dicGbsj02Service;

    @RequestMapping("/page")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--分页信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicGbsj02PageResp>> page(@Valid DicGbsj01PageReq req){
        req.setHospitalId(getUser().getHospitalId());
        PageInfo<DicGbsj02PageResp> response = dicGbsj01ValueSer.page(req);
        return ReturnEntityUtil.success(response);
    }

    @RequestMapping("/add")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--新增" ,httpMethod="POST")
    public ReturnEntity add(@Valid DicGbsj02AddReq req){
        dicGbsj01ValueSer.add(req, getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--编辑" ,httpMethod="POST")
    public ReturnEntity edit(@Valid DicGbsj02EditReq req){
        dicGbsj01ValueSer.edit(req, getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/detail/{id}")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--详情" ,httpMethod="POST")
    public ReturnEntity<DicGbsj02DetailResp> detail(@PathVariable("id") Integer id){
        return ReturnEntityUtil.success(dicGbsj01ValueSer.detail(id));
    }

    @RequestMapping("/stop/{id}")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--停用" ,httpMethod="POST")
    public ReturnEntity stop(@PathVariable("id") Integer id){
        dicGbsj01ValueSer.stop(id, getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/open/{id}")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--启用" ,httpMethod="POST")
    public ReturnEntity open(@PathVariable("id") Integer id){
        dicGbsj01ValueSer.open(id, getUser());
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/queryChild/{id}")
    @ResponseBody
    @ApiOperationSupport(author = "老花生")
    @ApiOperation(value="字典项--查询下级列表" ,httpMethod="POST")
    public ReturnEntity<List<DicGbsj02PageResp>> queryChild(@PathVariable("id") Integer id){
        DicGbsj02 data = new DicGbsj02();
        data.setHospitalId(getUser().getHospitalId());
        data.setParentDatavalueId(id);
        List<DicGbsj02> ret = dicGbsj01ValueSer.findByEntity(data);
        return ReturnEntityUtil.success(BeanUtil.toBeans(ret, DicGbsj02PageResp.class));
    }

}

