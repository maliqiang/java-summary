/**
 * @file GenericTest.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions;

/**
 * 泛型使用测试
 *
 * @author maliqiang
 * @version 1.0
 * @create 2017-11-23
 */
public class GenericTest {

    public static <T,R> void out(R r,T... args) {
        System.out.println(r);
        for (T t : args) {
            System.out.println(t);
        }
    }

    public static void main(String []args) {
        out(1,"2",3,4.5);
        out("mark", 123, 11.11, true);
    }


}
