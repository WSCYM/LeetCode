package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ym
 * @version 1.0.0
 * @ClassName 汇总区间
 * @Description TODO
 * @createTime 2020-11-14 21:18:00
 */
public class 汇总区间 {
    public List<String> summaryRanges(int[] nums) {
        if (nums.length==0){
            return new ArrayList<>();
        }
        ArrayList<String> as = new ArrayList<>();
        if (nums.length==1){
            as.add(String.valueOf(nums[0]));
            return as;
        }
        int left = 0;
        int right = 0;
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1]+1){
                right = i;
            } else {
                if (left!=right){
                    as.add(String.valueOf(nums[left])+"->"+String.valueOf(nums[right]));
                } else {
                    as.add(String.valueOf(nums[left]));
                }
                left = i;
                right = i;
            }
            if (i==nums.length-1){
                if (left!=right){
                    as.add(String.valueOf(nums[left])+"->"+String.valueOf(nums[right]));
                } else {
                    as.add(String.valueOf(nums[left]));
                }
            }
        }
        return as;
    }
}
