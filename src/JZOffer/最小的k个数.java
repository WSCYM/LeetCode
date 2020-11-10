package explore.JZOffer;

import java.util.Arrays;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 最小的k个数
 * @Description TODO
 * @createTime 2020-11-07 22:42:00
 */
public class 最小的k个数 {
    public int[] getLeastNumbers(int[] arr, int k) {
        Arrays.sort(arr);
        return Arrays.copyOf(arr,k);
    }
}
