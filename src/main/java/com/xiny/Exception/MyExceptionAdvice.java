package com.xiny.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiny on 2019/1/17.
 */
@ControllerAdvice
public class MyExceptionAdvice {


    //全局异常
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Map exceptionHandler(Exception ex){
         Map map=new HashMap();
         map.put("code","404");
         map.put("msg",ex.getMessage());
         return map;
    }

    //自定义异常
    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public Map myExceptionHandler(MyException ex){
         Map map=new HashMap();
         map.put("code",ex.getCode());
         map.put("msg",ex.getMsg());
         return map;
    }
}
