package JZOffer;

public class 剪绳子2 {
    public int cuttingRope(int n) {
        if (n<4) return n-1;
        int y = n%3;
        int t = n/3;
        long ret = 1;
        if (y==0){
            for (int i=0;i<t;i++){
                ret = ret*3 % 1000000007;
            }
        } else if (y==1){
            for (int i=0;i<t-1;i++){
                ret = ret*3 % 1000000007;
            }
            ret=ret*2 % 1000000007;
            ret=ret*2 % 1000000007;
        } else if (y==2){
            for (int i=0;i<t;i++){
                ret = ret*3 % 1000000007;
            }
            ret=ret*2 % 1000000007;
        }
        return (int) ret;
    }

    public static void main(String[] args) {
        System.out.println(new 剪绳子2().cuttingRope(120));
    }
}
