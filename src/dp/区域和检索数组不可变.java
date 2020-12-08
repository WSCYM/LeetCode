package dp;

public class 区域和检索数组不可变 {
    public static void main(String[] args) {
        new NumArray(new int[]{-2,0,3,-5,2,1}).sumRange(2,5);
    }
}
class NumArray {
    int[] dp;
    //dp[i] = dp[i-1]+nums[i-1]
    public NumArray(int[] nums) {
        dp = new int[nums.length+1];
        dp[0] = 0;
        for (int i = 1;i<dp.length;i++){
            dp[i] = dp[i-1]+nums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return dp[j+1]-dp[i];
    }
}
