package JZOffer;

public class 正则表达式匹配 {
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] ps = p.toCharArray();
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for (int j = 2;j<dp[0].length;j+=2){
            if (dp[0][j-2] && ps[j-1]=='*') {
                dp[0][j] = true;
            }
        }
        for (int i = 1;i<dp.length;i++){
            for (int j = 1;j<dp[0].length;j++){
                if (ps[j-1]=='*'){
                    if (dp[i][j-2]
                            ||(dp[i-1][j]&&ss[i-1]==ps[j-2])
                            ||(dp[i - 1][j] && ps[j - 2] == '.')){
                        dp[i][j] = true;
                    }
                } else {
                    if ((dp[i - 1][j - 1] && ss[i - 1] == ps[j - 1])
                            ||dp[i - 1][j - 1] && ps[j - 1] == '.'){
                        dp[i][j] = true;
                    }
                }
            }
        }
        return dp[dp.length-1][dp[0].length-1];
    }

    public static void main(String[] args) {
        new 正则表达式匹配().isMatch("aa","a*");
    }
}
