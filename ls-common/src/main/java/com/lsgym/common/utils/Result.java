package com.lsgym.common.utils;


import com.alibaba.fastjson.JSON;
import com.lsgym.common.enums.ResultEnum;

import java.io.Serializable;

/**
 * @author chenziyuan
 * @date 2020 4-1
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private String version = "1.0";
    private Integer code;
    private String msg;


    private T data;

    private Result() {
        this.setCode(ResultEnum.SUCCESS.getCode());
        this.setMsg(ResultEnum.SUCCESS.getMsg());
        this.setVersion(version);
    }

    /**
     * 成功提示
     *
     * @return
     */
    public static <T> Result<T> ok() {
        return new Result<>();
    }

    /**
     * 成功提示
     *
     * @param msg 提示信息
     * @return
     */
    public static <T> Result<T> ok(String msg) {
        Result<T> r = new Result<>();
        r.setMsg(msg);
        return r;
    }

    /**
     * 成功提示
     *
     * @param obj data
     * @return
     */
    public static <T> Result<T> ok(T obj) {
        Result<T> r = new Result<>();
        r.setData(obj);
        return r;
    }

    /**
     * 成功提示
     *
     * @param msg 提示信息
     * @param obj data
     * @return
     */
    public static <T> Result<T> ok(String msg, T obj) {
        Result<T> r = new Result<>();
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }

    /**
     * 操作失败
     *
     * @param msg 提示信息
     * @return
     */
    public static <T> Result<T> fail(String msg) {
        Result<T> r = new Result<>();
        r.setCode(ResultEnum.FAIL.getCode());
        r.setMsg(msg);
        return r;
    }

    /**
     * 操作失败
     *
     * @param obj data
     * @return
     */
    public static <T> Result<T> fail(T obj) {
        Result<T> r = new Result<>();
        r.setCode(ResultEnum.FAIL.getCode());
        r.setData(obj);
        return r;
    }

    /**
     * 操作失败
     *
     * @param msg 提示信息
     * @param obj data
     * @return
     */
    public static <T> Result<T> fail(String msg, T obj) {
        Result<T> r = new Result<>();
        r.setCode(ResultEnum.FAIL.getCode());
        r.setMsg(msg);
        r.setData(obj);
        return r;
    }


    /**
     * 错误提示
     *
     * @return
     */
    public static <T> Result<T> error() {
        return error(ResultEnum.SYSTEM_ERROR);
    }

    /**
     * 错误提示
     *
     * @param msg 提示信息
     * @return
     */
    public static <T> Result<T> error(String msg) {
        return create(ResultEnum.SYSTEM_ERROR.getCode(), msg);
    }


    public static <T> Result<T> error(Integer code, String msg) {
        return create(code, msg);
    }

    /**
     * 错误提示
     *
     * @param code 返回码
     * @param msg  提示信息
     * @return
     */
    public static <T> Result<T> create(int code, String msg) {
        Result<T> r = new Result<>();
        r.setMsg(msg);
        r.setCode(code);
        r.setData(null);
        return r;
    }

    public static <T> Result<T> create(ResultEnum resultEnum, T t) {
        Result<T> r = new Result<>();
        r.setMsg(resultEnum.getMsg());
        r.setCode(resultEnum.getCode());
        r.setData(t);
        return r;
    }

    /**
     * 错误提示
     *
     * @param code 返回码
     * @param msg  提示信息
     * @return
     */
    public static <T> Result<T> create(int code, String msg, T t) {
        Result<T> r = new Result<>();
        r.setMsg(msg);
        r.setCode(code);
        r.setData(t);
        return r;
    }

    public static <T> Result<T> error(ResultEnum resultEnum) {
        Result<T> r = new Result<>();
        r.setMsg(resultEnum.getMsg());
        r.setCode(resultEnum.getCode());
        r.setData(null);
        return r;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
