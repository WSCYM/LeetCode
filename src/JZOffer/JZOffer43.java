package JZOffer;

public class JZOffer43 {
//    public int countDigitOne(int n) {
//        int ret = 0;
//        for (int i =1;i<=n;i++){
//            int tmp = i;
//            while (tmp>0){
//                if (tmp%10==1){
//                    ret++;
//                }
//                tmp/=10;
//            }
//        }
//        return ret;
//    }
    public int countDigitOne(int n) {
        return f(n);
    }
    int f(int n){
        if (n<=0) return 0;
        String s = String.valueOf(n);
        int high = s.charAt(0)-'0';
        int pow = (int) Math.pow(10,s.length()-1);
        int last = n-high*pow;
        if (high==1){
            //1024
            return f(pow-1)+1+last+f(last);
        } else {
            //3024
            //1-999,1000-1999,2000-2999,3000-3024
            return high*f(pow-1)+pow+f(last);
        }
    }
}
