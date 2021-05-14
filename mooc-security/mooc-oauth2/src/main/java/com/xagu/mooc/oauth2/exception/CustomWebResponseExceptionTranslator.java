package com.xagu.mooc.oauth2.exception;

import com.xagu.mooc.base.controller.BaseController;
import com.xagu.mooc.base.domain.ResuBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;

/**
 * @author xagu Created on 2021/2/13 Email:xagu_qc@foxmail.com Describe: TODO
 */
@Slf4j
public class CustomWebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity<ResuBean> translate(Exception e) throws Exception {
        log.error("认证服务器异常", e);

        ResuBean response = resolveException(e);

        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getCode()));
    }

    /**
     * 构建返回异常
     *
     * @param e exception
     */
    private ResuBean resolveException(Exception e) {
        // 初始值 500
        Integer returnCode = 500;
        String returnMessage = "无权访问";
        int httpStatus = HttpStatus.UNAUTHORIZED.value();
        //不支持的认证方式
        if (e instanceof UnsupportedGrantTypeException) {
            returnCode = 1003;
            returnMessage = "不支持的认证方式";
            //用户名或密码异常
        } else if (e instanceof InvalidGrantException) {
            returnMessage = "用户名或密码异常";
            returnCode = 1002;
        } else if (e instanceof InternalAuthenticationServiceException){
            returnMessage = "用户名或密码异常";
            returnCode = 1002;
        }

        ResuBean failResponse = BaseController.fail(returnCode, returnMessage);
        failResponse.setCode(httpStatus);

        return failResponse;
    }

}
