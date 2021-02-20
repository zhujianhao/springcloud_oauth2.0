package com.lsgym.wechat.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lsgym.common.entity.wechat.Account;
import com.lsgym.common.entity.wechat.vo.AccountVo;
import org.springframework.stereotype.Service;

/**
 * @author zhujianhao
 * @date 2021/2/18 17:04
 * @modify
 */
@Service
public interface AccountService extends IService<Account> {

    AccountVo getByUserName(String userName);
}
