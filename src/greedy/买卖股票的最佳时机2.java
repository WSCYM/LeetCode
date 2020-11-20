package greedy;

public class 买卖股票的最佳时机2 {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i=1;i<prices.length;i++){
            if (prices[i]>prices[i-1]){
                res+=(prices[i]-prices[i-1]);
            }
        }
        return res;
    }
}
