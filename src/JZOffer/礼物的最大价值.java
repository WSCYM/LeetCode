package JZOffer;

import java.util.Arrays;

public class 礼物的最大价值 {
    public int maxValue(int[][] grid) {
        //dp[i,j] = max(dp[i-1][j],dp[i][j-1])+grid[i][j]
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i = 1;i<grid[0].length;i++){
            dp[0][i] = dp[0][i-1]+grid[0][i];
        }
        for (int i = 1;i<grid.length;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for (int i = 1;i<grid.length;i++){
            for (int j = 1;j<grid[0].length;j++){
                dp[i][j] = (dp[i-1][j]>dp[i][j-1]?dp[i-1][j]:dp[i][j-1])+grid[i][j];
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }

    public static void main(String[] args) {
        new 礼物的最大价值().maxValue(
                new int[][]{{1,3,1},{1,5,1},{4,2,1}}
        );
    }
}
