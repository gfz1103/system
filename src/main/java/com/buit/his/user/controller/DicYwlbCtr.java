package com.buit.his.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import com.buit.system.model.SysYwqxkz;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.his.user.model.DicYwlb;
import com.buit.his.user.model.HrPersonnel;
import com.buit.his.user.model.SysGroup;
import com.buit.his.user.response.BusinessAuth;
import com.buit.his.user.response.DicYwlbTabelResp;
import com.buit.his.user.service.DicYwlbSer;
import com.buit.his.user.service.HrPersonnelSer;
import com.buit.his.user.service.SysGroupSer;
import com.buit.his.user.service.SysYwqxkzSer;
import com.buit.system.model.SysYwqxkz;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 业务类别表<br>
 * @author WENGL
 */
@Api(tags="业务类别")
@Controller
@RequestMapping("/dicywlb")
public class DicYwlbCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(DicYwlbCtr.class);
    
    @Autowired
    private DicYwlbSer dicYwlbSer;
    @Autowired
    private HrPersonnelSer hrPersonnelSer;
    @Autowired
	private SysGroupSer sysGroupSer;
    @Autowired
    private SysYwqxkzSer sysYwqxkzSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<DicYwlb>> queryPage(PageQuery page){
    	DicYwlb dicywlb=new DicYwlb ();
    	dicywlb.setHospitaId(getUser().getHospitalId());
        PageInfo<DicYwlb> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> dicYwlbSer.findByEntity(dicywlb)
            );
        return ReturnEntityUtil.success(pageInfo);
    }

//  @RequestMapping("/getOneByID")
//  @ResponseBody
//  @ApiOperation(value="按主键查询" ,httpMethod="POST")
//  public ReturnEntity<DicYwlb> getOneByEntity(@ApiParam(name = "btId", value = "主键") @RequestParam(value = "btId")  Integer btId){
//      return ReturnEntityUtil.success( dicYwlbSer.getById(btId));
//  }
    
    @RequestMapping("/findList")
    @ResponseBody
    @ApiOperation(value="所有类型列表" ,notes = "岗位角色管理编辑时使用",httpMethod="POST")
    public ReturnEntity<List<DicYwlb>> getByEntity(){ 
    	DicYwlb dicywlb=new DicYwlb ();
    	dicywlb.setHospitaId(getUser().getHospitalId());
        return ReturnEntityUtil.success(dicYwlbSer.findByEntity(dicywlb));    
    }
    @RequestMapping("/findbtIdByUserId")
    @ResponseBody
    @ApiOperation(value="根据人员ID取权限" ,notes = "岗位角色管理编辑时使用",httpMethod="POST")
    public ReturnEntity<List<Integer>> findbtIdByUserId(@ApiParam(name = "personid", value = "人员ID") @RequestParam(value = "personid") Integer personid){
        List<Integer> list = dicYwlbSer.getEntityMapper().findbtIdByUserId(personid);
        boolean ysz = list.stream().filter(Objects::nonNull).anyMatch(o -> 6 == o);
        boolean hsz = list.stream().filter(Objects::nonNull).anyMatch(o -> 1 == o);
        if(ysz && !hsz){
            list.add(1);
        }
    	return ReturnEntityUtil.success(list);
    }
    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<DicYwlb> add(DicYwlb dicYwlb,HttpServletRequest request) {
    	dicYwlb.setHospitaId(getUser().getHospitalId());
        dicYwlbSer.add(dicYwlb);        
        return ReturnEntityUtil.success(dicYwlb);
    }
    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity<DicYwlb> edit(DicYwlb dicYwlb)  {
        dicYwlbSer.edit(dicYwlb);        
        return ReturnEntityUtil.success(dicYwlb);            
    }
    /** 取业务表信息 */
    @RequestMapping("/getTableinfo")
    @ResponseBody
    @ApiOperation(value="业务表信息" ,httpMethod="POST")
    public ReturnEntity<List<DicYwlbTabelResp>>  getTableinfo()  {
        return ReturnEntityUtil.success(dicYwlbSer.getTableinfo());            
    }
    /** 删除 */
    @RequestMapping("/delete")
    @ResponseBody
    @ApiOperation(value="删除" ,httpMethod="POST")
    public ReturnEntity<String> delete(@ApiParam(name = "btId", value = "主键") @RequestParam(value = "btId")  Integer btId) {
        dicYwlbSer.removeById(btId);;        
        return ReturnEntityUtil.success();            
    }
    
    /** 查询用户列表 */
    @RequestMapping("/queryPersonalPage")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="按条件分页查询员工信息" ,httpMethod="POST")
    public ReturnEntity<PageInfo<HrPersonnel>> queryPersonalPage(@ApiParam(name = "searchPharm", value = "查询条件") @RequestParam(value = "searchPharm",required = false)  String searchPharm,
    		@ApiParam(name = "groupId", value = "岗位角色ID") @RequestParam(value = "groupId",required = false) Integer groupId,
    		PageQuery page){  	    	
    	HrPersonnel hrpersonnel=new HrPersonnel ();
    	hrpersonnel.setPersonname(searchPharm);
    	hrpersonnel.setOrganizcode(getUser().getHospitalId());
    	hrpersonnel.setLogoff("0");
    	hrpersonnel.setSortColumns("LASTMODIFYDATE DESC");
    	if(groupId==null) {
    		hrpersonnel.setHaveGroup(1);
    	}else {
    		hrpersonnel.setGroupId(groupId);	
    	}
        PageInfo<HrPersonnel> pageInfo = PageHelper.startPage(
            page.getPageNum(), page.getPageSize()).doSelectPageInfo(
                    () -> hrPersonnelSer.findByEntity(hrpersonnel)
            );
        return ReturnEntityUtil.success(pageInfo);
    }
    
    /** 根据btId取所有业务权限 */
    @RequestMapping("/getAuthList")
    @ResponseBody
    @ApiOperation(value="btId取所有业务权限" ,httpMethod="POST")
    public ReturnEntity<List<BusinessAuth>>  getAuthList(@ApiParam(name = "btId", value = "主键") @RequestParam(value = "btId")  Integer btId)  {
    	dicYwlbSer.getById(btId);
    	Map<String, Object> parameter = new HashMap<>();
        parameter.put("hospitalId",getUser().getHospitalId());
        parameter.put("sql",dicYwlbSer.getById(btId).getBtSql());
        List<BusinessAuth> ret=dicYwlbSer.getEntityMapper().queryBusinessAuth(parameter);
        return ReturnEntityUtil.success(ret);            
    }
    
    /** 查询用户列表 */
    @RequestMapping("/getAuthority")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="取业务权限列表" ,httpMethod="POST")
    public  ReturnEntity<List<BusinessAuth>> getAuthority( @ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId){
    	List<BusinessAuth> ret=dicYwlbSer.getAuthority(getUser().getUserId(),groupId);
        return ReturnEntityUtil.success(ret);
    }
    /** 取用户默认权限 */
    @RequestMapping("/getmorenAuthority")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value="取用户默认权限" ,httpMethod="POST")
    public  ReturnEntity<Integer> getmorenAuthority(@ApiParam(name = "groupId", value = "角色ID", required = true) @RequestParam(value = "groupId")  Integer groupId){
    	SysGroup sysGroup =sysGroupSer.getById(groupId);
    	SysUser sysUser=getUser();
    	if(sysGroup.getBtId()!=null) {
    		SysYwqxkz sysYwqxkz=new SysYwqxkz ();
    		sysYwqxkz.setYgdm(sysUser.getUserId());
    		sysYwqxkz.setJgid(sysUser.getHospitalId());
    		sysYwqxkz.setYwlb(sysGroup.getBtId());
    		Integer moren=sysYwqxkzSer.getEntityMapper().getmorenAuthority(sysYwqxkz);
    		return ReturnEntityUtil.success(moren);
    	}
    	return ReturnEntityUtil.success();
    }
}

