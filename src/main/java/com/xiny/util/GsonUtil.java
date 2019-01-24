package com.xiny.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

/**
 * Created by xiny on 2019/1/23.
 */
public class GsonUtil {

    private static Gson gson = new GsonBuilder().create();

    public static String bean2Json(Object obj){
        return gson.toJson(obj);
    }

    public static <T> T json2Bean(String jsonStr,Class<T> objClass){
        return gson.fromJson(jsonStr,objClass);
    }

    public static String jsonFormmatter(String uglyJsonStr){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser jp = new JsonParser();
        JsonElement je = jp.parse(uglyJsonStr);
        return gson.toJson(je);
    }
}
