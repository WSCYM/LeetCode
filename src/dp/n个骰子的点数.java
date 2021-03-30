package dp;

public class n个骰子的点数 {
    public double[] dicesProbability(int n) {
        //思路:用dp储存每个点数会出现的次数，然后分别除以总次数算概率。
        //dp[i][j] 表示用i个骰子掷出点数集合中第j小的数的次数。
        //dp[i][j] = dp[i-1][j-1] +...+ dp[i-1][j-6]
        //base case: dp[1][1]=1 dp[1][2]=1 ...dp[1][6] = 1;

        int[][] dp = new int[n+1][6*n+1];
        for (int j = 1;j<=6;j++){
            dp[1][j] = 1;
        }
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=6*n;j++){
                for (int k = j-1;k>0 && k>=j-6;k--){
                    dp[i][j]+=dp[i-1][k];
                }
            }
        }
        double[] ret = new double[n*6-n+1];
        int sum = 0;
        for (int j = 0;j<dp[0].length;j++){
            sum+=dp[n][j];
        }
        int i = 0;
        for (int j = n;j<dp[0].length;j++){
            ret[i++] = (double) dp[n][j]/sum;
        }
        return ret;
    }

    public static void main(String[] args) {
        new n个骰子的点数().dicesProbability(2);
    }
}
