
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
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.model.ImDicYpyf;
import com.buit.his.sys.centermaintenance.request.ImDicYpyfAddReq;
import com.buit.his.sys.centermaintenance.request.ImDicYpyfEditReq;
import com.buit.his.sys.centermaintenance.response.ImDicYpyfAppendResp;
import com.buit.his.sys.centermaintenance.service.ImDicYpyfSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.PinyinUtils;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 住院_药品用法<br>
 *
 * @author liushijie
 */
@Api(tags = "给药途径维护")
@Controller
@RequestMapping("/imdicypyf")
public class ImDicYpyfCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(ImDicYpyfCtr.class);

    @Autowired
    private ImDicYpyfSer imDicYpyfSer;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value = "按条件分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<ImDicYpyf>> queryPage(@ApiParam(name = "pydm", value = "拼音代码") @RequestParam(required = false) String pydm, PageQuery page) {
        ImDicYpyf condition = new ImDicYpyf();
        condition.setPydm(pydm);
        condition.setSortColumns("yzpx is null,yzpx,YPYF");
        PageInfo<ImDicYpyf> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> imDicYpyfSer.findByEntity(condition)
        );
        return ReturnEntityUtil.success(pageInfo);

    }


    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity <String> add(@Valid ImDicYpyfAddReq req) {
        imDicYpyfSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity <String> edit(@Valid ImDicYpyfEditReq req) {
        ImDicYpyf imDicYpyf = BeanUtil.toBean(req, ImDicYpyf.class);
        String pydm = PinyinUtils.getSimplePinYin(imDicYpyf.getXmmc());
        imDicYpyf.setPydm(pydm);
        imDicYpyfSer.update(imDicYpyf);
        sysDictConfigSer.upDateVersion("im_dic_ypyf");
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "删除", httpMethod = "POST")
    public ReturnEntity <String> delete(@ApiParam(name = "ypyf", value = "药品用法序号",required = true) @RequestParam int ypyf) {
        imDicYpyfSer.removeById(ypyf);
        sysDictConfigSer.upDateVersion("im_dic_ypyf");
        return ReturnEntityUtil.success();
    }
    
    @RequestMapping("/loadYpAppendAdvice")
    @ResponseBody
    @ApiOperation(value = "查询药品附加项目", httpMethod = "POST")
    public ReturnEntity<List<ImDicYpyfAppendResp>> loadYpAppendAdvice(@ApiParam(name = "ypyf", value = "药品用法序号",required = true) 
    @RequestParam Integer ypyf) {
        return ReturnEntityUtil.success(imDicYpyfSer.getEntityMapper().loadYpAppendAdvice(ypyf));
    }

}

