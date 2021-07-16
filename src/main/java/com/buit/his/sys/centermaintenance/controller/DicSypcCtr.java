
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.dubbo.config.annotation.DubboReference;
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
import com.buit.his.sys.centermaintenance.model.DicSypc;
import com.buit.his.sys.centermaintenance.request.DicSypcAddReq;
import com.buit.his.sys.centermaintenance.request.DicSypcEditReq;
import com.buit.his.sys.centermaintenance.service.DicSypcSer;
import com.buit.system.service.SysDictConfigSer;
import com.buit.utill.BeanUtil;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 公用_使用频次<br>
 *
 * @author GONGFANGZHOU
 */
@Api(tags = "给药频次维护")
@Controller
@RequestMapping("/dicsypc")
public class DicSypcCtr extends BaseSpringController {

    static final Logger logger = LoggerFactory.getLogger(DicSypcCtr.class);

    @Autowired
    private DicSypcSer dicSypcSer;
    @Autowired
    private SysDictConfigSerImpl sysDictConfigSer;


    @RequestMapping("/getMrcsByPcbm")
    @ResponseBody
    @ApiOperation(value = "根据频次编码查询每日次数", httpMethod = "POST")
    public ReturnEntity<Integer> getMrcsByPcbm(@ApiParam(name = "pcbm", value = "频次编码", required = true) @RequestParam String pcbm) {
        DicSypc sypc = new DicSypc();
        sypc.setPcbm(pcbm);
        List<DicSypc> list = dicSypcSer.findByEntity(sypc);
        return ReturnEntityUtil.success(list.get(0).getMrcs());
    }

    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value = "按条件分页查询", httpMethod = "POST")
    public ReturnEntity<PageInfo<DicSypc>> queryPage(PageQuery page) {
        DicSypc condition = new DicSypc();
        //condition.setSortColumns(" PCMC ");
        condition.setSortColumns("plsx is null,plsx,PCBM");
        PageInfo<DicSypc> pageInfo = PageHelper.startPage(
                page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                () -> dicSypcSer.findByEntity(condition)
        );
        return ReturnEntityUtil.success(pageInfo);
    }

    /**
     * 新增
     */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value = "新增", httpMethod = "POST")
    public ReturnEntity <String> add(@Valid DicSypcAddReq req) {
        dicSypcSer.add(req);
        return ReturnEntityUtil.success();
    }

    /**
     * 编辑
     */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value = "编辑", httpMethod = "POST")
    public ReturnEntity <String> edit(@Valid DicSypcEditReq req) {
        DicSypc dicSypc = BeanUtil.toBean(req, DicSypc.class);
        dicSypcSer.update(dicSypc);
        sysDictConfigSer.upDateVersion("dic_sypc");
        return ReturnEntityUtil.success();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value = "删除", httpMethod = "POST")
    public ReturnEntity <String> delete(@ApiParam(name = "pcbm", value = "频次编码", required = true) @RequestParam String pcbm) {
        dicSypcSer.removeById(pcbm);
        sysDictConfigSer.upDateVersion("dic_sypc");
        return ReturnEntityUtil.success();
    }

}

