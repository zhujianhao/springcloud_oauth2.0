package com.lsgym.common.feign.auth.sentinel;

import com.lsgym.common.entity.oauth.vo.TokenVo;
import com.lsgym.common.entity.wechat.vo.AccountVo;
import com.lsgym.common.exception.MyException;
import com.lsgym.common.feign.auth.OauthFeignService;
import com.lsgym.common.feign.wechat.WechatFeignService;
import com.lsgym.common.utils.Result;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class OauthFeignFallbackFactory implements FallbackFactory<OauthFeignService> {
    @Override
    public OauthFeignService create(Throwable throwable) {
        return new OauthFeignService() {

            @Override
            public TokenVo getToken(String  clientId,String  clientSecret,String grantType, String username, String password, String scope) {
                throw new MyException(throwable.getMessage());
            }
        };
    }
}
