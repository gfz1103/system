package com.buit.his.user.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import com.buit.his.sys.centermaintenance.response.PageLogoResp;
import com.buit.his.sys.centermaintenance.service.DicYljgSer;
import com.buit.his.user.response.SysUserResp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buit.commons.BaseSpringController;
import com.buit.commons.SysUser;
import com.buit.his.user.response.LoginResp;
import com.buit.his.user.service.SysUserSer;
import com.buit.utill.ReturnEntity;
import com.buit.utill.ReturnEntityUtil;
import com.buit.utill.SpringContextUtil;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * @author All
 */

@Api(tags = "用户登录")
@Controller
@RequestMapping("/ex")
public class LoginController extends BaseSpringController {
    static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private SysUserSer sysUserSer;
    @Autowired
    private DicYljgSer dicYljgSer;

    @Value("${buit.jgid}")
    private Integer jgid;

//  @RequestMapping("/getOneByEntity")
//  @ResponseBody
//  @ApiOperation(value="按条件查询-返回唯一值" ,httpMethod="POST")
//  public ReturnEntity<SysGroup> getOneByEntity(SysGroup sysgroup){
//      List<SysGroup> list=sysGroupSer.findByEntity(sysgroup);
//      if(list.size()>0){
//         return ReturnEntityUtil.success(list.get(0));    
//      }
//      return ReturnEntityUtil.success();
//  }


    @RequestMapping("/login")
    @ResponseBody
    @ApiOperation(value = "用户密码登陆", httpMethod = "POST", notes = "1)验证用户名密码接口,输入密码光标离开调用 </br>2)longinCount=0 表示首次登录,进系统后,强制修改密码 </br> 3:登录成功后.返回医院下拉内容"
            + "</br>3:岗位下拉内容:接口位置,用户组关联岗位-->根据医院ID取角色</br>4:界面 登录按钮接口:用户设置-->提交登录信息")
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity<LoginResp> login(
            @ApiParam(name = "loginName", value = "用户名", required = true) @RequestParam(value = "loginName") String loginName,
            @ApiParam(name = "userPwd", value = "密码", required = true) @RequestParam(value = "userPwd") String userPwd) {
        return sysUserSer.login(loginName, userPwd);
    }

    @RequestMapping("/checkChangePwdTime")
    @ResponseBody
    @ApiOperation(value = "验证用户是否需要修改密码", httpMethod = "POST", notes = "系统参数配置多久修改一次密码")
    @ApiOperationSupport(author = "tian")
    public ReturnEntity<Boolean> checkChangePwdTime() {
        Boolean result = sysUserSer.checkChangePwdTime(getUser());
        return ReturnEntityUtil.success(result);
    }

    @RequestMapping("/loginGetUser")
    @ResponseBody
    @ApiOperation(value = "取用户信息", httpMethod = "POST", notes = "根据登录名查询用户信息")
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity<SysUser> loginGetUser(
            @ApiParam(name = "loginName", value = "用户名", required = true) @RequestParam(value = "loginName") String loginName) {
        return sysUserSer.loginGetUser(loginName);
    }


    @RequestMapping("/loginOut")
    @ResponseBody
    @ApiOperation(value = "用户退出登陆", httpMethod = "POST")
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity<String> loginOut() {
        sysUserSer.loginOut();
        return ReturnEntityUtil.success();
    }

    @Autowired
    private MessageSource messageSource;

    /**
     * 国际化测试
     */
    @RequestMapping("/i18ntest")
    @ResponseBody
    @ApiOperation(value = "国际化测试", httpMethod = "POST")
    public ReturnEntity<String> i18ntest() {
        Locale locale = LocaleContextHolder.getLocale();
        Object[] par = new Object[]{"第一个", "第二个"};
        String abc = messageSource.getMessage("login.failaa", par, locale);
        messageSource.getMessage("errorCode.ERROR_USER_0005", null, locale);
//		 SysUser sysUser =new SysUser();
//		 ChineseCharacterUtil.setPyAndWb(sysUser, "文光临");
//		 System.out.println("getWbCode : " + sysUser.getWbCode());
//		 System.out.println("getPyCode : " + sysUser.getPyCode());
//		 BaseException.create("ERROR_USER_0005");
        return ReturnEntityUtil.success(abc);
    }

    @RequestMapping("/shutdown")
    @ResponseBody
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity<String> shutdown(HttpServletRequest request) {
        if ("127.0.0.1".equals(request.getServerName())) {
            Thread t = new Thread(new Runnable() {
                public void run() {
                    logger.info("======5秒后 停止系统===========");
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    SpringContextUtil.getApplicationContext().close();
                }
            });
            t.start();
        }
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/errorUser")
    @ResponseBody
    @ApiOperation(value = "查询密码登录错误超过十次锁定的用户", httpMethod = "POST")
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity<List<SysUserResp>> errorUser(@ApiParam(name = "userName", value = "查询条件-姓名") @RequestParam(value = "userName", required = false) String userName) {
        List<SysUserResp> sysUserResps = sysUserSer.errorUser(getUser().getHospitalId(), userName);
        return ReturnEntityUtil.success( sysUserResps );
    }

    @RequestMapping("/unLockErrorUser")
    @ResponseBody
    @ApiOperation(value = "解锁密码登录错误超过十次锁定的用户", httpMethod = "POST")
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity unLockRrrorUser(@ApiParam(name = "userId", value = "userId", required = true) @RequestParam(value = "userId") Integer userId) {
        sysUserSer.unLockRrrorUser(userId);
        return ReturnEntityUtil.success();
    }

    @RequestMapping("/yljgInfo")
    @ResponseBody
    @ApiOperation(value = "获取医疗机构信息", httpMethod = "POST")
    @ApiOperationSupport(author = "tian")
    public ReturnEntity<?> getYljgInfo() {
        return ReturnEntityUtil.success(dicYljgSer.getById(jgid));
    }

   /* @RequestMapping("/view_cf/{kzxh}")
    @ResponseBody
    @ApiOperation(value = "解锁密码登录错误超过十次锁定的用户", httpMethod = "POST")
    @ApiOperationSupport(author = "神算子")
    public ReturnEntity unLockRrrorUser(@ApiParam(value = "处方kzxh", name = "kzxh") @PathVariable String kzxh,
                                        HttpServletResponse response, HttpServletRequest httpReq) {
        String path = httpReq.getRequestURI();
        String url = httpReq.getRequestURI();
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(url);
        path = url.replace(m.replaceAll("").trim(), "");
        char c = path.charAt(path.length());
        String substring = path.substring(0, path.length() - 1);
        return ReturnEntityUtil.success(c);
    }

    public String getPath(HttpServletRequest httpReq) {
        String path = httpReq.getRequestURI();
        String url = httpReq.getRequestURI();
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(url);
        path = url.replace(m.replaceAll("").trim(), "");
        char c = path.charAt(path.length());
        return path.substring(0, path.length() - 1);

    }*/

    /**
     * 查询医疗机构主页小logo
     */
    @RequestMapping("/pageLogo")
    @ResponseBody
    @ApiOperation(value = "查询医疗机构主页小logo", httpMethod = "POST")
    public ReturnEntity <PageLogoResp> pageLogo(@ApiParam(name = "hospitalId", value = "机构ID",required = true)@RequestParam Integer hospitalId) {
        return ReturnEntityUtil.success(dicYljgSer.pageLogo(hospitalId));
    }
}
