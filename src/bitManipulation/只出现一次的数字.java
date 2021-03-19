package bitManipulation;

public class 只出现一次的数字 {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int a : nums){
            res = res ^ a;
        }
        return res;
    }
}
