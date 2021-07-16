
package com.buit.his.dic.controller;

import com.buit.commons.BaseSpringController;
import com.buit.commons.PageQuery;
import com.buit.commons.SysUser;
import com.buit.his.dic.model.SysDictConfig;
import com.buit.his.dic.request.SysDictConfigAddReq;
import com.buit.his.dic.request.SysDictConfigEditReq;
import com.buit.his.dic.request.SysDictConfigPageReq;
import com.buit.his.dic.response.Maindic;
import com.buit.his.dic.response.RegionResp;
import com.buit.his.dic.response.Sondic;
import com.buit.his.dic.response.SysDictConfigPageResp;
import com.buit.his.dic.service.SysDictConfigSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.pagehelper.PageInfo;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 字典配置<br>
 * @author All
 */
@Api(tags="业务字典配置")
@Controller
@RequestMapping("/sysdictconfig")
public class SysDictConfigCtr extends BaseSpringController{
    
    static final Logger logger = LoggerFactory.getLogger(SysDictConfigCtr.class);
    
    @Autowired
    private SysDictConfigSer sysDictConfigSer;
    
    @RequestMapping("/queryPage")
    @ResponseBody
	@ApiOperationSupport(author = "MLeo")
    @ApiOperation(value="按条件分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<SysDictConfigPageResp>> queryPage(SysDictConfigPageReq req){
		SysUser user = getUser();
		PageInfo<SysDictConfigPageResp> pageInfo = sysDictConfigSer.page(user,req);
        return ReturnEntityUtil.success(pageInfo);
    }

	/**
	 * SQL查询结果
	 * @param id
	 * @param page
	 * @return
	 */
	@RequestMapping("/detail/queryPage/{id}")
    @ResponseBody
	@ApiOperationSupport(author = "MLeo")
    @ApiOperation(value="字典详情分页查询" ,httpMethod="POST")
    public ReturnEntity<PageInfo<Sondic>> detailPage(@PathVariable("id") Integer id, PageQuery page){
		PageInfo<Sondic> pageInfo = sysDictConfigSer.detailPage(id,getUser(),page);
        return ReturnEntityUtil.success(pageInfo);
    }



//    @RequestMapping("/findList")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回列表" ,httpMethod="POST")
//    public ReturnEntity<List<SysDictConfigResp>> getByEntity( SysDictConfigReq sysdictconfig){//@RequestBody 
//        return ReturnEntityUtil.success(sysDictConfigSer.findByEntity(sysdictconfig));    
//    }
//    
//    @RequestMapping("/getOneByEntity")
//    @ResponseBody
//    @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//    public ReturnEntity<SysDictConfigResp> getOneByEntity(SysDictConfigReq sysdictconfig){
//        List<SysDictConfig> list=sysDictConfigSer.findByEntity(sysdictconfig);
//        if(list.size()>0){
//           return ReturnEntityUtil.success(list.get(0));    
//        }
//        return ReturnEntityUtil.success();
//    }



    /** 新增 */
    @RequestMapping("/add")
    @ResponseBody
	@ApiOperationSupport(author = "MLeo")
    @ApiOperation(value="新增" ,httpMethod="POST")
    public ReturnEntity<Integer> add(@Valid SysDictConfigAddReq req) {
    	SysUser user = getUser();
        Integer id = sysDictConfigSer.add(user,req);
        return ReturnEntityUtil.success(id);
    }



    /** 编辑 */
    @RequestMapping("/edit")
    @ResponseBody
	@ApiOperationSupport(author = "MLeo")
    @ApiOperation(value="编辑" ,httpMethod="POST")
    public ReturnEntity edit(@Valid SysDictConfigEditReq req)  {
		SysUser user = getUser();
        sysDictConfigSer.edit(user,req);
        return ReturnEntityUtil.success();
    }

    /** 停用 */
    @RequestMapping("/stop/{id}")
    @ResponseBody
	@ApiOperationSupport(author = "MLeo")
    @ApiOperation(value="停用" ,httpMethod="POST")
    public ReturnEntity stop(@PathVariable Integer id)  {
		SysUser user = getUser();
        sysDictConfigSer.stop(id);
        return ReturnEntityUtil.success();
    }


    /** 启用 */
    @RequestMapping("/enable/{id}")
    @ResponseBody
	@ApiOperationSupport(author = "MLeo")
    @ApiOperation(value="启用" ,httpMethod="POST")
    public ReturnEntity enable(@PathVariable Integer id)  {
		SysUser user = getUser();
        sysDictConfigSer.enable(id);
        return ReturnEntityUtil.success();
    }


//    
//    /** 删除 */
//    @RequestMapping("/delete")
//    @ResponseBody
//    @ApiOperation(value="按条件查询" ,httpMethod="POST")
//    public ReturnEntity<SysDictConfigResp> delete(SysDictConfigReq sysDictConfig) {
//        sysDictConfigSer.removeByEntity(sysDictConfig);        
//        return ReturnEntityUtil.success(sysDictConfig);            
//    }
    
    @RequestMapping("/getAllDic")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "业务字典",notes = "1)前台加载业务字典项</br>2)每个主项目的数据版本号</br>3)前后台每次使用会确认版本号", httpMethod = "POST")
	public ReturnEntity<List<Maindic>> getAllDic() {
    	Map<String, Object> part=new HashMap<>(3);
    	part.put("hospitalId", getUser().getHospitalId());
		List<SysDictConfig> listMain = sysDictConfigSer.findByEntity(null);
		if(listMain.size()==0) {
			return ReturnEntityUtil.success();
    	}
		List<Maindic> retList = new ArrayList<>();
		for (SysDictConfig mainData : listMain) {
			Maindic maindic = new Maindic();
			maindic.setDk(mainData.getDictId().toString());
			maindic.setDname(mainData.getDictCode());
			maindic.setDversion(mainData.getDataVersion());
			retList.add(maindic);
			part.put("sql", mainData.getQuerySql());
			List<Sondic> resonList =sysDictConfigSer.getEntityMapper().runSondic(part);
			maindic.setSon(resonList);
		}
		return ReturnEntityUtil.success(retList);
	}
    
    @RequestMapping("/getNewData")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    @ApiOperation(value = "取最新数据",notes = "1)根据客户版本号判断是否有更新</br>2)如果无更新data节点空</br>3)如果有更新data节点,是最新数据", httpMethod = "POST" )
	public ReturnEntity<Maindic> getNewData(@ApiParam(name = "dk", value = "字典ID", required = true) @RequestParam(value = "dk")  Integer dk,
			@ApiParam(name = "dversion", value = "版本号", required = true) @RequestParam(value = "dversion")  Integer dversion) {
    	SysDictConfig mainData = sysDictConfigSer.getById(dk);
    	Maindic maindic = new Maindic();
    	if(mainData == null) {
    		return ReturnEntityUtil.success(maindic);
    	}
    	List<Maindic> retList = new ArrayList<>();
    	retList.add(maindic);
		//如果版本相同返回数据
		//这里可以使用缓存 暂时不写
		if(dversion.equals(mainData.getDataVersion())){
			return ReturnEntityUtil.success(maindic);
		}
		Map<String, Object> part=new HashMap<>(3);
    	part.put("hospitalId", getUser().getHospitalId());
		maindic.setDk(mainData.getDictId().toString());
		maindic.setDname(mainData.getDictCode());
		maindic.setDversion(mainData.getDataVersion());
		part.put("sql", mainData.getQuerySql());
		List<Sondic> resonList =sysDictConfigSer.getEntityMapper().runSondic(part);
		maindic.setSon(resonList);
		return ReturnEntityUtil.success(maindic);
	}

	@RequestMapping("/getRegion")
	@ResponseBody
	@ApiOperationSupport(author = "jiangwei")
	@ApiOperation(value = "行政区划(新版)", httpMethod = "POST")
	public ReturnEntity<List<RegionResp>> getLatestRegion() {
		return ReturnEntityUtil.success(sysDictConfigSer.getEntityMapper().getLatestRegion("1.0"));
	}

	@RequestMapping("/getAllRegion")
	@ResponseBody
	@ApiOperationSupport(author = "jiangwei")
	@ApiOperation(value = "行政区划(合并版)", httpMethod = "POST")
	public ReturnEntity<List<RegionResp>> getAllRegion() {
		return ReturnEntityUtil.success(sysDictConfigSer.getEntityMapper().getAllRegion());
	}
}

