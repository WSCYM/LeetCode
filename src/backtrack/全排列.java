package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 全排列 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,track);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track){
        if (nums.length==track.size()){
            res.add(new ArrayList<>(track));
            return;
        }
        for (int i : nums){
            if (track.contains(i)){
                continue;
            }
            track.add(i);
            backtrack(nums,track);
            track.removeLast();
        }
    }
}
