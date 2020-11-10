package explore.JZOffer;

public class 斐波那契数列 {

    public int fib(int n) {
//        dp[i] = dp[i-1]+dp[i-2];
        int[] dp = new int[n+1];
        if (n==0) {
            return 0;
        }
        if (n==1) {
            return 1;
        }
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2;i<=n;i++){
            dp[i] = (dp[i-1] + dp[i-2])%1000000007;
        }
        return dp[n];
    }

//    用递归超时
//    public int fib(int n) {
//        if (n==0){
//            return 0;
//        }
//        if (n==1){
//            return 1;
//        }
//        return (fib(n-1)+fib(n-2))%1000000007;
//    }
}
