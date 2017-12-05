/**
 * @file Test.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.filter;

import java.util.Comparator;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * 利用管道过滤数据
 * @author maliqiang
 * @create 2017-12-05
 * @version 1.0
 */
public class Test {


    public static void main(String[] args) {
        List<Car> cars = Iterating.createCars();
        List<String> result = cars.stream()
        .filter(c->c.getYear()>2000)
        .sorted(Comparator.comparing(Car::getYear))
        .map(Car::getModel)
        .collect(toList());


        // 输出结果
        cars.forEach(System.out::println);
        result.forEach(System.out::println);
    }
}
