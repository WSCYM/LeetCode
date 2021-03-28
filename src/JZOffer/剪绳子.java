package JZOffer;

public class 剪绳子 {
    public int cuttingRope(int n) {
        if (n<=3) return n-1;
        if ((n % 3)==0) return (int) Math.pow(3,n/3);
        if ((n % 3)==1) return (int) Math.pow(3,n/3-1)*4;
        if ((n % 3)==2) return (int) Math.pow(3,n/3)*2;
        return -1;
    }
}
