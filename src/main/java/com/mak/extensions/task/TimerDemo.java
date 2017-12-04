/**
 * @file TimerDemo.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.task;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Timer类示例
 * @author maliqiang
 * @create 2017-12-04
 * @version 1.0
 */
public class TimerDemo extends TimerTask {
    private String jobName;

    public TimerDemo(String jobName) {
        super();
        this.jobName = jobName;
    }

    @Override
    public void run() {
        System.out.println("execute " + jobName);
    }


    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        // 任务初次启动执行时的延迟时间
        long initialDelay1 = 1;
        // 从现在开始1秒钟之后，每隔1秒钟执行一次job1
        long period1 = 1;
        service.scheduleAtFixedRate(
                new TimerDemo("job1"), initialDelay1,
                period1, TimeUnit.SECONDS);

        long initialDelay2 = 1;
        // 从现在开始2秒钟之后，每隔2秒钟执行一次job2
        long delay2 = 2;
        service.scheduleWithFixedDelay(
                new TimerDemo("job2"), initialDelay2,
                delay2, TimeUnit.SECONDS);
    }
}
