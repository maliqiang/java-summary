/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.extensions.thread;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/7/3 下午3:15
 */
public class JoinDemo {



    public static void main(String[] args) {
        Thread thread = new Thread(()-> System.out.println("Thread ..."));
        Thread threadA = new Thread(()-> System.out.println("Thread A..."));
        Thread threadB = new Thread(()-> System.out.println("Thread B..."));
        Thread threadC = new Thread(()-> System.out.println("Thread C..."));

        try {
            thread.start();
            thread.join();
            threadA.start();
            threadA.join();
            threadB.start();
            threadB.join();
            threadC.start();
            threadC.join(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
