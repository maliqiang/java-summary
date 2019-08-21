/**
 * @file ReflectUtil.java
 * @project java8learn
 * @copyright 无锡雅座在线科技股份有限公司
 */
package com.mak.extensions.reflection;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.extern.slf4j.Slf4j;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * @author maliqiang
 * @version 1.0
 * @create 2017-12-14
 */
@Slf4j
public class ReflectUtil {

  public static void setProperty(Object obj, String propertyName, Object value) throws Exception {
    try {
      Class clz = obj.getClass();
      Field property = clz.getDeclaredField(propertyName);
      // 取消属性权限检查，即运行时private的值是可以通过反射的方式修改的
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
    //    clzOperation();
    String clzPath = "com.mak.extensions.reflection.User";
    clzByPath(clzPath);
  }

  /**
   * 根据完整类路径反射获取信息
   *
   * @param clzPath
   */
  private static void clzByPath(String clzPath) {

    try {
      Class clz = Class.forName(clzPath);
      Field[] fields = clz.getFields();
      Arrays.stream(fields).forEach(f -> log.info("当前类包含的变量：{}", f));
      Method[] methods = clz.getDeclaredMethods();
      Arrays.stream(methods).forEach(f -> log.info("当前类包含的方法：{}", f));
    } catch (ClassNotFoundException e) {
      log.error("找不到当前类：{}", clzPath);
      e.printStackTrace();
    }
  }

  /** 通过实体对象反射获取信息 */
  private static void clzOperation() {
    User user = new User();

    Class clz = user.getClass();
    Field[] fields = clz.getFields();

    boolean hasAnnotation = fields[0].isAnnotationPresent(JSONField.class);
    if (hasAnnotation) {
      JSONField jsonField = fields[0].getAnnotation(JSONField.class);
      System.out.println("annotationValue:" + jsonField.name());
    }
    System.out.println(fields[0].getType());
    // 返回底层类的完整名称
    System.out.println(clz.getTypeName());
    System.out.println(clz.getName());
    // 返回底层类的规范名称,即完整的类路径名称
    System.out.println(clz.getCanonicalName());
    // 获取类的名称
    System.out.println(clz.getSimpleName());
    System.out.println(clz.isPrimitive());
    int modifiers = clz.getModifiers();
    System.out.println(Modifier.isAbstract(modifiers));
    // 直接输出修饰符
    System.out.println(Modifier.toString(modifiers));

    try {
      /** 获取注解 */
      Annotation[] annotation = clz.getAnnotations();
      List<Annotation> annotations = Arrays.asList(annotation);
      annotations.forEach(System.out::println);
      Annotation annotation1 = annotations.get(0);
      System.out.println("annotationName:" + annotation1);

      Method method = clz.getMethod("print", String.class);
      System.out.println(method.getName());
      // 获取注解的值
      System.out.println(method.getAnnotation(JSONField.class).ordinal());
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
