package com.mak.extensions.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2018/8/19
 */
@Slf4j
public class CyclicBarrierExample01 {

  // 达到屏障点之后会继续后续的操作，设置屏障点为5
  private static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();

    //
    for (int i = 0; i < 10; i++) {
      //
      final int threadNum = i;

      try {
        Thread.sleep(1000);

        executorService.execute(
            () -> {
              try {
                process(threadNum);
              } catch (Exception e) {
                log.error("error{}", e);
              }
            });
      } catch (Exception e) {
        log.error("error{}", e);
      }
    }
    // 释放资源
    executorService.shutdown();
  }

  private static void process(int threadNum) throws Exception {

    Thread.sleep(1000);
    log.info("thread {} is ready!", threadNum);
    cyclicBarrier.await();
    log.info("{},process is starting...", threadNum);
    //    log.info("main thread is working...");
  }
}
