package dp;

import java.util.List;

public class 解码方法 {
    public boolean wordBreak(String s, List<String> wordDict) {
        //dp[i] = dp[j] && check(j,i);表示 s 中以 i - 1 结尾的字符串是否可被 wordDict 拆分
        char[] chars = s.toCharArray();
        boolean[] dp = new boolean[chars.length+1];
        dp[0] = true;
        for (int i = 1;i<=chars.length;i++){
            dp[i] = false;
            for (int j =0;j<=i;j++){
                if (dp[j]==true && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                }
            }
        }
        return dp[chars.length];
    }
}
