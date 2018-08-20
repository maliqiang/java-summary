package com.mak.extensions.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.FutureTask;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description futuretask 使用
 * @since 2018/8/19
 */
@Slf4j
public class FutureTaskExample01 {

  public static void main(String[] args) throws Exception {
    // create task
    FutureTask<Boolean> futureTask =
        new FutureTask<>(
            () -> {
              log.info("do something in task ...");
              Thread.sleep(2000);
              return Boolean.TRUE;
            });

    // call task
    new Thread(futureTask).start();

    log.info("do something in main ...");
    Thread.sleep(1000);
    log.info("The result of task is :{}", futureTask.get());
  }
}
