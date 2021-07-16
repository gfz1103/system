
package com.buit.his.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.his.user.model.SysGroup;
import com.buit.his.user.request.SysGroupReq;
import com.buit.his.user.response.SysGroupResp;
import com.buit.his.user.service.SysGroupSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 用户组表<br>
 * @author wangyang
 */
@Api(tags = "用户组表")
@Controller
@RequestMapping("/sys/sysgroup")
public class SysGroupCtr extends BaseSpringController {

	static final Logger logger = LoggerFactory.getLogger(SysGroupCtr.class);

	@Autowired
	private SysGroupSer sysGroupSer;

	@RequestMapping("/queryPage")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "按条件分页查询", httpMethod = "POST", notes = "分页查询岗位列表")
	public ReturnEntity<PageInfo<SysGroupResp>> queryPage(
			@ApiParam(name = "groupName", value = "岗位名称") @RequestParam(value = "groupName", required = false) String groupName,
			@ApiParam(name = "stopFlag", value = "查询标识：查询启用菜单传：0") @RequestParam(value = "stopFlag", required = false) String stopFlag,
			PageQuery page) {
		SysGroup sysgroup = new SysGroup();
		sysgroup.setHospitalId(getUser().getHospitalId());
		sysgroup.setGroupName(groupName);
		sysgroup.setSortColumns("GROUP_SEQ asc");
		if(!"".equals(stopFlag) && stopFlag != null) {
			sysgroup.setStopFlag(stopFlag);
		}
		PageInfo<SysGroupResp> pageInfo = PageHelper.startPage(page.getPageNum(), page.getPageSize())
				.doSelectPageInfo(() -> sysGroupSer.findByEntity(sysgroup));
		return ReturnEntityUtil.success(pageInfo);
	}

	@RequestMapping("/findList")
	@ResponseBody
	@ApiOperation(value = "有效岗位角色列表", httpMethod = "POST")
	public ReturnEntity<List<SysGroup>> getByEntity() {
		SysGroup sysGroup =new SysGroup();
		sysGroup.setStopFlag("0");
		return ReturnEntityUtil.success(sysGroupSer.findByEntity(sysGroup));
	}

	@RequestMapping("/getOneByEntity")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "按条件查询-返回唯一值", httpMethod = "POST", notes = "修改岗位时数据查询")
	public ReturnEntity<SysGroupResp> getOneByEntity(
			@ApiParam(name = "groupId", value = "用户组ID", required = true) @RequestParam(value = "groupId") Integer groupId) {
		SysGroup sysGroup = sysGroupSer.getById(groupId);
		if (sysGroup != null) {
			SysGroupResp resp = new SysGroupResp();
			BeanUtils.copyProperties(sysGroup, resp);
			return ReturnEntityUtil.success(resp);
		}
		return ReturnEntityUtil.success();
	}

	/** 新增 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "新增", httpMethod = "POST", notes = "新增岗位")
	public ReturnEntity <String> add(@Valid SysGroupReq sysGroup) {
		sysGroup.setHospitalId(getUser().getHospitalId());
		sysGroupSer.save(sysGroup);
		return ReturnEntityUtil.success();
	}

	/** 编辑 */
	@RequestMapping("/edit")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "编辑", httpMethod = "POST", notes = "修改岗位")
	public ReturnEntity <String> edit(SysGroupReq sysGroup) {
		sysGroup.setHospitalId(getUser().getHospitalId());
		sysGroupSer.edit(sysGroup);
		return ReturnEntityUtil.success();
	}

	/** 停用 */
	@RequestMapping("/editEnable")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "停用", httpMethod = "POST", notes = "停用岗位")
	public ReturnEntity<SysGroupResp> editEnable(
			@ApiParam(name = "groupId", value = "用户组ID", required = true) @RequestParam(value = "groupId") Integer groupId,
			@ApiParam(name = "stopFlag", value = "停用标识  0:启用，1:禁用", required = true) @RequestParam(value = "stopFlag") String stopFlag) {
		sysGroupSer.getEntityMapper().editEnable(groupId, stopFlag);
		return ReturnEntityUtil.success();
	}

    
    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity<String> delete(@ApiParam(name = "groupId", value = "组ID", required = true) @RequestParam(value = "groupId") Integer groupId) {
        sysGroupSer.removeById(groupId);        
        return ReturnEntityUtil.success();            
    }
	/**
	 * 取排序最大值
	 */
    @PostMapping("/getMaxSort")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="取排序最大值" ,httpMethod="POST")
    public ReturnEntity<Long> getMaxSort() {
    	Long maxSort= sysGroupSer.getEntityMapper().getMaxSort();    
    	if(maxSort==null) {
    		maxSort=0L;
    	}
    	maxSort=maxSort+1;
        return ReturnEntityUtil.success(maxSort);            
    }
    
	/**
	 * 验证岗位编码重复
	 * 
	 * @param groupCode
	 * @return
	 */
	@RequestMapping("/validGroupCode")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "验证岗位编码重复", notes = "验证岗位编码重复", httpMethod = "POST")
	public ReturnEntity<Boolean> validGroupCode(
			@ApiParam(name = "groupCode", value = "岗位编码", required = true) @RequestParam(name = "groupCode") String groupCode) {
		boolean isValid = sysGroupSer.validGroupCode(groupCode, getUser().getHospitalId());
		return ReturnEntityUtil.success(isValid);
	}

}
