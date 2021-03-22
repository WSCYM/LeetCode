package bitManipulation;

public class 四的幂342 {
    public boolean isPowerOfFour(int n) {
//        while (n>=4 && n%4==0){
//            n/=4;
//        }
//        return n==1?true:false;

        return (n > 0) && ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
