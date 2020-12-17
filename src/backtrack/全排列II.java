package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class 全排列II {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums,new LinkedList<>(),new boolean[nums.length]);
        return res;
    }

    void backtracking(int[] nums, LinkedList<Integer> path,boolean[] used){
        if (path.size()==nums.length){
            res.add(new LinkedList<>(path));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if (i>=1 && nums[i]==nums[i-1] &&!used[i-1]){
                continue;
            }
            if (used[i]){
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            backtracking(nums,path,used);
            path.removeLast();
            used[i] = false;
        }
    }

    public static void main(String[] args) {
        new 全排列II().permuteUnique(new int[]{1,1,2});
    }
}
