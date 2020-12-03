package dp;

public class 完全平方数 {
    public int numSquares(int n) {
        //dp[i]=min(dp[i-1],dp[i-4],dp[i-9]……)+1
        int[] dp = new int[n+1];
        for (int i=0;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0;i<=n;i++){
            for (int j = 1;j*j<=i;j++){
                dp[i] = Math.min(dp[i],dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}
