package bitManipulation;

public class 丢失的数字 {
    public int missingNumber(int[] nums) {
        int res = 0;
        for (int i = 0;i<nums.length;i++){
            res ^= nums[i];
            res ^= i;
        }
        res ^=nums.length;
        return res;
    }
}
