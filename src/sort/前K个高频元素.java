package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class 前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int key : nums){
            hashMap.put(key,hashMap.getOrDefault(key,0)+1);
        }
        List<Integer>[] b = new List[nums.length+1];
        for (int key : hashMap.keySet()){
            if (b[hashMap.get(key)]==null) b[hashMap.get(key)] = new ArrayList<>();
            b[hashMap.get(key)].add(key);
        }
        for (int i = nums.length;i>0 && res.size()<k;i--){
            if (b[i]==null) continue;
            res.addAll(b[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
