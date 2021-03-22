package bitManipulation;

public class 比特位计数 {
    public int[] countBits(int num) {
        int[] dp = new int[num+1];
        dp[0] = 0;
        for (int i = 1;i<dp.length;i++){
            dp[i] = dp[i&i-1]+1;
        }
        return dp;
    }
}
