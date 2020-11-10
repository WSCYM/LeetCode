package dp;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 按摩师
 * @Description TODO
 * @createTime 2020-11-10 21:48:00
 */
public class 按摩师 {
    public int massage(int[] nums) {
        //f[i] = max(f[i-2]+nums[i],f[i-1])
        int[] dp = new int[nums.length];
        if (nums.length==0) return 0;
        if (nums.length==1) return nums[0];
        if (nums.length==2) return nums[0]>nums[1]?nums[0]:nums[1];
        dp[0] = nums[0];
        dp[1] = nums[0]>nums[1]?nums[0]:nums[1];
        int res = dp[1];
        for (int i = 2;i<nums.length;i++){
            dp[i] = dp[i-2] + nums[i]>dp[i-1]?dp[i-2] + nums[i]:dp[i-1];
            if (dp[i]>res){
                res = dp[i];
            }
        }
        return res;
    }
}
