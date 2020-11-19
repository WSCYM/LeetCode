package BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;

public class 两个数组的交集2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        ArrayList<Integer> as = new ArrayList();
        for (int i : nums1){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        for (int i : nums2){
            if (hashMap.containsKey(i) && hashMap.get(i)!=0){
                as.add(i);
                hashMap.put(i,hashMap.get(i)-1);
            }
        }
        return as.stream().mapToInt(Integer::intValue).toArray();
    }
}
