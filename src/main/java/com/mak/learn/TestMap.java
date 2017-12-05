/**
 * @file TestMap.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.learn;

import java.util.HashMap;
import java.util.Map;

/**
 * map操作
 * @author maliqiang
 * @create 2017-12-05
 * @version 1.0
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> pageVisits = new HashMap<>();

        String page = "https://agiledeveloper.com";

        incrementPageVisit(pageVisits, page);
        incrementPageVisit(pageVisits, page);

        System.out.println(pageVisits.get(page));
    }

    public static void incrementPageVisit(Map<String, Integer> pageVisits, String page) {
        if(!pageVisits.containsKey(page)) {
            pageVisits.put(page, 0);
        }
        pageVisits.put(page, pageVisits.get(page) + 1);
    }

    public static void mergeMap(Map<String, Integer> pageVisits, String page){
        pageVisits.merge(page,1,(oldValue,value)->oldValue+value);
    }

}
