/**
 * Project:javassist-example
 * Summary: 普通类
 * Copyright@上海一条网络科技有限公司
 */

package com.mak.assist;

import javassist.*;

/**
 * @author maliqiang
 * @version 1.0
 * @description:
 * @date 2018/5/15 下午8:03
 */
public class CreateClass {

    public static void main(String[] args) {
        ClassPool pool = ClassPool.getDefault();
        //创建类
        CtClass ctClass = pool.makeClass("User");

        //
        try {
            // id
            CtField field = new CtField(CtClass.longType,"id",ctClass);
            ctClass.addField(field,"10");

            // age
            CtField ageField = new CtField(CtClass.intType, "age", ctClass);
            ctClass.addField(ageField);


            CtMethod getMethod = CtNewMethod.make("public int getAge() { return this.age;}", ctClass);

            CtMethod setMethod = CtNewMethod.make("public void setAge(int age) { this.age = age;}", ctClass);

            ctClass.addMethod(getMethod);
            ctClass.addMethod(setMethod);
            ctClass.debugWriteFile("/workspace/javassist-example/src/main/java/com/mark");

        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }
}
