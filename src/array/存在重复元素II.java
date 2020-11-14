package array;

import java.util.HashMap;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 存在重复元素II
 * @Description TODOu
 * @createTime 2020-11-14 19:46:00
 */
public class 存在重复元素II {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (!hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],i);
            } else {
                if ((i-hashMap.get(nums[i]))<=k){
                    return true;
                } else {
                    hashMap.put(nums[i],i);
                }
            }
        }
        return false;
    }
}
