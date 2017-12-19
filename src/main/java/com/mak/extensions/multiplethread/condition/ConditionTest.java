package com.mak.extensions.multiplethread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author maliqiang
 * @description 多线程condition示例，可精确控制线程的休眠和唤醒
 * @date 2017年12月19日
 */
public class ConditionTest {
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();

    public static void main(String[] args) {

        ThreadA ta = new ThreadA("demo");

        lock.lock(); // 获取锁
        try {
            System.out.println(Thread.currentThread().getName() + " start demo");
            ta.start();

            System.out.println(Thread.currentThread().getName() + " block");
            // 等待
            condition.await();

            System.out.println(Thread.currentThread().getName() + " continue");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    static class ThreadA extends Thread {

        public ThreadA(String name) {
            super(name);
        }

        @Override
        public void run() {
            // 获取锁
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + " wakup others");
                // 唤醒“condition所在锁上的其它线程”
                condition.signal();
            } finally {
                // 释放锁
                lock.unlock();
            }
        }
    }
}