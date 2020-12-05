package dp;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 两个字符串的最小ASCII删除和
 * @Description TODO
 * @createTime 2020-12-05 17:47:00
 */
public class 两个字符串的最小ASCII删除和 {
    public int minimumDeleteSum(String s1, String s2) {
        //dp[i][j]:s1[0...i]与s2[0...j]所需最小删除和
        //if s1[i]==s2[j] dp[i][j]=dp[i-1][j-1]
        //else dp[i][j]=min(dp[i-1][j],dp[i][j-1])
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int[][] dp = new int[chars1.length+1][chars2.length+1];
        dp[0][0] = 0;
        for (int i =1;i<dp.length;i++){
            dp[i][0] = chars1[i-1]+dp[i-1][0];
        }
        for (int i =1;i<dp[0].length;i++){
            dp[0][i] = chars2[i-1]+dp[0][i-1];
        }
        for (int i=1;i<dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                if (chars1[i-1]==chars2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] =Math.min(dp[i-1][j]+chars1[i-1],dp[i][j-1]+chars2[j-1]);
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
