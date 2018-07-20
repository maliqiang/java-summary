package com.mak.assist;

import com.mak.assist.entity.Foo;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

import java.io.IOException;
import java.lang.reflect.Field;

/**
 * @author Siyuan.mlq
 * @version 1.0
 * @description 动态修改类内容
 * @since 2018/7/20
 */
public class UpdateClass {

  public static void main(String[] args) {
    // init
    ClassPool classPool = ClassPool.getDefault();

    try {
      CtClass ctClass = classPool.get("com.mak.assist.entity.Foo");
      CtClass parentClass = classPool.get("com.mak.assist.entity.Parent");
      // setup super class
      ctClass.setSuperclass(parentClass);
      // output file
      //      ctClass.writeFile();

      // output to byte arrary
      //      byte[] bytes = ctClasslass.toBytecode();

      // output to class
      Class clz = ctClass.toClass();
      Foo child = (Foo) clz.newInstance();
      child.setId(111);
      System.out.println(child.getId());

    } catch (CannotCompileException e) {
      e.printStackTrace();
    } catch (NotFoundException e) {
      e.printStackTrace();
    } catch (InstantiationException e) {
      e.printStackTrace();
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    }
  }
}
