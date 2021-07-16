
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
import com.buit.his.sys.centermaintenance.model.ImDicYpyfFjjf;
import com.buit.his.sys.centermaintenance.request.ImDicYpyfFjjfReq;
import com.buit.his.sys.centermaintenance.response.ImDicYpyfFjjfResp;
import com.buit.his.sys.centermaintenance.service.ImDicYpyfFjjfSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.util.StrUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 住院_药品用法_附加计费<br>
 * @author GONGFANGZHOU
 */
@Api(tags="住院_药品用法_附加计费")
@Controller
@RequestMapping("/imdicypyffjjf")
public class ImDicYpyfFjjfCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(ImDicYpyfFjjfCtr.class);
    
    @Autowired
    private ImDicYpyfFjjfSer imDicYpyfFjjfSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="药品用法附加计费-按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<ImDicYpyfFjjfResp>> queryPage(ImDicYpyfFjjfReq imdicypyffjjf,PageQuery page){
    	imdicypyffjjf.setJgid(this.getUser().getHospitalId());
    	PageInfo<ImDicYpyfFjjfResp> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> imDicYpyfFjjfSer.findByEntity(imdicypyffjjf)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

    @RequestMapping("/getById")
    @ResponseBody
    @ApiOperation(value="药品用法附加计费返回唯一值" ,httpMethod="POST")
    public ReturnEntity<ImDicYpyfFjjf> getById(@ApiParam(name = "id", value = "主键id", required = true)
    @RequestParam Integer id){
        return ReturnEntityUtil.success(imDicYpyfFjjfSer.getById(id));
    }
  
    /** 新增 */
    @RequestMapping("/saveOrUpdate")
    @ResponseBody
    @ApiOperation(value="新增或修改药品用法附加计费" ,httpMethod="POST")
    public ReturnEntity saveOrUpdate(ImDicYpyfFjjfReq imDicYpyfFjjf) {
    	imDicYpyfFjjf.setJgid(this.getUser().getHospitalId());
    	if(StrUtil.isBlankIfStr(imDicYpyfFjjf.getId())) {
    		imDicYpyfFjjfSer.insert(imDicYpyfFjjf);        
    	}else {
    		imDicYpyfFjjfSer.update(imDicYpyfFjjf);        
    	}     
        return ReturnEntityUtil.success(imDicYpyfFjjf);            
    }
 
    /** 删除 */
    @RequestMapping("/deleteById")
    @ResponseBody
    @ApiOperation(value="根据主键删除" ,httpMethod="POST")
    public ReturnEntity deleteById(@ApiParam(name = "id", value = "主键id", required = true)
    @RequestParam Integer id) {
        imDicYpyfFjjfSer.removeById(id); 
        return ReturnEntityUtil.success();            
    }
    
}

