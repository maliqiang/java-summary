package com.mak.framework.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
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

    // 最大容量控制的缓存
    Cache<Integer, Integer> cache = buildHasCapacity();
    for (int i = 1; i < 30; i++) {
      //
      cache.put(i, i);
      if (cache.size() == 20) {
        log.error("缓存总数量为：{}", cache.size());
        cache.asMap().forEach((k, v) -> log.info("key:{} ,value:{}", k, v));
      }
      log.error("缓存总数量为：{}", cache.size());
      cache.asMap().forEach((k, v) -> log.info("key:{} ,value:{}", k, v));

    }

    //缓存回收
    List<Integer> keys = Arrays.asList(20,19,18,17);
    cache.invalidateAll(keys); //释放部分key的值
    cache.asMap().forEach((k, v) -> log.info("释放部分数据之后，key:{} ,value:{}", k, v));
    cache.invalidateAll(); //释放所有
    log.info("释放所有数据之后",cache.size());
  }

  private static Cache<String, String> buildStringCache() {
    Cache<String, String> stringCache =
        CacheBuilder.newBuilder()
            .expireAfterAccess(5, TimeUnit.SECONDS) // 访问后多久失效
            .concurrencyLevel(Runtime.getRuntime().availableProcessors()) // 并发值,推荐设置为当前机器的CPU核心数
            .maximumSize(20) // 最大值
            .recordStats()
            .build();
    return stringCache;
  }

  private static Cache<Integer, Integer> buildHasCapacity() {
    return CacheBuilder.newBuilder()
            .maximumSize(10)
            .build();
  }
}
