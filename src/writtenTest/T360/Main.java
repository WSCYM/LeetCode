package writtenTest.T360;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] addCost = new int[]{100,200,360,220};
        int[] delCost = new int[]{120,350,200,320};
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        //dp[l][r]:l位置到r位置字符串变成回文的最小花费
        //str[l]==str[r]:dp[l][r] = dp[l+1,r-1]
        //str[l]!=str[r]:dp[l][r] =
        //min:
        // dp[l+1][r]+addCost[str[l]-'0'],
        // dp[l+1][r]+delCost[str[l]-'0'],
        // dp[l][r-1]+addCost[str[r]-'0'],
        // dp[l][r-1]+delCost[str[r]-'0']
        int[][] dp = new int[str.length()][str.length()];

        for (int l = dp.length-1;l>=0;l--){
             for (int r= l+1;r<dp.length;r++){
                 if (str.charAt(l)==str.charAt(r)){
                     dp[l][r]=dp[l+1][r-1];
                 } else {
                     dp[l][r] = Math.min(Math.min(dp[l+1][r]+delCost[str.charAt(l)-'1'],dp[l+1][r]+addCost[str.charAt(l)-'1'])
                             ,Math.min(dp[l][r-1]+addCost[str.charAt(r)-'1'],dp[l][r-1]+delCost[str.charAt(r)-'1']) );
                 }
             }
        }
        System.out.println(dp[0][dp.length-1]);
    }

}
