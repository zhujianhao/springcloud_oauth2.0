package com.lsgym.auth.manager;

import com.lsgym.common.entity.wechat.Account;
import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.enums.ResultEnum;
import com.lsgym.common.feign.wechat.WechatFeignService;
import com.lsgym.common.utils.Result;
import net.sf.jsqlparser.statement.create.table.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

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
    private WechatFeignService wechatFeignService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Result<AccountVo> accountVoResult=  wechatFeignService.getAccountByName(userName);
       if(accountVoResult.getCode().equals(ResultEnum.SUCCESS.getCode())){
           AccountVo accountVo = accountVoResult.getData();
           return new User(accountVo.getUserName(),accountVo.getPassWord(),new ArrayList<>());
       }
       return null;
    }


    public static void main(String[] args) {
        String s = new  BCryptPasswordEncoder().encode("123");
        System.out.println(s);
    }

}
