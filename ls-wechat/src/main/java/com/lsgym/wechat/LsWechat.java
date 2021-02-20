package com.lsgym.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.lsgym")
@EnableFeignClients("com.lsgym.common.feign")
public class LsWechat {

    public static void main(String[] args) {
        SpringApplication.run(LsWechat.class, args);
    }

}
