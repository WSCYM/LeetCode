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

![](E:\javaProject\LeetCode\doc\imgs\zzxc.png)

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



# 二 java guide

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

### 1.7 重载和重写

重载就是同样的一个方法能够根据输入数据的不同，做出不同的处理

重写就是当子类继承自父类的相同方法，输入数据一样，但要做出有别于父类的响应时，你就要覆盖父类方法