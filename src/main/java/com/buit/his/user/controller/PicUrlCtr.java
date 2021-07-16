
package com.buit.his.user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import com.buit.constans.RedisKeyHead;
import com.buit.file.FtpFileService;
import com.buit.his.sys.centermaintenance.dao.DicYljgDao;
import com.buit.his.sys.centermaintenance.model.DicYljg;
import com.buit.utill.ReturnEntityUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import com.buit.commons.BaseSpringController;
import com.buit.config.FileUploadConfig;
import com.buit.his.user.service.FileUploadSer;
import com.buit.utill.ReturnEntity;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 图片地址表<br>
 * @author All
 */
@Api(value="图片上传")
@Controller
@RequestMapping("/sys/picUrl")
public class PicUrlCtr  extends BaseSpringController {
	static final Logger logger = LoggerFactory.getLogger(PicUrlCtr.class);
	@Autowired
	private DicYljgDao dicYljgDao;
	@Autowired
	private FtpFileService ftpFileService;




	/** 新增 新增一张图片 数据不入库 */
	@RequestMapping("/add")
	@ResponseBody
	@ApiOperationSupport(author = "神算子")
	@ApiOperation(value = "新增一张图片", httpMethod = "POST")
	public ReturnEntity<List<String>> add(StandardMultipartHttpServletRequest multipartRequest) {
		ReturnEntity<List<String>> returnEntity  = new ReturnEntity<>();
		Map<String, MultipartFile> mapFile = multipartRequest.getFileMap();
		List<String> retList = new ArrayList<>();
		if (mapFile != null){
			mapFile.forEach((k, v) -> {
				try {
					String originalFilename = v.getOriginalFilename();
					String fileName = originalFilename.substring(originalFilename.lastIndexOf("."));
					String url = ftpFileService.uploadFile(RedisKeyHead.picUrl.getHeadKey(), UUID.randomUUID().toString()+fileName, v.getInputStream());
					retList.add(url);
				} catch (IOException e) {
					e.printStackTrace();
				}
			});
		}
		returnEntity.setData(retList);
		return returnEntity;
	}
	/** 新增 新增一张图片 数据不入库 */
	@RequestMapping("/delete")
	@ResponseBody
	@ApiOperationSupport(author = "神算子")
	@ApiOperation(value = "新增之前删除之前的logo", httpMethod = "POST")
	public ReturnEntity delete( @ApiParam(name = "path", value = "路径") @RequestParam(value = "path", required = true) String path) {
		if( path!=null&&!"".equals(path)&&path.contains("image")) {
			String[] images = path.split("image");
			String pathUrl="/image"+images[1];
			ftpFileService.deleteFile(pathUrl);
		}
		return ReturnEntityUtil.success();
	}

	public static void main(String[] args) {
		String url="http://192.168.102.252:7990/ftpuser//image/system/4c127880-3479-4c8c-bcfb-8b752a375c42.png";
		String[] images = url.split("image");
		for (String image : images) {
			System.out.println("/image"+image);
		}
	}


}
