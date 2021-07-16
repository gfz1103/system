package com.buit.his.sys.openapi.util;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Author sunjx
 * @Date 2020-12-14 11:20
 * @Description 加密相关方法
 **/
public abstract class SignUtil {

    private static final Logger log = LoggerFactory.getLogger(SignUtil.class);

    private static final String SIGN_FEILD_NAME = "sign";

    /**
     * 数据签名校验
     * 参数转为json排除掉sign字段后md5签名
     */
    public static boolean signCheck(Object data){
        if(ObjectUtil.isEmpty(data)){
            return false;
        }

        JSONObject jsonObject = JSONUtil.parseObj(data);
        String signStr = (String)jsonObject.get(SIGN_FEILD_NAME);
        if (StrUtil.isBlank(signStr)){
            return false;
        }

        log.debug("signStr => {}", signStr);
        String md5Str = sign(data);
        return signStr.equals(md5Str);
    }

    /**
     * 移除签名属性后将数据签名
     */
    public static String sign(Object data){
        if(ObjectUtil.isEmpty(data)){
            return null;
        }

        //按类定义顺序排序
        JSONObject jsonObject = JSONUtil.parseObj(data, true, true);
        jsonObject.remove(SIGN_FEILD_NAME);

        String dataJsonStr = JSONUtil.toJsonStr(jsonObject);
        log.debug("dataJsonStr => {}", dataJsonStr);
        String md5Hex = md5(dataJsonStr);
        log.debug("md5Hex => {}", md5Hex);
        return md5Hex;
    }

    public static String md5(String source){
        return DigestUtil.md5Hex(source);
    }
}
