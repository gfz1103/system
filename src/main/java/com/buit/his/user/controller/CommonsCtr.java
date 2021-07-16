
package com.buit.his.user.controller;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import cn.hutool.core.date.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 通用API调用<br>
 * @author All
 */
@Api(tags="通用API调用")
@Controller
@RequestMapping("/commonsCtr")
public class CommonsCtr extends BaseSpringController{
    static final Logger logger = LoggerFactory.getLogger(CommonsCtr.class);
	/**
	 * 获取当前时间
	 * 
	 * @return
	 */
	@RequestMapping("/getCurrentDate")
	@ResponseBody
	@ApiOperationSupport(author = "汪洋")
	@ApiOperation(value = "获取当前时间", httpMethod = "POST", notes = "获取当前时间")
	public ReturnEntity<Long> getCurrentDate() {
		Date now = DateUtil.date().toSqlDate();
		return ReturnEntityUtil.success(now.getTime());
	}
}

