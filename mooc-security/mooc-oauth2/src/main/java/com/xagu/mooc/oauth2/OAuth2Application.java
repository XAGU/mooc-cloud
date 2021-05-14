package com.xagu.mooc.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author xagu
 * Created on 2021/2/13
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class,args);
    }
}
