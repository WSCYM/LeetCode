package JZOffer;

import java.util.Arrays;

public class 把数组排成最小的数 {
    public String minNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0;i<nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(s,(o1, o2) -> Double.valueOf(o1+o2)-Double.valueOf(o2+o1)<0?-1:1);
        StringBuffer sb = new StringBuffer();
        for (String string : s){
            sb.append(string);
        }
        return sb.toString();
    }
}
