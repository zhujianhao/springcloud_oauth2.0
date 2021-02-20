package com.lsgym.common.feign.wechat;

import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.feign.wechat.sentinel.WechatFeignFallbackFactory;
import com.lsgym.common.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author zhujianhao
 * @date 2021/2/20 14:15
 * @modify
 */
@FeignClient(value = "ls-wechat", fallbackFactory = WechatFeignFallbackFactory.class)
public interface WechatFeignService {

    @PostMapping("rpc/user/getSecurityUserDetail")
    Result<AccountVo> getAccountByName(@RequestParam("userName") String userName);
}
