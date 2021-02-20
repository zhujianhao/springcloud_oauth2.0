package com.lsgym.wechat.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lsgym.common.entity.wechat.Account;
import com.lsgym.common.entity.wechat.vo.AccountVo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zhujianhao
 * @date 2021/2/18 17:00
 * @modify
 */
@Mapper
public interface AccountDao extends BaseMapper<Account> {

    AccountVo getByUserName(String userName);
}
