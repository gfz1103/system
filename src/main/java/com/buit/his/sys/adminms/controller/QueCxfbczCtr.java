
package com.buit.his.sys.adminms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.buit.commons.BaseSpringController;

/**
 * 单表增删改查操作发布<br>
 * @author 神算子
 */
//@Api(tags="单表增删改查操作发布")
//@Controller
//@RequestMapping("/quecxfbcz")
public class QueCxfbczCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(QueCxfbczCtr.class);
    
//    @Autowired
//    private QueCxfbczSer queCxfbczSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<QueCxfbczResp>> queryPage(QueCxfbczReq quecxfbcz,PageQuery page){
//        PageInfo<QueCxfbcz> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> queCxfbczSer.findByEntity(quecxfbcz)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<QueCxfbczResp>> getByEntity( QueCxfbczReq quecxfbcz){//@RequestBody 
//        return ReturnEntityUtil.success(queCxfbczSer.findByEntity(quecxfbcz));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<QueCxfbczResp> getOneByEntity(QueCxfbczReq quecxfbcz){
//        List<QueCxfbcz> list=queCxfbczSer.findByEntity(quecxfbcz);
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
//    public ReturnEntity<QueCxfbczResp> add(QueCxfbczReq queCxfbcz) {
//        queCxfbczSer.insert(queCxfbcz);        
//        return ReturnEntityUtil.success(queCxfbcz);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<QueCxfbczResp> edit(QueCxfbczReq queCxfbcz)  {
//        queCxfbczSer.update(queCxfbcz);        
//        return ReturnEntityUtil.success(queCxfbcz);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<QueCxfbczResp> delete(QueCxfbczReq queCxfbcz) {
//        queCxfbczSer.removeByEntity(queCxfbcz);        
//        return ReturnEntityUtil.success(queCxfbcz);            
//    }
    
}

