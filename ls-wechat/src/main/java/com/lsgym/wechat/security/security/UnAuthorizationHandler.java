package com.lsgym.wechat.security.security;

import com.lsgym.common.enums.ResultEnum;
import com.lsgym.common.utils.Result;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 验证失败处理类
 */
public class UnAuthorizationHandler  implements AuthenticationEntryPoint {




    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        // ajax请求，返回错误代码

        httpServletResponse.getWriter().print(Result.create(ResultEnum.FORBIDDEN.getCode(),e.getMessage()));
    }
}
