package com.xiny.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by MACBOOK on 2018/12/24.
 */
interface invoke {

    int qwe=123;

    public void say(String name);


}

class invokeimpl implements invoke{

    @Override
    public void say(String name) {
        System.out.println("name:"+name);
    }

    private void qwer(){
        System.out.println("666");
    }

    public static void ewq(){
        System.out.println("576");
    }

}
