package dp;

public class 使用最小花费爬楼梯 {
    public int minCostClimbingStairs(int[] cost) {
        //dp[i]:到达阶梯i的最小花费
        //dp[i] = min(dp[i-2],dp[i-1]+cost[i])
        if (cost.length==2) return Math.min(cost[0],cost[1]);
        int[] dp = new int[cost.length];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2;i<dp.length;i++){
            dp[i] = Math.min(dp[i-2],dp[i-1])+cost[i];
        }
        return Math.min(dp[dp.length-1],dp[dp.length-2]);
    }
}
