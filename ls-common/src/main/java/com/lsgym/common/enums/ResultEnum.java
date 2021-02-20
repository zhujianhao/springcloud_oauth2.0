package com.lsgym.common.enums;

/**
 * @author chenziyuan
 * 响应状态码
 * @date 2020 /4/4
 */
public enum ResultEnum {
    /*
    请求返回状态码和说明信息
     */
    SUCCESS(200, "请求成功"),
    FAIL(-1, "操作失败"),
    REPEAT(-2, "重复操作"),
    TOKEN_NULL(201, "token为空"),
    TOKEN_EXPIRATION(202, "token失效"),
    ACCOUNT_IS_DISABLED(203, "你的用户账号已经被禁用,请联系管理员!"),
    ACCOUNT_IS_BLACKLISTED(204, "你的账号已经被拉黑,请联系管理员!"),
    ERROR_PHONE_CODE(209, "验证码不正确或者失效"),
    ERROR_NO_LOGIN(210, "用户未登陆!"),
    INCONSISTENT_PASSWORD(211, "两次输入的密码不一致!"),
    TOKEN_EXCEPTION(212, "您的账号在其他地方登录,您已被强制下线!如非本人操作,请及时修改密码!"),
    CREATE_USER_FAILED(222, "创建用户失败!"),
    BAD_REQUEST(400, "参数或者语法不对"),
    UNAUTHORIZED(401, "认证失败"),
    LOGIN_ERROR(401, "登陆失败,用户名或密码错误!"),
    FORBIDDEN(403, "您的权限不足，无法访问该资源"),
    NOT_FOUND(404, "请求的资源不存在"),
    OPERATE_ERROR(405, "操作失败，请求操作的资源不存在"),
    TIME_OUT(408, "请求超时"),

    SYSTEM_ERROR(500, "系统异常,请联系管理员处理!"),

    ERROR_DATE_FORMAT(520, "日期转换异常"),
    ERROR_DATE_NUMBER(520, "数字转换异常"),
    ERROR_JSON_FORMAT(522, "JSON转换异常"),
    ERROR_DUPLICATE_KEY(523, "重复键值"),
    ILLEGAL_REQUEST(5000, "非法请求!"),
    TOO_MUCH_REQUEST(5001, "请求次数过多"),
    ILLEGAL_ARGUMENT(10000, "参数不合法"),
    REPETITIVE_OPERATION(10001, "请勿重复操作"),
    ACCESS_LIMIT(10002, "请求太频繁, 请稍后再试");


    private int code;
    private String msg;

    ResultEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
