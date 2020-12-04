package dp;

import java.util.Arrays;

public class 俄罗斯套娃信封问题 {
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length==0) return 0;
        //dp[i]:排序后第i个信封最多信封个数
        //dp[i] = max[dp[j]]+1 | 0<=j<i && envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]
        Arrays.sort(envelopes, (o1, o2) -> {
            if (o1[0]>o2[0]){
                return 1;
            } else if (o1[0]<o2[0]){
                return -1;
            } else {
                return o1[1]-o2[1];
            }
        });
        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        for (int i = 1;i<envelopes.length;i++){
            int max = 0;
            for (int j = 0;j<i;j++){
                if (dp[j]>max && envelopes[j][0]<envelopes[i][0] && envelopes[j][1]<envelopes[i][1]){
                    max = dp[j];
                }
            }
            dp[i] = max+1;
        }
        int res = 0;
        for (int i : dp){
            if (i>res) {
                res = i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new 俄罗斯套娃信封问题().maxEnvelopes(new int[][]
                {{10,8},{1,12},{6,15},{2,18}}));
    }
}
