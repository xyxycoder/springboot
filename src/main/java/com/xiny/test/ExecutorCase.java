package com.xiny.test;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


/**
 * Created by xiny on 2018/11/22.
 */
public class ExecutorCase {

//    private static Executor executor = Executors.newFixedThreadPool(10);
//    public static void main(String[] args){
//        for (int i=0;i<20;i++){
//            executor.execute(new Task());
//        }
//    }
//
//    static class Task implements Runnable {
//
//        @Override
//        public void run() {
//            System.out.println(Thread.currentThread().getName());
//        }
//    }
//   List list= Lists.newArrayList();

//    public static void main(String[] args){
//        int i=1;
//        for (int j = 0; j < 20; j++) {
//            i=i++;
//
//        }
//        System.out.println(i);
//        String str2 = "SEUCalvin";//新加的一行代码，其余不变
//        String str1 = new String("SEU")+ new String("Calvin");
//        System.out.println(str1.intern() == str1);
//        System.out.println(str1.intern() == "SEUCalvin");
//    }



    public static void main(String[] args) {
        try {
            Class clz = Class.forName("com.xiny.test.invokeimpl");
            Object obj = clz.newInstance();
            Method method = clz.getDeclaredMethod("qwer");
            method.setAccessible(true);
            method.invoke(obj);
//            Method method1 = clz.getMethod("say", String.class);
//            method1.invoke(obj,"66666666");
//            Method method = clz.getMethod("ewq");
//            method.invoke(clz);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
