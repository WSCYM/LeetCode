package array;

import java.util.ArrayList;
import java.util.List;

public class 找到所有数组中消失的数字 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int num  : nums){
            if (num>0){
                if (nums[num-1]>0){
                    nums[num-1]*=-1;
                }
            } else {
                if (nums[-num-1]>0){
                    nums[-num-1]*=-1;
                }
            }
        }
        List<Integer> ret = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if (nums[i]>0){
                ret.add(i+1);
            }
        }
        return ret;
    }
}
