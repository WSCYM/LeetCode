package backtrack;

import com.sun.deploy.util.ArrayUtil;

import java.util.*;

public class 组合总和 {
    List<List<Integer>> res = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(0,track,0,candidates,target);
        return res;
    }

    void backtrack(int begin,LinkedList track,int sum, int[] candidates, int target){
        if (sum==target){
            res.add(new LinkedList<>(track));
            return;
        }
        for (int i = begin;i<candidates.length;i++){
            if (sum<=target){
                track.add(candidates[i]);
                backtrack(i,track,sum+candidates[i],candidates,target);
                track.removeLast();
            } else break;
        }
    }

    public static void main(String[] args) {
        new 组合总和().combinationSum(new int[]{2,3,6,7},7);
    }
}
