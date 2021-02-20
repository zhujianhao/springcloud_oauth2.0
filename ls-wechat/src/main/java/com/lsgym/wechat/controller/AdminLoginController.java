package com.lsgym.wechat.controller;

import com.lsgym.common.entity.oauth.vo.TokenVo;
import com.lsgym.common.entity.wechat.dto.LoginDto;
import com.lsgym.common.feign.auth.OauthFeignService;
import com.lsgym.common.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author zhujianhao
 * @date 2021/2/20 16:49
 * @modify
 */
@RestController
@RequestMapping("admin/login")
public class AdminLoginController {


    @Autowired
    private OauthFeignService oauthFeignService;


    @PostMapping("doLogin")
    public Result<String> doLogin(@RequestBody LoginDto loginDto){
        TokenVo tokenVo = oauthFeignService.getToken("wechat","123","password",loginDto.getUserName(),loginDto.getPassWord(),"");
        return Result.ok(tokenVo.getAccess_token());
    }
}
