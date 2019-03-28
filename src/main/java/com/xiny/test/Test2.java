package com.xiny.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Lambda
public class Test2 {
    public static void main(String[] args) {
        String[] arr=new String[]{"qqq","www","eee","rrr"};
        List<String> list = Arrays.asList(arr);
        List<String> strList=new ArrayList<>(list);
        System.out.println(strList);

        for (String str:strList){
            System.out.println(str);
        }
        strList.forEach(System.out::println);
        strList.forEach((str) ->System.out.println(str));

    }
}
