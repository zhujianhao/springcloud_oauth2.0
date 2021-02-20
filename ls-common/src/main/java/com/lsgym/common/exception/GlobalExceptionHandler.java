package com.lsgym.common.exception;


import com.lsgym.common.utils.Result;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 全局异常处理
     *
     * @param e 错误
     * @return 错误信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody //为了返回数据
    public Result error(Exception e) {
        e.printStackTrace();
        log.error(e.toString());
        return Result.error();
    }

    /**
     * 自定义异常处理
     *
     * @param e 错误
     * @return 错误信息
     */
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result parameterTypeException(MyException e) {
        e.printStackTrace();
        log.error(e.toString());
        return Result.error(e.getMsg());

    }

    @ExceptionHandler(HystrixBadRequestException.class)
    @ResponseBody
    public Result parameterTypeException(HystrixBadRequestException e) {
        e.printStackTrace();
        log.error(e.toString());
        return Result.error(e.getMessage());

    }

    @ExceptionHandler(ServletException.class)
    @ResponseBody
    public Result parameterTypeException(ServletException e) {
        e.printStackTrace();
        log.error(e.toString());
        return Result.error(e.getMessage());

    }


}
