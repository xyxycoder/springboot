package com.xiny.util;

import com.alibaba.fastjson.JSON;

/**
 * Created by xiny on 2019/1/23.
 */
public class FastJsonUtil {


    public static String bean2Json(Object obj){
        return JSON.toJSONString(obj);
    }

    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        return JSON.parseObject(jsonStr,objClass);
    }
}
