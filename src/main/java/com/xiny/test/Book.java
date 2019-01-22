package com.xiny.test;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Book {
    //    public static void main(String[] args)
//    {
//        byte a= 1;
//        a+=1;
//        int c=a+2;
//        staticFunction();
//    }
//    static Book book = new Book();
//    static
//    {
//        System.out.println("书的静态代码块");
//    }
//    {
//        System.out.println("书的普通代码块");
//    }
//    Book()
//    {
//        System.out.println("书的构造方法");
//        System.out.println("price=" + price +",amount=" + amount);
//    }
//    public static void staticFunction(){
//        System.out.println("书的静态方法");
//    }
//    int price = 110;
//    static int amount = 112;
    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = new String("1");
        s.intern();
        String s2 = "1";
        System.out.println(s == s2);

        String s3 = new String("1") + new String("1");
        s3.intern();
        String s4 = "11";
        System.out.println(s3 == s4);

        String str1 = new StringBuilder("a").append("b").toString();
        System.out.println(str1.intern() == str1);
        String str2 = new StringBuilder("c").toString();
        System.out.println(str2.intern() == str2);
        char value[] = {'1', '2', '3', '4', '5', '6'};
        String st = new String(value, 2, 3);
        String aaa = "qqqqqqqqqqqqwwee";
        int i = st.compareTo(aaa);
        System.out.println(i);
        String qqq = "12";
        System.out.println(qqq.hashCode());
        List list = new ArrayList();
       int num=15;
       num=num >> 1;
        System.out.println(num);

    }
}