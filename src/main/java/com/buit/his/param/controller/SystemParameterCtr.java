package com.buit.his.param.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.param.request.SysXtcsQueryReq;
import com.buit.his.param.request.SysXtcsSaveOrUpdateReq;
import com.buit.his.param.service.SysXtcsCacheSerImp;
import com.buit.his.param.service.SysXtcsSerImp;
import com.buit.system.response.SysXtcs;
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
 * 系统参数配置
 * @ClassName: SystemParameterCtr
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author 龚方舟
 * @date 2020年7月16日 下午5:19:07
 *
 */
@Api(tags="系统参数配置")
@Controller
@RequestMapping("/systemParameter")
public class SystemParameterCtr extends BaseSpringController{

	@Autowired
	private SysXtcsCacheSerImp sysXtcsCacheSer;
	
	@Autowired
	private SysXtcsSerImp sysXtcsSer;
	
	@RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="系统参数分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysXtcs>> queryPage(SysXtcsQueryReq sysXtcsQueryReq,PageQuery page){
		sysXtcsQueryReq.setJgid(this.getUser().getHospitalId());
        PageInfo<SysXtcs> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> sysXtcsSer.findByEntity(sysXtcsQueryReq)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
	
	@RequestMapping("/xtcsSaveOrUpdate")
    @ResponseBody
    @ApiOperation(value="系统参数新增修改" ,httpMethod="POST")
    public ReturnEntity <String> xtcsSaveOrUpdate(SysXtcsSaveOrUpdateReq sysXtcsSaveOrUpdateReq) {
    	SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(getUser().getHospitalId(), 
    			sysXtcsSaveOrUpdateReq.getCsmc());
    	sysXtcsSaveOrUpdateReq.setJgid(getUser().getHospitalId());
    	if(sysXtcs != null) {
    		BeanUtil.copyProperties(sysXtcsSaveOrUpdateReq, sysXtcs, 
    				CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    		if(StrUtil.isEmpty(sysXtcsSaveOrUpdateReq.getSslb())) {
    			sysXtcs.setSslb("");
    		}
			if(StrUtil.isEmpty(sysXtcsSaveOrUpdateReq.getBz())) {
				sysXtcs.setBz("");
			}
			if(StrUtil.isEmpty(sysXtcsSaveOrUpdateReq.getXxsm())) {
				sysXtcs.setXxsm("");
			}
    		sysXtcsCacheSer.update(sysXtcs);
    	}else {
    		sysXtcs = new SysXtcs();
    		BeanUtil.copyProperties(sysXtcsSaveOrUpdateReq, sysXtcs, 
    				CopyOptions.create().setIgnoreNullValue(true).setIgnoreError(true));
    		sysXtcsCacheSer.insert(sysXtcs);
    	}
        return ReturnEntityUtil.success();            
    }
 
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除系统参数" ,httpMethod="POST")
    public ReturnEntity <String> delete(@ApiParam(name = "csmc", value = "参数名称", required = true) 
	@RequestParam String csmc) {
    	sysXtcsCacheSer.delete(this.getUser().getHospitalId(), csmc);
        return ReturnEntityUtil.success();            
    }
    
    @RequestMapping("/getOneByEntity")
    @ResponseBody
    @ApiOperation(value="查询单条系统参数" ,httpMethod="POST")
    public ReturnEntity<SysXtcs> getOneByEntity(@ApiParam(name = "csmc", value = "参数名称", required = true) 
	@RequestParam String csmc) {
    	SysXtcs sysXtcs = sysXtcsCacheSer.getByJGIdAndCsmc(getUser().getHospitalId(), csmc);
        return ReturnEntityUtil.success(sysXtcs);            
    }
}
