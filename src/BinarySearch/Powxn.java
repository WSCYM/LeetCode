package BinarySearch;

public class Powxn {
    double quickMul(double x, long N) {
        double res = 1.0;
        double x_base = x;
        while (N>0){
            if ((N&1)==1){
                res *= x_base;
            }
            x_base *= x_base;
            N >>= 1;
        }
         return res;
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static void main(String[] args) {
        new Powxn().myPow(2.00000,10);
    }
}
