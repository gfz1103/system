
package com.buit.his.sys.centermaintenance.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.dic.api.SysDictConfigSerImpl;
import com.buit.his.sys.centermaintenance.model.PubFkfs;
import com.buit.his.sys.centermaintenance.request.PubFkfsAddReq;
import com.buit.his.sys.centermaintenance.request.PubFkfsEditReq;
import com.buit.his.sys.centermaintenance.service.PubFkfsSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

/**
 * 公用_付款方式 |  用于门诊及住院付款方式设定<br>
 *
 * @author WY
 */
@Api(tags = "付款方式维护")
@Controller
@RequestMapping("/pubfkfs")
public class PubFkfsCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(PubFkfsCtr.class);

    @Autowired
    private PubFkfsSer pubFkfsSer;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value = "分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<PubFkfs>> queryPage(@ApiParam(name = "sylx", value = "使用类型 1.门诊使用2.住院使用", required = true) @RequestParam Integer sylx, PageQuery page) {
        PubFkfs condition = new PubFkfs();
        condition.setSylx(sylx);
        PageInfo<PubFkfs> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> pubFkfsSer.findByEntity(condition)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/list")
    @ResponseBody
    @ApiOperation(value = "付款方式", httpMethod = "POST")
    public ReturnEntity<List<PubFkfs>> queryPage(@ApiParam(name = "sylx", value = "使用类型 1.门诊使用2.住院使用", required = true) @RequestParam Integer sylx) {
        PubFkfs condition = new PubFkfs();
        condition.setSylx(sylx);
        List<PubFkfs> list = pubFkfsSer.findByEntity(condition);
        return ReturnEntityUtil.success(list);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity<String> add(@Valid PubFkfsAddReq req) {
        pubFkfsSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity<String> edit(@Valid PubFkfsEditReq req) {
        PubFkfs pubFkfs = BeanUtil.toBean(req, PubFkfs.class);
        pubFkfsSer.update(pubFkfs);
        sysDictConfigSer.upDateVersion("pub_fkfs");
        return ReturnEntityUtil.success();
    }

    /**
     * 作废/取消作废
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "作废/取消作废", httpMethod = "POST")
    public ReturnEntity<String> delete(@ApiParam(name = "fkfs", value = "付款方式", required = true) @RequestParam int fkfs,
                                       @ApiParam(name = "zfbz", value = "作废标志,0:未作废1:作废", required = true) @RequestParam int zfbz) {
        pubFkfsSer.getEntityMapper().updateZfbz(zfbz, fkfs);
        sysDictConfigSer.upDateVersion("pub_fkfs");
        return ReturnEntityUtil.success();
    }

    /**
     * 设置默认标志
     */
    @RequestMapping("/setMrbz")
    @ResponseBody
    @ApiOperation(value = "设置默认标志", httpMethod = "POST")
    public ReturnEntity<String> setMrbz(@ApiParam(name = "fkfs", value = "付款方式", required = true) @RequestParam int fkfs,
                                        @ApiParam(value = "使用类型 1.门诊使用2.住院使用", name = "sylx", required = true) @RequestParam Integer sylx) {
        pubFkfsSer.setMrbz(fkfs, sylx);
        return ReturnEntityUtil.success();
    }

    /**
     * 设置货币误差
     */
    @RequestMapping("/setHbwc")
    @ResponseBody
    @ApiOperation(value = "设置货币误差", httpMethod = "POST")
    public ReturnEntity<String> setHbwc(@ApiParam(name = "fkfs", value = "付款方式", required = true) @RequestParam int fkfs,
                                        @ApiParam(value = "使用类型 1.门诊使用2.住院使用", name = "sylx", required = true) @RequestParam Integer sylx) {
        pubFkfsSer.setHbwc(fkfs, sylx);
        return ReturnEntityUtil.success();
    }


}

