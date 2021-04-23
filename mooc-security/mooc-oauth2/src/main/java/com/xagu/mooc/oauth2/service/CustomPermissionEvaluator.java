package com.xagu.mooc.oauth2.service;

import com.xagu.mooc.oauth2.domain.SecurityUserDetails;
import com.xagu.mooc.user.pojo.Power;
import java.io.Serializable;
import java.util.List;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

/**
 * Describe: 自定义 Security 权限注解实现
 * Author: 就 眠 仪 式
 * CreateTime: 2019/10/23
 */
@Component
public class CustomPermissionEvaluator implements PermissionEvaluator {


    /**
     * Describe: 自定义 Security 权限认证 @HasPermission
     * Param: Authentication
     * Return Boolean
     */
    @Override
    public boolean hasPermission(Authentication authentication, Object o, Object o1) {
        // 根据用户账户查询权限信息
        Object principal = authentication.getPrincipal();

        if (principal instanceof SecurityUserDetails) {
            if ("admin".equals(((SecurityUserDetails) principal).getUsername())) {
                return true;
            }
            // 根据用户账户查询权限信息
            List<Power> powerList = ((SecurityUserDetails) principal).getPowers();

            for (Power power : powerList) {
                //权限匹配上且权限的enable为0(数据sql查询控制了enable==0)
                if (power.getPowerCode().equals(o)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean hasPermission(Authentication authentication, Serializable serializable, String s, Object o) {
        return false;
    }

}
