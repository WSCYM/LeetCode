package dp;

public class 买卖股票的最佳时机 {
    public int maxProfit(int[] prices) {
        if (prices.length<=1) return 0;
        int dp[] = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1;i<dp.length;i++){
            //dp[i] = max(dp[i-1],prices[i]-min)
            if (prices[i]<min) min = prices[i];
            dp[i] = Math.max(dp[i-1],prices[i]-min);
        }
        return dp[prices.length-1];
    }
}
