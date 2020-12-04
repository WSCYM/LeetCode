package dp;

public class 两个字符串的删除操作 {
    public int minDistance(String word1, String word2) {
        if (word1.length()==0 || word2.length()==0){
            return Math.max(word1.length(),word2.length());
        }
        //dp[i][j]:使word1[0...i]与word2[0...j]相同的最小操作数
        //if word1[i]==word2[j] dp[i][j]=dp[i-1][j-1]
        //else dp[i][j] = max(dp[i-1][j],dp[i][j-1])
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        int[][] dp = new int[c1.length+1][c2.length+1];
        for (int i = 0;i<dp.length;i++){
            dp[i][0] = i;
        }
        for (int j = 0;j<dp[0].length;j++){
            dp[0][j] = j;
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                if (c1[i-1]==c2[j-1]) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    int getCnt(char c,char[] chars){
        int res = 0;
        for (char cc : chars){
            if (cc==c){
                res++;
            }
        }
        return res;
    }
}
