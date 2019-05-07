package com.mak.framework.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description 基于guava的缓存机制
 *     <p>使用缓存需要考虑的性能问题：内存占用、缓存的命中率、使用频次
 * @since 2019/5/5
 */
@Slf4j
public class CacheDemo {

  public static void main(String[] args) {
    //

    Cache<String, String> stringCache = buildStringCache();

    stringCache.asMap().forEach((k, v) -> log.info("缓存池初始化——>   key:{},value:{}", k, v));
    stringCache.put("hello", "111");

    System.out.println(stringCache.asMap().toString());
    stringCache.asMap().forEach((k, v) -> log.info("插入一个值——>   key:{},value:{}", k, v));
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(
        "10s倒计时结束...,当前缓存池大小："
            + stringCache.size()
            + ",当前获取缓存值："
            + stringCache.getIfPresent("hello"));
    stringCache.asMap().forEach((k, v) -> log.info("访问结束10s之后 ——>   key:{} ,value:{}", k, v));
    //    for (int i = 0; i < 20; i++) {
    //      //
    //    }
  }

  private static Cache<String, String> buildStringCache() {
    Cache<String, String> stringCache =
        CacheBuilder.newBuilder()
            .expireAfterAccess(5, TimeUnit.SECONDS) // 访问后多久失效
            .concurrencyLevel(10) // 并发值
            .maximumSize(20) // 最大值
            .recordStats()
            .build();
    return stringCache;
  }
}
