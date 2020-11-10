package JZOffer;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 最大子序和
 * @Description TODO
 * @createTime 2020-11-10 20:59:00
 */
public class 最大子序和 {
    public int maxSubArray(int[] nums) {
//        f[i] = max(f[i-1]+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = dp[i-1]+nums[i]>nums[i]?dp[i-1]+nums[i]:nums[i];
            if (res < dp[i]) res = dp[i];
        }
        return res;
    }
}
