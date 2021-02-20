package com.lsgym.common.entity.wechat;

import lombok.Data;

/**
 * @author zhujianhao
 * @date 2021/2/18 16:59
 * @modify
 */
@Data
public class Account {

    /**
     * id
     *
     */
    private String id;
    /**
     * 用户名
     *
     */
    private String userName;
    /**
     * 密码
     *
     */
    private String passWord;
    /**
     * 电话号码
     *
     */
    private String phone;
    /**
     * 头像
     *
     */
    private String avatar;

}
