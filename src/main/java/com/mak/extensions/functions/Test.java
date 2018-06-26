/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.extensions.functions;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/6/25 下午4:48
 */
public class Test {
    public static void main(String[] args) {
        Integer length = new MyFunction().apply("hello");
        System.out.println(length);
    }

}
