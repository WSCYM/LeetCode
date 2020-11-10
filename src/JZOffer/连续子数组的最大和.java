package JZOffer;

public class 连续子数组的最大和 {
    public int maxSubArray(int[] nums) {
            //dp[i] = max(dp[i-1]+nums[i],nums[i])
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            if (res<dp[i]){
                res = dp[i];
            }
        }
        return res;
    }
}
