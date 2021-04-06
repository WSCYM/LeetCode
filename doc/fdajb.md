# 一 算法

## 1 排序

### 1.1 冒泡排序

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

### 1.2 选择排序

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

### 1.3 插入排序

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

### 1.4 归并排序

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

### 1.5 快速排序

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

#### 1.5.1 快排变形题

215.[[数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

### 1.6 桶排序

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

#### 1.6.1 桶排序变形题

​	[前 K 个高频元素](https://leetcode-cn.com/problems/top-k-frequent-elements/)

### 1.7 堆排序

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

#### 1.7.1 堆排序变形题

[数组中的第K个最大元素](https://leetcode-cn.com/problems/kth-largest-element-in-an-array/)

## 2 数组

### 2.1 二分查找

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

#### 2.1.1 模板1

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

##### 2.1.1.1 关键属性

二分查找的最基础和最基本的形式。
查找条件可以在不与元素的两侧进行比较的情况下确定（或使用它周围的特定元素）。
不需要后处理，因为每一步中，你都在检查是否找到了元素。如果到达末尾，则知道未找到该元素。

##### 2.1.1.2 区分语法

初始条件：left = 0, right = length-1
终止：left > right
**向左查找：right = mid-1 **
向右查找：left = mid+1

#### 2.1.2 模板2

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

##### 2.1.2.1 关键属性

一种实现二分查找的高级方法。
查找条件需要访问元素的直接右邻居。
使用元素的右邻居来确定是否满足条件，并决定是向左还是向右。
保证查找空间在每一步中至少有 2 个元素。
需要进行后处理。 当你剩下 1 个元素时，循环 / 递归结束。 需要评估剩余元素是否符合条件。

##### 2.1.2.2 区分语法

初始条件：left = 0, right = length
终止：left == right
**向左查找：right = mid **
向右查找：left = mid+1

#### 2.1.3 模板2-2

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

#### 2.1.4 模板3

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

##### 2.1.4.1 关键属性

实现二分查找的另一种方法。
搜索条件需要访问元素的直接左右邻居。
使用元素的邻居来确定它是向右还是向左。
保证查找空间在每个步骤中至少有 3 个元素。
需要进行后处理。 当剩下 2 个元素时，循环 / 递归结束。 需要评估其余元素是否符合条件。

##### 2.1.4.2 区分语法

初始条件：left = 0, right = length-1
终止：left + 1 == right
向左查找：right = mid
向右查找：left = mid

## 3 快速幂

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

## 4 滑动窗口算法及模板

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

## 5 众数问题

​	摩尔投票算法

## 6 树

### 6.1 二叉树前中后序遍历迭代模板

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

#### 6.1.1前序遍历

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

#### 6.1.2中序遍历

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

#### 6.1.3 后序遍历

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





### 6.2 层序遍历

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

### 6.3 二叉搜索树

​	二叉查找树（Binary Search Tree），（又：二叉搜索树，二叉排序树）它或者是一棵空树，或者是具有下列性质的[二叉树](https://baike.baidu.com/item/%E4%BA%8C%E5%8F%89%E6%A0%91/1602879)： 若它的左子树不空，则左子树上所有结点的值均小于它的[根结点](https://baike.baidu.com/item/%E6%A0%B9%E7%BB%93%E7%82%B9/9795570)的值； 若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值； 它的左、右子树也分别为[二叉排序树](https://baike.baidu.com/item/%E4%BA%8C%E5%8F%89%E6%8E%92%E5%BA%8F%E6%A0%91/10905079)。

​	特性：通过中序遍历所得到的序列，就是有序的

#### 6.3.1根据前中（前后||中后）遍历序列构造二叉树模板

##### 6.3.1.1根据前中序列构造二叉树

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

##### 6.3.1.2 根据中后序列构造二叉树

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

##### 6.3.1.3 根据前后序列构造二叉树

```java
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
```

## 7 常用api

```java
Collections.reverse(xx)
将xx集合逆序
```



## 8 堆

### 8.1 实现类：优先级队列

**概念**

PriorityQueue类在Java1.5中引入。PriorityQueue是基于**优先堆**的一个无界队列，这个优先队列中的元素可以默认自然排序或者通过提供的Comparator（比较器）在队列实例化的时排序。要求使用Java Comparable和Comparator接口给对象排序，并且在排序时会按照优先级处理其中的元素。

## 9 回溯

解决问题：排列，组合，子集，切割，棋盘（N皇后，解数独）

模板

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



## 10 other

### 10.1 Comparator

​	Comparator的返回值有三种情况，正数，零，负数。当返回值为正数时，表示左值（a）大于右值（b），左值排列在右值的后面；当返回值为负数时，表示左值小于右值，，左值在右值的前面。

## 11 LinkedList

### 11.1 floyd判圈法(快慢指针)

e: [环形链表 II](https://leetcode-cn.com/problems/linked-list-cycle-ii/) 

对于链表找环路的问题，有一个通用的解法 。给定两个指针，分别命名为 slow 和 fast，起始位置在链表的开头。每次 fast 前进两步， slow 前进一步。如果 fast可以走到尽头，那么说明没有环路；如果 fast 可以无限走下去，那么说明一定有环路，且一定存在一个时刻 slow 和 fast 相遇。当 slow 和 fast 第一次相遇时，我们将 fast 重新移动到链表开头，并让 slow 和 fast 每次都前进一步。当 slow 和 fast 第二次相遇时，相遇的节点即为环路的开始点。 





## 12 分治

```java
int divideConquer(args){
        //1.递归出口
        //2.将问题分解为更小的子问题
        //3.分别处理各子问题
    	//4.整理结果，返回
 }
```

[剑指 Offer 42. 连续子数组的最大和](https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/)]

输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

```java
class Solution {
    public int maxSubArray(int[] nums) {
        return divideConquer(nums,0,nums.length-1);
    }

    public int divideConquer(int[] nums,int low,int high) {
        //1.递归出口
        if (low>=high){
            return nums[low];
        }
        //2.将问题分解为更小的子问题
        //3.分别处理各子问题
        int mid = low+(high-low)/2;
        int left = divideConquer(nums,low,mid-1);
        int right = divideConquer(nums,mid+1,high);
        int maxMid = nums[mid];
        int curMId = nums[mid];
        for (int i = mid-1;i>=low;i--){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        curMId = maxMid;
        for (int i = mid+1;i<=high;i++){
            curMId += nums[i];
            if (maxMid<curMId) maxMid = curMId;
        }
        //4.整理结果，返回
        return Math.max(Math.max(left,right),maxMid);
    }
}
```



eg2:[95. 不同的二叉搜索树 II](https://leetcode-cn.com/problems/unique-binary-search-trees-ii/)

给定一个整数 *n*，生成所有由 1 ... *n* 为节点所组成的 **二叉搜索树** 。

```java
class Solution {
    public List<TreeNode> generateTrees(int n) {
        int[] arr = new int[n];
        for (int i = 0;i<arr.length;i++){
            arr[i] = i+1;
        }
        return helper(arr,0,arr.length-1);
    }

    private List<TreeNode> helper(int[] nums,int low,int high){
        List<TreeNode> res = new ArrayList<>();
        //1.递归出口
        if (low>high){
            res.add(null);
            return res;
        }
        //2.将问题分解为更小的子问题
        //3.分别处理各子问题
        //4.汇总结果，返回
        for (int i=low;i<=high;i++){
            List<TreeNode> left = helper(nums, low, i - 1);
            List<TreeNode> right = helper(nums,i+1,high);
            for (TreeNode l : left){
                for (TreeNode r : right){
                    TreeNode node = new TreeNode(nums[i]);
                    node.left = l;
                    node.right = r;
                    res.add(node);
                }
            }
        }
        return res;
    }
}
```

## 13 数学

### 13.1 利用辗转相除法求最大公因数和最小公倍数

#### 13.1.1 求最大公因数

![](.\imgs\zzxc.png)

#### 13.1.2 求最小公倍数

利用辗转相除法，我们可以很方便地求得两个数的最大公因数（greatest common divisor， gcd）；
将两个数相乘再除以最大公因数即可得到最小公倍数（least common multiple, lcm）。 

```java
int gcd(int a, int b) {
return b == 0 ? a : gcd(b, a% b);
}
int lcm(int a, int b) {
return a * b / gcd(a, b);
}
```

#### 13.1.3 求gcd系数

进一步地，我们也可以通过扩展欧几里得算法（extended gcd）在求得 a 和 b 最大公因数的同
时，也得到它们的系数 x 和 y，从而使 ax + by = gcd(a, b)。 

```java
class Pony{
    static int x,y;
    static int exgcd(int a,int b)
    {
        if(b==0){
            x=1;y=0;
            return a;
        }
        else{
            int ret=exgcd(b,a%b);
            int tmp=x;
            x=y;y=tmp-(a/b)*y;
            return ret;
        }
    }

    public static void main(String[] args) throws Exception
    {
        int a,b;a=54;b=27;
        exgcd(a,b);
        System.out.println(x+" "+y);
    }
}
```

例题

[365. 水壶问题](https://leetcode-cn.com/problems/water-and-jug-problem/)

```java
public boolean canMeasureWater(int x, int y, int z) {
        if (x==0&&y==0) return z==0?true:false;
        if (x==0||y==0) return x==0?z%y==0:z%x==0;
        if(x+y<z) return false;
        if (z%gcd(x,y)==0){
            return true;
        } else return false;
    }

    int gcd(int a,int b){
        return b==0?a:gcd(b,a%b);
    }
```



### 13.2 埃拉托斯特尼筛法求质数

从 1 到 n 遍历，假设当前遍历到 m，则把所有小于 n 的、且是 m 的倍数的整数标为和数；遍历完成后，没有被标为和数的数字即为质数。 

```java
class Solution {
    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }
        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }
}
```

## 14 位运算

### 14.1 基础

位运算是算法题里比较特殊的一种类型，它们利用二进制位运算的特性进行一些奇妙的优化
和计算。常用的位运算符号包括：“^”按位异或、“&”按位与、“|”按位或、“∼”取反、“<<”
算术左移和“>>”算术右移。以下是一些常见的位运算特性，其中 0s 和 1s 分别表示只由 0 或 1
构成的二进制数字。 

x ^ 0s = x              x & 0s = 0                 x | 0s = x
x ^ 1s = ~x            x & 1s = x                 x | 1s = 1s
x ^ x = 0                x & x = x                   x | x = x 

位运算中异或运算具有交换律，也就是
`A^B^C=A^C^B`

除此之外， n & (n - 1) 可以去除 n 的位级表示中最低的那一位，例如对于二进制表示 11110100
，减去 1 得到 11110011，这两个数按位与得到 11110000。

注意，如果n为2的x次幂，n & (n - 1)的结果为0；

 n & (-n) 可以得到 n 的位级表示中最低的那一位，例如对于二进制表示 11110100，取负得到 00001100，这两个数按位与得到 00000100。 

### 14.2 原码，反码，补码 

参考https://zhuanlan.zhihu.com/p/91967268

https://blog.csdn.net/yo_bc/article/details/74511066

int大小为什么正负不对称？

参考 : https://blog.csdn.net/baidu_41795891/article/details/108744924

### 14.3 负数的左移和右移

在机器中，数的二进制码都是其补码。

① 负数的右移：需要保持数为负数，所以操作是对负数的二进制位左边补1。如果一直右移，最终会变成-1，即(-1)>>1是-1。

② 负数的左移：和整数左移一样，在负数的二进制位右边补0，一个数在左移的过程中会有正有负的情况，所以切记负数左移不会特殊处理符号位。如果一直左移，最终会变成0。


注意，java中要注意对负数的除和右移的区别,注意对负数%和&的区别

java中对负数除需要向0取整

例如，-3 / 2 = -1 ， -3>>1 = -2

-3 % 2 = -1, -3 & 1 = 1

原:10011 反:11100 补:11101 右移一位后 原:11110 反:11101 补:10010  转化成十进制则为-2

例题参考[190. 颠倒二进制位](https://leetcode-cn.com/problems/reverse-bits/)

如果将>>1换成/2，则答案错误

如果将&1换成%2，则答案错误



# 二 java知识点

## 1 java基础

### 1.1 泛型

Java 泛型（generics）是 JDK 5 中引入的一个新特性, 泛型提供了编译时类型安全检测机制，该机制允许程序员在编译时检测到非法的类型。泛型的本质是参数化类型，也就是说所操作的数据类型被指定为一个参数。

**Java 的泛型是伪泛型，这是因为 Java 在编译期间，所有的泛型信息都会被擦掉，这也就是通常所说类型擦除 。**

泛型一般有三种使用方式:泛型类、泛型接口、泛型方法。

**1.泛型类**：

```java
//此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型
//在实例化泛型类时，必须指定T的具体类型
public class Generic<T>{

    private T key;

    public Generic(T key) {
        this.key = key;
    }

    public T getKey(){
        return key;
    }
}Copy to clipboardErrorCopied
```

如何实例化泛型类：

```java
Generic<Integer> genericInteger = new Generic<Integer>(123456);Copy to clipboardErrorCopied
```

**2.泛型接口** ：

```java
public interface Generator<T> {
    public T method();
}Copy to clipboardErrorCopied
```

实现泛型接口，不指定类型：

```java
class GeneratorImpl<T> implements Generator<T>{
    @Override
    public T method() {
        return null;
    }
}Copy to clipboardErrorCopied
```

实现泛型接口，指定类型：

```java
class GeneratorImpl<T> implements Generator<String>{
    @Override
    public String method() {
        return "hello";
    }
}Copy to clipboardErrorCopied
```

**3.泛型方法** ：

```java
   public static < E > void printArray( E[] inputArray )
   {
         for ( E element : inputArray ){
            System.out.printf( "%s ", element );
         }
         System.out.println();
    }Copy to clipboardErrorCopied
```

使用：

```java
// 创建不同类型数组： Integer, Double 和 Character
Integer[] intArray = { 1, 2, 3 };
String[] stringArray = { "Hello", "World" };
printArray( intArray  );
printArray( stringArray  );Copy to clipboardErrorCopied
```

**常用的通配符为： T，E，K，V，？**

- ？ 表示不确定的 java 类型
- T (type) 表示具体的一个 java 类型
- K V (key value) 分别代表 java 键值中的 Key Value
- E (element) 代表 Element

### 1.2 ==和equals

**基本数据类型==比较的是值，引用数据类型==比较的是内存地址**

因为 Java 只有值传递，所以，对于 == 来说，不管是比较基本数据类型，还是引用数据类型的变量，其本质比较的都是值，只是引用类型变量存的值是对象的地址。

**equals()** : 它的作用也是判断两个对象是否相等，它不能用于比较基本数据类型的变量。`equals()`方法存在于`Object`类中，而`Object`类是所有类的直接或间接父类。

`Object`类`equals()`方法：

```java
public boolean equals(Object obj) {
     return (this == obj);
}Copy to clipboardErrorCopied
```

`equals()` 方法存在两种使用情况：

- 情况 1：类没有覆盖 `equals()`方法。则通过`equals()`比较该类的两个对象时，等价于通过“==”比较这两个对象。使用的默认是 `Object`类`equals()`方法。
- 情况 2：类覆盖了 `equals()`方法。一般，我们都覆盖 `equals()`方法来两个对象的内容相等；若它们的内容相等，则返回 true(即，认为这两个对象相等)。

### 1.3 hashCode()与equals()

面试官可能会问你：“你重写过 `hashcode` 和 `equals`么，为什么重写 `equals` 时必须重写 `hashCode` 方法？”

**1)hashCode()介绍:**

`hashCode()` 的作用是获取哈希码，也称为散列码；它实际上是返回一个 int 整数。这个哈希码的作用是确定该对象在哈希表中的索引位置。

**2)为什么要有 hashCode？**

我们以“`HashSet` 如何检查重复”为例子来说明为什么要有 hashCode？

当你把对象加入 `HashSet` 时，`HashSet` 会先计算对象的 hashcode 值来判断对象加入的位置，同时也会与其他已经加入的对象的 hashcode 值作比较，如果没有相符的 hashcode，`HashSet` 会假设对象没有重复出现。但是如果发现有相同 hashcode 值的对象，这时会调用 `equals()` 方法来检查 hashcode 相等的对象是否真的相同。如果两者相同，`HashSet` 就不会让其加入操作成功。如果不同的话，就会重新散列到其他位置。（摘自我的 Java 启蒙书《Head First Java》第二版）。这样我们就大大减少了 equals 的次数，相应就大大提高了执行速度。

**3)为什么重写 equals 时必须重写 hashCode 方法？**

如果两个对象相等，则 hashcode 一定也是相同的。两个对象相等,对两个对象分别调用 equals 方法都返回 true。但是，两个对象有相同的 hashcode 值，它们也不一定是相等的 。**因此，equals 方法被覆盖过，则 hashCode 方法也必须被覆盖。**

> `hashCode()`的默认行为是对堆上的对象产生独特值。如果没有重写 `hashCode()`，则该 class 的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）

**4)为什么两个对象有相同的 hashcode 值，它们也不一定是相等的？**

因为 `hashCode()` 所使用的杂凑算法也许刚好会让多个对象传回相同的杂凑值。越糟糕的杂凑算法越容易碰撞，但这也与数据值域分布的特性有关（所谓碰撞也就是指的是不同的对象得到相同的 `hashCod	e`。

我们刚刚也提到了 `HashSet`,如果 `HashSet` 在对比的时候，同样的 hashcode 有多个对象，它会使用 `equals()` 来判断是否真的相同。也就是说 `hashcode` 只是用来缩小查找成本。

### 1.4 基本数据类型

Java中有 8 种基本数据类型，分别为：

1. 6 种数字类型 ：byte、short、int、long、float、double
2. 1 种字符类型：char
3. 1 种布尔型：boolean。

这八种基本类型都有对应的包装类分别为：Byte、Short、Integer、Long、Float、Double、Character、Boolean

| 基本类型 | 位数 | 字节 | 默认值  |
| -------- | ---- | ---- | ------- |
| int      | 32   | 4    | 0       |
| short    | 16   | 2    | 0       |
| long     | 64   | 8    | 0L      |
| byte     | 8    | 1    | 0       |
| char     | 16   | 2    | 'u0000' |
| float    | 32   | 4    | 0f      |
| double   | 64   | 8    | 0d      |
| boolean  | 1    |      | false   |

### 1.5 自动装箱与拆箱

- **装箱**：将基本类型用它们对应的引用类型包装起来；
- **拆箱**：将包装类型转换为基本数据类型；

### 1.6  8种基本类型的包装类和常量池

**Java 基本类型的包装类的大部分都实现了常量池技术，即 Byte,Short,Integer,Long,Character,Boolean；前面 4 种包装类默认创建了数值[-128，127] 的相应类型的缓存数据，Character 创建了数值在[0,127]范围的缓存数据，Boolean 直接返回 True Or False。如果超出对应范围仍然会去创建新的对象。**

**应用场景：**

1. Integer i1=40；Java 在编译的时候会直接将代码封装成 Integer i1=Integer.valueOf(40);，从而使用常量池中的对象。
2. Integer i1 = new Integer(40);这种情况下会创建新的对象。

```java
  Integer i1 = 40;
  Integer i2 = new Integer(40);
  System.out.println(i1 == i2);//输出 falseCopy to clipboardErrorCopied
```

**Integer 比较更丰富的一个例子:**

```java
  Integer i1 = 40;
  Integer i2 = 40;
  Integer i3 = 0;
  Integer i4 = new Integer(40);
  Integer i5 = new Integer(40);
  Integer i6 = new Integer(0);

  System.out.println("i1=i2   " + (i1 == i2));
  System.out.println("i1=i2+i3   " + (i1 == i2 + i3));
  System.out.println("i1=i4   " + (i1 == i4));
  System.out.println("i4=i5   " + (i4 == i5));
  System.out.println("i4=i5+i6   " + (i4 == i5 + i6));
  System.out.println("40=i5+i6   " + (40 == i5 + i6));Copy to clipboardErrorCopied
```

结果：

```
i1=i2   true
i1=i2+i3   true
i1=i4   false
i4=i5   false
i4=i5+i6   true
40=i5+i6   trueCopy to clipboardErrorCopied
```

解释：

语句 i4 == i5 + i6，因为+这个操作符不适用于 Integer 对象，首先 i5 和 i6 进行自动拆箱操作，进行数值相加，即 i4 == 40。然后 Integer 对象无法与数值进行直接比较，所以 i4 自动拆箱转为 int 值 40，最终这条语句转为 40 == 40 进行数值比较。

### 1.7 重载,重写,函数签名

重载 : 同样的一个方法能够根据输入数据的不同，做出不同的处理

重载解析 : 编译器通过函数名和其参数类型识别出相应的重载函数。

函数签名 : 要完整的描述一个方法，需要指出方法名和参数类型，这叫做方法的签名。返回类型不是方法签名的一部分。也就是说，不能有两个名字相同，参数类型也相同却具有不同类型返回值的方法。

```java
//签名例子:
indexOf(int)
indexOf(int,int)
indexOf(String)
......
```



重写 : 当子类继承自父类的相同方法，输入数据一样，但要做出有别于父类的响应时，你就要覆盖父类方法

重写发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写。

1. 返回值类型、方法名、参数列表必须相同，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。
2. 如果父类方法访问修饰符为 `private/final/static` 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明。
3. **构造方法无法被重写**,但可以被重载

综上：重写就是子类对父类方法的重新改造，外部样子不能改变，内部逻辑可以改变

暖心的 Guide 哥最后再来个图表总结一下！

| 区别点     | 重载方法 | 重写方法                                                     |
| ---------- | -------- | ------------------------------------------------------------ |
| 发生范围   | 同一个类 | 子类                                                         |
| 参数列表   | 必须修改 | 一定不能修改                                                 |
| 返回类型   | 可修改   | 子类方法返回值类型应比父类方法返回值类型更小或相等           |
| 异常       | 可修改   | 子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等； |
| 访问修饰符 | 可修改   | 一定不能做更严格的限制（可以降低限制）                       |
| 发生阶段   | 编译期   | 运行期                                                       |

**方法的重写要遵循“两同两小一大”**以下内容摘录自《疯狂 Java 讲义]

- “两同”即方法名相同、形参列表相同；
- “两小”指的是子类方法返回值类型应比父类方法返回值类型更小或相等，子类方法声明抛出的异常类应比父类方法声明抛出的异常类更小或相等；
- “一大”指的是子类方法的访问权限应比父类方法的访问权限更大或相等。

⭐️ 关于 **重写的返回值类**型 这里需要额外多说明一下，上面的表述不太清晰准确：如果方法的返回类型是void和基本数据类型，则返回值重写时不可修改。但是如果方法的返回值是引用类型，重写时是可以返回该引用类型的子类的。



### 1.8 深拷贝，浅拷贝

1. **浅拷贝**：对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝，此为浅拷贝。

   浅拷贝会创建一个新对象，这个对象有着原始对象属性值的一份精确拷贝。如果属性是基本类型，拷贝的就是基本类型的值；如果属性是内存地址（引用类型），拷贝的就是内存地址 ，因此如果其中一个对象改变了这个地址，就会影响到另一个对象。即默认拷贝构造函数只是对对象进行浅拷贝复制(逐个成员依次拷贝)，即只复制对象空间而不复制资源。

   ![copy1](.\imgs\copy1.png)

2. **深拷贝**：对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝。

   深拷贝在拷贝引用类型成员变量时，为引用类型的数据成员另辟了一个独立的内存空间，实现真正内容上的拷贝。

![copy2](.\imgs\copy2.png)

具体实现 : 参考https://blog.csdn.net/u014727260/article/details/55003402

## 2 java面向对象

### 2.1 面向对象和面向过程的区别

- **面向过程** ：**面向过程性能比面向对象高。** 因为类调用时需要实例化，开销比较大，比较消耗资源，所以当性能是最重要的考量因素的时候，比如单片机、嵌入式开发、Linux/Unix 等一般采用面向过程开发。但是，**面向过程没有面向对象易维护、易复用、易扩展。**
- **面向对象** ：**面向对象易维护、易复用、易扩展。** 因为面向对象有封装、继承、多态性的特性，所以可以设计出低耦合的系统，使系统更加灵活、更加易于维护。但是，**面向对象性能比面向过程低**。

### 2.2 在 Java 中定义一个不做事且没有参数的构造方法的作用

Java 程序在执行子类的构造方法之前，如果没有用 `super()`来调用父类特定的构造方法，则会调用父类中“没有参数的构造方法”。因此，如果父类中只定义了有参数的构造方法，而在子类的构造方法中又没有用 `super()`来调用父类中特定的构造方法，则编译时将发生错误，因为 Java 程序在父类中找不到没有参数的构造方法可供执行。解决办法是在父类里加上一个不做事且没有参数的构造方法。

### 2.3 成员变量与局部变量

1. 从语法形式上看:成员变量是属于类的，而局部变量是在代码块或方法中定义的变量或是方法的参数；成员变量可以被 public,private,static 等修饰符所修饰，而局部变量不能被访问控制修饰符及 static 所修饰；但是，成员变量和局部变量都能被 final 所修饰。
2. 从变量在内存中的存储方式来看:如果成员变量是使用`static`修饰的，那么这个成员变量是属于类的，如果没有使用`static`修饰，这个成员变量是属于实例的。而对象存在于堆内存，局部变量则存在于栈内存。
3. 从变量在内存中的生存时间上看:成员变量是对象的一部分，它随着对象的创建而存在，而局部变量随着方法的调用而自动消失。
4. 成员变量如果没有被赋初值:则会自动以类型的默认值而赋值（一种情况例外:被 final 修饰的成员变量也必须显式地赋值），而局部变量则不会自动赋值。

### 2.4 一个类的构造方法的作用是什么? 若一个类没有声明构造方法，该程序能正确执行吗? 为什么?

主要作用是完成对类对象的初始化工作。可以执行。因为**一个类没有声明构造方法也会有默认的不带参数的构造方法**。**如果我们自己添加了类的构造方法（无论是否有参），Java 就不会再添加默认的无参数的构造方法了**，这时候，就不能直接 new 一个对象而不传递参数了，所以我们一直在不知不觉地使用构造方法，这也是为什么我们在创建对象的时候后面要加一个括号（因为要调用无参的构造方法）。如果我们重载了有参的构造方法，记得都要把无参的构造方法也写出来（无论是否用到），因为这可以帮助我们在创建对象的时候少踩坑。

### 2.5 构造方法的特性？

1. 名字与类名相同。
2. 没有返回值，但不能用 void 声明构造函数。
3. 生成类的对象时自动执行，无需调用。

### 2.6 在调用子类构造方法之前会先调用父类没有参数的构造方法,其目的是?

帮助子类做初始化工作。

### 2.7 封装，继承，多态

#### 2.7.1 封装

封装是指把一个对象的状态信息（也就是属性）隐藏在对象内部，不允许外部对象直接访问对象的内部信息。但是可以提供一些可以被外界访问的方法来操作属性。

#### 2.7.2 继承

继承是使用已存在的类的定义作为基础建立新类的技术，新类的定义可以增加新的数据或新的功能，也可以用父类的功能，但不能选择性地继承父类。通过使用继承，可以快速地创建新的类，可以提高代码的重用，程序的可维护性，节省大量创建新类的时间 ，提高我们的开发效率。

**关于继承如下 3 点请记住：**

1. 子类拥有父类对象所有的属性和方法（包括私有属性和私有方法），但是父类中的私有属性和方法子类是无法访问，**只是拥有**。
2. 子类可以拥有自己属性和方法，即子类可以对父类进行扩展。
3. 子类可以用自己的方式实现父类的方法。（以后介绍）。

#### 2.7.3 多态

表示一个对象具有多种的状态。具体表现为父类的引用指向子类的实例。

**多态的特点:**

- 对象类型和引用类型之间具有继承（类）/实现（接口）的关系；
- 引用类型变量发出的方法调用的到底是哪个类中的方法，必须在程序运行期间才能确定；
- 多态不能调用“只在子类存在但在父类不存在”的方法；
- 如果子类重写了父类的方法，真正执行的是子类覆盖的方法，如果子类没有覆盖父类的方法，执行的是父类的方法。

### 2.8  静态方法和实例方法区别

1. 在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。而实例方法只有后面这种方式。也就是说，调用静态方法可以无需创建对象。
2. 静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），而不允许访问实例成员变量和实例方法；实例方法则无此限制。

### 2.9 其它重点

#### 2.9.1 String,StringBuffer 和 StringBuilder 的区别是什么? String 为什么是不可变的?

**可变性**

简单的来说：`String` 类中使用 final 关键字修饰字符数组来保存字符串，`private final char value[]`，所以`String` 对象是不可变的。

> 补充（来自[issue 675](https://github.com/Snailclimb/JavaGuide/issues/675)）：在 Java 9 之后，String 、`StringBuilder` 与 `StringBuffer` 的实现改用 byte 数组存储字符串 `private final byte[] value`

而 `StringBuilder` 与 `StringBuffer` 都继承自 `AbstractStringBuilder` 类，在 `AbstractStringBuilder` 中也是使用字符数组保存字符串`char[]value` 但是没有用 `final` 关键字修饰，所以这两种对象都是可变的。

**线程安全性**

`String` 中的对象是不可变的，也就可以理解为常量，线程安全。`AbstractStringBuilder` 是 `StringBuilder` 与 `StringBuffer` 的公共父类，定义了一些字符串的基本操作，如 `expandCapacity`、`append`、`insert`、`indexOf` 等公共方法。`StringBuffer` 对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。`StringBuilder` 并没有对方法进行加同步锁，所以是非线程安全的。

**性能**

每次对 `String` 类型进行改变的时候，都会生成一个新的 `String` 对象，然后将指针指向新的 `String` 对象。

`StringBuffer` 每次都会对 `StringBuffer` 对象本身进行操作，而不是生成新的对象并改变对象引用。

相同情况下使用 `StringBuilder` 相比使用 `StringBuffer` 仅能获得 10%~15% 左右的性能提升，但却要冒多线程不安全的风险。

**对于三者使用的总结：**

1. 操作少量的数据: 适用 `String`
2. 单线程操作字符串缓冲区下操作大量数据: 适用 `StringBuilder`
3. 多线程操作字符串缓冲区下操作大量数据: 适用 `StringBuffer`

#### 2.9.2 Object 类的常见方法总结

```java
public final native Class<?> getClass()//native方法，用于返回当前运行时对象的Class对象，使用了final关键字修饰，故不允许子类重写。

public native int hashCode() //native方法，用于返回对象的哈希码，主要使用在哈希表中，比如JDK中的HashMap。
public boolean equals(Object obj)//用于比较2个对象的内存地址是否相等，String类对该方法进行了重写用户比较字符串的值是否相等。

protected native Object clone() throws CloneNotSupportedException//naitive方法，用于创建并返回当前对象的一份拷贝。一般情况下，对于任何对象 x，表达式 x.clone() != x 为true，x.clone().getClass() == x.getClass() 为true。Object本身没有实现Cloneable接口，所以不重写clone方法并且进行调用的话会发生CloneNotSupportedException异常。

public String toString()//返回类的名字@实例的哈希码的16进制的字符串。建议Object所有的子类都重写这个方法。

public final native void notify()//native方法，并且不能重写。唤醒一个在此对象监视器上等待的线程(监视器相当于就是锁的概念)。如果有多个线程在等待只会任意唤醒一个。

public final native void notifyAll()//native方法，并且不能重写。跟notify一样，唯一的区别就是会唤醒在此对象监视器上等待的所有线程，而不是一个线程。

public final native void wait(long timeout) throws InterruptedException//native方法，并且不能重写。暂停线程的执行。注意：sleep方法没有释放锁，而wait方法释放了锁 。timeout是等待时间。

public final void wait(long timeout, int nanos) throws InterruptedException//多了nanos参数，这个参数表示额外时间（以毫微秒为单位，范围是 0-999999）。 所以超时的时间还需要加上nanos毫秒。

public final void wait() throws InterruptedException//跟之前的2个wait方法一样，只不过该方法一直等待，没有超时时间这个概念

protected void finalize() throws Throwable { }//实例被垃圾回收器回收的时候触发的操作
Copy to clipboardErrorCopied
```

#### 2.9.3 Java 序列化中如果有些字段不想进行序列化，怎么办？

对于不想进行序列化的变量，使用 transient 关键字修饰。

transient 关键字的作用是：阻止实例中那些用此关键字修饰的的变量序列化；当对象被反序列化时，被 transient 修饰的变量值不会被持久化和恢复。transient 只能修饰变量，不能修饰类和方法。

#### 2.9.4 获取键盘输入常用的两种方法

方法 1：通过 Scanner

```java
Scanner input = new Scanner(System.in);
String s  = input.nextLine();
input.close();Copy to clipboardErrorCopied
```

方法 2：通过 BufferedReader

```java
BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
String s = input.readLine();
```



## 3 JAVA核心技术

### 3.1 反射机制

具体实现参考：https://blog.csdn.net/huangliniqng/article/details/88554510

JAVA 反射机制是在运行状态中，对于任意一个类，都能够知道这个类的所有属性和方法；对于任意一个对象，都能够调用它的任意一个方法和属性；这种动态获取的信息以及动态调用对象的方法的功能称为 java 语言的反射机制。（私有的方法也可以调用）

#### 3.1.1 静态编译和动态编译

- **静态编译：** 在编译时确定类型，绑定对象
- **动态编译：** 运行时确定类型，绑定对象

#### 3.1.2 反射机制优缺点

- **优点：** 运行期类型的判断，动态加载类，提高代码灵活度。
- **缺点：** 1,性能瓶颈：反射相当于一系列解释操作，通知 JVM 要做的事情，性能比直接的 java 代码要慢很多。2,安全问题，让我们可以动态操作改变类的属性同时也增加了类的安全隐患。

#### 3.1.3 反射的应用场景

**反射是框架设计的灵魂。**

在我们平时的项目开发过程中，基本上很少会直接使用到反射机制，但这不能说明反射机制没有用，实际上有很多设计、开发都与反射机制有关，例如模块化的开发，通过反射去调用对应的字节码；动态代理设计模式也采用了反射机制，还有我们日常使用的 Spring／Hibernate 等框架也大量使用到了反射机制。

举例：

1. 我们在使用 JDBC 连接数据库时使用 `Class.forName()`通过反射加载数据库的驱动程序；
2. Spring 框架的 IOC（动态加载管理 Bean）创建对象以及 AOP（动态代理）功能都和反射有联系；
3. 动态配置实例的属性；

### [3.2. 异常](https://snailclimb.gitee.io/javaguide/#/docs/java/basis/Java%E5%9F%BA%E7%A1%80%E7%9F%A5%E8%AF%86?id=_32-%e5%bc%82%e5%b8%b8)

#### 3.2.1 Java异常类层次结构图

![exception1](.\imgs\exception1.png)

![exception2](.\imgs\exception2.png)

在 Java 中，所有的异常都有一个共同的祖先 `java.lang` 包中的 `Throwable` 类。`Throwable` 类有两个重要的子类 `Exception`（异常）和 `Error`（错误）。`Exception` 能被程序本身处理(`try-catch`)， `Error` 是无法处理的(只能尽量避免)。

`Exception` 和 `Error` 二者都是 Java 异常处理的重要子类，各自都包含大量子类。

- **Exception** :程序本身可以处理的异常，可以通过 `catch` 来进行捕获。`Exception` 又可以分为 受检查异常(必须处理) 和 不受检查异常(可以不处理)。
- **Error** ：`Error` 属于程序无法处理的错误 ，我们没办法通过 `catch` 来进行捕获 。例如，Java 虚拟机运行错误（`Virtual MachineError`）、虚拟机内存不够错误(`OutOfMemoryError`)、类定义错误（`NoClassDefFoundError`）等 。这些异常发生时，Java 虚拟机（JVM）一般会选择线程终止。

**受检查异常**

Java 代码在编译过程中，如果受检查异常没有被 `catch`/`throw` 处理的话，就没办法通过编译 。

除了`RuntimeException`及其子类以外，其他的`Exception`类及其子类都属于受检查异常 。常见的受检查异常有： IO 相关的异常、`ClassNotFoundException` 、`SQLException`...。

**不受检查异常**

Java 代码在编译过程中 ，我们即使不处理不受检查异常也可以正常通过编译。

`RuntimeException` 及其子类都统称为非受检查异常，例如：`NullPointerException`、`NumberFormatException`（字符串转换为数字）、`ArrayIndexOutOfBoundsException`（数组越界）、`ClassCastException`（类型转换错误）、`ArithmeticException`（算术错误）等。

#### 3.2.2  Throwable 类常用方法

- **public string getMessage()**:返回异常发生时的简要描述
- **public string toString()**:返回异常发生时的详细信息
- **public string getLocalizedMessage()**:返回异常对象的本地化信息。使用 `Throwable` 的子类覆盖这个方法，可以生成本地化信息。如果子类没有覆盖该方法，则该方法返回的信息与 `getMessage（）`返回的结果相同
- **public void printStackTrace()**:在控制台上打印 `Throwable` 对象封装的异常信息

#### 3.2.3 try-catch-finally

- **try块：** 用于捕获异常。其后可接零个或多个 `catch` 块，如果没有 `catch` 块，则必须跟一个 `finally` 块。
- **catch块：** 用于处理 try 捕获到的异常。
- **finally 块：** 无论是否捕获或处理异常，`finally` 块里的语句都会被执行。当在 `try` 块或 `catch` 块中遇到 `return` 语句时，`finally` 语句块将在方法返回之前被执行。

**在以下 3 种特殊情况下，finally 块不会被执行：**

1. 在 `try` 或 `finally `块中用了 `System.exit(int)`退出程序。但是，如果 `System.exit(int)` 在异常语句之后，`finally` 还是会被执行
2. 程序所在的线程死亡。
3. 关闭 CPU。

#### 3.2.4 使用 `try-with-resources` 来代替 try-catch-finally

1. **适用范围（资源的定义）：** 任何实现 `java.lang.AutoCloseable`或者 `java.io.Closeable` 的对象
2. **关闭资源和 final 的执行顺序：** 在 `try-with-resources` 语句中，任何 catch 或 finally 块在声明的资源关闭后运行

《Effecitve Java》中明确指出：

> 面对必须要关闭的资源，我们总是应该优先使用 `try-with-resources` 而不是`try-finally`。随之产生的代码更简短，更清晰，产生的异常对我们也更有用。`try-with-resources`语句让我们更容易编写必须要关闭的资源的代码，若采用`try-finally`则几乎做不到这点。

Java 中类似于`InputStream`、`OutputStream` 、`Scanner` 、`PrintWriter`等的资源都需要我们调用`close()`方法来手动关闭，一般情况下我们都是通过`try-catch-finally`语句来实现这个需求，如下：

```java
        //读取文本文件的内容
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("D://read.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }Copy to clipboardErrorCopied
```

使用 Java 7 之后的 `try-with-resources` 语句改造上面的代码:

```java
try (Scanner scanner = new Scanner(new File("test.txt"))) {
    while (scanner.hasNext()) {
        System.out.println(scanner.nextLine());
    }
} catch (FileNotFoundException fnfe) {
    fnfe.printStackTrace();
}Copy to clipboardErrorCopied
```

当然多个资源需要关闭的时候，使用 `try-with-resources` 实现起来也非常简单，如果你还是用`try-catch-finally`可能会带来很多问题。

通过使用分号分隔，可以在`try-with-resources`块中声明多个资源。

```java
try (BufferedInputStream bin = new BufferedInputStream(new FileInputStream(new File("test.txt")));
             BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(new File("out.txt")))) {
            int b;
            while ((b = bin.read()) != -1) {
                bout.write(b);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
```



### 3.3 多线程

#### 3.3.1. 简述线程、程序、进程的基本概念。以及他们之间关系是什么?

**线程**与进程相似，但线程是一个比进程更小的执行单位。一个进程在其执行的过程中可以产生多个线程。与进程不同的是同类的多个线程共享同一块内存空间和一组系统资源，所以系统在产生一个线程，或是在各个线程之间作切换工作时，负担要比进程小得多，也正因为如此，线程也被称为轻量级进程。

**程序**是含有指令和数据的文件，被存储在磁盘或其他的数据存储设备中，也就是说程序是静态的代码。

**进程**是程序的一次执行过程，是系统运行程序的基本单位，因此进程是动态的。系统运行一个程序即是一个进程从创建，运行到消亡的过程。简单来说，一个进程就是一个执行中的程序，它在计算机中一个指令接着一个指令地执行着，同时，每个进程还占有某些系统资源如 CPU 时间，内存空间，文件，输入输出设备的使用权等等。换句话说，当程序在执行时，将会被操作系统载入内存中。 线程是进程划分成的更小的运行单位。线程和进程最大的不同在于基本上各进程是独立的，而各线程则不一定，因为同一进程中的线程极有可能会相互影响。从另一角度来说，进程属于操作系统的范畴，主要是同一段时间内，可以同时执行一个以上的程序，而线程则是在同一程序内几乎同时执行一个以上的程序段。

#### 3.3.2. 线程有哪些基本状态?

Java 线程在运行的生命周期中的指定时刻只可能处于下面 6 种不同状态的其中一个状态（图源《Java 并发编程艺术》4.1.4 节）。

![thread1](.\imgs\thread1.png)

线程在生命周期中并不是固定处于某一个状态而是随着代码的执行在不同状态之间切换。Java 线程状态变迁如下图所示（图源《Java 并发编程艺术》4.1.4 节）：

![thread2](.\imgs\thread2.png)

由上图可以看出：

线程创建之后它将处于 **NEW（新建）** 状态，调用 `start()` 方法后开始运行，线程这时候处于 **READY（可运行）** 状态。可运行状态的线程获得了 cpu 时间片（timeslice）后就处于 **RUNNING（运行）** 状态。

> 操作系统隐藏 Java 虚拟机（JVM）中的 READY 和 RUNNING 状态，它只能看到 RUNNABLE 状态（图源：[HowToDoInJava](https://howtodoinjava.com/)：[Java Thread Life Cycle and Thread States](https://howtodoinjava.com/java/multi-threading/java-thread-life-cycle-and-thread-states/)），所以 Java 系统一般将这两个状态统称为 **RUNNABLE（运行中）** 状态 。
>
> ![thread3](.\imgs\thread3.png)

当线程执行 `wait()`方法之后，线程进入 **WAITING（等待）** 状态。进入等待状态的线程需要依靠其他线程的通知才能够返回到运行状态，而 **TIME_WAITING(超时等待)** 状态相当于在等待状态的基础上增加了超时限制，比如通过 `sleep（long millis）`方法或 `wait（long millis）`方法可以将 Java 线程置于 TIMED WAITING 状态。当超时时间到达后 Java 线程将会返回到 RUNNABLE 状态。当线程调用同步方法时，在没有获取到锁的情况下，线程将会进入到 **BLOCKED（阻塞）** 状态。线程在执行 Runnable 的`run()`方法之后将会进入到 **TERMINATED（终止）** 状态。



### 3.4 文件与 I\O 流

#### 3.4.1 Java 中 IO 流分为几种?

- 按照流的流向分，可以分为输入流和输出流；
- 按处理数据单位不同：字节流，字符流。
  （1） 字节流：数据流中最小的数据单元是字节。
  （2）字符流：数据流中最小的数据单元是字符， Java中的字符是Unicode编码，一个字符占用两个字节。
  按功能不同：节点流，处理流。
  （1）程序用于直接操作目标设备所对应的类叫节点流。
  （2）程序通过一个间接流类去调用节点流类，以达到更加灵活方便地读写各种类型的数据，这个间接流类就是处理流。

Java Io 流共涉及 40 多个类，这些类看上去很杂乱，但实际上很有规则，而且彼此之间存在非常紧密的联系， Java I0 流的 40 多个类都是从如下 4 个抽象类基类中派生出来的。

- InputStream/Reader: 所有的输入流的基类，前者是字节输入流，后者是字符输入流。
- OutputStream/Writer: 所有输出流的基类，前者是字节输出流，后者是字符输出流。

按操作方式分类结构图：

![IO-操作方式分类](.\imgs\io1.png)

按操作对象分类结构图：

![IO-操作对象分类](.\imgs\io2.png)

##### 3.4.1.1. 既然有了字节流,为什么还要有字符流?

问题本质想问：**不管是文件读写还是网络发送接收，信息的最小存储单元都是字节，那为什么 I/O 流操作要分为字节流操作和字符流操作呢？**

回答：字符流是由 Java 虚拟机将字节转换得到的，问题就出在这个过程还算是非常耗时，并且，如果我们不知道编码类型就很容易出现乱码问题。所以， I/O 流就干脆提供了一个直接操作字符的接口，方便我们平时对字符进行流操作。如果音频文件、图片等媒体文件用字节流比较好，如果涉及到字符的话使用字符流比较好。

##### 3.4.1.2. BIO,NIO,AIO 有什么区别?

- **BIO (Blocking I/O):** 同步阻塞 I/O 模式，数据的读取写入必须阻塞在一个线程内等待其完成。在活动连接数不是特别高（小于单机 1000）的情况下，这种模型是比较不错的，可以让每一个连接专注于自己的 I/O 并且编程模型简单，也不用过多考虑系统的过载、限流等问题。线程池本身就是一个天然的漏斗，可以缓冲一些系统处理不了的连接或请求。但是，当面对十万甚至百万级连接的时候，传统的 BIO 模型是无能为力的。因此，我们需要一种更高效的 I/O 处理模型来应对更高的并发量。
- **NIO (Non-blocking/New I/O):** NIO 是一种同步非阻塞的 I/O 模型，在 Java 1.4 中引入了 NIO 框架，对应 java.nio 包，提供了 Channel , Selector，Buffer 等抽象。NIO 中的 N 可以理解为 Non-blocking，不单纯是 New。它支持面向缓冲的，基于通道的 I/O 操作方法。 NIO 提供了与传统 BIO 模型中的 `Socket` 和 `ServerSocket` 相对应的 `SocketChannel` 和 `ServerSocketChannel` 两种不同的套接字通道实现,两种通道都支持阻塞和非阻塞两种模式。阻塞模式使用就像传统中的支持一样，比较简单，但是性能和可靠性都不好；非阻塞模式正好与之相反。对于低负载、低并发的应用程序，可以使用同步阻塞 I/O 来提升开发速率和更好的维护性；对于高负载、高并发的（网络）应用，应使用 NIO 的非阻塞模式来开发
- **AIO (Asynchronous I/O):** AIO 也就是 NIO 2。在 Java 7 中引入了 NIO 的改进版 NIO 2,它是异步非阻塞的 IO 模型。异步 IO 是基于事件和回调机制实现的，也就是应用操作之后会直接返回，不会堵塞在那里，当后台处理完成，操作系统会通知相应的线程进行后续的操作。AIO 是异步 IO 的缩写，虽然 NIO 在网络操作中，提供了非阻塞的方法，但是 NIO 的 IO 行为还是同步的。对于 NIO 来说，我们的业务线程是在 IO 操作准备好时，得到通知，接着就由这个线程自行进行 IO 操作，IO 操作本身是同步的。查阅网上相关资料，我发现就目前来说 AIO 的应用还不是很广泛，Netty 之前也尝试使用过 AIO，不过又放弃了。

## 4 易错点

### 1 基础

#### 1.1 正确使用 equals 方法

Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用 equals。

举个例子：

```java
// 不能使用一个值为null的引用类型变量来调用非静态方法，否则会抛出异常
String str = null;
if (str.equals("SnailClimb")) {
  ...
} else {
  ..
}Copy to clipboardErrorCopied
```

运行上面的程序会抛出空指针异常，但是我们把第二行的条件判断语句改为下面这样的话，就不会抛出空指针异常，else 语句块得到执行。：

```java
"SnailClimb".equals(str);// false Copy to clipboardErrorCopied
```

不过更推荐使用 `java.util.Objects#equals`(JDK7 引入的工具类)。

```java
Objects.equals(null,"SnailClimb");// falseCopy to clipboardErrorCopied
```

我们看一下`java.util.Objects#equals`的源码就知道原因了。

```java
public static boolean equals(Object a, Object b) {
    // 可以避免空指针异常。如果a==null的话此时a.equals(b)就不会得到执行，避免出现空指针异常。
    return (a == b) || (a != null && a.equals(b));
}
```

#### 1.2 整型包装类值的比较

所有整型包装类对象值的比较必须使用equals方法。

先看下面这个例子：

```java
Integer x = 3;
Integer y = 3;
System.out.println(x == y);// true
Integer a = new Integer(3);
Integer b = new Integer(3);
System.out.println(a == b);//false
System.out.println(a.equals(b));//trueCopy to clipboardErrorCopied
```

当使用自动装箱方式创建一个Integer对象时，当数值在-128 ~127时，会将创建的 Integer 对象缓存起来，当下次再出现该数值时，直接从缓存中取出对应的Integer对象。所以上述代码中，x和y引用的是相同的Integer对象。

**注意：** 如果你的IDE(IDEA/Eclipse)上安装了阿里巴巴的p3c插件，这个插件如果检测到你用 ==的话会报错提示，推荐安装一个这个插件，很不错。

#### 1.3. BigDecimal

##### 1.3.1 BigDecimal 的用处

《阿里巴巴Java开发手册》中提到：**浮点数之间的等值判断，基本数据类型不能用==来比较，包装数据类型不能用 equals 来判断。** 具体原理和浮点数的编码方式有关，这里就不多提了，我们下面直接上实例：

```java
float a = 1.0f - 0.9f;
float b = 0.9f - 0.8f;
System.out.println(a);// 0.100000024
System.out.println(b);// 0.099999964
System.out.println(a == b);// falseCopy to clipboardErrorCopied
```

具有基本数学知识的我们很清楚的知道输出并不是我们想要的结果（**精度丢失**），我们如何解决这个问题呢？一种很常用的方法是：**使用使用 BigDecimal 来定义浮点数的值，再进行浮点数的运算操作。**

```java
BigDecimal a = new BigDecimal("1.0");
BigDecimal b = new BigDecimal("0.9");
BigDecimal c = new BigDecimal("0.8");

BigDecimal x = a.subtract(b); 
BigDecimal y = b.subtract(c); 

System.out.println(x); /* 0.1 */
System.out.println(y); /* 0.1 */
System.out.println(Objects.equals(x, y)); /* true */Copy to clipboardErrorCopied
```

##### 1.3.2. BigDecimal 的大小比较

`a.compareTo(b)` : 返回 -1 表示 `a` 小于 `b`，0 表示 `a` 等于 `b` ， 1表示 `a` 大于 `b`。

```java
BigDecimal a = new BigDecimal("1.0");
BigDecimal b = new BigDecimal("0.9");
System.out.println(a.compareTo(b));// 1Copy to clipboardErrorCopied
```

##### 1.3.3 BigDecimal 保留几位小数

通过 `setScale`方法设置保留几位小数以及保留规则。保留规则有挺多种，不需要记，IDEA会提示。

##### 1.3.4 BigDecimal 的使用注意事项

注意：我们在使用BigDecimal时，为了防止精度丢失，推荐使用它的 **BigDecimal(String)** 构造方法来创建对象。《阿里巴巴Java开发手册》对这部分内容也有提到如下图所示。

![bigDecimal1](.\imgs\bigDecimal1.png)

##### 1.3.5 总结

BigDecimal 主要用来操作（大）浮点数，BigInteger 主要用来操作大整数（超过 long 类型）。

BigDecimal 的实现利用到了 BigInteger, 所不同的是 BigDecimal 加入了小数位的概念

### 2 集合

#### 2.1. Arrays.asList()使用指南

最近使用`Arrays.asList()`遇到了一些坑，然后在网上看到这篇文章：[Java Array to List Examples](http://javadevnotes.com/java-array-to-list-examples) 感觉挺不错的，但是还不是特别全面。所以，自己对于这块小知识点进行了简单的总结。

##### 2.1.1. 简介

`Arrays.asList()`在平时开发中还是比较常见的，我们可以使用它将一个数组转换为一个List集合。

```java
String[] myArray = {"Apple", "Banana", "Orange"};
List<String> myList = Arrays.asList(myArray);
//上面两个语句等价于下面一条语句
List<String> myList = Arrays.asList("Apple","Banana", "Orange");Copy to clipboardErrorCopied
```

JDK 源码对于这个方法的说明：

```java
/**
  *返回由指定数组支持的固定大小的列表。此方法作为基于数组和基于集合的API之间的桥梁，
  * 与 Collection.toArray()结合使用。返回的List是可序列化并实现RandomAccess接口。
  */
public static <T> List<T> asList(T... a) {
    return new ArrayList<>(a);
}Copy to clipboardErrorCopied
```

##### 2.1.2. 《阿里巴巴Java 开发手册》对其的描述

`Arrays.asList()`将数组转换为集合后,底层其实还是数组，《阿里巴巴Java 开发手册》对于这个方法有如下描述：

![bigDecimal1](.\imgs\asList1.png)

##### 2.1.3. 使用时的注意事项总结

**传递的数组必须是对象数组，而不是基本类型。**

`Arrays.asList()`是泛型方法，传入的对象必须是对象数组。

```java
int[] myArray = {1, 2, 3};
List myList = Arrays.asList(myArray);
System.out.println(myList.size());//1
System.out.println(myList.get(0));//数组地址值
System.out.println(myList.get(1));//报错：ArrayIndexOutOfBoundsException
int[] array = (int[]) myList.get(0);
System.out.println(array[0]);//1Copy to clipboardErrorCopied
```

当传入一个原生数据类型数组时，`Arrays.asList()` 的真正得到的参数就不是数组中的元素，而是数组对象本身！此时List 的唯一元素就是这个数组，这也就解释了上面的代码。

我们使用包装类型数组就可以解决这个问题。

```java
Integer[] myArray = {1, 2, 3};Copy to clipboardErrorCopied
```

**使用集合的修改方法:add()、remove()、clear()会抛出异常。**

```java
List myList = Arrays.asList(1, 2, 3);
myList.add(4);//运行时报错：UnsupportedOperationException
myList.remove(1);//运行时报错：UnsupportedOperationException
myList.clear();//运行时报错：UnsupportedOperationExceptionCopy to clipboardErrorCopied
```

`Arrays.asList()` 方法返回的并不是 `java.util.ArrayList` ，而是 `java.util.Arrays` 的一个内部类,这个内部类并没有实现集合的修改方法或者说并没有重写这些方法。

```java
List myList = Arrays.asList(1, 2, 3);
System.out.println(myList.getClass());//class java.util.Arrays$ArrayListCopy to clipboardErrorCopied
```

下图是`java.util.Arrays$ArrayList`的简易源码，我们可以看到这个类重写的方法有哪些。

```java
  private static class ArrayList<E> extends AbstractList<E>
        implements RandomAccess, java.io.Serializable
    {
        ...

        @Override
        public E get(int index) {
          ...
        }

        @Override
        public E set(int index, E element) {
          ...
        }

        @Override
        public int indexOf(Object o) {
          ...
        }

        @Override
        public boolean contains(Object o) {
           ...
        }

        @Override
        public void forEach(Consumer<? super E> action) {
          ...
        }

        @Override
        public void replaceAll(UnaryOperator<E> operator) {
          ...
        }

        @Override
        public void sort(Comparator<? super E> c) {
          ...
        }
    }Copy to clipboardErrorCopied
```

我们再看一下`java.util.AbstractList`的`remove()`方法，这样我们就明白为啥会抛出`UnsupportedOperationException`。

```java
public E remove(int index) {
    throw new UnsupportedOperationException();
}Copy to clipboardErrorCopied
```

##### 2.1.4. 如何正确的将数组转换为ArrayList?>

**1. 自己动手实现（教育目的）**

```java
//JDK1.5+
static <T> List<T> arrayToList(final T[] array) {
  final List<T> l = new ArrayList<T>(array.length);

  for (final T s : array) {
    l.add(s);
  }
  return l;
}Copy to clipboardErrorCopied
Integer [] myArray = { 1, 2, 3 };
System.out.println(arrayToList(myArray).getClass());//class java.util.ArrayListCopy to clipboardErrorCopied
```

**2. 最简便的方法(推荐)**

```java
List list = new ArrayList<>(Arrays.asList("a", "b", "c"))Copy to clipboardErrorCopied
```

**3. 使用 Java8 的Stream(推荐)**

```java
Integer [] myArray = { 1, 2, 3 };
List myList = Arrays.stream(myArray).collect(Collectors.toList());
//基本类型也可以实现转换（依赖boxed的装箱操作）
int [] myArray2 = { 1, 2, 3 };
List myList = Arrays.stream(myArray2).boxed().collect(Collectors.toList());Copy to clipboardErrorCopied
```

**4. 使用 Guava(推荐)**

对于不可变集合，你可以使用[`ImmutableList`](https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/ImmutableList.java)类及其[`of()`](https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/ImmutableList.java#L101)与[`copyOf()`](https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/ImmutableList.java#L225)工厂方法：（参数不能为空）

```java
List<String> il = ImmutableList.of("string", "elements");  // from varargs
List<String> il = ImmutableList.copyOf(aStringArray);      // from arrayCopy to clipboardErrorCopied
```

对于可变集合，你可以使用[`Lists`](https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/Lists.java)类及其[`newArrayList()`](https://github.com/google/guava/blob/master/guava/src/com/google/common/collect/Lists.java#L87)工厂方法：

```java
List<String> l1 = Lists.newArrayList(anotherListOrCollection);    // from collection
List<String> l2 = Lists.newArrayList(aStringArray);               // from array
List<String> l3 = Lists.newArrayList("or", "string", "elements"); // from varargsCopy to clipboardErrorCopied
```

**5. 使用 Apache Commons Collections**

```java
List<String> list = new ArrayList<String>();
CollectionUtils.addAll(list, str);Copy to clipboardErrorCopied
```

**6. 使用 Java9 的 List.of()方法**

```java
Integer[] array = {1, 2, 3};
List<Integer> list = List.of(array);
System.out.println(list); /* [1, 2, 3] */
/* 不支持基本数据类型 */Copy to clipboardErrorCopied
```

#### 2.2 Collection.toArray()方法使用的坑&如何反转数组

该方法是一个泛型方法：`<T> T[] toArray(T[] a);` 如果`toArray`方法中没有传递任何参数的话返回的是`Object`类型数组。

```java
String [] s= new String[]{
    "dog", "lazy", "a", "over", "jumps", "fox", "brown", "quick", "A"
};
List<String> list = Arrays.asList(s);
Collections.reverse(list);
s=list.toArray(new String[0]);//没有指定类型的话会报错Copy to clipboardErrorCopied
```

由于JVM优化，`new String[0]`作为`Collection.toArray()`方法的参数现在使用更好，`new String[0]`就是起一个模板的作用，指定了返回数组的类型，0是为了节省空间，因为它只是为了说明返回的类型。详见：<https://shipilev.net/blog/2016/arrays-wisdom-ancients/>

#### 2.3. 不要在 foreach 循环里进行元素的 remove/add 操作

如果要进行`remove`操作，可以调用迭代器的 `remove `方法而不是集合类的 remove 方法。因为如果列表在任何时间从结构上修改创建迭代器之后，以任何方式除非通过迭代器自身`remove/add`方法，迭代器都将抛出一个`ConcurrentModificationException`,这就是单线程状态下产生的 **fail-fast 机制**。

> **fail-fast 机制** ：多个线程对 fail-fast 集合进行修改的时，可能会抛出ConcurrentModificationException，单线程下也会出现这种情况，上面已经提到过。

Java8开始，可以使用`Collection#removeIf()`方法删除满足特定条件的元素,如

```java
List<Integer> list = new ArrayList<>();
for (int i = 1; i <= 10; ++i) {
    list.add(i);
}
list.removeIf(filter -> filter % 2 == 0); /* 删除list中的所有偶数 */
System.out.println(list); /* [1, 3, 5, 7, 9] */Copy to clipboardErrorCopied
```

`java.util`包下面的所有的集合类都是fail-fast的，而`java.util.concurrent`包下面的所有的类都是fail-safe的。

![](.\imgs\iterator.png)



# 三 note

## 1 static

### 1.1静态代码块

+ 当第一次用到本类时，静态代码块执行唯一的一次。

+ 静态内容总是优先于非静态，所以静态代码块比构造方法先执行。

## 2  继承

### 2.1 区分父类成员变量，子类成员变量，子类局部变量

+ 子类局部：name

+ 子类成员变量 ：this.name

+ 父类成员变量：super.name

### 2.2 子类方法的返回值类型小于等于父类方法

+ 若子类重写父类方法，则子类方法的返回值类型小于等于父类方法。eg: Object>String

### 2.3 子类方法的权限修饰符大于等于父类方法。

+ 若子类重写父类方法，则子类方法的权限修饰符大于等于父类方法。

+ public>protected>(default)>private

### 2.4 父子类构造方法的访问特点

+ 子类构造方法中默认隐含一个“super();”调用，所以一定是先调用父类构造方法，后执行子类构造方法。

+ 子类构造方法可以通过super关键字调用父类的重载的构造方法。

+ 2.6 super调用必须是子类构造方法的第一个语句。不能一个子类构造调用多次super构造。

### 2.5 super三种用法

+ 访问父类成员变量 super.xxxName;

+ 访问父类成员方法 super.method();

+ 访问父类构造方法 super(); super(T t);

### 2.6 this三种用法

+ 在本类成员方法中，访问本类成员变量 this.xxxName

+ 在本类成员方法中，访问本类另一个成员方法。this.methodB

+ 在本类构造方法中，访问本类另一个构造方法。this(T t)。

​	要注意

+ this调用也必须是构造方法的第一个语句。也必须是唯一一个。

+ b) super 和this两种构造调用，不能同时使用。

### 2.7 抽象类注意事项

+ 抽象类中可以有构造方法，子类创建对象时，调用此方法。一般用于初始化父类成员。

+ 抽象类中不一定有抽象方法。但有抽象方法的类一定是抽象类。

+ 抽象类的子类必须重写抽象类中的所有抽象方法，除非该子类也是一个抽象类。



## 3接口

### 3.1 接口内容

java7 : 

1. 常量

2. 抽象方法 （任何java版本都可以定义）
   + 接口中的抽象方法，修饰符只能是public abstract ,可以选择性省略

java8 新增:

3. 默认方法   
   + 格式: public default 返回值类型 方法名(args.....) { xxxxxxx } 
   + 接口中的默认方法会被实现类继承。
   + 可以解决接口升级问题。接口中新增default方法不需要修改实现类。
   + 接口中的默认方法可以被实现类的对象直接调用。也可以在实现类中重写覆盖。

4. 静态方法

   + 格式: public static 返回值类型 方法名(args.....) { xxxxxxx } 

   + 注意，**不能通过接口实现类的对象来调用接口中的静态方法**。因为一个类可以实现多个接口，这些接口中可能有重名	静态方法，产生冲突。而由于单继承，多实现机制，子类的对象可以调用父类的静态方法。
   + 正确用法：接口名称.静态方法名(args...);



java9 新增:

5.  私有方法
    1. 普通私有方法

       + 解决多个默认方法直接重复代码的问题

       + 格式： private 返回值类型 方法名(args.....) { xxxxxxx } 

   2. 静态私有方法
      + 解决多个默认方法直接重复代码的问题
      + 格式： private static 返回值类型 方法名(args.....) { xxxxxxx } 

​	

### 3.2 接口的成员变量

1. 从接口中也可以定义成员变量，但是必须用public static final三个关键字修饰。从效果上看这其实就是接口的常量。
2. 格式：public static final 数据类型 常量名称 = 数据值;
3. 接口中的常量，可以省略public static final，不写也是这样。
4. 接口中的常量，必须进行赋值，不能不赋值。

### 3.3 使用接口的注意事项

1. 如果实现类没有覆盖重写所有的抽象方法，那么实现类必定是一个抽象类。
2. 如果实现类所实现的多个接口中，存在重复的抽象方法，那么只需要重写一次即可。
3. 如果实现类所实现的多个接口中，存在重复的默认方法，那么实现类一定要对冲突的默认方法进行重写。
4. 一个类如果直接父类当中的方法，和接口中的默认方法产生了冲突，优先使用父类中的方法。

### 3.4 接口之间的多继承

1. 接口与接口直接是多继承的。
2. 多个父接口中的抽象方法如果重复，没关系。
3. 多个父接口中的默认方法如果重复，那么子接口必须进行默认方法的覆盖重写，而且带着default关键字。

## 4 多态

1. 概念 

   一个对象有多种形态。

2. 前提

   extends继承或implement实现是多态性的前提。

3. 代码中如何体现多态性

   父类引用指向子类对象。

4. 访问成员变量的两种方式。

   + 直接通过对象名称访问，等号左边是谁，优先用谁。没有则向上找。（成员变量不能覆盖重写）

     例：Fu fu = new Zi();   若父类子类中都有重名变量num，则fu.num访问的是Fu类中的num

   + 间接通过成员方法访问，看该方法属于谁，则优先访问谁。没有则向上找。

     例：Fu fu = new Zi();   若父类子类中都有重名变量num，且zi类没有重写showNum(),则fu.showNum访问的是Fu类中的num。

     若zi类重写了showNum(),则fu.showNum访问的是Zi类中的num。

5. 多态代码中，访问成员方法的规则是，看new的是谁，就优先用谁。没有则想上找。

6. 向上转型，向下转型

   - 向上转型格式：父类名称 对象名 = new 子类名称（）；//其实就是多态写法

   - 向下转型：子类名称 对象名 = （子类名称） 父类对象；

     //对象创建时是啥，才能向下转型为啥，不然编译时不会报错，但运行时会报错。

7. 对象名 instanceof 类名：返回一个boolean值，表示前面的对象能不能当作后面类的实例。

## 5 final

1. 修饰类 表示该类没有子类了。

2. 修饰方法 表示该方法不能被子类覆盖重写  

3. 对于类和方法来说，abstract 和final不能同时使用，矛盾。

4. 修饰局部变量 该变量的值不能进行更改。

   + 对于基本类型来说，不可变指变量中的数据不可变。
   + 对于引用类型来说，不可变指变量中的地址值不可变。但是指向的对象包含的数据可以变。

5. 修饰成员变量 改变量也是不可变的。

   + final修饰的成员变量，必须手动赋值，不会给默认值了。
   + 对于final修饰的成员变量，要么直接赋值，要么通过构造方法赋值。二者选其一。

   

## 6 四种权限修饰符

| 权限\修饰符  | public | protected | (default) | private |
| :----------: | :----: | :-------: | :-------: | :-----: |
|   同一个类   |   T    |     T     |     T     |    T    |
|   同一个包   |   T    |     T     |     T     |    F    |
|  不同包子类  |   T    |     T     |     F     |    F    |
| 不同包非子类 |   T    |     F     |     F     |    F    |

## 7 内部类

### 7.1 成员内部类

+ 格式 ： 修饰符 class 类名{

  ​	修饰符 class 类名{

  ​	} 

  } 

+ 注意，内用外，随意访问（private的成员变量也可访问）。外用内，需要内部类对象。

+ 使用方式

  1. 间接：在外部类方法中使用内部类。然后main中只调用外部类的方法。
  2. 直接：外部类名称.内部类名称 = new 外部类名称().内部类名称();

+ 重名变量访问方式：

  1. 内部类局部变量:变量名
  2. 内部类成员变量:this.变量名
  3. 外部类成员变量:外部类类名.this.变量名

### 7.2 局部内部类

+ 概念：定义在方法内部的类,只有当前方法能使用它，出了就不能用了。

+ 格式：修饰符 class 外部类名称 {

  ​					修饰符 返回值类型 外部类方法名称（args...）{	

  ​					 	class 局部内部类名称 {

  ​						     	xxxx;

  ​						 }

  ​					}

  ​			}

+ 如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final】的。

  备注：从java8开始，只要局部变量事实不变，那么final关键字可以省略。

  原因：

   	1. new出来的对象在堆内存中。
   	2. 局部变量是跟着方法走的，在栈内存中。
   	3. 方法运行结束之后，立刻出栈，局部变量会立刻消失。
   	4. 但是new出来的对象在堆内存中，直到垃圾回收才会消失。对象存在时间比局部变量长，所以需要保证变量不变，对象才可一直使用该变量的拷贝。不然局部变量消失后对象就找不到该变量了。

### 7.3 匿名内部类

```java
/*
如果接口的实现类（或者是父类的子类）只需要使用唯一的一次，
那么这种情况下就可以省略掉该类的定义，而改为使用【匿名内部类】。

匿名内部类的定义格式：
接口名称 对象名 = new 接口名称() {
    // 覆盖重写所有抽象方法
};

对格式“new 接口名称() {...}”进行解析：
1. new代表创建对象的动作
2. 接口名称就是匿名内部类需要实现哪个接口
3. {...}这才是匿名内部类的内容

另外还要注意几点问题：
1. 匿名内部类，只能创建一次对象。
如果希望多次创建对象，而且类的内容一样的话，那么就需要使用单独定义的实现类了。
2. 匿名对象，在【调用方法】的时候，只能调用唯一一次。
如果希望同一个对象，调用多次方法，那么必须给对象起个名字。
3. 匿名内部类是省略了【实现类/子类名称】，但是匿名对象是省略了【对象名称】
强调：匿名内部类和匿名对象不是一回事！！！
 */
```





​	

## 8 类的修饰符总结

1. 外部类：public / (default)
2. 成员内部类：public / protected / (default) / private
3. 局部内部类：什么都不能写

## 9 Object 类

1. toString:打印对象调用的是Object类的toString()方法。默认打印对象的地址值。要打印对象的内容，需要重写toString()方法。

2. + equals():Object类默认的equals调用==判断是否相等

   + equals()的参数是Object对象，重写equals方法无法使用子类的属性，所以需要向下强转。还要先用 instanceOf判断一下

   + Objects.equals()方法：可以防止空指针异常

     ```java
     public static boolean equals(Object a, Object b) {
         return (a == b) || (a != null && a.equals(b));
     }
     ```

## 10 Date 类

` java.util.Date`类 表示特定的瞬间，精确到毫秒。

继续查阅Date类的描述，发现Date拥有多个构造函数，只是部分已经过时，但是其中有未过时的构造函数可以把毫秒值转成日期对象。

- `public Date()`：分配Date对象并初始化此对象，以表示分配它的时间（精确到毫秒）。
- `public Date(long date)`：分配Date对象并初始化此对象，以表示自从标准基准时间（称为“历元（epoch）”，即1970年1月1日00:00:00 GMT）以来的指定毫秒数。

> tips: 由于我们处于东八区，所以我们的基准时间为1970年1月1日8时0分0秒。

简单来说：使用无参构造，可以自动设置当前系统时间的毫秒时刻；指定long类型的构造参数，可以自定义毫秒时刻。tips:在使用println方法时，会自动调用Date类中的toString方法。Date类对Object类中的toString方法进行了覆盖重写，所以结果为指定格式的字符串。

### 常用方法

Date类中的多数方法已经过时，常用的方法有：

- `public long getTime()` 把日期对象转换成对应的时间毫秒值。

## 11 DateFormat类

`java.text.DateFormat` 是日期/时间格式化子类的抽象类，我们通过这个类可以帮我们完成日期和文本之间的转换,也就是可以在Date对象与String对象之间进行来回转换。

- **格式化**：按照指定的格式，从Date对象转换为String对象。
- **解析**：按照指定的格式，从String对象转换为Date对象。

### 构造方法

由于DateFormat为抽象类，不能直接使用，所以需要常用的子类`java.text.SimpleDateFormat`。这个类需要一个模式（格式）来指定格式化或解析的标准。构造方法为：

- `public SimpleDateFormat(String pattern)`：用给定的模式和默认语言环境的日期格式符号构造SimpleDateFormat。

参数pattern是一个字符串，代表日期时间的自定义格式。

### 格式规则

常用的格式规则为：

| 标识字母（区分大小写） | 含义 |
| ---------------------- | ---- |
| y                      | 年   |
| M                      | 月   |
| d                      | 日   |
| H                      | 时   |
| m                      | 分   |
| s                      | 秒   |

> 备注：更详细的格式规则，可以参考SimpleDateFormat类的API文档0。

创建SimpleDateFormat对象的代码如：

```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Demo02SimpleDateFormat {
    public static void main(String[] args) {
        // 对应的日期格式如：2018-01-16 15:06:38
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }    
}
```

### 常用方法

DateFormat类的常用方法有：

- `public String format(Date date)`：将Date对象格式化为字符串。
- `public Date parse(String source)`：将字符串解析为Date对象。

#### format方法

使用format方法的代码为：

```java
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 把Date对象转换成String
*/
public class Demo03DateFormatMethod {
    public static void main(String[] args) {
        Date date = new Date();
        // 创建日期格式化对象,在获取格式化对象时可以指定风格
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = df.format(date);
        System.out.println(str); // 2008年1月23日
    }
}
```

#### parse方法

使用parse方法的代码为：

```java
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/*
 把String转换成Date对象
*/
public class Demo04DateFormatMethod {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        String str = "2018年12月11日";
        Date date = df.parse(str);
        System.out.println(date); // Tue Dec 11 00:00:00 CST 2018
    }
}
```

## 12 Calendar类

### 概念

`java.util.Calendar`是日历类，在Date后出现，替换掉了许多Date的方法。该类将所有可能用到的时间信息封装为静态成员变量，方便获取。日历类就是方便获取各个时间属性的。

### 获取方式

Calendar为抽象类，由于语言敏感性，Calendar类在创建对象时并非直接创建，而是通过静态方法创建，返回子类对象，如下：

Calendar静态方法

- `public static Calendar getInstance()`：使用默认时区和语言环境获得一个日历

例如：

```java
import java.util.Calendar;

public class Demo06CalendarInit {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
    }    
}
```

### 常用方法

根据Calendar类的API文档，常用方法有：

- `public int get(int field)`：返回给定日历字段的值。
- `public void set(int field, int value)`：将给定的日历字段设置为给定值。
- `public abstract void add(int field, int amount)`：根据日历的规则，为给定的日历字段添加或减去指定的时间量。
- `public Date getTime()`：返回一个表示此Calendar时间值（从历元到现在的毫秒偏移量）的Date对象。

Calendar类中提供很多成员常量，代表给定的日历字段：

| 字段值       | 含义                                  |
| ------------ | ------------------------------------- |
| YEAR         | 年                                    |
| MONTH        | 月（从0开始，可以+1使用）             |
| DAY_OF_MONTH | 月中的天（几号）                      |
| HOUR         | 时（12小时制）                        |
| HOUR_OF_DAY  | 时（24小时制）                        |
| MINUTE       | 分                                    |
| SECOND       | 秒                                    |
| DAY_OF_WEEK  | 周中的天（周几，周日为1，可以-1使用） |

#### get/set方法

get方法用来获取指定字段的值，set方法用来设置指定字段的值，代码使用演示：

```java
import java.util.Calendar;

public class CalendarUtil {
    public static void main(String[] args) {
        // 创建Calendar对象
        Calendar cal = Calendar.getInstance();
        // 设置年 
        int year = cal.get(Calendar.YEAR);
        // 设置月
        int month = cal.get(Calendar.MONTH) + 1;
        // 设置日
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日");
    }    
}
```

```java
import java.util.Calendar;

public class Demo07CalendarMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); // 2020年1月17日
    }
}
```

#### add方法

add方法可以对指定日历字段的值进行加减操作，如果第二个参数为正数则加上偏移量，如果为负数则减去偏移量。代码如：

```java
import java.util.Calendar;

public class Demo08CalendarMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); // 2018年1月17日
        // 使用add方法
        cal.add(Calendar.DAY_OF_MONTH, 2); // 加2天
        cal.add(Calendar.YEAR, -3); // 减3年
        System.out.print(year + "年" + month + "月" + dayOfMonth + "日"); // 2015年1月18日; 
    }
}
```

#### getTime方法

Calendar中的getTime方法并不是获取毫秒时刻，而是拿到对应的Date对象。

```java
import java.util.Calendar;
import java.util.Date;

public class Demo09CalendarMethod {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        Date date = cal.getTime();
        System.out.println(date); // Tue Jan 16 16:03:09 CST 2018
    }
}
```

> 小贴士：
>
> ​     西方星期的开始为周日，中国为周一。
>
> ​     在Calendar类中，月份的表示是以0-11代表1-12月。
>
> ​     日期是有大小关系的，时间靠后，时间越大。

## System类

`java.lang.System`类中提供了大量的静态方法，可以获取与系统相关的信息或系统级操作，在System类的API文档中，常用的方法有：

- `public static long currentTimeMillis()`：返回以毫秒为单位的当前时间。
- `public static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length)`：将数组中指定的数据拷贝到另一个数组中。



## 13 String, StringBuilder,StringBuffer



由于String类的对象内容不可改变，所以每当进行字符串拼接时，总是会在内存中创建一个新的对象。例如：

```java
public class StringDemo {
    public static void main(String[] args) {
        String s = "Hello";
        s += "World";
        System.out.println(s);
    }
}
```

在API中对String类有这样的描述：字符串是常量，它们的值在创建后不能被更改。(因为底层的数组是final的)

根据这句话分析我们的代码，其实总共产生了三个字符串，即`"Hello"`、`"World"`和`"HelloWorld"`。引用变量s首先指向`Hello`对象，最终指向拼接出来的新字符串对象，即`HelloWord` 。

由此可知，如果对字符串进行拼接操作，每次拼接，都会构建一个新的String对象，既耗时，又浪费空间。为了解决这一问题，可以使用`java.lang.StringBuilder`类。

### 13.1 StringBuilder概述

查阅`java.lang.StringBuilder`的API，StringBuilder又称为可变字符序列，它是一个类似于 String 的字符串缓冲区，通过某些方法调用可以改变该序列的长度和内容。

原来StringBuilder是个字符串的缓冲区，即它是一个容器，容器中可以装很多字符串。并且能够对其中的字符串进行各种操作。

它的内部拥有一个数组(不是final的)用来存放字符串内容，进行字符串拼接时，直接在数组中加入新内容。StringBuilder会自动维护数组的扩容。原理如下图所示：(默认16字符空间，超过自动扩充)

### 13.2 构造方法

根据StringBuilder的API文档，常用构造方法有2个：

- `public StringBuilder()`：构造一个空的StringBuilder容器。
- `public StringBuilder(String str)`：构造一个StringBuilder容器，并将字符串添加进去。

### 13.3 常用方法

StringBuilder常用的方法有2个：

- `public StringBuilder append(...)`：添加任意类型数据的字符串形式，并返回当前对象自身。
- `public String toString()`：将当前StringBuilder对象转换为String对象。

1. append方法

append方法具有多种重载形式，可以接收任意类型的参数。任何数据作为参数都会将对应的字符串内容添加到StringBuilder中。例如：

```java
public class Demo02StringBuilder {
	public static void main(String[] args) {
		//创建对象
		StringBuilder builder = new StringBuilder();
		//public StringBuilder append(任意类型)
		StringBuilder builder2 = builder.append("hello");
		//对比一下
		System.out.println("builder:"+builder);
		System.out.println("builder2:"+builder2);
		System.out.println(builder == builder2); //true
	    // 可以添加 任何类型
		builder.append("hello");
		builder.append("world");
		builder.append(true);
		builder.append(100);
		// 在我们开发中，会遇到调用一个方法后，返回一个对象的情况。然后使用返回的对象继续调用方法。
        // 这种时候，我们就可以把代码现在一起，如append方法一样，代码如下
		//链式编程
		builder.append("hello").append("world").append(true).append(100);
		System.out.println("builder:"+builder);
	}
}
```

> 备注：StringBuilder已经覆盖重写了Object当中的toString方法。

2. toString方法

通过toString方法，StringBuilder对象将会转换为不可变的String对象。如：

```java
public class Demo16StringBuilder {
    public static void main(String[] args) {
        // 链式创建
        StringBuilder sb = new StringBuilder("Hello").append("World").append("Java");
        // 调用方法
        String str = sb.toString();
        System.out.println(str); // HelloWorldJava
    }
}
```

## 14 装箱拆箱

基本类型与对应的包装类对象之间，来回转换的过程称为”装箱“与”拆箱“：

- **装箱**：从基本类型转换为对应的包装类对象。
- **拆箱**：从包装类对象转换为对应的基本类型。

用Integer与 int为例：（看懂代码即可）

基本数值---->包装对象

```java
Integer i = new Integer(4);//使用构造函数函数
Integer iii = Integer.valueOf(4);//使用包装类中的valueOf方法
```

包装对象---->基本数值

```java
int num = i.intValue();
```

## 15 基本类型与字符串类型转化

```java
/*
    基本类型与字符串类型之间的相互转换
    基本类型->字符串(String)
        1.基本类型的值+""  最简单的方法(工作中常用)
        2.包装类的静态方法toString(参数),不是Object类的toString() 重载
            static String toString(int i) 返回一个表示指定整数的 String 对象。
        3.String类的静态方法valueOf(参数)
            static String valueOf(int i) 返回 int 参数的字符串表示形式。
    字符串(String)->基本类型
        使用包装类的静态方法parseXXX("字符串");
            Integer类: static int parseInt(String s)
            Double类: static double parseDouble(String s)
 */
```



集合按照其存储结构可以分为两大类，分别是单列集合`java.util.Collection`和双列集合`java.util.Map`

## 16 collection

![](.\imgs\collections.png)

- **Collection**：单列集合类的根接口，用于存储一系列符合某种规则的元素，它有两个重要的子接口，分别是`java.util.List`和`java.util.Set`。其中，`List`的特点是元素有序、元素可重复。`Set`的特点是元素无序，而且不可重复。`List`接口的主要实现类有`java.util.ArrayList`和`java.util.LinkedList`，`Set`接口的主要实现类有`java.util.HashSet`和`java.util.TreeSet`。

- **Collection 常用功能**

  Collection是所有单列集合的父接口，因此在Collection中定义了单列集合(List和Set)通用的一些方法，这些方法可用于操作所有的单列集合。方法如下：

  - `public boolean add(E e)`：  把给定的对象添加到当前集合中 。
  - `public void clear()` :清空集合中所有的元素。
  - `public boolean remove(E e)`: 把给定的对象在当前集合中删除。
  - `public boolean contains(E e)`: 判断当前集合中是否包含给定的对象。
  - `public boolean isEmpty()`: 判断当前集合是否为空。
  - `public int size()`: 返回集合中元素的个数。
  - `public Object[] toArray()`: 把集合中的元素，存储到数组中。

## 17 泛型

Collection虽然可以存储各种对象，但实际上通常Collection只存储同一类型对象。例如都是存储字符串对象。因此在JDK5之后，新增了**泛型**(**Generic**)语法，让你在设计API时可以指定类或方法支持泛型，这样我们使用API的时候也变得更为简洁，并得到了编译时期的语法检查。

- **泛型**：可以在类或方法中预支地使用未知的类型。

> tips:一般在创建对象时，将未知的类型确定具体的类型。当没有指定泛型时，默认类型为Object类型。

+ 使用泛型的好处

泛型带来了哪些好处呢？

- 将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
- 避免了类型强转的麻烦。

### 泛型的定义与使用

我们在集合中会大量使用到泛型，这里来完整地学习泛型知识。

泛型，用来灵活地将数据类型应用到不同的类、方法、接口当中。将数据类型作为参数进行传递。

#### 定义和使用含有泛型的类

定义格式：

```
修饰符 class 类名<代表泛型的变量> {  }
```

例如，API中的ArrayList集合：

```java
class ArrayList<E>{ 
    public boolean add(E e){ }

    public E get(int index){ }
   	....
}
```

使用泛型： 即什么时候确定泛型。

**在创建对象的时候确定泛型**

 例如，`ArrayList<String> list = new ArrayList<String>();`

此时，变量E的值就是String类型,那么我们的类型就可以理解为：

```java 
class ArrayList<String>{ 
     public boolean add(String e){ }

     public String get(int index){  }
     ...
}
```

再例如，`ArrayList<Integer> list = new ArrayList<Integer>();`

此时，变量E的值就是Integer类型,那么我们的类型就可以理解为：

```java
class ArrayList<Integer> { 
     public boolean add(Integer e) { }

     public Integer get(int index) {  }
     ...
}
```

举例自定义泛型类

```java
public class MyGenericClass<MVP> {
	//没有MVP类型，在这里代表 未知的一种数据类型 未来传递什么就是什么类型
	private MVP mvp;
     
    public void setMVP(MVP mvp) {
        this.mvp = mvp;
    }
     
    public MVP getMVP() {
        return mvp;
    }
}
```

使用:

```java
public class GenericClassDemo {
  	public static void main(String[] args) {		 
         // 创建一个泛型为String的类
         MyGenericClass<String> my = new MyGenericClass<String>();    	
         // 调用setMVP
         my.setMVP("curry");
         // 调用getMVP
         String mvp = my.getMVP();
         System.out.println(mvp);
         //创建一个泛型为Integer的类
         MyGenericClass<Integer> my2 = new MyGenericClass<Integer>(); 
         my2.setMVP(123);   	  
         Integer mvp2 = my2.getMVP();
    }
}
```

#### 含有泛型的方法

定义格式：

```
修饰符 <代表泛型的变量> 返回值类型 方法名(参数){  }
```

例如，

```java
public class MyGenericMethod {	  
    public <MVP> void show(MVP mvp) {
    	System.out.println(mvp.getClass());
    }
    
    public <MVP> MVP show2(MVP mvp) {	
    	return mvp;
    }
}
```

使用格式：**调用方法时，确定泛型的类型**

```java
public class GenericMethodDemo {
    public static void main(String[] args) {
        // 创建对象
        MyGenericMethod mm = new MyGenericMethod();
        // 演示看方法提示
        mm.show("aaa");
        mm.show(123);
        mm.show(12.45);
    }
}
```

#### 有泛型的接口

定义格式：

```
修饰符 interface接口名<代表泛型的变量> {  }
```

例如，

```java
public interface MyGenericInterface<E>{
	public abstract void add(E e);
	
	public abstract E getE();  
}
```

使用格式：

**1、定义类时确定泛型的类型**

例如

```java
public class MyImp1 implements MyGenericInterface<String> {
	@Override
    public void add(String e) {
        // 省略...
    }

	@Override
	public String getE() {
		return null;
	}
}
```

此时，泛型E的值就是String类型。

 **2、始终不确定泛型的类型，直到创建对象时，确定泛型的类型**

 例如

```java
public class MyImp2<E> implements MyGenericInterface<E> {
	@Override
	public void add(E e) {
       	 // 省略...
	}

	@Override
	public E getE() {
		return null;
	}
}
```

确定泛型：

```java
/*
 * 使用
 */
public class GenericInterface {
    public static void main(String[] args) {
        MyImp2<String>  my = new MyImp2<String>();  
        my.add("aa");
    }
}
```



## 18 LinkedList

### 特有方法

```csharp
//以下四个是特有方法
public void addFirst(E e)及addLast(E e)
public E getFirst()及getLast()
public E removeFirst()及public E removeLast()
public E get(int index);
//addFirst 等效于此类中的push
//removeFirst 等效于此类中的pop
```

## 19 Queue中方法区别

1、offer()和add()的区别
add()和offer()都是向队列中添加一个元素。但是如果想在一个满的队列中加入一个新元素，调用 add() 方法就会抛出一个 unchecked 异常，而调用 offer() 方法会返回 false。可以据此在程序中进行有效的判断！

2、peek()和element()的区别
peek()和element()都将在不移除的情况下返回队头，但是peek()方法在队列为空时返回null，调用element()方法会抛出NoSuchElementException异常。

3、poll()和remove()的区别
poll()和remove()都将移除并且返回队头，但是在poll()在队列为空时返回null，而remove()会抛出NoSuchElementException异常。

## 20 Hash

+ HashSet底层是哈希表
+ HashSet不能使用for遍历，可以使用for each 和iterator遍历。
+ 哈希值是一个十进制整数，由系统随即给出，表示对象的逻辑地址
+ LinkedHashSet相比HashSet多了一条链表，用于记录元素的存储顺序，保证元素有序

### 20.1 哈希表

+ 在**JDK1.8**之前，哈希表底层采用数组+链表实现，即使用链表处理冲突，同一hash值的链表都存储在一个链表里。但是当位于一个桶中的元素较多，即hash值相等的元素较多时，通过key值依次查找的效率较低。而JDK1.8中，哈希表存储采用数组+链表+红黑树实现，当链表长度超过阈值（8）时，将链表转换为红黑树，这样大大减少了查找时间。

+ set的add方法添加元素时，会调用元素的hashcode和equals方法判断是否重复，如果集合中没有重复元素，才添加。对于我们来讲保证HashSet集合元素的唯一，其实就是根据对象的hashCode和equals方法来决定的。如果我们往集合中存放自定义的对象，那么保证其唯一，就必须复写hashCode和equals方法建立属于当前对象的比较方式。

+ 为什么用红黑树

HashMap在里面就是链表加上红黑树的一种结构，这样利用了链表对内存的使用率以及红黑树的高效检索，是一种很happy的数据结构。

AVL树是一种高度平衡的二叉树，所以查找的非常高，但是，有利就有弊，AVL树为了维持这种高度的平衡，就要付出更多代价。每次插入、删除都要做调整，就比较复杂、耗时。所以，对于有频繁的插入、删除操作的数据集合，使用AVL树的代价就有点高了。

红黑树只是做到了近似平衡，并不严格的平衡，所以在维护的成本上，要比AVL树要低。

所以，红黑树的插入、删除、查找各种操作性能都比较稳定。对于工程应用来说，要面对各种异常情况，为了支撑这种工业级的应用，我们更倾向于这种性能稳定的平衡二叉查找树。

### 20.2 hashTable

```java
/*
    java.util.Hashtable<K,V>集合 implements Map<K,V>接口

    Hashtable:底层也是一个哈希表,是一个线程安全的集合,是单线程集合,速度慢
    HashMap:底层是一个哈希表,是一个线程不安全的集合,是多线程的集合,速度快

    HashMap集合(之前学的所有的集合):可以存储null值,null键
    Hashtable集合,不能存储null值,null键

    Hashtable和Vector集合一样,在jdk1.2版本之后被更先进的集合(HashMap,ArrayList)取代了
    Hashtable的子类Properties依然活跃在历史舞台
    Properties集合是一个唯一和IO流相结合的集合
 */
```



## 21  JDK9对集合添加的优化

通常，我们在代码中创建一个集合（例如，List 或 Set ），并直接用一些元素填充它。 实例化集合，几个 add方法 调用，使得代码重复。

```java
public class Demo01 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("abc");
        list.add("def");
        list.add("ghi");
        System.out.println(list);
    }
}
```

 Java 9，添加了几种集合工厂方法,更方便创建少量元素的集合、map实例。新的List、Set、Map的静态工厂方法可以更方便地创建集合的不可变实例。

例子：

```java
public class HelloJDK9 {  
    public static void main(String[] args) {  
        Set<String> str1=Set.of("a","b","c");  
        //str1.add("c");这里编译的时候不会错，但是执行的时候会报错，因为是不可变的集合  
        System.out.println(str1);  
        Map<String,Integer> str2=Map.of("a",1,"b",2);  
        System.out.println(str2);  
        List<String> str3=List.of("a","b");  
        System.out.println(str3);  
    }  
} 
```

需要注意以下两点：

> 1:of()方法只是Map，List，Set这三个接口的静态方法，其父类接口和子类实现并没有这类方法，比如    HashSet，ArrayList等待；
>
> 2:返回的集合是不可变的；



## 22 Exception

+ 异常的产生过程分析

 ![](.\imgs\exception.png)

+ try中如果捕获到异常，会跳转到catch，try中后续的代码不会执行。所以需要用到finally
+ 多个catch块处理异常时，多个catch中的异常不能相同，并且若catch中的多个异常之间有子父类异常的关系，那么子类异常要求在上面的catch处理，父类异常在下面的catch处理。因为如果父类异常在上，父类异常和子类异常都会被该catch块捕获，后面的子类异常catch块就没用了。
+ 如果父类抛出了多个异常,子类重写父类方法时,抛出和父类相同的异常或者是父类异常的子类或者不抛出异常。
+ 父类方法没有抛出异常，子类重写父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
+ 自定义异常类，如果继承Exception，必须处理（抛出或try catch）。如果继承RuntimeException，可以不处理。



## 23 多线程

### 23.1 并发与并行

- **并发**：指两个或多个事件在**同一个时间段内**发生。
- **并行**：指两个或多个事件在**同一时刻**发生（同时发生）。

### 23.2 进程与线程

- 进程**：是指一个内存中运行的应用程序，每个进程都有一个独立的内存空间，一个应用程序可以同时运行多个进程；进程也是程序的一次执行过程，是系统运行程序的基本单位；系统运行一个程序即是一个进程从创建、运行到消亡的过程。

- **线程**：线程是进程中的一个执行单元，负责当前进程中程序的执行，一个进程中至少有一个线程。一个进程中是可以有多个线程的，这个应用程序也可以称之为多线程程序。 

  简而言之：一个程序运行后至少有一个进程，一个进程中可以包含多个线程 

### 23.3 多线程原理

程序启动运行main时候，java虚拟机启动一个进程，主线程main在main()调用时候被创建。随着调用mt的对象的
start方法，另外一个新的线程也启动了，这样，整个应用就在多线程下运行。
通过这张图我们可以很清晰的看到多线程的执行流程，那么为什么可以完成并发执行呢？我们再来讲一讲原理。
多线程执行时，到底在内存中是如何运行的呢？以上个程序为例，进行图解说明：
多线程执行时，在栈内存中，其实**每一个执行线程都有一片自己所属的栈内存空间**。进行方法的压栈和弹栈。 

 ![](.\imgs\thread4.png)

### 23.4 Thread和Runnable

**Thread构造方法：**

public Thread() :分配一个新的线程对象。
public Thread(String name) :分配一个指定名字的新的线程对象。
public Thread(Runnable target) :分配一个带有指定目标新的线程对象。
public Thread(Runnable target,String name) :分配一个带有指定目标新的线程对象并指定名字。 

**Thread常用方法：**

public String getName() :获取当前线程名称。
public void start() :导致此线程开始执行; Java虚拟机调用此线程的run方法。
public void run() :此线程要执行的任务在此处定义代码。
public static void sleep(long millis) :使当前正在执行的线程以指定的毫秒数暂停（暂时停止执行）。
public static Thread currentThread() :返回对当前正在执行的线程对象的引用。 

**Runnable使用方式**

采用 java.lang.Runnable 也是非常常见的一种，我们只需要重写run方法即可。
步骤如下：

1. 定义Runnable接口的实现类，并重写该接口的run()方法，该run()方法的方法体同样是该线程的线程执行体。
2. 创建Runnable实现类的实例，并以此实例作为Thread的target来创建Thread对象，该Thread对象才是真正
    的线程对象。
3. 调用线程对象的start()方法来启动线程。 

**Thread和Runnable的区别**
如果一个类继承Thread，则不适合资源共享。但是如果实现了Runable接口的话，则很容易的实现资源共享。
总结：
实现Runnable接口比继承Thread类所具有的优势：

1. 适合多个相同的程序代码的线程去共享同一个资源。
2. 可以避免java中的单继承的局限性。
3. 增加程序的健壮性，实现解耦操作，代码可以被多个线程共享，代码和线程独立。
4. 线程池只能放入实现Runable或Callable类线程，不能直接放入继承Thread的类。
    扩充：在java中，每次程序运行至少启动2个线程。一个是main线程，一个是垃圾收集线程。因为每当使用
    java命令执行一个类的时候，实际上都会启动一个JVM，每一个JVM其实在就是在操作系统中启动了一个进
    程。 

### 23.5 线程安全

线程安全问题都是由全局变量及静态变量引起的。若每个线程中对全局变量、静态变量只有读操作，而无写
操作，一般来说，这个全局变量是线程安全的；若有多个线程同时执行写操作，一般都需要考虑线程同步，
否则的话就可能影响线程安全。 

为了保证每个线程都能正常执行原子操作,Java引入了线程同步机制。
那么怎么去使用呢？有三种方式完成同步操作： 

1. 同步代码块。
2. 同步方法。
3. 锁机制。 

1. 同步代码块： synchronized 关键字可以用于方法中的某个区块中，表示只对这个区块的资源实行互斥访问。
   格式:

   ```java
   public synchronized void method(){
   可能会产生线程安全问题的代码
   }
   ```

   

   同步锁:
   对象的同步锁只是一个概念,可以想象为在对象上标记了一个锁.

   1. 锁对象 可以是任意类型。
   2. 多个线程对象 要使用同一把锁。
       注意:在任何时候,最多允许一个线程拥有同步锁,谁拿到锁就进入代码块,其他的线程只能在外等着
       (BLOCKED) 

2. 同步方法:使用synchronized修饰的方法,就叫做同步方法,保证A线程执行该方法的时候,其他线程只能在方法外
   等着。
   格式：

   ```java
   public synchronized void method(){
   可能会产生线程安全问题的代码
   }
   ```

   

   同步锁是谁?
   对于非static方法,同步锁就是this。
   对于static方法,我们使用当前方法所在类的字节码对象(类名.class)。

3. java.util.concurrent.locks.Lock 机制提供了比synchronized代码块和synchronized方法更广泛的锁定操作,
   同步代码块/同步方法具有的功能Lock都有,除此之外更强大,更体现面向对象。
   Lock锁也称同步锁，加锁与释放锁方法化了，如下：
   public void lock() :加同步锁。
   public void unlock() :释放同步锁。
   可以与try catch一起使用，在finally中释放锁

### 23.6 线程状态

| 线程状态                 | 导致状态发生条件                                             |
| ------------------------ | ------------------------------------------------------------ |
| NEW(新建)                | 线程刚被创建，但是并未启动。还没调用start方法。              |
| Runnable(可 运行)        | 线程可以在java虚拟机中运行的状态，可能正在运行自己代码，也可能没有，这取决于操 作系统处理器 |
| Blocked(锁阻 塞)         | 当一个线程试图获取一个对象锁，而该对象锁被其他的线程持有，则该线程进入Blocked状 态；当该线程持有锁时，该线程将变成Runnable状态。 |
| Waiting(无限 等待)       | 一个线程在等待另一个线程执行一个（唤醒）动作时，该线程进入Waiting状态。进入这个 状态后是不能自动唤醒的，必须等待另一个线程调用notify或者notifyAll方法才能够唤醒。 |
| Timed Waiting(计时 等待) | 同waiting状态，有几个方法有超时参数，调用他们将进入Timed Waiting状态。这一状态 将一直保持到超时期满或者接收到唤醒通知。带有超时参数的常用方法有Thread.sleep 、 Object.wait。 |
| Teminated(被 终止)       | 因为run方法正常退出而死亡，或者因为没有捕获的异常终止了run方法而死亡。 |

#### 23.6.1 Timed Waiting（计时等待） 

一个正在限时等待另一个线程执行一个（唤醒）动作的线程处于这一状态。

单独的去理解这句话，真是玄之又玄，其实我们在之前的操作中已经接触过这个状态了，在哪里呢？
在我们写卖票的案例中，为了减少线程执行太快，现象不明显等问题，我们在run方法中添加了sleep语句，这样就
强制当前正在执行的线程休眠（**暂停执行**），以“减慢线程”。

#### 23.6.2 Blocked(锁阻 塞)

一个正在阻塞等待一个监视器锁（锁对象）的线程处于这一状态。
我们已经学完同步机制，那么这个状态是非常好理解的了。比如，线程A与线程B代码中使用同一锁，如果线程A获
取到锁，线程A进入到Runnable状态，那么线程B就进入到Blocked锁阻塞状态。
这是由Runnable状态进入Blocked状态。除此Waiting以及Time Waiting状态也会在某种情况下进入阻塞状态 

#### 23.6.3 Waiting(无限 等待)

一个正在无限期等待另一个线程执行一个特别的（唤醒）动作的线程处于这一状态。 

一个调用了某个对象的 Object.wait 方法的线程会等待另一个线程调用此对象的
Object.notify()方法 或 Object.notifyAll()方法。
其实waiting状态并不是一个线程的操作，它体现的是多个线程间的通信，可以理解为多个线程之间的协作关系，
多个线程会争取锁，同时相互之间又存在协作关系。就好比在公司里你和你的同事们，你们可能存在晋升时的竞
争，但更多时候你们更多是一起合作以完成某些任务。
当多个线程协作时，比如A，B线程，如果A线程在Runnable（可运行）状态中调用了wait()方法那么A线程就进入
了Waiting（无限等待）状态，同时失去了同步锁。假如这个时候B线程获取到了同步锁，在运行状态中调用了
notify()方法，那么就会将无限等待的A线程唤醒。注意是唤醒，如果获取到锁对象，那么A线程唤醒后就进入
Runnable（可运行）状态；如果没有获取锁对象，那么就进入到Blocked（锁阻塞状态） 一个调用了某个对象的 Object.wait 方法的线程会等待另一个线程调用此对象的
Object.notify()方法 或 Object.notifyAll()方法。
其实waiting状态并不是一个线程的操作，它体现的是多个线程间的通信，可以理解为多个线程之间的协作关系，
多个线程会争取锁，同时相互之间又存在协作关系。就好比在公司里你和你的同事们，你们可能存在晋升时的竞
争，但更多时候你们更多是一起合作以完成某些任务。
当多个线程协作时，比如A，B线程，如果A线程在Runnable（可运行）状态中调用了wait()方法那么A线程就进入
了Waiting（无限等待）状态，同时失去了同步锁。假如这个时候B线程获取到了同步锁，在运行状态中调用了
notify()方法，那么就会将无限等待的A线程唤醒。注意是唤醒，如果获取到锁对象，那么A线程唤醒后就进入
Runnable（可运行）状态；如果没有获取锁对象，那么就进入到Blocked（锁阻塞状态） 

## 24 线程池	

- **线程池：**其实就是一个容纳多个线程的容器，其中的线程可以反复使用，省去了频繁创建线程对象的操作，无需反复创建线程而消耗过多资源。

- 合理利用线程池能够带来三个好处：

  1. 降低资源消耗。减少了创建和销毁线程的次数，每个工作线程都可以被重复利用，可执行多个任务。
  2. 提高响应速度。当任务到达时，任务可以不需要的等到线程创建就能立即执行。
  3. 提高线程的可管理性。可以根据系统的承受能力，调整线程池中工作线线程的数目，防止因为消耗过多的内存，而把服务器累趴下(每个线程需要大约1MB内存，线程开的越多，消耗的内存也就越大，最后死机)。

- 线程池的使用

  Java里面线程池的顶级接口是`java.util.concurrent.Executor`，但是严格意义上讲`Executor`并不是一个线程池，而只是一个执行线程的工具。真正的线程池接口是`java.util.concurrent.ExecutorService`。

  要配置一个线程池是比较复杂的，尤其是对于线程池的原理不是很清楚的情况下，很有可能配置的线程池不是较优的，因此在`java.util.concurrent.Executors`线程工厂类里面提供了一些静态工厂，生成一些常用的线程池。官方建议使用Executors工程类来创建线程池对象。

  Executors类中有个创建线程池的方法如下：

  - `public static ExecutorService newFixedThreadPool(int nThreads)`：返回线程池对象。(创建的是有界线程池,也就是池中的线程个数可以指定最大数量)

  获取到了一个线程池ExecutorService 对象，那么怎么使用呢，在这里定义了一个使用线程池对象的方法如下：

  - `public Future<?> submit(Runnable task)`:获取线程池中的某一个线程对象，并执行

    > Future接口：用来记录线程任务执行完毕后产生的结果。线程池创建与使用。

  使用线程池中线程对象的步骤：

  1. 创建线程池对象。
  2. 创建Runnable接口子类对象。(task)
  3. 提交Runnable接口子类对象。(take task)
  4. 关闭线程池(一般不做)。

  线程池demo：

  ```java
  public class ThreadPoolDemo {
      public static void main(String[] args) {
          // 创建线程池对象
          ExecutorService service = Executors.newFixedThreadPool(2);//包含2个线程对象
          // 创建Runnable实例对象
          MyRunnable r = new MyRunnable();
  
          //自己创建线程对象的方式
          // Thread t = new Thread(r);
          // t.start(); ---> 调用MyRunnable中的run()
  
          // 从线程池中获取线程对象,然后调用MyRunnable中的run()
          service.submit(r);
          // 再获取个线程对象，调用MyRunnable中的run()
          service.submit(r);
          service.submit(r);
          // 注意：submit方法调用结束后，程序并不终止，是因为线程池控制了线程的关闭。
          // 将使用完的线程又归还到了线程池中
          // 关闭线程池
          //service.shutdown();
      }
  }
  ```

  ## 25 Lambda表达式

  Lambda表达式的**标准格式**为：

  ```
  (参数类型 参数名称) -> { 代码语句 }
  ```

  **格式说明：**

  - 小括号内的语法与传统方法参数列表一致：无参数则留空；多个参数则用逗号分隔。
  - `->`是新引入的语法格式，代表指向动作。
  - 大括号内的语法与传统方法体要求基本一致。

  ### 省略规则

  在Lambda标准格式的基础上，使用省略写法的规则为：

  1. 小括号内参数的类型可以省略；
  2. 如果小括号内**有且仅有一个参**，则小括号可以省略；
  3. 如果大括号内**有且仅有一个语句**，则无论是否有返回值，都可以省略大括号、return关键字及语句分号。

  

  

  Lambda的语法非常简洁，完全没有面向对象复杂的束缚。但是使用时有几个问题需要特别注意：

  1. 使用Lambda必须具有接口，且要求**接口中有且仅有一个抽象方法**。
     无论是JDK内置的`Runnable`、`Comparator`接口还是自定义的接口，只有当接口中的抽象方法存在且唯一时，才可以使用Lambda。
  2. 使用Lambda必须具有**上下文推断**。
     也就是方法的参数或局部变量类型必须为Lambda对应的接口类型，才能使用Lambda作为该接口的实例。

  > 备注：有且仅有一个抽象方法的接口，称为“**函数式接口**”。

  

  