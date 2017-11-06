package com.mak.extensions.automic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ava.util.concurrent中实现的原子操作类包括：AtomicBoolean、AtomicInteger、AtomicIntegerArray、AtomicLong、AtomicReference、AtomicReferenceArray。
 */
public class AtomicOperationDemo {
    static AtomicInteger count = new AtomicInteger(0);
    static Integer integer = new Integer(0);
    public static void AtomicIntShow() {
        System.out.println("AtomicIntShow() enter");
        ExecutorService threadpool = Executors.newFixedThreadPool(10);

        for (int k = 0; k < 100; k++) {
            threadpool.submit(new AddThread());
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

		 /* output
		  * AtomicIntShow() enter
		  * result of acumulated sum=100000
		  * AtomicIntShow() exit
		  */

        System.out.println("result of acumulated sum=" + count);
        System.out.println("result of acumulated sum=" + integer);
        threadpool.shutdown();
        System.out.println("AtomicIntShow() exit");
        return;

    }

    public static class AddThread implements Runnable {
        @Override
        public void run() {
            for (int k = 0; k < 1000; k++) {
                count.incrementAndGet();
                integer = integer +1;
            }
        }
    }


    public static void main(String[] args) {
        AtomicIntShow();
    }
}
