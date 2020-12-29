package sort.basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BucketSort {
    //按频次排序
    public int[] bucketSort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i : nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
        }
        List<Integer>[] bucket = new List[nums.length+1];
        for (int key : hashMap.keySet()){
            if (bucket[hashMap.get(key)]==null) bucket[hashMap.get(key)] = new ArrayList<>();
            bucket[hashMap.get(key)].add(key);
        }
        for (int i =0;i<bucket.length;i++){
            if (bucket[i]==null) continue;
            res.addAll(bucket[i]);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,6,5,2,2,2,8,8,8,8,8,0};
        int[] res = new BucketSort().bucketSort(nums);
        Arrays.stream(res).forEach(System.out::println);
    }
}
