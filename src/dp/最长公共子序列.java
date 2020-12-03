package dp;

public class 最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        //dp[i][j]:text1 以i位置结尾的，text2以j位置结尾的字符串的最长公共子序列的字符数
        //dp[i][j] = if(text[i]==text[j]) dp[i][j]=dp[i-1][j-1]+1;
        //           else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        if (text1.length()<=0 || text2.length()<=0) return 0;
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int[][] dp = new int[t1.length+1][t2.length+1];
        for (int i = 1;i<t1.length+1;i++){
            for (int j = 1;j<t2.length+1;j++){
                if (t1[i-1]==t2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[t1.length][t2.length];
    }
}
