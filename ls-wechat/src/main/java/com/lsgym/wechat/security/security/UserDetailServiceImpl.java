package com.lsgym.wechat.security.security;

import com.lsgym.common.exception.MyException;
import com.lsgym.common.entity.wechat.Account;
import com.lsgym.wechat.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhujianhao
 * @date 2021/2/18 16:45
 * @modify
 *
 * 框架用于认证用的
 */
@Service("userDetailsService")
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private AccountService accountService;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Account account = accountService.getByUserName(s);

        if(account ==null){
            throw new MyException("不存在用户");
        }
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();//去数据库查出来权限
        return new User(account.getUserName(),account.getPassWord(),grantedAuthorities);
    }


}
