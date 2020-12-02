package dp;

public class 矩阵 {
    public int[][] updateMatrix(int[][] matrix) {
        //dp[i][j] = matrix[i][j]==0?0:math.min(dp[i-1][j],dp[i][j-1])+1;
        //dp[i][j] = matrix[i][j]==0?0:math.min(dp[i][j],math.min(dp[i+1][j],dp[i][j+1])+1);
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (i==0 && j==0){
                    dp[i][j] = matrix[i][j]==0?0:10000;
                } else if (i==0 && j!=0) {
                    dp[i][j] = matrix[i][j]==0?0:dp[i][j-1]+1;
                } else if (i!=0 && j==0){
                    dp[i][j] = matrix[i][j]==0?0:dp[i-1][j]+1;
                } else {
                    dp[i][j] = matrix[i][j]==0?0:Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        for (int i = matrix.length-1;i>=0;i--){
            for (int j=matrix[0].length-1;j>=0;j--){
                if (i==matrix.length-1 && j==matrix[0].length-1){
                    if (matrix[i][j]==0) dp[i][j] = 0;
                } else if (i==matrix.length-1 && j!=matrix[0].length-1) {
                    dp[i][j] = Math.min(dp[i][j],dp[i][j+1]+1);
                } else if (i!=matrix.length-1 && j==matrix[0].length-1){
                    dp[i][j] = Math.min(dp[i][j],dp[i+1][j]+1);
                } else {
                    dp[i][j] = Math.min(dp[i][j+1]+1,Math.min(dp[i][j],dp[i+1][j]+1));
                }
            }
        }
        return dp;
    }
}
