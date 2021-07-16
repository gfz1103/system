
package com.buit.his.sys.centermaintenance.controller;

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
import com.buit.his.sys.centermaintenance.model.OptMzfs;
import com.buit.his.sys.centermaintenance.request.FeeYlsfxmYlReq;
import com.buit.his.sys.centermaintenance.request.OptMzfsReq;
import com.buit.his.sys.centermaintenance.response.FeeYlsfxmResp;
import com.buit.his.sys.centermaintenance.service.FeeYlsfxmSer;
import com.buit.his.sys.centermaintenance.service.OptMzfsSer;
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
 * <br>
 * @author GONGFANGZHOU
 */
@Api(tags="手术麻醉方式维护")
@Controller
@RequestMapping("/optmzfs")
public class OptMzfsCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(OptMzfsCtr.class);
    
    @Autowired
    private OptMzfsSer optMzfsSer;
    
    @Autowired
    private RedisFactory redisFactory;
    
    @Autowired
    private FeeYlsfxmSer feeYlsfxmSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="手术麻醉方式-分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<OptMzfs>> queryPage(@ApiParam(name = "pydm", value = "拼音代码", required = false) 
    @RequestParam(value = "pydm", required = false ) String pydm,PageQuery page){
    	OptMzfs optMzfs = new OptMzfs();
    	if(StrUtil.isNotBlank(pydm)) {
    		optMzfs.setPydm(pydm);
    	}
        PageInfo<OptMzfs> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> optMzfsSer.findByEntity(optMzfs)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
    
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    @ApiOperation(value="手术麻醉方式新增或保存" ,httpMethod="POST")
    public ReturnEntity <String> saveOrUpdate(OptMzfsReq optMzfsReq){
    	if(StrUtil.isNotBlank(ObjectToTypes.parseString(optMzfsReq.getMzid()))) {
    		optMzfsSer.update(optMzfsReq);
    	}else {
//    		optMzfsReq.setMzid(redisFactory.getTableKey(TableName.DB_NAME, TableName.OPT_MZFS));
    		optMzfsSer.insert(optMzfsReq);
    	}
        return ReturnEntityUtil.success();    
    }
    
    @RequestMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value="手术麻醉方式删除" ,httpMethod="POST")
    public ReturnEntity <String> deleteById(@ApiParam(name = "mzId", value = "门诊id", required = true) 
	@RequestParam Integer mzId){
    	optMzfsSer.removeById(mzId);
        return ReturnEntityUtil.success();    
    }
    
    
    @RequestMapping("/querySurgicalItems")
    @ResponseBody
    @ApiOperation(value="手术信息维护-分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<FeeYlsfxmResp>> querySurgicalItems(FeeYlsfxmYlReq feeYlsfxmYlReq,PageQuery page){
    	feeYlsfxmYlReq.setFygb(19);
        PageInfo<FeeYlsfxmResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> feeYlsfxmSer.getEntityMapper().querySurgicalItems(feeYlsfxmYlReq)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
    


    
}

