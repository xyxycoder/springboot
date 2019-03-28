package com.xiny.test;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.dictionary.py.Pinyin;
import org.springframework.util.StringUtils;


import java.util.*;
import java.util.stream.Collectors;


public class Test4 {


    public static void main(String[] args) {
        Test4.testToPinList("复方水杨酸溶液胶囊胶囊", "复方紫荆皮水杨酸溶液液");
    }




    public static double testToPinList(String s1, String s2) {
        if ((StringUtils.isEmpty(s1) && !StringUtils.isEmpty(s2)) || (!StringUtils.isEmpty(s1) && StringUtils.isEmpty(s2))) {
            return 0;
        }
        if (s1.equals(s2)) {
            return 1;
        }
        //获取拼音
        List<String> list1 = Test4.testToPin(s1);
        List<String> list2 = Test4.testToPin(s2);
        List<String> listAll = new ArrayList<>();
        listAll.addAll(list1);
        listAll.addAll(list2);
        listAll = new ArrayList<>(new LinkedHashSet<>(listAll));
        System.out.println(listAll);
        //获取每个拼音出现次数
        int[] cou1 = Test4.testSelectCou(list1, listAll);
        int[] cou2 = Test4.testSelectCou(list2, listAll);
        System.out.println();
        double d = Test4.cosineSimilarityAlgorithm(cou1, cou2);
        return d;
    }


    /**
     * 余弦相似度算法
     *
     * @param i1
     * @param i2
     * @return
     */
    public static double cosineSimilarityAlgorithm(int[] i1, int[] i2) {
        double d = 0;

        return d;
    }


    /**
     * 返回数组，每个拼音出现次数
     *
     * @param list
     * @param listAll
     * @return
     */
    public static int[] testSelectCou(List<String> list, List<String> listAll) {
        int[] count = new int[listAll.size()];
        for (int i = 0; i < listAll.size(); i++) {
            int cou = 0;
            for (int j = 0; j < list.size(); j++) {
                if (listAll.get(i).equals(list.get(j))) {
                    cou++;
                }
                count[i] = cou;
            }
        }
        return count;
    }

    /**
     * 返回拼音list
     *
     * @param str
     * @return
     */
    public static List<String> testToPin(String str) {
        List<Pinyin> pinyinList = HanLP.convertToPinyinList(str);
        List<String> stringList = pinyinList.stream().map(o -> o.getPinyinWithoutTone()).collect(Collectors.toList());
        System.out.println(stringList);
        return stringList;
    }


    public static void testToPin1(String str) {
//        String str = "重载不是重任";
        List<Pinyin> pinyinList = HanLP.convertToPinyinList(str);
        System.out.print("原文,");
        for (char c : str.toCharArray()) {
            System.out.printf("%c,", c);
        }
        System.out.println();

        System.out.print("拼音（数字音调）,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin);
        }
        System.out.println();

        System.out.print("拼音（符号音调）,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin.getPinyinWithToneMark());
        }
        System.out.println();

        System.out.print("拼音（无音调）,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin.getPinyinWithoutTone());
        }
        System.out.println();

        System.out.print("声调,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin.getTone());
        }
        System.out.println();

        System.out.print("声母,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin.getShengmu());
        }
        System.out.println();

        System.out.print("韵母,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin.getYunmu());
        }
        System.out.println();

        System.out.print("输入法头,");
        for (Pinyin pinyin : pinyinList) {
            System.out.printf("%s,", pinyin.getHead());
        }
        System.out.println();


    }
}
