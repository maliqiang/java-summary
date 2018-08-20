package com.mak.extensions.aqs;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description future使用
 * @since 2018/8/19
 */
@Slf4j
public class FutureExample01 {
  public static void main(String[] args) throws Exception {
    //
    ExecutorService executorService = Executors.newCachedThreadPool();
    // commit tasks
    Future<String> future01 = executorService.submit(new MyFutureTask01());
    log.info("do something in main thread...");
    Thread.sleep(1000);
    String result = future01.get();
    log.info("The result of callback is :{}", result);

    Future<Boolean> future02 = executorService.submit(new MyFutureTask02());
    Boolean result02 = future02.get();
    log.info("The result of callback is :{}", result02);
  }

  /** processing of task */
  static class MyFutureTask01 implements Callable<String> {

    @Override
    public String call() throws Exception {
      log.info("{} is running...", this.getClass().getSimpleName());
      Thread.sleep(5000);
      return "Done...";
    }
  }

  /** processing of task */
  static class MyFutureTask02 implements Callable<Boolean> {

    @Override
    public Boolean call() throws Exception {
      log.info("{} is running...", this.getClass().getSimpleName());
      Thread.sleep(5000);
      return Boolean.TRUE;
    }
  }
}
