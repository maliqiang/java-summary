# java8
java8 learning example for everyday

>main content
+ forEach使用
+ stream和map
+ 新时间类型使用

# 拓展
### 多线程相关
* AQS
* JUC
### 反射相关
### javassist [官方文档](http://www.javassist.org/tutorial/tutorial.html)
+ a. 读取一个类
``` java

```
+ b. 创建一个类
``` java
ClassPool pool = ClassPool.getDefault();
CtClass ctClass = pool.makeClass("className");
CtField field = new CtField(CtClass.longType,"id",ctClass);
ctClass.addField(fieldName,fieldValue);
ctClass.writeFile();
```
+ c. 冻结类和激活
``` java
// 当执行writeFile(), toClass(), or toBytecode()方法时，类会被冻结。
// JVM已经加载的类，修改之后不会被重新加载。
// 调用defrost之后就可以对类继续进行动态操作。
cc.defrost();
```
+ d. doPruning默认是false，被置成true后，除了注释、方法签名、注解之外的内容不能被修改。
cc.stopPruning(true);
+ e. 动态修改一个类
```java
C
```
+ f.附加classpath
``` java
//第一种
pool.insertClassPath(new ClassClassPath(this.getClass()));
//第二种
pool.insertClassPath("xxx/lib");
//第三种，远程类路径加载
ClassPath cp = new URLClassPath("www.javassist.org", 80, "/java/", "org.javassist.");

```
+ g. 从classPool中移除类
``` java
ctClass.detach();
```




