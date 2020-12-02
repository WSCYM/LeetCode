package dp;

public class 最大正方形 {
    public int maximalSquare(char[][] matrix) {
        //dp[i][j] = min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1])+1
        int[][] dp = new int[matrix.length][matrix[0].length];
        int res = 0;
        for (int i = 0;i<matrix.length;i++){
                dp[i][0] = matrix[i][0]=='0'?0:1;
                if (dp[i][0]>res){
                    res = dp[i][0];
                }
        }
        for (int j = 0;j<matrix[0].length;j++){
            dp[0][j] = matrix[0][j]=='0'?0:1;
            if (dp[0][j]>res){
                res = dp[0][j];
            }
        }
        for (int i = 1;i<matrix.length;i++){
            for (int j = 1;j<matrix[0].length;j++){
                if (matrix[i][j]=='0'){
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    if (dp[i][j]>res){
                        res = dp[i][j];
                    }
                }
            }
        }
        return res*res;
    }
}
