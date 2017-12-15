/**
 * @file ReflectUtil.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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

        Class clz = user.getClass();
        Field[] fields = clz.getFields();
        System.out.println(fields[0].getType());
        //返回底层类的完整名称
        System.out.println(clz.getTypeName());
        System.out.println(clz.getName());
        //返回底层类的规范名称
        System.out.println(clz.getCanonicalName());
        //获取类的名称
        System.out.println(clz.getSimpleName());
        System.out.println(clz.isPrimitive());
        int modifiers = clz.getModifiers();
        System.out.println(Modifier.isAbstract(modifiers));
        //直接输出修饰符
        System.out.println(Modifier.toString(modifiers));


        try {
            Method method = clz.getMethod("print", String.class);
            System.out.println(method.getName());
            try {
                Object obj = clz.newInstance();
                try {
                    method.invoke(obj, "方法执行测试");
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            setProperty(user, "name", "test");
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(user.getName());
    }
}
