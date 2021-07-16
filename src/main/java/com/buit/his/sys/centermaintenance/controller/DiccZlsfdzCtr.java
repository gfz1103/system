
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
import com.buit.his.sys.centermaintenance.service.DiccZlsfdzSer;
import com.buit.system.response.LoadSqdDetailInfoResp;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 诊疗收费对照<br>
 * 
 * @author 老花生
 */
@Api(tags = "诊疗项目维护-诊疗收费对照")
@Controller
@RequestMapping("/dicczlsfdz")
public class DiccZlsfdzCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(DiccZlsfdzCtr.class);

	@Autowired
	private DiccZlsfdzSer diccZlsfdzSer;

//    @RequestMapping("/queryPage")
//    @ResponseBody
//    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
//    public ReturnEntity<PageInfo<DiccZlsfdzResp>> queryPage(DiccZlsfdzReq dicczlsfdz,PageQuery page){
//        PageInfo<DiccZlsfdz> pageInfo = PageHelper.startPage(
//            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
//                    () -> diccZlsfdzSer.findByEntity(dicczlsfdz)
//            );
//        return ReturnEntityUtil.success(pageInfo);
//    }
//    
//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<DiccZlsfdzResp>> getByEntity( DiccZlsfdzReq dicczlsfdz){//@RequestBody 
//        return ReturnEntityUtil.success(diccZlsfdzSer.findByEntity(dicczlsfdz));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<DiccZlsfdzResp> getOneByEntity(DiccZlsfdzReq dicczlsfdz){
//        List<DiccZlsfdz> list=diccZlsfdzSer.findByEntity(dicczlsfdz);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }
//    
	/** 查询医技预病人申请单详细信息(sqdManageService.loadSqdDetailInfo) */
	@RequestMapping("/loadSqdDetailInfo")
	@ResponseBody
	@ApiOperation(value = "查询医技预病人申请单详细信息", httpMethod = "POST")
	public ReturnEntity<List<LoadSqdDetailInfoResp>> loadSqdDetailInfo(
			@ApiParam(name = "type", value = "申请类型", required = true) @RequestParam Integer type,
			@ApiParam(name = "jcxh", value = "检查序号", required = true) @RequestParam Integer jcxh) {
		return ReturnEntityUtil.success(diccZlsfdzSer.loadSqdDetailInfo(type, jcxh));
	}

}
