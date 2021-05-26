package leetcode.editor.cn;
//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3371 👎 0



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution8 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();
        if (nums.length<3) return ret;
        for (int k = 0;k<nums.length-2;k++){
            if (nums[k]>0) return ret;
            if (k>0 && nums[k]==nums[k-1]) continue;
            int l = k+1;
            int r = nums.length-1;
            while (l<r){
                int sum = nums[k]+nums[l]+nums[r];
                if (sum>0){
                    while (l<r && nums[r]==nums[--r]);
                } else if (sum<0){
                    while (l<r && nums[l]==nums[++l]);
                } else {
                    ret.add(Arrays.asList(nums[k],nums[l],nums[r]));
                    while (l<r && nums[r]==nums[--r]);
                    while (l<r && nums[l]==nums[++l]);
                }
            }
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
