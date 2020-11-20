package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 非递增顺序的最小子序列 {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i : nums){
            sum += i;
        }
        List<Integer> res = new ArrayList<>();
        int resSum = 0;
        for (int i = nums.length-1;i>=0;i--){
            res.add(nums[i]);
            sum-=nums[i];
            resSum+= nums[i];
            if (resSum>sum){
                return res;
            }
        }
        return res;
    }
}
