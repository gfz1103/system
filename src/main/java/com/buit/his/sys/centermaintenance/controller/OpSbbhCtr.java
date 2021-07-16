
package com.buit.his.sys.centermaintenance.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.model.OpSbbh;
import com.buit.his.sys.centermaintenance.request.OpSbbhReq;
import com.buit.his.sys.centermaintenance.response.OpSbbhResp;
import com.buit.his.sys.centermaintenance.service.OpSbbhSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 设备编号表<br>
 * @author GONGFANGZHOU
 */
@Api(tags="设备编号表")
@Controller
@RequestMapping("/opsbbh")
public class OpSbbhCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(OpSbbhCtr.class);
    
    @Autowired
    private OpSbbhSer opSbbhSer;
    
    @Autowired
    private RedisFactory redisFactory;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="检查检验设备维护分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpSbbhResp>> queryPage(PageQuery page){
        PageInfo<OpSbbhResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> opSbbhSer.findByEntity(null)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
    
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    @ApiOperation(value="检查检验设备维护新增或修改" ,httpMethod="POST")
    public ReturnEntity<List<OpSbbhResp>> saveOrUpdate(OpSbbhReq opSbbhReq){
    	if(StrUtil.isNotBlank(ObjectToTypes.parseString(opSbbhReq.getBhid()))) {
    		opSbbhSer.update(opSbbhReq);
    	}else {
//    		opSbbhReq.setBhid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_SBBH));
    		opSbbhSer.insert(opSbbhReq);
    	}
        return ReturnEntityUtil.success();    
    }
    
    @RequestMapping("/getOneByEntity")
    @ResponseBody
    @ApiOperation(value="查询单条设备记录" ,httpMethod="POST")
    public ReturnEntity<OpSbbh> getOneByEntity(@ApiParam(name = "bhId", value = "编号id", required = true) 
	@RequestParam Integer bhId){
        return ReturnEntityUtil.success(opSbbhSer.getById(bhId));
    }
    
    @RequestMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value="根据主键删除" ,httpMethod="POST")
    public ReturnEntity <String> deleteById(@ApiParam(name = "bhId", value = "编号id", required = true) 
	@RequestParam Integer bhId){
    	opSbbhSer.deleteById(bhId);
        return ReturnEntityUtil.success();
    }
    
    @RequestMapping("/generateSbhy")
    @ResponseBody
    @ApiOperation(value="生成未来30天号源" ,httpMethod="POST")
    public ReturnEntity <String> generateSbhy(@ApiParam(name = "bhId", value = "编号id", required = false) 
	@RequestParam(value = "bhId", required = false ) Integer bhId){
    	opSbbhSer.doGenerateSbhy(bhId);
        return ReturnEntityUtil.success();
    }
}

