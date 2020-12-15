package backtrack;

import java.util.Arrays;
import java.util.Stack;

public class 组合总和Ⅳ {
    int res = 0;
    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        Stack<Integer> path = new Stack<>();
        backtracking(nums,target,0,path);
        return res;
    }
    void backtracking(int[] nums, int target , int sum, Stack<Integer> path){
        if (sum==target){
            res+=1;
            return;
        }
        if (sum>target){
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if (sum+nums[i]>target) break;
            path.push(nums[i]);
            backtracking(nums,target,sum+nums[i],path);
            path.pop();
        }
    }
}
