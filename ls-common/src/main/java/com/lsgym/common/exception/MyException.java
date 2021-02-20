package com.lsgym.common.exception;

import lombok.Data;

/**
 * 自定义异常
 *
 * @author chenziyuan
 * @date 2022/4/7
 */
@Data
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private String msg;

    private int code;

    public MyException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public MyException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public MyException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }

    public MyException(String msg, int code, Throwable e) {
        super(msg, e);
        this.msg = msg;
        this.code = code;
    }


}
