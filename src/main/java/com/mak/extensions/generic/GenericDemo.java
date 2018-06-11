/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.extensions.generic;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/6/11 上午9:42
 */
public class GenericDemo {

    public static void main(String[] args) {
        System.out.println("输出结果：" + JSON.toJSONString(getList(1, 2L, 3, "50", 6.89D, 1.234F)));
    }


    public static <T> List<T> getList(T... elements) {
        List<T> list = new ArrayList<>();
        for (T t : elements) {
            if (t instanceof Integer) {
                list.add(t);
            }
        }
        return list;
    }
}
