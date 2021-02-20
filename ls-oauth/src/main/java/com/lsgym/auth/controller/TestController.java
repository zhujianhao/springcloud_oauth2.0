package com.lsgym.auth.controller;

import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.feign.wechat.WechatFeignService;
import com.lsgym.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhujianhao
 * @date 2021/2/20 14:42
 * @modify
 */
@RequestMapping("test")
@RestController
public class TestController {

    @Autowired
    private WechatFeignService wechatFeignService;

    @GetMapping("userDetail")
    public Result<AccountVo> userDetail() {
        return wechatFeignService.getAccountByName("zhangsan");
    }
}
