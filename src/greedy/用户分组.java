package greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 用户分组 {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer,List<Integer>> hashMap = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0 ;i<groupSizes.length;i++){
            List<Integer> as;
            if (hashMap.containsKey(groupSizes[i])){
                as = hashMap.get(groupSizes[i]);
                as.add(i);
            } else {
                as = new ArrayList<>();
                as.add(i);
                hashMap.put(groupSizes[i],as);
            }
            if (as.size()==groupSizes[i]){
                res.add(as);
                hashMap.put(groupSizes[i],new ArrayList<>());
            }
        }
        return res;
    }
}