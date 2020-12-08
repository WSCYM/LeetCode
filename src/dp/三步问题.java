package dp;

public class 三步问题 {
    public int waysToStep(int n) {
        //dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 4;
        int lll = 1,ll=2,l=4;
        for (int i = 4;i<n;i++){
            //坑点:对两个大的数之和要先取余一次，防溢出
            int tmp = (lll+(ll+l)%1000000007)%1000000007;
            lll = ll;
            ll = l;
            l = tmp;
        }
        return (lll+(ll+l)%1000000007)%1000000007;
    }
}
