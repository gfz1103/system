
package com.buit.his.sys.msg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.buit.commons.BaseSpringController;

/**
 * 消息推送-主记录<br>
 * @author 神算子
 */
//@Api(tags="消息推送-主记录")
//@Controller
//@RequestMapping("/messzjl")
public class MessZjlCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MessZjlCtr.class);
    
//    @Autowired
//    private MessZjlSer messZjlSer;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<MessZjlResp>> queryPage(MessZjlReq messzjl,PageQuery page){
//        PageInfo<MessZjl> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> messZjlSer.findByEntity(messzjl)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<MessZjlResp>> getByEntity( MessZjlReq messzjl){//@RequestBody 
//        return ReturnEntityUtil.success(messZjlSer.findByEntity(messzjl));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MessZjlResp> getOneByEntity(MessZjlReq messzjl){
//        List<MessZjl> list=messZjlSer.findByEntity(messzjl);
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
//    public ReturnEntity<MessZjlResp> add(MessZjlReq messZjl) {
//        messZjlSer.insert(messZjl);        
//        return ReturnEntityUtil.success(messZjl);            
//    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<MessZjlResp> edit(MessZjlReq messZjl)  {
//        messZjlSer.update(messZjl);        
//        return ReturnEntityUtil.success(messZjl);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MessZjlResp> delete(MessZjlReq messZjl) {
//        messZjlSer.removeByEntity(messZjl);        
//        return ReturnEntityUtil.success(messZjl);            
//    }
    
}

