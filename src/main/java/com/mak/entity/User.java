/**
 * Project:javassist-example
 * Summary: 普通类
 * Copyright@
 */

package com.mak.entity;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/5/21 下午8:05
 */

public class User {
    private Integer age;
    private String name;
    private Integer coverUrl;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(Integer coverUrl) {
        this.coverUrl = coverUrl;
    }

    public User(){}

    public User(Integer age, String name, Integer coverUrl) {
        this.age = age;
        this.name = name;
        this.coverUrl = coverUrl;
    }
}
