package dp;

public class 跳跃游戏 {
    public boolean canJump(int[] nums) {
        //dp[i] : 是否可以跳到此位置
        int idx = 0;
        for (int i = 0;i<nums.length;i++){
            idx = idx>=i && i+nums[i]>idx?i+nums[i]:idx;
        }
        if (idx>=nums.length-1) return true;
        return false;
    }
}
