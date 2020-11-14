package array;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 存在连续三个奇数的数组
 * @Description TODO
 * @createTime 2020-11-14 19:36:00
 */
public class 存在连续三个奇数的数组 {
    public boolean threeConsecutiveOdds(int[] arr) {
        int count = 0;
        for (int i : arr){
            if (i%2!=0){
                count++;
                if (count==3){
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }
}
