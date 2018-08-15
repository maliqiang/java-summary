package com.mak.extensions.currency;

import java.util.concurrent.*;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2018/7/25
 */
public class CurrencyDemo01 {

  private static int i = 0;

  private static int threadTotal = 200;

  public static void main(String[] args) {

    // 200个线程处理请求
    Semaphore semaphore = new Semaphore(threadTotal);
    ExecutorService executorService = Executors.newCachedThreadPool();
    // 模拟5000个用户
    for (int j = 0; j < 5000; j++) {
      executorService.execute(
          () -> {
            try {
              semaphore.acquire();
              counter();
              semaphore.release();
            } catch (Exception e) {
              e.printStackTrace();
            }
          });
    }
    executorService.shutdown();
    System.out.println(i);
  }

  private static void counter() {
    //
    i++;
  }
}
