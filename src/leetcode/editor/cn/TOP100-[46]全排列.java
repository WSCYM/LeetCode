package leetcode.editor.cn;
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 回溯算法 
// 👍 1387 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution46 {
    List<List<Integer>> ret = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtracking(new ArrayList<>(),new boolean[nums.length],nums);
        return ret;
    }

    void backtracking(List<Integer> path,boolean[] visited,int[] nums){
        if (path.size()==nums.length){
            ret.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if (visited[i]){
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            backtracking(path,visited,nums);
            visited[i] = false;
            path.remove(path.size()-1);
        }
    }

}
//leetcode submit region end(Prohibit modification and deletion)
