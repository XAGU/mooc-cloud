package com.xagu.mooc.oauth2.hander;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xagu.mooc.base.domain.ResuBean;
import com.xagu.mooc.user.pojo.User;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * Describe: 自定义 Security 用户未登陆处理类
 * @author xagu
 * */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        ResuBean resuBean = new ResuBean();
        resuBean.setSuccess(true);
        resuBean.setMsg("登陆成功");
        resuBean.setCode(200);
        //得到登录信息
        User user = (User) authentication.getPrincipal();
        resuBean.setData(user);
        httpServletResponse.setHeader("Content-type","application/json;charset=UTF-8");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(resuBean));

    }
}
