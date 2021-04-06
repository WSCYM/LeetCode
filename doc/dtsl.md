# 1 集合

### [1.1.2. 说说 List,Set,Map 三者的区别？](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_112-%e8%af%b4%e8%af%b4-listsetmap-%e4%b8%89%e8%80%85%e7%9a%84%e5%8c%ba%e5%88%ab%ef%bc%9f)

1. 是否有序
2. 是否可重复
3. 存储形式是否是单列

### [1.1.4. 如何选用集合?](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_114-%e5%a6%82%e4%bd%95%e9%80%89%e7%94%a8%e9%9b%86%e5%90%88)

根据集合的特点来选用，xxxxxxx

### [1.1.5. 为什么要使用集合？](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_115-%e4%b8%ba%e4%bb%80%e4%b9%88%e8%a6%81%e4%bd%bf%e7%94%a8%e9%9b%86%e5%90%88%ef%bc%9f)

答使用数组弊端，

1. 长度不可变
2. 数组元素有序，可重复，特点单一
3. 集合合提高了数据存储的灵活性

### [1.2.1. Arraylist 和 Vector 的区别?](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_121-arraylist-%e5%92%8c-vector-%e7%9a%84%e5%8c%ba%e5%88%ab)

1. 效率
2. 是否线程安全

### [1.2.2. Arraylist 与 LinkedList 区别?](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_122-arraylist-%e4%b8%8e-linkedlist-%e5%8c%ba%e5%88%ab)

1. 是否线程安全
2. 底层数据结构
3. 插入和删除是否受元素位置的影响（AL底层是数组，所以删除一个元素后面的元素都要前移。LL底层是双向链表，所以只需要更改前驱节点和后继节点的引用）
4. 是否支持快速随机访问
5. 内存空间占用（ArrayList需要在列表结尾预留空间，造成内存浪费。LinkedList因为要存放前驱和后继，每个元素消耗更多空间）

#### [1.2.2.2. 补充内容:RandomAccess 接口](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_1222-%e8%a1%a5%e5%85%85%e5%86%85%e5%ae%b9randomaccess-%e6%8e%a5%e5%8f%a3)

1. 内容是空的，起个标识符作用，表示实现该接口的可以被随机访问
2. 举例，ArrayList实现了，LinkedList没有实现。
3. 举例，binarySearch判断传入的 list 是否 `RamdomAccess` 的实例从而调用indexedBinarySearch()或iteratorBinarySearch()。

### [1.2.3. 说一说 ArrayList 的扩容机制吧](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java集合框架常见面试题?id=_123-说一说-arraylist-的扩容机制吧)

难，以后看