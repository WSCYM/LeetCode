package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 子集 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums,0,track);
        return res;
    }

    void backtrack(int[] nums, int start, LinkedList<Integer> track){
        res.add(new ArrayList<>(track));
        for (int i= start;i<nums.length;i++){
            track.add(nums[i]);
            backtrack(nums,i+1,track);
            track.removeLast();
        }
    }
}
