import java.util.HashMap;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName Easy
 * @Description TODO
 * @createTime 2020-06-25 21:01:00
 */
public class TwoNumsSum {

    public int[] twoSum(int[] nums, int target) {
        HashMap hashMap = new HashMap();
        for (int i = 0;i<nums.length;i++){
            if (!hashMap.containsKey(target-nums[i])){
                hashMap.put(nums[i],i);
            } else {
                return new int[]{(int) hashMap.get(target-nums[i]),i};
            }
        }
        return null;
    }
}
