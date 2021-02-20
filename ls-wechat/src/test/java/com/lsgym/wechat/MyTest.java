package com.lsgym.wechat;

import com.alibaba.fastjson.JSON;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author zhujianhao
 * @date 2021/2/19 15:08
 * @modify
 */
public class MyTest extends PubplantApplicationTests {

    @Autowired
    private UserDetailsService userDetailsService;

    @Test
    public void getAccountByName(){
        UserDetails userDetails = userDetailsService.loadUserByUsername("zhangsan");
        System.out.println(JSON.toJSONString(userDetails));
    }
}
