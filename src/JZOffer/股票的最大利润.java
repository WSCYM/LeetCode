package JZOffer;

public class 股票的最大利润 {
    public int maxProfit(int[] prices) {
        if (prices.length<=1){
            return 0;
        }
        int min = prices[0];
        int res = 0;
        for (int i = 1;i<prices.length;i++){
            if ((prices[i]-min)>res){
                res = prices[i]-min;
            }
            if (prices[i]<min){
                min = prices[i];
            }
        }
        return res;
    }
}
