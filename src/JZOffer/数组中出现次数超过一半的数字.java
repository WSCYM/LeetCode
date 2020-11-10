package JZOffer;

import java.util.HashMap;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 数组中出现次数超过一半的数字
 * @Description TODO
 * @createTime 2020-11-07 18:55:00
 */
public class 数组中出现次数超过一半的数字 {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> hashMap = new HashMap();
        for (int i : nums){
            hashMap.put(i,hashMap.getOrDefault(i,0)+1);
            if (hashMap.get(i)>nums.length/2){
                return i;
            }
        }
        return -1;
    }
}
