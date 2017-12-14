/**
 * @file ReentrantLockDemo.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.multiplethread.mutualexclusion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * @author maliqiang
 * @version 1.0
 * @create 2017-12-13
 */
public class ReentrantLockDemo {

    Lock lock = new ReentrantLock();

    /**
     * 线程未加锁
     */
    public void test() {

        try {
            for (int i = 1; i <= 3; i++) {
                Thread.sleep(1000);
                System.out.println("未加锁测试:ThreadName=" + Thread.currentThread().getName() + "  " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("未加锁测试执行结束...");
        }
    }

    /**
     * 对线程加锁
     */
    public void testLock() {

        try {
            //加锁
            lock.lock();
//            lock.tryLock(200, TimeUnit.SECONDS);
            for (int i = 1; i <= 3; i++) {
                Thread.sleep(1000);
                System.out.println("加锁测试：ThreadName=" + Thread.currentThread().getName() + "  " + i);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //释放锁
            lock.unlock();
            System.out.println("释放锁完成...");
        }
    }


    public void testTryLock(Lock a, Lock b, long timeout) throws InterruptedException {
        int count = 0;
        long fixedDelay = timeout;

        while (true) {
            if (a.tryLock()) {
                try {
                    if (b.tryLock()) {
                        try {
                            // Do Something
                            return;
                        } finally {
                            b.unlock();
                        }
                    }
                } finally {
                    a.unlock();
                }
            }

            ++count;

            if (count > 10) {
                return;
            }
            NANOSECONDS.sleep(fixedDelay % timeout);
        }
    }
}
