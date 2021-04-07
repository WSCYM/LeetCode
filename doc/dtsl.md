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

1. 是否线程安全
2. 效率

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

以后看

### [1.3.3. 比较 HashSet、LinkedHashSet 和 TreeSet 三者的异同](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_133-%e6%af%94%e8%be%83-hashset%e3%80%81linkedhashset-%e5%92%8c-treeset-%e4%b8%89%e8%80%85%e7%9a%84%e5%bc%82%e5%90%8c)

`HashSet` 是 `Set` 接口的主要实现类 ，`HashSet` 的底层是 `HashMap`，线程不安全的，可以存储 null 值；

`LinkedHashSet` 是 `HashSet` 的子类，能够按照添加的顺序遍历；

`TreeSet` 底层使用红黑树，能够按照添加元素的顺序进行遍历，排序的方式有自然排序和定制排序。

### 自己补充：各种集合类存放null值的问题

主要讨论以下几种：

1.Collection接口
单列数据，定义了存取一组对象的方法的集合

1.List接口：可以存放多个null值
有序的可重复的数据 ”动态“数组

具体实现类：ArrayList、LinkedList、Vector
2.Set接口：
无序的、不可重复的数据 就是数学里的集合：无序、确定、互异

具体实现类：HashSet、LinkedHashSet、TreeSet
由于不可重复性只能存放一个null值。
**其中，TreeSet不可存放null值，因为TreeSet底层涉及到要使用compare()和compareto()方法去排序**

2.Map接口
双列数据，保存具有映射关系的“key-value对“的集 就是数学里的函数：y=f(x)

具体实现类：HashMap、LinkedHashMap、TreeMap、HashTable、Properties
由于是映射对，key不可重复，所以key只能有一个null值，但是value可以有很多null值。
**其中，TreeMap由于也涉及排序所以key不能存放null值；HashTable规定key和value都不能存放null值**



### [1.4.1. HashMap 和 Hashtable 的区别](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_141-hashmap-%e5%92%8c-hashtable-%e7%9a%84%e5%8c%ba%e5%88%ab)

1. **线程是否安全：**
2. **效率：** 因为线程安全的问题，`HashMap` 要比 `HashTable` 效率高一点。另外，`HashTable` 基本被淘汰，不要在代码中使用它；
3. **对 Null key 和 Null value 的支持：** 
   1. **初始容量大小和每次扩充容量大小的不同 ：** ① 创建时如果不指定容量初始值，`Hashtable` 默认的初始大小为 11，之后每次扩充，容量变为原来的 2n+1。`HashMap` 默认的初始化大小为 16。之后每次扩充，容量变为原来的 2 倍。② 创建时如果给定了容量初始值，那么 Hashtable 会直接使用你给定的大小，而 `HashMap` 会将其扩充为 2 的幂次方大小（`HashMap` 中的`tableSizeFor()`方法保证，下面给出了源代码）。也就是说 `HashMap` 总是使用 2 的幂作为哈希表的大小,后面会介绍到为什么是 2 的幂次方。
4. **底层数据结构：** JDK1.8 以后的 `HashMap` 在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树）时，将链表转化为红黑树，以减少搜索时间。Hashtable 没有这样的机制。

### [1.4.2. HashMap 和 HashSet 区别](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_142-hashmap-%e5%92%8c-hashset-%e5%8c%ba%e5%88%ab)

如果你看过 `HashSet` 源码的话就应该知道：`HashSet` 底层就是基于 `HashMap` 实现的。（`HashSet` 的源码非常非常少，因为除了 `clone()`、`writeObject()`、`readObject()`是 `HashSet` 自己不得不实现之外，其他方法都是直接调用 `HashMap` 中的方法。

| `HashMap`                              | `HashSet`                                                    |
| -------------------------------------- | ------------------------------------------------------------ |
| 实现了 `Map` 接口                      | 实现 `Set` 接口                                              |
| 存储键值对                             | 仅存储对象                                                   |
| 调用 `put()`向 map 中添加元素          | 调用 `add()`方法向 `Set` 中添加元素                          |
| `HashMap` 使用键（Key）计算 `hashcode` | `HashSet` 使用成员对象来计算 `hashcode` 值，对于两个对象来说 `hashcode` 可能相同，所以` equals()`方法用来判断对象的相等性 |

### [1.4.3. HashMap 和 TreeMap 区别](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_143-hashmap-%e5%92%8c-treemap-%e5%8c%ba%e5%88%ab)

**相比于HashMap来说 TreeMap 主要多了对集合中的元素根据键排序的能力以及对集合内元素的搜索的能力。**



### [1.4.4. HashSet 如何检查重复](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_144-hashset-%e5%a6%82%e4%bd%95%e6%a3%80%e6%9f%a5%e9%87%8d%e5%a4%8d)

**equals()` 方法被覆盖过，则 `hashCode()方法也必须被覆盖**

**`hashCode() `的默认行为是对堆上的对象产生独特值。如果没有重写 `hashCode()`，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）**

### **==与 equals 的区别**

对于基本类型来说，== 比较的是值是否相等；

对于引用类型来说，== 比较的是两个引用是否指向同一个对象地址（两者在内存中存放的地址（堆内存地址）是否指向同一个地方）；

对于引用类型（包括包装类型）来说，equals 如果没有被重写，对比它们的地址是否相等；如果 equals()方法被重写（例如 String），则比较的是地址里的内容。

#### [1.4.5.1. JDK1.8 之前](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_1451-jdk18-%e4%b9%8b%e5%89%8d)

JDK1.8 之前 `HashMap` 底层是 **数组和链表** 结合在一起使用也就是 **链表散列**。**HashMap 通过 key 的 hashCode 经过扰动函数处理过后得到 hash 值，然后通过 (n - 1) & hash 判断当前元素存放的位置（这里的 n 指的是数组的长度），如果当前位置存在元素的话，就判断该元素与要存入的元素的 hash 值以及 key 是否相同，如果相同的话，直接覆盖，不相同就通过拉链法解决冲突。**

**所谓扰动函数指的就是 HashMap 的 hash 方法。使用 hash 方法也就是扰动函数是为了防止一些实现比较差的 hashCode() 方法 换句话说使用扰动函数之后可以减少碰撞。**

#### [1.4.5.2. JDK1.8 之后](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_1452-jdk18-%e4%b9%8b%e5%90%8e)

相比于之前的版本， JDK1.8 之后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为 8）（将链表转换成红黑树前会判断，如果当前数组的长度小于 64，那么会选择先进行数组扩容，而不是转换为红黑树）时，将链表转化为红黑树，以减少搜索时间。

TreeMap、TreeSet 以及 JDK1.8 之后的 HashMap 底层都用到了红黑树。红黑树就是为了解决二叉查找树的缺陷，因为二叉查找树在某些情况下会退化成一个线性结构。

### [1.4.6. HashMap 的长度为什么是 2 的幂次方](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_146-hashmap-%e7%9a%84%e9%95%bf%e5%ba%a6%e4%b8%ba%e4%bb%80%e4%b9%88%e6%98%af-2-%e7%9a%84%e5%b9%82%e6%ac%a1%e6%96%b9)

为了能让 HashMap 存取高效，尽量较少碰撞，也就是要尽量把数据分配均匀。我们上面也讲到了过了，Hash 值的范围值-2147483648 到 2147483647，前后加起来大概 40 亿的映射空间，只要哈希函数映射得比较均匀松散，一般应用是很难出现碰撞的。但问题是一个 40 亿长度的数组，内存是放不下的。所以这个散列值是不能直接拿来用的。用之前还要先做对数组的长度取模运算，得到的余数才能用来要存放的位置也就是对应的数组下标。这个数组下标的计算方法是“ `(n - 1) & hash`”。（n 代表数组长度）。这也就解释了 HashMap 的长度为什么是 2 的幂次方

**这个算法应该如何设计呢？**

我们首先可能会想到采用%取余的操作来实现。但是，重点来了：**“取余(%)操作中如果除数是 2 的幂次则等价于与其除数减一的与(&)操作（也就是说 hash%length==hash&(length-1)的前提是 length 是 2 的 n 次方；）。”** 并且 **采用二进制位操作 &，相对于%能够提高运算效率，这就解释了 HashMap 的长度为什么是 2 的幂次方。**



### [1.4.10. ConcurrentHashMap 线程安全的具体实现方式/底层具体实现](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_1410-concurrenthashmap-%e7%ba%bf%e7%a8%8b%e5%ae%89%e5%85%a8%e7%9a%84%e5%85%b7%e4%bd%93%e5%ae%9e%e7%8e%b0%e6%96%b9%e5%bc%8f%e5%ba%95%e5%b1%82%e5%85%b7%e4%bd%93%e5%ae%9e%e7%8e%b0)

#### [1.4.10.1. JDK1.7（上面有示意图）](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_14101-jdk17%ef%bc%88%e4%b8%8a%e9%9d%a2%e6%9c%89%e7%a4%ba%e6%84%8f%e5%9b%be%ef%bc%89)

首先将数据分为一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据时，其他段的数据也能被其他线程访问。

#### [1.4.10.2. JDK1.8 （上面有示意图）](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_14102-jdk18-%ef%bc%88%e4%b8%8a%e9%9d%a2%e6%9c%89%e7%a4%ba%e6%84%8f%e5%9b%be%ef%bc%89)

`ConcurrentHashMap` 取消了 `Segment` 分段锁，采用 CAS 和 `synchronized` 来保证并发安全。

`synchronized` 只锁定当前链表或红黑二叉树的首节点，这样只要 hash 不冲突，就不会产生并发，效率又提升 N 倍。

## [1.5. Collections 工具类](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_15-collections-%e5%b7%a5%e5%85%b7%e7%b1%bb)

Collections 工具类常用方法:

1. 排序
2. 查找,替换操作
3. 同步控制(不推荐，需要线程安全的集合类型时请考虑使用 JUC 包下的并发集合)

### [1.5.1. 排序操作](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_151-%e6%8e%92%e5%ba%8f%e6%93%8d%e4%bd%9c)

```java
void reverse(List list)//反转
void shuffle(List list)//随机排序
void sort(List list)//按自然排序的升序排序
void sort(List list, Comparator c)//定制排序，由Comparator控制排序逻辑
void swap(List list, int i , int j)//交换两个索引位置的元素
void rotate(List list, int distance)//旋转。当distance为正数时，将list后distance个元素整体移到前面。当distance为负数时，将 list的前distance个元素整体移到后面Copy to clipboardErrorCopied
```

### [1.5.2. 查找,替换操作](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_152-%e6%9f%a5%e6%89%be%e6%9b%bf%e6%8d%a2%e6%93%8d%e4%bd%9c)

```java
int binarySearch(List list, Object key)//对List进行二分查找，返回索引，注意List必须是有序的
int max(Collection coll)//根据元素的自然顺序，返回最大的元素。 类比int min(Collection coll)
int max(Collection coll, Comparator c)//根据定制排序，返回最大元素，排序规则由Comparatator类控制。类比int min(Collection coll, Comparator c)
void fill(List list, Object obj)//用指定的元素代替指定list中的所有元素。
int frequency(Collection c, Object o)//统计元素出现次数
int indexOfSubList(List list, List target)//统计target在list中第一次出现的索引，找不到则返回-1，类比int lastIndexOfSubList(List source, list target).
boolean replaceAll(List list, Object oldVal, Object newVal), 用新元素替换旧元素
```

### [1.5.3. 同步控制](https://snailclimb.gitee.io/javaguide/#/docs/java/collection/Java%E9%9B%86%E5%90%88%E6%A1%86%E6%9E%B6%E5%B8%B8%E8%A7%81%E9%9D%A2%E8%AF%95%E9%A2%98?id=_153-%e5%90%8c%e6%ad%a5%e6%8e%a7%e5%88%b6)

`Collections` 提供了多个`synchronizedXxx()`方法·，该方法可以将指定集合包装成线程同步的集合，从而解决多线程并发访问集合时的线程安全问题。

我们知道 `HashSet`，`TreeSet`，`ArrayList`,`LinkedList`,`HashMap`,`TreeMap` 都是线程不安全的。`Collections` 提供了多个静态方法可以把他们包装成线程同步的集合。

**最好不要用下面这些方法，效率非常低，需要线程安全的集合类型时请考虑使用 JUC 包下的并发集合。**

方法如下：

```java
synchronizedCollection(Collection<T>  c) //返回指定 collection 支持的同步（线程安全的）collection。
synchronizedList(List<T> list)//返回指定列表支持的同步（线程安全的）List。
synchronizedMap(Map<K,V> m) //返回由指定映射支持的同步（线程安全的）Map。
synchronizedSet(Set<T> s) //返回指定 set 支持的同步（线程安全的）set。
```