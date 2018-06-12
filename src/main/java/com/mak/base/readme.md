## 基础类笔记
### StringBuffer、StringBuilder区别
相同点：
* 内部都是通过append方法进行字符串拓展的
* 初始容量都是字串长度+16，默认构造函数创建是是16

不同点：
* StringBuilder是非线程安全的
* StringBuffer是线程安全的，方法都由synchronized修饰

### ArraryList和Vector区别
* 增长因子：0.75
### HashMap和HashTable，ConcurrentHashMap的区别
* HashMap
  * 初始容量16
  * 非线程安全
  * 重要变量
    + capacity：当前数组容量，始终保持 2^n，可以扩容，扩容后数组大小为当前的 2 倍。
    + loadFactor：负载因子，默认为 0.75。
    + threshold：扩容的阈值，等于 capacity * loadFactor
  * 数据结构
    + JDK7 是数组+链表的数据结构；时间复杂度为O(N)
    + JDK8是红黑树（节点大于8个的时候），所以其由 数组+链表+红黑树 组成。时间复杂度为O(logN)
  * 可以一个null值的key和多个null值的value
* HashTable
  * 初始容量11
  * 线程安全，synchronized修饰
  * 不能有空值的key或value
* ConcurrentHashMap
  * 初始容量16
  * 线程安全的，和HashTable不同的是，使用了segment分段锁的方式，可以通过hash值范围，对一定范围的数据进行锁定。从而实现多线程读，单线程写。
  类似于线程锁ReadWriteLock。

### synchronize和lock的区别