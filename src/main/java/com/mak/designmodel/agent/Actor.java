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
 * @date 2018/7/3 下午3:50
 */
public class Actor implements IAction {
    @Override
    public void doSomething() {
        System.out.println("真实的原对象...发起动作");
    }
}
