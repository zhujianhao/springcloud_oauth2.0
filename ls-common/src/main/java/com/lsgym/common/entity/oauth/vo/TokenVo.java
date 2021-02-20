package com.lsgym.common.entity.oauth.vo;

import lombok.Data;

/**
 * @author zhujianhao
 * @date 2021/2/20 17:59
 * @modify
 */
@Data
public class TokenVo {
    private String access_token;
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private String example_parameter;
}
