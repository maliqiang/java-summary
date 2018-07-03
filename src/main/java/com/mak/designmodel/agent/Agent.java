/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.designmodel.agent;

import java.util.Random;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/7/3 下午3:49
 */
public class Agent implements IAction {

    private IAction action;

    public Agent(IAction action) {
        this.action = action;
    }

    @Override
    public void doSomething() {
        if (new Random().nextBoolean()) {
            System.out.println("代理不安排相关事情");
        } else {
            System.out.println("代理安排，有事进行...");
            action.doSomething();
        }
    }
}
