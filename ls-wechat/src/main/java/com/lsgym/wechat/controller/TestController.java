package com.lsgym.wechat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhujianhao
 * @date 2021/2/18 16:02
 * @modify
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("hello")
    public String test(){
        return "world";
    }
}
