
package com.buit.his.sys.centermaintenance.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.buit.commons.BaseSpringController;
import com.buit.his.sys.centermaintenance.service.FeeSfdlzfblSer;

import io.swagger.annotations.Api;

/**
 * 公用_自负比例<br>
 * @author ZHOUHAISHENG
 */
@Api(tags="公用_自负比例")
@Controller
@RequestMapping("/feesfdlzfbl")
public class FeeSfdlzfblCtr extends BaseSpringController {
    
    static final Logger logger = LoggerFactory.getLogger(FeeSfdlzfblCtr.class);
    
    @Autowired
    private FeeSfdlzfblSer feeSfdlzfblSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<FeeSfdlzfblResp>> queryPage(FeeSfdlzfblReq feesfdlzfbl,PageQuery page){
//        PageInfo<FeeSfdlzfbl> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> feeSfdlzfblSer.findByEntity(feesfdlzfbl)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<FeeSfdlzfblResp>> getByEntity( FeeSfdlzfblReq feesfdlzfbl){//@RequestBody 
//        return ReturnEntityUtil.success(feeSfdlzfblSer.findByEntity(feesfdlzfbl));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<FeeSfdlzfblResp> getOneByEntity(FeeSfdlzfblReq feesfdlzfbl){
//        List<FeeSfdlzfbl> list=feeSfdlzfblSer.findByEntity(feesfdlzfbl);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
//    /** 新增 */
//    @RequestMapping("/add")
//    @ResponseBody
//    @ApiOperation(value="新增" ,httpMethod="POST")
//    public ReturnEntity<FeeSfdlzfblResp> add(FeeSfdlzfblReq feeSfdlzfbl) {
//        feeSfdlzfblSer.insert(feeSfdlzfbl);        
//        return ReturnEntityUtil.success(feeSfdlzfbl);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<FeeSfdlzfblResp> edit(FeeSfdlzfblReq feeSfdlzfbl)  {
//        feeSfdlzfblSer.update(feeSfdlzfbl);        
//        return ReturnEntityUtil.success(feeSfdlzfbl);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<FeeSfdlzfblResp> delete(FeeSfdlzfblReq feeSfdlzfbl) {
//        feeSfdlzfblSer.removeByEntity(feeSfdlzfbl);        
//        return ReturnEntityUtil.success(feeSfdlzfbl);            
//    }
    
}

