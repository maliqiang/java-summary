package com.mak.learn;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description 总和收集
 * @since 2018/8/16
 */
public class ReduceTest {

  public static void main(String[] args) {
    //
    List<Car> list = new ArrayList<>();

    list.add(new Car(1));
    list.add(new Car(4));
    list.add(new Car(3));
    list.add(new Car(2));

    System.out.println(list.stream().collect(Collectors.summarizingInt(a -> a.getWeight())).getSum());
  }
}
