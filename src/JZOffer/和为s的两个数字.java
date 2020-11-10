package explore.JZOffer;

import java.util.HashSet;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 和为s的两个数字
 * @Description TODO
 * @createTime 2020-11-07 19:01:00
 */
public class 和为s的两个数字 {
    public int[] twoSum(int[] nums, int target) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums){
            if (!hashSet.contains(i)){
                hashSet.add(target-i);
            } else {
                return new int[]{i,target-i};
            }
        }
        return null;
    }
}
