package com.mak.learn;

import java.util.ArrayList;
import java.util.List;

/**
 * list的foreach方法
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-03-20
 */
public class ForEachList {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        /**
         * 普通方法
         */
        for(String str :list){
            System.out.println(str);
        }
        /**
         * java8方法
         */
        list.forEach(item-> System.out.println("Java8："+item));

        list.forEach(System.out::println);

        list.stream().filter(s->s.contains("A")).forEach(System.out::println);
    }

}
