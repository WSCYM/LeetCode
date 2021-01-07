package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> path = new LinkedList<>();
        backtracking(nums,path);
        return res;
    }

    void backtracking(int[] nums,LinkedList<Integer> path){
        if (path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0;i<nums.length;i++){
            if (path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            backtracking(nums,path);
            path.removeLast();
        }
    }
}
