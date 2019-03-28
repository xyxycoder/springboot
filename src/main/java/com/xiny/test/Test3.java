package com.xiny.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Test3 {

  public static  final  String str="药品第10行第4列";

    public static void main(String[] args) {
        String[] strings = str.split("第");
        Map<String,Object> map=new HashMap<>();
        map.put("sheet_name",strings[0]);
        map.put("row_index",strings[1].split("行")[0]);
        map.put("cell_index",strings[2].split("列")[0]);
        for(String s:map.keySet()){
            Object o = map.get(s);
            System.out.println(o.toString());
        }
        for(Object o:map.values()){
            System.out.println(o.toString());
        }
        Iterator<Map.Entry<String, Object>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next().getValue());
        }

        for (Map.Entry<String,Object> m: map.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }

    }



}
