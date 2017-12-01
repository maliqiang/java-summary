package com.mak.extensions.thread;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test {
     public static void main(String[] args) {
         int CORE_POOL_SIZE = 5;
         int MAX_IMUM_POOL_SIZE = 10;
         int KEEP_ALIVE_TIME = 200;
         ThreadFactory threadFactory = new ThreadFactoryBuilder()
                 .setNameFormat("demo-pool-thread-%d")
                 .build();
         /**
          * @param corePoolSize：线程池维护线程的最少线程数,也是核心线程数,包括空闲线程。
          * @param maximumPoolSize: 线程池维护线程的最大线程数。
          * @param keepAliveTime: 线程池维护线程所允许的空闲时间，单位由后面 unit参数指定。
          * @param unit: 程池维护线程所允许的空闲时间的单位，可选。
          * @param workQueue: 线程池所使用的缓冲队列。
          * @param threadFactory：创建一个新的线程时使用的工厂。
          * @param handler: 线程池对拒绝任务的处理策略。
          */
         ThreadPoolExecutor executor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_IMUM_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.MILLISECONDS,
                 new ArrayBlockingQueue<>(5),threadFactory,new ThreadPoolExecutor.AbortPolicy());
         /**
          * 当一个任务通过execute(Runnable)方法欲添加到线程池时：
          * 1、 如果此时线程池中的数量小于corePoolSize，即使线程池中的线程都处于空闲状态，也要创建新的线程来处理被添加的任务。
          * 2、 如果此时线程池中的数量等于corePoolSize，但是缓冲队列 workQueue未满，那么任务被放入缓冲队列。
          * 3、 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量小于maximumPoolSize，
          * 建新的线程来处理被添加的任务。
          * 4、 如果此时线程池中的数量大于corePoolSize，缓冲队列workQueue满，并且线程池中的数量等于maximumPoolSize，
          * 那么通过 handler所指定的策略来处理此任务。也就是：处理任务的优先级为：核心线程corePoolSize、任务队列workQueue、
          * 最大线程 maximumPoolSize，如果三者都满了，使用handler处理被拒绝的任务。
          * 5、 当线程池中的线程数量大于 corePoolSize时，如果某线程空闲时间超过keepAliveTime，线程将被终止。这样，线程池可以动态的调整池中的线程数。
          *
          */
         for(int i=0;i<15;i++){
             MyTaskThread myTask = new MyTaskThread(i);
             executor.execute(myTask);
             System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
             executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
         }
         executor.shutdown();
     }
}
 
class MyTaskThread implements Runnable {
    private int taskNum;
 
    public MyTaskThread(int num) {
        this.taskNum = num;
    }
 
    @Override
    public void run() {
        System.out.println("正在执行task "+Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}