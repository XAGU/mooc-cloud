package com.xagu.mooc.oauth2.hander;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xagu.mooc.base.domain.ResuBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Describe: 自定义 Security 注销成功处理类
 * @author xagu
 * */
@Component
public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ResuBean resuBean = new ResuBean();
        resuBean.setCode(200);
        resuBean.setMsg("注销成功");
        resuBean.setSuccess(true);
        SecurityContextHolder.clearContext();
        httpServletResponse.setHeader("Content-type","application/json;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(resuBean));
    }
}
