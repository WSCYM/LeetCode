# 算法

## 排序

### 冒泡排序

```java
public class BubbleSort {
    void sort(int[] nums,int n){
        boolean swapped;
        for (int i = 1;i<n;i++){
            swapped = false;
            for (int j = 1;j<n-i+1;j++){
                if (nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }
    }
}
```

### 选择排序

```java
public class SelectSort {
    void sort(int[] nums,int n){
        int mid;
        for (int i = 0;i<n-1;i++){
            mid = i;
            for (int j = i+1;j<n;j++){
                if (nums[j]<nums[mid]){
                    mid = j;
                }
            }
            int tmp = nums[mid];
            nums[mid] = nums[i];
            nums[i] = tmp;
        }
    }
}

```

### 插入排序

```java
public class InsertionSort {
    void sort(int[] nums,int n){
        for (int i = 0;i<n;i++){
            for (int j = i;j>0 && nums[j]<nums[j-1];j--){
                if (nums[j]>=nums[j-1]) break;
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
            }
        }
    }
}
```

### 归并排序

```java
public class MergeSort {
    //左闭右开
    void sort(int[] nums,int l,int r,int[] temp){
        if (l+1>=r){
            return;
        }
        int m = l+(r-l)/2;
        sort(nums,l,m,temp);
        sort(nums,m,r,temp);
        int p=l,q=m,i=l;
        while (p<m || q<r){
            if (q>=r || (p<m && nums[p]<nums[q])){
                temp[i++] = nums[p++];
            } else {
                temp[i++] = nums[q++];
            }
        }
        for (i=l;i<r;i++){
            nums[i] = temp[i];
        }
    }
}
```

### 快速排序

```java
public class QuickSort {
    //左闭右开
    public void sort(int[] nums,int l,int r){
        if (l+1>=r){
            return;
        }
        int first = l;int last = r-1;int key = nums[first];
        while (first<last){
            while (first<last && nums[last]>=key){
                last--;
            }
            nums[first] = nums[last];
            while (first<last && nums[first]<=key){
                first++;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        sort(nums,l,first);
        sort(nums,first+1,r);
    }
}
```

#### 快排变形题

215.[[数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

### 桶排序

```java
public class BucketSort {
    //按频次排序
    public int[] bucketSort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key : hashMap.keySet()){
            if (bucket[hashMap.get(key)]==null) bucket[hashMap.get(key)] = new ArrayList<>();
            bucket[hashMap.get(key)].add(key);
        }
        for (int i =0;i<bucket.length;i++){
            if (bucket[i]==null) continue;
            res.addAll(bucket[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
```

#### 桶排序变形题

​	[前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

### 堆排序

```java
public class HeapSort {

    public void sort(int[] nums){
        int heapSize = nums.length;
        buildMaxHeap(nums,heapSize);
        for (int i = nums.length-1;i>=0;i--){
            swap(nums,0,i);
            heapSize--;
            maxHeapify(nums,0,heapSize);
        }
    }
	//建堆
    //从最后一个非叶子节点开始调整
    public void buildMaxHeap(int[] nums,int heapSize){
        for (int i = nums.length/2;i>=0;i--){
            maxHeapify(nums,i,heapSize);
        }
    }
	以第i个位置为根的子树调整为最大堆
    public void maxHeapify(int[] a,int i,int heapSize){
        int l=2*i+1;
        int r = 2*i+2;
        int largest = i;
        if (l<heapSize && a[l]>a[largest]){
            largest = l;
        }
        if (r<heapSize && a[r]>a[largest]){
            largest = r;
        }
        if (largest!=i){
            swap(a,i,largest);
            maxHeapify(a,largest,heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
```

#### 堆排序变形题

[数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

## 数组

### 二分查找



二分查找思考方式，写的不错：

1.https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/da-jia-bu-yao-kan-labuladong-de-jie-fa-fei-chang-2/

2.https://www.cnblogs.com/kyoner/p/11080078.html

 tips:求最小化的最大值或者求最大化的最小值  eg.[1552. 两球之间的磁力](https://leetcode-cn.com/problems/magnetic-force-between-two-balls/)

while (left <= right)	简单问题用，在循环体里能找到答案以后退出。
while (left < right)	复杂问题用，把答案留到退出循环以后，再判断。是解决二分问题的利器，尤其在边界问题用，这种方式考虑细节最少，但是需要一定练习才能灵活运用。

**写二分查找时要考虑剩余两个元素时是否会死循环**

**注意：**

**第一种方式向左收缩时right= mid - 1**

**第二种方式向左收缩时right= mid**

**若left=mid会进入死循环**

#### 模板1

```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length - 1;
  while(left <= right){
  
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid - 1; }
  }

  return -1;
}
```

##### 关键属性

二分查找的最基础和最基本的形式。
查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。

##### 区分语法

初始条件：left = 0, right = length-1
终止：left > right
**向左查找：right = mid-1 **
向右查找：left = mid+1

#### 模板2

```java
int binarySearch(int[] nums, int target){
  if(nums == null || nums.length == 0)
    return -1;

  int left = 0, right = nums.length;
  while(left < right){
    int mid = left + (right - left) / 2;
    if(nums[mid] == target){ return mid; }
    else if(nums[mid] < target) { left = mid + 1; }
    else { right = mid; }
  }

  if(left != nums.length && nums[left] == target) return left;
  return -1;
}
```



模板 #2 是二分查找的高级模板。它用于查找需要*访问数组中当前索引及其直接右邻居索引*的元素或条件。

##### 关键属性

一种实现二分查找的高级方法。
查找条件需要访问元素的直接右邻居。
使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
保证查找空间在每一步中至少有 2 个元素。
需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。

##### 区分语法

初始条件：left = 0, right = length
终止：left == right
**向左查找：right = mid **
向右查找：left = mid+1

#### 模板2-2

```java
public int findMin(int[] nums) {
        int left = 0,right = nums.length-1;
        while (left<right){
            int mid = left + (right-left)/2;
            if (条件){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
```

#### 模板3

```java
int binarySearch(int[] nums, int target) {
    if (nums == null || nums.length == 0)
        return -1;

    int left = 0, right = nums.length - 1;
    while (left + 1 < right){
        // Prevent (left + right) overflow
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        } else if (nums[mid] < target) {
            left = mid;
        } else {
            right = mid;
        }
    }

    // Post-processing:
    // End Condition: left + 1 == right
    if(nums[left] == target) return left;
    if(nums[right] == target) return right;
    return -1;
}
```

模板 #3 是二分查找的另一种独特形式。 它用于搜索需要*访问当前索引及其在数组中的直接左右邻居索引*的元素或条件。

##### 关键属性

实现二分查找的另一种方法。
搜索条件需要访问元素的直接左右邻居。
使用元素的邻居来确定它是向右还是向左。
保证查找空间在每个步骤中至少有 3 个元素。
需要进行后处理。 当剩下 2 个元素时，循环 / 递归结束。 需要评估其余元素是否符合条件。

##### 区分语法

初始条件：left = 0, right = length-1
终止：left + 1 == right
向左查找：right = mid
向右查找：left = mid



#### 快速幂

```java
double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            } 
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
```





### 滑动窗口算法及模板

什么是滑动窗口

滑动窗口可以看成数组中框起来的一个部分。在一些数组类题目中，我们可以用滑动窗口来观察可能的候选结果。当滑动窗口从数组的左边滑到了右边，我们就可以从所有的候选结果中找到最优的结果。

滑动窗口法可以用来解决一些查找满足一定条件的连续区间的性质（长度等）问题，个人认为可以看做是一种双指针方法的特例，两个指针都起始于原点，并一前一后向终点前进。还有一种双指针方法，其两个指针一始一终，并相向靠近，这种方法的内在思想和滑动窗口也非常类似

![1604660402967](.\imgs\hdck.png)

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

e:[76最小覆盖子串](https://leetcode-cn.com/problems/minimum-window-substring/)

记住本题中将check优化到O(1)的方法

### 众数问题

​	摩尔投票算法



## 树

### 二叉树 前中后序遍历迭代模板

只有注释的地方需要注意

```java	
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                //res.add(p.val);
                stack.push(p);
                p=p.left;//p=p.right
            }
            p = stack.pop();
            //res.add(p.val);
            p=p.right;//p=p.left
        }
        //Collections.reverse(res);
        return res;
    }
```

#### 前序遍历

只有注释地方需要改动 根->左->右

```java
public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                //res.add(p.val);
                stack.push(p);
                //p=p.left;
            }
            p = stack.pop();
            //p=p.right;
        }
        return res;
}
```

#### 中序遍历

只有注释地方需要改动 左->根->右

```java
public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                stack.push(p);
                //p=p.left;
            }
            p = stack.pop();
            //res.add(p.val);
            //p=p.right;
        }
        return res;
}
```

#### 后序遍历

只有注释地方需要改动 

根->右->左 + 逆序 即为 左右根

```java
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root==null) return res;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p!=null || !stack.isEmpty()){
            while (p!=null){
                //res.add(p.val);
                stack.push(p);
                //p=p.right;
            }
            p = stack.pop();
            //p=p.left;
        }
        //Collections.reverse(res);
        return res;
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

### 根据前中（前后||中后）遍历序列构造二叉树模板



#### 根据前中序列构造二叉树

```java
public class test {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    }

    TreeNode helper(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
		//递归出口
        if (preStart > preEnd) {
            return null;
        }
        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        if (preStart==preEnd) {
            return root;
        }
        //获得根节点在另一个数组中的索引
        int index = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        //计算左子树节点数
        int leftSize = index - inStart;
        //递归构造左右子树
        root.left = helper(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = helper(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);
        return root;
    }
}
```

#### 根据中后序列构造二叉树

````java
public class test {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
    }

    TreeNode helper(int[] inorder,int inStart,int inEnd, int[] postorder,int postStart,int postEnd){
        //递归出口
        if (inStart>inEnd){
            return null;
        }
        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        if (inStart==inEnd) return root;
        //获得根节点在另一个数组中的索引
        int rootIndex = 0;
        for (int i=inStart;i<=inEnd;i++){
            if (rootVal == inorder[i]){
                rootIndex = i;
                break;
            }
        }
        //计算左子树节点数
        int leftSize = rootIndex-inStart;
        //递归构造左右子树
        root.left = helper(inorder,inStart,rootIndex-1,postorder,postStart,postStart+leftSize-1);
        root.right = helper(inorder,rootIndex+1,inEnd,postorder,postStart+leftSize,postEnd-1);
        return root;
    }
}
````

#### 根据前后序列构造二叉树

````java
public class test {
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        return helper(pre,0,pre.length-1,post,0,post.length-1);
    }

    TreeNode helper(int[] pre,int preStart,int preEnd,int[] post,int postStart,int postEnd){
        //递归出口
        if (preStart >preEnd){
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(pre[preStart]);
        if (preStart==preEnd){
            return root;
        }
        //获取左子树的根节点在后序序列中的索引
        int index = postStart;
        for(int i=postStart;i<=postEnd;i++){
            if (post[i]==pre[preStart+1]){
                index = i;
            }
        }
        //计算左子树节点数
        int leftSize = index-postStart;
        //递归构造左右子树
        root.left = helper(pre,preStart+1,preStart+leftSize+1,post,postStart,index);
        root.right = helper(pre,preStart+leftSize+1+1,preEnd,post,index+1,postEnd-1);
        return root;
    }
}
````



## 常用API



```
Collections.reverse(xx)
将xx集合逆序
```





## 堆

### 实现类：优先级队列

#### **1、概念**

PriorityQueue类在Java1.5中引入。PriorityQueue是基于**优先堆**的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。要求使用Java Comparable和Comparator接口给对象排序，并且在排序时会按照优先级处理其中的元素。

## 回溯

解决问题：排列，组合，子集，切割，棋盘（N皇后，解数独）

### 模板

```java
void backtrack(args){
    if(终止条件){//若从各根节点开始收集，不加if
        收集结果;
        return;
    }
    for(集合元素//思考是否可以剪枝
       ){
        //思考是否可以剪枝
		做选择;
		backtrack(args);
		撤销选择;
    }
}
```



## other

### Comparator

​	Comparator的返回值有三种情况，正数，零，负数。当返回值为正数时，表示左值（a）大于右值（b），左值排列在右值的后面；当返回值为负数时，表示左值小于右值，，左值在右值的前面。

## LinkedList

### floyd判圈法(快慢指针)

e: [环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) 

对于链表找环路的问题，有一个通用的解法 。给定两个指针，分别命名为 slow 和 fast，起始位置在链表的开头。每次 fast 前进两步， slow 前进一步。如果 fast可以走到尽头，那么说明没有环路；如果 fast 可以无限走下去，那么说明一定有环路，且一定存在一个时刻 slow 和 fast 相遇。当 slow 和 fast 第一次相遇时，我们将 fast 重新移动到链表开头，并让 slow 和 fast 每次都前进一步。当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点。 