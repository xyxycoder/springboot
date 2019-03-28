package com.xiny.cosineSimilarityAlgorithm;

/**
 * 计算两个字符串的相识度
 */
public class Similarity {

    public static final  String content1="复方水杨酸溶液溶液";

    public static final  String content2="复方紫荆皮水杨酸溶液";


    public static void main(String[] args) {

        double  score=CosineSimilarity.getSimilarity(content1,content2);
        System.out.println("相似度："+score);

        score=CosineSimilarity.getSimilarity(content1,content1);
        System.out.println("相似度："+score);
    }

}
