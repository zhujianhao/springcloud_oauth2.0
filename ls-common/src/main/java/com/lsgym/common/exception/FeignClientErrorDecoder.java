package com.lsgym.common.exception;


import com.lsgym.common.enums.ResultEnum;
import com.lsgym.common.utils.JsonUtils;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Map;


/**
 * feign自定义异常处理
 *
 * @author chenziyuan
 * @date 2022/4/7
 */
@Configuration
public class FeignClientErrorDecoder implements ErrorDecoder {
    @Override
    public Exception decode(String s, Response response) {
        String body = null;
        try {
            body = Util.toString(response.body().asReader());
            // body = Util.toByteArray(response.body().asInputStream());
            // Map parse = (Map) JSONObject.parse(body);
            Map<String, String> map = JsonUtils.readJsonToMap(body);


            //请求放行的接口出现token过期的错误返回
            String token_expired = map.get("error_description");
            if (!StringUtils.isEmpty(token_expired)) {
                return new MyException(ResultEnum.LOGIN_ERROR.getMsg(), ResultEnum.LOGIN_ERROR.getCode());
            }

            String message = map.get("message");
            if (response.status() >= 400 && response.status() <= 500) {
                //throw new MyException(message);
                if (!StringUtils.isEmpty(message)) {
                    MyException exception = new MyException(message);
                    exception.setCode(response.status());
                    return exception;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
