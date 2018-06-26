/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.extensions.functions;

import java.util.function.Function;

/**
 * @author maliqiang
 * @version 1.0
 * @description:输入参数为类型T， 输出为类型R， 记作 T -> R；
 * 如果参数是两个，可以实现BiFunction接口
 * @date 2018/6/25 下午4:02
 */
public class MyFunction implements Function<String,Integer> {
    @Override
    public Integer apply(String s) {
        return s.length();
    }
}
