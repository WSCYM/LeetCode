package JZOffer;

import java.util.HashSet;

public class 数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        HashSet set = new HashSet();
        for (Integer i : nums){
            if (set.contains(i)){
                return i;
            }
            set.add(i);
        }
        return -1;
    }
}
