package dp;

public class 最长回文子序列 {
    public int longestPalindromeSubseq(String s) {
        if (s.length()==1) return 1;
        //dp[i][j]:以i位置开始，j位置结束的最大回文序列元素个数
        //if s[i] == s[j] dp[i][j] = dp[i+1][j-1]+2
        //else dp[i][j] = max(dp[i][j-1],dp[i+1][j])
        char[] chars = s.toCharArray();
        int[][] dp = new int[chars.length][chars.length];
        for (int i = 0;i<chars.length;i++){
            dp[i][i] = 1;
        }
        for (int i = 1;i<chars.length;i++){
            dp[i-1][i] = 0;
        }
        for (int i = chars.length-2;i>=0;i--){
            for (int j = i+1;j<chars.length;j++){
                if (chars[i]==chars[j]){
                    dp[i][j] = dp[i+1][j-1]+2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1],dp[i+1][j]);
                }
            }
        }
        return dp[0][chars.length-1];
    }

    public static void main(String[] args) {
        new 最长回文子序列().longestPalindromeSubseq("bbbaa");
    }
}
