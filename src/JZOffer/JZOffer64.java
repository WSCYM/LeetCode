package JZOffer;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName JZOffer64
 * @Description TODO
 * @createTime 2020-11-10 20:43:00
 */
public class JZOffer64 {
    public int sumNums(int n) {
        Boolean flag = n>0 && (n+=sumNums(n-1))>0;
        return n;
//        if (n==1){
//            return 1;
//        }
//        return n+sumNums(n-1);
    }
}
