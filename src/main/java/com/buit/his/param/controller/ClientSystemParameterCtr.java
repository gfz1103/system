package com.buit.his.param.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.param.request.CfgJqtdcsReq;
import com.buit.his.param.request.GyJqdcsSaveOrUpdateReq;
import com.buit.his.param.service.GyJqdcsCacheSerImp;
import com.buit.system.response.CfgJqtdcs;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 客户端系统参数配置
 * @ClassName: ClientSystemParameterCtr
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年7月16日 下午5:19:07
 *
 */
@Api(tags="客户端系统参数配置")
@Controller
@RequestMapping("/clientSystemParameter")
public class ClientSystemParameterCtr extends BaseSpringController{

	@Autowired
	private GyJqdcsCacheSerImp gyJqdcsCacheSer;
	
	@RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="客户端系统参数分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<CfgJqtdcs>> queryPage(CfgJqtdcsReq cfgJqtdcsReq,PageQuery page){
        PageInfo<CfgJqtdcs> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> gyJqdcsCacheSer.findByEntity(cfgJqtdcsReq)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
	
	@RequestMapping("/jqdcsSaveOrUpdate")
    @ResponseBody
    @ApiOperation(value="客户端系统参数新增修改" ,httpMethod="POST")
    public ReturnEntity <String> xtcsSaveOrUpdate(GyJqdcsSaveOrUpdateReq gyJqdcsSaveOrUpdateReq) {
		CfgJqtdcs cfgJqtdcs = gyJqdcsCacheSer.getByJgIdAndIpAndCsmc(getUser().getHospitalId(), 
    			gyJqdcsSaveOrUpdateReq.getIp(), gyJqdcsSaveOrUpdateReq.getCsm());
		gyJqdcsSaveOrUpdateReq.setJgid(getUser().getHospitalId());
    	if(cfgJqtdcs != null) {
    		BeanUtil.copyProperties(gyJqdcsSaveOrUpdateReq, cfgJqtdcs, 
    				CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    		if(StrUtil.isEmpty(gyJqdcsSaveOrUpdateReq.getSslb())) {
    			cfgJqtdcs.setSslb("");
    		}
			if(StrUtil.isEmpty(gyJqdcsSaveOrUpdateReq.getBz())) {
				cfgJqtdcs.setBz("");
			}
    		gyJqdcsCacheSer.update(cfgJqtdcs);
    	}else {
    		cfgJqtdcs = new CfgJqtdcs();
    		BeanUtil.copyProperties(gyJqdcsSaveOrUpdateReq, cfgJqtdcs, 
    				CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    		gyJqdcsCacheSer.insert(cfgJqtdcs);
    	}
        return ReturnEntityUtil.success();            
    }
 
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除客户端系统参数" ,httpMethod="POST")
    public ReturnEntity <String> delete(@ApiParam(name = "csmc", value = "参数名称", required = true) 
	@RequestParam String csmc,@ApiParam(name = "ip", value = "ip地址", required = true) 
	@RequestParam String ip) {
    	gyJqdcsCacheSer.delete(this.getUser().getHospitalId(), ip, csmc);
        return ReturnEntityUtil.success();            
    }
    
    @RequestMapping("/getOneByEntity")
    @ResponseBody
    @ApiOperation(value="查询单条客户端系统参数" ,httpMethod="POST")
    public ReturnEntity<CfgJqtdcs> getOneByEntity(@ApiParam(name = "csmc", value = "参数名称", required = true) 
	@RequestParam String csmc, @ApiParam(name = "ip", value = "ip地址", required = true) 
	@RequestParam String ip) {
    	CfgJqtdcs cfgJqtdcs = gyJqdcsCacheSer.getByJgIdAndIpAndCsmc(getUser().getHospitalId(), 
    			ip, csmc);
        return ReturnEntityUtil.success(cfgJqtdcs);            
    }
}
