package dp;

public class 编辑距离 {
//    public int minDistance(String word1, String word2) {
//        if (word1.length()==0){
//            return word2.length();
//        }
//        if (word2.length()==0){
//            return word1.length();
//        }
//        char[] s1 = word1.toCharArray();
//        char[] s2 = word2.toCharArray();
//        int[][] dp = new int[s1.length+1][s2.length+1];
//        for (int i = 0;i<dp.length;i++){
//            dp[i][0] = i;
//        }
//        for (int i = 0;i<dp[0].length;i++){
//            dp[0][i] = i;
//        }
//        for (int i = 1;i<dp.length;i++){
//            for (int j = 1;j<dp[0].length;j++){
//                if (s1[i-1]==s2[j-1]){
//                    dp[i][j] = dp[i-1][j-1];
//                } else {
//                    dp[i][j] = Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
//                }
//            }
//        }
//        return dp[dp.length-1][dp[0].length-1];
//    }
//    空间压缩
    public int minDistance(String word1, String word2) {
        if (word1.length()==0){
            return word2.length();
        }
        if (word2.length()==0){
            return word1.length();
        }
        char[] s1 = word1.toCharArray();
        char[] s2 = word2.toCharArray();
        int[] dp = new int[s2.length+1];
        for (int i = 1; i < s2.length+1; i++) {
            dp[i] = i;
        }
        for (int i = 1;i<s1.length+1;i++){
            int last = dp[0];
            dp[0] = i;
            for (int j = 1;j<s2.length+1;j++){
                int tmp = dp[j];
                if (s1[i-1]==s2[j-1]){
                    dp[j] = last;
                } else {
                    dp[j] = Math.min(Math.min(dp[j],dp[j-1]),last)+1;
                }
                last = tmp;
            }
        }
        return dp[dp.length-1];
    }
    public static void main(String[] args) {
        System.out.println(new 编辑距离().minDistance("horse","ros"));
    }
}
