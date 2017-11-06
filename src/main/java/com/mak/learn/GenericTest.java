/**
 * @file GenericTest.java
 * @project SpringWind
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author maliqiang
 * @version 1.0
 * @create 2017-11-01
 */
public class GenericTest {
    public static void main(String[] args) {
        //编译时会擦除类型
        Class clz1 = new ArrayList<Integer>().getClass();
        Class clz2 = new ArrayList<Long>().getClass();
        System.out.println(clz1 == clz2);


        // 1. Individual values
        Stream stream = Stream.of("a", "b", "c");
        // 2. Arrays
        String[] strArray = new String[]{"a", "b", "c"};
        stream = Stream.of(strArray);
        stream = Arrays.stream(strArray);
        // 3. Collections
        List<String> list = Arrays.asList(strArray);
        stream = list.stream();
        Object rs[] = stream.filter(l -> l.equals("a")).toArray();
        System.out.println(rs[0]);

        List<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(4);
        list1.add(5);
        List list2 = list1.stream().map(l -> l * 2).collect(Collectors.toList());
        list2.forEach(System.out::println);


        Integer[] sixNums = {1, 2, 3, 4, 5, 6};
        Integer[] evens = Stream.of(sixNums).filter(n -> n % 2 == 0).toArray(Integer[]::new);
        for (int i = 0; i <evens.length ; i++) {
            System.out.println(evens[i]);
        }
    }
}
