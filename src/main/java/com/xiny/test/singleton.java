package com.xiny.test;

/**
 * Created by xiny on 2018/12/25.
 */
public class singleton {

    private singleton(){};

    private static singleton single=new singleton();

    public static singleton getsingleton(){
        return single;
    }
}
