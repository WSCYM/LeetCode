package dp;

public class 统计字典序元音字符串的数目 {
    public int countVowelStrings(int n) {
        //f[i,j] : 第i位以数字（字母）j结尾的组合数
        //f[i,j] = sum(f[i-1,k]), k>=j
        int[][] dp = new int[n][5];
        dp[0][0]=1;dp[0][1]=1;dp[0][2]=1;dp[0][3]=1;dp[0][4]=1;
        for (int i=1;i<n;i++){
            for (int j = 0;j<5;j++){
                int sum = 0;
                for (int k = 0;k<5;k++){
                    if (k>=j){
                        sum+=dp[i-1][k];
                    }
                }
                dp[i][j] = sum;
            }
        }
        return dp[n-1][0]+dp[n-1][1]+dp[n-1][2]+dp[n-1][3]+dp[n-1][4];
    }
}
