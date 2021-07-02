package leetcode.editor.cn;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Top100139单词拆分 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hashSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1;i<dp.length;i++){
            for (int j=i-1;j>=0;j--){
                if (dp[j] && hashSet.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length-1];
    }
}
