package com.lsgym.common.utils;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.Map;

/**
 * @Author: cheziyuan.
 * @Description: Json工具
 * @Date: 2020/4/15
 */
public class JsonUtils {
    public static Map<String, String> readJsonToMap(String jsondata) {
        try {
            return JSON.parseObject(jsondata, new TypeReference<Map<String, String>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
