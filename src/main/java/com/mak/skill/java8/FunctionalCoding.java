package com.mak.skill.java8;

import java.util.function.Consumer;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2019/7/12
 */
public class FunctionalCoding {

  public static void main(String[] args) {
    //
      consumer();
  }


    /**
     * Consumer接口有输入无输出
     */
  public static void consumer(){
      Consumer f = System.out::println;
      Consumer f2 = n -> System.out.println(n+"-F2");

      //执行完F后再执行F2的Accept方法
      f.andThen(f2).accept("test");
      //连续执行f的accept方法
      f.andThen(f).andThen(f).andThen(f).accept("test2");
  }
}
