/**
 * @file LockTest.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.multiplethread.mutualexclusion;

/**
 * 加锁
 * @author maliqiang
 * @version 1.0
 * @create 2017-12-13
 */
public class LockTest {


    public static void main(String[] args) {

        ReentrantLockDemo demo = new ReentrantLockDemo();
        /**
         * 未加锁测试
         */
        MyThread thread = new MyThread(demo);
        MyThread thread2 = new MyThread(demo);
        new Thread(thread).start();
        new Thread(thread2).start();


        /**
         * 加锁测试
         */

        MyLockThread myLockThread = new MyLockThread(demo);
        MyLockThread myLockThread2 = new MyLockThread(demo);
        myLockThread.start();
        myLockThread2.start();
    }
}


class MyThread implements Runnable {
    private ReentrantLockDemo reentrantLockDemo;

    public MyThread(ReentrantLockDemo reentrantLockDemo) {
        this.reentrantLockDemo = reentrantLockDemo;
    }

    @Override
    public void run() {
        reentrantLockDemo.test();
    }
}

class MyLockThread extends Thread{
    private ReentrantLockDemo reentrantLockDemo;

    public MyLockThread(ReentrantLockDemo reentrantLockDemo){
        this.reentrantLockDemo = reentrantLockDemo;
    }
    @Override
    public void run() {
        reentrantLockDemo.testLock();
    }
}