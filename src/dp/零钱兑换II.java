package dp;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 零钱兑换II
 * @Description TODO
 * @createTime 2020-12-06 20:32:00
 */
public class 零钱兑换II {
    public int change(int amount, int[] coins) {
        //dp[i][j]:用前i种硬币凑出金额j的方法数
        //dp[i][j] = dp[i-1][j]+dp[i][j-nums[i]]
        //base case:dp[i][0] = 1;
        //          dp[0][j] = 0
        int[][] dp = new int[coins.length+1][amount+1];
        for (int i = 0;i<dp.length;i++){
            dp[i][0] = 1;
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                if (j<coins[i-1]){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j]+dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
