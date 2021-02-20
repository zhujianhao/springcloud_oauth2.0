package com.lsgym.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhujianhao
 * @date 2021/2/20 14:29
 * @modify
 */
@EnableDiscoveryClient
@EnableFeignClients("com.lsgym.common.feign")
@SpringBootApplication(scanBasePackages = "com.lsgym")
public class Auth2Application {

    public static void main(String[] args) {
        SpringApplication.run(Auth2Application.class, args);
    }
}
