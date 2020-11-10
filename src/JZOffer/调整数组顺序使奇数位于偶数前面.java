package JZOffer;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 调整数组顺序使奇数位于偶数前面
 * @Description TODO
 * @createTime 2020-11-07 19:31:00
 */
public class 调整数组顺序使奇数位于偶数前面 {
    public int[] exchange(int[] nums) {
        int i=0,j=nums.length-1,tmp;
        while (i<j){
            while (nums[i]%2!=0 && i<j){
                i++;
            }
            while (nums[j]%2!=1 && i<j){
                j--;
            }
            if (i>=j) break;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        new 调整数组顺序使奇数位于偶数前面().exchange(new int[]{1,3,5});
    }
}
