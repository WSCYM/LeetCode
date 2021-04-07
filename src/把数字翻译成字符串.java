public class 把数字翻译成字符串 {
    public int translateNum(int num) {
        String string = String.valueOf(num);
        int[] dp = new int[string.length()+1];
        //dp[i] = 以第i个数字结尾的有dp[i]种
        //base case:dp[0] = 0;dp[0]=1 dp[1]=1
        //if  0<=dp[i-1]dp[i]<=25, dp[i] = dp[i-1]+dp[i-2]
        //else dp[i] = dp[i-1]
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1;i<string.length();i++){
            if (Integer.valueOf(string.substring(i-1,i+1))>=0 &&Integer.valueOf(string.substring(i-1,i+1))<=25 && !"0".equals(string.substring(i-1,i))){
                dp[i+1] = dp[i]+dp[i-1];
            } else {
                dp[i+1] = dp[i];
            }
        }
        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        new 把数字翻译成字符串().translateNum(26);
    }
}
