
package com.buit.his.sys.msg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.constans.TableName;
import com.buit.his.sys.msg.model.MessCljl;
import com.buit.his.sys.msg.service.MessCljlSer;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 消息推送-处理记录<br>
 * @author 神算子
 */
@Api(tags="消息推送-处理记录")
@Controller
@RequestMapping("/messcljl")
public class MessCljlCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(MessCljlCtr.class);
    
    @Autowired
    private MessCljlSer messCljlSer;
    
    @Autowired
    private RedisFactory redisFactory;
    
//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<MessCljlResp>> queryPage(MessCljlReq messcljl,PageQuery page){
//        PageInfo<MessCljl> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> messCljlSer.findByEntity(messcljl)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<MessCljlResp>> getByEntity( MessCljlReq messcljl){//@RequestBody 
//        return ReturnEntityUtil.success(messCljlSer.findByEntity(messcljl));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @Res`ponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<MessCljlResp> getOneByEntity(MessCljlReq messcljl){
//        List<MessCljl> list=messCljlSer.findByEntity(messcljl);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<MessCljl> add(@ApiParam(name = "messId", value = "消息主键") @RequestParam(value = "messId")  Integer messId,
    @ApiParam(name = "ksId", value = "科室id", required = false) @RequestParam(value = "ksId", required = false ) Integer ksId,
    @ApiParam(name = "ywtype", value = "业务类型(1:住院护士站,2:住院医生站)", required = false) @RequestParam(value = "ywtype", required = false ) Integer ywtype) {
    	MessCljl messCljl=new MessCljl();
    	messCljl.setMessId(messId);
    	messCljl.setUserId(getUser().getUserId());
    	messCljl.setCtime(DateUtil.date().toTimestamp());   
    	if(!StrUtil.isBlankIfStr(ksId)) {
    		messCljl.setKsId(ksId);
    	}
    	if(!StrUtil.isBlankIfStr(ywtype)) {
    		messCljl.setKsId(ksId);
    	}
    	messCljl.setMessCljlId(redisFactory.getTableKey(TableName.DB_NAME, TableName.MESS_CLJL));
    	messCljlSer.insert(messCljl); 
        return ReturnEntityUtil.success(messCljl);            
    }
//    /** 编辑 */
//    @RequestMapping("/edit")
//    @ResponseBody
//    @ApiOperation(value="编辑" ,httpMethod="POST")
//    public ReturnEntity<MessCljlResp> edit(MessCljlReq messCljl)  {
//        messCljlSer.update(messCljl);        
//        return ReturnEntityUtil.success(messCljl);            
//    }
//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<MessCljlResp> delete(MessCljlReq messCljl) {
//        messCljlSer.removeByEntity(messCljl);        
//        return ReturnEntityUtil.success(messCljl);            
//    }
    
}

