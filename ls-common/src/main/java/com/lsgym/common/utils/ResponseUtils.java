package com.lsgym.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @description: Response返回util
 * @author: chenziyuan
 * @create: 2020/4/8
 **/
public class ResponseUtils {

    public static void responseReturn(HttpServletResponse response, Integer status, Result result) {
        try {
            if (status == null) {
                status = HttpServletResponse.SC_OK;
            }
            response.setContentType("application/json;charset=utf-8");
            response.setStatus(status);
            PrintWriter out = response.getWriter();
            out.write(JSON.toJSONString(result, SerializerFeature.WriteMapNullValue));
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void responseReturn(HttpServletResponse response, Result result) {
        responseReturn(response, null, result);
    }


}
