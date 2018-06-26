/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.util;


import org.apache.commons.text.StringEscapeUtils;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/6/26 下午12:02
 */
public class CharsetCode {
    public static void main(String[] args) {
        String result = transferToUnicode("测试");
        System.out.println("编码：" + result);
        System.out.println("解码：" + transferToWord(result));
    }

    /**
     * 转换文字为Unicode
     *
     * @param str
     * @return
     */
    public static String transferToUnicode(String str) {
        return StringEscapeUtils.escapeJava(str);
    }

    /**
     * 转换Unicode为文字
     *
     * @param str
     * @return
     */
    public static String transferToWord(String str) {
        return StringEscapeUtils.unescapeJava(str);
    }
}
