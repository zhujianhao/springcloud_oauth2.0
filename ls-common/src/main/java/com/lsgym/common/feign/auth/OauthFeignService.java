package com.lsgym.common.feign.auth;

import com.alibaba.fastjson.JSONObject;
import com.lsgym.common.entity.oauth.vo.TokenVo;
import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.feign.auth.sentinel.OauthFeignFallbackFactory;
import com.lsgym.common.feign.wechat.sentinel.WechatFeignFallbackFactory;
import com.lsgym.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhujianhao
 * @date 2021/2/20 14:15
 * @modify
 */
@FeignClient(value = "ls-oauth", fallbackFactory = OauthFeignFallbackFactory.class)
public interface OauthFeignService {

    @PostMapping("oauth/token")
    TokenVo getToken(@RequestParam("client_id") String clientId,
                     @RequestParam("client_secret") String clientSecret,
                     @RequestParam("grant_type") String grantType,
                     @RequestParam("username") String username,
                     @RequestParam("password") String password,
                     @RequestParam(value = "scope",required = false) String scope);

//    @GetMapping("oauth/check_token")
//    JSONObject checkToken(@RequestParam("token") String token);


}
