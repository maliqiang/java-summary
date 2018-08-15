/**
 * @file User.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.reflection;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.NonNull;

/**
 * @author maliqiang
 * @version 1.0
 * @create 2017-12-14
 */
public class User {
    @JSONField(name = "user_age")
    public String age;

    private Integer id = 0;
    @NonNull
    private String name = "mark";

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JSONField(ordinal = 9)
    public void print(String name) {
        System.out.println("invoke方法执行:" + name);
    }

}
