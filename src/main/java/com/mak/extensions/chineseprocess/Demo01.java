package com.mak.extensions.chineseprocess;

import com.hankcs.hanlp.HanLP;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2018/8/16
 */
public class Demo01 {

  public static void main(String[] args) {
    //最简单的分词，识别词语的种类
    System.out.println(HanLP.segment("你好，欢迎使用HanLP汉语处理包！"));
  }
}
