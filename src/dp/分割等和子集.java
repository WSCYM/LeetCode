package dp;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 分割等和子集
 * @Description TODO
 * @createTime 2020-12-06 14:24:00
 */
public class 分割等和子集 {
    public boolean canPartition(int[] nums) {
        //dp[i][j]:对于前i个物品，若当前背包重量为j，是否可以将背包装满
        //dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j]
        //base case : dp[0][nums[0]] = true
        int sum = 0;
        for (int i : nums){
            sum+=i;
        }
        if (sum % 2 != 0){
            return false;
        }
        boolean[][] dp = new boolean[nums.length][sum/2+1];
        if (nums[0]<=sum/2){
            dp[0][nums[0]] = true;
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                if (j>=nums[i]){
                    dp[i][j] = dp[i-1][j-nums[i]] || dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        new 分割等和子集().canPartition(new int[]{1,1});
    }
}
