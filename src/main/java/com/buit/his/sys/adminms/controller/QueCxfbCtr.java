//
//package com.buit.his.sys.adminms.controller;
//
//import java.io.PrintWriter;
//import java.util.List;
//import java.util.Map;
//
//import javax.servlet.http.HttpServletResponse;
//
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.defaults.DefaultSqlSessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import com.buit.commons.BaseSpringController;
//import com.buit.his.sys.adminms.model.QueCxfb;
//import com.buit.his.sys.adminms.service.QueCxfbSer;
//import com.buit.utill.ReturnEntity;
//import com.buit.utill.ReturnEntityUtil;
//import com.github.pagehelper.PageHelper;
//import com.github.pagehelper.PageInfo;
//
//import cn.hutool.core.collection.CollectionUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import io.swagger.annotations.ApiParam;
//
///**
// * 查询发布<br>
// *
// * @author 神算子
// */
//@Api(tags = "通用查询")
//@Controller
//@RequestMapping("/quecxfb")
//public class QueCxfbCtr extends BaseSpringController {
//
//	static final Logger logger = LoggerFactory.getLogger(QueCxfbCtr.class);
//
//	@Autowired
//	private QueCxfbSer queCxfbSer;
//	@Autowired
//	DefaultSqlSessionFactory sessionFactory;
//
//	/** 分布查询 */
//	@RequestMapping("/queryPage")
//	@ResponseBody
//	@ApiOperation(value = "分页查询", notes = "enName,pageNum,pageSize 为必输项", httpMethod = "POST")
//	public ReturnEntity<PageInfo<List<Map<String, Object>>>> queryPage(@RequestParam Map<String, Object> params) {
//		String enName = params.get("enName").toString();
//		String pageNum = params.get("pageNum").toString();
//		String pageSize = params.get("pageSize").toString();
//		params.remove("enName");
//		params.remove("pageNum");
//		params.remove("pageSize");
//		params.put("_sysuser", getUser());
//
////	  Iterator<Map.Entry<String,String>> iterator = params.entrySet().iterator();
////	  System.out.println("---------------------------------------");
////      while (iterator.hasNext()){
////          Map.Entry<String,String> entry = iterator.next();
////          System.out.println(entry.getKey()+"="+entry.getValue()+" type="+entry.getValue().getClass());
////      }
////      System.out.println("---------------------------------------");
//		try (SqlSession sqlSession = sessionFactory.openSession(true)) {
//			PageInfo<List<Map<String, Object>>> pageInfo = PageHelper
//					.startPage(Integer.valueOf(pageNum), Integer.valueOf(pageSize)).doSelectPageInfo(
//							() -> sqlSession.selectList("com.buit.design.query." + enName + ".query", params));
//			return ReturnEntityUtil.success(pageInfo);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			//这个抛错 开发时才会触发,上线后不会触发
//			return	ReturnEntityUtil.error("EA002",e.getMessage());
//		}
//
//	}
//
//	@RequestMapping("/findList")
//	@ResponseBody
//	@ApiOperation(value = "不分页查询", httpMethod = "POST")
//	public ReturnEntity<List<Map<String, Object>>> getByEntity(@RequestParam Map<String, Object> params) {
//		String enName = params.get("enName").toString();
//		params.remove("enName");
//		params.put("_sysuser", getUser());
//		List<Map<String, Object>> list =null;
//		try (SqlSession sqlSession = sessionFactory.openSession(true)) {
//			list=sqlSession.selectList("com.buit.design.query." + enName + ".query", params);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			//这个抛错 开发时才会触发,上线后不会触发
//			return	ReturnEntityUtil.error("EA002",e.getMessage());
//		}
//		return ReturnEntityUtil.success(list);
//	}
//
//	@RequestMapping("/getByOneEntity")
//	@ResponseBody
//	@ApiOperation(value = "返回唯一值", httpMethod = "POST")
//	public ReturnEntity<Map<String, Object>> getByOneEntity(@RequestParam Map<String, Object> params) {
//		String enName = params.get("enName").toString();
//		params.remove("enName");
//		params.put("_sysuser", getUser());
//		List<Map<String, Object>> list=null;
//		try (SqlSession sqlSession = sessionFactory.openSession(true)) {
//			list = sqlSession.selectList("com.buit.design.query." + enName + ".query", params);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			//这个抛错 开发时才会触发,上线后不会触发
//			return	ReturnEntityUtil.error("EA002",e.getMessage());
//		}
//		if (CollectionUtil.isNotEmpty(list)) {
//			return ReturnEntityUtil.success(list.get(0));
//		}
//		return ReturnEntityUtil.success();
//	}
//
//	@RequestMapping("/getDesign")
//	@ApiOperation(value = "取查询定义", httpMethod = "POST")
//	public void getOneByEntity(@ApiParam(name = "enName", value = "英文名") @RequestParam(value = "enName") String enName,
//			HttpServletResponse response) {
//		QueCxfb design = queCxfbSer.getEntityMapper().findDesign(enName);
//		if (design != null) {
//			printMes(design.getQueryJson(), response);
//		} else {
//			printMes("null", response);
//		}
//	}
//
//	private void printMes(String data, HttpServletResponse response) {
//		PrintWriter out = null;
//		try {
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("application/json");
//			out = response.getWriter();
//			out.println("{\"errorCode\": \"SUCCESS\",\"data\": " + data + ",\"message\": null}");
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		} finally {
//			if (null != out) {
//				out.flush();
//				out.close();
//			}
//		}
//	}
//}
