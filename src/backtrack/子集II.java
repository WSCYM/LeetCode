package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 子集II {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,0,new ArrayList<>(),new boolean[nums.length]);
        return res;
    }

    void backtrack(int[] nums,int start,List<Integer> path,boolean[] visit){
        res.add(new ArrayList<>(path));

        for (int i = start;i<nums.length;i++){
            if (i>0 && nums[i]==nums[i-1] && !visit[i-1]) continue;
            path.add(nums[i]);
            visit[i]=true;
            backtrack(nums,i+1,path,visit);
            visit[i] = false;
            path.remove(path.size()-1);
        }
    }
}
