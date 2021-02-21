package com.lsgym.wechat.config;

import com.lsgym.common.annotation.LoginUser;
import com.lsgym.common.entity.wechat.Account;
import com.lsgym.wechat.service.AccountService;
import org.apache.http.Consts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Component
public class AutoFillLoginUserResolver implements HandlerMethodArgumentResolver {


    @Autowired
    private AccountService accountService;


    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().isAssignableFrom(Account.class)
                && methodParameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null){//有登录信息
            if(!(authentication instanceof OAuth2Authentication)){
                return null;
            }
        }

        OAuth2Authentication oAuth2Authentication = (OAuth2Authentication) authentication;
        Authentication userAuthentication = oAuth2Authentication.getUserAuthentication();
        //取出用户身份信息
        String userName = userAuthentication.getName();


        //从userAuthentication取出权限，放在authorities
        List<String> authorities = userAuthentication.getAuthorities().stream().map(c->c.getAuthority()).collect(Collectors.toList());

        OAuth2Request oAuth2Request = oAuth2Authentication.getOAuth2Request();//客户端信息
        Account account  = accountService.getByUserName(userName);

        return  account;

    }
}
