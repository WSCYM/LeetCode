package dp;

public class 买卖股票的最佳时机含手续费 {
    public int maxProfit(int[] prices, int fee) {
        //规定买入时扣fee
        //dp1[i]:若第i天持有股票，0...i天的最大利润
        //dp2[i]:若第i天不持有股票，0...i天的最大利润
        //dp1[i] = Math.max(dp2[i-1]-fee-prices[i],dp1[i-1])
        //dp2[i] = Math.max(dp1[i-1]+prices[i],dp2[i-1])
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        dp1[0] = 0-prices[0]-fee;
        dp2[0] = 0;
        for (int i = 1;i<dp1.length;i++){
            dp1[i] = Math.max(dp2[i-1]-fee-prices[i],dp1[i-1]);
            dp2[i] = Math.max(dp1[i-1]+prices[i],dp2[i-1]);
        }
        return Math.max(dp1[dp1.length-1],dp2[dp2.length-1]);
    }
}
