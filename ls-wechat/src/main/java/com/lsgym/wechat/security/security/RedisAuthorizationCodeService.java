package com.lsgym.wechat.security.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.stereotype.Service;

/**
 * @author zhujianhao
 * @date 2021/2/19 16:35
 * @modify
 *
 *将授权码存入redis
 */
@Service
public class RedisAuthorizationCodeService extends RandomValueAuthorizationCodeServices {



    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserDetailsService userDetailsService;


    //存储code

    @Override
    protected void store(String code, OAuth2Authentication oAuth2Authentication) {
        OAuth2Request request = oAuth2Authentication.getOAuth2Request();//client
        Authentication authentication = oAuth2Authentication.getUserAuthentication();//userinfo
        String value = request.getClientId()+","+(String)authentication.getPrincipal();

        redisTemplate.opsForValue().set(code,value);
    }

    //移除code 并返回 认证信息
    @Override
    protected OAuth2Authentication remove(String code) {
        String value = redisTemplate.opsForValue().get(code);
        if(value !=null){
            OAuth2Request auth2Request = null;
            Authentication authentication = null;

            String clientId = value.split(",")[0];
            String userName = value.split(",")[1];
            if(StringUtils.isNotEmpty(clientId)){
                //获取客户端信息
            }
            if(StringUtils.isNotEmpty(userName)){
                //获取用信息 和 权限信息
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                authentication = new UsernamePasswordAuthenticationToken(userDetails.getUsername(),userDetails.getPassword(),userDetails.getAuthorities());
            }
            OAuth2Authentication auth2Authentication = new OAuth2Authentication(auth2Request,authentication);
            return auth2Authentication;
        }
        return null;
    }
}
