package leetcode.editor.cn;
//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3656 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[chars.length][chars.length];
        for (int i = 0;i<dp.length;i++){
            dp[i][i] = true;
        }
        for (int i = 0;i<dp.length-1;i++){
            if (chars[i]==chars[i+1]) {
                dp[i][i+1] = true;
            }
        }
        for (int i = chars.length-2;i>=0;i--){
            for (int j = i+2;j<chars.length;j++){
                if (dp[i+1][j-1] && chars[i]==chars[j]){
                    dp[i][j] = true;
                }
            }
        }
        int maxLen = 0;
        int start = 0;
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<chars.length;j++){
                if (dp[i][j] && (j-i+1)>maxLen){
                    maxLen=j-i+1;
                    start=i;
                }
            }
        }
        return s.substring(start,start+maxLen);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
