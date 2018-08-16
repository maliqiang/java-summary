package com.mak.extensions.chineseprocess;

import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.StandardTokenizer;

import java.util.List;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description 标准分词
 * @since 2018/8/16
 */
public class Demo02 {
  public static void main(String[] args) {
    //
      List<Term> termList = StandardTokenizer.segment("商品和服务");
      System.out.println(termList);
  }
}
