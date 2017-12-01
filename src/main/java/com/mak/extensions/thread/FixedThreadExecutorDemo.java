/**
 * @file SingleThreadExcecutorDemo.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * SingleThreadExecutor
 * @author maliqiang
 * @create 2017-12-01
 * @version 1.0
 */
public class FixedThreadExecutorDemo {
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        MyThread thread = new MyThread();
        MyThread thread2 = new MyThread();
        MyThread thread3 = new MyThread();
        MyThread thread4 = new MyThread();
        MyThread thread5 = new MyThread();

        executorService.execute(thread);
        executorService.execute(thread2);
        executorService.execute(thread3);
        executorService.execute(thread4);
        executorService.execute(thread5);

        executorService.shutdown();

    }
}
