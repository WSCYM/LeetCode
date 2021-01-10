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
//    public List<String> summaryRanges(int[] nums) {
//        if (nums.length==0){
//            return new ArrayList<>();
//        }
//        ArrayList<String> as = new ArrayList<>();
//        if (nums.length==1){
//            as.add(String.valueOf(nums[0]));
//            return as;
//        }
//        int left = 0;
//        int right = 0;
//        for (int i=1;i<nums.length;i++){
//            if (nums[i]==nums[i-1]+1){
//                right = i;
//            } else {
//                if (left!=right){
//                    as.add(String.valueOf(nums[left])+"->"+String.valueOf(nums[right]));
//                } else {
//                    as.add(String.valueOf(nums[left]));
//                }
//                left = i;
//                right = i;
//            }
//            if (i==nums.length-1){
//                if (left!=right){
//                    as.add(String.valueOf(nums[left])+"->"+String.valueOf(nums[right]));
//                } else {
//                    as.add(String.valueOf(nums[left]));
//                }
//            }
//        }
//        return as;
//    }
    List<String> res = new ArrayList<>();
    public List<String> summaryRanges(int[] nums) {
        if (nums.length==0) return res;
        int l = 0;int r = 0;
        while (r<nums.length-1){
            if (nums[r + 1] != nums[r] + 1) {
                if (l == r) {
                    res.add(new String(String.valueOf(nums[l])));
                } else {
                    res.add(new String(nums[l] + "->" + nums[r]));
                }
                l = r + 1;
            }
            r++;
        }
        if (l==r){
            res.add(new String(String.valueOf(nums[l])));
        } else {
            res.add(new String(nums[l] + "->" + nums[r]));
        }
        return res;
    }
}
