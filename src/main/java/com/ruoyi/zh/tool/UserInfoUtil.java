package com.ruoyi.zh.tool;

import com.ruoyi.framework.security.LoginUser;
import com.ruoyi.project.system.domain.SysUser;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Copyright © 广州禾信仪器股份有限公司. All rights reserved.
 *
 * @Author hxsdd-20
 * @Date 2020/4/28 15:52
 * @Version 1.0
 */
public class UserInfoUtil {
    public static String getUserName(){
        LoginUser loginUser =(LoginUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        SysUser user = loginUser.getUser();
        return user.getUserName();
    }
}
