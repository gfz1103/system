package com.buit.his.sys.openapi;

import cn.hutool.core.io.IoUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.buit.commons.BaseException;
import com.buit.config.annotation.OpenApi;
import com.buit.his.sys.openapi.dao.SysOpenApiDao;
import com.buit.his.sys.openapi.model.SysOpenApi;
import com.buit.his.sys.openapi.request.OpenApiRequest;
import com.buit.his.sys.openapi.util.SignUtil;
import com.buit.logPrint.lFilter.ParamRequestWrapper;
import com.buit.utill.SpringContextUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

/**
 * @Author sunjx
 * @Date 2020-12-15 11:09
 * @Description OPENAPI 拦截器
 **/
public class OpenApiInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(OpenApiInterceptor.class);

    //用于与timestamp 对比校验请求是否超时; 用于设置校验重复请求的key的超时时长
    private static final Integer TIMEOUT = 300_000;

    //用于设置校验重复请求的key
    private static final String REQUEST_KEY_REDIS_KEY_PRIFIX = "openapi:reqkey:";

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SysOpenApiDao sysOpenApiDao;

    @Override
    public boolean preHandle(HttpServletRequest httpRequest, HttpServletResponse httpResponse, Object handler) throws Exception {

        if(!(handler instanceof HandlerMethod)){
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        if(!handlerMethod.getBeanType().isAnnotationPresent(OpenApi.class)){
            return true;
        }

        OpenApi annotation = handlerMethod.getBeanType().getAnnotation(OpenApi.class);

        try {

            if(httpRequest instanceof ParamRequestWrapper){
                ParamRequestWrapper requestWrapper = (ParamRequestWrapper) httpRequest;
                BufferedReader reader = requestWrapper.getReader();
                String jsonStr = IoUtil.read(reader);

                if(StrUtil.isBlank(jsonStr)){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0009.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0009.getMsg());
                }

                OpenApiRequest request = JSONUtil.toBean(jsonStr, OpenApiRequest.class);

                if(StrUtil.isBlank(request.getAccessKey()) || StrUtil.isBlank(request.getAccessSecret())){
                    //accessKey 或者 accessSecret 为空
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0003.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0003.getMsg());
                }

                //accessKey 是否存在
                SysOpenApi sysOpenApi = sysOpenApiDao.selectBy(request.getAccessKey(), SignUtil.md5(request.getAccessKey() + request.getAccessSecret()));

                //accessKey 或者 accessSecret 错误
                if(null == sysOpenApi){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0004.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0004.getMsg());
                }

                //已禁用
                if(sysOpenApi.getZt() != 1){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0005.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0005.getMsg());
                }

                //签名不正确
                if(!SignUtil.signCheck(request)){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0002.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0002.getMsg());
                }

                //接口权限
                if(StrUtil.isBlank(sysOpenApi.getRoles())){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0007.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0007.getMsg());
                }

                String[] roles = sysOpenApi.getRoles().split(",");
                boolean hasRole = false;
                for (String role : roles) {
                    if(role.equals(annotation.role())){
                        hasRole = true;
                        break;
                    }
                }

                if(!hasRole){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0006.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0006.getMsg());
                }

                //timestamp 为null 或者调用超时
                if(null != request.getTimestamp() && System.currentTimeMillis() - request.getTimestamp() > TIMEOUT){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0010.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0010.getMsg());
                }

                //重复请求
                if(!redisTemplate.opsForValue().setIfAbsent(REQUEST_KEY_REDIS_KEY_PRIFIX + request.getSign(),"", TIMEOUT, TimeUnit.MILLISECONDS)){
                    throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0011.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0011.getMsg());
                }

            }else{
                //参数格式不正确
                throw BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0001.getCode(), OpenApiErrorCode.ERROR_OPENAPI_0001.getMsg());
            }

            return true;
        } catch (Exception e) {
            BaseException baseException = null;
            if(e instanceof BaseException){
                baseException = (BaseException)e;
            }else{
                baseException = BaseException.create(OpenApiErrorCode.ERROR_OPENAPI_0008.getCode(), e.getMessage());
            }

            PrintWriter out = null;
            Environment env = SpringContextUtil.getApplicationContext().getBean(Environment.class);
            String msg = StrUtil.isBlank(baseException.getMessage()) ? env.getProperty(baseException.getCode()) : baseException.getMessage();
            String printErrorData = "{\"errorCode\": \""+baseException.getCode()+"\",\"message\": \""+ msg +"\",\"data\": null}";
            try {
                httpResponse.setCharacterEncoding("UTF-8");
                httpResponse.setContentType("application/json");
                out = httpResponse.getWriter();
                out.println(printErrorData);
                log.error(printErrorData);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
            } finally {
                if (null != out) {
                    out.flush();
                    out.close();
                }
            }
        }
        return false;
    }
}
