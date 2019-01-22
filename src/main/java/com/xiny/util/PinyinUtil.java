package com.xiny.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiny on 2019/1/3.
 */
public class PinyinUtil {




    // 返回中文的首字母(大写)
    public static String getPinYinHeadCharD(String str) throws BadHanyuPinyinOutputFormatCombination {
        if (str.isEmpty()) {
            return null;
        }
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
        StringBuffer convert = new StringBuffer("");
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word,format);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString();
    }


    public static void main(String[] args) throws BadHanyuPinyinOutputFormatCombination {
        System.out.println(getPinYinHeadCharX("厉()*&(*&害"));
    }



    // 返回中文的首字母(小写)
    public static String getPinYinHeadCharX(String str) {
        if(str.isEmpty()){
            return null;
        }
        String regEx="[`~!@#$%^&*()\\-+=_|{}':;'\",\\[\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]";
        Pattern p   =   Pattern.compile(regEx);
        Matcher m   =   p.matcher(str);
        String st=m.replaceAll("").trim();
        StringBuffer convert = new StringBuffer("");
        for (int j = 0; j < st.length(); j++) {
            char word = st.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert.append(pinyinArray[0].charAt(0));
            } else {
                convert.append(word);
            }
        }
        return convert.toString();
    }
}
