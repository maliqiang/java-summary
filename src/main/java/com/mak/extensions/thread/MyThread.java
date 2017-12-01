/**
 * @file MyThread.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.thread;

/**
 *
 * @author maliqiang
 * @create 2017-12-01
 * @version 1.0
 */
public class MyThread  implements Runnable{
    @Override
    public void run() {
        System.out.println("线程："+Thread.currentThread().getId()+"正在执行...");
    }
}
