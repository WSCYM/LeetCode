package dp;

public class 连续数列 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length==0) {
            return 0;
        }
        if (nums.length==1){
            return nums[0];
        }
        int res = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1;i<nums.length;i++){
            dp[i] = dp[i-1]>0?dp[i-1]+nums[i]:nums[i];
            if (dp[i]>res) res = dp[i];
        }
        return res;
    }
}
