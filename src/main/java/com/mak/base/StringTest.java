/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.base;

import org.junit.Test;

/**
 * @author maliqiang
 * @version 1.0
 * @description:String类相关
 * @date 2018/6/12 下午10:39
 */
public class StringTest {

    @Test
    public void testStringBuffer() {
        StringBuffer stringBuffer = new StringBuffer();
        System.out.println("stringBuffer的初始长度：" + stringBuffer.length());
        System.out.println("stringBuffer的初始容量：" + stringBuffer.capacity());
        stringBuffer.append("abc");
        System.out.println("stringBuffer反向：" + stringBuffer.reverse());

    }


    @Test
    public void testStringBuilder() {

        StringBuilder stringBuilder = new StringBuilder();
        ThreadGroup threadGroup = new ThreadGroup("测试线程组");
        Thread thread1 = new Thread(threadGroup, () -> stringBuilder.append("123"), "thread1");
        Thread thread2 = new Thread(threadGroup, () -> stringBuilder.append("789"), "thread2");
        Thread thread3 = new Thread(threadGroup, () -> stringBuilder.append("000"), "thread3");
        //starting thread
        thread1.start();
        thread2.start();
        thread3.start();

        Thread thread4 = new Thread( () -> stringBuilder.append("111"), "thread4");
        Thread thread5 = new Thread( () -> stringBuilder.delete(2,5), "thread5");
        Thread thread6 = new Thread( () -> stringBuilder.append("555"), "thread6");

        //starting thread
        thread5.start();

        thread4.start();
        thread6.start();

        System.out.println(stringBuilder.toString());
    }

    @Test
    public void getValue(){
       String original = "Hello";
       String test = "Hello";
       System.out.println(original==test);
    }
}
