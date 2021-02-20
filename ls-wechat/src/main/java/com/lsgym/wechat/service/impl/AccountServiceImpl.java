package com.lsgym.wechat.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.wechat.dao.AccountDao;
import com.lsgym.common.entity.wechat.Account;
import com.lsgym.wechat.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author zhujianhao
 * @date 2021/2/18 17:05
 * @modify
 */
@Service
public class AccountServiceImpl extends ServiceImpl<AccountDao, Account> implements AccountService {
    @Override
    public AccountVo getByUserName(String userName) {
        return getBaseMapper().getByUserName(userName);
    }
}
