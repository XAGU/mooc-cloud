package com.xagu.mooc.practical;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author xagu Created on 2021/2/13 Email:xagu_qc@foxmail.com Describe: TODO
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients(basePackages = {"com.xagu.mooc.*.client"})
@MapperScan("com.xagu.mooc.*.mapper")
public class PracticalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PracticalServiceApplication.class, args);
    }
}
