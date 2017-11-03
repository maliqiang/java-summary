package com.mak.learn;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * stream的使用
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-03-20
 */
public class StreamDemo {
    public static void main(String[] args) throws IOException {
        String data[] = {"1","2","33","46","78","99","36"};
        Stream stream = Stream.of(data);
        Long count = stream.filter(d->d.equals("33")).count();
//        Object rs =stream.filter(d->d.equals("33")).collect(Collectors.toList());//流只能使用一次
        System.out.println("删选出的元素："+count);


        //筛选符合条件的元素
        List<String> list = new ArrayList();
        list.add("44");
        list.add("32");
        list.add("26");
        list.add("47");
        list.add("99");
        List<String> result = list.stream().filter(l->l.equals("99")).collect(Collectors.toList());
        result.forEach(System.out::println);

        //操作顺序不同得到的结果也不同
        operateNormal();
//        operateErr();

      scanFiles();
    }

    /**
     * 扫码文件目录
     * @throws IOException
     */
    private static void scanFiles() throws IOException {
        Files.walk(Paths.get("."))
                .filter(p -> !p.toFile().getName().startsWith("."))
                .forEach(System.out::println);
    }

    private static void operateNormal() {
        IntStream.iterate(0, i -> ( i + 1 ) % 2)
                .limit(10)
                .distinct()
                .forEach(System.out::println);
    }

    /**
     * 并行无限流，是错误的用法
     */
    private static void operateErr() {
        IntStream.iterate(0, i -> ( i + 1 ) % 2)
                .distinct()
                .limit(10)
                .forEach(System.out::println);
    }


}
