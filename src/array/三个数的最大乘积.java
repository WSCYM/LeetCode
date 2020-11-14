package array;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 三个数的最大乘积
 * @Description TODO
 * @createTime 2020-11-14 12:22:00
 */
public class 三个数的最大乘积 {
    public int maximumProduct(int[] nums) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        for (int n: nums) {
            if (n<=min1){
                min2 = min1;
                min1 = n;
            } else if (n>min1 && n<min2){
                min2 = n;
            }
            if (n>=max3){
                max1 = max2;
                max2 = max3;
                max3 = n;
            } else if (n<max3 && n>=max2){
                max1 = max2;
                max2 = n;
            } else if (n<max2 && n>max1){
                max1 = n;
            }
        }
        return Math.max(min1 * min2 * max3, max1 * max2 * max3);
    }
}
