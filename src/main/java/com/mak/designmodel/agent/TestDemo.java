/**
 * Project:java8learn
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.designmodel.agent;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/7/3 下午4:00
 */
public class TestDemo {
    public static void main(String[] args) {
        IAction actor = new Actor();
        IAction agent = new Agent(actor);
        agent.doSomething();
    }
}
