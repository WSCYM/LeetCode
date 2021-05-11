package JZOffer;

public class 数值的整数次方 {
    public double myPow(double x, int n) {
        return myPowLn(x,n);
    }

    private double myPowLn(double x,long n){
        if (n==0) return 1;
        boolean lessThanZero = false;
        if (n<0){
            lessThanZero = true;
            n = -n;
        }
        double ret = 0;
        if(n==1){
            ret = x;
        }
        double tmp = myPowLn(x,n/2);
        if ((n&1)==0){
            ret = tmp*tmp;
        } else {
            ret = tmp*tmp*x;
        }
        if (lessThanZero) {
            ret = 1/ret;
        }
        return ret;
    }
}
