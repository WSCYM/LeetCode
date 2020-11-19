package BinarySearch;

import java.util.HashSet;

public class 两个数组的交集 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();
        for (int i : nums1){
            if (!hashSet1.contains(i)){
                hashSet1.add(i);
            }
        }
        for (int i : nums2){
            if (hashSet1.contains(i)){
                hashSet2.add(i);
                hashSet1.remove(i);
            }
        }
        int[] res = new int[hashSet2.size()];
        int idx = 0;
        for (int i : hashSet2){
            res[idx] = i;
            idx++;
        }
        return res;
    }
}
