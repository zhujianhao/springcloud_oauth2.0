package com.lsgym.common.feign.wechat.sentinel;

import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.exception.MyException;
import com.lsgym.common.feign.wechat.WechatFeignService;
import com.lsgym.common.utils.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class WechatFeignFallbackFactory implements FallbackFactory<WechatFeignService> {
    @Override
    public WechatFeignService create(Throwable throwable) {
        return new WechatFeignService() {
            @Override
            public Result<AccountVo> getAccountByName(String userName) {
                throw new  MyException(throwable.getMessage());
            }
        };
    }
}
