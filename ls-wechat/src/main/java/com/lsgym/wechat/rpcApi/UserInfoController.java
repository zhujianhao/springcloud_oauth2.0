package com.lsgym.wechat.rpcApi;

import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.exception.MyException;
import com.lsgym.common.utils.Result;
import com.lsgym.wechat.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhujianhao
 * @date 2021/2/20 14:21
 * @modify
 */
@RequestMapping ("rpc/user")
@RestController
public class UserInfoController {

    @Autowired
    private AccountService accountService;
    /**
     *  security 获取用户信息 userDetailService
     */
    @PostMapping("getSecurityUserDetail")
    public Result<AccountVo> getAccountByName(@RequestParam("userName")String userName){
        if(true){
            throw new MyException("testerro");
        }
        return Result.ok(accountService.getByUserName(userName));
    }
}
