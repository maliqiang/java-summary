package com.mak.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * foreach循环遍历map
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-03-20
 */
public class ForEachMap {
    public static void main(String[] args) {
        Map<String, Integer> items = new HashMap<>();
        items.put("A", 10);
        items.put("B", 20);
        items.put("C", 30);
        items.put("D", 40);
        items.put("E", 50);
        items.put("F", 60);
        /**
         * 普通遍历
         */
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
        }
        /**
         * Java8遍历
         */
        items.forEach((k,v)-> System.out.println("新遍历方法k:"+k+",v:"+v));
        items.forEach((k,v)->{
            if (k.endsWith("A")){
                System.out.println(v);
            }
        });

    }


}
