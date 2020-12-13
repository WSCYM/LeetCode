package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合总和III {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(1,new LinkedList<>(),k,n,0);
        return res;
    }

    void backtrack(int begin,LinkedList<Integer> track,int k,int n,int sum){
        if (sum>n){
            return;
        }
        if (track.size()==k){
            if (sum==n) res.add(new LinkedList<>(track));
            return;
        }

        for (int j = begin;j<=9;j++){
            if (track.contains(j)){
                continue;
            }
            track.add(j);
            backtrack(j+1,track,k,n,sum+j);
            track.removeLast();
        }
    }
}
