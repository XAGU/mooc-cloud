package com.xagu.mooc.oauth2.hander;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xagu.mooc.base.domain.ResuBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Describe: 自定义 Security 用户未登陆处理类
 * @author xagu
 *
 **/

@Component
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        ResuBean resuBean = new ResuBean();
        resuBean.setSuccess(false);
        resuBean.setMsg("未知账户");
        resuBean.setCode(401);
        httpServletResponse.setHeader("Content-type","application/json;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(resuBean));
    }
}
