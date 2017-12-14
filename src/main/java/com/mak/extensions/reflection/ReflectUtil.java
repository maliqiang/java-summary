/**
 * @file ReflectUtil.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.reflection;

import java.lang.reflect.Field;

/**
 * @author maliqiang
 * @version 1.0
 * @create 2017-12-14
 */
public class ReflectUtil {

    public static void setProperty(Object obj, String propertyName, Object value) throws Exception {
        try {
            Class clz = obj.getClass();
            Field property = clz.getDeclaredField(propertyName);
            //取消属性权限检查
            property.setAccessible(true);
            try {
                property.set(obj, value);
            } catch (IllegalAccessException e) {
                throw new Exception(propertyName + "非法访问，异常信息：" + e.getMessage());
            }
        } catch (NoSuchFieldException e) {
            throw new Exception("没有找到对应的属性，异常信息：" + e.getMessage());
        }
    }

    public static void main(String[] args) {
        User user = new User();
        try {
            setProperty(user, "name", "test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getName());
    }
}
