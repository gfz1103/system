
package com.buit.his.sys.centermaintenance.controller;

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
import com.buit.his.sys.centermaintenance.model.PubFklb;
import com.buit.his.sys.centermaintenance.request.PubFklbAddReq;
import com.buit.his.sys.centermaintenance.request.PubFklbEditReq;
import com.buit.his.sys.centermaintenance.service.PubFklbSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 付款类别<br>
 *
 * @author liushijie
 */
@Api(tags = "付款类别维护")
@Controller
@RequestMapping("/pubfklb")
public class PubFklbCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(PubFklbCtr.class);

    @Autowired
    private PubFklbSer pubFklbSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value = "按条件分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<PubFklb>> queryPage(PageQuery page) {
        PageInfo<PubFklb> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> pubFklbSer.findByEntity(null)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity <String> add(@Valid PubFklbAddReq req) {
        pubFklbSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity <String> edit(@Valid PubFklbEditReq req) {
        PubFklb pubFklb = BeanUtil.toBean(req, PubFklb.class);
        pubFklbSer.update(pubFklb);
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "删除", httpMethod = "POST")
    public ReturnEntity <String> delete(@ApiParam(name = "fklb", value = "付款类别", required = true) @RequestParam int fklb) {
        pubFklbSer.removeById(fklb);
        return ReturnEntityUtil.success();
    }

}

