package com.xagu.mooc.base.constant;

/**
 * spring security 放行的资源
 *
 * @author xagu
 */
public class SecurityConstants {

    /**
     * 不需要认证的地方
     */
    public static final String ANT_MATCHERS = "/admin/login.html," +
            "/admin/admin/**," +
            "/admin/assets/**," +
            "/admin/component/**";
}
