package leetcode.editor.cn;
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 809 👎 0


import java.util.HashMap;
import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution128 {
//    public int longestConsecutive(int[] nums) {
//        HashSet<Integer> hashSet = new HashSet<>();
//        for (int num : nums){
//            hashSet.add(num);
//        }
//        int ret = 0;
//        for (int num : nums){
//            if (!hashSet.contains(num-1)){
//                int k = num;
//                int curCount = 0;
//                while (hashSet.contains(k)){
//                    curCount++;
//                    if (curCount>ret){
//                        ret=curCount;
//                    }
//                    k++;
//                }
//            }
//        }
//        return ret;
//    }

    public int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;
        UnionFind unionFind = new UnionFind(nums);
        for (int num : nums){
            unionFind.union(num,num+1);
        }
        int ret = 0;
        for (int num : nums){
            ret = Math.max(unionFind.find(num)-num+1,ret);
        }
        return ret;
    }

    class UnionFind {
        public HashMap<Integer, Integer> parents;

        public UnionFind(int[] arr) {
            parents = new HashMap<>();
            for (int num : arr) {
                parents.put(num, num);
            }
        }

        public Integer find(int x) {
            if (!parents.containsKey(x)) return null;
            int t = parents.get(x);
            if (x != t) {
                parents.put(x, find(t));
            }
            return parents.get(x);
        }

        public boolean union(int x, int y) {
            Integer rootX = find(x);
            Integer rootY = find(y);
            if (rootX == null || rootY == null) return false;
            if (rootX.equals(rootY)) return false;
            parents.put(rootX, rootY);
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
