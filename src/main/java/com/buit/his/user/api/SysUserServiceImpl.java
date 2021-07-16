package com.buit.his.user.api;

import com.buit.his.user.service.SysUserSer;
import com.buit.system.service.SysUserService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类名：SysUserServiceImpl
 * 描述：系统用户
 *
 * @author : liushijie
 * 2021/3/20
 **/
@DubboService(timeout = 10000)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserSer sysUserSer;

    /**
     * 验证密码是否正确
     * @param loginName
     * @param userPwd
     * @return
     */
    @Override
    public boolean checkPwd(String loginName, String userPwd) {
        return sysUserSer.checkPwd(loginName, userPwd);
    }
}
