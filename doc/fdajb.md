# 算法

## 位运算

![1604586652791](C:\Users\ym\AppData\Roaming\Typora\typora-user-images\1604586652791.png)

​	<<表示左移移，不分正负数，低位补0；

​	\>>表示右移，如果该数为正，则高位补0，若为负数，则高位补1；

​	\>>>表示无符号右移，也叫逻辑右移，即若该数为正，则高位补0，而若该数为负数，则右移后高位同样补0



“与运算”的特殊用途：

（1）清零。如果想将一个单元清零，即使其全部二进制位为0，只要与一个各位都为零的数值相与，结果为零。

（2）取一个数中指定位

方法：找一个数，对应X要取的位，该数的对应位为1，其余位为零，此数与X进行“与运算”可以得到X中的指定位。



“或运算”特殊作用：

（1）常用来对一个数据的某些位置为1。

方法：找到一个数，对应X要置1的位，该数的对应位为1，其余位为零。此数与X相或可使X中的某些位置1。

### 位运算模拟加法

1.递归

这题位运算还是背下来吧，毕竟位运算这种模拟加法用法基本就这题，很容易就忘掉。。。。。

^ 亦或 ----相当于 无进位的求和， 想象10进制下的模拟情况：（如:19+1=20；无进位求和就是10，而非20；因为它不管进位情况）

& 与 ----相当于求每位的进位数， 先看定义：1&1=1；1&0=0；0&0=0；即都为1的时候才为1，正好可以模拟进位数的情况,还是想象10进制下模拟情况：（9+1=10，如果是用&的思路来处理，则9+1得到的进位数为1，而不是10，所以要用<<1向左再移动一位，这样就变为10了）；

这样公式就是：（a^b) ^ ((a&b)<<1) 即：每次无进位求 + 每次得到的进位数--------我们需要不断重复这个过程，直到进位数为0为止；

```java
public int add(int a, int b) {
        if(a == 0){
            return b;
        }
        if(b == 0){
            return a;
        }
        return add(a^b, (a&b) << 1);
    }
```

2.while

```java
public int add(int a, int b) {
        while (b != 0) { // 当进位为 0 时跳出
            int c = (a & b) << 1;  // c = 进位
            a ^= b; // a = 非进位和
            b = c; // b = 进位
        }
        return a;
    }
```

来自[剑指 Offer 65. 不用加减乘除做加法](https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof/)



## 数组

### 滑动窗口算法及模板

什么是滑动窗口

滑动窗口可以看成数组中框起来的一个部分。在一些数组类题目中，我们可以用滑动窗口来观察可能的候选结果。当滑动窗口从数组的左边滑到了右边，我们就可以从所有的候选结果中找到最优的结果。

滑动窗口法可以用来解决一些查找满足一定条件的连续区间的性质（长度等）问题，个人认为可以看做是一种双指针方法的特例，两个指针都起始于原点，并一前一后向终点前进。还有一种双指针方法，其两个指针一始一终，并相向靠近，这种方法的内在思想和滑动窗口也非常类似

![1604660402967](C:\Users\ym\AppData\Roaming\Typora\typora-user-images\1604660402967.png)

模板:

```swift
int left = 0, right = 0;
while (right < s.size()) {
    // 增大窗口
    window.add(s[right]);
    right++;

    while (window needs shrink) {
        // 缩小窗口
        window.remove(s[left]);
        left++;
    }
}
```

## 树

### 后序遍历

树的后序遍历 / 深度优先搜索往往利用 递归 或 栈 实现，本文使用递归实现。
关键点： 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度 等于 左子树的深度 与 右子树的深度 中的 最大值 +1 。

![Picture1.png](https://pic.leetcode-cn.com/9b063f1f2b7ba125b97a2a11c5f774c0f8ff4df594696993a8eb8282750dae0d-Picture1.png)

算法解析：
终止条件： 当 root 为空，说明已越过叶节点，因此返回 深度 0 。
递推工作： 本质上是对树做后序遍历。
计算节点 root 的 左子树的深度 ，即调用 maxDepth(root.left)；
计算节点 root 的 右子树的深度 ，即调用 maxDepth(root.right)；
返回值： 返回 此树的深度 ，即 max(maxDepth(root.left), maxDepth(root.right)) + 1。

复杂度分析：
时间复杂度 O(N)O(N) ： NN 为树的节点数量，计算树的深度需要遍历所有节点。
空间复杂度 O(N)O(N) ： 最差情况下（当树退化为链表时），递归深度可达到 NN 。



```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
```

### 层序遍历

- 树的层序遍历 / 广度优先搜索往往利用 **队列** 实现。
- **关键点：** 每遍历一层，则计数器 +1，直到遍历完成，则可得到树的深度。

算法解析：
特例处理： 当 root 为空，直接返回 深度 0 。
初始化： 队列 queue （加入根节点 root ），计数器 res = 0。
循环遍历： 当 queue 为空时跳出。
初始化一个空列表 tmp ，用于临时存储下一层节点；
遍历队列： 遍历 queue 中的各节点 node ，并将其左子节点和右子节点加入 tmp；
更新队列： 执行 queue = tmp ，将下一层节点赋值给 queue；
统计层数： 执行 res += 1 ，代表层数加 1；
返回值： 返回 res 即可

复杂度分析：
时间复杂度 O(N) ： N 为树的节点数量，计算树的深度需要遍历所有节点。
空间复杂度 O(N) ： 最差情况下（当树平衡时），队列 queue 同时存储 N/2 个节点。

```java
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        List<TreeNode> queue = new LinkedList<>() {{ add(root); }}, tmp;
        int res = 0;
        while(!queue.isEmpty()) {
            tmp = new LinkedList<>();
            for(TreeNode node : queue) {
                if(node.left != null) tmp.add(node.left);
                if(node.right != null) tmp.add(node.right);
            }
            queue = tmp;
            res++;
        }
        return res;
    }
}
```

### 二叉搜索树

​	二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的[二叉树](https://baike.baidu.com/item/%E4%BA%8C%E5%8F%89%E6%A0%91/1602879)： 若它的左子树不空，则左子树上所有结点的值均小于它的[根结点](https://baike.baidu.com/item/%E6%A0%B9%E7%BB%93%E7%82%B9/9795570)的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为[二叉排序树](https://baike.baidu.com/item/%E4%BA%8C%E5%8F%89%E6%8E%92%E5%BA%8F%E6%A0%91/10905079)。

​	特性：通过中序遍历所得到的序列，就是有序的

## 字符串

### 大数问题

![1604403968667](C:\Users\ym\AppData\Roaming\Typora\typora-user-images\1604403968667.png)

大数打印解法：
实际上，本题的主要考点是大数越界情况下的打印。需要解决以下三个问题：

1. 表示大数的变量类型：
    无论是 short / int / long ... 任意变量类型，数字的取值范围都是有限的。因此，大数的表示应用字符串 String 类型。
2. 生成数字的字符串集：
    使用 int 类型时，每轮可通过 +1+1 生成下个数字，而此方法无法应用至 String 类型。并且， String 类型的数字的进位操作效率较低，例如 "9999" 至 "10000" 需要从个位到千位循环判断，进位 4 次。

观察可知，生成的列表实际上是 nn 位 00 - 99 的 全排列 ，因此可避开进位操作，通过递归生成数字的 String 列表。

3. 递归生成全排列：
    基于分治算法的思想，先固定高位，向低位递归，当个位已被固定时，添加数字的字符串。例如当 n = 2n=2 时（数字范围 1 - 991−99 ），固定十位为 00 - 99 ，按顺序依次开启递归，固定个位 00 - 99 ，终止递归并添加数字字符串。

![Picture1.png](https://pic.leetcode-cn.com/83f4b5930ddc1d42b05c724ea2950ee7f00427b11150c86b45bd88405f8c7c87-Picture1.png)

```java
class Solution {
    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder(); // 数字字符串集
        num = new char[n]; // 定义长度为 n 的字符列表
        dfs(0); // 开启全排列递归
        res.deleteCharAt(res.length() - 1); // 删除最后多余的逗号
        return res.toString(); // 转化为字符串并返回
    }
    void dfs(int x) {
        if(x == n) { // 终止条件：已固定完所有位
            res.append(String.valueOf(num) + ","); // 拼接 num 并添加至 res 尾部，使用逗号隔开
            return;
        }
        for(char i : loop) { // 遍历 ‘0‘ - ’9‘
            num[x] = i; // 固定第 x 位为 i
            dfs(x + 1); // 开启固定第 x + 1 位
        }
    }
}
```

![1604404212508](C:\Users\ym\AppData\Roaming\Typora\typora-user-images\1604404212508.png)

![1604404221002](C:\Users\ym\AppData\Roaming\Typora\typora-user-images\1604404221002.png)

![1604404233871](C:\Users\ym\AppData\Roaming\Typora\typora-user-images\1604404233871.png)

```java
class Solution {
    int[] res;
    int nine = 0, count = 0, start, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public int[] printNumbers(int n) {
        this.n = n;
        res = new int[(int)Math.pow(10, n) - 1];
        num = new char[n];
        start = n - 1;
        dfs(0);
        return res;
    }
    void dfs(int x) {
        if(x == n) {
            String s = String.valueOf(num).substring(start);
            if(!s.equals("0")) res[count++] = Integer.parseInt(s);
            if(n - start == nine) start--;
            return;
        }
        for(char i : loop) {
            if(i == '9') nine++;
            num[x] = i;
            dfs(x + 1);
        }
        nine--;
    }
}
```



常用API

```
Collections.reverse(xx)
将xx集合逆序
```



## dp



![QQ图片20201110123639](F:\mdImg\dp1.png)

![QQ图片20201110123722](F:\mdImg\dp2.png)

![dp3](F:\mdImg\dp3.png)