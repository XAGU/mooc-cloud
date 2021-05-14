package com.xagu.mooc.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xagu Created on 2021/2/13 Email:xagu_qc@foxmail.com Describe: 用户微服务
 */
@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = {"com.xagu.mooc"})
@EnableFeignClients
@MapperScan("com.xagu.mooc.*.mapper")
public class UserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }
}
