package com.mak.other;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description
 * @since 2018/9/12
 */
public class Test {
  public static void main(String[] args) {
    //
      String str = "NW001新弘站_20180912081735_20180912081819.dav";
      String file = str.substring(0,5)+str.substring(str.length()-34);
    System.out.println(file.substring(0,file.lastIndexOf(".")));
  }
}
