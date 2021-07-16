
package com.buit.his.sys.centermaintenance.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.constans.TableName;
import com.buit.his.sys.centermaintenance.model.OpSssd;
import com.buit.his.sys.centermaintenance.request.OpSssdReq;
import com.buit.his.sys.centermaintenance.service.OpSssdSer;
import com.buit.system.utill.ObjectToTypes;
import com.buit.utill.RedisFactory;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 所属时段<br>
 * @author GONGFANGZHOU
 */
@Api(tags="设备时段维护")
@Controller
@RequestMapping("/opsssd")
public class OpSssdCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(OpSssdCtr.class);
    
    @Autowired
    private OpSssdSer opSssdSer;
    
    @Autowired
    private RedisFactory redisFactory;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="设备时段分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OpSssd>> queryPage(PageQuery page){
        PageInfo<OpSssd> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> opSssdSer.findByEntity(null)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

  
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
	@ApiOperation(value="新增或修改" ,httpMethod="POST")
    public ReturnEntity <String> add(OpSssdReq opSssdReq) {
    	if(StrUtil.isNotBlank(ObjectToTypes.parseString(opSssdReq.getSssdid()))) {
    		opSssdSer.update(opSssdReq);        		
    	}else {
//    		opSssdReq.setSssdid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OP_SSSD));
    		opSssdSer.insert(opSssdReq);       
    	}
    	return ReturnEntityUtil.success();            
    }
    
}

