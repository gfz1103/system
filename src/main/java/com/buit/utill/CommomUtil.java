package com.buit.utill;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类名：CommomUtinl
 * 描述：公共工具类
 *
 * @author : liushijie
 * 2020/11/16
 **/
public class CommomUtil {

    /**
     * 判断是否包含中文 @Title: isContainChinese @Description:
     * TODO(这里用一句话描述这个方法的作用) @param @param str @param @return 设定文件 @return boolean
     * 返回类型 @author 龚方舟 @throws
     */
    public static boolean isContainChinese(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]");
        Matcher m = p.matcher(str);
        if (m.find()) {
            return true;
        }
        return false;
    }
}
