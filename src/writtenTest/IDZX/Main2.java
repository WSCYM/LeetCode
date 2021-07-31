package writtenTest.IDZX;

public class Main2 {
    public int findMin (int[][] mapArray) {
        if (mapArray.length==0) return 0;
        int[][] dp = new int[mapArray.length][mapArray[0].length];
        dp[0][0] = mapArray[0][0];
        for (int i = 1;i<dp.length;i++){
            dp[i][0] = mapArray[i][0]+dp[i-1][0];
        }
        for (int j = 1;j<dp[0].length;j++){
            dp[0][j] = mapArray[0][j]+dp[0][j-1];
        }
        for (int i =1;i< dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                dp[i][j] = mapArray[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }
}
