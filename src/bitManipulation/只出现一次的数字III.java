package bitManipulation;

public class 只出现一次的数字III {
    public int[] singleNumber(int[] nums) {
        int k = 0;
        for (int n : nums){
            k ^= n;
        }
        int bitMask = k&-k;
        int[] ret = new int[]{0,0};
        for (int n : nums){
            if ((n&bitMask)==0){
                ret[0] ^= n;
            } else {
                ret[1] ^= n;
            }
        }
        return ret;
    }
}
