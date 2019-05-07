package com.mak.skill.chaincoding;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description 使用链式编程方式构建一个对象
 * @since 2019/5/7
 */
public class BuilderTest {

  public static void main(String[] args) {
    //
      BuilderDemo buildDemo = BuilderDemo.builder()
              .env("dev")
              .expireTime(2000)
              .url("https://maliqiang.github.io/")
              .build();

    System.out.println(buildDemo.toString());
  }
}
