package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 组合 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> track = new LinkedList<>();
        trackback(1,n,k,track);
        return res;
    }

    void trackback(int start, int n, int k, LinkedList<Integer> track){
        if (track.size()==k){
            res.add(new LinkedList(track));
            return;
        }
        for (int i = start;i<=n;i++){
            track.add(i);
            trackback(i+1,n,k,track);
            track.removeLast();
        }
    }
}
