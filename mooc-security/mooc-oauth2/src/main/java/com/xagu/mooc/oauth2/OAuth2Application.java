package com.xagu.mooc.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author xagu
 * Created on 2020/9/13
 * Email:xagu_qc@foxmail.com
 * Describe: TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableResourceServer
public class OAuth2Application {

    public static void main(String[] args) {
        SpringApplication.run(OAuth2Application.class,args);
    }
}
