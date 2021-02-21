package com.lsgym.wechat.controller;

import com.lsgym.common.annotation.LoginUser;
import com.lsgym.common.entity.wechat.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public String test(@LoginUser Account account){
        return account.getUserName();
//        return "world";
    }
}
