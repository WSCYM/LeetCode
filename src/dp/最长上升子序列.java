package dp;

public class 最长上升子序列 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]:以i结尾最长上升子序列元素个数
        //dp[i] = max(nums[i]>=nums[j] -> dp[j]+1)
        if (nums==null) return 0;
        if (nums.length == 1) return 1;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i=1;i<nums.length;i++){
            dp[i] = 1;
            for (int j = 0;j<i;j++){
                if (nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int max = dp[0];
        for (int i : dp){
            if (i>max){
                max = i;
            }
        }
        return max;
    }
}
