package com.lsgym.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableDiscoveryClient
@SpringBootApplication(scanBasePackages = "com.lsgym")
public class LsWechat {

    public static void main(String[] args) {
        SpringApplication.run(LsWechat.class, args);
    }

}
