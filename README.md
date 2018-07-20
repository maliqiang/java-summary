# java8
java8 learning example for everyday

>main content
+ forEach使用
+ stream和map
+ 新时间类型使用

# 拓展
### 多线程相关
### 反射相关
### javassist [官方文档](http://www.javassist.org/tutorial/tutorial.html)
+ a. 读取一个类
```$java

```
+ b. 创建一个类
```$java
ClassPool pool = ClassPool.getDefault();
CtClass ctClass = pool.makeClass("className");
CtField field = new CtField(CtClass.longType,"id",ctClass);
ctClass.addField(fieldName,fieldValue);
ctClass.writeFile();
```

+ c. 动态修改一个类




