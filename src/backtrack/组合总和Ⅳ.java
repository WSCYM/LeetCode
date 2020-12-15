package backtrack;

import java.util.Arrays;
import java.util.Stack;

public class 组合总和Ⅳ {
//    int res = 0;
//    public int combinationSum4(int[] nums, int target) {
//        Arrays.sort(nums);
//        Stack<Integer> path = new Stack<>();
//        backtracking(nums,target,0,path);
//        return res;
//    }
//    void backtracking(int[] nums, int target , int sum, Stack<Integer> path){
//        if (sum==target){
//            res+=1;
//            return;
//        }
//        if (sum>target){
//            return;
//        }
//        for (int i = 0;i<nums.length;i++){
//            if (sum+nums[i]>target) break;
//            path.push(nums[i]);
//            backtracking(nums,target,sum+nums[i],path);
//            path.pop();
//        }
//    }
    public int combinationSum4(int[] nums, int target) {
        //dp[i]:和为i的组合数
        //dp[i] = sum(dp[i-nums[k]])
        int[] dp = new int[target+1];
        dp[0] = 1;
        for (int i = 1;i<=target;i++){
            for (int num : nums){
                if (i>=num){
                    dp[i]+=dp[i-num];
                }
            }
        }
        return dp[target];
    }
}
